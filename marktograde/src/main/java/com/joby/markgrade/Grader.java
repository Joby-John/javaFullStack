package com.joby.markgrade;

public class Grader {

    public char determineLetterGrade(int mark) throws IllegalArgumentException
    {
        if(mark < 0){
            throw new IllegalArgumentException("Mark cannot be less than zero");
        }
        else if(mark < 60){
            return 'F';
        }else if(mark < 70){
            return 'D';
        }
        else if(mark < 80){
            return 'C';
        }
        else if(mark < 90){
            return 'B';
        }
        else if(mark <= 100){
            return 'A';
        }
        else{
            throw new IllegalArgumentException("Mark cannot be greater than 100");
        }
    }    
}
