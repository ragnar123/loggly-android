package net.escosoft.loggly.lib;

import net.escosoft.loggly.lib.model.LogEntry;

import java.util.ArrayList;

/**
 * Created by Victor on 18/04/2014.
 */
public class Loggly {

    private static ArrayList<LogEntry> mLogEntries;

    public static void addLogEntry(String message, int type, boolean postLater) {
        LogEntry logEntry = new LogEntry(message, type);

        //If the flag is activated, add it to the queue.
        if (postLater) {
            mLogEntries.add(logEntry);
        } else {

        }
    }
}
