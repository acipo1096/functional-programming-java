package functionalInterface;
import java.util.function.Supplier;
import java.util.List;

public class _Supplier {
    public static void main(String[] args) {
        System.out.println(getDBConnectionUrl());
        System.out.println(getDBConnectionUrlSupplier.get());
        System.out.println(getDBConnectionUrlSupplierList.get());
    }

    static String getDBConnectionUrl () {
        return "jdbc://localhost:5432/users";
    }

    // A Supplier returns any kind of value that you want
    // Can be custom objects, a string, a list, etc.
    static Supplier<String> getDBConnectionUrlSupplier = () -> "jdbc://localhost:5432/users";

    static Supplier<List<String>> getDBConnectionUrlSupplierList = () -> List.of("jdbc://localhost:5432/users","jdbc://localhost:5432/customer");

}
