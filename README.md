# YouVideo (OOP Project)

Simplified streaming platform for Object-Oriented Programming (Phase 1).

## Current project status (where you are now)

- `dataStructures/` is ready (custom `Array` and `Iterator` package from class).
- `Main.java` has command/message constants, but command handling and domain classes are not implemented yet.
- No `YouVideo` domain model classes are in the repo yet.

## Rules from the assignment (important)

1. Do **not** use Java Collections (`ArrayList`, `HashMap`, etc.) in this phase.
2. Reuse the provided `dataStructures` package (or wrappers over it).
3. Keep command error checks in the **exact order** specified in the PDF.
4. Keep all user messages as constants.
5. Build incrementally: `help/exit` -> videos/subtitles -> shows -> podcasts/episodes -> authorpodcasts.

## Implementation roadmap (step-by-step)

### Phase 0 - Setup and architecture

1. Create packages:
   - `YouVideo.core` (platform class + app control)
   - `YouVideo.video` (video hierarchy)
   - `YouVideo.podcast` (podcast + episode relation)
   - `YouVideo.show` (show entity)
   - `YouVideo.subtitle` (subtitle entity)
2. Define interfaces first, then classes.
3. Create one central class (e.g., `YouvideoClass`) that stores:
   - videos by id
   - podcasts by title
   - shows by title
   - authors -> podcasts list (for `authorpodcasts`)

### Phase 1 - Domain model (before command logic)

1. `Video` (abstract): `id`, `duration`, `fileUrl`
2. `PublishableVideo` extends `Video`: `title`, `publisher`, `language`
3. `PremiumVideo` extends `PublishableVideo`: list of `Subtitle`
4. `Episode` extends `Video`: `releaseDate` (belongs to one podcast)
5. `Subtitle`: `fileUrl`, `language`
6. `Podcast`: `title`, `author`, `language`, episodes (reverse chronological)
7. `Show`: `title` (derived from referenced video title), `author`, `transmissionDate`, `publishableVideoRef`

### Phase 2 - Command engine skeleton

1. Implement command loop in `Main`.
2. Make commands case-insensitive.
3. Implement only:
   - `help`
   - `exit`
4. Add unknown command behavior exactly as required.

### Phase 3 - Videos and subtitles

Implement and test in this order:

1. `createpublishable`
2. `createpremium`
3. `addsubtitle`
4. `getvideo`
5. `subtitles`

Focus points:
- language validation with `Locale.getISOLanguages()`
- duration > 0
- global unique video IDs across **all** video types

### Phase 4 - Shows

Implement and test:

1. `createshow`
2. `getshow`
3. `removeshow`
4. `removevideo`

Focus points:
- show title uniqueness (video title is the show title)
- cannot remove video used in show
- remove show must not remove underlying video

### Phase 5 - Podcasts and episodes

Implement and test:

1. `createpodcast`
2. `addepisode`
3. `getpodcast`
4. `episodes`
5. `authorpodcasts`
6. `removepodcast`

Focus points:
- podcast title uniqueness
- episode id globally unique in video system
- episode date >= latest episode date
- episodes listed newest first
- removing podcast removes all its episodes from video storage too

### Phase 6 - Final polish for submission

1. Confirm all command outputs match required text exactly.
2. Add full Javadocs (interfaces, classes, preconditions).
3. Update UML class/interface hierarchy.
4. Run through full manual command script.

## Suggested class checklist

- Interfaces:
  - `Video`, `PublishableVideo`, `PremiumVideo`, `Podcast`, `Show`, `Subtitle`, `Youvideo`
- Core implementations:
  - `VideoClass`, `PublishableVideoClass`, `PremiumVideoClass`, `EpisodeClass`
  - `PodcastClass`, `ShowClass`, `SubtitleClass`
  - `YouvideoClass`

(Names can vary, but keep them consistent and simple.)

## How we will work together (interactive tutoring mode)

For each task we do:

1. I give you the exact objective.
2. I give a small class/method checklist.
3. You implement it.
4. I review your code and explain OOP decisions + common exam defense questions.
5. Then we move to the next task.

## Learning strategy (to pass test + defend project)

For every class you write, prepare 4 quick defense points:

1. Responsibility: why this class exists (single responsibility).
2. Relations: inheritance vs composition choice.
3. Encapsulation: what is private and why.
4. Extensibility: how this design supports future features.

If you can explain these 4 points for each core class, your defense will be strong.
