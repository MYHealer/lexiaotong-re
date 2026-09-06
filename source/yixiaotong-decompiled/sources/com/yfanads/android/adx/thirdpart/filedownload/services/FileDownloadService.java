package com.yfanads.android.adx.thirdpart.filedownload.services;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.yfanads.android.adx.thirdpart.filedownload.PauseAllMarker;
import com.yfanads.android.adx.thirdpart.filedownload.download.CustomComponentHolder;
import com.yfanads.android.adx.thirdpart.filedownload.i.IFileDownloadIPCService;
import com.yfanads.android.adx.thirdpart.filedownload.util.ExtraKeys;
import com.yfanads.android.adx.thirdpart.filedownload.util.FileDownloadHelper;
import com.yfanads.android.adx.thirdpart.filedownload.util.FileDownloadLog;
import com.yfanads.android.adx.thirdpart.filedownload.util.FileDownloadProperties;
import com.yfanads.android.adx.thirdpart.filedownload.util.FileDownloadUtils;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class FileDownloadService extends Service {
    private IFileDownloadServiceHandler handler;
    private PauseAllMarker pauseAllMarker;

    public static class SeparateProcessService extends FileDownloadService {
    }

    public static class SharedMainProcessService extends FileDownloadService {
    }

    private void inspectRunServiceForeground(Intent intent) {
        if (intent != null && intent.getBooleanExtra(ExtraKeys.IS_FOREGROUND, false)) {
            try {
                ForegroundServiceConfig foregroundConfigInstance = CustomComponentHolder.getImpl().getForegroundConfigInstance();
                if (foregroundConfigInstance.isNeedRecreateChannelId()) {
                    NotificationChannel notificationChannel = new NotificationChannel(foregroundConfigInstance.getNotificationChannelId(), foregroundConfigInstance.getNotificationChannelName(), 2);
                    NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
                    if (notificationManager == null) {
                        return;
                    } else {
                        notificationManager.createNotificationChannel(notificationChannel);
                    }
                }
                startForeground(foregroundConfigInstance.getNotificationId(), foregroundConfigInstance.getNotification(this));
                if (FileDownloadLog.NEED_LOG) {
                    FileDownloadLog.d(this, "run service foreground with config: %s", foregroundConfigInstance);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.handler.onBind(intent);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        FileDownloadHelper.holdContext(this);
        try {
            FileDownloadUtils.setMinProgressStep(FileDownloadProperties.getImpl().downloadMinProgressStep);
            FileDownloadUtils.setMinProgressTime(FileDownloadProperties.getImpl().downloadMinProgressTime);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        FileDownloadManager fileDownloadManager = new FileDownloadManager();
        if (FileDownloadProperties.getImpl().processNonSeparate) {
            this.handler = new FDServiceSharedHandler(new WeakReference(this), fileDownloadManager);
        } else {
            this.handler = new FDServiceSeparateHandler(new WeakReference(this), fileDownloadManager);
        }
        PauseAllMarker.clearMarker();
        PauseAllMarker pauseAllMarker = new PauseAllMarker((IFileDownloadIPCService) this.handler);
        this.pauseAllMarker = pauseAllMarker;
        pauseAllMarker.startPauseAllLooperCheck();
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.pauseAllMarker.stopPauseAllLooperCheck();
        stopForeground(true);
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        this.handler.onStartCommand(intent, i, i2);
        inspectRunServiceForeground(intent);
        return 1;
    }
}
