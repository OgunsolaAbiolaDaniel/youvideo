import java.util.Scanner;

import dataStructures.Array;
import youvideo.core.*;
import youvideo.podcast.Podcast;
import youvideo.show.Show;
import youvideo.subtitle.Subtitle;
import youvideo.video.EpisodeClass;
import youvideo.video.PremiumVideo;
import youvideo.video.PublishableVideo;
import youvideo.video.VideoClass;

public class Main {

    //commands
    public static final String EXIT = "exit";
    public static final String HELP = "help";
    public static final String CREATE_PUBLISHABLE = "createpublishable";
    public static final String CREATE_PREMIUM = "createpremium";
    public static final String ADD_SUBTITLE = "addsubtitle";
    public static final String GET_VIDEO = "getvideo";
    public static final String SUBTITLES = "subtitles";
    public static final String CREATE_PODCAST = "createpodcast";
    public static final String ADD_EPISODE = "addepisode";
    public static final String GET_PODCAST = "getpodcast";
    public static final String EPISODES = "episodes";
    public static final String AUTHOR_PODCASTS = "authorpodcasts";
    public static final String REMOVE_PODCAST = "removepodcast";
    public static final String CREATE_SHOW = "createshow";
    public static final String GET_SHOW = "getshow";
    public static final String REMOVE_SHOW = "removeshow";
    public static final String REMOVE_VIDEO = "removevideo";

    //messages
    //unknown msg
    public static final String UNKNOWN_COMMAND_MSG = "Unknown command.Type help to see available commands.";
    //exit msg
    public static final String BYE_MSG = "Bye!";
    //miniconstant
    public static final String PREMIUM = "PREMIUM";
    public static final String VIDEO = "Video";
    //help msg
    public static final String HELP_MSG = """
        createpublishable - creates a new publishable video
        createpremium - creates a new publishable Premium video
        addsubtitle - adds subtitle to Premium video
        getvideo - presents publishable video data from its id
        subtitles - Lists Premium video subtitles
        createpodcast - creates a new podcast with no episodes
        addepisode - adds an episode to a podcast
        getpodcast - presents podcast data from its title
        episodes - List podcast episodes
        authorpodcasts - List all podcasts of an author
        removepodcast - removes a podcast
        createshow - creates show using an existing publishable video
        getshow - presents show data from its title
        removeshow - removes a show
        removevideo - removes a publishable video
        help - shows the available commands
        exit - terminates the execution of the program
        """;

    //createpublishable msg
    public static final String VIDEO_CREATED_SUCCESSFULLY = "Video %s created successfully.";
    public static final String INVALID_LANGUAGE_TYPE = "Invalid language type.";
    public static final String INVALID_VALUE = "Invalid value.";
    public static final String VIDEO_ID_EXISTS = "Video with this ID already exists.";

    //createpremium msg
    public static final String INVALID_LANGUAGE_TYPE_IN_SUBTITLE = "Invalid language type in subtitle.";

    //addsubtitle msg
    public static final String SUBTITLE_ADDED_SUCCESSFULLY = "Subtitle added successfully.";
    public static final String VIDEO_NOT_EXIST = "Video does not exist.";
    public static final String PREMIUM_VIDEO_REQUIRED = "This operation requires a Premium video.";

    //getvideo msg
    public static final String VIDEO_INFO = "%s %s %d Title: %s";
    public static final String VIDEO_FILE_INFO = "File: %s Publisher: %s Language: %s";
    public static final String PUBLISHABLE_VIDEO_NOT_EXIST = "Publishable Video %s does not exist.";

    //subtitles msg
    public static final String NO_PREMIUM_VIDEO = "No Premium Video with ID.";
    public static final String SUBTITLES_HEADER = "Subtitles for video %s:";
    public static final String SUBTITLE_INFO = "- %s (%s)";

    //createpodcast msg
    public static final String PODCAST_CREATED_SUCCESSFULLY = "Podcast created successfully.";
    public static final String PODCAST_TITLE_EXISTS = "Podcast with this title already exists.";

    //addepisode msg
    public static final String EPISODE_ADDED_SUCCESSFULLY = "Episode added successfully.";
    public static final String PODCAST_NOT_EXIST = "Podcast does not exist.";
    public static final String EPISODE_ID_EXISTS = "Episode ID already exists in the system.";
    public static final String EPISODE_DATE_INVALID = "Episode date must be >= than latest episode date.";

    //getpodcast msg
    public static final String PODCAST_INFO = """
                                                Podcast: %s Author: %s Language: %s
                                                Latest episode date: %s
                                                """;
    //episodes msg
    public static final String NO_EPISODES_AVAILABLE = "No episodes available for this podcast.";
    public static final String EPISODES_HEADER = "Episodes for podcast %s:";
    public static final String EPISODE_INFO = """
                                            Episode %s: %d min Date: %s
                                            URL: %s
                                            """;

    //authorpodcasts msg
    public static final String AUTHOR_PODCASTS_HEADER = "Podcasts by author %s:";
    public static final String NO_PODCASTS_FOR_AUTHOR = "No podcasts found for this author.";

    //removepodcast msg
    public static final String PODCAST_REMOVED_SUCCESSFULLY = "Podcast removed successfully.";

    //createshow msg
    public static final String SHOW_CREATED_SUCCESSFULLY = "Show created successfully.";
    public static final String VIDEO_FOR_SHOW_NOT_EXIST = "Video for show does not exist.";
    public static final String SHOW_TITLE_ALREADY_EXISTS = "Show with this title already exists.";

    //getshow msg
    public static final String SHOW_NOT_EXIST = "Show does not exist.";
    public static final String SHOW_INFO = """
                                        Show Date: %s Author: %s
                                        Video: %s
                                        """;

    //removeshow msg
    public static final String SHOW_REMOVED_SUCCESSFULLY = "Show removed successfully.";

    //removevideo msg
    public static final String VIDEO_REMOVED_SUCCESSFULLY = "Video removed successfully.";
    public static final String CANNOT_REMOVE_EPISODE_VIDEO = "Cannot remove: video is an episode of a podcast.";
    public static final String CANNOT_REMOVE_SHOW_VIDEO = "Cannot remove: video is used in a show.";


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Commands(in);
        in.close();
    }

    private static void Commands(Scanner in) {
        Youvideo yv = new YouvideoClass();
        String command;
        do{
            command = in.next().toLowerCase();
            switch(command){
                case EXIT -> System.out.println(BYE_MSG);
                case HELP -> System.out.println(HELP_MSG);
                case CREATE_PUBLISHABLE -> createPublishable(in, yv);
                case CREATE_PREMIUM -> createPremium(in, yv);
                case ADD_SUBTITLE -> addSubtitle(in, yv);
                case GET_VIDEO -> getVideoData(in, yv);
                case SUBTITLES -> listSubtitles(in, yv);
                case CREATE_PODCAST -> createPodcast(in, yv);
                case ADD_EPISODE -> addEpisode(in, yv);
                case GET_PODCAST -> getPodcastData(in, yv);
                case EPISODES -> listEpisodes(in, yv);
                case AUTHOR_PODCASTS -> listPodcasts(in, yv);
                case REMOVE_PODCAST -> removePodcast(in, yv);
                case CREATE_SHOW -> createShow(in, yv);
                case GET_SHOW -> getShowData(in, yv);
                case REMOVE_SHOW -> removeShow(in, yv);
                case REMOVE_VIDEO -> removeVideo(in, yv);
                default -> System.out.println(UNKNOWN_COMMAND_MSG);
            }
        }while(!command.equals(EXIT));
    }

    private static void removeShow(Scanner in, Youvideo yv) {
        String title = in.next();
        if(!yv.showTitleExist(title)){
            System.out.println(SHOW_NOT_EXIST);
            return;
        }
        yv.removeShow(title);
        System.out.println(SHOW_REMOVED_SUCCESSFULLY);
    }

    private static void removeVideo(Scanner in, Youvideo yv) {
        String videoId = in.next();
        if(!yv.videoIdExist(videoId)){
            System.out.printf(PUBLISHABLE_VIDEO_NOT_EXIST + "%n",videoId);
            return;
        }
        if(yv.isVideoInstance(videoId, EpisodeClass.class)){
            System.out.println(CANNOT_REMOVE_EPISODE_VIDEO);
            return;
        }
        if(yv.isVideoUsedInShow(videoId)){
            System.out.println(CANNOT_REMOVE_SHOW_VIDEO);
            return;
        }
        yv.removeVideo(videoId);
        System.out.println(VIDEO_REMOVED_SUCCESSFULLY);
    }

    private static void getShowData(Scanner in, Youvideo yv) {
        String title = in.next();
        Show show = yv.findShowByTitle(title);
        if(show == null){
            System.out.println(SHOW_NOT_EXIST);
            return;
        }
        String videoType = VIDEO;
        if(show.getVideo() instanceof PremiumVideo){
            videoType = PREMIUM;
        }
        System.out.printf(SHOW_INFO + "%n",show.getTransmissionDate(),show.getAuthor(),videoType + " " + show.getVideo().getTitle());
    }

    private static void createShow(Scanner in, Youvideo yv) {
        String author = in.next();
        String videoId = in.next();
        String transmissionDate = in.next();
        if(!yv.videoIdExist(videoId) || !yv.isVideoInstance(videoId, PublishableVideo.class)){
            System.out.println(VIDEO_FOR_SHOW_NOT_EXIST);
            return;
        }
        PublishableVideo video = (PublishableVideo) yv.findVideoById(videoId);
        if(yv.showTitleExist(video.getTitle())){
            System.out.println(SHOW_TITLE_ALREADY_EXISTS);
            return;
        }
        yv.createShow(author,videoId,transmissionDate);
        System.out.println(SHOW_CREATED_SUCCESSFULLY);
    }

    private static void removePodcast(Scanner in, Youvideo yv) {
        String title = in.next();
        if(!yv.podcastExist(title)){
            System.out.println(PODCAST_NOT_EXIST);
            return;
        }
        yv.removePodcast(title);
        System.out.println(PODCAST_REMOVED_SUCCESSFULLY);
    }

    private static void listPodcasts(Scanner in, Youvideo yv) {
        String authorName = in.next();
        Array<Podcast> podcasts = yv.podcastsByAuthor(authorName);
        if(podcasts.size() == 0){
            System.out.println(NO_PODCASTS_FOR_AUTHOR);
            return;
        }
        System.out.printf(AUTHOR_PODCASTS_HEADER + "%n",authorName);
        for(int i = 0; i < podcasts.size(); i++){
            Podcast podcast = podcasts.get(i);
            Array<EpisodeClass> episodes = podcast.getEpisodes();
            String latestDate = episodes.size() == 0 ? "-" : episodes.get(episodes.size() - 1).getReleaseDate();
            System.out.printf(PODCAST_INFO,podcast.getTitle(),podcast.getAuthor(),podcast.getLanguage(),latestDate);
        }
    }

    private static void listEpisodes(Scanner in, Youvideo yv) {
        String title = in.next();
        if(!yv.podcastExist(title)){
            System.out.println(PODCAST_NOT_EXIST);
            return;
        }
        Podcast podcast = yv.findPodcastByTitle(title);
        Array<EpisodeClass> episodes = podcast.getEpisodes();
        if(episodes.size() == 0){
            System.out.println(NO_EPISODES_AVAILABLE);
            return;
        }
        System.out.printf(EPISODES_HEADER + "%n",title);
        for(int i = episodes.size() - 1; i >= 0; i--){
            EpisodeClass episode = episodes.get(i);
            System.out.printf(EPISODE_INFO + "%n",episode.getUid(),episode.getDuration(),episode.getReleaseDate(),episode.getFileLocation());
        }
    }

    private static void getPodcastData(Scanner in, Youvideo yv) {
        String title = in.next();
        if(!yv.podcastExist(title)){
            System.out.println(PODCAST_NOT_EXIST);
            return;
        }
        Podcast podcast = yv.findPodcastByTitle(title);
        Array<EpisodeClass> episodes = podcast.getEpisodes();
        String latestDate = episodes.size() == 0 ? "-" : episodes.get(episodes.size() - 1).getReleaseDate();
        System.out.printf(PODCAST_INFO,podcast.getTitle(),podcast.getAuthor(),podcast.getLanguage(),latestDate);
    }

    private static void addEpisode(Scanner in, Youvideo yv) {
        String podTitle = in.next();
        String uid = in.next();
        if (!in.hasNextInt()) {
            System.out.println(INVALID_VALUE);
            in.next();
            return;
        }
        int duration = in.nextInt();
        String url = in.next();
        String date = in.next();

        if(duration <= 0){
            System.out.println(INVALID_VALUE);
            return;
        }
        if(!yv.podcastExist(podTitle)){
            System.out.println(PODCAST_NOT_EXIST);
            return;
        }
        if(yv.episode_Exist(uid)){
            System.out.println(EPISODE_ID_EXISTS);
            return;
        }
        if(!yv.isEpisodeDateValid(podTitle, date)){
            System.out.println(EPISODE_DATE_INVALID);
            return;
        }
        yv.addEpisode(podTitle, uid, duration, url, date);
        System.out.println(EPISODE_ADDED_SUCCESSFULLY);
    }


    //done
    private static void createPodcast(Scanner in, Youvideo yv) {
        String title= in.next();
        String author = in.next();
        String lang = in.next();

        if(yv.podcastExist(title)){
            System.out.println(PODCAST_TITLE_EXISTS);
            return;
        }
        if(!isValidLanguageCode(lang)){
            System.out.println(INVALID_LANGUAGE_TYPE);
            return;
        };
        yv.createPodcast(title,author,lang);
        System.out.println(PODCAST_CREATED_SUCCESSFULLY);

    }



//commit -5
    private static void listSubtitles(Scanner in, Youvideo yv) {
        String v_id = in.next();
        if(!yv.videoIdExist(v_id) || !yv.isVideoInstance(v_id, PremiumVideo.class)){
            System.out.println(NO_PREMIUM_VIDEO);
            return;
        };
        PremiumVideo video = (PremiumVideo) yv.findVideoById(v_id);
        System.out.printf(SUBTITLES_HEADER + "%n",video.getTitle());
       Array<Subtitle> subtitles= video.getSubtitles();
       String suburl ="";
       String subLang = "";
        for(int i = 0; i<subtitles.size();i++){
            suburl = subtitles.get(i).getSubtitleUrl();
            subLang = subtitles.get(i).getLanguage();
            System.out.printf(SUBTITLE_INFO+ "%n", suburl,subLang);
        };
    }


//commit -4
    private static void getVideoData(Scanner in, Youvideo yv) {
        String v_id = in.next();
        if(!yv.videoIdExist(v_id)){
            System.out.printf(PUBLISHABLE_VIDEO_NOT_EXIST + "%n",v_id);
            return;
        }
        String v_type = VIDEO;
        if(yv.isVideoInstance(v_id, PremiumVideo.class)){
            v_type= PREMIUM;
        }
        PublishableVideo video = (PublishableVideo) yv.findVideoById(v_id);
        System.out.printf(VIDEO_INFO + "%n",v_type,video.getUid(),video.getDuration(),video.getTitle());
        System.out.printf(VIDEO_FILE_INFO + "%n",video.getFileLocation(),video.getPublisher(),video.getLanguage());
    }



    //done commit- 3
    private static void addSubtitle(Scanner in, Youvideo yv) {
        String id = in.next();
        String subUrl = in.next();
        String subLang = in.next();
        if(!yv.videoIdExist(id)){
            System.out.println(VIDEO_NOT_EXIST);
            return;
        }
        if(!isValidLanguageCode(subLang)){
            System.out.println(INVALID_LANGUAGE_TYPE_IN_SUBTITLE);
            return;
        }
        if(!yv.isVideoInstance(id, PremiumVideo.class)){
            System.out.println(PREMIUM_VIDEO_REQUIRED);
            return;
        };

        yv.addSubtitle(id,subUrl,subLang);
        System.out.println(SUBTITLE_ADDED_SUCCESSFULLY);
    };



//done---commit 2
    private static void createPremium(Scanner in, Youvideo yv) {
      String id = in.next();
      if(!in.hasNextInt()){
          System.out.println(INVALID_VALUE);
          in.next();
          return;
      };
      int duration = in.nextInt();
      String url = in.next();
      String publisher = in.next();
      String title = in.next();
      String langCode = in.next();
      String subUrl =in.next();
      String subLang = in.next();
        if(duration<=0){
            System.out.println(INVALID_VALUE);
            return;
        }
        if(yv.videoIdExist(id)){
            System.out.println(VIDEO_ID_EXISTS);
            return;
        }
        if (!isValidLanguageCode(langCode)) {
            System.out.println(INVALID_LANGUAGE_TYPE);
            return;
        }
        if (!isValidLanguageCode(subLang)) {
            System.out.println(INVALID_LANGUAGE_TYPE_IN_SUBTITLE);
            return;
        };
        yv.createPremium(id,duration,url,publisher,title,langCode,subUrl,subLang);
        //TODO output match  reformat this output;
        System.out.printf("PREMIUM " + VIDEO_CREATED_SUCCESSFULLY + "%n", id);
    }




    //checks whether code is a valid 2-letter alphabetic language code.
    private static boolean isValidLanguageCode(String code) {
        return code != null && code.matches("(?i)[a-z]{2}");
    }

    //done
    private static void createPublishable(Scanner in, Youvideo yv) {
        String id = in.next();
        if(!in.hasNextInt()){
            System.out.println(INVALID_VALUE);
            in.next();
            return;
        }
        int duration = in.nextInt();
        String url = in.next();
        String publisher = in.next();
        String title = in.next();
        String langCode = in.next();
        if(duration<=0){
            System.out.println(INVALID_VALUE);
            return;
        }
        if(yv.videoIdExist(id)){
            System.out.println(VIDEO_ID_EXISTS);
            return;
        }
        if (!isValidLanguageCode(langCode)) {
            System.out.println(INVALID_LANGUAGE_TYPE);
            return;
        }
        yv.createPublishable(id,duration, url,publisher,title,langCode);
        System.out.printf((VIDEO_CREATED_SUCCESSFULLY)+ "%n", id);
    }



}
