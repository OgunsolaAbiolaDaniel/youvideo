package youvideo.subtitle;

public class SubtitleClass implements Subtitle{
    private String language;
    private String videoId;
    private String subtitleUrl;

    public SubtitleClass(String language, String videoId, String subtitleUrl){
        this.language = language;
        this.videoId = videoId;
        this.subtitleUrl = subtitleUrl;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setSubtitleUrl(String subtitleUrl) {
        this.subtitleUrl = subtitleUrl;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getSubtitleUrl() {
        return subtitleUrl;
    }
    public String getLanguage() {
        return language;
    }

    public String getVideoId() {
        return videoId;
    }
}
