package youvideo.video;

public class PublishableVideo extends VideoClass {
    protected String title;
    protected String publisher;

    public PublishableVideo(String uid, int duration, String fileLocation, String language, String title, String publisher) {
        super(uid, duration, fileLocation, language);
        this.title= title;
        this.publisher = publisher;
    }

    public String getTitle() {
        return title;
    };
    public String getPublisher(){
        return publisher;
    }
}
