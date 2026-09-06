package com.yfanads.android.adx.thirdpart.filedownload.download;

import com.yfanads.android.adx.thirdpart.filedownload.connection.FileDownloadConnection;
import com.yfanads.android.adx.thirdpart.filedownload.database.FileDownloadDatabase;
import com.yfanads.android.adx.thirdpart.filedownload.model.FileDownloadModel;
import com.yfanads.android.adx.thirdpart.filedownload.services.DownloadMgrInitialParams;
import com.yfanads.android.adx.thirdpart.filedownload.services.ForegroundServiceConfig;
import com.yfanads.android.adx.thirdpart.filedownload.stream.FileDownloadOutputStream;
import com.yfanads.android.adx.thirdpart.filedownload.util.FileDownloadHelper;
import com.yfanads.android.adx.thirdpart.filedownload.util.FileDownloadLog;
import com.yfanads.android.adx.thirdpart.filedownload.util.FileDownloadUtils;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class CustomComponentHolder {
    private FileDownloadHelper.ConnectionCountAdapter connectionCountAdapter;
    private FileDownloadHelper.ConnectionCreator connectionCreator;
    private FileDownloadDatabase database;
    private ForegroundServiceConfig foregroundServiceConfig;
    private FileDownloadHelper.IdGenerator idGenerator;
    private DownloadMgrInitialParams initialParams;
    private FileDownloadHelper.OutputStreamCreator outputStreamCreator;

    public static final class LazyLoader {
        private static final CustomComponentHolder INSTANCE = new CustomComponentHolder();

        private LazyLoader() {
        }
    }

    public static CustomComponentHolder getImpl() {
        return LazyLoader.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:56:0x0110 A[Catch: all -> 0x013a, TryCatch #1 {all -> 0x013a, blocks: (B:52:0x00ec, B:36:0x00a0, B:41:0x00c7, B:43:0x00ce, B:47:0x00db, B:50:0x00e6, B:54:0x00fa, B:56:0x0110, B:58:0x0114, B:59:0x012c, B:60:0x0134), top: B:78:0x00ec }] */
    /* JADX WARN: Code duplicated, block: B:58:0x0114 A[Catch: all -> 0x013a, TryCatch #1 {all -> 0x013a, blocks: (B:52:0x00ec, B:36:0x00a0, B:41:0x00c7, B:43:0x00ce, B:47:0x00db, B:50:0x00e6, B:54:0x00fa, B:56:0x0110, B:58:0x0114, B:59:0x012c, B:60:0x0134), top: B:78:0x00ec }] */
    /* JADX WARN: Code duplicated, block: B:74:0x0187  */
    private static void maintainDatabase(FileDownloadDatabase.Maintainer maintainer) throws Throwable {
        String str;
        int id;
        int iTransOldId;
        String str2 = "refreshed data count: %d , delete data count: %d, reset id count: %d. consume %d";
        Iterator<FileDownloadModel> it = maintainer.iterator();
        FileDownloadHelper.IdGenerator idGeneratorInstance = getImpl().getIdGeneratorInstance();
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        while (it.hasNext()) {
            try {
                try {
                    FileDownloadModel next = it.next();
                    if (next.getStatus() == 3 || next.getStatus() == 2 || next.getStatus() == -1 || (next.getStatus() == 1 && next.getSoFar() > 0)) {
                        next.setStatus((byte) -2);
                    }
                    String targetFilePath = next.getTargetFilePath();
                    try {
                        if (targetFilePath == null) {
                            str = str2;
                            jCurrentTimeMillis = jCurrentTimeMillis;
                        } else {
                            File file = new File(targetFilePath);
                            if (next.getStatus() == -2) {
                                str = str2;
                                try {
                                    if (FileDownloadUtils.isBreakpointAvailable(next.getId(), next, next.getPath(), null)) {
                                        File file2 = new File(next.getTempFilePath());
                                        if (!file2.exists() && file.exists()) {
                                            boolean zRenameTo = file.renameTo(file2);
                                            if (FileDownloadLog.NEED_LOG) {
                                                FileDownloadLog.d(FileDownloadDatabase.class, "resume from the old no-temp-file architecture [%B], [%s]->[%s]", Boolean.valueOf(zRenameTo), file.getPath(), file2.getPath());
                                            }
                                        }
                                    }
                                    if (next.getStatus() == 1 || next.getSoFar() > 0) {
                                        if (FileDownloadUtils.isBreakpointAvailable(next.getId(), next) && !file.exists()) {
                                            id = next.getId();
                                            iTransOldId = idGeneratorInstance.transOldId(id, next.getUrl(), next.getPath(), next.isPathAsDirectory());
                                            if (iTransOldId != id) {
                                                if (FileDownloadLog.NEED_LOG) {
                                                    FileDownloadLog.d(FileDownloadDatabase.class, "the id is changed on restoring from db: old[%d] -> new[%d]", Integer.valueOf(id), Integer.valueOf(iTransOldId));
                                                }
                                                next.setId(iTransOldId);
                                                maintainer.changeFileDownloadModelId(id, next);
                                                j++;
                                            }
                                            maintainer.onRefreshedValidData(next);
                                            j3++;
                                        }
                                        str2 = str;
                                        jCurrentTimeMillis = jCurrentTimeMillis;
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    jCurrentTimeMillis = jCurrentTimeMillis;
                                    str2 = str;
                                    FileDownloadUtils.markConverted(FileDownloadHelper.getAppContext());
                                    maintainer.onFinishMaintain();
                                    if (FileDownloadLog.NEED_LOG) {
                                        FileDownloadLog.d(FileDownloadDatabase.class, str2, Long.valueOf(j3), Long.valueOf(j2), Long.valueOf(j), Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
                                    }
                                    throw th;
                                }
                            } else {
                                str = str2;
                            }
                            if (next.getStatus() == 1) {
                            }
                            if (FileDownloadUtils.isBreakpointAvailable(next.getId(), next)) {
                                id = next.getId();
                                iTransOldId = idGeneratorInstance.transOldId(id, next.getUrl(), next.getPath(), next.isPathAsDirectory());
                                if (iTransOldId != id) {
                                    if (FileDownloadLog.NEED_LOG) {
                                        FileDownloadLog.d(FileDownloadDatabase.class, "the id is changed on restoring from db: old[%d] -> new[%d]", Integer.valueOf(id), Integer.valueOf(iTransOldId));
                                    }
                                    next.setId(iTransOldId);
                                    maintainer.changeFileDownloadModelId(id, next);
                                    j++;
                                }
                                maintainer.onRefreshedValidData(next);
                                j3++;
                                str2 = str;
                                jCurrentTimeMillis = jCurrentTimeMillis;
                            }
                        }
                        it.remove();
                        maintainer.onRemovedInvalidData(next);
                        j2++;
                        str2 = str;
                        jCurrentTimeMillis = jCurrentTimeMillis;
                    } catch (Throwable th2) {
                        th = th2;
                        str2 = str;
                        FileDownloadUtils.markConverted(FileDownloadHelper.getAppContext());
                        maintainer.onFinishMaintain();
                        if (FileDownloadLog.NEED_LOG) {
                            FileDownloadLog.d(FileDownloadDatabase.class, str2, Long.valueOf(j3), Long.valueOf(j2), Long.valueOf(j), Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    jCurrentTimeMillis = jCurrentTimeMillis;
                    FileDownloadUtils.markConverted(FileDownloadHelper.getAppContext());
                    maintainer.onFinishMaintain();
                    if (FileDownloadLog.NEED_LOG) {
                        FileDownloadLog.d(FileDownloadDatabase.class, str2, Long.valueOf(j3), Long.valueOf(j2), Long.valueOf(j), Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
                    }
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
            }
        }
        String str3 = str2;
        long j4 = jCurrentTimeMillis;
        FileDownloadUtils.markConverted(FileDownloadHelper.getAppContext());
        maintainer.onFinishMaintain();
        if (FileDownloadLog.NEED_LOG) {
            FileDownloadLog.d(FileDownloadDatabase.class, str3, Long.valueOf(j3), Long.valueOf(j2), Long.valueOf(j), Long.valueOf(System.currentTimeMillis() - j4));
        }
    }

    public FileDownloadConnection createConnection(String str) throws IOException {
        return getConnectionCreator().create(str);
    }

    public FileDownloadOutputStream createOutputStream(File file) throws IOException {
        return getOutputStreamCreator().create(file);
    }

    public int determineConnectionCount(int i, String str, String str2, long j) {
        return getConnectionCountAdapter().determineConnectionCount(i, str, str2, j);
    }

    public int getMaxNetworkThreadCount() {
        return getDownloadMgrInitialParams().getMaxNetworkThreadCount();
    }

    public boolean isSupportSeek() {
        return getOutputStreamCreator().supportSeek();
    }

    public void setInitCustomMaker(DownloadMgrInitialParams.InitCustomMaker initCustomMaker) {
        synchronized (this) {
            this.initialParams = new DownloadMgrInitialParams(initCustomMaker);
            this.connectionCreator = null;
            this.outputStreamCreator = null;
            this.database = null;
            this.idGenerator = null;
        }
    }

    private FileDownloadHelper.ConnectionCountAdapter getConnectionCountAdapter() {
        FileDownloadHelper.ConnectionCountAdapter connectionCountAdapter = this.connectionCountAdapter;
        if (connectionCountAdapter != null) {
            return connectionCountAdapter;
        }
        synchronized (this) {
            if (this.connectionCountAdapter == null) {
                this.connectionCountAdapter = getDownloadMgrInitialParams().createConnectionCountAdapter();
            }
        }
        return this.connectionCountAdapter;
    }

    private FileDownloadHelper.ConnectionCreator getConnectionCreator() {
        FileDownloadHelper.ConnectionCreator connectionCreator = this.connectionCreator;
        if (connectionCreator != null) {
            return connectionCreator;
        }
        synchronized (this) {
            if (this.connectionCreator == null) {
                this.connectionCreator = getDownloadMgrInitialParams().createConnectionCreator();
            }
        }
        return this.connectionCreator;
    }

    private DownloadMgrInitialParams getDownloadMgrInitialParams() {
        DownloadMgrInitialParams downloadMgrInitialParams = this.initialParams;
        if (downloadMgrInitialParams != null) {
            return downloadMgrInitialParams;
        }
        synchronized (this) {
            if (this.initialParams == null) {
                this.initialParams = new DownloadMgrInitialParams();
            }
        }
        return this.initialParams;
    }

    private FileDownloadHelper.OutputStreamCreator getOutputStreamCreator() {
        FileDownloadHelper.OutputStreamCreator outputStreamCreator = this.outputStreamCreator;
        if (outputStreamCreator != null) {
            return outputStreamCreator;
        }
        synchronized (this) {
            if (this.outputStreamCreator == null) {
                this.outputStreamCreator = getDownloadMgrInitialParams().createOutputStreamCreator();
            }
        }
        return this.outputStreamCreator;
    }

    public FileDownloadDatabase getDatabaseInstance() {
        FileDownloadDatabase fileDownloadDatabase = this.database;
        if (fileDownloadDatabase != null) {
            return fileDownloadDatabase;
        }
        synchronized (this) {
            if (this.database == null) {
                FileDownloadDatabase fileDownloadDatabaseCreateDatabase = getDownloadMgrInitialParams().createDatabase();
                this.database = fileDownloadDatabaseCreateDatabase;
                maintainDatabase(fileDownloadDatabaseCreateDatabase.maintainer());
            }
        }
        return this.database;
    }

    public ForegroundServiceConfig getForegroundConfigInstance() {
        ForegroundServiceConfig foregroundServiceConfig = this.foregroundServiceConfig;
        if (foregroundServiceConfig != null) {
            return foregroundServiceConfig;
        }
        synchronized (this) {
            if (this.foregroundServiceConfig == null) {
                this.foregroundServiceConfig = getDownloadMgrInitialParams().createForegroundServiceConfig();
            }
        }
        return this.foregroundServiceConfig;
    }

    public FileDownloadHelper.IdGenerator getIdGeneratorInstance() {
        FileDownloadHelper.IdGenerator idGenerator = this.idGenerator;
        if (idGenerator != null) {
            return idGenerator;
        }
        synchronized (this) {
            if (this.idGenerator == null) {
                this.idGenerator = getDownloadMgrInitialParams().createIdGenerator();
            }
        }
        return this.idGenerator;
    }
}
