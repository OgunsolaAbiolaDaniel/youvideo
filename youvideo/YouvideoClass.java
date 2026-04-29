package youvideo;
import dataStructures.*;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

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
            if (videos.get(i).getUid().equalsIgnoreCase(uid)) {
                return true;
            }
        }
        return false;
    }
    //instance of checker ..for me to be able to know if its an instance of a class
    public boolean isVideoInstance(String videoId, Class<?> targetClass) {
        for (int i = 0; i < videos.size(); i++) {
            VideoClass video = videos.get(i);
            if (video.getUid().equalsIgnoreCase(videoId)) {
                return targetClass.isInstance(video);
            }
        }
        return false;
    }

    public VideoClass findVideoById(String videoId) {
        for (int i = 0; i < videos.size(); i++) {
            VideoClass video = videos.get(i);
            if (video.getUid().equalsIgnoreCase(videoId)) {
                return video;
            }
        }
        return null;
    }




    @Override
    public void createPublishable(String id, int duration, String url, String publisher, String title, String langCode) {
         videos.insertLast(new PublishableVideo(id, duration, url, langCode, title, publisher));
    }

    @Override
    public void createPremium(String id, int duration, String url, String publisher, String title, String langCode, String subUrl, String subLang) {
        videos.insertLast(new PremiumVideo(id,duration,url,langCode,title,publisher,subUrl,subLang));
    }

    @Override
    public void addSubtitle(String videoId, String subtitleUrl, String subtitleLanguage) {
          PremiumVideo video = (PremiumVideo) findVideoById(videoId);
          video.addSubtitle(videoId,subtitleUrl,subtitleLanguage);
    }


    /**
     * check if podcast exist;
     * */
    public boolean podcastExist(String title) {
        return findPodcastByTitle(title) != null;
    }
    public boolean episode_Exist(String id) {
        return videoIdExist(id);
    }


    //very tense refrence from copilot ai on how to  check validity of date
    @Override
    public boolean isEpisodeDateValid(String podcastTitle, String releaseDate) {
        Podcast podcast = findPodcastByTitle(podcastTitle);
        if (podcast == null) {
            return false;
        }
        LocalDate newEpisodeDate;
        try {
            newEpisodeDate = LocalDate.parse(releaseDate);
        } catch (DateTimeParseException e) {
            return false;
        }
        Array<EpisodeClass> episodes = podcast.getEpisodes();
        if (episodes.size() == 0) {
            return true;
        }

        String latestReleaseDate = episodes.get(episodes.size() - 1).getReleaseDate();
        //research on how t work with date ..ask prof miguel if there is a simpler approach
        try {
            LocalDate latestEpisodeDate = LocalDate.parse(latestReleaseDate);
            return !newEpisodeDate.isBefore(latestEpisodeDate);
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    @Override
    public void createPodcast(String title, String author, String langCode) {
        podcasts.insertLast(new PodcastClass(title,author,langCode));
    }

    @Override
    public void addEpisode(String podcastTitle, String episodeId, int duration, String url, String releaseDate) {
        Podcast podcast = findPodcastByTitle(podcastTitle);
        if (podcast == null) {
            return;
        }
        EpisodeClass episode = new EpisodeClass(episodeId, duration, url, releaseDate);
        podcast.addEpisode(episode);
        videos.insertLast(episode);
    }

    @Override
    public Podcast findPodcastByTitle(String title) {
        for (int i = 0; i < podcasts.size(); i++) {
            if (podcasts.get(i).getTitle().equalsIgnoreCase(title)) {
                return podcasts.get(i);
            }
        }
        return null;
    }

    @Override
    public void getPodcast(String title) {
        findPodcastByTitle(title);
    }

    @Override
    public void episodes(String title) {
        findPodcastByTitle(title);
    }

    @Override
    public void authorPodcasts(String authorName) {
        podcastsByAuthor(authorName);
    }

    @Override
    public void removePodcast(String title) {
        int podcastIndex = findPodcastIndexByTitle(title);
        if (podcastIndex < 0) {
            return;
        }

        Array<EpisodeClass> episodes = podcasts.get(podcastIndex).getEpisodes();
        for (int i = 0; i < episodes.size(); i++) {
            removeVideoById(episodes.get(i).getUid());
        }
        podcasts.removeAt(podcastIndex);
    }

    @Override
    public void createShow(String author, String videoId, String transmissionDate) {
        VideoClass video = findVideoById(videoId);
        if (!(video instanceof PublishableVideo)) {
            return;
        }
        shows.insertLast(new ShowClass(author, transmissionDate, (PublishableVideo) video));
    }

    @Override
    public void getShow(String title) {
        findShowByTitle(title);
    }

    @Override
    public void removeShow(String title) {
        int showIndex = findShowIndexByTitle(title);
        if (showIndex >= 0) {
            shows.removeAt(showIndex);
        }
    }

    @Override
    public void removeVideo(String videoId) {
        removeVideoById(videoId);
    }

    @Override
    public boolean showTitleExist(String title) {
        return findShowByTitle(title) != null;
    }

    @Override
    public Show findShowByTitle(String title) {
        for (int i = 0; i < shows.size(); i++) {
            if (shows.get(i).getTitle().equalsIgnoreCase(title)) {
                return shows.get(i);
            }
        }
        return null;
    }

    @Override
    public Array<Podcast> podcastsByAuthor(String authorName) {
        Array<Podcast> authorPodcasts = new ArrayClass<>();
        for (int i = 0; i < podcasts.size(); i++) {
            Podcast podcast = podcasts.get(i);
            if (podcast.getAuthor().equalsIgnoreCase(authorName)) {
                authorPodcasts.insertLast(podcast);
            }
        }
        return authorPodcasts;
    }

    @Override
    public boolean isVideoUsedInShow(String videoId) {
        for (int i = 0; i < shows.size(); i++) {
            if (shows.get(i).getVideo().getUid().equalsIgnoreCase(videoId)) {
                return true;
            }
        }
        return false;
    }

    private int findPodcastIndexByTitle(String title) {
        for (int i = 0; i < podcasts.size(); i++) {
            if (podcasts.get(i).getTitle().equalsIgnoreCase(title)) {
                return i;
            }
        }
        return -1;
    }

    private int findShowIndexByTitle(String title) {
        for (int i = 0; i < shows.size(); i++) {
            if (shows.get(i).getTitle().equalsIgnoreCase(title)) {
                return i;
            }
        }
        return -1;
    }

    private void removeVideoById(String videoId) {
        for (int i = 0; i < videos.size(); i++) {
            if (videos.get(i).getUid().equalsIgnoreCase(videoId)) {
                videos.removeAt(i);
                return;
            }
        }
    }
}
