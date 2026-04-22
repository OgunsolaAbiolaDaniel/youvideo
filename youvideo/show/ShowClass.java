package youvideo.show;

import youvideo.video.PublishableVideo;

/**
 * Default implementation of a show.
 */
public class ShowClass implements Show {
    private final String title;
    private final String author;
    private final String transmissionDate;
    private final PublishableVideo video;

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
}
