# youvideo
A simplified video streaming platform that manages different types of video content, podcasts, and shows, capturing the essential relationships and constraints that exist in real-world streaming services.



# Project Information 

# VIDEO 
uid: each video must have unique identifier irrespective of the type
duration,
filelocation
# TYPES OF VIDEOS 
-Publishable:(independent)  , title , publisher, language, (basic and premium subscribers)
-Podcast episodes
-Shows
# Subscribers
Basic , 
Premium:- videos published by them are labelled premium they have publishable videos ...in that publishable videos they may include one or more subtitles..
they will include a list of subtitles ordered by moment of insertion;
more than 1 subtitle of the same language may be added to a premium video


# Subtitle
language , subtitle file 

# Podcasts
title:must be unique

, author, and language;

collection of
video episodes that are released over time.

A podcast is created with no episodes. A podcast episode is an
unpublishable video, with no language information;

removing a podcasts removes all episodes 

# Episodes
a video with a release date.
organized in reverse chronological order, with the most recent episode appearing first.
release date is not earlier than the
most recent existing episode,
being videos, must
also have unique identifiers across the entire system and cannot exist independently of their
parent podcast


# Shows
represent scheduled transmissions of publishable
videos
unique titles
Author , transmission date, reference to publishable video(
removing a show should not affect thee underlying video content)(meaning even if i delete 
the show i can still have reference of mmy publishable video so i can reference it again !)


# videos organized by their identifier
# podcasts sorted by title,
# and shows sorted by title

the system must track podcast authors to support queries about an
author’s body of work(lets create an authors list to add some spice )
//spice --authors profile: list of videos uploaded by the author just name and vidreference and 
podcast reference including
Shows

# Data issues
The data attributes to be used in the system will include:
• Integer values, larger than zero, to be used for video durations;
• One word strings, to be used for video identifiers, language codes (two letter strings),
dates(YYYY-MM-DD) and URLs and filenames (long one word strings);
• Strings including more than one word, for video and show titles, as well as publisher
and author names.
The set of possible languages to be used in this project is defined in the ISO 639-1 lan-
guage standard1 and can be accessed in the java.util.Locale class, through the method
getISOLanguages(). Each language value can be stored as Locale objects which may be
created using two-letter strings. For this you can use the Locale(String l) constructor
(e.g. Locale lang = new Locale("ES")). To access the display name of the language
you can use the getDisplayLanguage() method (e.g. lang.getDisplayLanguage()).

You should start with
a really bare-bones system with the help and exit commands, which are good enough for
checking whether your commands interpreter is working well, to begin with. Then, add 
publishable (and premium) videos and subtitles to premium videos. Once this is working you can
create shows, which depend on the availability of videos. Check that they are ok. After that
you can implement podcasts. Podcasts depend on extending the system with particular types
of videos, episodes. Finally, you can implement the listing of the podcasts created by an author.
Step by step, you will incrementally add functionalities to your program and test them. Do
not try to make all functionalities simultaneously. It is a really bad idea.
Last, but not least, do not underestimate the effort for this project. 


_//later on for the authors list we can use Hashmaps;