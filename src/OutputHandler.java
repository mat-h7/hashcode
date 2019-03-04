import java.io.PrintStream;
import java.util.List;

public class OutputHandler {

    private PrintStream output;

    public OutputHandler(List<Slide> slides, PrintStream output) {
        this.output = output;
        output(slides);
    }

    public void output(List<Slide> slides) {
        output.println(slides.size());
        for (Slide s : slides) {
            if (s.getId().size() == 2) {
                output.print(s.getId().get(0) + " ");
                output.print(s.getId().get(1) + "\n");
            } else {
                output.print(s.getId().get(0) + "\n");
            }
        }
    }


}
