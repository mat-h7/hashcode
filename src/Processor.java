import java.util.*;

public class Processor {
    private Scanner input;
    private Set<Image> verticalImagesSet;
    private Set<Image> horizontalImagesSet;
    private Queue<Image> verticalQueue;
    private Queue<Image> horizontalQueue;

    public Processor(Set<Image> verticalImages, Set<Image> horizontalImages){
        this.verticalImagesSet = verticalImages;
        this.horizontalImagesSet = horizontalImages;
        this.verticalQueue = createQueue(verticalImagesSet);
        this.horizontalQueue = createQueue(horizontalImagesSet);
    }

    private Queue<Image> createQueue(Set<Image> set){
        Queue<Image> result = new PriorityQueue<>(set.size(), idComparator);
        result.addAll(set);
        return result;
    }

    private static Comparator<Image> idComparator = new Comparator<Image>() {
        @Override
        public int compare(Image o1, Image o2) {
            return (int) o1.getId() - o2.getId();
        }
    };
    

}
