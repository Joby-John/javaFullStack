package JAVA.OOP.abstarctClassesAndInterfaces;

// Interface
interface PowerSupply {
    int voltageRating = 240; // by default variables in interface are final and static 
    void powerConnected();
}

interface Portable {
    void move();

    // Java 8 default method
    default void Deskmove() {
        System.out.println("We can't move desktop");
    }
}

// Abstract class
abstract class Computer {
    public abstract void compiler();

    public void start() {
        System.out.println("Starting the computer");
    }
}

class Laptop extends Computer implements PowerSupply, Portable {
    @Override
    public void compiler() {
        System.out.println("Compiling on Laptop");
    }

    @Override
    public void powerConnected() {
        System.out.println("Laptop is charging on 240V");
    }

    @Override
    public void move() {
        System.out.println("Laptop can be moved from one place to another");
    }
}

class Desktop extends Computer implements PowerSupply, Portable {
    @Override
    public void compiler() {
        System.out.println("Compiling faster on Desktop");
    }

    @Override
    public void powerConnected() {
        System.out.println("Desktop running on 240V");
    }

    @Override
    public void move() {
        Deskmove(); // Uses default method
    }
}

class Developer {
    public void turnOnPower(PowerSupply comp) {
        comp.powerConnected();
    }

    public void code(Computer comp) {
        comp.start();
        System.out.println("Coding...");
        comp.compiler();
    }
}

public class Main {
    public static void main(String args[]) {
        Developer dev1 = new Developer();
        Computer lap1 = new Laptop();
        Computer desk1 = new Desktop();

        System.out.println("Power Rating is " + PowerSupply.voltageRating);

        // Portable polymorphism
        ((Portable) lap1).move();
        ((Portable) desk1).move();

        // Interface polymorphism
        dev1.turnOnPower((PowerSupply) lap1);
        dev1.turnOnPower((PowerSupply) desk1);

        // Abstract class polymorphism
        dev1.code(lap1);
        dev1.code(desk1);
    }
}


/*
 * Abstract Classes and Interfaces Notes
 * --------------------------------------
 * 
 * Abstract Classes
 * ----------------
 * 1. Abstract classes cannot be instantiated directly.
 * 2. Abstract classes can contain abstract methods (methods without a body) and/or concrete methods (with implementation).
 * 3. A class that extends an abstract class must implement all its abstract methods unless it is also declared abstract.
 * 4. Abstract classes can have constructors, fields, and methods.
 * 5. Abstract classes support access modifiers (private, protected, public) for their members.
 * 6. Abstract classes are useful when you want to provide some default behavior and enforce certain methods to be implemented in subclasses.
 * 7. Abstract classes support polymorphism. You can refer to a subclass object using an abstract class reference 
 *    (e.g., Computer comp = new Laptop();).
 * 
 * Interfaces
 * ----------
 * 1. Interfaces declare only method signatures (before Java 8), no implementation.
 * 2. From Java 8 onwards, interfaces can have default methods (with implementation) and static methods.
 * 3. A class implementing an interface must provide implementation for all abstract methods unless the class is abstract.
 * 4. Interfaces do not have constructors or instance fields (except static final constants).
 * 5. Interfaces support multiple inheritance; a class can implement multiple interfaces.
 * 6. Interfaces are ideal for defining a contract that multiple unrelated classes can implement.
 * 
 * Key Differences between Abstract Classes and Interfaces:
 * -------------------------------------------------------
 * 1. Abstract class: can have both abstract and concrete methods; Interface: mostly abstract methods (except default/static in Java 8+)
 * 2. Abstract class: supports single inheritance; Interface: supports multiple inheritance
 * 3. Abstract class: can have instance fields; Interface: only static final constants
 * 4. Abstract class: constructors allowed; Interface: no constructors
 * 5. Abstract class: use when classes are closely related; Interface: use when defining a contract across unrelated classes
 * 
 * Casting Notes
 * -------------
 * 1. In Java, you can cast an object to any type that its class implements or extends.
 * 2. Example: Computer lap1 = new Laptop(); can be cast to PowerSupply because Laptop implements PowerSupply.
 * 3. Compile-time type: type of the variable reference (e.g., Computer lap1).
 * 4. Runtime type: actual object created (e.g., new Laptop()).
 * 5. Upcasting (subclass → superclass/interface) is implicit and safe.
 * 6. Downcasting (superclass/interface → subclass) requires explicit cast and may throw ClassCastException at runtime.
 * 7. Polymorphism allows methods to operate on references of abstract class or interface types while executing subclass-specific behavior.
 */
