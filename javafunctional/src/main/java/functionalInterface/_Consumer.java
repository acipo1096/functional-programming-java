package functionalInterface;
import java.util.function.Consumer;
import java.util.function.BiConsumer;

public class _Consumer {
    public static void main(String[] args) {
        // Normal Java function
        Customer maria = new Customer("Maria", "516-516-5516");
        greetCustomer(maria);
        greetCustomerV2(maria,false);

        // Consumer Functional interface
        // A Consumer is like a void function. It takes one argument and returns nothing
        // We use .accept() instead of .apply()
        greetCustomerConsumer.accept(maria);

        // BiConsumer
        greetCustomerConsumerV2.accept(maria,false);
    }

    static BiConsumer<Customer, Boolean> greetCustomerConsumerV2 = (customer, showPhoneNumber) -> System.out.println(
            "Hello " + customer.customerName + ", thanks for registering phone number " + (showPhoneNumber ? customer.customerPhoneNumber : "**********"));

    static Consumer<Customer> greetCustomerConsumer = customer -> System.out.println(
            "Hello " + customer.customerName + ", thanks for registering phone number " + customer.customerPhoneNumber);

    static void greetCustomer(Customer customer) {
        System.out.println("Hello " + customer.customerName + ", thanks for registering phone number " + customer.customerPhoneNumber);
    }

    static void greetCustomerV2(Customer customer, boolean showPhoneNumber) {
        System.out.println("Hello " + customer.customerName + ", thanks for registering phone number " + (showPhoneNumber ? customer.customerPhoneNumber : "**********"));
    }

    static class Customer {
        private final String customerName;
        private final String customerPhoneNumber;

        Customer(String customerName, String customerPhoneNumber) {
            this.customerName = customerName;
            this.customerPhoneNumber = customerPhoneNumber;
        }
    }
}
