package finalsection;

import java.util.function.*;

public class Lambdas {
    public static void main(String[] args) {

        // 1 return statement
        
        // Function <String, String> upperCaseName = name -> name.toUpperCase();
        // Think of a Lambda like ES6 JavaScript
        // name is the argument - the first Function parameter
        // No need for return keyword because we only have 1 return statement

        // Return block
        Function<String, String> upperCaseName = name -> {
            if (name.isEmpty()) throw new IllegalArgumentException("");
            return name.toUpperCase();
        };

        BiFunction<String, Integer, String> upperCaseName2 = (name,age) -> {
            if (name.isEmpty()) throw new IllegalArgumentException("");
            return name.toUpperCase();
        };
        
        System.out.println(upperCaseName2.apply("Alex", 20));
    }
    
}
