package youvideo.video;

public class EpisodeClass extends VideoClass {
        private int date;

    public EpisodeClass(String uid, int duration, String fileLocation, String language, int date) {
        super(uid, duration, fileLocation, language);
        this.date= date;
    }
}
