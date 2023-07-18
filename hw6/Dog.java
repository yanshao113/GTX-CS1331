import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
public class Dog extends Pet {
    private double droolRate;
    public static final double DEFAULTDROOLRATE = 5.0;
    public Dog(String name, double health, int painLevel, double droolRate){
        super(name,health,painLevel);
        if(droolRate<=0){
            this.droolRate= 0.5;
        }else{
            this.droolRate = droolRate;
        }
    }
    public Dog(String name, double health, int painLevel){
        this(name,health,painLevel,DEFAULTDROOLRATE);
    }

    // getters
    public double getDroolRate(){
        return droolRate;
    }

    // int treat()
    public int treat(){
        int minuteTreat;
        int pain = this.getPainLevel();
        double hlth = this.getHealth();
        if(droolRate<3.5){
            minuteTreat = (int)((pain*2)/hlth);
        }else if(droolRate>=3.5 && droolRate<=7.5){
            minuteTreat = (int)(pain/hlth);
        }else{
            minuteTreat = (int)(pain/(hlth*2));
        }
        super.heal();
        return minuteTreat;
    }

    // void speak()
    public void speak(){
        super.speak();
        String barkNum = "";
        for(int i = 0; i < this.getPainLevel(); i++){
            barkNum = barkNum + "bark ";
            if(this.getPainLevel()>5){
                System.out.println(barkNum.toUpperCase());
            }else{
                System.out.println(barkNum);
            }
        }
    }

    //boolean equals
    public boolean equals(Object o){
        if(super.equals(o)&&(droolRate==((Dog)o).getDroolRate())){
            return true;
        }return false;
    }

}
