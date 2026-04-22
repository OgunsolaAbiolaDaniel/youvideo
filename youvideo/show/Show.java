package youvideo.show;

import youvideo.video.PublishableVideo;

public interface Show {
    String getTitle();
    String getAuthor();
    String getTransmissionDate();
    PublishableVideo getVideo();
}
