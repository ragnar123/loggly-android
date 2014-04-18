package net.escosoft.loggly.lib.model;

/**
 * Created by Victor on 18/04/2014.
 */
public class Tag {

    private String mTagName;

    public Tag(String tagName){
        mTagName = tagName;
    }

    public String getTagName() {
        return mTagName;
    }

    public void setTagName(String mTagName) {
        this.mTagName = mTagName;
    }
}
