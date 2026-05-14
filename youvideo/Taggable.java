package youvideo;

import java.util.Set;

public interface Taggable {

    /**
     * to add tag to show or podcast
     * 
     * @param tag
     * @return
     */
    void addTag(String tag);

    /**
     * to remove tag from show or podcast
     * 
     * @param tag
     */
    void removeTag(String tag);

    /**
     * check if show or podcast has tag
     * 
     * @param tag
     * 
     * @return
     */
    boolean hasTag(String tag);

    /**
     * to get all tags from show or podcast
     * 
     * @return
     */
    Set<String> getTags();

    /**
     * to get title from show or podcast
     * 
     * @return
     */
    String getTitle();
}
