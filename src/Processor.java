import java.util.*;

public class Processor {
    private Scanner input;
    private Set<Image> verticalImagesSet;
    private Set<Image> horizontalImagesSet;
    private Queue<Image> verticalQueue;
    private Queue<Image> horizontalQueue;
    private Set<Slide> slides = new HashSet<>();

    public Processor(Set<Image> verticalImages, Set<Image> horizontalImages){
        this.verticalImagesSet = verticalImages;
        this.horizontalImagesSet = horizontalImages;
        this.verticalQueue = createQueue(verticalImagesSet);
        this.horizontalQueue = createQueue(horizontalImagesSet);
        createSlides();
    }

    public void createSlides(){
        Queue<Image> queue = (ArrayDeque<Image>) verticalQueue;
        while(!queue.isEmpty()){
            Image first = ((ArrayDeque<Image>) queue).getFirst();
            Image last = ((ArrayDeque<Image>) queue).getLast();
            slides.add(new Slide(first, last));
        }
    }

    private Queue<Image> createQueue(Set<Image> set){
        Queue<Image> pQueue = new PriorityQueue<>(set.size(), idComparator);
        pQueue.addAll(set);
        Queue<Image> result = new ArrayDeque<>();
        result.addAll(pQueue);
        System.out.println(((ArrayDeque<Image>) result).getLast().getId());
        System.out.println(((ArrayDeque<Image>) result).getFirst().getId());

        return result;
    }

    private static Comparator<Image> idComparator = new Comparator<Image>() {
        @Override
        public int compare(Image o1, Image o2) {
            return (int) o1.getId() - o2.getId();
        }
    };

    public Set<Slide> getSlides(){
        return slides;
    }
    
}
