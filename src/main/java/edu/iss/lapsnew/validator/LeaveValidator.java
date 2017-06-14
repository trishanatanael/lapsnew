package edu.iss.lapsnew.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import edu.iss.lapsnew.model.Leavel;

@Component
public class LeaveValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return Leavel.class.isAssignableFrom(arg0);

	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		Leavel leave = (Leavel) arg0;	
		if ((leave.getFromDate()!=null && leave.getToDate()!=null)&&(leave.getFromDate().compareTo(leave.getToDate()) > 0)) {
			arg1.reject("toDate", "End date should be greater than start date.");
			arg1.rejectValue("toDate", "error.dates", "to date must be > from date");
	
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "leaveName", "error.leaveName", "Leave name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "fromDate", "error.fromDate", "From Date is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "toDate", "error.toDate", "To Date is required.");
	}

}
