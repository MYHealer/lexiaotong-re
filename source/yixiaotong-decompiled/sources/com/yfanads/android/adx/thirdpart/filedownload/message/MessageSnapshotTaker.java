package com.yfanads.android.adx.thirdpart.filedownload.message;

import com.yfanads.android.adx.thirdpart.filedownload.BaseDownloadTask;
import com.yfanads.android.adx.thirdpart.filedownload.download.DownloadStatusCallback;
import com.yfanads.android.adx.thirdpart.filedownload.model.FileDownloadModel;
import com.yfanads.android.adx.thirdpart.filedownload.util.FileDownloadLog;
import com.yfanads.android.adx.thirdpart.filedownload.util.FileDownloadUtils;
import java.io.File;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class MessageSnapshotTaker {
    public static MessageSnapshot catchCanReusedOldFile(int i, File file, boolean z) {
        long length = file.length();
        if (length > 2147483647L) {
            return z ? new LargeMessageSnapshot.CompletedFlowDirectlySnapshot(i, true, length) : new LargeMessageSnapshot.CompletedSnapshot(i, true, length);
        }
        return z ? new SmallMessageSnapshot.CompletedFlowDirectlySnapshot(i, true, (int) length) : new SmallMessageSnapshot.CompletedSnapshot(i, true, (int) length);
    }

    public static MessageSnapshot catchException(int i, long j, Throwable th) {
        return j > 2147483647L ? new LargeMessageSnapshot.ErrorMessageSnapshot(i, j, th) : new SmallMessageSnapshot.ErrorMessageSnapshot(i, (int) j, th);
    }

    public static MessageSnapshot catchPause(BaseDownloadTask baseDownloadTask) {
        return baseDownloadTask.isLargeFile() ? new LargeMessageSnapshot.PausedSnapshot(baseDownloadTask.getId(), baseDownloadTask.getLargeFileSoFarBytes(), baseDownloadTask.getLargeFileTotalBytes()) : new SmallMessageSnapshot.PausedSnapshot(baseDownloadTask.getId(), baseDownloadTask.getSmallFileSoFarBytes(), baseDownloadTask.getSmallFileTotalBytes());
    }

    public static MessageSnapshot catchWarn(int i, long j, long j2, boolean z) {
        if (j2 > 2147483647L) {
            return z ? new LargeMessageSnapshot.WarnFlowDirectlySnapshot(i, j, j2) : new LargeMessageSnapshot.WarnMessageSnapshot(i, j, j2);
        }
        return z ? new SmallMessageSnapshot.WarnFlowDirectlySnapshot(i, (int) j, (int) j2) : new SmallMessageSnapshot.WarnMessageSnapshot(i, (int) j, (int) j2);
    }

    public static MessageSnapshot take(byte b, FileDownloadModel fileDownloadModel) {
        return take(b, fileDownloadModel, null);
    }

    public static MessageSnapshot takeBlockCompleted(MessageSnapshot messageSnapshot) {
        if (messageSnapshot.getStatus() == -3) {
            return new BlockCompleteMessage.BlockCompleteMessageImpl(messageSnapshot);
        }
        throw new IllegalStateException(FileDownloadUtils.formatString("take block completed snapshot, must has already be completed. %d %d", Integer.valueOf(messageSnapshot.getId()), Byte.valueOf(messageSnapshot.getStatus())));
    }

    public static MessageSnapshot take(byte b, FileDownloadModel fileDownloadModel, DownloadStatusCallback.ProcessParams processParams) {
        MessageSnapshot completedSnapshot;
        int id = fileDownloadModel.getId();
        if (b == -4) {
            throw new IllegalStateException(FileDownloadUtils.formatString("please use #catchWarn instead %d", Integer.valueOf(id)));
        }
        if (b == -3) {
            completedSnapshot = fileDownloadModel.isLargeFile() ? new LargeMessageSnapshot.CompletedSnapshot(id, false, fileDownloadModel.getTotal()) : new SmallMessageSnapshot.CompletedSnapshot(id, false, (int) fileDownloadModel.getTotal());
        } else if (b == -1) {
            completedSnapshot = fileDownloadModel.isLargeFile() ? new LargeMessageSnapshot.ErrorMessageSnapshot(id, fileDownloadModel.getSoFar(), processParams.getException()) : new SmallMessageSnapshot.ErrorMessageSnapshot(id, (int) fileDownloadModel.getSoFar(), processParams.getException());
        } else {
            if (b == 1) {
                return fileDownloadModel.isLargeFile() ? new LargeMessageSnapshot.PendingMessageSnapshot(id, fileDownloadModel.getSoFar(), fileDownloadModel.getTotal()) : new SmallMessageSnapshot.PendingMessageSnapshot(id, (int) fileDownloadModel.getSoFar(), (int) fileDownloadModel.getTotal());
            }
            if (b == 2) {
                String filename = fileDownloadModel.isPathAsDirectory() ? fileDownloadModel.getFilename() : null;
                return fileDownloadModel.isLargeFile() ? new LargeMessageSnapshot.ConnectedMessageSnapshot(id, processParams.isResuming(), fileDownloadModel.getTotal(), fileDownloadModel.getETag(), filename) : new SmallMessageSnapshot.ConnectedMessageSnapshot(id, processParams.isResuming(), (int) fileDownloadModel.getTotal(), fileDownloadModel.getETag(), filename);
            }
            if (b == 3) {
                return fileDownloadModel.isLargeFile() ? new LargeMessageSnapshot.ProgressMessageSnapshot(id, fileDownloadModel.getSoFar()) : new SmallMessageSnapshot.ProgressMessageSnapshot(id, (int) fileDownloadModel.getSoFar());
            }
            if (b != 5) {
                if (b == 6) {
                    return new MessageSnapshot.StartedMessageSnapshot(id);
                }
                String string = FileDownloadUtils.formatString("it can't takes a snapshot for the task(%s) when its status is %d,", fileDownloadModel, Byte.valueOf(b));
                FileDownloadLog.w(MessageSnapshotTaker.class, "it can't takes a snapshot for the task(%s) when its status is %d,", fileDownloadModel, Byte.valueOf(b));
                IllegalStateException illegalStateException = processParams.getException() != null ? new IllegalStateException(string, processParams.getException()) : new IllegalStateException(string);
                return fileDownloadModel.isLargeFile() ? new LargeMessageSnapshot.ErrorMessageSnapshot(id, fileDownloadModel.getSoFar(), illegalStateException) : new SmallMessageSnapshot.ErrorMessageSnapshot(id, (int) fileDownloadModel.getSoFar(), illegalStateException);
            }
            completedSnapshot = fileDownloadModel.isLargeFile() ? new LargeMessageSnapshot.RetryMessageSnapshot(id, fileDownloadModel.getSoFar(), processParams.getException(), processParams.getRetryingTimes()) : new SmallMessageSnapshot.RetryMessageSnapshot(id, (int) fileDownloadModel.getSoFar(), processParams.getException(), processParams.getRetryingTimes());
        }
        return completedSnapshot;
    }
}
