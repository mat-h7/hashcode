import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Set;

public class OutputHandler {

    private PrintStream printStream;
    private PrintStream output;
    private Set<Slide> verticalSlides;
    private Set<Slide> horizontalSlides;

    public OutputHandler(Set<Slide> verticalSlides, Set<Slide> horizontalSlides, PrintStream output) {
        this.verticalSlides = verticalSlides;
        this.horizontalSlides = horizontalSlides;
        this.output = output;
    }

    public void output(Set<Slide> slides) {
        output.println(slides.size());
        for (Slide s : slides) {
            output.println(s.getId());
        }
    }

    /*public OutputHandler(String path, List<Slide> slides) {
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
    }*/


}
