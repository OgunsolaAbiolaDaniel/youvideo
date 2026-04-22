package youvideo.core;
import youvideo.podcast.Podcast;
import youvideo.show.Show;
import youvideo.video.PublishableVideo;
import dataStructures.*;
import youvideo.video.VideoClass;

public class YouvideoClass implements Youvideo {
    private Array<VideoClass> videos;
    private Array<Podcast> podcasts;
    private Array<Show> shows;

    public YouvideoClass() {
        videos = new ArrayClass<>();
        podcasts = new ArrayClass<>();
        shows = new ArrayClass<>();
    }

    /*
    * findVideoById(String id)
•
findPodcastByTitle(String title)
•
findShowByTitle(String title)
•
videoIdExists(String id)
•
podcastTitleExists(String title)
•
showTitleExists(String title)
    * */

    @Override
    public boolean videoIdExist(String uid) {
        for (int i = 0; i < videos.size(); i++) {
            if (videos.get(i).getUid().equals(uid)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void createPublishable(String id, int duration, String url, String publisher, String title, String langCode) {
         videos.insertLast(new PublishableVideo(id, String.valueOf(duration), url, langCode, title, publisher));
    }

    @Override
    public void createPremium(String id, String duration, String url, String publisher, String title, String langCode, String subUrl, String subLang) {

    }

    @Override
    public void addSubtitle(String videoId, String subtitleUrl, String subtitleLanguage) {

    }

    @Override
    public void getVideo(String videoId) {

    }

    @Override
    public void subtitles(String videoId) {

    }

    @Override
    public void createPodcast(String title, String author, String langCode) {

    }

    @Override
    public void addEpisode(String podcastTitle, String episodeId, int duration, String url, String releaseDate) {

    }

    @Override
    public void getPodcast(String title) {

    }

    @Override
    public void episodes(String title) {

    }

    @Override
    public void authorPodcasts(String authorName) {

    }

    @Override
    public void removePodcast(String title) {

    }

    @Override
    public void createShow(String author, String videoId, String transmissionDate) {

    }

    @Override
    public void getShow(String title) {

    }

    @Override
    public void removeShow(String title) {

    }

    @Override
    public void removeVideo(String videoId) {

    }
}
