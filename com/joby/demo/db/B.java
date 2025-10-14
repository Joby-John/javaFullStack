package com.joby.demo.db;
import com.joby.demo.app.A;

public class B extends A{
    
    @Override
    public void show()
    { 
        System.out.println("Can't overide fnal methods");
    }    
}
