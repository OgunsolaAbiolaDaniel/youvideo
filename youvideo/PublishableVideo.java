package youvideo;

/**
 * Represents a video that can exist independently in the platform.
 * <p>
 * Publishable videos add title and publisher information to the base video data.
 */
public class PublishableVideo extends VideoClass {
    protected String title;
    protected String publisher;

    /**
     * Creates a new publishable video.
     *
     * @param uid unique identifier of the video
     * @param duration playback duration in minutes
     * @param fileLocation URL or file location of the video
     * @param language two-letter language code
     * @param title title used to present the video
     * @param publisher name of the publisher responsible for the video
     */
    public PublishableVideo(String uid, int duration, String fileLocation, String language, String title, String publisher) {
        super(uid, duration, fileLocation, language);
        this.title= title;
        this.publisher = publisher;
    }

    /**
     * Returns the title of the publishable video.
     *
     * @return the video title
     */
    public String getTitle() {
        return title;
    };

    /**
     * Returns the publisher of the video.
     *
     * @return the publisher name
     */
    public String getPublisher(){
        return publisher;
    }
}
