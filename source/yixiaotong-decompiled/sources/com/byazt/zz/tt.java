package com.byazt.zz;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.c.IDownloadFileUriProvider;
import com.byazt.c.IDownloadListener;
import com.byazt.c.md;
import com.byazt.c.yv;
import com.byazt.t.DownloadInfo;
import com.byazt.t.DownloadTask;
import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 189, 13})
public class tt {
    public String globalDefaultSavePath;
    public String globalDefaultSaveTempPath;

    public static DownloadTask with(Context context) {
        Downloader.getInstance(context);
        return new DownloadTask();
    }

    public void pause(int i) {
        uj.c().uj(i);
    }

    public int getDownloadId(String str, String str2) {
        return uj.c().c(str, str2);
    }

    public List<DownloadInfo> getDownloadInfoList(String str) {
        return uj.c().c(str);
    }

    public void cancel(int i) {
        cancel(i, true);
    }

    public void cancel(int i, boolean z) {
        uj.c().ve(i, z);
    }

    public void resume(int i) {
        uj.c().a(i);
    }

    public boolean canResume(int i) {
        return uj.c().n(i);
    }

    public void restart(int i) {
        uj.c().sp(i);
    }

    public void pauseAll() {
        uj.c().ve();
    }

    public List<DownloadInfo> getFailedDownloadInfosWithMimeType(String str) {
        return uj.c().tt(str);
    }

    public void restartAllFailedDownloadTasks(List<String> list) {
        uj.c().c(list);
    }

    public void restartAllPauseReserveOnWifiDownloadTasks(List<String> list) {
        uj.c().tt(list);
    }

    public long getCurBytes(int i) {
        return uj.c().x(i);
    }

    public int getStatus(int i) {
        return uj.c().i(i);
    }

    public boolean isDownloading(int i) {
        boolean zDa;
        if (com.byazt.w.c.c(4194304)) {
            synchronized (this) {
                zDa = uj.c().da(i);
            }
            return zDa;
        }
        return uj.c().da(i);
    }

    public DownloadInfo getDownloadInfo(int i) {
        return uj.c().sl(i);
    }

    public DownloadInfo getDownloadInfo(String str, String str2) {
        return uj.c().tt(str, str2);
    }

    public yv getDownloadNotificationEventListener(int i) {
        return uj.c().t(i);
    }

    public void setDownloadNotificationEventListener(int i, yv yvVar) {
        uj.c().c(i, yvVar);
    }

    public List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String str) {
        return uj.c().ve(str);
    }

    public void clearDownloadData(int i) {
        uj.c().uj(i, true);
    }

    public void clearDownloadData(int i, boolean z) {
        uj.c().uj(i, z);
    }

    public void forceDownloadIngoreRecommendSize(int i) {
        uj.c().yp(i);
    }

    @Deprecated
    public void removeTaskMainListener(int i) {
        uj.c().c(i, null, com.byazt.ev.a.MAIN, true);
    }

    public void removeMainThreadListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        uj.c().c(i, iDownloadListener, com.byazt.ev.a.MAIN, false);
    }

    @Deprecated
    public void setMainThreadListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        uj.c().tt(i, iDownloadListener, com.byazt.ev.a.MAIN, true);
    }

    @Deprecated
    public void setMainThreadListener(int i, IDownloadListener iDownloadListener, boolean z) {
        if (iDownloadListener == null) {
            return;
        }
        uj.c().c(i, iDownloadListener, com.byazt.ev.a.MAIN, true, z);
    }

    public void addMainThreadListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        uj.c().tt(i, iDownloadListener, com.byazt.ev.a.MAIN, false);
    }

    @Deprecated
    public void setSubThreadListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        uj.c().tt(i, iDownloadListener, com.byazt.ev.a.SUB, true);
    }

    public void addSubThreadListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        uj.c().tt(i, iDownloadListener, com.byazt.ev.a.SUB, false);
    }

    @Deprecated
    public void removeTaskSubListener(int i) {
        uj.c().c(i, null, com.byazt.ev.a.SUB, true);
    }

    public void removeSubThreadListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        uj.c().c(i, iDownloadListener, com.byazt.ev.a.SUB, false);
    }

    @Deprecated
    public void removeTaskNotificationListener(int i) {
        uj.c().c(i, null, com.byazt.ev.a.NOTIFICATION, true);
    }

    public void removeNotificationListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        uj.c().c(i, iDownloadListener, com.byazt.ev.a.NOTIFICATION, false);
    }

    @Deprecated
    public void setNotificationListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        uj.c().tt(i, iDownloadListener, com.byazt.ev.a.NOTIFICATION, true);
    }

    public void addNotificationListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        uj.c().tt(i, iDownloadListener, com.byazt.ev.a.NOTIFICATION, false);
    }

    public boolean isDownloadSuccessAndFileNotExist(DownloadInfo downloadInfo) {
        return uj.c().c(downloadInfo);
    }

    public boolean isHttpServiceInit() {
        return uj.c().uj();
    }

    public List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String str) {
        return uj.c().uj(str);
    }

    public List<DownloadInfo> getDownloadingDownloadInfosWithMimeType(String str) {
        return uj.c().n(str);
    }

    public List<DownloadInfo> getAllDownloadInfo() {
        return uj.c().n();
    }

    public void destoryDownloader() {
        ve.c();
    }

    public void setLogLevel(int i) {
        uj.c().m(i);
    }

    public void registerDownloadCacheSyncListener(com.byazt.c.sl slVar) {
        uj.c().c(slVar);
    }

    public void unRegisterDownloadCacheSyncListener(com.byazt.c.sl slVar) {
        uj.c().tt(slVar);
    }

    public boolean isDownloadCacheSyncSuccess() {
        return uj.c().a();
    }

    public void setDownloadInMultiProcess() {
        if (com.byazt.w.c.c(4194304)) {
            synchronized (this) {
                ve.tt();
            }
        } else {
            ve.tt();
        }
    }

    public IDownloadFileUriProvider getDownloadFileUriProvider(int i) {
        return uj.c().rh(i);
    }

    public void registerDownloaderProcessConnectedListener(md mdVar) {
        uj.c().c(mdVar);
    }

    public void unRegisterDownloaderProcessConnectedListener(md mdVar) {
        uj.c().tt(mdVar);
    }

    public boolean isDownloadServiceForeground(int i) {
        return uj.c().ve(i).tt();
    }

    public rh getReserveWifiStatusListener() {
        return ve.lr();
    }

    public void setReserveWifiStatusListener(rh rhVar) {
        ve.c(rhVar);
    }

    public void setThrottleNetSpeed(int i, long j) {
        uj.c().c(i, j);
    }

    public File getGlobalSaveDir() {
        return getGlobalSaveDir(this.globalDefaultSavePath, true);
    }

    public File getGlobalSaveTempDir() {
        return getGlobalSaveDir(this.globalDefaultSaveTempPath, false);
    }

    private File getGlobalSaveDir(String str, boolean z) {
        File file = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            File file2 = new File(str);
            try {
                if (!file2.exists()) {
                    file2.mkdirs();
                } else if (!file2.isDirectory()) {
                    if (!z) {
                        return null;
                    }
                    file2.delete();
                    file2.mkdirs();
                }
                return file2;
            } catch (Throwable unused) {
                file = file2;
                return file;
            }
        } catch (Throwable unused2) {
        }
    }

    public void setDefaultSavePath(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.globalDefaultSavePath = str;
    }

    public void setDefaultSaveTempPath(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.globalDefaultSaveTempPath = str;
    }
}
