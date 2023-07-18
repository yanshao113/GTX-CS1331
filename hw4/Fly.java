public class Fly {
    private double mass;
    private double speed;
    //constants
    public static final double default_speed = 10;
    public static final double default_mass = 5;
    //constructor1: takes in mass and speed of a Fly.
    public Fly(double mass, double speed){
        this.mass = mass;
        this.speed = speed;
    }
    //constructor2:takes in only mass.
    public Fly(double mass){
        this(mass,default_speed);
    }
    //constructor3:takes in no parameters.
    public Fly(){
        this(default_mass,default_speed);
    }
    //getter
    public double getMass(){
        return mass;
    }
    public double getSpeed(){
        return speed;
    }
    //setter
    public void setMass(double newMass){
        if(isLegalMass(newMass)){
            mass = newMass;
        }
    }
    public void setSpeed(double newSpeed){
        if(isLegalspeed(newSpeed)){
            speed = newSpeed;
        }
    }
    public static boolean isLegalMass(double newMass){
        return (newMass >= 0 ? true : false);
    }
    public static boolean isLegalspeed(double newSpeed){
        return (newSpeed > 0 ? true : false);
    }
    //toString
    public String toString(){
        if(mass == 0){
            return String.format("I’m dead, but I used to be a fly with a speed of %.2f",speed);
        }else{
            return String.format("I’m a speedy fly with %.2f speed and %.2f mass.", speed,mass);
        }
    }
    /*
    grow - takes in an integer parameter representing the added mass. Then it increases the mass of the Fly by the given number of mass. As mass increases, speed changes as follows:
If mass is less than 20: increases speed by 1 for every mass the Fly grows until it reaches 20 mass.
If the mass is 20 or more: decreases speed by 0.5 for each mass unit added over 20.
     */
    public void grow(int addMass){
            if(mass>=20){
                speed -= 0.5 * addMass;
            }else if(mass+addMass < 20){
                speed += addMass;
            }else{
                int noReach20 = 20-(int)mass;
                int bigThan20 = (int)mass + addMass -20;
                speed += noReach20 - 0.5*bigThan20;
            }
            mass += addMass;
        }
    //isdead
    public boolean isDead(){
        if(mass == 0){
            return true;
        }else{
            return false;
        }
    }
}
