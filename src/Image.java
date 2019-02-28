import java.util.Set;

public class Image {
    private Set<String> tags;
    private Orientation orientation;
    private int id;

    public Image(Orientation orientation, int id, Set<String> tags){
        this.orientation = orientation;
        this.id = id;
        this.tags = tags;
    }


    public void setOrientation(Orientation orientation){
        this.orientation = orientation;
    }


    public Orientation getOrientation(){
        return orientation;
    }

    public Set<String> getTags(){
        return tags;
    }

    public int getId(){
        return id;
    }

    public enum Orientation{
        H, V
    }
}
