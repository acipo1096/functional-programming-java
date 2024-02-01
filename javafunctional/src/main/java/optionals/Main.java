package optionals;

import java.util.Optional;
import java.util.function.Supplier;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        Supplier<IllegalStateException> exception = () -> new IllegalStateException("exception");
        
        // Object value = Optional.ofNullable("Hello!")
            // .orElseGet(() -> "default value");
            // .orElseThrow(exception);
        Optional.ofNullable("alex.cipollone10@gmail.com")
            // .ifPresent(email -> System.out.println("Sending email to " + email));
                .ifPresentOrElse(email -> System.out.println("Sending email to " + email), () -> {
                    System.out.println("Cannot send email");
                });

        // System.out.println(value);
    }
}
