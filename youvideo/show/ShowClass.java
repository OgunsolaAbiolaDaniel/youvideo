package youvideo.show;

import youvideo.video.PublishableVideo;

public class ShowClass implements Show {
    private final String title;
    private final String author;
    private final String transmissionDate;
    private final PublishableVideo video;

    public ShowClass(String author, String transmissionDate, PublishableVideo video) {
        this.title = video.getTitle();
        this.author = author;
        this.transmissionDate = transmissionDate;
        this.video = video;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getTransmissionDate() {
        return transmissionDate;
    }

    public PublishableVideo getVideo() {
        return video;
    }
}
