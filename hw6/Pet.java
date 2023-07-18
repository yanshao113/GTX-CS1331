import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
public abstract class Pet {
    private final String name;
    private double health;
    private int painLevel;
    public Pet(String name, double health, int painLevel){
        this.name= name;
        this.health = Math.max(health, 0.0);
        if(painLevel>=10){
            this.painLevel = 10;
        }else this.painLevel = Math.max(painLevel, 1);
    }
    //getters
    public String getName(){
        return name;
    }
    public double getHealth(){
        return health;
    }
    public int getPainLevel(){
        return painLevel;
    }

    // int treat()
    public abstract int treat();
    // void speak
    public void speak(){
        String myName = String.format("Hello! My name is %s",name);
        if(painLevel > 5){
            System.out.println(myName.toUpperCase());
        }else{
            System.out.println(myName);
        }
    }
    // boolean equals
    public boolean equals(Object o){
        if(!(o instanceof Pet)){
            return false;
        }else{
            return this.name.equals(((Pet)o).name);
        }
    }
    // heal()
    protected void heal(){
        this.health = 1.0;
        this.painLevel = 1;
    }
}
