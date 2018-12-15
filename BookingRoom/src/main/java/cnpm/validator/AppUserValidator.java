package cnpm.validator;
 
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import cnpm.domain.Account;
import cnpm.repository.UserRepository;
 
@Component
public class AppUserValidator implements Validator {
 
    // common-validator library.
    private EmailValidator emailValidator = EmailValidator.getInstance();
 
    @Autowired
    private UserRepository accountRepository;
 
    // Các lớp được hỗ trợ bởi Validator này.
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz == Account.class;
    }
 
    @Override
    public void validate(Object target, Errors errors) {
    	Account account = (Account) target;
    	
    	 // Kiểm tra các field của AppUserForm.
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty.account.username");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty.account.name");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty.account.email");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty.account.password");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone_number", "NotEmpty.account.phone_number");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "NotEmpty.account.address");
        
        
        if (!this.emailValidator.isValid(account.getEmail())) {
            // Email không hợp lệ.
            errors.rejectValue("email", "Pattern.account.email");
        } else {
            Account dbUser = accountRepository.findByEmail(account.getEmail());
            if (dbUser != null) {
                // Email đã được sử dụng bởi tài khoản khác.
                errors.rejectValue("email", "Duplicate.appUserForm.email");
            }
        }
        if (!errors.hasFieldErrors("username")) {
            Account dbUser = accountRepository.findByUsername(account.getUsername());
            if (dbUser != null) {
                // Tên tài khoản đã bị sử dụng bởi người khác.
                errors.rejectValue("username", "Duplicate.account.username");
            }
        }
    }
 
}