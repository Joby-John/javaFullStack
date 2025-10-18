package JAVA.OOP.threads;

// ---------------------------
// Implementing Runnable is preferred over extending Thread
// ---------------------------
// Reasons:
// 1. Java supports only single inheritance. Extending Thread prevents you
//    from extending another class. Implementing Runnable allows you to
//    extend another class if needed.
// 2. Runnable separates the task to be done from the Thread object itself,
//    which is cleaner design (decouples job from thread execution).
// 3. Multiple threads can share the same Runnable instance, allowing shared data.

class A implements Runnable {
    @Override
    public void run() {
        for(int i = 0; i < 5; i++) {
            System.out.println("A runs");

            // sleep pauses the current thread for the given milliseconds
            try {
                Thread.sleep(10); // milliseconds
            } catch (InterruptedException e) {
                e.printStackTrace(); // prints the call stack where exception occurred
            }
        }
    }
}

class B implements Runnable {
    @Override
    public void run() {
        for(int i = 0; i < 5; i++) {
            System.out.println("B runs");

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Main {
    public static void main(String args[]) {
        // Create Runnable instances
        A aObj = new A();
        B bObj = new B();

        // Create Thread objects with Runnable tasks
        Thread t1 = new Thread(aObj, "Thread-A");
        Thread t2 = new Thread(bObj, "Thread-B");

        // Start the threads
        t1.start();
        t2.start();

        // join() ensures main thread waits for t1 and t2 to finish
        try {
            t1.join(); // main thread waits until t1 completes
            t2.join(); // main thread waits until t2 completes
        } catch (InterruptedException e) {
            e.printStackTrace(); 
            // Stack trace: Shows sequence of method calls that led to exception
            // Useful for debugging where the exception occurred
        }

        System.out.println("Program complete");
    }
}

/*
 * ---------------------------
 * Thread Notes
 * ---------------------------
 * 1. Thread Creation:
 *    a) Extend Thread class
 *    b) Implement Runnable interface (preferred)
 * 2. Thread States:
 *    - New (created, not started)
 *    - Runnable (ready to run)
 *    - Running (executing run())
 *    - Waiting/Blocked (waiting for resource or join)
 *    - Terminated (finished execution)
 *
 * 3. Thread Methods:
 *    - start(): moves thread from New -> Runnable, then eventually Running
 *    - run(): contains the task; called automatically by start()
 *    - sleep(ms): pauses current thread, allows others to execute
 *    - join(): waits for a thread to finish
 *    - interrupt(): signals a thread to stop waiting/sleeping
 *
 * 4. Thread Safety:
 *    - Accessing shared data from multiple threads can cause race conditions
 *    - Use synchronization, locks, or concurrent collections to prevent data corruption
 *
 * 5. InterruptedException:
 *    - Thrown when a sleeping/waiting thread is interrupted
 *    - Must be either caught or declared to be thrown
 *
 * 6. Stack Trace:
 *    - A detailed printout of the sequence of method calls that led to the exception
 *    - Useful for debugging
 *
 * 7. Runnable vs Thread:
 *    - Runnable separates task from execution; allows multiple threads to share the same task
 *    - Extending Thread ties task and thread together, limiting flexibility
 *
 * 8. Naming Threads:
 *    - Thread constructor can take a name for easier debugging/logging
 *
 * 9. Thread Scheduling:
 *    - Java threads are scheduled by the JVM and OS; order of execution is not guaranteed
 *
 * 10. Best Practices:
 *    - Prefer implementing Runnable or Callable (for return values)
 *    - Use ExecutorService or thread pools in production instead of manually managing threads
 *    - Minimize shared mutable state to avoid concurrency issues
 *    - Always handle InterruptedException properly
 */
