package youvideo.video;

public abstract class VideoClass {
    //protected is used:-- let see how this will work ;
    protected String uid;
    protected String duration;
    protected String fileLocation;
    protected String language ;// this is meant to be 2encodedcapital letters;

    public VideoClass(String uid, String duration, String fileLocation, String language){
        this.uid = uid;
     this.duration= duration;
     this.fileLocation = fileLocation;
     this.language= language;
    }
    //get the uid ....i don't know if this is necessary !
    public String getUid() {
        return uid;
    };
    //get the Language .... i don't know if this is necessary !
    public String getLanguage() {
        return language;
    };
    //get the Duration  ....i don't know if this is necessary !
    public String getDuration() {
        return duration;
    };
    //get the fileLocation ....i don't know if this is necessary !
    public String getFileLocation() {
        return fileLocation;
    };


}
