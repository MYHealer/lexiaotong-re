package com.yfanads.android.adx.thirdpart.filedownload.download;

import android.os.Process;
import com.kuaishou.weapon.p0.g;
import com.yfanads.android.adx.thirdpart.filedownload.IThreadPoolMonitor;
import com.yfanads.android.adx.thirdpart.filedownload.connection.FileDownloadConnection;
import com.yfanads.android.adx.thirdpart.filedownload.database.FileDownloadDatabase;
import com.yfanads.android.adx.thirdpart.filedownload.exception.FileDownloadGiveUpRetryException;
import com.yfanads.android.adx.thirdpart.filedownload.exception.FileDownloadHttpException;
import com.yfanads.android.adx.thirdpart.filedownload.exception.FileDownloadNetworkPolicyException;
import com.yfanads.android.adx.thirdpart.filedownload.exception.FileDownloadOutOfSpaceException;
import com.yfanads.android.adx.thirdpart.filedownload.exception.FileDownloadSecurityException;
import com.yfanads.android.adx.thirdpart.filedownload.model.ConnectionModel;
import com.yfanads.android.adx.thirdpart.filedownload.model.FileDownloadHeader;
import com.yfanads.android.adx.thirdpart.filedownload.model.FileDownloadModel;
import com.yfanads.android.adx.thirdpart.filedownload.stream.FileDownloadOutputStream;
import com.yfanads.android.adx.thirdpart.filedownload.util.FileDownloadExecutors;
import com.yfanads.android.adx.thirdpart.filedownload.util.FileDownloadHelper;
import com.yfanads.android.adx.thirdpart.filedownload.util.FileDownloadLog;
import com.yfanads.android.adx.thirdpart.filedownload.util.FileDownloadProperties;
import com.yfanads.android.adx.thirdpart.filedownload.util.FileDownloadUtils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class DownloadLaunchRunnable implements Runnable, ProcessCallback {
    private static final ThreadPoolExecutor DOWNLOAD_EXECUTOR = FileDownloadExecutors.newFixedThreadPool("ConnectionBlock");
    private static final int HTTP_REQUESTED_RANGE_NOT_SATISFIABLE = 416;
    private static final int TOTAL_VALUE_IN_CHUNKED_RESOURCE = -1;
    private boolean acceptPartial;
    private final AtomicBoolean alive;
    private final FileDownloadDatabase database;
    private final int defaultConnectionCount;
    private final ArrayList<DownloadRunnable> downloadRunnableList;
    private volatile boolean error;
    private volatile Exception errorException;
    private boolean isChunked;
    private final boolean isForceReDownload;
    private boolean isNeedForceDiscardRange;
    private boolean isResumeAvailableOnDB;
    private boolean isSingleConnection;
    private boolean isTriedFixRangeNotSatisfiable;
    private final boolean isWifiRequired;
    private long lastCallbackBytes;
    private long lastCallbackTimestamp;
    private long lastUpdateBytes;
    private long lastUpdateTimestamp;
    private final FileDownloadModel model;
    private volatile boolean paused;
    private String redirectedUrl;
    private DownloadRunnable singleDownloadRunnable;
    private final DownloadStatusCallback statusCallback;
    private final boolean supportSeek;
    private final IThreadPoolMonitor threadPoolMonitor;
    private final FileDownloadHeader userRequestHeader;
    int validRetryTimes;

    /* JADX INFO: renamed from: com.yfanads.android.adx.thirdpart.filedownload.download.DownloadLaunchRunnable$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public class DiscardSafely extends Throwable {
        public DiscardSafely() {
        }
    }

    public class RetryDirectly extends Throwable {
        public RetryDirectly() {
        }
    }

    public /* synthetic */ DownloadLaunchRunnable(FileDownloadModel fileDownloadModel, FileDownloadHeader fileDownloadHeader, IThreadPoolMonitor iThreadPoolMonitor, int i, int i2, boolean z, boolean z2, int i3, AnonymousClass1 anonymousClass1) {
        this(fileDownloadModel, fileDownloadHeader, iThreadPoolMonitor, i, i2, z, z2, i3);
    }

    private int calcConnectionCount(long j) {
        if (isMultiConnectionAvailable()) {
            return this.isResumeAvailableOnDB ? this.model.getConnectionCount() : CustomComponentHolder.getImpl().determineConnectionCount(this.model.getId(), this.model.getUrl(), this.model.getPath(), j);
        }
        return 1;
    }

    private void checkupAfterGetFilename() throws RetryDirectly, DiscardSafely {
        int id = this.model.getId();
        if (this.model.isPathAsDirectory()) {
            String targetFilePath = this.model.getTargetFilePath();
            int iGenerateId = FileDownloadUtils.generateId(this.model.getUrl(), targetFilePath);
            if (FileDownloadHelper.inspectAndInflowDownloaded(id, targetFilePath, this.isForceReDownload, false)) {
                this.database.remove(id);
                this.database.removeConnections(id);
                throw new DiscardSafely();
            }
            FileDownloadModel fileDownloadModelFind = this.database.find(iGenerateId);
            if (fileDownloadModelFind != null) {
                if (FileDownloadHelper.inspectAndInflowDownloading(id, fileDownloadModelFind, this.threadPoolMonitor, false)) {
                    this.database.remove(id);
                    this.database.removeConnections(id);
                    throw new DiscardSafely();
                }
                List<ConnectionModel> listFindConnectionModel = this.database.findConnectionModel(iGenerateId);
                this.database.remove(iGenerateId);
                this.database.removeConnections(iGenerateId);
                FileDownloadUtils.deleteTargetFile(this.model.getTargetFilePath());
                if (FileDownloadUtils.isBreakpointAvailable(iGenerateId, fileDownloadModelFind)) {
                    this.model.setSoFar(fileDownloadModelFind.getSoFar());
                    this.model.setTotal(fileDownloadModelFind.getTotal());
                    this.model.setETag(fileDownloadModelFind.getETag());
                    this.model.setConnectionCount(fileDownloadModelFind.getConnectionCount());
                    this.database.update(this.model);
                    if (listFindConnectionModel != null) {
                        for (ConnectionModel connectionModel : listFindConnectionModel) {
                            connectionModel.setId(id);
                            this.database.insertConnectionModel(connectionModel);
                        }
                    }
                    throw new RetryDirectly();
                }
            }
            if (FileDownloadHelper.inspectAndInflowConflictPath(id, this.model.getSoFar(), this.model.getTempFilePath(), targetFilePath, this.threadPoolMonitor)) {
                this.database.remove(id);
                this.database.removeConnections(id);
                throw new DiscardSafely();
            }
        }
    }

    public static DownloadLaunchRunnable createForTest(DownloadStatusCallback downloadStatusCallback, FileDownloadModel fileDownloadModel, FileDownloadHeader fileDownloadHeader, IThreadPoolMonitor iThreadPoolMonitor, int i, int i2, boolean z, boolean z2, int i3) {
        return new DownloadLaunchRunnable(downloadStatusCallback, fileDownloadModel, fileDownloadHeader, iThreadPoolMonitor, i, i2, z, z2, i3);
    }

    private int determineConnectionCount() {
        return 5;
    }

    private void fetchWithMultipleConnection(List<ConnectionModel> list, long j) throws InterruptedException {
        int id = this.model.getId();
        String eTag = this.model.getETag();
        String url = this.redirectedUrl;
        if (url == null) {
            url = this.model.getUrl();
        }
        String tempFilePath = this.model.getTempFilePath();
        if (FileDownloadLog.NEED_LOG) {
            FileDownloadLog.d(this, "fetch data with multiple connection(count: [%d]) for task[%d] totalLength[%d]", Integer.valueOf(list.size()), Integer.valueOf(id), Long.valueOf(j));
        }
        boolean z = this.isResumeAvailableOnDB;
        long currentOffset = 0;
        for (ConnectionModel connectionModel : list) {
            long currentOffset2 = connectionModel.getEndOffset() == -1 ? j - connectionModel.getCurrentOffset() : (connectionModel.getEndOffset() - connectionModel.getCurrentOffset()) + 1;
            currentOffset += connectionModel.getCurrentOffset() - connectionModel.getStartOffset();
            if (currentOffset2 != 0) {
                DownloadRunnable downloadRunnableBuild = new DownloadRunnable.Builder().setId(id).setConnectionIndex(Integer.valueOf(connectionModel.getIndex())).setCallback(this).setUrl(url).setEtag(z ? eTag : null).setHeader(this.userRequestHeader).setWifiRequired(this.isWifiRequired).setConnectionModel(ConnectionProfile.ConnectionProfileBuild.buildConnectionProfile(connectionModel.getStartOffset(), connectionModel.getCurrentOffset(), connectionModel.getEndOffset(), currentOffset2)).setPath(tempFilePath).build();
                if (FileDownloadLog.NEED_LOG) {
                    FileDownloadLog.d(this, "enable multiple connection: %s", connectionModel);
                }
                if (downloadRunnableBuild == null) {
                    throw new IllegalArgumentException("the download runnable must not be null!");
                }
                this.downloadRunnableList.add(downloadRunnableBuild);
            } else if (FileDownloadLog.NEED_LOG) {
                FileDownloadLog.d(this, "pass connection[%d-%d], because it has been completed", Integer.valueOf(connectionModel.getId()), Integer.valueOf(connectionModel.getIndex()));
            }
        }
        if (currentOffset != this.model.getSoFar()) {
            FileDownloadLog.w(this, "correct the sofar[%d] from connection table[%d]", Long.valueOf(this.model.getSoFar()), Long.valueOf(currentOffset));
            this.model.setSoFar(currentOffset);
        }
        ArrayList arrayList = new ArrayList(this.downloadRunnableList.size());
        for (DownloadRunnable downloadRunnable : this.downloadRunnableList) {
            if (this.paused) {
                downloadRunnable.pause();
            } else {
                arrayList.add(Executors.callable(downloadRunnable));
            }
        }
        if (this.paused) {
            this.model.setStatus((byte) -2);
            return;
        }
        List<Future> listInvokeAll = DOWNLOAD_EXECUTOR.invokeAll(arrayList);
        if (FileDownloadLog.NEED_LOG) {
            for (Future future : listInvokeAll) {
                FileDownloadLog.d(this, "finish sub-task for [%d] %B %B", Integer.valueOf(id), Boolean.valueOf(future.isDone()), Boolean.valueOf(future.isCancelled()));
            }
        }
    }

    private void handlePreAllocate(long j, String str) throws IllegalAccessException, IOException {
        FileDownloadOutputStream fileDownloadOutputStreamCreateOutputStream = null;
        if (j != -1) {
            try {
                fileDownloadOutputStreamCreateOutputStream = FileDownloadUtils.createOutputStream(this.model.getTempFilePath());
                long length = new File(str).length();
                long j2 = j - length;
                long freeSpaceBytes = FileDownloadUtils.getFreeSpaceBytes(str);
                if (freeSpaceBytes < j2) {
                    throw new FileDownloadOutOfSpaceException(freeSpaceBytes, j2, length);
                }
                if (!FileDownloadProperties.getImpl().fileNonPreAllocation) {
                    fileDownloadOutputStreamCreateOutputStream.setLength(j);
                }
            } catch (Throwable th) {
                if (0 != 0) {
                    fileDownloadOutputStreamCreateOutputStream.close();
                }
                throw th;
            }
        }
        if (fileDownloadOutputStreamCreateOutputStream != null) {
            fileDownloadOutputStreamCreateOutputStream.close();
        }
    }

    private void handleTrialConnectResult(Map<String, List<String>> map, ConnectTask connectTask, FileDownloadConnection fileDownloadConnection) throws FileDownloadSecurityException, RetryDirectly, IOException, IllegalArgumentException {
        int id = this.model.getId();
        int responseCode = fileDownloadConnection.getResponseCode();
        this.acceptPartial = FileDownloadUtils.isAcceptRange(responseCode, fileDownloadConnection);
        boolean z = responseCode == 200 || responseCode == 201 || responseCode == 0;
        long jFindInstanceLengthForTrial = FileDownloadUtils.findInstanceLengthForTrial(fileDownloadConnection);
        String eTag = this.model.getETag();
        String strFindEtag = FileDownloadUtils.findEtag(id, fileDownloadConnection);
        if (responseCode != 412 && ((eTag == null || eTag.equals(strFindEtag) || (!z && !this.acceptPartial)) && (responseCode != 201 || !connectTask.isRangeNotFromBeginning()))) {
            if (responseCode == 416) {
                if (this.acceptPartial && jFindInstanceLengthForTrial >= 0) {
                    FileDownloadLog.w(this, "get 416 but the Content-Range is returned, no need to retry", new Object[0]);
                } else if (this.model.getSoFar() > 0) {
                    FileDownloadLog.w(this, "get 416, precondition failed and just retry", new Object[0]);
                } else if (!this.isNeedForceDiscardRange) {
                    this.isNeedForceDiscardRange = true;
                    FileDownloadLog.w(this, "get 416, precondition failed and need to retry with discarding range", new Object[0]);
                }
            }
            this.redirectedUrl = connectTask.getFinalRedirectedUrl();
            if (!this.acceptPartial && !z) {
                throw new FileDownloadHttpException(responseCode, map, fileDownloadConnection.getResponseHeaderFields());
            }
            String strFindFilename = this.model.isPathAsDirectory() ? FileDownloadUtils.findFilename(fileDownloadConnection, this.model.getUrl()) : null;
            this.isChunked = jFindInstanceLengthForTrial == -1;
            this.statusCallback.onConnected(this.isResumeAvailableOnDB && this.acceptPartial, jFindInstanceLengthForTrial, strFindEtag, strFindFilename);
            return;
        }
        if (this.isResumeAvailableOnDB) {
            FileDownloadLog.w(this, "there is precondition failed on this request[%d] with old etag[%s]、new etag[%s]、response code is %d", Integer.valueOf(id), eTag, strFindEtag, Integer.valueOf(responseCode));
        }
        this.database.removeConnections(this.model.getId());
        FileDownloadUtils.deleteTaskFiles(this.model.getTargetFilePath(), this.model.getTempFilePath());
        this.isResumeAvailableOnDB = false;
        if (eTag != null && eTag.equals(strFindEtag)) {
            FileDownloadLog.w(this, "the old etag[%s] is the same to the new etag[%s], but the response status code is %d not Partial(206), so wo have to start this task from very beginning for task[%d]!", eTag, strFindEtag, Integer.valueOf(responseCode), Integer.valueOf(id));
            strFindEtag = null;
        }
        this.model.setSoFar(0L);
        this.model.setTotal(0L);
        this.model.setETag(strFindEtag);
        this.model.resetConnectionCount();
        this.database.updateOldEtagOverdue(id, this.model.getETag(), this.model.getSoFar(), this.model.getTotal(), this.model.getConnectionCount());
        throw new RetryDirectly();
    }

    private boolean isMultiConnectionAvailable() {
        return (!this.isResumeAvailableOnDB || this.model.getConnectionCount() > 1) && this.acceptPartial && this.supportSeek && !this.isChunked;
    }

    private void realDownloadWithMultiConnectionFromBeginning(long j, int i) throws InterruptedException {
        long j2 = j / ((long) i);
        int id = this.model.getId();
        ArrayList arrayList = new ArrayList();
        long j3 = 0;
        int i2 = 0;
        while (i2 < i) {
            long j4 = i2 == i + (-1) ? -1L : (j3 + j2) - 1;
            ConnectionModel connectionModel = new ConnectionModel();
            connectionModel.setId(id);
            connectionModel.setIndex(i2);
            connectionModel.setStartOffset(j3);
            connectionModel.setCurrentOffset(j3);
            connectionModel.setEndOffset(j4);
            arrayList.add(connectionModel);
            this.database.insertConnectionModel(connectionModel);
            j3 += j2;
            i2++;
        }
        this.model.setConnectionCount(i);
        this.database.updateConnectionCount(id, i);
        fetchWithMultipleConnection(arrayList, j);
    }

    private void realDownloadWithMultiConnectionFromResume(int i, List<ConnectionModel> list) throws InterruptedException {
        if (i <= 1 || list.size() != i) {
            throw new IllegalArgumentException();
        }
        fetchWithMultipleConnection(list, this.model.getTotal());
    }

    public int getId() {
        return this.model.getId();
    }

    public String getTempFilePath() {
        return this.model.getTempFilePath();
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0058  */
    public void inspectTaskModelResumeAvailableOnDB(List<ConnectionModel> list) {
        long soFar;
        int connectionCount = this.model.getConnectionCount();
        String tempFilePath = this.model.getTempFilePath();
        String targetFilePath = this.model.getTargetFilePath();
        boolean z = connectionCount > 1;
        if (this.isNeedForceDiscardRange || ((z && !this.supportSeek) || !FileDownloadUtils.isBreakpointAvailable(this.model.getId(), this.model))) {
            soFar = 0;
        } else if (!this.supportSeek) {
            soFar = new File(tempFilePath).length();
        } else if (!z) {
            soFar = this.model.getSoFar();
        } else if (connectionCount != list.size()) {
            soFar = 0;
        } else {
            soFar = ConnectionModel.getTotalOffset(list);
        }
        this.model.setSoFar(soFar);
        boolean z2 = soFar > 0;
        this.isResumeAvailableOnDB = z2;
        if (z2) {
            return;
        }
        this.database.removeConnections(this.model.getId());
        FileDownloadUtils.deleteTaskFiles(targetFilePath, tempFilePath);
    }

    public boolean isAlive() {
        return this.alive.get() || this.statusCallback.isAlive();
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.download.ProcessCallback
    public boolean isRetry(Exception exc) {
        if (exc instanceof FileDownloadHttpException) {
            int code = ((FileDownloadHttpException) exc).getCode();
            if (this.isSingleConnection && code == 416 && !this.isTriedFixRangeNotSatisfiable) {
                FileDownloadUtils.deleteTaskFiles(this.model.getTargetFilePath(), this.model.getTempFilePath());
                this.isTriedFixRangeNotSatisfiable = true;
                return true;
            }
        }
        return this.validRetryTimes > 0 && !(exc instanceof FileDownloadGiveUpRetryException);
    }

    /* JADX WARN: Code duplicated, block: B:129:0x0222 A[Catch: all -> 0x0257, TryCatch #11 {all -> 0x0257, blocks: (B:3:0x0003, B:6:0x0012, B:8:0x001a, B:10:0x001e, B:11:0x0030, B:24:0x008d, B:26:0x0091, B:27:0x0096, B:29:0x009a, B:31:0x009e, B:44:0x00dc, B:46:0x00f8, B:59:0x012a, B:75:0x0172, B:77:0x0176, B:93:0x01ad, B:95:0x01b1, B:96:0x01b6, B:98:0x01bf, B:99:0x01c4, B:100:0x01c8, B:101:0x01db, B:102:0x01dc, B:127:0x021c, B:129:0x0222, B:130:0x0227), top: B:166:0x0003, inners: #17, #13, #11 }] */
    /* JADX WARN: Code duplicated, block: B:175:0x0227 A[SYNTHETIC] */
    @Override // java.lang.Runnable
    public void run() {
        try {
            Process.setThreadPriority(10);
            if (this.model.getStatus() != 1) {
                if (this.model.getStatus() != -2) {
                    onError(new RuntimeException(FileDownloadUtils.formatString("Task[%d] can't start the download runnable, because its status is %d not %d", Integer.valueOf(this.model.getId()), Byte.valueOf(this.model.getStatus()), (byte) 1)));
                } else if (FileDownloadLog.NEED_LOG) {
                    FileDownloadLog.d(this, "High concurrent cause, start runnable but already paused %d", Integer.valueOf(this.model.getId()));
                }
                this.statusCallback.discardAllMessage();
                if (this.paused) {
                    this.statusCallback.onPausedDirectly();
                } else if (this.error) {
                    this.statusCallback.onErrorDirectly(this.errorException);
                } else {
                    try {
                        this.statusCallback.onCompletedDirectly();
                    } catch (IOException e) {
                        this.statusCallback.onErrorDirectly(e);
                    }
                }
                this.alive.set(false);
                return;
            }
            if (!this.paused) {
                this.statusCallback.onStartThread();
            }
            while (true) {
                if (!this.paused) {
                    try {
                        checkupBeforeConnect();
                        trialConnect();
                        checkupAfterGetFilename();
                        List<ConnectionModel> listFindConnectionModel = this.database.findConnectionModel(this.model.getId());
                        inspectTaskModelResumeAvailableOnDB(listFindConnectionModel);
                        if (this.paused) {
                            this.model.setStatus((byte) -2);
                            this.statusCallback.discardAllMessage();
                            if (this.paused) {
                                this.statusCallback.onPausedDirectly();
                            } else if (this.error) {
                                this.statusCallback.onErrorDirectly(this.errorException);
                            } else {
                                try {
                                    this.statusCallback.onCompletedDirectly();
                                } catch (IOException e2) {
                                    this.statusCallback.onErrorDirectly(e2);
                                }
                            }
                            this.alive.set(false);
                            return;
                        }
                        long total = this.model.getTotal();
                        handlePreAllocate(total, this.model.getTempFilePath());
                        int iCalcConnectionCount = calcConnectionCount(total);
                        if (iCalcConnectionCount <= 0) {
                            throw new IllegalAccessException(FileDownloadUtils.formatString("invalid connection count %d, the connection count must be larger than 0", Integer.valueOf(iCalcConnectionCount)));
                        }
                        if (total != 0) {
                            if (!this.paused) {
                                boolean z = iCalcConnectionCount == 1;
                                this.isSingleConnection = z;
                                if (!z) {
                                    this.statusCallback.onMultiConnection();
                                    if (!this.isResumeAvailableOnDB) {
                                        realDownloadWithMultiConnectionFromBeginning(total, iCalcConnectionCount);
                                        break;
                                    } else {
                                        realDownloadWithMultiConnectionFromResume(iCalcConnectionCount, listFindConnectionModel);
                                        break;
                                    }
                                }
                                realDownloadWithSingleConnection(total);
                                break;
                            }
                            this.model.setStatus((byte) -2);
                            this.statusCallback.discardAllMessage();
                            if (this.paused) {
                                this.statusCallback.onPausedDirectly();
                            } else if (this.error) {
                                this.statusCallback.onErrorDirectly(this.errorException);
                            } else {
                                try {
                                    this.statusCallback.onCompletedDirectly();
                                } catch (IOException e3) {
                                    this.statusCallback.onErrorDirectly(e3);
                                }
                            }
                            this.alive.set(false);
                            return;
                        }
                        this.statusCallback.discardAllMessage();
                        if (this.paused) {
                            this.statusCallback.onPausedDirectly();
                        } else if (this.error) {
                            this.statusCallback.onErrorDirectly(this.errorException);
                        } else {
                            try {
                                this.statusCallback.onCompletedDirectly();
                            } catch (IOException e4) {
                                this.statusCallback.onErrorDirectly(e4);
                            }
                        }
                        this.alive.set(false);
                        return;
                    } catch (DiscardSafely unused) {
                        this.statusCallback.discardAllMessage();
                        if (this.paused) {
                            this.statusCallback.onPausedDirectly();
                        } else if (this.error) {
                            this.statusCallback.onErrorDirectly(this.errorException);
                        } else {
                            try {
                                this.statusCallback.onCompletedDirectly();
                            } catch (IOException e5) {
                                this.statusCallback.onErrorDirectly(e5);
                            }
                        }
                        this.alive.set(false);
                        return;
                    } catch (RetryDirectly unused2) {
                        this.model.setStatus((byte) 5);
                    } catch (FileDownloadGiveUpRetryException e6) {
                        e = e6;
                        if (isRetry(e)) {
                            onError(e);
                            break;
                        }
                        onRetry(e);
                    } catch (FileDownloadSecurityException e7) {
                        e = e7;
                        if (isRetry(e)) {
                            onError(e);
                            break;
                        }
                        onRetry(e);
                    } catch (IOException e8) {
                        e = e8;
                        if (isRetry(e)) {
                            onError(e);
                            break;
                        }
                        onRetry(e);
                    } catch (IllegalAccessException e9) {
                        e = e9;
                        if (isRetry(e)) {
                            onError(e);
                            break;
                        }
                        onRetry(e);
                    } catch (IllegalArgumentException e10) {
                        e = e10;
                        if (isRetry(e)) {
                            onError(e);
                            break;
                        }
                        onRetry(e);
                    } catch (InterruptedException e11) {
                        e = e11;
                        if (isRetry(e)) {
                            onError(e);
                            break;
                        }
                        onRetry(e);
                    }
                } else {
                    if (FileDownloadLog.NEED_LOG) {
                        FileDownloadLog.d(this, "High concurrent cause, start runnable but already paused %d", Integer.valueOf(this.model.getId()));
                    }
                    this.statusCallback.discardAllMessage();
                    if (this.paused) {
                        this.statusCallback.onPausedDirectly();
                    } else if (this.error) {
                        this.statusCallback.onErrorDirectly(this.errorException);
                    } else {
                        try {
                            this.statusCallback.onCompletedDirectly();
                        } catch (IOException e12) {
                            this.statusCallback.onErrorDirectly(e12);
                        }
                    }
                    this.alive.set(false);
                    return;
                }
            }
            this.statusCallback.discardAllMessage();
            if (this.paused) {
                this.statusCallback.onPausedDirectly();
            } else if (this.error) {
                this.statusCallback.onErrorDirectly(this.errorException);
            } else {
                try {
                    this.statusCallback.onCompletedDirectly();
                } catch (IOException e13) {
                    this.statusCallback.onErrorDirectly(e13);
                }
            }
            this.alive.set(false);
        } catch (Throwable th) {
            this.statusCallback.discardAllMessage();
            if (this.paused) {
                this.statusCallback.onPausedDirectly();
            } else if (this.error) {
                this.statusCallback.onErrorDirectly(this.errorException);
            } else {
                try {
                    this.statusCallback.onCompletedDirectly();
                } catch (IOException e14) {
                    this.statusCallback.onErrorDirectly(e14);
                }
            }
            this.alive.set(false);
            throw th;
        }
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.download.ProcessCallback
    public void syncProgressFromCache() {
        this.database.updateProgress(this.model.getId(), this.model.getSoFar());
    }

    private DownloadLaunchRunnable(FileDownloadModel fileDownloadModel, FileDownloadHeader fileDownloadHeader, IThreadPoolMonitor iThreadPoolMonitor, int i, int i2, boolean z, boolean z2, int i3) {
        this.defaultConnectionCount = 5;
        this.isNeedForceDiscardRange = false;
        this.downloadRunnableList = new ArrayList<>(5);
        this.lastCallbackBytes = 0L;
        this.lastCallbackTimestamp = 0L;
        this.lastUpdateBytes = 0L;
        this.lastUpdateTimestamp = 0L;
        this.alive = new AtomicBoolean(true);
        this.paused = false;
        this.isTriedFixRangeNotSatisfiable = false;
        this.model = fileDownloadModel;
        this.userRequestHeader = fileDownloadHeader;
        this.isForceReDownload = z;
        this.isWifiRequired = z2;
        this.database = CustomComponentHolder.getImpl().getDatabaseInstance();
        this.supportSeek = CustomComponentHolder.getImpl().isSupportSeek();
        this.threadPoolMonitor = iThreadPoolMonitor;
        this.validRetryTimes = i3;
        this.statusCallback = new DownloadStatusCallback(fileDownloadModel, i3, i, i2);
    }

    private void checkupBeforeConnect() throws FileDownloadGiveUpRetryException {
        if (this.isWifiRequired && !FileDownloadUtils.checkPermission(g.b)) {
            throw new FileDownloadGiveUpRetryException(FileDownloadUtils.formatString("Task[%d] can't start the download runnable, because this task require wifi, but user application nor current process has %s, so we can't check whether the network type connection.", Integer.valueOf(this.model.getId()), g.b));
        }
        if (this.isWifiRequired && FileDownloadUtils.isNetworkNotOnWifiType()) {
            throw new FileDownloadNetworkPolicyException();
        }
    }

    private void realDownloadWithSingleConnection(long j) throws IllegalAccessException, IOException {
        ConnectionProfile connectionProfileBuildToEndConnectionProfile;
        if (this.acceptPartial) {
            connectionProfileBuildToEndConnectionProfile = ConnectionProfile.ConnectionProfileBuild.buildToEndConnectionProfile(this.model.getSoFar(), this.model.getSoFar(), j - this.model.getSoFar());
        } else {
            this.model.setSoFar(0L);
            connectionProfileBuildToEndConnectionProfile = ConnectionProfile.ConnectionProfileBuild.buildBeginToEndConnectionProfile(j);
        }
        this.singleDownloadRunnable = new DownloadRunnable.Builder().setId(this.model.getId()).setConnectionIndex(-1).setCallback(this).setUrl(this.model.getUrl()).setEtag(this.model.getETag()).setHeader(this.userRequestHeader).setWifiRequired(this.isWifiRequired).setConnectionModel(connectionProfileBuildToEndConnectionProfile).setPath(this.model.getTempFilePath()).build();
        this.model.setConnectionCount(1);
        this.database.updateConnectionCount(this.model.getId(), 1);
        if (!this.paused) {
            this.singleDownloadRunnable.run();
        } else {
            this.model.setStatus((byte) -2);
            this.singleDownloadRunnable.pause();
        }
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.download.ProcessCallback
    public void onCompleted(DownloadRunnable downloadRunnable, long j, long j2) {
        if (this.paused) {
            if (FileDownloadLog.NEED_LOG) {
                FileDownloadLog.d(this, "the task[%d] has already been paused, so pass the completed callback", Integer.valueOf(this.model.getId()));
                return;
            }
            return;
        }
        int i = downloadRunnable.connectionIndex;
        if (FileDownloadLog.NEED_LOG) {
            FileDownloadLog.d(this, "the connection has been completed(%d): [%d, %d)  %d", Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(this.model.getTotal()));
        }
        if (!this.isSingleConnection) {
            synchronized (this.downloadRunnableList) {
                this.downloadRunnableList.remove(downloadRunnable);
            }
        } else {
            if (j == 0 || j2 == this.model.getTotal()) {
                return;
            }
            FileDownloadLog.e(this, "the single task not completed corrected(%d, %d != %d) for task(%d)", Long.valueOf(j), Long.valueOf(j2), Long.valueOf(this.model.getTotal()), Integer.valueOf(this.model.getId()));
        }
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.download.ProcessCallback
    public void onRetry(Exception exc) {
        if (this.paused) {
            if (FileDownloadLog.NEED_LOG) {
                FileDownloadLog.d(this, "the task[%d] has already been paused, so pass the retry callback", Integer.valueOf(this.model.getId()));
            }
        } else {
            int i = this.validRetryTimes;
            int i2 = i - 1;
            this.validRetryTimes = i2;
            if (i < 0) {
                FileDownloadLog.e(this, "valid retry times is less than 0(%d) for download task(%d)", Integer.valueOf(i2), Integer.valueOf(this.model.getId()));
            }
            this.statusCallback.onRetry(exc, this.validRetryTimes);
        }
    }

    public void pending() {
        inspectTaskModelResumeAvailableOnDB(this.database.findConnectionModel(this.model.getId()));
        this.statusCallback.onPending();
    }

    private void trialConnect() throws FileDownloadSecurityException, RetryDirectly, IllegalAccessException, IOException {
        ConnectionProfile connectionProfileBuildTrialConnectionProfile;
        FileDownloadConnection fileDownloadConnectionConnect = null;
        try {
            if (this.isNeedForceDiscardRange) {
                connectionProfileBuildTrialConnectionProfile = ConnectionProfile.ConnectionProfileBuild.buildTrialConnectionProfileNoRange();
            } else {
                connectionProfileBuildTrialConnectionProfile = ConnectionProfile.ConnectionProfileBuild.buildTrialConnectionProfile();
            }
            ConnectTask connectTaskBuild = new ConnectTask.Builder().setDownloadId(this.model.getId()).setUrl(this.model.getUrl()).setEtag(this.model.getETag()).setHeader(this.userRequestHeader).setConnectionProfile(connectionProfileBuildTrialConnectionProfile).build();
            fileDownloadConnectionConnect = connectTaskBuild.connect();
            handleTrialConnectResult(connectTaskBuild.getRequestHeader(), connectTaskBuild, fileDownloadConnectionConnect);
        } finally {
            if (fileDownloadConnectionConnect != null) {
                fileDownloadConnectionConnect.ending();
            }
        }
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.download.ProcessCallback
    public void onProgress(long j) {
        if (this.paused) {
            return;
        }
        this.statusCallback.onProgress(j);
    }

    public void pause() {
        this.paused = true;
        DownloadRunnable downloadRunnable = this.singleDownloadRunnable;
        if (downloadRunnable != null) {
            downloadRunnable.pause();
        }
        for (DownloadRunnable downloadRunnable2 : (ArrayList) this.downloadRunnableList.clone()) {
            if (downloadRunnable2 != null) {
                downloadRunnable2.pause();
            }
        }
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.download.ProcessCallback
    public void onError(Exception exc) {
        this.error = true;
        this.errorException = exc;
        if (this.paused) {
            if (FileDownloadLog.NEED_LOG) {
                FileDownloadLog.d(this, "the task[%d] has already been paused, so pass the error callback", Integer.valueOf(this.model.getId()));
            }
        } else {
            for (DownloadRunnable downloadRunnable : (ArrayList) this.downloadRunnableList.clone()) {
                if (downloadRunnable != null) {
                    downloadRunnable.discard();
                }
            }
        }
    }

    public static class Builder {
        private Integer callbackProgressMaxCount;
        private FileDownloadHeader header;
        private Boolean isForceReDownload;
        private Boolean isWifiRequired;
        private Integer maxRetryTimes;
        private Integer minIntervalMillis;
        private FileDownloadModel model;
        private IThreadPoolMonitor threadPoolMonitor;

        public Builder setCallbackProgressMaxCount(Integer num) {
            this.callbackProgressMaxCount = num;
            return this;
        }

        public Builder setForceReDownload(Boolean bool) {
            this.isForceReDownload = bool;
            return this;
        }

        public Builder setHeader(FileDownloadHeader fileDownloadHeader) {
            this.header = fileDownloadHeader;
            return this;
        }

        public Builder setMaxRetryTimes(Integer num) {
            this.maxRetryTimes = num;
            return this;
        }

        public Builder setMinIntervalMillis(Integer num) {
            this.minIntervalMillis = num;
            return this;
        }

        public Builder setModel(FileDownloadModel fileDownloadModel) {
            this.model = fileDownloadModel;
            return this;
        }

        public Builder setThreadPoolMonitor(IThreadPoolMonitor iThreadPoolMonitor) {
            this.threadPoolMonitor = iThreadPoolMonitor;
            return this;
        }

        public Builder setWifiRequired(Boolean bool) {
            this.isWifiRequired = bool;
            return this;
        }

        public DownloadLaunchRunnable build() {
            if (this.model != null && this.threadPoolMonitor != null && this.minIntervalMillis != null && this.callbackProgressMaxCount != null && this.isForceReDownload != null && this.isWifiRequired != null && this.maxRetryTimes != null) {
                return new DownloadLaunchRunnable(this.model, this.header, this.threadPoolMonitor, this.minIntervalMillis.intValue(), this.callbackProgressMaxCount.intValue(), this.isForceReDownload.booleanValue(), this.isWifiRequired.booleanValue(), this.maxRetryTimes.intValue(), (AnonymousClass1) null);
            }
            throw new IllegalArgumentException();
        }
    }

    private DownloadLaunchRunnable(DownloadStatusCallback downloadStatusCallback, FileDownloadModel fileDownloadModel, FileDownloadHeader fileDownloadHeader, IThreadPoolMonitor iThreadPoolMonitor, int i, int i2, boolean z, boolean z2, int i3) {
        this.defaultConnectionCount = 5;
        this.isNeedForceDiscardRange = false;
        this.downloadRunnableList = new ArrayList<>(5);
        this.lastCallbackBytes = 0L;
        this.lastCallbackTimestamp = 0L;
        this.lastUpdateBytes = 0L;
        this.lastUpdateTimestamp = 0L;
        this.alive = new AtomicBoolean(true);
        this.paused = false;
        this.isTriedFixRangeNotSatisfiable = false;
        this.model = fileDownloadModel;
        this.userRequestHeader = fileDownloadHeader;
        this.isForceReDownload = z;
        this.isWifiRequired = z2;
        this.database = CustomComponentHolder.getImpl().getDatabaseInstance();
        this.supportSeek = CustomComponentHolder.getImpl().isSupportSeek();
        this.threadPoolMonitor = iThreadPoolMonitor;
        this.validRetryTimes = i3;
        this.statusCallback = downloadStatusCallback;
    }
}
