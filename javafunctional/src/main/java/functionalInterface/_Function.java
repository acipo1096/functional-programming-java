package functionalInterface;
import java.util.function.Function;
import java.util.function.BiFunction;

public class _Function {
public static void main(String[] args) {
        // No function
        int increment = increment(1);
        System.out.println(increment);

        // With Function
        // First Integer corresponds to the Type
        // Second Integer corresponds to Result type
        // Needs to be within method unless you use "static"
        // Function takes 1 argument and produces 1 result
        int increment2 = incrementByOneFunction.apply(3);
        // use .apply() to accept arguments
        System.out.println(increment2);

        int multiply = multiplyBy10Function.apply(increment2);
        System.out.println(multiply);

        // What if we combined the two functions together using andThen()?
        Function<Integer,Integer> addBy1AndThenMultiplyBy10 = 
            incrementByOneFunction.andThen(multiplyBy10Function);
        System.out.println(addBy1AndThenMultiplyBy10.apply(1));

        // BiFunction takes 2 arguments and produces 1 result
        System.out.println(incrementByOneAndMultiply(4, 100));

        System.out.println(incrementByOneAndMultiplyBiFunction.apply(4, 100));
        }

    static Function<Integer, Integer> incrementByOneFunction = number -> number + 1;

    // Chaining Functions
    static Function<Integer, Integer> multiplyBy10Function = number -> number * 10;

    static int increment(int number) {
        return number + 1;
    }

    // BIFUNCTIONS - can have different data types if need be
    // The top example is exactly the same as the below
    static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyBiFunction = 
    (numberToIncrementByOne, numberToMultiplyBy) -> (numberToIncrementByOne + 1) * numberToMultiplyBy;

    // BiFunctions take two arguments and produce one result
    static int incrementByOneAndMultiply(int number, int numToMultiplyBy) {
        return (number + 1) * numToMultiplyBy;
    }
}
