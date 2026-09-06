package com.yfanads.android.adx.thirdpart.filedownload;

import android.app.Notification;
import android.content.Context;
import com.yfanads.android.adx.thirdpart.filedownload.model.FileDownloadHeader;
import com.yfanads.android.adx.thirdpart.filedownload.services.FDServiceSharedHandler;
import com.yfanads.android.adx.thirdpart.filedownload.util.FileDownloadProperties;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class FileDownloadServiceProxy implements IFileDownloadServiceProxy {
    private final IFileDownloadServiceProxy handler;

    /* JADX INFO: renamed from: com.yfanads.android.adx.thirdpart.filedownload.FileDownloadServiceProxy$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class HolderClass {
        private static final FileDownloadServiceProxy INSTANCE = new FileDownloadServiceProxy(null);

        private HolderClass() {
        }
    }

    public /* synthetic */ FileDownloadServiceProxy(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static FDServiceSharedHandler.FileDownloadServiceSharedConnection getConnectionListener() {
        if (getImpl().handler instanceof FileDownloadServiceSharedTransmit) {
            return (FDServiceSharedHandler.FileDownloadServiceSharedConnection) getImpl().handler;
        }
        return null;
    }

    public static FileDownloadServiceProxy getImpl() {
        return HolderClass.INSTANCE;
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.IFileDownloadServiceProxy
    public void bindStartByContext(Context context) {
        this.handler.bindStartByContext(context);
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.IFileDownloadServiceProxy
    public void clearAllTaskData() {
        this.handler.clearAllTaskData();
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.IFileDownloadServiceProxy
    public boolean clearTaskData(int i) {
        return this.handler.clearTaskData(i);
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.IFileDownloadServiceProxy
    public long getSofar(int i) {
        return this.handler.getSofar(i);
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.IFileDownloadServiceProxy
    public byte getStatus(int i) {
        return this.handler.getStatus(i);
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.IFileDownloadServiceProxy
    public long getTotal(int i) {
        return this.handler.getTotal(i);
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.IFileDownloadServiceProxy
    public boolean isConnected() {
        return this.handler.isConnected();
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.IFileDownloadServiceProxy
    public boolean isDownloading(String str, String str2) {
        return this.handler.isDownloading(str, str2);
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.IFileDownloadServiceProxy
    public boolean isIdle() {
        return this.handler.isIdle();
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.IFileDownloadServiceProxy
    public boolean isRunServiceForeground() {
        return this.handler.isRunServiceForeground();
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.IFileDownloadServiceProxy
    public boolean pause(int i) {
        return this.handler.pause(i);
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.IFileDownloadServiceProxy
    public void pauseAllTasks() {
        this.handler.pauseAllTasks();
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.IFileDownloadServiceProxy
    public boolean setMaxNetworkThreadCount(int i) {
        return this.handler.setMaxNetworkThreadCount(i);
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.IFileDownloadServiceProxy
    public boolean start(String str, String str2, boolean z, int i, int i2, int i3, boolean z2, FileDownloadHeader fileDownloadHeader, boolean z3) {
        return this.handler.start(str, str2, z, i, i2, i3, z2, fileDownloadHeader, z3);
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.IFileDownloadServiceProxy
    public void startForeground(int i, Notification notification) {
        this.handler.startForeground(i, notification);
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.IFileDownloadServiceProxy
    public void stopForeground(boolean z) {
        this.handler.stopForeground(z);
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.IFileDownloadServiceProxy
    public void unbindByContext(Context context) {
        this.handler.unbindByContext(context);
    }

    private FileDownloadServiceProxy() {
        this.handler = FileDownloadProperties.getImpl().processNonSeparate ? new FileDownloadServiceSharedTransmit() : new FileDownloadServiceUIGuard();
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.IFileDownloadServiceProxy
    public void bindStartByContext(Context context, Runnable runnable) {
        this.handler.bindStartByContext(context, runnable);
    }
}
