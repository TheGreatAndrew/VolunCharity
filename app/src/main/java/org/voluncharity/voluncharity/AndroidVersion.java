package org.voluncharity.voluncharity;

public class AndroidVersion {
    private String VersionName;
    private String ImageURL;

    public String getVersionName(){
        return this.VersionName;
    }

    public void setVersionName(String VN){
        this.VersionName = VN;
    }

    public String getImageURL(){
        return this.ImageURL;
    }

    public void setImageURL(String url){
        this.ImageURL = url;
    }
}
