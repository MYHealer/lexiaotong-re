package org.apache.commons.io;

import java.io.File;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
@Deprecated
public class FileCleaner {
    static final FileCleaningTracker theInstance = new FileCleaningTracker();

    public static FileCleaningTracker getInstance() {
        return theInstance;
    }

    @Deprecated
    public static void track(File file, Object obj) {
        theInstance.track(file, obj);
    }

    @Deprecated
    public static void track(File file, Object obj, FileDeleteStrategy fileDeleteStrategy) {
        theInstance.track(file, obj, fileDeleteStrategy);
    }

    @Deprecated
    public static void track(String str, Object obj) {
        theInstance.track(str, obj);
    }

    @Deprecated
    public static void track(String str, Object obj, FileDeleteStrategy fileDeleteStrategy) {
        theInstance.track(str, obj, fileDeleteStrategy);
    }

    @Deprecated
    public static int getTrackCount() {
        return theInstance.getTrackCount();
    }

    @Deprecated
    public static synchronized void exitWhenFinished() {
        theInstance.exitWhenFinished();
    }
}
