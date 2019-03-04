import javax.management.StringValueExp;
import java.util.*;
import java.util.stream.Stream;

public class Processor {
    private Scanner input;
    private Set<Image> verticalImagesSet;
    private Set<Image> horizontalImagesSet;
    private Queue<Image> verticalQueue;
    private Queue<Image> horizontalQueue;
    private Set<Slide> verticalSlides = new HashSet<>();
    private Set<Slide> horizontalSlides = new HashSet<>();
    private List<Slide> slideshow;


    public Processor(Set<Image> verticalImages, Set<Image> horizontalImages) {
        this.verticalImagesSet = verticalImages;
        this.horizontalImagesSet = horizontalImages;
        if (!verticalImages.isEmpty()) {
            this.verticalQueue = createQueue(verticalImagesSet);
        } else {
            verticalQueue = new ArrayDeque<>();
        }
        createSlides();
    }

    public void createSlides() {
        if (!verticalQueue.isEmpty()) {
            Queue<Image> queueVertical = verticalQueue;
            while (!queueVertical.isEmpty()) {
                Image first = ((ArrayDeque<Image>) queueVertical).getFirst();
                ((ArrayDeque<Image>) queueVertical).removeFirst();
                Image last = ((ArrayDeque<Image>) queueVertical).getLast();
                ((ArrayDeque<Image>) queueVertical).removeLast();
                verticalSlides.add(new Slide(first, last));
            }
        }

        Set<Image> setHorizontal = horizontalImagesSet;
        setHorizontal.forEach(e -> horizontalSlides.add(new Slide(e)));
    }

    private Queue<Image> createQueue(Set<Image> set) {
        Queue<Image> pQueue = new PriorityQueue<>(set.size(), idComparator);
        pQueue.addAll(set);
        Queue<Image> result = new ArrayDeque<>();
        result.addAll(pQueue);

        return result;
    }

    private static Comparator<Image> idComparator = new Comparator<Image>() {
        @Override
        public int compare(Image o1, Image o2) {
            return (int) o1.getId() - o2.getId();
        }
    };

    public Set<Slide> getVerticalSlides() {
        return verticalSlides;
    }

    public Set<Slide> getHorizontalSlides() {
        return horizontalSlides;
    }


    public int[][] generateAdjacencyMatrix() {
        Set<Slide> allSlides = new HashSet<>();
        allSlides.addAll(Set.copyOf(getVerticalSlides()));
        allSlides.addAll(Set.copyOf(getHorizontalSlides()));

        int[][] adjacencyMatrix = new int[allSlides.size()][allSlides.size()];

        int i = 0;
        for (Slide s:allSlides) {
            int j = 0;
            for (Slide p:allSlides) {
                if (adjacencyMatrix[i][j] == 0) {
                    adjacencyMatrix[i][j] = s.calculateScore(p);
                    adjacencyMatrix[j][i] = s.calculateScore(p);
                }
                j++;
            }
            i++;
        }
        return adjacencyMatrix;


    public List<Slide> getSlideshow() {
        return slideshow;
    }
}
