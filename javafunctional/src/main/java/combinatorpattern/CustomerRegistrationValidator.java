package combinatorpattern;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

import combinatorpattern.CustomerRegistrationValidator.ValidationResult;

import static combinatorpattern.CustomerRegistrationValidator.*;
import static combinatorpattern.CustomerRegistrationValidator.ValidationResult.EMAIL_NOT_VALID;
import static combinatorpattern.CustomerRegistrationValidator.ValidationResult.IS_NOT_AN_ADULT;
import static combinatorpattern.CustomerRegistrationValidator.ValidationResult.PHONE_NUMBER_NOT_VALID;
import static combinatorpattern.CustomerRegistrationValidator.ValidationResult.SUCCESS;

public interface CustomerRegistrationValidator 
        extends Function <Customer, ValidationResult> {

        static CustomerRegistrationValidator isEmailValid() {
            return customer -> customer.getEmail().contains("@") ? SUCCESS : EMAIL_NOT_VALID;
        }

        static CustomerRegistrationValidator isPhoneNumberValid() {
            return customer -> customer.getPhoneNumber().startsWith("+1") ? SUCCESS : PHONE_NUMBER_NOT_VALID;
        }

        static CustomerRegistrationValidator isAnAdult() {
            return customer -> Period.between(customer.getDob(), LocalDate.now()).getYears() > 18 ? SUCCESS : IS_NOT_AN_ADULT;
        }

        default CustomerRegistrationValidator and (CustomerRegistrationValidator other) {
            return customer -> {
                ValidationResult result = this.apply(customer);
                return result.equals(SUCCESS) ? other.apply(customer) : result;
            };
        }

        enum ValidationResult {
            SUCCESS,
            PHONE_NUMBER_NOT_VALID,
            EMAIL_NOT_VALID,
            IS_NOT_AN_ADULT
        }
}

// If we didn't chain with Combinator Patterns, this is what the functions would look like:

// static CustomerRegistrationValidator isEmailValid() {
//     return customer -> customer.getEmail().contains("@") ? SUCCESS : EMAIL_NOT_VALID;
// }

// static CustomerRegistrationValidator isPhoneNumberValid() {
//     return customer -> customer.getPhoneNumber().startsWith("+1") ? SUCCESS : PHONE_NUMBER_NOT_VALID;
// }

// static CustomerRegistrationValidator isAnAdult() {
//             return customer -> Period.between(customer.getDob(), LocalDate.now()).getYears() > 18 ? SUCCESS : IS_NOT_AN_ADULT;
//         }