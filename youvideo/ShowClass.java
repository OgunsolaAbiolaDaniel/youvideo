package youvideo;

import java.util.Set;
import java.util.TreeSet;

/**
 * Default implementation of a show.
 */
public class ShowClass implements Show, Taggable {
    private final String title;
    private final String author;
    private final String transmissionDate;
    private final PublishableVideo video;
    private TreeSet<String> tags;

    /**
     * Creates a new show based on an existing publishable video.
     *
     * @param author author responsible for the show
     * @param transmissionDate scheduled transmission date
     * @param video publishable video referenced by the show
     */
    public ShowClass(String author, String transmissionDate, PublishableVideo video) {
        this.title = video.getTitle();
        this.author = author;
        this.transmissionDate = transmissionDate;
        this.tags = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        this.video = video;
    }

    /**
     * {@inheritDoc}
     */
    public String getTitle() {
        return title;
    }

    /**
     * {@inheritDoc}
     */
    public String getAuthor() {
        return author;
    }

    /**
     * {@inheritDoc}
     */
    public String getTransmissionDate() {
        return transmissionDate;
    }

    /**
     * {@inheritDoc}
     */
    public PublishableVideo getVideo() {
        return video;
    }

    // new methods implementation from my Taggable(phase2)
    /**
     * {@inheritDoc}
     */
    public void addTag(String tag) {
        tags.add(tag);
    }

    /**
     * {@inheritDoc}
     */
    public void removeTag(String tag) {
        tags.remove(tag);
    }

    /**
     * {@inheritDoc}
     */
    public boolean hasTag(String tag) {
        return tags.contains(tag);
    }

    /**
     * {@inheritDoc}
     */
    public Set<String> getTags() {
        return tags;
    };

}
