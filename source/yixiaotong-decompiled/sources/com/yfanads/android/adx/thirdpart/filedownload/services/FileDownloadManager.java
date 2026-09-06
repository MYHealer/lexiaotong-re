package com.yfanads.android.adx.thirdpart.filedownload.services;

import android.text.TextUtils;
import com.yfanads.android.adx.thirdpart.filedownload.IThreadPoolMonitor;
import com.yfanads.android.adx.thirdpart.filedownload.PauseAllMarker;
import com.yfanads.android.adx.thirdpart.filedownload.database.FileDownloadDatabase;
import com.yfanads.android.adx.thirdpart.filedownload.download.CustomComponentHolder;
import com.yfanads.android.adx.thirdpart.filedownload.download.DownloadLaunchRunnable;
import com.yfanads.android.adx.thirdpart.filedownload.model.ConnectionModel;
import com.yfanads.android.adx.thirdpart.filedownload.model.FileDownloadHeader;
import com.yfanads.android.adx.thirdpart.filedownload.model.FileDownloadModel;
import com.yfanads.android.adx.thirdpart.filedownload.model.FileDownloadStatus;
import com.yfanads.android.adx.thirdpart.filedownload.util.FileDownloadHelper;
import com.yfanads.android.adx.thirdpart.filedownload.util.FileDownloadLog;
import com.yfanads.android.adx.thirdpart.filedownload.util.FileDownloadUtils;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
class FileDownloadManager implements IThreadPoolMonitor {
    private final FileDownloadDatabase mDatabase;
    private final FileDownloadThreadPool mThreadPool;

    public FileDownloadManager() {
        CustomComponentHolder impl = CustomComponentHolder.getImpl();
        this.mDatabase = impl.getDatabaseInstance();
        this.mThreadPool = new FileDownloadThreadPool(impl.getMaxNetworkThreadCount());
    }

    public void clearAllTaskData() {
        this.mDatabase.clear();
    }

    public boolean clearTaskData(int i) {
        if (i == 0) {
            FileDownloadLog.w(this, "The task[%d] id is invalid, can't clear it.", Integer.valueOf(i));
            return false;
        }
        if (isDownloading(i)) {
            FileDownloadLog.w(this, "The task[%d] is downloading, can't clear it.", Integer.valueOf(i));
            return false;
        }
        this.mDatabase.remove(i);
        this.mDatabase.removeConnections(i);
        return true;
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.IThreadPoolMonitor
    public int findRunningTaskIdBySameTempPath(String str, int i) {
        return this.mThreadPool.findRunningTaskIdBySameTempPath(str, i);
    }

    public long getSoFar(int i) {
        FileDownloadModel fileDownloadModelFind = this.mDatabase.find(i);
        if (fileDownloadModelFind == null) {
            return 0L;
        }
        int connectionCount = fileDownloadModelFind.getConnectionCount();
        if (connectionCount <= 1) {
            return fileDownloadModelFind.getSoFar();
        }
        List<ConnectionModel> listFindConnectionModel = this.mDatabase.findConnectionModel(i);
        if (listFindConnectionModel == null || listFindConnectionModel.size() != connectionCount) {
            return 0L;
        }
        return ConnectionModel.getTotalOffset(listFindConnectionModel);
    }

    public byte getStatus(int i) {
        FileDownloadModel fileDownloadModelFind = this.mDatabase.find(i);
        if (fileDownloadModelFind == null) {
            return (byte) 0;
        }
        return fileDownloadModelFind.getStatus();
    }

    public long getTotal(int i) {
        FileDownloadModel fileDownloadModelFind = this.mDatabase.find(i);
        if (fileDownloadModelFind == null) {
            return 0L;
        }
        return fileDownloadModelFind.getTotal();
    }

    public boolean isDownloading(String str, String str2) {
        return isDownloading(FileDownloadUtils.generateId(str, str2));
    }

    public boolean isIdle() {
        return this.mThreadPool.exactSize() <= 0;
    }

    public boolean pause(int i) {
        if (FileDownloadLog.NEED_LOG) {
            FileDownloadLog.d(this, "request pause the task %d", Integer.valueOf(i));
        }
        FileDownloadModel fileDownloadModelFind = this.mDatabase.find(i);
        if (fileDownloadModelFind == null) {
            return false;
        }
        fileDownloadModelFind.setStatus((byte) -2);
        this.mThreadPool.cancel(i);
        return true;
    }

    public void pauseAll() {
        List<Integer> allExactRunningDownloadIds = this.mThreadPool.getAllExactRunningDownloadIds();
        if (FileDownloadLog.NEED_LOG) {
            FileDownloadLog.d(this, "pause all tasks %d", Integer.valueOf(allExactRunningDownloadIds.size()));
        }
        Iterator<Integer> it = allExactRunningDownloadIds.iterator();
        while (it.hasNext()) {
            pause(it.next().intValue());
        }
    }

    public synchronized boolean setMaxNetworkThreadCount(int i) {
        return this.mThreadPool.setMaxNetworkThreadCount(i);
    }

    /* JADX WARN: Code duplicated, block: B:81:0x0183 A[Catch: all -> 0x01ce, TryCatch #0 {, blocks: (B:4:0x0009, B:6:0x0010, B:7:0x0022, B:10:0x0034, B:12:0x0044, B:14:0x004e, B:16:0x0052, B:17:0x0065, B:21:0x0072, B:23:0x0078, B:25:0x007c, B:29:0x008d, B:31:0x0096, B:33:0x009f, B:35:0x00a3, B:40:0x00b6, B:43:0x00bf, B:45:0x00c8, B:47:0x00d7, B:49:0x00db, B:51:0x00ec, B:55:0x00fa, B:57:0x0101, B:59:0x0108, B:61:0x010e, B:63:0x0115, B:65:0x011b, B:67:0x0121, B:69:0x013b, B:70:0x013f, B:72:0x0145, B:81:0x0183, B:82:0x0188, B:73:0x0154, B:75:0x015e, B:77:0x0164, B:78:0x0169, B:44:0x00c4, B:30:0x0092), top: B:88:0x0009 }] */
    public synchronized void start(String str, String str2, boolean z, int i, int i2, int i3, boolean z2, FileDownloadHeader fileDownloadHeader, boolean z3) {
        FileDownloadModel fileDownloadModel;
        List<ConnectionModel> listFindConnectionModel;
        boolean z4 = false;
        if (FileDownloadLog.NEED_LOG) {
            FileDownloadLog.d(this, "request start the task with url(%s) path(%s) isDirectory(%B)", str, str2, Boolean.valueOf(z));
        }
        PauseAllMarker.clearMarker();
        int iGenerateId = FileDownloadUtils.generateId(str, str2, z);
        FileDownloadModel fileDownloadModelFind = this.mDatabase.find(iGenerateId);
        if (z || fileDownloadModelFind != null) {
            fileDownloadModel = fileDownloadModelFind;
            listFindConnectionModel = null;
        } else {
            int iGenerateId2 = FileDownloadUtils.generateId(str, FileDownloadUtils.getParent(str2), true);
            FileDownloadModel fileDownloadModelFind2 = this.mDatabase.find(iGenerateId2);
            if (fileDownloadModelFind2 == null || !str2.equals(fileDownloadModelFind2.getTargetFilePath())) {
                listFindConnectionModel = null;
            } else {
                if (FileDownloadLog.NEED_LOG) {
                    FileDownloadLog.d(this, "task[%d] find model by dirCaseId[%d]", Integer.valueOf(iGenerateId), Integer.valueOf(iGenerateId2));
                }
                listFindConnectionModel = this.mDatabase.findConnectionModel(iGenerateId2);
            }
            fileDownloadModel = fileDownloadModelFind2;
        }
        if (FileDownloadHelper.inspectAndInflowDownloading(iGenerateId, fileDownloadModel, this, true)) {
            if (FileDownloadLog.NEED_LOG) {
                FileDownloadLog.d(this, "has already started download %d", Integer.valueOf(iGenerateId));
            }
            return;
        }
        String targetFilePath = fileDownloadModel != null ? fileDownloadModel.getTargetFilePath() : FileDownloadUtils.getTargetFilePath(str2, z, null);
        if (FileDownloadHelper.inspectAndInflowDownloaded(iGenerateId, targetFilePath, z2, true)) {
            if (FileDownloadLog.NEED_LOG) {
                FileDownloadLog.d(this, "has already completed downloading %d", Integer.valueOf(iGenerateId));
            }
            return;
        }
        if (FileDownloadHelper.inspectAndInflowConflictPath(iGenerateId, fileDownloadModel != null ? fileDownloadModel.getSoFar() : 0L, fileDownloadModel != null ? fileDownloadModel.getTempFilePath() : FileDownloadUtils.getTempPath(targetFilePath), targetFilePath, this)) {
            if (FileDownloadLog.NEED_LOG) {
                FileDownloadLog.d(this, "there is an another task with the same target-file-path %d %s", Integer.valueOf(iGenerateId), targetFilePath);
            }
            if (fileDownloadModel != null) {
                this.mDatabase.remove(iGenerateId);
                this.mDatabase.removeConnections(iGenerateId);
            }
            return;
        }
        if (fileDownloadModel == null || !(fileDownloadModel.getStatus() == -2 || fileDownloadModel.getStatus() == -1 || fileDownloadModel.getStatus() == 1 || fileDownloadModel.getStatus() == 6 || fileDownloadModel.getStatus() == 2)) {
            if (fileDownloadModel == null) {
                fileDownloadModel = new FileDownloadModel();
            }
            fileDownloadModel.setUrl(str);
            fileDownloadModel.setPath(str2, z);
            fileDownloadModel.setId(iGenerateId);
            fileDownloadModel.setSoFar(0L);
            fileDownloadModel.setTotal(0L);
            fileDownloadModel.setStatus((byte) 1);
            fileDownloadModel.setConnectionCount(1);
        } else {
            if (fileDownloadModel.getId() == iGenerateId) {
                if (!TextUtils.equals(str, fileDownloadModel.getUrl())) {
                    fileDownloadModel.setUrl(str);
                }
                if (z4) {
                    this.mDatabase.update(fileDownloadModel);
                }
                this.mThreadPool.execute(new DownloadLaunchRunnable.Builder().setModel(fileDownloadModel).setHeader(fileDownloadHeader).setThreadPoolMonitor(this).setMinIntervalMillis(Integer.valueOf(i2)).setCallbackProgressMaxCount(Integer.valueOf(i)).setForceReDownload(Boolean.valueOf(z2)).setWifiRequired(Boolean.valueOf(z3)).setMaxRetryTimes(Integer.valueOf(i3)).build());
            }
            this.mDatabase.remove(fileDownloadModel.getId());
            this.mDatabase.removeConnections(fileDownloadModel.getId());
            fileDownloadModel.setId(iGenerateId);
            fileDownloadModel.setPath(str2, z);
            if (listFindConnectionModel != null) {
                for (ConnectionModel connectionModel : listFindConnectionModel) {
                    connectionModel.setId(iGenerateId);
                    this.mDatabase.insertConnectionModel(connectionModel);
                }
            }
        }
        z4 = true;
        if (z4) {
            this.mDatabase.update(fileDownloadModel);
        }
        this.mThreadPool.execute(new DownloadLaunchRunnable.Builder().setModel(fileDownloadModel).setHeader(fileDownloadHeader).setThreadPoolMonitor(this).setMinIntervalMillis(Integer.valueOf(i2)).setCallbackProgressMaxCount(Integer.valueOf(i)).setForceReDownload(Boolean.valueOf(z2)).setWifiRequired(Boolean.valueOf(z3)).setMaxRetryTimes(Integer.valueOf(i3)).build());
    }

    public boolean isDownloading(int i) {
        return isDownloading(this.mDatabase.find(i));
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.IThreadPoolMonitor
    public boolean isDownloading(FileDownloadModel fileDownloadModel) {
        if (fileDownloadModel == null) {
            return false;
        }
        boolean zIsInThreadPool = this.mThreadPool.isInThreadPool(fileDownloadModel.getId());
        if (FileDownloadStatus.isOver(fileDownloadModel.getStatus())) {
            if (!zIsInThreadPool) {
                return false;
            }
        } else if (!zIsInThreadPool) {
            FileDownloadLog.e(this, "%d status is[%s](not finish) & but not in the pool", Integer.valueOf(fileDownloadModel.getId()), Byte.valueOf(fileDownloadModel.getStatus()));
            return false;
        }
        return true;
    }
}
