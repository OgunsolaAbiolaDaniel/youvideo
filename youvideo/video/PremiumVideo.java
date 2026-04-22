package youvideo.video;
import dataStructures.*;
import youvideo.subtitle.Subtitle;
import youvideo.subtitle.SubtitleClass;

public class PremiumVideo extends PublishableVideo{
    //array of subtitles
    private final Array<Subtitle> subtitles ;


    public PremiumVideo(String uid, int duration, String fileLocation, String language, String title, String publisher,String subtitleUrl,String subtitleLang){
        super(uid, duration, fileLocation, language, title, publisher);
        this.subtitles= new ArrayClass<Subtitle>();
        subtitles.insertLast(new SubtitleClass(subtitleLang,uid,subtitleUrl));
    }

    public Array<Subtitle> getSubtitles() {
        return subtitles;
    }

    public void addSubtitle(String v_uid ,String subtitleUrl,String subtitleLanguage) {
        subtitles.insertLast(new SubtitleClass(subtitleLanguage,v_uid, subtitleUrl));
    }

}
