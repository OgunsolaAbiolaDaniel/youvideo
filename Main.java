import java.util.Locale;
import java.util.Scanner;

import dataStructures.Array;
import youvideo.Youvideo;
import youvideo.YouvideoClass;
import youvideo.Podcast;
import youvideo.Show;
import youvideo.Subtitle;
import youvideo.EpisodeClass;
import youvideo.PremiumVideo;
import youvideo.PublishableVideo;

public class Main {

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

    public static final String UNKNOWN_COMMAND_MSG = "Unknown command. Type help to see available commands.";
    public static final String BYE_MSG = "Bye!";
    public static final String VIDEO = "Video";
    public static final String PREMIUM_VIDEO = "PREMIUM Video";

    public static final String HELP_MSG =
            "createpublishable - creates a new publishable video%n"
            + "createpremium - creates a new publishable Premium video%n"
            + "addsubtitle - adds subtitle to Premium video%n"
            + "getvideo - presents publishable video data from its id%n"
            + "subtitles - Lists Premium video subtitles%n"
            + "createpodcast - creates a new podcast with no episodes%n"
            + "addepisode - adds an episode to a podcast%n"
            + "getpodcast - presents podcast data from its title%n"
            + "episodes - List podcast episodes%n"
            + "authorpodcasts - List all podcasts of an author%n"
            + "removepodcast - removes a podcast%n"
            + "createshow - creates show using an existing publishable video%n"
            + "getshow - presents show data from its title%n"
            + "removeshow - removes a show%n"
            + "removevideo - removes a publishable video%n"
            + "help - shows the available commands%n"
            + "exit - terminates the execution of the program";

    public static final String VIDEO_CREATED_SUCCESSFULLY = "Video %s created successfully.";
    public static final String PREMIUM_VIDEO_CREATED_SUCCESSFULLY = "PREMIUM Video %s created successfully.";
    public static final String INVALID_LANGUAGE_TYPE = "Invalid language type.";
    public static final String INVALID_LANGUAGE_TYPE_IN_SUBTITLE = "Invalid language type in subtitle.";
    public static final String INVALID_VALUE = "Invalid value.";
    public static final String VIDEO_ID_EXISTS = "Video with this ID already exists.";

    public static final String SUBTITLE_ADDED_SUCCESSFULLY = "Subtitle added successfully.";
    public static final String VIDEO_NOT_EXIST = "Video does not exist.";
    public static final String PREMIUM_VIDEO_REQUIRED = "This operation requires a Premium video.";

    public static final String VIDEO_INFO = "%s %s %d Title: %s";
    public static final String VIDEO_FILE_INFO = "File: %s Publisher: %s Language: %s";
    public static final String PUBLISHABLE_VIDEO_NOT_EXIST = "Publishable Video %s does not exist.";

    public static final String NO_PREMIUM_VIDEO = "No Premium Video with ID.";
    public static final String SUBTITLES_HEADER = "Subtitles for video %s:";
    public static final String SUBTITLE_INFO = "- %s (%s)";

    public static final String PODCAST_CREATED_SUCCESSFULLY = "Podcast created successfully.";
    public static final String PODCAST_TITLE_EXISTS = "Podcast with this title already exists.";
    public static final String EPISODE_ADDED_SUCCESSFULLY = "Episode added successfully.";
    public static final String PODCAST_NOT_EXIST = "Podcast does not exist.";
    public static final String EPISODE_ID_EXISTS = "Episode ID already exists in the system.";
    public static final String EPISODE_DATE_INVALID = "Episode date must be >= than latest episode date.";
    public static final String PODCAST_INFO = "Podcast: %s Author: %s Language: %s";
    public static final String LATEST_EPISODE_DATE = "Latest episode date: %s";
    public static final String NO_EPISODES_AVAILABLE = "No episodes available for this podcast.";
    public static final String EPISODES_HEADER = "Episodes for podcast %s:";
    public static final String EPISODE_INFO = "Episode %s: %d min Date: %s%nURL: %s";
    public static final String AUTHOR_PODCASTS_HEADER = "Podcasts by author %s:";
    public static final String NO_PODCASTS_FOR_AUTHOR = "No podcasts found for this author.";
    public static final String PODCAST_REMOVED_SUCCESSFULLY = "Podcast removed successfully.";

    public static final String SHOW_CREATED_SUCCESSFULLY = "Show created successfully.";
    public static final String VIDEO_FOR_SHOW_NOT_EXIST = "Video for show does not exist.";
    public static final String SHOW_TITLE_ALREADY_EXISTS = "Show with this title already exists.";
    public static final String SHOW_NOT_EXIST = "Show does not exist.";
    public static final String SHOW_INFO = "Show Date: %s Author: %s%nVideo: %s";
    public static final String SHOW_REMOVED_SUCCESSFULLY = "Show removed successfully.";

    public static final String VIDEO_REMOVED_SUCCESSFULLY = "Video removed successfully.";
    public static final String CANNOT_REMOVE_EPISODE_VIDEO = "Cannot remove: video is an episode of a podcast.";
    public static final String CANNOT_REMOVE_SHOW_VIDEO = "Cannot remove: video is used in a show.";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        commands(in);
        in.close();
    }

    private static void commands(Scanner in) {
        Youvideo yv = new YouvideoClass();

        while (in.hasNextLine()) {
            String line = in.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }

            String[] tokens = line.split("\\s+");
            String command = tokens[0].toLowerCase(Locale.ROOT);

            switch (command) {
                case EXIT -> {
                    System.out.println(BYE_MSG);
                    return;
                }
                case HELP -> System.out.printf(HELP_MSG + "%n");
                case CREATE_PUBLISHABLE -> createPublishable(line, in, yv);
                case CREATE_PREMIUM -> createPremium(line, in, yv);
                case ADD_SUBTITLE -> addSubtitle(line, in, yv);
                case GET_VIDEO -> getVideoData(line, yv);
                case SUBTITLES -> listSubtitles(line, yv);
                case CREATE_PODCAST -> createPodcast(line, in, yv);
                case ADD_EPISODE -> addEpisode(line, in, yv);
                case GET_PODCAST -> getPodcastData(line, yv);
                case EPISODES -> listEpisodes(line, yv);
                case AUTHOR_PODCASTS -> listPodcasts(line, yv);
                case REMOVE_PODCAST -> removePodcast(line, yv);
                case CREATE_SHOW -> createShow(line, in, yv);
                case GET_SHOW -> getShowData(line, yv);
                case REMOVE_SHOW -> removeShow(line, yv);
                case REMOVE_VIDEO -> removeVideo(line, yv);
                default -> printUnknownCommands(tokens);
            }
        }
    }

    private static void createPublishable(String line, Scanner in, Youvideo yv) {
        String[] parts = line.split("\\s+");
        String id = parts[1];
        int duration = parseInt(parts[2]);
        String url = parts[3];
        String publisher = readLine(in);
        String title = readLine(in);
        String languageCode = readLine(in);

        if (!isValidLanguageCode(languageCode)) {
            System.out.println(INVALID_LANGUAGE_TYPE);
            return;
        }
        if (duration <= 0) {
            System.out.println(INVALID_VALUE);
            return;
        }
        if (yv.videoIdExist(id)) {
            System.out.println(VIDEO_ID_EXISTS);
            return;
        }

        yv.createPublishable(id, duration, url, publisher, title, normalizeLanguageCode(languageCode));
        System.out.printf(VIDEO_CREATED_SUCCESSFULLY + "%n", id);
    }

    private static void createPremium(String line, Scanner in, Youvideo yv) {
        String[] parts = line.split("\\s+");
        String id = parts[1];
        int duration = parseInt(parts[2]);
        String url = parts[3];
        String publisher = readLine(in);
        String title = readLine(in);
        String languageCode = readLine(in);
        String subtitleUrl = readLine(in);
        String subtitleLanguage = readLine(in);

        if (!isValidLanguageCode(languageCode)) {
            System.out.println(INVALID_LANGUAGE_TYPE);
            return;
        }
        if (!isValidLanguageCode(subtitleLanguage)) {
            System.out.println(INVALID_LANGUAGE_TYPE_IN_SUBTITLE);
            return;
        }
        if (duration <= 0) {
            System.out.println(INVALID_VALUE);
            return;
        }
        if (yv.videoIdExist(id)) {
            System.out.println(VIDEO_ID_EXISTS);
            return;
        }

        yv.createPremium(
                id,
                duration,
                url,
                publisher,
                title,
                normalizeLanguageCode(languageCode),
                subtitleUrl,
                normalizeLanguageCode(subtitleLanguage)
        );
        System.out.printf(PREMIUM_VIDEO_CREATED_SUCCESSFULLY + "%n", id);
    }

    private static void addSubtitle(String line, Scanner in, Youvideo yv) {
        String[] parts = line.split("\\s+");
        String videoId = parts[1];
        String subtitleUrl = parts[2];
        String subtitleLanguage = readLine(in);

        if (!isValidLanguageCode(subtitleLanguage)) {
            System.out.println(INVALID_LANGUAGE_TYPE_IN_SUBTITLE);
            return;
        }
        if (!yv.videoIdExist(videoId)) {
            System.out.println(VIDEO_NOT_EXIST);
            return;
        }
        if (!yv.isVideoInstance(videoId, PremiumVideo.class)) {
            System.out.println(PREMIUM_VIDEO_REQUIRED);
            return;
        }

        yv.addSubtitle(videoId, subtitleUrl, normalizeLanguageCode(subtitleLanguage));
        System.out.println(SUBTITLE_ADDED_SUCCESSFULLY);
    }

    private static void getVideoData(String line, Youvideo yv) {
        String videoId = argumentAfterCommand(line);
        if (!yv.videoIdExist(videoId) || !yv.isVideoInstance(videoId, PublishableVideo.class)) {
            System.out.printf(PUBLISHABLE_VIDEO_NOT_EXIST + "%n", videoId);
            return;
        }

        PublishableVideo video = (PublishableVideo) yv.findVideoById(videoId);
        String videoType = video instanceof PremiumVideo ? PREMIUM_VIDEO : VIDEO;
        System.out.printf(VIDEO_INFO + "%n", videoType, video.getUid(), video.getDuration(), video.getTitle());
        System.out.printf(
                VIDEO_FILE_INFO + "%n",
                video.getFileLocation(),
                video.getPublisher(),
                displayLanguage(video.getLanguage())
        );
    }

    private static void listSubtitles(String line, Youvideo yv) {
        String videoId = argumentAfterCommand(line);
        if (!yv.videoIdExist(videoId) || !yv.isVideoInstance(videoId, PremiumVideo.class)) {
            System.out.println(NO_PREMIUM_VIDEO);
            return;
        }

        PremiumVideo video = (PremiumVideo) yv.findVideoById(videoId);
        System.out.printf(SUBTITLES_HEADER + "%n", video.getTitle());
        Array<Subtitle> subtitles = video.getSubtitles();
        for (int i = 0; i < subtitles.size(); i++) {
            Subtitle subtitle = subtitles.get(i);
            System.out.printf(
                    SUBTITLE_INFO + "%n",
                    subtitle.getSubtitleUrl(),
                    displayLanguage(subtitle.getLanguage())
            );
        }
    }

    private static void createPodcast(String line, Scanner in, Youvideo yv) {
        String title = argumentAfterCommand(line);
        String author = readLine(in);
        String languageCode = readLine(in);

        if (!isValidLanguageCode(languageCode)) {
            System.out.println(INVALID_LANGUAGE_TYPE);
            return;
        }
        if (yv.podcastExist(title)) {
            System.out.println(PODCAST_TITLE_EXISTS);
            return;
        }

        Array<Podcast> authorPodcasts = yv.podcastsByAuthor(author);
        if (authorPodcasts.size() > 0) {
            author = authorPodcasts.get(0).getAuthor();
        }

        yv.createPodcast(title, author, normalizeLanguageCode(languageCode));
        System.out.println(PODCAST_CREATED_SUCCESSFULLY);
    }

    private static void addEpisode(String line, Scanner in, Youvideo yv) {
        String podcastTitle = argumentAfterCommand(line);
        String[] parts = readLine(in).split("\\s+");
        String episodeId = parts[0];
        int duration = parseInt(parts[1]);
        String url = parts[2];
        String releaseDate = readLine(in);

        if (duration <= 0) {
            System.out.println(INVALID_VALUE);
            return;
        }
        if (!yv.podcastExist(podcastTitle)) {
            System.out.println(PODCAST_NOT_EXIST);
            return;
        }
        if (yv.episode_Exist(episodeId)) {
            System.out.println(EPISODE_ID_EXISTS);
            return;
        }
        if (!yv.isEpisodeDateValid(podcastTitle, releaseDate)) {
            System.out.println(EPISODE_DATE_INVALID);
            return;
        }

        yv.addEpisode(podcastTitle, episodeId, duration, url, releaseDate);
        System.out.println(EPISODE_ADDED_SUCCESSFULLY);
    }

    private static void getPodcastData(String line, Youvideo yv) {
        String title = argumentAfterCommand(line);
        if (!yv.podcastExist(title)) {
            System.out.println(PODCAST_NOT_EXIST);
            return;
        }

        Podcast podcast = yv.findPodcastByTitle(title);
        System.out.printf(PODCAST_INFO + "%n", podcast.getTitle(), podcast.getAuthor(), podcast.getLanguage());
        Array<EpisodeClass> episodes = podcast.getEpisodes();
        if (episodes.size() > 0) {
            System.out.printf(LATEST_EPISODE_DATE + "%n", episodes.get(episodes.size() - 1).getReleaseDate());
        }
    }

    private static void listEpisodes(String line, Youvideo yv) {
        String title = argumentAfterCommand(line);
        if (!yv.podcastExist(title)) {
            System.out.println(PODCAST_NOT_EXIST);
            return;
        }

        Podcast podcast = yv.findPodcastByTitle(title);
        Array<EpisodeClass> episodes = podcast.getEpisodes();
        if (episodes.size() == 0) {
            System.out.println(NO_EPISODES_AVAILABLE);
            return;
        }

        System.out.printf(EPISODES_HEADER + "%n", title);
        for (int i = episodes.size() - 1; i >= 0; i--) {
            EpisodeClass episode = episodes.get(i);
            System.out.printf(
                    EPISODE_INFO + "%n",
                    episode.getUid(),
                    episode.getDuration(),
                    episode.getReleaseDate(),
                    episode.getFileLocation()
            );
        }
    }

    private static void listPodcasts(String line, Youvideo yv) {
        String authorName = argumentAfterCommand(line);
        Array<Podcast> podcasts = yv.podcastsByAuthor(authorName);
        if (podcasts.size() == 0) {
            System.out.println(NO_PODCASTS_FOR_AUTHOR);
            return;
        }

        System.out.printf(AUTHOR_PODCASTS_HEADER + "%n", authorName);
        for (int i = 0; i < podcasts.size(); i++) {
            Podcast podcast = podcasts.get(i);
            System.out.printf(PODCAST_INFO + "%n", podcast.getTitle(), podcast.getAuthor(), podcast.getLanguage());
        }
    }

    private static void removePodcast(String line, Youvideo yv) {
        String title = argumentAfterCommand(line);
        if (!yv.podcastExist(title)) {
            System.out.println(PODCAST_NOT_EXIST);
            return;
        }

        yv.removePodcast(title);
        System.out.println(PODCAST_REMOVED_SUCCESSFULLY);
    }

    private static void createShow(String line, Scanner in, Youvideo yv) {
        String author = argumentAfterCommand(line);
        String[] parts = readLine(in).split("\\s+");
        String videoId = parts[0];
        String transmissionDate = parts[1];

        if (!yv.videoIdExist(videoId) || !yv.isVideoInstance(videoId, PublishableVideo.class)) {
            System.out.println(VIDEO_FOR_SHOW_NOT_EXIST);
            return;
        }

        PublishableVideo video = (PublishableVideo) yv.findVideoById(videoId);
        if (yv.showTitleExist(video.getTitle())) {
            System.out.println(SHOW_TITLE_ALREADY_EXISTS);
            return;
        }

        Array<Podcast> authorPodcasts = yv.podcastsByAuthor(author);
        if (authorPodcasts.size() > 0) {
            author = authorPodcasts.get(0).getAuthor();
        }

        yv.createShow(author, videoId, transmissionDate);
        System.out.println(SHOW_CREATED_SUCCESSFULLY);
    }

    private static void getShowData(String line, Youvideo yv) {
        String title = argumentAfterCommand(line);
        Show show = yv.findShowByTitle(title);
        if (show == null) {
            System.out.println(SHOW_NOT_EXIST);
            return;
        }

        System.out.printf(SHOW_INFO + "%n", show.getTransmissionDate(), show.getAuthor(), show.getVideo().getTitle());
    }

    private static void removeShow(String line, Youvideo yv) {
        String title = argumentAfterCommand(line);
        if (!yv.showTitleExist(title)) {
            System.out.println(SHOW_NOT_EXIST);
            return;
        }

        yv.removeShow(title);
        System.out.println(SHOW_REMOVED_SUCCESSFULLY);
    }

    private static void removeVideo(String line, Youvideo yv) {
        String videoId = argumentAfterCommand(line);
        if (!yv.videoIdExist(videoId)) {
            System.out.println(VIDEO_NOT_EXIST);
            return;
        }
        if (yv.isVideoInstance(videoId, EpisodeClass.class)) {
            System.out.println(CANNOT_REMOVE_EPISODE_VIDEO);
            return;
        }
        if (yv.isVideoUsedInShow(videoId)) {
            System.out.println(CANNOT_REMOVE_SHOW_VIDEO);
            return;
        }

        yv.removeVideo(videoId);
        System.out.println(VIDEO_REMOVED_SUCCESSFULLY);
    }

    private static void printUnknownCommands(String[] tokens) {
        for (String ignored : tokens) {
            System.out.println(UNKNOWN_COMMAND_MSG);
        }
    }

    private static String readLine(Scanner in) {
        return in.hasNextLine() ? in.nextLine().trim() : "";
    }

    private static String argumentAfterCommand(String line) {
        int firstSpace = line.indexOf(' ');
        if (firstSpace < 0) {
            return "";
        }
        return line.substring(firstSpace + 1).trim();
    }

    private static int parseInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return Integer.MIN_VALUE;
        }
    }

    private static boolean isValidLanguageCode(String code) {
        for (String language : Locale.getISOLanguages()) {
            if (language.equalsIgnoreCase(code)) {
                return true;
            }
        }
        return false;
    }

    private static String normalizeLanguageCode(String code) {
        return code.toUpperCase(Locale.ROOT);
    }

    private static String displayLanguage(String code) {
        if ("FF".equalsIgnoreCase(code)) {
            return "FULAH";
        }
        return Locale.forLanguageTag(code).getDisplayLanguage(Locale.ENGLISH).toUpperCase(Locale.ROOT);
    }
}
