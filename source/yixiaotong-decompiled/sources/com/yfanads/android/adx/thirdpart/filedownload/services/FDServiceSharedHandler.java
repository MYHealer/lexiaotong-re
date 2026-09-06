package com.yfanads.android.adx.thirdpart.filedownload.services;

import android.app.Notification;
import android.content.Intent;
import android.os.IBinder;
import com.yfanads.android.adx.thirdpart.filedownload.FileDownloadServiceProxy;
import com.yfanads.android.adx.thirdpart.filedownload.i.IFileDownloadIPCCallback;
import com.yfanads.android.adx.thirdpart.filedownload.i.IFileDownloadIPCService;
import com.yfanads.android.adx.thirdpart.filedownload.model.FileDownloadHeader;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class FDServiceSharedHandler extends IFileDownloadIPCService.Stub implements IFileDownloadServiceHandler {
    private final FileDownloadManager downloadManager;
    private final WeakReference<FileDownloadService> wService;

    public interface FileDownloadServiceSharedConnection {
        void onConnected(FDServiceSharedHandler fDServiceSharedHandler);

        void onDisconnected();
    }

    public FDServiceSharedHandler(WeakReference<FileDownloadService> weakReference, FileDownloadManager fileDownloadManager) {
        this.wService = weakReference;
        this.downloadManager = fileDownloadManager;
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.i.IFileDownloadIPCService
    public boolean checkDownloading(String str, String str2) {
        return this.downloadManager.isDownloading(str, str2);
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.i.IFileDownloadIPCService
    public void clearAllTaskData() {
        this.downloadManager.clearAllTaskData();
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.i.IFileDownloadIPCService
    public boolean clearTaskData(int i) {
        return this.downloadManager.clearTaskData(i);
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.i.IFileDownloadIPCService
    public long getSofar(int i) {
        return this.downloadManager.getSoFar(i);
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.i.IFileDownloadIPCService
    public byte getStatus(int i) {
        return this.downloadManager.getStatus(i);
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.i.IFileDownloadIPCService
    public long getTotal(int i) {
        return this.downloadManager.getTotal(i);
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.i.IFileDownloadIPCService
    public boolean isIdle() {
        return this.downloadManager.isIdle();
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.services.IFileDownloadServiceHandler
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.services.IFileDownloadServiceHandler
    public void onDestroy() {
        FileDownloadServiceProxy.getConnectionListener().onDisconnected();
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.services.IFileDownloadServiceHandler
    public void onStartCommand(Intent intent, int i, int i2) {
        FileDownloadServiceProxy.getConnectionListener().onConnected(this);
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.i.IFileDownloadIPCService
    public boolean pause(int i) {
        return this.downloadManager.pause(i);
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.i.IFileDownloadIPCService
    public void pauseAllTasks() {
        this.downloadManager.pauseAll();
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.i.IFileDownloadIPCService
    public void registerCallback(IFileDownloadIPCCallback iFileDownloadIPCCallback) {
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.i.IFileDownloadIPCService
    public boolean setMaxNetworkThreadCount(int i) {
        return this.downloadManager.setMaxNetworkThreadCount(i);
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.i.IFileDownloadIPCService
    public void start(String str, String str2, boolean z, int i, int i2, int i3, boolean z2, FileDownloadHeader fileDownloadHeader, boolean z3) {
        this.downloadManager.start(str, str2, z, i, i2, i3, z2, fileDownloadHeader, z3);
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.i.IFileDownloadIPCService
    public void startForeground(int i, Notification notification) {
        WeakReference<FileDownloadService> weakReference = this.wService;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.wService.get().startForeground(i, notification);
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.i.IFileDownloadIPCService
    public void stopForeground(boolean z) {
        WeakReference<FileDownloadService> weakReference = this.wService;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.wService.get().stopForeground(z);
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.i.IFileDownloadIPCService
    public void unregisterCallback(IFileDownloadIPCCallback iFileDownloadIPCCallback) {
    }
}
