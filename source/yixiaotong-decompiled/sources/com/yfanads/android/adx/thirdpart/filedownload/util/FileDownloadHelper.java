package com.yfanads.android.adx.thirdpart.filedownload.util;

import android.content.Context;
import com.yfanads.android.adx.thirdpart.filedownload.IThreadPoolMonitor;
import com.yfanads.android.adx.thirdpart.filedownload.connection.FileDownloadConnection;
import com.yfanads.android.adx.thirdpart.filedownload.database.FileDownloadDatabase;
import com.yfanads.android.adx.thirdpart.filedownload.exception.PathConflictException;
import com.yfanads.android.adx.thirdpart.filedownload.message.MessageSnapshotFlow;
import com.yfanads.android.adx.thirdpart.filedownload.message.MessageSnapshotTaker;
import com.yfanads.android.adx.thirdpart.filedownload.model.FileDownloadModel;
import com.yfanads.android.adx.thirdpart.filedownload.stream.FileDownloadOutputStream;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class FileDownloadHelper {
    private static Context APP_CONTEXT;

    public interface ConnectionCountAdapter {
        int determineConnectionCount(int i, String str, String str2, long j);
    }

    public interface ConnectionCreator {
        FileDownloadConnection create(String str) throws IOException;
    }

    public interface DatabaseCustomMaker {
        FileDownloadDatabase customMake();
    }

    public interface IdGenerator {
        int generateId(String str, String str2, boolean z);

        int transOldId(int i, String str, String str2, boolean z);
    }

    public interface OutputStreamCreator {
        FileDownloadOutputStream create(File file) throws IOException;

        boolean supportSeek();
    }

    public static Context getAppContext() {
        return APP_CONTEXT;
    }

    public static void holdContext(Context context) {
        APP_CONTEXT = context;
    }

    public static boolean inspectAndInflowConflictPath(int i, long j, String str, String str2, IThreadPoolMonitor iThreadPoolMonitor) {
        int iFindRunningTaskIdBySameTempPath;
        if (str2 == null || str == null || (iFindRunningTaskIdBySameTempPath = iThreadPoolMonitor.findRunningTaskIdBySameTempPath(str, i)) == 0) {
            return false;
        }
        MessageSnapshotFlow.getImpl().inflow(MessageSnapshotTaker.catchException(i, j, new PathConflictException(iFindRunningTaskIdBySameTempPath, str, str2)));
        return true;
    }

    public static boolean inspectAndInflowDownloaded(int i, String str, boolean z, boolean z2) {
        if (!z && str != null) {
            File file = new File(str);
            if (file.exists()) {
                MessageSnapshotFlow.getImpl().inflow(MessageSnapshotTaker.catchCanReusedOldFile(i, file, z2));
                return true;
            }
        }
        return false;
    }

    public static boolean inspectAndInflowDownloading(int i, FileDownloadModel fileDownloadModel, IThreadPoolMonitor iThreadPoolMonitor, boolean z) {
        if (!iThreadPoolMonitor.isDownloading(fileDownloadModel)) {
            return false;
        }
        MessageSnapshotFlow.getImpl().inflow(MessageSnapshotTaker.catchWarn(i, fileDownloadModel.getSoFar(), fileDownloadModel.getTotal(), z));
        return true;
    }
}
