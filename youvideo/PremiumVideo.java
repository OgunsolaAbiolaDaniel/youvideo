package youvideo;
import dataStructures.*;

/**
 * Specialized publishable video with subtitle support.
 * <p>
 * Premium videos keep subtitles in insertion order and may contain more than
 * one subtitle for the same language.
 */
public class PremiumVideo extends PublishableVideo {
    private final Array<Subtitle> subtitles ;

    /**
     * Creates a premium video with its initial subtitle.
     *
     * @param uid unique identifier of the video
     * @param duration playback duration in minutes
     * @param fileLocation URL or file location of the video
     * @param language primary language code of the video
     * @param title title of the premium video
     * @param publisher publisher responsible for the video
     * @param subtitleUrl URL of the initial subtitle file
     * @param subtitleLang language code of the initial subtitle
     */
    public PremiumVideo(String uid, int duration, String fileLocation, String language, String title, String publisher,String subtitleUrl,String subtitleLang){
        super(uid, duration, fileLocation, language, title, publisher);
        this.subtitles= new ArrayClass<Subtitle>();
        subtitles.insertLast(new SubtitleClass(subtitleLang,uid,subtitleUrl));
    }

    /**
     * Returns the subtitles associated with this premium video.
     *
     * @return the subtitle collection in insertion order
     */
    public Array<Subtitle> getSubtitles() {
        return subtitles;
    }

    /**
     * Adds a subtitle to this premium video.
     *
     * @param v_uid identifier of the video owning the subtitle
     * @param subtitleUrl URL of the subtitle file
     * @param subtitleLanguage language code of the subtitle
     */
    public void addSubtitle(String v_uid ,String subtitleUrl,String subtitleLanguage) {
        subtitles.insertLast(new SubtitleClass(subtitleLanguage,v_uid, subtitleUrl));
    }
}
