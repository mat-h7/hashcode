import java.util.Set;

public class Image {
    private Set<String> tags;
    private Orientation orientation;

    public Image(Orientation orientation, Set<String> tags){
        this.orientation = orientation;
        this.tags = tags;
    }


    public Orientation getOrientation(){
        return orientation;
    }

    public Set<String> getTags(){
        return tags;
    }

    public enum Orientation{
        H, V
    }
}
