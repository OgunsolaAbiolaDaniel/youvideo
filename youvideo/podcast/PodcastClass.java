package youvideo.podcast;

import dataStructures.Array;
import dataStructures.ArrayClass;
import youvideo.video.EpisodeClass;


/**
 * Default implementation of a podcast.
 */
public class PodcastClass implements Podcast {
    private String title;
    private String author;
    private String language;
    private  Array<EpisodeClass> vid_collection;

    /**
     * Creates an empty podcast.
     *
     * @param title unique title of the podcast
     * @param author author responsible for the podcast
     * @param language language code of the podcast
     */
    public PodcastClass(String title, String author, String language){
        this.title=title;
        this.author= author;
        this.language = language;
        vid_collection= new ArrayClass<EpisodeClass>();
    }

    /**
     * {@inheritDoc}
     */
    public String getTitle(){
        return this.title;
    }

    /**
     * {@inheritDoc}
     */
    public String getAuthor(){
        return this.author;
    }

    /**
     * {@inheritDoc}
     */
    public String getLanguage(){
        return this.language;
    }

    /**
     * {@inheritDoc}
     */
    public Array<EpisodeClass> getEpisodes(){
        return this.vid_collection;
    }

    /**
     * {@inheritDoc}
     */
    public void addEpisode(EpisodeClass episode){
        vid_collection.insertLast(episode);
    }
}
