public class Frog {
    private String name;
    private int age;
    private double tongueSpeed;
    private boolean isFroglet;

    private static String species = "Rare Pepe";
    public static final double deTonguespeed = 5;
    public static final int deAge = 5;

    // constructors
    public Frog(String name, int age, double tongueSpeed){
        this.name = name;
        this.age = age;
        this.tongueSpeed = tongueSpeed;
        this.isFroglet=(age>1)&&(age<7);
    }
    public Frog(String name){
        this(name,deAge,deTonguespeed);
    }
    public Frog(String name, double ageInYears, double tongueSpeed){
        this(name,(int)(ageInYears *12),tongueSpeed);
    }
    //grow
    public void grow(int numMonth){
        for(int count =0; count <numMonth;count++){
            age ++;
            if(age <= 12){
                tongueSpeed ++;
            }else if(age >= 30){
                if(tongueSpeed >5) {
                    tongueSpeed --;
                }

            }
        }isFroglet = (1<age)&&(age<7);
    }
    public void grow(){
        grow(1);
    }
    //eat
    public void eat(Fly food){
        if(!food.isDead()){
            if(tongueSpeed > food.getSpeed()){
                if(food.getMass() >= 0.5*age){
                    grow();
                }
                food.setMass(0);

            }else{
                food.grow(1);
            }
        }
    }
    //toString
    public String toString(){
        if(isFroglet){
            return String.format("My name is %s and I’m a rare froglet! I’m %d months old and my tongue has a speed of %.2f.",name,age,tongueSpeed);
        }else{
            return String.format("My name is %s and I’m a rare frog. I’m %d months old and my tongue has a speed of %.2f.",name,age,tongueSpeed);
        }
    }
    // get species
    public static String getSpecies(){
        return species;
    }

    //set species
    public static void setSpecies(String newSpecies){
        species = newSpecies;
    }
}
