package JAVA.OOP.exceptionHandling;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Division {
    // Method 'a' performs division and can throw ArithmeticException
    // Note: Non-static now, belongs to an object instance of Division
    public void a() throws ArithmeticException {
        int a;
        int b;
        int result;

        // Try-with-resources ensures Scanner is automatically closed
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter numbers");
            a = sc.nextInt();
            b = sc.nextInt();
        }

        // Perform division
        result = a / b;

        // If result is zero or b is zero, throw ArithmeticException
        // Throwing an exception immediately stops method execution
        if (result == 0 || b == 0) {
            System.out.println("Division failed");
            throw new ArithmeticException();
        }

        // This line executes only if no exception was thrown
        System.out.println("Result : " + result);
    }
}

public class Main {

    public static void main(String args[]) {
        // Normal ArrayList (not thread-safe)
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        // Thread-safe version of ArrayList using synchronizedList
        // Collections.synchronizedList wraps the ArrayList and synchronizes all methods
        List<Integer> threadSafeList = Collections.synchronizedList(new ArrayList<>());
        threadSafeList.add(1);
        threadSafeList.add(2);

        try {
            // Create an object of Division since 'a()' is now non-static
            Division division = new Division();
            division.a();  // Exception may be thrown here

            // Accessing elements beyond the list size will throw IndexOutOfBoundsException
            list.get(5);             
            threadSafeList.get(8);

        } catch (ArithmeticException e) {
            // Catch block handles exceptions thrown from 'a()'
            // Exception is propagated from 'a()' to main method
            System.err.println("function a generated " + e);
        } catch (IndexOutOfBoundsException e) {
            // Catch block handles invalid list access
            System.err.println(e);
        }
        finally
        {
            System.out.println("Program Completed");
        }

        /*
         * Notes:
         *
         * 1. Exception Handling:
         *    - 'throw' inside a method immediately stops execution of that method.
         *    - 'throws' in method declaration indicates that the method may propagate an exception to its caller.
         *    - The caller can catch the exception with try-catch blocks.
         *
         * 2. Exception Propagation:
         *    - When an exception is thrown inside 'division.a()', it propagates up the call stack to the nearest matching catch block in main().
         *    - Code after the throw inside 'a()' is skipped.
         *
         * 3. Thread-safe Lists:
         *    - ArrayList is not thread-safe by default.
         *    - Collections.synchronizedList() wraps an ArrayList and synchronizes its methods.
         *    - Useful when multiple threads access the same list concurrently.
         *
         * 4. Static vs Non-Static:
         *    - Previously 'a()' was static to allow calling it directly from the static main method.
         *    - Now 'a()' is non-static and belongs to an instance of Division.
         *    - This is more OOP-friendly, avoids unnecessary static methods, and allows multiple Division objects with independent states.
         *
         * 5. Try-with-resources:
         *    - Automatically closes Scanner to avoid resource leaks.
         *
         * 6. Polymorphic Exception Handling:
         *    - Multiple catch blocks can handle different types of exceptions.
         *    - The first matching catch block is executed.
         */
    }
}
