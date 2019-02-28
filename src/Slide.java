import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Slide {

    private Image img1, img2;
    private Orientation orientation;
    private Slide next;
    private Set<String> tags;

    public Slide(Image img) {
        this.img1 = img;
        orientation = Orientation.H;
        tags = img.getTags();
    }

    public Slide(Image img1, Image img2) {
        this.img1 = img1;
        this.img2 = img2;
        orientation = Orientation.V;
        tags = img1.getTags();
        tags.addAll(img2.getTags());
    }

    public Image getImg1() {
        return img1;
    }

    public Image getImg2() {
        return img2;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public Slide getNext() {
        return next;
    }

    public List<Integer> getId() {
        List<Integer> ids = new ArrayList<>();
        ids.add(img1.getId());
        if (img2 != null) {
            ids.add(img2.getId());
        }
        return ids;
    }

    public Set<String> getTags() {
        return tags;
    }

    public int calculateScore(Slide other) {
        int uniqueS1 = 0, uniqueS2 = 0, intersection = 0;
        Set<String> combined = new HashSet<>();

        combined.addAll(tags);
        combined.addAll(other.getTags());

        for (String s : combined) {
            if (tags.contains(s) && other.getTags().contains(s)) {
                intersection++;
            } else if (tags.contains(s)) {
                uniqueS1++;
            } else {
                uniqueS2++;
            }
        }

        return Math.min(uniqueS1, Math.min(uniqueS2, intersection));
    }
}
