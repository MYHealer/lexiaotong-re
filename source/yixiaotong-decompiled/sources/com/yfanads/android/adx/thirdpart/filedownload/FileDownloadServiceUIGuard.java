package com.yfanads.android.adx.thirdpart.filedownload;

import android.app.Notification;
import android.os.IBinder;
import android.os.RemoteException;
import com.yfanads.android.adx.thirdpart.filedownload.i.IFileDownloadIPCCallback;
import com.yfanads.android.adx.thirdpart.filedownload.i.IFileDownloadIPCService;
import com.yfanads.android.adx.thirdpart.filedownload.message.MessageSnapshot;
import com.yfanads.android.adx.thirdpart.filedownload.message.MessageSnapshotFlow;
import com.yfanads.android.adx.thirdpart.filedownload.model.FileDownloadHeader;
import com.yfanads.android.adx.thirdpart.filedownload.services.BaseFileServiceUIGuard;
import com.yfanads.android.adx.thirdpart.filedownload.services.FileDownloadService;
import com.yfanads.android.adx.thirdpart.filedownload.util.DownloadServiceNotConnectedHelper;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
class FileDownloadServiceUIGuard extends BaseFileServiceUIGuard<FileDownloadServiceCallback, IFileDownloadIPCService> {

    public static class FileDownloadServiceCallback extends IFileDownloadIPCCallback.Stub {
        @Override // com.yfanads.android.adx.thirdpart.filedownload.i.IFileDownloadIPCCallback
        public void callback(MessageSnapshot messageSnapshot) throws RemoteException {
            MessageSnapshotFlow.getImpl().inflow(messageSnapshot);
        }
    }

    public FileDownloadServiceUIGuard() {
        super(FileDownloadService.SeparateProcessService.class);
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.IFileDownloadServiceProxy
    public void clearAllTaskData() {
        if (!isConnected()) {
            DownloadServiceNotConnectedHelper.clearAllTaskData();
            return;
        }
        try {
            getService().clearAllTaskData();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.IFileDownloadServiceProxy
    public boolean clearTaskData(int i) {
        if (!isConnected()) {
            return DownloadServiceNotConnectedHelper.clearTaskData(i);
        }
        try {
            return getService().clearTaskData(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.IFileDownloadServiceProxy
    public long getSofar(int i) {
        if (!isConnected()) {
            return DownloadServiceNotConnectedHelper.getSofar(i);
        }
        try {
            return getService().getSofar(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return 0L;
        }
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.IFileDownloadServiceProxy
    public byte getStatus(int i) {
        if (!isConnected()) {
            return DownloadServiceNotConnectedHelper.getStatus(i);
        }
        try {
            return getService().getStatus(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return (byte) 0;
        }
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.IFileDownloadServiceProxy
    public long getTotal(int i) {
        if (!isConnected()) {
            return DownloadServiceNotConnectedHelper.getTotal(i);
        }
        try {
            return getService().getTotal(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return 0L;
        }
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.IFileDownloadServiceProxy
    public boolean isDownloading(String str, String str2) {
        if (!isConnected()) {
            return DownloadServiceNotConnectedHelper.isDownloading(str, str2);
        }
        try {
            return getService().checkDownloading(str, str2);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.IFileDownloadServiceProxy
    public boolean isIdle() {
        if (!isConnected()) {
            return DownloadServiceNotConnectedHelper.isIdle();
        }
        try {
            getService().isIdle();
            return true;
        } catch (RemoteException e) {
            e.printStackTrace();
            return true;
        }
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.IFileDownloadServiceProxy
    public boolean pause(int i) {
        if (!isConnected()) {
            return DownloadServiceNotConnectedHelper.pause(i);
        }
        try {
            return getService().pause(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.IFileDownloadServiceProxy
    public void pauseAllTasks() {
        if (!isConnected()) {
            DownloadServiceNotConnectedHelper.pauseAllTasks();
            return;
        }
        try {
            getService().pauseAllTasks();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.IFileDownloadServiceProxy
    public boolean setMaxNetworkThreadCount(int i) {
        if (!isConnected()) {
            return DownloadServiceNotConnectedHelper.setMaxNetworkThreadCount(i);
        }
        try {
            return getService().setMaxNetworkThreadCount(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.IFileDownloadServiceProxy
    public boolean start(String str, String str2, boolean z, int i, int i2, int i3, boolean z2, FileDownloadHeader fileDownloadHeader, boolean z3) {
        if (!isConnected()) {
            return DownloadServiceNotConnectedHelper.start(str, str2, z);
        }
        try {
            getService().start(str, str2, z, i, i2, i3, z2, fileDownloadHeader, z3);
            return true;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.IFileDownloadServiceProxy
    public void startForeground(int i, Notification notification) {
        if (!isConnected()) {
            DownloadServiceNotConnectedHelper.startForeground(i, notification);
            return;
        }
        try {
            getService().startForeground(i, notification);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.IFileDownloadServiceProxy
    public void stopForeground(boolean z) {
        if (!isConnected()) {
            DownloadServiceNotConnectedHelper.stopForeground(z);
            return;
        }
        try {
            getService().stopForeground(z);
        } catch (RemoteException e) {
            e.printStackTrace();
        } finally {
            this.runServiceForeground = false;
        }
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.services.BaseFileServiceUIGuard
    public IFileDownloadIPCService asInterface(IBinder iBinder) {
        return IFileDownloadIPCService.Stub.asInterface(iBinder);
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.services.BaseFileServiceUIGuard
    public FileDownloadServiceCallback createCallback() {
        return new FileDownloadServiceCallback();
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.services.BaseFileServiceUIGuard
    public void registerCallback(IFileDownloadIPCService iFileDownloadIPCService, FileDownloadServiceCallback fileDownloadServiceCallback) throws RemoteException {
        iFileDownloadIPCService.registerCallback(fileDownloadServiceCallback);
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.services.BaseFileServiceUIGuard
    public void unregisterCallback(IFileDownloadIPCService iFileDownloadIPCService, FileDownloadServiceCallback fileDownloadServiceCallback) throws RemoteException {
        iFileDownloadIPCService.unregisterCallback(fileDownloadServiceCallback);
    }
}
