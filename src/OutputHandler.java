import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.sql.SQLOutput;
import java.util.List;

public class OutputHandler {

    private PrintStream printStream;
    private OutputStream outputStream;

    public OutputHandler(String path, List<Slide> slides) {
        try {
            outputStream = new FileOutputStream(path);
            printStream = new PrintStream(outputStream);
        }
        catch (FileNotFoundException e) {
            System.out.printf("Invalid path!");
        }
        catch (NullPointerException e) {
            System.out.println("outputStream is null");
        }
    }



}
