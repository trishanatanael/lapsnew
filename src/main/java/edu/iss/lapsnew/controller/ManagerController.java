package edu.iss.lapsnew.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.iss.lapsnew.javabeans.Approve;
import edu.iss.lapsnew.model.Leavel;
import edu.iss.lapsnew.model.LeaveEvent;
import edu.iss.lapsnew.model.Employee;
import edu.iss.lapsnew.service.LeaveEventService;
import edu.iss.lapsnew.service.LeaveService;

@Controller
@RequestMapping(value = "/manager")
public class ManagerController {

	@Autowired
	private LeaveService cService;

	@Autowired
	private LeaveEventService ceService;
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		//binder.setValidator(studentValidator);
	}
	
	@RequestMapping(value = "/pending")
	public ModelAndView pendingApprovals(HttpSession session) {
		HashMap<Employee, ArrayList<Leavel>> hm = new HashMap<Employee, ArrayList<Leavel>>();
		UserSession us = (UserSession) session.getAttribute("USERSESSION");
		System.out.println(us.toString());

		ModelAndView mav = new ModelAndView("login");
		if (us.getSessionId() != null) {
			for (Employee employee : us.getSubordinates()) {
				ArrayList<Leavel> clist = cService.findPendingLeavesByEID(employee.getEmployeeId());
				hm.put(employee, clist);
			}
			mav = new ModelAndView("manager-pending-leave-history");
			mav.addObject("pendinghistory", hm);
			return mav;
		}
		return mav;

	}
	
	@RequestMapping(value = "/shistory")
	public ModelAndView subordinatesHistory(HttpSession session) {
		
		UserSession us = (UserSession) session.getAttribute("USERSESSION");
		HashMap<Employee, ArrayList<Leavel>> submap = new HashMap<Employee, ArrayList<Leavel>>();		
		for (Employee subordinate : us.getSubordinates()) {
			submap.put(subordinate, cService.findLeavesByEID(subordinate.getEmployeeId()));
		}
		ModelAndView mav = new ModelAndView("login");
		if (us.getSessionId() != null && us.getSubordinates() != null) {
			mav = new ModelAndView("/subordinates-leave-history");
			mav.addObject("submap", submap);
			return mav;
		}
		return mav;
		

	}

	@RequestMapping(value = "/leave/display/{id}", method = RequestMethod.GET)
	public ModelAndView newDepartmentPage(@PathVariable int id) {
		Leavel leave = cService.findLeave(id);
		ModelAndView mav = new ModelAndView("manager-leave-detail", "leave", leave);
		mav.addObject("approve", new Approve());
		return mav;
	}

	@RequestMapping(value = "/leave/edit/{id}", method = RequestMethod.POST)
	public ModelAndView approveOrRejectLeave(@ModelAttribute("approve") Approve approve, BindingResult result,
			@PathVariable Integer id, HttpSession session, final RedirectAttributes redirectAttributes) {
		if (result.hasErrors())
			return new ModelAndView("manager-leave-detail");
		Leavel c = cService.findLeave(id);
		LeaveEvent ce = new LeaveEvent();
		UserSession us = (UserSession) session.getAttribute("USERSESSION");
		if (approve.getDecision().equalsIgnoreCase(Leavel.APPROVED)) {
			ce.setEventType(Leavel.APPROVED);
			c.setStatus(Leavel.APPROVED);
		} else {
			ce.setEventType(Leavel.REJECTED);
			c.setStatus(Leavel.REJECTED);
		}
		ce.setEventBy(us.getEmployee().getEmployeeId());
		ce.setComment(approve.getComment());
		ce.setTimeStamp(Calendar.getInstance().getTime());
		ce.setLeave(c);
		ArrayList<LeaveEvent> celist = c.getEvents();
		celist.add(ce);
		c.setEvents(celist);
		System.out.println(c.toString());
		cService.changeLeave(c);
		ceService.createLeaveEvent(ce);
		ModelAndView mav = new ModelAndView("redirect:/manager/pending");
		String message = "Leavel was successfully updated.";
		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

}
