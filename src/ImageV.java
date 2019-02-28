import java.util.Set;

public class ImageV {
    private Set<String> tags;

    public ImageV(Set<String> tags){
        this.tags = tags;
    }

    public int getNumberOfTags(){
        return tags.size();
    }
    
}
