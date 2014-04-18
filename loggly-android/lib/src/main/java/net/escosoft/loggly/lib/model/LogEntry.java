package net.escosoft.loggly.lib.model;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Victor on 18/04/2014.
 */
public class LogEntry {

    private Set<String> mTags;
    private String mMessage;
    private String mLocation;
    private int mType;

    public static final int ERROR = 1;
    public static final int VERBOSE = 2;
    public static final int WARNING = 3;
    public static final int INFO = 4;

    public LogEntry(String message, int type) {
        mMessage = message;
        mType = type;

        mTags = new TreeSet<String>();
        mLocation = getStackLocation();
    }

    /**
     * Add a tag to the log entry.
     *
     * @param tag Tag to add
     * @return True on success or false if the tag already exists.
     */
    public boolean addTag(String tag) {
        return mTags.add(tag);
    }

    /**
     * Add a tag to the log entry.
     *
     * @param tag Tag to add
     * @return True on success or false if the tag already exists.
     */
    public boolean addTag(Tag tag){
        return addTag(tag.getTagName());
    }

    /**
     * Delete a tag from the log entry
     * @param tag Tag to remove
     * @return True if the tag has been deleted, false if the tag was not in the tag list.
     */
    public boolean removeTag(String tag) {
        return mTags.remove(tag);
    }

    /**
     * Add a tag to the log entry.
     *
     * @param tag Tag to add
     * @return True on success or false if the tag already exists.
     */
    public boolean removeTag(Tag tag){
        return removeTag(tag.getTagName());
    }

    /**
     * Get the location of the last called.
     *
     * @return The location of last called in the following format:
     * ClassName.MethodName:LineNumber
     */
    private String getStackLocation() {
        StackTraceElement[] elements = Thread.currentThread().getStackTrace();
        return elements[0].getClassName() + "." + elements[0].getMethodName() + ":" + elements[0].getLineNumber();
    }
}

