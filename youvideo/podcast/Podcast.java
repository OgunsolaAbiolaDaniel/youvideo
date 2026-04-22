package youvideo.podcast;

import dataStructures.Array;
import youvideo.video.EpisodeClass;

public interface Podcast {
   public abstract  String getTitle();
  public abstract  String getLanguage();
   public abstract String getAuthor();
    public Array<EpisodeClass> getEpisodes();
    public void addEpisode(EpisodeClass episode);
}
