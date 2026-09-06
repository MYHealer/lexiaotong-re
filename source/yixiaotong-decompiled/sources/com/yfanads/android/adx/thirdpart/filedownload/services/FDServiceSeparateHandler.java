package com.yfanads.android.adx.thirdpart.filedownload.services;

import android.app.Notification;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.yfanads.android.adx.thirdpart.filedownload.i.IFileDownloadIPCCallback;
import com.yfanads.android.adx.thirdpart.filedownload.i.IFileDownloadIPCService;
import com.yfanads.android.adx.thirdpart.filedownload.message.MessageSnapshot;
import com.yfanads.android.adx.thirdpart.filedownload.message.MessageSnapshotFlow;
import com.yfanads.android.adx.thirdpart.filedownload.model.FileDownloadHeader;
import com.yfanads.android.adx.thirdpart.filedownload.util.FileDownloadLog;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class FDServiceSeparateHandler extends IFileDownloadIPCService.Stub implements MessageSnapshotFlow.MessageReceiver, IFileDownloadServiceHandler {
    private final RemoteCallbackList<IFileDownloadIPCCallback> callbackList = new RemoteCallbackList<>();
    private final FileDownloadManager downloadManager;
    private final WeakReference<FileDownloadService> wService;

    public FDServiceSeparateHandler(WeakReference<FileDownloadService> weakReference, FileDownloadManager fileDownloadManager) {
        this.wService = weakReference;
        this.downloadManager = fileDownloadManager;
        MessageSnapshotFlow.getImpl().setReceiver(this);
    }

    private synchronized int callback(MessageSnapshot messageSnapshot) {
        int iBeginBroadcast;
        iBeginBroadcast = this.callbackList.beginBroadcast();
        for (int i = 0; i < iBeginBroadcast; i++) {
            try {
                try {
                    ((IFileDownloadIPCCallback) this.callbackList.getBroadcastItem(i)).callback(messageSnapshot);
                } catch (Throwable th) {
                    this.callbackList.finishBroadcast();
                    throw th;
                }
            } catch (RemoteException e) {
                FileDownloadLog.e(this, e, "callback error", new Object[0]);
                this.callbackList.finishBroadcast();
                return iBeginBroadcast;
            }
        }
        this.callbackList.finishBroadcast();
        return iBeginBroadcast;
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.i.IFileDownloadIPCService
    public boolean checkDownloading(String str, String str2) throws RemoteException {
        return this.downloadManager.isDownloading(str, str2);
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.i.IFileDownloadIPCService
    public void clearAllTaskData() throws RemoteException {
        this.downloadManager.clearAllTaskData();
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.i.IFileDownloadIPCService
    public boolean clearTaskData(int i) throws RemoteException {
        return this.downloadManager.clearTaskData(i);
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.i.IFileDownloadIPCService
    public long getSofar(int i) throws RemoteException {
        return this.downloadManager.getSoFar(i);
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.i.IFileDownloadIPCService
    public byte getStatus(int i) throws RemoteException {
        return this.downloadManager.getStatus(i);
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.i.IFileDownloadIPCService
    public long getTotal(int i) throws RemoteException {
        return this.downloadManager.getTotal(i);
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.i.IFileDownloadIPCService
    public boolean isIdle() throws RemoteException {
        return this.downloadManager.isIdle();
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.services.IFileDownloadServiceHandler
    public IBinder onBind(Intent intent) {
        return this;
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.services.IFileDownloadServiceHandler
    public void onDestroy() {
        MessageSnapshotFlow.getImpl().setReceiver(null);
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.services.IFileDownloadServiceHandler
    public void onStartCommand(Intent intent, int i, int i2) {
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.i.IFileDownloadIPCService
    public boolean pause(int i) throws RemoteException {
        return this.downloadManager.pause(i);
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.i.IFileDownloadIPCService
    public void pauseAllTasks() throws RemoteException {
        this.downloadManager.pauseAll();
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.message.MessageSnapshotFlow.MessageReceiver
    public void receive(MessageSnapshot messageSnapshot) {
        callback(messageSnapshot);
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.i.IFileDownloadIPCService
    public void registerCallback(IFileDownloadIPCCallback iFileDownloadIPCCallback) throws RemoteException {
        this.callbackList.register(iFileDownloadIPCCallback);
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.i.IFileDownloadIPCService
    public boolean setMaxNetworkThreadCount(int i) throws RemoteException {
        return this.downloadManager.setMaxNetworkThreadCount(i);
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.i.IFileDownloadIPCService
    public void start(String str, String str2, boolean z, int i, int i2, int i3, boolean z2, FileDownloadHeader fileDownloadHeader, boolean z3) throws RemoteException {
        this.downloadManager.start(str, str2, z, i, i2, i3, z2, fileDownloadHeader, z3);
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.i.IFileDownloadIPCService
    public void startForeground(int i, Notification notification) throws RemoteException {
        WeakReference<FileDownloadService> weakReference = this.wService;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.wService.get().startForeground(i, notification);
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.i.IFileDownloadIPCService
    public void stopForeground(boolean z) throws RemoteException {
        WeakReference<FileDownloadService> weakReference = this.wService;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.wService.get().stopForeground(z);
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.i.IFileDownloadIPCService
    public void unregisterCallback(IFileDownloadIPCCallback iFileDownloadIPCCallback) throws RemoteException {
        this.callbackList.unregister(iFileDownloadIPCCallback);
    }
}
