package edu.iss.lapsnew.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
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

import edu.iss.lapsnew.exception.LeaveNotFound;
import edu.iss.lapsnew.model.Leavel;
import edu.iss.lapsnew.model.LeaveEvent;
import edu.iss.lapsnew.service.LeaveEventService;
import edu.iss.lapsnew.service.LeaveService;
import edu.iss.lapsnew.validator.LeaveValidator;

@Controller
@RequestMapping(value = "/staff")
public class StaffController {
	@Autowired
	private LeaveService cService;

	@Autowired
	private LeaveValidator cValidator;

	@Autowired
	private LeaveEventService ceService;

	@InitBinder("leavel")
	private void initLeaveBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
		binder.addValidators(cValidator);

	}

	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/home/login";

	}

	/**
	 * LEAVE CRUD OPERATIONS
	 * 
	 * @return
	 */

	@RequestMapping(value = "/history")
	public ModelAndView employeeLeaveHistory(HttpSession session) {
		UserSession us = (UserSession) session.getAttribute("USERSESSION");
		ModelAndView mav = new ModelAndView("login");
		if (us.getSessionId() != null) {
			mav = new ModelAndView("/staff-leave-history");
			mav.addObject("chistory", cService.findLeavesByEID(us.getEmployee().getEmployeeId()));
			return mav;
		}
		return mav;

	}

	@RequestMapping(value = "/leave/create", method = RequestMethod.GET)
	public ModelAndView newLeavePage() {
		ModelAndView mav = new ModelAndView("staff-leave-new");
		mav.addObject("leave", new Leavel());
		return mav;
	}

	@RequestMapping(value = "/leave/create", method = RequestMethod.POST)
	public ModelAndView createNewLeave(@ModelAttribute @Valid Leavel leave, BindingResult result,
			final RedirectAttributes redirectAttributes, HttpSession session) {

		if (result.hasErrors())
			return new ModelAndView("staff-leave-new");

		ModelAndView mav = new ModelAndView();
		String message = "New leave " + leave.getLeaveId() + " was successfully created.";
		UserSession us = (UserSession) session.getAttribute("USERSESSION");
		leave.setEmployeeId(us.getEmployee().getEmployeeId());
		leave.setStatus(Leavel.SUBMITTED);
		mav.setViewName("redirect:/staff/history");
		LeaveEvent ce = new LeaveEvent();
		ce.setLeave(leave);
		ce.setEventBy(us.getEmployee().getEmployeeId());
		ce.setEventType(Leavel.SUBMITTED);
		ce.setTimeStamp(Calendar.getInstance().getTime());
		cService.createLeave(leave);
		ceService.createLeaveEvent(ce);
		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	@RequestMapping(value = "/leave/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editLeavePage(@PathVariable Integer id) {
		ModelAndView mav = new ModelAndView("staff-leave-edit");
		Leavel leave = cService.findLeave(id);
		mav.addObject("leave", leave);
		return mav;
	}

	@RequestMapping(value = "/leave/edit/{id}", method = RequestMethod.POST)
	public ModelAndView editLeave(@ModelAttribute @Valid Leavel leave, BindingResult result, @PathVariable Integer id,
			final RedirectAttributes redirectAttributes, HttpSession session) throws LeaveNotFound {
		if (result.hasErrors())
			return new ModelAndView("staff-leave-edit");
		ModelAndView mav = new ModelAndView();
		System.out.println("DATES****" + leave.getFromDate() + leave.getToDate());
		String message = "New leave " + leave.getLeaveId() + " was successfully created.";
		UserSession us = (UserSession) session.getAttribute("USERSESSION");
		leave.setEmployeeId(us.getEmployee().getEmployeeId());
		leave.setStatus(Leavel.UPDATED);
		mav.setViewName("redirect:/staff/history");
		LeaveEvent ce = new LeaveEvent();
		ce.setLeave(leave);
		ce.setEventBy(us.getEmployee().getEmployeeId());
		ce.setEventType(Leavel.UPDATED);
		ce.setTimeStamp(Calendar.getInstance().getTime());
		cService.changeLeave(leave);
		ceService.createLeaveEvent(ce);
		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	@RequestMapping(value = "/leave/withdraw/{id}", method = RequestMethod.GET)
	public ModelAndView deleteLeave(@PathVariable Integer id, final RedirectAttributes redirectAttributes,
			HttpSession session) throws LeaveNotFound {

		ModelAndView mav = new ModelAndView("redirect:/staff/history");
		Leavel leave = cService.findLeave(id);
		String message = "Leavel " + leave.getLeaveId() + " was successfully withdrawn.";
		UserSession us = (UserSession) session.getAttribute("USERSESSION");
		leave.setStatus(Leavel.WITHDRAWN);
		LeaveEvent ce = new LeaveEvent();
		ce.setLeave(leave);
		ce.setEventBy(us.getEmployee().getEmployeeId());
		ce.setEventType(Leavel.WITHDRAWN);
		ce.setTimeStamp(Calendar.getInstance().getTime());
		cService.changeLeave(leave);
		ceService.createLeaveEvent(ce);
		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

}
