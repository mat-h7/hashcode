import java.util.Set;

public class ImageH {
    private Set<String> tags;

    public ImageH(Set<String> tags){
        this.tags = tags;
    }

    public int getNumberOfTags(){
        return tags.size();
    }

}
