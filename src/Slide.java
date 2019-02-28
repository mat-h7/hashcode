public class Slide {

    private enum Type {
        Horizontal,
        Vertical
    }

    private Image img1, img2;
    private Type type;
    private Slide next;
    private int[] id;

    public Slide(Image image) {
        img1 = image;
        type = Type.Horizontal;
        id = new int[1];
        id[0] = image.
    }

    public Slide(Image img1, Image img2) {
        this.img1 = img1;
        this.img2 = img2;
        type = Type.Vertical;
    }

    public Image getImg1() {
        return img1;
    }

    public Image getImg2() {
        return img2;
    }

    public Type getType() {
        return type;
    }

    public Slide getNext() {
        return next;
    }

    public int getId() {
        return id;
    }
}
