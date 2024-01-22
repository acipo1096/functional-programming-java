package imperative;

import java.util.List;

import static imperative.Main.Gender.*;

public class Main {
    public static void main(String[] args) {
        // Create list - type person - of a few people
        List<Person> people = List.of(
            // Take it from 9:47
            // https://www.youtube.com/watch?v=rPSL1alFIjI&list=PLWKjhJtqVAbnRT_hue-3zyiuIYj0OlpyG&index=2
            new Person("John", MALE),
            new Person("Maria", FEMALE),
            new Person("Aisha", FEMALE),
            new Person("Alex", MALE),
            new Person("Alice", FEMALE)
        );
    }

        static class Person {
            private final String name;
            private final Gender gender;

            Person (String name, Gender gender) {
                this.name = name;
                this.gender = gender;
            }

            @Override
            public String toString() {
                return "Person{" + 
                        "name='" + name + '\\' + 
                        "gender=" + gender + 
                        '}';
            }
        }

        enum Gender {
            MALE, FEMALE
        }
}
