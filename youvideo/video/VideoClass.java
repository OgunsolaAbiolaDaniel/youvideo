package youvideo.video;

/**
 * Base abstraction for all video content managed by the platform.
 * <p>
 * A video stores the data shared by publishable videos and podcast episodes:
 * identifier, duration, file location and language metadata.
 */
public abstract class VideoClass {
    protected String uid;
    protected int duration;
    protected String fileLocation;
    protected String language;

    /**
     * Builds a new video with the common data used across the system.
     *
     * @param uid unique identifier of the video
     * @param duration playback duration in minutes
     * @param fileLocation URL or file location of the video content
     * @param language two-letter language code, or an empty string for episodes
     */
    public VideoClass(String uid, int duration, String fileLocation, String language){
        this.uid = uid;
     this.duration= duration;
     this.fileLocation = fileLocation;
     this.language= language;
    }

    /**
     * Returns the unique identifier of the video.
     *
     * @return the video identifier
     */
    public String getUid() {
        return uid;
    };

    /**
     * Returns the language code associated with the video.
     *
     * @return the language code, or an empty string for episodes
     */
    public String getLanguage() {
        return language;
    };

    /**
     * Returns the duration of the video in minutes.
     *
     * @return the video duration
     */
    public int getDuration() {
        return duration;
    };

    /**
     * Returns the location of the video file.
     *
     * @return the file location or URL
     */
    public String getFileLocation() {
        return fileLocation;
    };
}
