import java.util.Scanner;
import youvideo.core.*;
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
    public static final String VIDEO_INFO = "Video %s %d Title: %s";
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
                                            Episode %s: %d min Date: %s";
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
                                        Show Date: %s Author: %s"
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
        System.out.println("removeShowData");
    }

    private static void removeVideo(Scanner in, Youvideo yv) {
        System.out.println("removeVideo");
    }

    private static void getShowData(Scanner in, Youvideo yv) {
        System.out.println("getShowData");
    }

    private static void createShow(Scanner in, Youvideo yv) {
        System.out.println("createShow");
    }

    private static void removePodcast(Scanner in, Youvideo yv) {
        System.out.println("removePodcast");
    }

    private static void listPodcasts(Scanner in, Youvideo yv) {
        System.out.println("list Podcasts");
    }

    private static void listEpisodes(Scanner in, Youvideo yv) {
        System.out.println("ListEpisodes");
    }

    private static void getPodcastData(Scanner in, Youvideo yv) {
        System.out.println("getPodcastData");
    }

    private static void addEpisode(Scanner in, Youvideo yv) {
        System.out.println("addEpisode");
    }

    private static void createPodcast(Scanner in, Youvideo yv) {
        System.out.println("create Podcast");
    }

    private static void listSubtitles(Scanner in, Youvideo yv) {
        System.out.println("list Subtitles");
    }

    private static void getVideoData(Scanner in, Youvideo yv) {
        System.out.println("getVideoData");
    }

    private static void addSubtitle(Scanner in, Youvideo yv) {
        System.out.println("addSubtitle");
    }

    private static void createPremium(Scanner in, Youvideo yv) {
        System.out.println("create Premium ");
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
