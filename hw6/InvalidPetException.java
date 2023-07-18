import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
public class InvalidPetException extends RuntimeException{
    public InvalidPetException(){
       super("Your pet is invalid!");
    }
    public InvalidPetException(String s){
        super(s);
    }
}
