package combinatorpattern;

import java.time.LocalDate;

import combinatorpattern.CustomerRegistrationValidator.ValidationResult;

public class Main {
    public static void main(String[] args) {
        // Customer customer = new Customer("Alice", "alice@gmail.com", "+15164637461", LocalDate.of(2000, 1, 1));
        // System.out.println(new CustomerValidatorService().isValid(customer));

        // If valid, we can store customer in db

        // Using combinator pattern
        ValidationResult result = isEmailValid()
            .and(CustomerRegistrationValidator.isPhoneNumberValid())
            .and(CustomerRegistrationValidator.isAnAdult())
            .apply(customer);
        Customer customer = new Customer("Alice", "alicegmail.com", "+15164637461", LocalDate.of(2000, 1, 1));
        System.out.println(new CustomerValidatorService().isValid(customer));


    }
}
