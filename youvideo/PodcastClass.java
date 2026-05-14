package youvideo;

import java.util.TreeSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;


/**
 * Default implementation of a podcast.
 */
public class PodcastClass implements Podcast, Taggable {
    private String title;
    private String author;
    private String language;
    private TreeSet<String> tags;
    private List<EpisodeClass> vid_collection;

    /**
     * Creates an empty podcast.
     *
     * @param title unique title of the podcast
     * @param author author responsible for the podcast
     * @param language language code of the podcast
     */
    public PodcastClass(String title, String author, String language){
        this.title=title;
        this.author= author;
        this.language = language;
        this.tags = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);// the tags tree set .. using the case insensitive
                                                                 // order from java for auto formatting

        vid_collection = new ArrayList<EpisodeClass>(); // changed to an array list
    }

    /**
     * {@inheritDoc}
     */
    public String getTitle(){
        return this.title;
    }

    /**
     * {@inheritDoc}
     */
    public String getAuthor(){
        return this.author;
    }

    /**
     * {@inheritDoc}
     */
    public String getLanguage(){
        return this.language;
    }

    /**
     * {@inheritDoc}
     */
    public List<EpisodeClass> getEpisodes() {
        return this.vid_collection;
    }

    /**
     * {@inheritDoc}
     */
    public void addEpisode(EpisodeClass episode) {
        vid_collection.addLast(episode);
    }

    // new methods implementation from my Taggable(phase2)
    public void addTag(String tag) {
        tags.add(tag);
    }

    public void removeTag(String tag) {
        tags.remove(tag);
    }

    public boolean hasTag(String tag) {
        return tags.contains(tag);
    }

    public Set<String> getTags() {
        return tags;
    }
}
