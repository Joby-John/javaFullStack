package com.joby.junitdemo;

public class SimpleCalculator {
    
    public int add(Integer numA, Integer numB)
    {
        return numA + numB;
    }
}


/*
─────────────────────────────────────────────────────────────
🧩 STEP-BY-STEP GUIDE — SETTING UP JUNIT IN VS CODE (MAVEN)
─────────────────────────────────────────────────────────────

📍 1️⃣  Create Maven Project in VS Code
───────────────────────────────────────
1. Press **Ctrl + Shift + P** → type and select **“Java: Create Java Project”**
2. Choose **Maven** as the project type.
3. Choose **No Archetype** (simpler structure, we’ll configure manually).
4. You’ll be asked for:
   - **Group Id** → this represents your organization or domain (e.g., `com.joby`)
   - **Artifact Id** → this is your project name (e.g., `junitdemo`)
   Together, they define your base package → `com.joby.junitdemo`
5. VS Code creates a new folder with this structure:

   📁 project-root  
   ├── 📁 src  
   │   ├── 📁 main  
   │   │   └── 📁 java  
   │   │       └── 📁 com  
   │   │           └── 📁 joby  
   │   │               └── 📁 junitdemo  ← (your main code here)
   │   └── 📁 test  
   │       └── 📁 java  
   │           └── 📁 com  
   │               └── 📁 joby  
   │                   └── 📁 junitdemo  ← (your test code here)
   ├── pom.xml  ← Maven configuration
   └── ... other files

   📌 Note: `src/main/java` and `src/test/java` must mirror the **same package structure**.

─────────────────────────────────────────────────────────────
📍 2️⃣  Edit pom.xml to Add JUnit Dependency
─────────────────────────────────────────────
Open `pom.xml` and add this inside `<dependencies>` tag:

```xml
<dependency>
  <groupId>org.junit.jupiter</groupId>
  <artifactId>junit-jupiter</artifactId>
  <version>5.10.2</version>
  <scope>test</scope>
</dependency>
*/

/*
 * 📍 5️⃣ Commonly Used JUnit Annotations
─────────────────────────────────────────────

@Test → Marks a test method.

@BeforeEach → Runs before every test (setup).

@AfterEach → Runs after every test (cleanup).

@BeforeAll → Runs once before all tests (static method).

@AfterAll → Runs once after all tests (static method).

@DisplayName("Readable name") → Gives a nice name for test in reports.

 */

/*
 * 📍 6️⃣ Commonly Used Assertions (from org.junit.jupiter.api.Assertions)
─────────────────────────────────────────────────────────────

assertEquals(expected, actual) → checks if both are equal.

assertNotEquals(a, b)

assertTrue(condition)

assertFalse(condition)

assertNull(object)

assertNotNull(object)

assertThrows(Exception.class, () -> { ... }) → checks if code throws exception.
 */

/*
📍 7️⃣ Running Tests
─────────────────────────────────────────────
✔️ Use VS Code’s Testing Sidebar → “Run Test” or “Run All Tests”.
✔️ Or use terminal:
    mvn test
 */ 

 /*
  * 📍 8️⃣ Pro Tips for Development
─────────────────────────────────────────────

* Always test edge cases (zero, negative, null, limits).

* Keep logic (like SimpleCalculator) separate from I/O (Main).

* JUnit tests should never print — they should assert.

* For reusable setup, use:
    @BeforeEach
    void init() {
        calc = new SimpleCalculator();
    }

  */