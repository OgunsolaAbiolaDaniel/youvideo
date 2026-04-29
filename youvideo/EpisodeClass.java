package youvideo;

/**
 * Represents a podcast episode stored as a non-publishable video.
 */
public class EpisodeClass extends VideoClass {
    private final String releaseDate;

    /**
     * Creates a new podcast episode.
     *
     * @param uid unique identifier of the episode
     * @param duration playback duration in minutes
     * @param fileLocation URL or file location of the episode
     * @param releaseDate release date in {@code YYYY-MM-DD} format
     */
    public EpisodeClass(String uid, int duration, String fileLocation, String releaseDate) {
        super(uid, duration, fileLocation, "");
        this.releaseDate = releaseDate;
    }

    /**
     * Returns the release date of the episode.
     *
     * @return the release date
     */
    public String getReleaseDate() {
        return releaseDate;
    }
}
