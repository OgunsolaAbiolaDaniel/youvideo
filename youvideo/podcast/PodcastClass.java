package youvideo.podcast;

import dataStructures.Array;
import dataStructures.ArrayClass;
import youvideo.video.EpisodeClass;


public class PodcastClass implements Podcast {
    private String title;
    private String author;
    private String language;
    private  Array<EpisodeClass> vid_collection;



    public PodcastClass(String title, String author, String language){
        this.title=title;
        this.author= author;
        this.language = language;
        vid_collection= new ArrayClass<EpisodeClass>();
    }

    public String getTitle(){
        return this.title;
    }

    public String getAuthor(){
        return this.author;
    }
    public String getLanguage(){
        return this.language;
    }

}
