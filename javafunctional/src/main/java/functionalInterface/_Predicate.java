package functionalInterface;
import java.util.function.Predicate;

public class _Predicate {
    public static void main(String[] args) {
        // A Predicate is the equivalent of a normal Java function
        // Represents a predicate (boolean-valued function) of one argument
        System.out.println("Without Predicate");
        System.out.println(isPhoneNumberValid("01000000000"));
        System.out.println(isPhoneNumberValid("0100000000"));
        System.out.println(isPhoneNumberValid("09009877300"));

        // See the use of .test()
        System.out.println("With Predicate");
        System.out.println(isPhoneNumberValidPredicate.test("01000000000"));
        System.out.println(isPhoneNumberValidPredicate.test("0100000000"));
        System.out.println(isPhoneNumberValidPredicate.test("09009877300"));

        // "Chaining" a Predicate
        System.out.println("Is phone number valid and contains number 3 = " + isPhoneNumberValidPredicate.and(containsNumber3).test("09009877300"));
        System.out.println("Is phone number valid and contains number 3 = "
                + isPhoneNumberValidPredicate.and(containsNumber3).test("01000030000"));

        // You can also use .or() - if either one is true, return true
        System.out.println("Is phone number valid and contains number 3 = "
                + isPhoneNumberValidPredicate.or(containsNumber3).test("01000030000"));

    }

    static boolean isPhoneNumberValid (String phoneNumber) {
        return phoneNumber.startsWith("01") && phoneNumber.length() == 11;
    }

    static Predicate<String> isPhoneNumberValidPredicate = phoneNumber -> phoneNumber.startsWith("01") && phoneNumber.length() == 11;

    static Predicate<String> containsNumber3 = phoneNumber -> phoneNumber.contains("3");

    // We also have BiPredicates - very similar as the other "Bi" interfaces

}
