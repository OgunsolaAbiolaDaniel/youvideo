package youvideo.show;

import youvideo.video.PublishableVideo;

/**
 * Models a scheduled transmission of a publishable video.
 */
public interface Show {
    /**
     * Returns the title used to identify the show.
     *
     * @return the show title
     */
    String getTitle();

    /**
     * Returns the author responsible for the show.
     *
     * @return the author name
     */
    String getAuthor();

    /**
     * Returns the transmission date of the show.
     *
     * @return the transmission date
     */
    String getTransmissionDate();

    /**
     * Returns the publishable video used by the show.
     *
     * @return the referenced video
     */
    PublishableVideo getVideo();
}
