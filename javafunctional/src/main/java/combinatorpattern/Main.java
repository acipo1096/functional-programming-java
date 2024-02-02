package combinatorpattern;

import java.time.LocalDate;

import combinatorpattern.CustomerRegistrationValidator.ValidationResult;
import static combinatorpattern.CustomerRegistrationValidator.isEmailValid;
import static combinatorpattern.CustomerRegistrationValidator.isPhoneNumberValid;
import static combinatorpattern.CustomerRegistrationValidator.isAnAdult;

public class Main {
    public static void main(String[] args) {
        // Customer customer = new Customer("Alice", "alice@gmail.com", "+15164637461", LocalDate.of(2000, 1, 1));
        // System.out.println(new CustomerValidatorService().isValid(customer));

        // If valid, we can store customer in db

        // Using combinator pattern
        Customer customer = new Customer("Alice", "alice@gmail.com", "+15164637461", LocalDate.of(2020, 1, 1));
        ValidationResult result = isEmailValid()
            .and(isPhoneNumberValid())
            .and(isAnAdult())
            .apply(customer);
            // Nothing runs until we invoke .apply(), even if you return something in Customer RegistrationValidator

        System.out.println(result);

        if (result != ValidationResult.SUCCESS) {
            throw new IllegalStateException(result.name());
        }


    }
}
