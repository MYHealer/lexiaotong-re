package com.yfanads.android.adx.thirdpart.filedownload.download;

import android.database.sqlite.SQLiteFullException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import com.yfanads.android.adx.thirdpart.filedownload.database.FileDownloadDatabase;
import com.yfanads.android.adx.thirdpart.filedownload.exception.FileDownloadGiveUpRetryException;
import com.yfanads.android.adx.thirdpart.filedownload.exception.FileDownloadOutOfSpaceException;
import com.yfanads.android.adx.thirdpart.filedownload.message.MessageSnapshotFlow;
import com.yfanads.android.adx.thirdpart.filedownload.message.MessageSnapshotTaker;
import com.yfanads.android.adx.thirdpart.filedownload.model.FileDownloadModel;
import com.yfanads.android.adx.thirdpart.filedownload.services.FileDownloadBroadcastHandler;
import com.yfanads.android.adx.thirdpart.filedownload.util.FileDownloadLog;
import com.yfanads.android.adx.thirdpart.filedownload.util.FileDownloadProperties;
import com.yfanads.android.adx.thirdpart.filedownload.util.FileDownloadUtils;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class DownloadStatusCallback implements Handler.Callback {
    private static final String ALREADY_DEAD_MESSAGE = "require callback %d but the host thread of the flow has already dead, what is occurred because of there are several reason can final this flow on different thread.";
    private static final int CALLBACK_SAFE_MIN_INTERVAL_BYTES = 1;
    private static final int CALLBACK_SAFE_MIN_INTERVAL_MILLIS = 5;
    private static final int NO_ANY_PROGRESS_CALLBACK = -1;
    private long callbackMinIntervalBytes;
    private final int callbackProgressMaxCount;
    private final int callbackProgressMinInterval;
    private Handler handler;
    private HandlerThread handlerThread;
    private final int maxRetryTimes;
    private final FileDownloadModel model;
    private volatile Thread parkThread;
    private final ProcessParams processParams;
    private volatile boolean handlingMessage = false;
    private volatile long lastCallbackTimestamp = 0;
    private final AtomicLong callbackIncreaseBuffer = new AtomicLong();
    private final AtomicBoolean needCallbackProgressToUser = new AtomicBoolean(false);
    private final AtomicBoolean needSetProcess = new AtomicBoolean(false);
    private final AtomicBoolean isFirstCallback = new AtomicBoolean(true);
    private final FileDownloadDatabase database = CustomComponentHolder.getImpl().getDatabaseInstance();

    public static class ProcessParams {
        private Exception exception;
        private boolean isResuming;
        private int retryingTimes;

        public Exception getException() {
            return this.exception;
        }

        public int getRetryingTimes() {
            return this.retryingTimes;
        }

        public boolean isResuming() {
            return this.isResuming;
        }

        public void setException(Exception exc) {
            this.exception = exc;
        }

        public void setResuming(boolean z) {
            this.isResuming = z;
        }

        public void setRetryingTimes(int i) {
            this.retryingTimes = i;
        }
    }

    public DownloadStatusCallback(FileDownloadModel fileDownloadModel, int i, int i2, int i3) {
        this.model = fileDownloadModel;
        this.callbackProgressMinInterval = i2 < 5 ? 5 : i2;
        this.callbackProgressMaxCount = i3;
        this.processParams = new ProcessParams();
        this.maxRetryTimes = i;
    }

    private static long calculateCallbackMinIntervalBytes(long j, long j2) {
        if (j2 <= 0) {
            return -1L;
        }
        if (j == -1) {
            return 1L;
        }
        long j3 = j / j2;
        if (j3 <= 0) {
            return 1L;
        }
        return j3;
    }

    private Exception exFiltrate(Exception exc) {
        long length;
        String tempFilePath = this.model.getTempFilePath();
        if ((!this.model.isChunked() && !FileDownloadProperties.getImpl().fileNonPreAllocation) || !(exc instanceof IOException) || !new File(tempFilePath).exists()) {
            return exc;
        }
        long freeSpaceBytes = FileDownloadUtils.getFreeSpaceBytes(tempFilePath);
        if (freeSpaceBytes > 4096) {
            return exc;
        }
        File file = new File(tempFilePath);
        if (file.exists()) {
            length = file.length();
        } else {
            FileDownloadLog.e(this, exc, "Exception with: free space isn't enough, and the target file not exist.", new Object[0]);
            length = 0;
        }
        return new FileDownloadOutOfSpaceException(freeSpaceBytes, 4096L, length, exc);
    }

    private void handleCompleted() throws IOException {
        renameTempFile();
        this.model.setStatus((byte) -3);
        this.database.updateCompleted(this.model.getId(), this.model.getTotal());
        this.database.removeConnections(this.model.getId());
        onStatusChanged((byte) -3);
        if (FileDownloadProperties.getImpl().broadcastCompleted) {
            FileDownloadBroadcastHandler.sendCompletedBroadcast(this.model);
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void handleError(Exception exc) {
        SQLiteFullException sQLiteFullException;
        Exception excExFiltrate = exFiltrate(exc);
        if (excExFiltrate instanceof SQLiteFullException) {
            handleSQLiteFullException((SQLiteFullException) excExFiltrate);
            sQLiteFullException = excExFiltrate;
        } else {
            try {
                this.model.setStatus((byte) -1);
                this.model.setErrMsg(exc.toString());
                this.database.updateError(this.model.getId(), excExFiltrate, this.model.getSoFar());
                sQLiteFullException = excExFiltrate;
            } catch (SQLiteFullException e) {
                SQLiteFullException sQLiteFullException2 = e;
                handleSQLiteFullException(sQLiteFullException2);
                sQLiteFullException = sQLiteFullException2;
            }
        }
        this.processParams.setException(sQLiteFullException);
        onStatusChanged((byte) -1);
    }

    private void handlePaused() {
        this.model.setStatus((byte) -2);
        this.database.updatePause(this.model.getId(), this.model.getSoFar());
        onStatusChanged((byte) -2);
    }

    private void handleProgress() {
        if (this.model.getSoFar() == this.model.getTotal()) {
            this.database.updateProgress(this.model.getId(), this.model.getSoFar());
            return;
        }
        if (this.needSetProcess.compareAndSet(true, false)) {
            if (FileDownloadLog.NEED_LOG) {
                FileDownloadLog.i(this, "handleProgress update model's status with progress", new Object[0]);
            }
            this.model.setStatus((byte) 3);
        }
        if (this.needCallbackProgressToUser.compareAndSet(true, false)) {
            if (FileDownloadLog.NEED_LOG) {
                FileDownloadLog.i(this, "handleProgress notify user progress status", new Object[0]);
            }
            onStatusChanged((byte) 3);
        }
    }

    private void handleRetry(Exception exc, int i) {
        Exception excExFiltrate = exFiltrate(exc);
        this.processParams.setException(excExFiltrate);
        this.processParams.setRetryingTimes(this.maxRetryTimes - i);
        this.model.setStatus((byte) 5);
        this.model.setErrMsg(excExFiltrate.toString());
        this.database.updateRetry(this.model.getId(), excExFiltrate);
        onStatusChanged((byte) 5);
    }

    private void handleSQLiteFullException(SQLiteFullException sQLiteFullException) {
        int id = this.model.getId();
        if (FileDownloadLog.NEED_LOG) {
            FileDownloadLog.d(this, "the data of the task[%d] is dirty, because the SQLite full exception[%s], so remove it from the database directly.", Integer.valueOf(id), sQLiteFullException.toString());
        }
        this.model.setErrMsg(sQLiteFullException.toString());
        this.model.setStatus((byte) -1);
        this.database.remove(id);
        this.database.removeConnections(id);
    }

    private void inspectNeedCallbackToUser(long j) {
        if (!this.isFirstCallback.compareAndSet(true, false)) {
            long j2 = j - this.lastCallbackTimestamp;
            if (this.callbackMinIntervalBytes == -1 || this.callbackIncreaseBuffer.get() < this.callbackMinIntervalBytes || j2 < this.callbackProgressMinInterval) {
                return;
            }
        }
        if (this.needCallbackProgressToUser.compareAndSet(false, true)) {
            if (FileDownloadLog.NEED_LOG) {
                FileDownloadLog.i(this, "inspectNeedCallbackToUser need callback to user", new Object[0]);
            }
            this.lastCallbackTimestamp = j;
            this.callbackIncreaseBuffer.set(0L);
        }
    }

    private boolean interceptBeforeCompleted() {
        if (this.model.isChunked()) {
            FileDownloadModel fileDownloadModel = this.model;
            fileDownloadModel.setTotal(fileDownloadModel.getSoFar());
            return false;
        }
        if (this.model.getSoFar() == this.model.getTotal()) {
            return false;
        }
        onErrorDirectly(new FileDownloadGiveUpRetryException(FileDownloadUtils.formatString("sofar[%d] not equal total[%d]", Long.valueOf(this.model.getSoFar()), Long.valueOf(this.model.getTotal()))));
        return true;
    }

    private void onStatusChanged(byte b) {
        if (b != -2) {
            MessageSnapshotFlow.getImpl().inflow(MessageSnapshotTaker.take(b, this.model, this.processParams));
        } else if (FileDownloadLog.NEED_LOG) {
            FileDownloadLog.d(this, "High concurrent cause, Already paused and we don't need to call-back to Task in here, %d", Integer.valueOf(this.model.getId()));
        }
    }

    private void renameTempFile() throws IOException {
        String tempFilePath = this.model.getTempFilePath();
        String targetFilePath = this.model.getTargetFilePath();
        File file = new File(tempFilePath);
        try {
            File file2 = new File(targetFilePath);
            if (file2.exists()) {
                long length = file2.length();
                if (!file2.delete()) {
                    throw new IOException(FileDownloadUtils.formatString("Can't delete the old file([%s], [%d]), so can't replace it with the new downloaded one.", targetFilePath, Long.valueOf(length)));
                }
                FileDownloadLog.w(this, "The target file([%s], [%d]) will be replaced with the new downloaded file[%d]", targetFilePath, Long.valueOf(length), Long.valueOf(file.length()));
            }
            boolean zRenameTo = true ^ file.renameTo(file2);
            if (zRenameTo) {
                throw new IOException(FileDownloadUtils.formatString("Can't rename the  temp downloaded file(%s) to the target file(%s)", tempFilePath, targetFilePath));
            }
            if (zRenameTo && file.exists() && !file.delete()) {
                FileDownloadLog.w(this, "delete the temp file(%s) failed, on completed downloading.", tempFilePath);
            }
        } catch (Throwable th) {
            if (1 != 0 && file.exists() && !file.delete()) {
                FileDownloadLog.w(this, "delete the temp file(%s) failed, on completed downloading.", tempFilePath);
            }
            throw th;
        }
    }

    private synchronized void sendMessage(Message message) {
        if (!this.handlerThread.isAlive()) {
            if (FileDownloadLog.NEED_LOG) {
                FileDownloadLog.d(this, ALREADY_DEAD_MESSAGE, Integer.valueOf(message.what));
            }
            return;
        }
        try {
            this.handler.sendMessage(message);
        } catch (IllegalStateException e) {
            if (this.handlerThread.isAlive()) {
                throw e;
            }
            if (FileDownloadLog.NEED_LOG) {
                FileDownloadLog.d(this, ALREADY_DEAD_MESSAGE, Integer.valueOf(message.what));
            }
        }
    }

    public boolean isAlive() {
        HandlerThread handlerThread = this.handlerThread;
        return handlerThread != null && handlerThread.isAlive();
    }

    public void onCompletedDirectly() throws IOException {
        if (interceptBeforeCompleted()) {
            return;
        }
        handleCompleted();
    }

    public void onConnected(boolean z, long j, String str, String str2) throws IllegalArgumentException {
        String eTag = this.model.getETag();
        if (eTag != null && !eTag.equals(str)) {
            throw new IllegalArgumentException(FileDownloadUtils.formatString("callback onConnected must with precondition succeed, but the etag is changes(%s != %s)", str, eTag));
        }
        this.processParams.setResuming(z);
        this.model.setStatus((byte) 2);
        this.model.setTotal(j);
        this.model.setETag(str);
        this.model.setFilename(str2);
        this.database.updateConnected(this.model.getId(), j, str, str2);
        onStatusChanged((byte) 2);
        this.callbackMinIntervalBytes = calculateCallbackMinIntervalBytes(j, this.callbackProgressMaxCount);
        this.needSetProcess.compareAndSet(false, true);
    }

    public void onErrorDirectly(Exception exc) {
        handleError(exc);
    }

    public void onMultiConnection() {
        HandlerThread handlerThread = new HandlerThread("source-status-callback");
        this.handlerThread = handlerThread;
        handlerThread.start();
        this.handler = new Handler(this.handlerThread.getLooper(), this);
    }

    public void onPausedDirectly() {
        handlePaused();
    }

    public void onPending() {
        this.model.setStatus((byte) 1);
        this.database.updatePending(this.model.getId());
        onStatusChanged((byte) 1);
    }

    public void onProgress(long j) {
        this.callbackIncreaseBuffer.addAndGet(j);
        this.model.increaseSoFar(j);
        inspectNeedCallbackToUser(SystemClock.elapsedRealtime());
        if (this.handler == null) {
            handleProgress();
        } else if (this.needCallbackProgressToUser.get()) {
            sendMessage(this.handler.obtainMessage(3));
        }
    }

    public void onRetry(Exception exc, int i) {
        this.callbackIncreaseBuffer.set(0L);
        Handler handler = this.handler;
        if (handler == null) {
            handleRetry(exc, i);
        } else {
            sendMessage(handler.obtainMessage(5, i, 0, exc));
        }
    }

    public void onStartThread() {
        this.model.setStatus((byte) 6);
        onStatusChanged((byte) 6);
        this.database.onTaskStart(this.model.getId());
    }

    public void discardAllMessage() {
        Handler handler = this.handler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.handlerThread.quit();
            this.parkThread = Thread.currentThread();
            while (this.handlingMessage) {
                LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(100L));
            }
            this.parkThread = null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0020  */
    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        this.handlingMessage = true;
        int i = message.what;
        try {
            if (i != 3) {
                if (i == 5) {
                    handleRetry((Exception) message.obj, message.arg1);
                }
                this.handlingMessage = false;
                if (this.parkThread != null) {
                    LockSupport.unpark(this.parkThread);
                }
                return true;
            }
            handleProgress();
            this.handlingMessage = false;
            if (this.parkThread != null) {
                LockSupport.unpark(this.parkThread);
            }
            return true;
        } catch (Throwable th) {
            this.handlingMessage = false;
            if (this.parkThread != null) {
                LockSupport.unpark(this.parkThread);
            }
            throw th;
        }
    }
}
