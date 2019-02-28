import java.util.ArrayList;
import java.util.List;

public class Slide {

    private Image img1, img2;
    private Orientation orientation;
    private Slide next;

    public Slide(Image image) {
        img1 = image;
        orientation = Orientation.H;
    }

    public Slide(Image img1, Image img2) {
        this.img1 = img1;
        this.img2 = img2;
        orientation = Orientation.V;
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
}
