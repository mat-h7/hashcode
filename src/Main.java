import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {


    public static void main(String[] args) throws FileNotFoundException {
        Scanner input;
        int numOfTags;
        int index = 0;
        Set<Image> V = new HashSet<>();
        Set<Image> H = new HashSet<>();

        input = new Scanner(new File(args[4]));
        if (input.nextInt() == 0) {
            return;
        }

        while (input.hasNext()) {
            switch (input.next()) {
                case "H":
                    numOfTags = input.nextInt();
                    Set<String> setH = new HashSet<>();
                    for (int i = 0; i < numOfTags; i++) {
                        setH.add(input.next());
                    }
                    Image imageH = new Image(Orientation.H, index, setH);
                    H.add(imageH);
                    index++;
                    break;
                case "V":
                    numOfTags = input.nextInt();
                    Set<String> setV = new HashSet<>();
                    for (int i = 0; i < numOfTags; i++) {
                        setV.add(input.next());
                    }
                    Image imageV = new Image(Orientation.V, index, setV);
                    V.add(imageV);
                    index++;
            }
        }
        Processor processor = new Processor(V, H);
        OutputHandler handler = new OutputHandler(processor.generateSlides(), new PrintStream(new File("Data/outputE.txt")));
    }
}
