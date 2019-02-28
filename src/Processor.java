import java.util.Queue;
import java.util.Scanner;

public class Processor {
    private Scanner input;
    private Queue<ImageV> verticalImages;
    private Queue<ImageH> horizontalImages;

    public Processor(Queue<ImageV> verticalImages, Queue<ImageH> horizontalImages){
        this.verticalImages = verticalImages;
        this.horizontalImages = horizontalImages;
    }


}
