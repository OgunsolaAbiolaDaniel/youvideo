package youvideo.subtitle;

public interface Subtitle {
    /**
     * Returns the identifier of the video this subtitle belongs to.
     *
     * @return the associated video identifier
     */
    String getVideoId();

    /**
     * Updates the identifier of the video this subtitle belongs to.
     *
     * @param videoId the associated video identifier
     */
    void setVideoId(String videoId);

    /**
     * Returns the subtitle file URL.
     *
     * @return the subtitle file URL
     */
    String getSubtitleUrl();

    /**
     * Updates the subtitle file URL.
     *
     * @param subtitleUrl the subtitle file URL
     */
    void setSubtitleUrl(String subtitleUrl);

    /**
     * Returns the subtitle language code.
     *
     * @return the subtitle language code
     */
    String getLanguage();

    /**
     * Updates the subtitle language code.
     *
     * @param language the subtitle language code
     */
    void setLanguage(String language);
}
