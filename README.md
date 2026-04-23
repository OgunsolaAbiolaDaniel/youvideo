# YouVideo

Phase 1 Object-Oriented Programming project.

This project implements a simplified streaming platform called `YouVideo`. The system manages:

- publishable videos
- premium videos with subtitles
- podcasts and podcast episodes
- shows that schedule existing publishable videos

This README is written to help both implementation review and oral defense.

## 1. Project Goal

The goal of the project is to model the domain of a streaming platform using OOP principles, without using the standard Java Collections framework.

The implementation follows the Phase 1 restrictions:

- no `ArrayList`, `HashMap`, or other Java Collections
- reuse the provided `dataStructures` package
- keep command messages in constants
- respect the validation order required by the assignment
- build a clear object-oriented model using interfaces, abstract classes, inheritance, composition, and encapsulation

## 2. Main Functionalities

The program supports these commands:

- `help`
- `exit`
- `createpublishable`
- `createpremium`
- `addsubtitle`
- `getvideo`
- `subtitles`
- `createpodcast`
- `addepisode`
- `getpodcast`
- `episodes`
- `authorpodcasts`
- `removepodcast`
- `createshow`
- `getshow`
- `removeshow`
- `removevideo`

Commands are case-insensitive, and the implementation was tested against the provided training files.

## 3. Project Structure

### `Main.java`

This is the command interpreter.

Responsibilities:

- reads user input
- identifies the command
- reads the remaining arguments in the format expected by the assignment
- performs validation in the correct order
- prints the exact feedback required by the specification
- delegates data operations to `YouvideoClass`

Important defense point:
`Main` is responsible for interaction and command flow, not for storing business data.

### `youvideo.core`

#### `Youvideo`

This is the main platform interface.  
It defines the operations supported by the system.

#### `YouvideoClass`

This is the central class of the system.

It stores:

- all videos
- all podcasts
- all shows

It is also responsible for:

- searching objects
- checking uniqueness constraints
- creating domain objects
- removing objects
- enforcing relationships between objects

Important defense point:
`YouvideoClass` works like the application service / central repository of the system.

### `youvideo.video`

#### `VideoClass`

Abstract base class for all videos.

Common fields:

- `uid`
- `duration`
- `fileLocation`
- `language`

Why abstract?

- there is no reason to create a generic “video” directly
- only specific kinds of video should exist in the system
- it avoids duplicated fields in subclasses

#### `PublishableVideo`

Concrete subclass of `VideoClass`.

Adds:

- `title`
- `publisher`

This models videos that can exist independently in the system.

#### `PremiumVideo`

Subclass of `PublishableVideo`.

Adds:

- a collection of subtitles

This models the rule that premium videos are still publishable videos, but with extra subtitle support.

#### `EpisodeClass`

Subclass of `VideoClass`.

Adds:

- `releaseDate`

This models podcast episodes as a special kind of video.  
Episodes are videos, but they are not publishable videos.

Important defense point:
This is why `EpisodeClass` extends `VideoClass` directly and not `PublishableVideo`.

### `youvideo.subtitle`

#### `Subtitle`

Interface for subtitle objects.

#### `SubtitleClass`

Concrete subtitle implementation.

Stores:

- subtitle language
- subtitle URL
- owning video id

Important defense point:
Subtitles are modeled separately because they belong only to premium videos and are added over time.

### `youvideo.podcast`

#### `Podcast`

Interface representing a podcast.

#### `PodcastClass`

Concrete podcast implementation.

Stores:

- `title`
- `author`
- `language`
- list of `EpisodeClass`

Important defense point:
A podcast is not itself a video. It is a container of episodes.

### `youvideo.show`

#### `Show`

Interface representing a scheduled show.

#### `ShowClass`

Concrete show implementation.

Stores:

- `title`
- `author`
- `transmissionDate`
- referenced `PublishableVideo`

Important defense point:
The show title is derived from the referenced video title, which matches the assignment rule.

## 4. Relationships in the Model

These are the most important relationships:

- `YouvideoClass` manages videos, podcasts, and shows
- `VideoClass` is the parent of `PublishableVideo` and `EpisodeClass`
- `PublishableVideo` is the parent of `PremiumVideo`
- `PremiumVideo` contains subtitles
- `PodcastClass` contains episodes
- `ShowClass` references one publishable video

In short:

- inheritance is used when one type is a specialized version of another
- composition/aggregation is used when one object owns or stores other objects

## 5. Why the Design Looks Like This

### Why use inheritance for videos?

Because the assignment defines a shared concept of video:

- every video has id, duration, and file location
- some videos are publishable
- some publishable videos are premium
- episodes are videos too, but not publishable

This makes inheritance the most natural design.

### Why use composition for podcasts and shows?

- a podcast is made of episodes
- a premium video is made of subtitles
- a show references a publishable video

These are “has-a” relations, not “is-a” relations.

### Why use interfaces?

Interfaces were used to separate the abstraction from the implementation.

This helps in three ways:

- cleaner design
- easier UML hierarchy
- better explanation of responsibilities in defense

Even when there is only one implementation in this phase, the interface still expresses the role of the object.

## 6. Key Business Rules Implemented

### Video rules

- every video id is globally unique
- durations must be greater than zero
- language codes must be valid ISO 639-1 codes
- `getvideo` only works for publishable videos
- podcast episodes cannot be retrieved as publishable videos

### Premium video rules

- premium videos must be created with an initial subtitle
- subtitles are stored in insertion order
- multiple subtitles with the same language are allowed

### Podcast rules

- podcast titles are unique
- a podcast starts with no episodes
- episode ids are globally unique across all videos
- new episode date must not be earlier than the latest episode date
- episodes are listed newest first
- removing a podcast removes all its episodes from the global video collection too

### Show rules

- a show must reference an existing publishable video
- the show title is the title of that referenced video
- two shows cannot have the same title
- removing a show does not remove the underlying video
- a video used in a show cannot be removed

## 7. Data Storage Strategy

Because Java Collections are forbidden in this phase, the project uses the provided `dataStructures` package.

Internally, `YouvideoClass` stores data in custom arrays:

- videos in `Array<VideoClass>`
- podcasts in `Array<Podcast>`
- shows in `Array<Show>`

Searches are implemented by iterating through these arrays.

Important defense point:
This is acceptable because the assignment explicitly expects the use of the provided custom structures in Phase 1.

## 8. Case Insensitivity

The assignment states that commands are case-insensitive and, by default, string arguments should also be interpreted case-insensitively.

The project handles this by:

- converting the command name to lowercase in `Main`
- using `equalsIgnoreCase` in platform searches and existence checks

Examples:

- `HELP`, `help`, `HeLp` all work
- titles, ids, authors, and show names are matched case-insensitively where required

## 9. Validation Order

One of the most important technical requirements is the order of validation.

This matters because the assignment and Mooshak expect the first error in the exact order described in the PDF.

Examples:

- language must be checked before duplicate id in commands where the PDF says so
- `removevideo` must check:
  1. video existence
  2. whether it is a podcast episode
  3. whether it is used in a show

Important defense point:
This project was adjusted to match the provided training tests exactly, which confirms that the validation order is aligned with the assignment.

## 10. How to Run

Compile:

```bash
javac Main.java youvideo/core/*.java youvideo/podcast/*.java youvideo/show/*.java youvideo/subtitle/*.java youvideo/video/*.java dataStructures/*.java
```

Run:

```bash
java Main
```

## 11. Testing

The project was tested with the provided training files in `testfile/`.

Each input file was run through the program and compared to its expected output file.

Training result:

- `9/9` training tests pass

Important defense point:
This is strong evidence that:

- command parsing is correct
- output messages are correct
- validation order is correct
- the current implementation matches the project specification closely

## 12. Likely Defense Questions and Good Answers

### Why is `VideoClass` abstract?

Because “video” is a generic concept in the system.  
The program should create concrete specialized types like publishable videos, premium videos, and podcast episodes, not generic videos.

### Why does `EpisodeClass` not extend `PublishableVideo`?

Because an episode is a video, but it is not publishable on its own.  
It only exists inside a podcast. So it shares the common video fields, but not the publishable-specific fields.

### Why does `PremiumVideo` extend `PublishableVideo`?

Because every premium video is still a publishable video, just with additional subtitle support.

### Why is a show not a video?

A show is a scheduled transmission event, not content itself.  
It references a publishable video, but it is a different domain concept.

### Why is a podcast not a video?

A podcast is a container of episodes.  
The episodes are videos; the podcast is the object that groups and manages them.

### Why use interfaces like `Podcast`, `Show`, `Subtitle`, and `Youvideo`?

To separate the role from the implementation.  
This makes the design clearer and easier to explain in UML and in defense.

### Why not use `ArrayList`?

Because the assignment explicitly forbids Java Collections in Phase 1.  
So the project uses the provided `dataStructures` package instead.

### How is uniqueness guaranteed?

By checking the relevant array before inserting:

- video ids in the global videos collection
- podcast titles in the podcast collection
- show titles in the show collection

### How are episodes ordered?

Episodes are stored in insertion order, but insertion is only allowed if the new date is not earlier than the latest date.  
When listing episodes, the program prints from the end of the array to the beginning, which gives newest first.

## 13. Class-by-Class Defense Summary

### `Main`

- responsibility: command interpreter
- does not store business data
- validates input and delegates to the core system

### `YouvideoClass`

- responsibility: central platform manager
- owns the main collections
- enforces global business rules

### `VideoClass`

- responsibility: shared base for all videos
- avoids duplicated fields and methods

### `PublishableVideo`

- responsibility: models standalone publishable content
- adds title and publisher to base video data

### `PremiumVideo`

- responsibility: publishable video with subtitles
- extends `PublishableVideo` because it is a more specific kind of publishable video

### `EpisodeClass`

- responsibility: podcast episode
- extends `VideoClass` because it is a video
- does not extend `PublishableVideo` because it is not standalone content

### `PodcastClass`

- responsibility: represents a podcast and stores its episodes
- groups related episode objects

### `ShowClass`

- responsibility: represents a scheduled transmission
- references a publishable video instead of duplicating video data

### `SubtitleClass`

- responsibility: represents one subtitle entry
- isolated because subtitles are separate objects added over time

## 14. Final Notes

This project is not just a command-line program.  
It is mainly an object-oriented domain model with a command interface on top.

The strongest points to defend are:

- clear inheritance hierarchy in the video model
- correct use of composition in podcasts, subtitles, and shows
- separation between command handling and domain/data logic
- compliance with assignment restrictions
- successful training test results

If someone is defending the project, the safest strategy is:

1. explain the domain first
2. explain the class hierarchy
3. explain the main business rules
4. explain why inheritance or composition was chosen in each case
5. mention that the implementation passes the provided training tests
