package youvideo;

/**
 * Default implementation of a subtitle attached to a premium video.
 */
public class SubtitleClass implements Subtitle {
    private String language;
    private String videoId;
    private String subtitleUrl;

    /**
     * Creates a subtitle entry.
     *
     * @param language language code of the subtitle
     * @param videoId identifier of the video that owns the subtitle
     * @param subtitleUrl URL of the subtitle file
     */
    public SubtitleClass(String language, String videoId, String subtitleUrl){
        this.language = language;
        this.videoId = videoId;
        this.subtitleUrl = subtitleUrl;
    }

    /**
     * {@inheritDoc}
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * {@inheritDoc}
     */
    public void setSubtitleUrl(String subtitleUrl) {
        this.subtitleUrl = subtitleUrl;
    }

    /**
     * {@inheritDoc}
     */
    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    /**
     * {@inheritDoc}
     */
    public String getSubtitleUrl() {
        return subtitleUrl;
    }

    /**
     * {@inheritDoc}
     */
    public String getLanguage() {
        return language;
    }

    /**
     * {@inheritDoc}
     */
    public String getVideoId() {
        return videoId;
    }
}
