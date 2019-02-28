import java.util.*;

public class Processor {
    private Scanner input;
    private Set<Image> verticalImagesSet;
    private Set<Image> horizontalImagesSet;
    private Queue<Image> verticalQueue;
    private Queue<Image> horizontalQueue;
    private Set<Slide> verticalSlides = new HashSet<>();
    private Set<Slide> horizontalSlides = new HashSet<>();


    public Processor(Set<Image> verticalImages, Set<Image> horizontalImages){
        this.verticalImagesSet = verticalImages;
        this.horizontalImagesSet = horizontalImages;
        if(!verticalImages.isEmpty()){
            this.verticalQueue = createQueue(verticalImagesSet);
        }else{
            verticalQueue = new ArrayDeque<>();
        }
        //this.horizontalQueue = createQueue(horizontalImagesSet);
        createSlides();
    }

    public void createSlides(){
        if(!verticalQueue.isEmpty()){
            Queue<Image> queueVertical = verticalQueue;
            while(!queueVertical.isEmpty()){
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

    public Set<Slide> getVerticalSlides(){
        return verticalSlides;
    }

    public Set<Slide> getHorizontalSlides(){
        return horizontalSlides;
    }

    private Slide getFirst() {
        Slide slide = null;
        for (Slide s:horizontalSlides) {
            horizontalSlides.remove(s);
            slide = s;
            break;
        }
        return slide;
    }

    private static Comparator<Image> slideComparator = new Comparator<Image>() {
        @Override
        public int compare(Image o1, Image o2) {
            return (int) o1.getId() - o2.getId();
        }
    };

    public List<Slide> generateSlides(){
        List<Slide> slides = new ArrayList<>();
        slides.addAll(verticalSlides);
        slides.addAll(horizontalSlides);
        Collections.sort(slides, new Comparator<Slide>() {
            @Override
            public int compare(Slide o1, Slide o2) {
                return o1.getTags().size() - o2.getTags().size();
            }
        });
        return slides;
    }

    public List<Slide> generateSlides2(){
        List<Slide> slides = generateSlides();
        List<Slide> slides1 = slides.subList(0, slides.size()/2);
        List<Slide> slides2 = slides.subList(slides.size() / 2, slides.size());
        List<Slide> slides3 = new ArrayList<>();
        for(int i = 0; i < Math.max(slides1.size(), slides2.size()); i++){
            if(i < slides1.size()){
                slides3.add(slides1.get(i));
            }
            if(i < slides2.size()){
                slides3.add(slides2.get(i));

            }
        }
        return slides3;
    }

    public List<Slide> generateSlideshow() {
        List<Slide> slideshow = new ArrayList<>();
        Set<Slide> combined = new HashSet<>();
        slideshow.add(getFirst());
        combined.addAll(horizontalSlides);
        combined.addAll(verticalSlides);

        while (!combined.isEmpty()) {
            Slide bestSlide = null;
            int maxScore = 0;
            for (Slide s:combined) {
                Slide current = slideshow.get(slideshow.size() - 1);
                if (current.calculateScore(s) > maxScore) {
                    maxScore = current.calculateScore(s);
                    bestSlide = s;
                }
            }
            slideshow.add(bestSlide);
            combined.remove(bestSlide);
        }

        return slideshow;

    }


}
