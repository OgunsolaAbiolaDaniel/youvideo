package youvideo.core;

import dataStructures.Array;
import youvideo.podcast.Podcast;
import youvideo.show.Show;
import youvideo.video.VideoClass;

public interface Youvideo {
    /**
     * Checks whether a video identifier already exists in the platform.
     *
     * @param uid identifier to search for
     * @return {@code true} if a video with that identifier exists, {@code false} otherwise
     */
    public abstract boolean videoIdExist(String uid);

    /**
     * Checks whether a stored video belongs to a given runtime type.
     *
     * @param videoId identifier of the video to inspect
     * @param targetClass class expected for the video
     * @return {@code true} if the video exists and is an instance of {@code targetClass}
     */
    public abstract boolean isVideoInstance(String videoId, Class<?> targetClass);

    /**
     * Finds a video by its identifier.
     *
     * @param videoId identifier of the video to retrieve
     * @return the matching video, or {@code null} if it does not exist
     */
    public abstract VideoClass findVideoById(String videoId);

    /**
     * Creates a new publishable video.
     * * @param id        The unique identifier for the video.
     * @param duration  The length of the video (e.g., in ISO-8601 format or seconds).
     * @param url       The source URL where the video file is hosted.
     * @param publisher The name of the entity or user publishing the video.
     * @param title     The display title of the video.
     * @param langCode two-letter language code of the video
     */
    void createPublishable(String id, int duration, String url, String publisher, String title, String langCode);
    /**
     * Creates a new premium video entry with subtitle support.
     * @param id          The unique identifier for the video.
     * @param duration  The playback duration of the video.
     * @param url       The primary video stream or file URL.
     * @param publisher The entity responsible for publishing the content.
     * @param title     The descriptive title of the premium video.
     * @param langCode  The ISO language code for the primary audio (e.g., "en", "es").
     * @param subUrl    The URL pointing to the subtitle file (e.g., .srt or .vtt).
     * @param subLang   The language code of the initial subtitle.
     */
   void createPremium(String id, int duration, String url, String publisher, String title, String langCode, String subUrl, String subLang);
    /**
     * Adds a new subtitle to an existing premium video.
     * <p>
     * The subtitle is added to the video's collection, preserving the order of addition.
     * Multiple subtitles in the same language are permitted.
     *
     * @param videoId          The unique identifier of the premium video.
     * @param subtitleUrl      The URL where the subtitle file is stored.
     * @param subtitleLanguage The language code for the subtitle (e.g., "en", "fr").
     */
    void addSubtitle(String videoId, String subtitleUrl, String subtitleLanguage);
    /**
     * Retrieves and displays all information about a video.
     * <p>
     * This command uses the unique identifier to present video data, including
     * the video type (e.g., PREMIUM), ID, duration, title, URL, publisher, and language.
     *
     * @param videoId The unique identifier of the video to be retrieved.
     */
   // void getVideo(String videoId);//this is not needed yet .. i think i will delete it
    /**
     * Lists all subtitles associated with a specific premium video.
     * <p>
     * This command retrieves the video by its identifier and displays a header
     * containing the video's title. It then lists each subtitle's URL and
     * language code, maintaining the original order of addition.
     *
     * @param videoId The unique identifier of the premium video whose subtitles are to be listed.
     */

    /**
     * Creates a new podcast with no episodes.
     * <p>
     * This command initializes a podcast entry in the system with an empty
     * collection of episodes. The podcast title must be unique across all
     * existing podcasts.
     *
     * @param title    The unique title of the podcast.
     * @param author   The name of the podcast creator or author.
     * @param langCode A two-character language code (e.g., "en", "pt").
     */

    void createPodcast(String title, String author, String langCode);

    /**
     * Checks whether a podcast with the given title exists.
     *
     * @param title title to search for
     * @return {@code true} if the podcast exists
     */
    public boolean podcastExist(String title);

    /**
     * Finds a podcast by title.
     *
     * @param title title of the podcast to retrieve
     * @return the matching podcast, or {@code null} if it does not exist
     */
    public Podcast findPodcastByTitle(String title);

    /**
     * Checks whether an episode identifier is already in use.
     *
     * @param id episode identifier to search for
     * @return {@code true} if the identifier is already used by a video
     */
    public boolean episode_Exist(String id);

    /**
     * Validates whether an episode date can be appended to a podcast.
     *
     * @param podcastTitle title of the podcast receiving the new episode
     * @param releaseDate release date to validate
     * @return {@code true} if the date is valid for insertion
     */
    public boolean isEpisodeDateValid(String podcastTitle, String releaseDate);

    /**
     * Returns all podcasts written by a given author.
     *
     * @param authorName author whose podcasts should be retrieved
     * @return podcasts found for that author, in insertion order
     */
    public Array<Podcast> podcastsByAuthor(String authorName);
    /**
     * Adds a new episode to an existing podcast.
     * <p>
     * This method creates an episode and appends it to the specified podcast's collection.
     * The episode ID is unique across the entire system. The release date
     * is validated to ensure it is not earlier than the podcast's most recent episode.
     * @param podcastTitle The title of the podcast to which the episode will be added.
     * @param episodeId    The unique identifier for the episode (must be globally unique).
     * @param duration     The length of the episode in minutes.
     * @param url          The URL where the episode file is located.
     * @param releaseDate  The date of release in YYYY-MM-DD format.
     */
    void addEpisode(String podcastTitle, String episodeId, int duration, String url, String releaseDate);
    /**
     * Retrieves and displays information about a specific podcast by its title.
     * <p>
     * This method  presents the podcast's <code>title</code> , <code>author</code>, and <code>language</code>.
     * If the podcast contains episodes, it also displays the date of the
     * most recent episode. If no episodes exist, only the basic podcast
     * metadata is shown.
     *
     * @param title The unique title of the podcast to be retrieved.
     */
    void getPodcast(String title);

    /**
     * Lists all episodes associated with a specific podcast in reverse chronological order.
     * <p>
     * This command displays a header with the podcast title, followed by a list of
     * all episodes starting from the newest. Each entry includes the episode's
     * identifier, duration, release date, and file URL.
     *
     * @param title The title of the podcast whose episodes are to be listed.
     */
    void episodes(String title);

    /**
     * Lists all podcasts created by a specific author.
     * <p>
     * This command retrieves every podcast associated with the given author name.
     * The system displays a header with the author's name, followed by each
     * podcast's title, author, and language, listed in the order they were
     * originally added to the system.
     *
     * @param authorName The name of the author whose podcasts are to be listed.
     */
    void authorPodcasts(String authorName);
    /**
     * Removes a podcast and all its associated episodes from the system.
     * <p>
     * This command performs a cascading removal: it first deletes all episodes
     * belonging to the podcast from the global videos collection to prevent
     * orphaned records, then removes the podcast entry itself.
     *
     * @param title The title of the podcast to be permanently removed.
     */
    void removePodcast(String title);
    /**
     * Creates a new authored show based on an existing publishable video.
     * <p>
     * This command links a video to a specific transmission date and author.
     * Validation rules:
     * <ul>
     * <li>The provided videoId must exist in the system.</li>
     * <li>The title of the associated video is used as the show's identifier and must be unique among all existing shows.</li>
     * </ul>
     *
     * @param author           The name of the show's author.
     * @param videoId          The unique identifier of the existing publishable video to be broadcast.
     * @param transmissionDate The date the show is scheduled to be broadcast.
     */
    void createShow(String author, String videoId, String transmissionDate);

    /**
     * Checks whether a show with the given title exists.
     *
     * @param title title to search for
     * @return {@code true} if the show exists
     */
    public boolean showTitleExist(String title);

    /**
     * Finds a show by title.
     *
     * @param title title of the show to retrieve
     * @return the matching show, or {@code null} if it does not exist
     */
    public Show findShowByTitle(String title);

    /**
     * Checks whether a video is currently referenced by a show.
     *
     * @param videoId identifier of the video to inspect
     * @return {@code true} if the video is used in a show
     */
    public boolean isVideoUsedInShow(String videoId);

    /**
     * Retrieves and displays a show's data based on its title.
     * <p>
     * This command searches for a show by its unique title and presents
     * the scheduled transmission date, the author of the show, and
     * specific details about the content being aired, including the
     * video type (e.g., PUBLISHABLE, PREMIUM) and the video title.
     *
     * @param title The unique title of the show to be retrieved.
     */
    void getShow(String title);
    /**
     * Removes a show from the system by its title.
     * <p>
     * This command deletes the show record but does not affect the
     * underlying video associated with it. The referenced video
     * remains available in the system for other programming or uses.
     *
     * @param title The unique title of the show to be removed.
     */
    void removeShow(String title);
    /**
     * Removes a publishable video from the system by its identifier.
     * <p>
     * This command is subject to the following constraints:
     * <ul>
     * <li>It only applies to publishable videos; podcast episodes cannot be removed via this command.</li>
     * <li>A video cannot be removed if it is currently associated with an existing show.</li>
     * </ul>
     *
     * @param videoId The unique identifier of the publishable video to be removed.
     */
    void removeVideo(String videoId);
}
