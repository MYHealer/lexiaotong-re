package com.yfanads.android.adx.thirdpart.filedownload;

import android.text.TextUtils;
import android.util.SparseArray;
import com.yfanads.android.adx.thirdpart.filedownload.model.FileDownloadHeader;
import com.yfanads.android.adx.thirdpart.filedownload.model.FileDownloadStatus;
import com.yfanads.android.adx.thirdpart.filedownload.util.FileDownloadLog;
import com.yfanads.android.adx.thirdpart.filedownload.util.FileDownloadUtils;
import java.io.File;
import java.util.ArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class DownloadTask implements BaseDownloadTask, BaseDownloadTask.IRunningTask, DownloadTaskHunter.ICaptureTask {
    public static final int DEFAULT_CALLBACK_PROGRESS_MIN_INTERVAL_MILLIS = 10;
    private String mFilename;
    private ArrayList<BaseDownloadTask.FinishListener> mFinishListenerList;
    private FileDownloadHeader mHeader;
    private final ITaskHunter mHunter;
    private int mId;
    private SparseArray<Object> mKeyedTags;
    private FileDownloadListener mListener;
    private final ITaskHunter.IMessageHandler mMessageHandler;
    private String mPath;
    private boolean mPathAsDirectory;
    private final Object mPauseLock;
    private Object mTag;
    private final String mUrl;
    private int mAutoRetryTimes = 0;
    private boolean mSyncCallback = false;
    private boolean mIsWifiRequired = false;
    private int mCallbackProgressTimes = 100;
    private int mCallbackProgressMinIntervalMillis = 10;
    private boolean mIsForceReDownload = false;
    volatile int mAttachKey = 0;
    private boolean mIsInQueueTask = false;
    private final Object headerCreateLock = new Object();
    private volatile boolean mIsMarkedAdded2List = false;

    /* JADX INFO: renamed from: com.yfanads.android.adx.thirdpart.filedownload.DownloadTask$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class InQueueTaskImpl implements BaseDownloadTask.InQueueTask {
        private final DownloadTask mTask;

        public /* synthetic */ InQueueTaskImpl(DownloadTask downloadTask, AnonymousClass1 anonymousClass1) {
            this(downloadTask);
        }

        @Override // com.yfanads.android.adx.thirdpart.filedownload.BaseDownloadTask.InQueueTask
        public int enqueue() {
            int id = this.mTask.getId();
            if (FileDownloadLog.NEED_LOG) {
                FileDownloadLog.d(this, "add the task[%d] to the queue", Integer.valueOf(id));
            }
            FileDownloadList.getImpl().addUnchecked(this.mTask);
            return id;
        }

        private InQueueTaskImpl(DownloadTask downloadTask) {
            this.mTask = downloadTask;
            downloadTask.mIsInQueueTask = true;
        }
    }

    public DownloadTask(String str) {
        this.mUrl = str;
        Object obj = new Object();
        this.mPauseLock = obj;
        DownloadTaskHunter downloadTaskHunter = new DownloadTaskHunter(this, obj);
        this.mHunter = downloadTaskHunter;
        this.mMessageHandler = downloadTaskHunter;
    }

    private int startTaskUnchecked() {
        if (isUsing()) {
            if (isRunning()) {
                throw new IllegalStateException(FileDownloadUtils.formatString("This task is running %d, if you want to start the same task, please create a new one by FileDownloader.create", Integer.valueOf(getId())));
            }
            throw new IllegalStateException("This task is dirty to restart, If you want to reuse this task, please invoke #reuse method manually and retry to restart again." + this.mHunter.toString());
        }
        if (!isAttached()) {
            setAttachKeyDefault();
        }
        this.mHunter.intoLaunchPool();
        return getId();
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.BaseDownloadTask
    public BaseDownloadTask addHeader(String str, String str2) {
        checkAndCreateHeader();
        this.mHeader.add(str, str2);
        return this;
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.BaseDownloadTask
    public BaseDownloadTask.InQueueTask asInQueueTask() {
        return new InQueueTaskImpl(this, null);
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.BaseDownloadTask
    public boolean cancel() {
        return pause();
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.BaseDownloadTask.IRunningTask
    public void free() {
        this.mHunter.free();
        if (FileDownloadList.getImpl().isNotContains(this)) {
            this.mIsMarkedAdded2List = false;
        }
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.BaseDownloadTask.IRunningTask
    public int getAttachKey() {
        return this.mAttachKey;
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.BaseDownloadTask
    public int getAutoRetryTimes() {
        return this.mAutoRetryTimes;
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.BaseDownloadTask
    public int getCallbackProgressMinInterval() {
        return this.mCallbackProgressMinIntervalMillis;
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.BaseDownloadTask
    public int getCallbackProgressTimes() {
        return this.mCallbackProgressTimes;
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.BaseDownloadTask
    public int getDownloadId() {
        return getId();
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.BaseDownloadTask
    public Throwable getErrorCause() {
        return this.mHunter.getErrorCause();
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.BaseDownloadTask
    public String getEtag() {
        return this.mHunter.getEtag();
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.BaseDownloadTask
    public Throwable getEx() {
        return getErrorCause();
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.BaseDownloadTask
    public String getFilename() {
        return this.mFilename;
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.DownloadTaskHunter.ICaptureTask
    public ArrayList<BaseDownloadTask.FinishListener> getFinishListenerList() {
        return this.mFinishListenerList;
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.DownloadTaskHunter.ICaptureTask
    public FileDownloadHeader getHeader() {
        return this.mHeader;
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.BaseDownloadTask
    public long getLargeFileSoFarBytes() {
        return this.mHunter.getSofarBytes();
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.BaseDownloadTask
    public long getLargeFileTotalBytes() {
        return this.mHunter.getTotalBytes();
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.BaseDownloadTask
    public FileDownloadListener getListener() {
        return this.mListener;
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.BaseDownloadTask.IRunningTask
    public ITaskHunter.IMessageHandler getMessageHandler() {
        return this.mMessageHandler;
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.BaseDownloadTask.IRunningTask
    public BaseDownloadTask getOrigin() {
        return this;
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.BaseDownloadTask
    public String getPath() {
        return this.mPath;
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.BaseDownloadTask.IRunningTask
    public Object getPauseLock() {
        return this.mPauseLock;
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.BaseDownloadTask
    public int getRetryingTimes() {
        return this.mHunter.getRetryingTimes();
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.DownloadTaskHunter.ICaptureTask
    public BaseDownloadTask.IRunningTask getRunningTask() {
        return this;
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.BaseDownloadTask
    public int getSmallFileSoFarBytes() {
        if (this.mHunter.getSofarBytes() > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) this.mHunter.getSofarBytes();
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.BaseDownloadTask
    public int getSmallFileTotalBytes() {
        if (this.mHunter.getTotalBytes() > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) this.mHunter.getTotalBytes();
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.BaseDownloadTask
    public int getSoFarBytes() {
        return getSmallFileSoFarBytes();
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.BaseDownloadTask
    public int getSpeed() {
        return this.mHunter.getSpeed();
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.BaseDownloadTask
    public byte getStatus() {
        return this.mHunter.getStatus();
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.BaseDownloadTask
    public Object getTag() {
        return this.mTag;
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.BaseDownloadTask
    public String getTargetFilePath() {
        return FileDownloadUtils.getTargetFilePath(getPath(), isPathAsDirectory(), getFilename());
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.BaseDownloadTask
    public int getTotalBytes() {
        return getSmallFileTotalBytes();
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.BaseDownloadTask
    public String getUrl() {
        return this.mUrl;
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.BaseDownloadTask.IRunningTask
    public boolean is(int i) {
        return getId() == i;
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.BaseDownloadTask
    public boolean isAttached() {
        return this.mAttachKey != 0;
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.BaseDownloadTask.IRunningTask
    public boolean isContainFinishListener() {
        ArrayList<BaseDownloadTask.FinishListener> arrayList = this.mFinishListenerList;
        return arrayList != null && arrayList.size() > 0;
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.BaseDownloadTask
    public boolean isContinue() {
        return isResuming();
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.BaseDownloadTask
    public boolean isForceReDownload() {
        return this.mIsForceReDownload;
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.BaseDownloadTask
    public boolean isLargeFile() {
        return this.mHunter.isLargeFile();
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.BaseDownloadTask.IRunningTask
    public boolean isMarkedAdded2List() {
        return this.mIsMarkedAdded2List;
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.BaseDownloadTask.IRunningTask
    public boolean isOver() {
        return FileDownloadStatus.isOver(getStatus());
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.BaseDownloadTask
    public boolean isPathAsDirectory() {
        return this.mPathAsDirectory;
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.BaseDownloadTask
    public boolean isResuming() {
        return this.mHunter.isResuming();
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.BaseDownloadTask
    public boolean isReusedOldFile() {
        return this.mHunter.isReusedOldFile();
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.BaseDownloadTask
    public boolean isRunning() {
        if (FileDownloader.getImpl().getLostConnectedHandler().isInWaitingList(this)) {
            return true;
        }
        return FileDownloadStatus.isIng(getStatus());
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.BaseDownloadTask
    public boolean isSyncCallback() {
        return this.mSyncCallback;
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.BaseDownloadTask
    public boolean isUsing() {
        return this.mHunter.getStatus() != 0;
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.BaseDownloadTask
    public boolean isWifiRequired() {
        return this.mIsWifiRequired;
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.BaseDownloadTask.IRunningTask
    public void markAdded2List() {
        this.mIsMarkedAdded2List = true;
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.BaseDownloadTask
    public boolean pause() {
        boolean zPause;
        synchronized (this.mPauseLock) {
            zPause = this.mHunter.pause();
        }
        return zPause;
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.BaseDownloadTask
    public int ready() {
        return asInQueueTask().enqueue();
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.BaseDownloadTask
    public boolean removeFinishListener(BaseDownloadTask.FinishListener finishListener) {
        ArrayList<BaseDownloadTask.FinishListener> arrayList = this.mFinishListenerList;
        return arrayList != null && arrayList.remove(finishListener);
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.BaseDownloadTask
    public boolean reuse() {
        if (isRunning()) {
            FileDownloadLog.w(this, "This task[%d] is running, if you want start the same task, please create a new one by FileDownloader#create", Integer.valueOf(getId()));
            return false;
        }
        this.mAttachKey = 0;
        this.mIsInQueueTask = false;
        this.mIsMarkedAdded2List = false;
        this.mHunter.reset();
        return true;
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.BaseDownloadTask.IRunningTask
    public void setAttachKeyByQueue(int i) {
        this.mAttachKey = i;
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.BaseDownloadTask.IRunningTask
    public void setAttachKeyDefault() {
        this.mAttachKey = getListener() != null ? getListener().hashCode() : hashCode();
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.BaseDownloadTask
    public BaseDownloadTask setAutoRetryTimes(int i) {
        this.mAutoRetryTimes = i;
        return this;
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.BaseDownloadTask
    public BaseDownloadTask setCallbackProgressIgnored() {
        return setCallbackProgressTimes(-1);
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.BaseDownloadTask
    public BaseDownloadTask setCallbackProgressMinInterval(int i) {
        this.mCallbackProgressMinIntervalMillis = i;
        return this;
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.BaseDownloadTask
    public BaseDownloadTask setCallbackProgressTimes(int i) {
        this.mCallbackProgressTimes = i;
        return this;
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.DownloadTaskHunter.ICaptureTask
    public void setFileName(String str) {
        this.mFilename = str;
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.BaseDownloadTask
    public BaseDownloadTask setFinishListener(BaseDownloadTask.FinishListener finishListener) {
        addFinishListener(finishListener);
        return this;
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.BaseDownloadTask
    public BaseDownloadTask setForceReDownload(boolean z) {
        this.mIsForceReDownload = z;
        return this;
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.BaseDownloadTask
    public BaseDownloadTask setMinIntervalUpdateSpeed(int i) {
        this.mHunter.setMinIntervalUpdateSpeed(i);
        return this;
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.BaseDownloadTask
    public BaseDownloadTask setPath(String str) {
        return setPath(str, false);
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.BaseDownloadTask
    public BaseDownloadTask setSyncCallback(boolean z) {
        this.mSyncCallback = z;
        return this;
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.BaseDownloadTask
    public BaseDownloadTask setWifiRequired(boolean z) {
        this.mIsWifiRequired = z;
        return this;
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.BaseDownloadTask.IRunningTask
    public void startTaskByQueue() {
        startTaskUnchecked();
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.BaseDownloadTask.IRunningTask
    public void startTaskByRescue() {
        startTaskUnchecked();
    }

    public String toString() {
        return FileDownloadUtils.formatString("%d@%s", Integer.valueOf(getId()), super.toString());
    }

    private void checkAndCreateHeader() {
        if (this.mHeader == null) {
            synchronized (this.headerCreateLock) {
                if (this.mHeader == null) {
                    this.mHeader = new FileDownloadHeader();
                }
            }
        }
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.BaseDownloadTask
    public BaseDownloadTask addFinishListener(BaseDownloadTask.FinishListener finishListener) {
        if (this.mFinishListenerList == null) {
            this.mFinishListenerList = new ArrayList<>();
        }
        if (!this.mFinishListenerList.contains(finishListener)) {
            this.mFinishListenerList.add(finishListener);
        }
        return this;
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.BaseDownloadTask
    public Object getTag(int i) {
        SparseArray<Object> sparseArray = this.mKeyedTags;
        if (sparseArray == null) {
            return null;
        }
        return sparseArray.get(i);
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.BaseDownloadTask.IRunningTask
    public boolean is(FileDownloadListener fileDownloadListener) {
        return getListener() == fileDownloadListener;
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.BaseDownloadTask
    public BaseDownloadTask removeAllHeaders(String str) {
        if (this.mHeader == null) {
            synchronized (this.headerCreateLock) {
                if (this.mHeader == null) {
                    return this;
                }
            }
        }
        this.mHeader.removeAll(str);
        return this;
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.BaseDownloadTask
    public BaseDownloadTask setTag(Object obj) {
        this.mTag = obj;
        if (FileDownloadLog.NEED_LOG) {
            FileDownloadLog.d(this, "setTag %s", obj);
        }
        return this;
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.BaseDownloadTask
    public BaseDownloadTask addHeader(String str) {
        checkAndCreateHeader();
        this.mHeader.add(str);
        return this;
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.BaseDownloadTask
    public BaseDownloadTask setListener(FileDownloadListener fileDownloadListener) {
        this.mListener = fileDownloadListener;
        if (FileDownloadLog.NEED_LOG) {
            FileDownloadLog.d(this, "setListener %s", fileDownloadListener);
        }
        return this;
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.BaseDownloadTask
    public BaseDownloadTask setPath(String str, boolean z) {
        this.mPath = str;
        if (FileDownloadLog.NEED_LOG) {
            FileDownloadLog.d(this, "setPath %s", str);
        }
        this.mPathAsDirectory = z;
        if (z) {
            this.mFilename = null;
        } else {
            this.mFilename = new File(str).getName();
        }
        return this;
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.BaseDownloadTask
    public int getId() {
        int i = this.mId;
        if (i != 0) {
            return i;
        }
        if (TextUtils.isEmpty(this.mPath) || TextUtils.isEmpty(this.mUrl)) {
            return 0;
        }
        int iGenerateId = FileDownloadUtils.generateId(this.mUrl, this.mPath, this.mPathAsDirectory);
        this.mId = iGenerateId;
        return iGenerateId;
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.BaseDownloadTask
    public BaseDownloadTask setTag(int i, Object obj) {
        if (this.mKeyedTags == null) {
            this.mKeyedTags = new SparseArray<>(2);
        }
        this.mKeyedTags.put(i, obj);
        return this;
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.BaseDownloadTask
    public int start() {
        if (!this.mIsInQueueTask) {
            return startTaskUnchecked();
        }
        throw new IllegalStateException("If you start the task manually, it means this task doesn't belong to a queue, so you must not invoke BaseDownloadTask#ready() or InQueueTask#enqueue() before you start() this method. For detail: If this task doesn't belong to a queue, what is just an isolated task, you just need to invoke BaseDownloadTask#start() to start this task, that's all. In other words, If this task doesn't belong to a queue, you must not invoke BaseDownloadTask#ready() method or InQueueTask#enqueue() method before invoke BaseDownloadTask#start(), If you do that and if there is the same listener object to start a queue in another thread, this task may be assembled by the queue, in that case, when you invoke BaseDownloadTask#start() manually to start this task or this task is started by the queue, there is an exception buried in there, because this task object is started two times without declare BaseDownloadTask#reuse() : 1. you invoke BaseDownloadTask#start() manually;  2. the queue start this task automatically.");
    }
}
