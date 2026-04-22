package youvideo.video;
import dataStructures.*;
import youvideo.subtitle.Subtitle;

public class PremiumVideo extends PublishableVideo {
    private final Array<Subtitle> subtitles ;
    public PremiumVideo(String uid, String duration, String fileLocation, String language, String title, String publisher){
        super(uid, duration, fileLocation, language, title, publisher);
        this.subtitles= new ArrayClass<Subtitle>();
    }

    public Array<Subtitle> getSubtitles() {
        return subtitles;
    }

    public void addSubtitle(Subtitle subtitle) {
        subtitles.insertLast(subtitle);
    }
}
