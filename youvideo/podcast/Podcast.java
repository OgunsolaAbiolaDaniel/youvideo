package youvideo.podcast;

import dataStructures.Array;
import youvideo.video.EpisodeClass;

/**
 * Models a podcast and its ordered collection of episodes.
 */
public interface Podcast {
    /**
     * Returns the title that identifies the podcast.
     *
     * @return the podcast title
     */
    public abstract String getTitle();

    /**
     * Returns the language code of the podcast.
     *
     * @return the podcast language code
     */
    public abstract String getLanguage();

    /**
     * Returns the author of the podcast.
     *
     * @return the author name
     */
    public abstract String getAuthor();

    /**
     * Returns the episodes stored in this podcast.
     *
     * @return the episode collection
     */
    public Array<EpisodeClass> getEpisodes();

    /**
     * Adds a new episode to the podcast.
     *
     * @param episode episode to be stored in the podcast
     */
    public void addEpisode(EpisodeClass episode);
}
