package JAVA.OOP.packages;

import JAVA.com.joby.demo.app.*;

public class Demo {
   public static void main(String args[])
   {
     final int num = 100;
     C obj = new C(); // C must be public to be accessible from another package
     num = 10; // final variable can't change as its constant
    }

}

/*
 * Java Access Modifiers Table
 * 
 * Modifier \ Context                 Same Class   Same Package Subclass   Same Package Non-Subclass   Different Package Subclass   Different Package Non-Subclass
 * --------------------------------------------------------------------------------------------------------------------------------------
 * private                             Yes           No                     No                          No                          No
 * default (no modifier / package)     Yes           Yes                    Yes                         No                          No
 * protected                           Yes           Yes                    Yes                         Yes                         No
 * public                              Yes           Yes                    Yes                         Yes                         Yes
 *
 * Notes:
 * 1. private: accessible only within the same class.
 * 2. default/package-private: accessible only within the same package.
 * 3. protected: accessible within package and by subclasses (even in other packages).
 * 4. public: accessible everywhere.
 */


/*
 * Final Uses
 * With Variable :- can be used to to make it constant.
 * With method :- can be used to prevent overiding.
 * With class :- can be used to prevent inheritance. 
 */
