import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
public class Cat extends Pet{
    private int miceCaught;
    public static final int DEFAULTMICECAUGHT =0 ;
    public Cat(String name, double health, int painLevel, int miceCaught){
        super(name, health, painLevel);
        if(miceCaught<0){
            this.miceCaught = 0;
        }else {
            this.miceCaught = miceCaught;
        }
    }
    public Cat(String name, double health, int painLevel){
        this(name,health,painLevel,DEFAULTMICECAUGHT);
    }
    //getters
    public int getMiceCaught(){
        return miceCaught;
    }
    //treat
    public int treat(){
        int minuteTreat;
        int pain = this.getPainLevel();
        double hlth = this.getHealth();
        super.heal();
        if(miceCaught<4){
            minuteTreat = (int)((pain*2)/hlth);
        }else if(miceCaught<=7){
            minuteTreat = (int)(pain/hlth);
        }else{
            minuteTreat = (int)(pain/(hlth*2));
        }
        return minuteTreat;
    }
    //void speak
    public void speak(){
        super.speak();
        String meowNum ="";
        for(int i = 0; i < this.getPainLevel(); i++){
            meowNum = meowNum + "meow ";
            if(this.getPainLevel()>5){
                System.out.println(meowNum.toUpperCase());
            }else{
                System.out.println(meowNum);
            }
        }
    }
    //equals
    public boolean equals(Object o){
        return super.equals(o) && (miceCaught == ((Cat) o).getMiceCaught());
    }
}
