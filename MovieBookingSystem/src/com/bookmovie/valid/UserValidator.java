package com.bookmovie.valid;

import java.util.regex.Pattern;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.bookmovie.dto.User;

@Service
public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(User.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email","unmKey", "*user name required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "passKey","*password required");
		
		User user = (User)target;
		if(user!=null) {
			if(user.getPassword().length()<8) { 
				errors.rejectValue("password", "passKey", "*password must be atleast 8 characters");
			}
			
			boolean b2=Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$").matcher(user.getEmail()).matches();  
			if(!b2) {
				errors.rejectValue("email", "unmKey", "Email must be char,aplha,no @mail.com");
			}
			if(user.getuFname()!=null) {
				ValidationUtils.rejectIfEmptyOrWhitespace(errors, "uFname", "ufname1","First Name required");
				if(user.getuFname().length()<20) {
					errors.rejectValue("uFname", "ufname1","*First Name must be between 1-20");
				}
			}
			if(user.getuLname()!=null) {
				ValidationUtils.rejectIfEmptyOrWhitespace(errors, "uLname", "ulname1","First Name required");
				if(user.getuLname().length()<20) {
					errors.rejectValue("uLname", "ulname1","*First Name must be between 1-20");
				}
			}
			if(user.getContact()!=null) {
				ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contact", "contact1","Mob no required");
				if(user.getContact().toString().length()<8 || user.getContact().toString().length() > 15 ) {
					errors.rejectValue("contact", "contact1","Mob no should in betn 8-15");
				}
			}
		}
		
		
	}

	
}
