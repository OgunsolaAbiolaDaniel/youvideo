package youvideo;

import java.util.HashMap;
import java.util.Map;

import java.util.List;
import java.util.ArrayList;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class YouvideoClass implements Youvideo {
    private Map<String, VideoClass> videos;
    private Map<String, Podcast> podcasts;
    private Map<String, ShowClass> shows;

    public YouvideoClass() {
        /*
         * phase 1- videos = new ArrayClass<>(); podcasts = new ArrayClass<>(); shows =
         * new ArrayClass<>();
         */

        // phase 2
        videos = new HashMap<>();
        podcasts = new HashMap<>();
        shows = new HashMap<>();

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
        // for (int i = 0; i < videos.size(); i++) {
        // if (videos.con(i).getUid().equalsIgnoreCase(uid)) {
        // return true;
        // }
        // }
        // before we need to ignore case the search in hashmap simplifies things
        return videos.containsKey(uid.toLowerCase());
    }

    //instance of checker ..for me to be able to know if its an instance of a class
    public boolean isVideoInstance(String videoId, Class<?> targetClass) {
        // for (int i = 0; i < videos.size(); i++) {
        // VideoClass video = videos.get(i);
        // if (video.getUid().equalsIgnoreCase(videoId)) {
        // return targetClass.isInstance(video);
        // }
        // }
        VideoClass video = videos.get(videoId.toLowerCase());
        if (video != null) {
            return targetClass.isInstance(video);
        }
        return false;
    }

    public VideoClass findVideoById(String videoId) {

        /*
         * for (int i = 0; i < videos.size(); i++) { VideoClass video = videos.get(i);
         * if (video.getUid().equalsIgnoreCase(videoId)) { return video; } } return
         * null;
         */
        return videos.get(videoId.toLowerCase());

    }

    @Override
    public void createPublishable(String id, int duration, String url, String publisher, String title,
            String langCode) {
        videos.put(id.toLowerCase(), new PublishableVideo(id, duration, url, langCode, title, publisher));
    }

    @Override
    public void createPremium(String id, int duration, String url, String publisher, String title, String langCode,
            String subUrl, String subLang) {
        videos.put(id.toLowerCase(), new PremiumVideo(id, duration, url, langCode, title, publisher, subUrl, subLang));
    }

    @Override
    public void addSubtitle(String videoId, String subtitleUrl, String subtitleLanguage) {
          PremiumVideo video = (PremiumVideo) findVideoById(videoId);
          video.addSubtitle(videoId,subtitleUrl,subtitleLanguage);
      }

      /**
       * check if podcast exist;
       */
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
        List<EpisodeClass> episodes = podcast.getEpisodes();
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
        podcasts.put(title.toLowerCase(), new PodcastClass(title, author, langCode));
        // podcasts.insertLastnew PodcastClass(title,author,langCode));
    }

    @Override
    public void addEpisode(String podcastTitle, String episodeId, int duration, String url, String releaseDate) {
        Podcast podcast = findPodcastByTitle(podcastTitle);
        if (podcast == null) {
            return;
        }
        EpisodeClass episode = new EpisodeClass(episodeId, duration, url, releaseDate);
        podcast.addEpisode(episode);
        videos.put(episodeId.toLowerCase(), episode);
    }

    @Override
    public Podcast findPodcastByTitle(String title) {
        // for (int i = 0; i < podcasts.size(); i++) {
        // if (podcasts.get(i).getTitle().equalsIgnoreCase(title)) {
        // return podcasts.get(i);
        // }
        // }
        return podcasts.get(title.toLowerCase());
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
        /*
         * "we don't need this any longer"-- Abiola int podcastIndex =
         * findPodcastIndexByTitle(title); if (podcastIndex < 0) { return; }
         * 
         * Array<EpisodeClass> episodes = podcasts.get(podcastIndex).getEpisodes(); for
         * (int i = 0; i < episodes.size(); i++) {
         * removeVideoById(episodes.get(i).getUid()); } podcasts.removeAt(podcastIndex);
         */

        PodcastClass podcast = (PodcastClass) findPodcastByTitle(title);
        if (podcast == null)
            return;

        for (EpisodeClass ep : podcast.getEpisodes()) {
            videos.remove(ep.getUid().toLowerCase());
        }
        podcasts.remove(title.toLowerCase());

    }

    @Override
    public void createShow(String author, String videoId, String transmissionDate) {
        /*
         * VideoClass video = findVideoById(videoId); if (!(video instanceof
         * PublishableVideo)) { return; }
         */
        VideoClass video = findVideoById(videoId);
        if (!(video instanceof PublishableVideo)) {
            return;
        }
        shows.put(video.getTitle().toLowerCase(), new ShowClass(author, transmissionDate, (PublishableVideo) video));
    }

    @Override
    public void getShow(String title) {
        findShowByTitle(title);
    }

    @Override
    public void removeShow(String title) {
        // int showIndex = findShowIndexByTitle(title);
        // if (showIndex >= 0) {
        // shows.removeAt(showIndex);
        // }
        shows.remove(title.toLowerCase());
    }

    @Override
    public void removeVideo(String videoId) {
        videos.remove(videoId.toLowerCase());
    }

    @Override
    public boolean showTitleExist(String title) {
        return findShowByTitle(title) != null;
    }

    @Override
    public Show findShowByTitle(String title) {
        // for (int i = 0; i < shows.size(); i++) {
        // if (shows.get(i).getTitle().equalsIgnoreCase(title)) {
        // return shows.get(i);
        // }
        // }
        return shows.get(title.toLowerCase());
    }

    @Override
    public List<Podcast> podcastsByAuthor(String authorName) {
        // change to list
        List<Podcast> authorPodcasts = new ArrayList<>();
        // for (int i = 0; i < podcasts.size(); i++) {
        // Podcast podcast = podcasts.get(i);
        // if (podcast.getAuthor().equalsIgnoreCase(authorName)) {
        // authorPodcasts.insertLast(podcast);
        // }
        // }
        // since its array list we rather use a for each loop
        for (Podcast podcast : podcasts.values()) {
            if (podcast.getAuthor().equalsIgnoreCase(authorName)) {
                authorPodcasts.add(podcast);
            }
        }
        return authorPodcasts;
    }


    @Override
    public boolean isVideoUsedInShow(String videoId) {
        for (ShowClass show : shows.values()) {
            if (show.getVideo().getUid().equalsIgnoreCase(videoId)) {
                return true;
            }
        }
        return false;
    };

    @Override
    public void addTag(String title, String tag) {
        PodcastClass podcast = (PodcastClass) findPodcastByTitle(title);
        ShowClass show = (ShowClass) findShowByTitle(title);
        if (podcast != null)
            podcast.addTag(tag);
        if (show != null)
            show.addTag(tag);
    }

    @Override
    public void removeTag(String title, String tag) {
        PodcastClass podcast = (PodcastClass) findPodcastByTitle(title);
        ShowClass show = (ShowClass) findShowByTitle(title);
        if (podcast != null)
            podcast.removeTag(tag);
        if (show != null)
            show.removeTag(tag);
    }

    @Override
    public boolean titleExists(String title) {
        return findPodcastByTitle(title) != null || findShowByTitle(title) != null;
    }

    @Override
    public boolean isAlreadyTagged(String title, String tag) {
        PodcastClass podcast = (PodcastClass) findPodcastByTitle(title);
        ShowClass show = (ShowClass) findShowByTitle(title);
        if (podcast != null && podcast.hasTag(tag))
            return true;
        if (show != null && show.hasTag(tag))
            return true;
        return false;
    }

}
