import java.util.Set;

public class ImageV {
    private Set<String> tags;
    private int id;

    public ImageV(int id, Set<String> tags){
        this.id = id;
        this.tags = tags;
    }

    public int getNumberOfTags(){
        return tags.size();
    }

    public int getId(){
        return id;
    }

}
