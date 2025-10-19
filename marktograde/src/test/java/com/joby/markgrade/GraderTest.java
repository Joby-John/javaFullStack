package com.joby.markgrade;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;


public class GraderTest {
        private Grader grader;
        
        @BeforeEach
        void init() {
            grader = new Grader();
        }


        @Test
        void lessThanZeroGivesIllegalArgumentException(){
            assertThrows(IllegalArgumentException.class, 
            ()->{ grader.determineLetterGrade(-1);
            });
        }
            
            
        @Test
        void ZeroGivesF(){
            assertEquals('F', grader.determineLetterGrade(0));
            
        }

        @Test
        void lessThanSixtyGivesF(){
            
            assertEquals('F', grader.determineLetterGrade(49));
        }

        @Test
        void SixtyGivesD(){
            
            assertEquals('D', grader.determineLetterGrade(60));
        }

        @Test
        void lessThanSeventyGivesD(){
            assertEquals('D', grader.determineLetterGrade(69));

        }
        @Test
        void SeventyGivesC(){
            assertEquals('C', grader.determineLetterGrade(70));

        }

        @Test 
        void lessThanEightyGivesC(){
            assertEquals('C', grader.determineLetterGrade(79));
        }
        @Test 
        void EightyGivesB(){
            assertEquals('B', grader.determineLetterGrade(80));
        }

        @Test
        void lessThanNintyGivesB(){
            assertEquals('B', grader.determineLetterGrade(89));

        }
        @Test
        void NintyGivesA(){
            assertEquals('A', grader.determineLetterGrade(90));

        }

        @Test
        void lessHundredGivesA(){
            assertEquals('A', grader.determineLetterGrade(99));

        }

        @Test
        void equalToHundredGivesA(){
            assertEquals('A', grader.determineLetterGrade(100));

        }

        @Test
        void greaterThanHundredGivesIllegalArgumentException(){
            assertThrows(IllegalArgumentException.class, 
            ()->{
                grader.determineLetterGrade(120);
            });
        }
}
