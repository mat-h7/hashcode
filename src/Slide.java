import java.util.ArrayList;
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
        Set<String> copyOf1 = Set.copyOf(tags);
        copyOf1.removeAll(other.getTags());

        Set<String> copyOf2 = Set.copyOf(other.getTags());
        copyOf2.removeAll(tags);

        Set<String> intersection = Set.copyOf(tags);
        intersection.retainAll(other.getTags());

        return Math.min(copyOf1.size(), Math.min(copyOf2.size(), intersection.size()));
    }
}
