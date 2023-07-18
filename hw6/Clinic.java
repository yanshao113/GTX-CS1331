import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
public class Clinic {
    private File patientFile;
    private int day;
    public Clinic(File file){
        patientFile = file;
        day = 1;
    }
    //Clinic(String fileName)
    //String includes filename extension – don't add “.csv”
    //Chains to the other constructor
    public Clinic(String filename){
        this(new File(filename));
    }
    public String nextDay(String fileName) throws FileNotFoundException{
        return nextDay(new File(fileName));
    }
    public String nextDay(File f) throws FileNotFoundException{
        day++;
        String output= "";
        Scanner read = new Scanner(f);
        Scanner input = new Scanner(System.in);
        String line ;
        while(read.hasNextLine()){
            line = read.nextLine();
            String[] information = line.split(",");
            String name = information[0];
            String typeOfPet = information[1];
            String personalVar = information[2];
            String appointmentTime = information[3];
            if((!typeOfPet.equals("Dog"))&&(!typeOfPet.equals("Cat"))){
                throw new InvalidPetException();
            }
            System.out.printf("Consultation for %s the %s at %s.\n",name,typeOfPet,appointmentTime);
            double health = 0;
            int painLevel = 0;
            boolean isVaildHealth = false;
            boolean isVaildPain = false;
            while(!isVaildHealth){
                System.out.printf("What is the health of %s?\n",name);
                if(input.hasNextDouble()){
                    health = input.nextDouble();
                    isVaildHealth = true;
                }else{
                    input.nextLine();
                    System.out.println("Please enter a number");
                }
            }
            while(!isVaildPain){
                System.out.printf("On a scale of 1 to 10, how much pain is %s in right now?\n",name);
                if(input.hasNextInt()){
                    painLevel =input.nextInt();
                    isVaildPain =true;
                }else{
                    input.nextLine();
                    System.out.println("Please enter a number");
                }
            }
            Pet pet;
            switch(typeOfPet){
                case"Dog":
                    pet = new Dog(name,health,painLevel,Double.parseDouble(personalVar));
                    break;
                case"Cat":
                    pet = new Cat(name,health,painLevel,Integer.parseInt(personalVar));
                    break;
                default:
                    throw new InvalidPetException();
            }
            health = pet.getHealth();
            painLevel = pet.getPainLevel();
            pet.speak();
            int treatTime = pet.treat();
            String timeOut = addTime(appointmentTime,treatTime);
            output = output + String.format("%s,%s,%s,Day %d,%s,%s,%s,%d\n",name,typeOfPet,personalVar,day,appointmentTime,timeOut,health,painLevel);
        }
        read.close();
        input.close();
        return output;
    }
    public boolean addToFile(String patientInfo){
        Scanner read = null;
        PrintWriter printread = null;
        String output ="";
        try{
            read = new Scanner(patientFile);
            boolean newPet = true;
            int firstDelimiter = patientInfo.indexOf(",");
            String name = patientInfo.substring(0,firstDelimiter);
            while(read.hasNextLine()){
                String line = read.nextLine();
                if(line.startsWith(name)){
                    newPet = false;
                    int currentDm = firstDelimiter;
                    for(int i =2; i<=3; i++){
                        int nextDm = patientInfo.indexOf(",",currentDm+1);
                        currentDm =nextDm;
                    }
                    line = line +patientInfo.substring(currentDm);
                }
                output = output+(line + "\n");
            }
            if(newPet){
                output = output + patientInfo;
            }
            read.close();
            printread = new PrintWriter(patientFile);
            printread.print(output);
            return true;
        }catch(Exception e){
            return false;
        }finally{
            if(read != null){
                read.close();
            }
            if(printread != null);
            printread.close();
        }
    }
    private static String addTime(String timeIn, int treaTime){
        int hours = Integer.parseInt(timeIn.substring(0,2));
        int minutes = Integer.parseInt(timeIn.substring(2));
        int hourOut = hours + (minutes+treaTime)/60;
        int minOut = (minutes+treaTime)%60;
        String output ="";
        output = output + ((hourOut < 10) ? ("0" + hourOut) : hourOut);
        output = output + ((minOut < 10) ? ("0" + minOut) : minOut);
        return output;
    }
}
