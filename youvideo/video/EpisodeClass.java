package youvideo.video;

public class EpisodeClass extends VideoClass {
    private final String releaseDate;

    public EpisodeClass(String uid, int duration, String fileLocation, String releaseDate) {
        super(uid, duration, fileLocation, "");
        this.releaseDate = releaseDate;
    }

    public String getReleaseDate() {
        return releaseDate;
    }
}
