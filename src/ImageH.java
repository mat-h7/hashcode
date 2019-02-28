import java.util.Set;

public class ImageH {
    private int id;
    private Set<String> tags;

    public ImageH(int id, Set<String> tags){
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
