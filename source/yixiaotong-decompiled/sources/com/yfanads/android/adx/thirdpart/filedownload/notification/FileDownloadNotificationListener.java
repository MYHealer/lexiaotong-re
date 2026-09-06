package com.yfanads.android.adx.thirdpart.filedownload.notification;

import com.yfanads.android.adx.thirdpart.filedownload.BaseDownloadTask;
import com.yfanads.android.adx.thirdpart.filedownload.FileDownloadList;
import com.yfanads.android.adx.thirdpart.filedownload.FileDownloadListener;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public abstract class FileDownloadNotificationListener extends FileDownloadListener {
    private final FileDownloadNotificationHelper helper;

    public FileDownloadNotificationListener(FileDownloadNotificationHelper fileDownloadNotificationHelper) {
        if (fileDownloadNotificationHelper == null) {
            throw new IllegalArgumentException("helper must not be null!");
        }
        this.helper = fileDownloadNotificationHelper;
    }

    public void addNotificationItem(int i) {
        BaseDownloadTask.IRunningTask iRunningTask;
        if (i == 0 || (iRunningTask = FileDownloadList.getImpl().get(i)) == null) {
            return;
        }
        addNotificationItem(iRunningTask.getOrigin());
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.FileDownloadListener
    public void blockComplete(BaseDownloadTask baseDownloadTask) {
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.FileDownloadListener
    public void completed(BaseDownloadTask baseDownloadTask) {
        destroyNotification(baseDownloadTask);
    }

    public abstract BaseNotificationItem create(BaseDownloadTask baseDownloadTask);

    public void destroyNotification(BaseDownloadTask baseDownloadTask) {
        if (disableNotification(baseDownloadTask)) {
            return;
        }
        this.helper.showIndeterminate(baseDownloadTask.getId(), baseDownloadTask.getStatus());
        BaseNotificationItem baseNotificationItemRemove = this.helper.remove(baseDownloadTask.getId());
        if (interceptCancel(baseDownloadTask, baseNotificationItemRemove) || baseNotificationItemRemove == null) {
            return;
        }
        baseNotificationItemRemove.cancel();
    }

    public boolean disableNotification(BaseDownloadTask baseDownloadTask) {
        return false;
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.FileDownloadListener
    public void error(BaseDownloadTask baseDownloadTask, Throwable th) {
        destroyNotification(baseDownloadTask);
    }

    public FileDownloadNotificationHelper getHelper() {
        return this.helper;
    }

    public boolean interceptCancel(BaseDownloadTask baseDownloadTask, BaseNotificationItem baseNotificationItem) {
        return false;
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.FileDownloadListener
    public void paused(BaseDownloadTask baseDownloadTask, int i, int i2) {
        destroyNotification(baseDownloadTask);
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.FileDownloadListener
    public void pending(BaseDownloadTask baseDownloadTask, int i, int i2) {
        addNotificationItem(baseDownloadTask);
        showIndeterminate(baseDownloadTask);
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.FileDownloadListener
    public void progress(BaseDownloadTask baseDownloadTask, int i, int i2) {
        showProgress(baseDownloadTask, i, i2);
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.FileDownloadListener
    public void retry(BaseDownloadTask baseDownloadTask, Throwable th, int i, int i2) {
        super.retry(baseDownloadTask, th, i, i2);
        showIndeterminate(baseDownloadTask);
    }

    public void showIndeterminate(BaseDownloadTask baseDownloadTask) {
        if (disableNotification(baseDownloadTask)) {
            return;
        }
        this.helper.showIndeterminate(baseDownloadTask.getId(), baseDownloadTask.getStatus());
    }

    public void showProgress(BaseDownloadTask baseDownloadTask, int i, int i2) {
        if (disableNotification(baseDownloadTask)) {
            return;
        }
        this.helper.showProgress(baseDownloadTask.getId(), baseDownloadTask.getSmallFileSoFarBytes(), baseDownloadTask.getSmallFileTotalBytes());
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.FileDownloadListener
    public void started(BaseDownloadTask baseDownloadTask) {
        super.started(baseDownloadTask);
        showIndeterminate(baseDownloadTask);
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.FileDownloadListener
    public void warn(BaseDownloadTask baseDownloadTask) {
    }

    public void addNotificationItem(BaseDownloadTask baseDownloadTask) {
        BaseNotificationItem baseNotificationItemCreate;
        if (disableNotification(baseDownloadTask) || (baseNotificationItemCreate = create(baseDownloadTask)) == null) {
            return;
        }
        this.helper.add(baseNotificationItemCreate);
    }
}
