import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        if(args.length == 1){
            try{
                Scanner input = new Scanner(new File(args[0]));

            }catch(FileNotFoundException e){
                System.out.println("File with name: " + args[0] + " not found");
            }
        }else{
            throw new RuntimeException("Please enter a file name");
        }

    }
}
