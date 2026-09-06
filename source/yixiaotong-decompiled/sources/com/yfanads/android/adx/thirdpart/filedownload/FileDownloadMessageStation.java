package com.yfanads.android.adx.thirdpart.filedownload;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.yfanads.android.adx.thirdpart.filedownload.util.FileDownloadExecutors;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class FileDownloadMessageStation {
    public static final int DEFAULT_INTERVAL = 10;
    public static final int DEFAULT_SUB_PACKAGE_SIZE = 5;
    static final int DISPOSE_MESSENGER_LIST = 2;
    static final int HANDOVER_A_MESSENGER = 1;
    private final ArrayList<IFileDownloadMessenger> disposingList;
    private final Handler handler;
    private final Object queueLock;
    private final LinkedBlockingQueue<IFileDownloadMessenger> waitingQueue;
    private static final Executor BLOCK_COMPLETED_POOL = FileDownloadExecutors.newDefaultThreadPool(5, "BlockCompleted");
    static int INTERVAL = 10;
    static int SUB_PACKAGE_SIZE = 5;

    public static final class HolderClass {
        private static final FileDownloadMessageStation INSTANCE = new FileDownloadMessageStation();

        private HolderClass() {
        }
    }

    public static class UIHandlerCallback implements Handler.Callback {
        private UIHandlerCallback() {
        }

        private void dispose(ArrayList<IFileDownloadMessenger> arrayList) {
            for (IFileDownloadMessenger iFileDownloadMessenger : arrayList) {
                if (!FileDownloadMessageStation.interceptBlockCompleteMessage(iFileDownloadMessenger)) {
                    iFileDownloadMessenger.handoverMessage();
                }
            }
            arrayList.clear();
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                ((IFileDownloadMessenger) message.obj).handoverMessage();
            } else if (i == 2) {
                dispose((ArrayList) message.obj);
                FileDownloadMessageStation.getImpl().push();
            }
            return true;
        }
    }

    private void enqueue(IFileDownloadMessenger iFileDownloadMessenger) {
        synchronized (this.queueLock) {
            this.waitingQueue.offer(iFileDownloadMessenger);
        }
        push();
    }

    public static FileDownloadMessageStation getImpl() {
        return HolderClass.INSTANCE;
    }

    private void handoverInUIThread(IFileDownloadMessenger iFileDownloadMessenger) {
        Handler handler = this.handler;
        handler.sendMessage(handler.obtainMessage(1, iFileDownloadMessenger));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean interceptBlockCompleteMessage(final IFileDownloadMessenger iFileDownloadMessenger) {
        if (!iFileDownloadMessenger.isBlockingCompleted()) {
            return false;
        }
        BLOCK_COMPLETED_POOL.execute(new Runnable() { // from class: com.yfanads.android.adx.thirdpart.filedownload.FileDownloadMessageStation.1
            @Override // java.lang.Runnable
            public void run() {
                iFileDownloadMessenger.handoverMessage();
            }
        });
        return true;
    }

    public static boolean isIntervalValid() {
        return INTERVAL > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void push() {
        synchronized (this.queueLock) {
            if (this.disposingList.isEmpty()) {
                if (this.waitingQueue.isEmpty()) {
                    return;
                }
                int i = 0;
                if (isIntervalValid()) {
                    int i2 = INTERVAL;
                    int iMin = Math.min(this.waitingQueue.size(), SUB_PACKAGE_SIZE);
                    while (i < iMin) {
                        this.disposingList.add(this.waitingQueue.remove());
                        i++;
                    }
                    i = i2;
                } else {
                    this.waitingQueue.drainTo(this.disposingList);
                }
                Handler handler = this.handler;
                handler.sendMessageDelayed(handler.obtainMessage(2, this.disposingList), i);
            }
        }
    }

    public void requestEnqueue(IFileDownloadMessenger iFileDownloadMessenger) {
        requestEnqueue(iFileDownloadMessenger, false);
    }

    private FileDownloadMessageStation() {
        this.queueLock = new Object();
        this.disposingList = new ArrayList<>();
        this.handler = new Handler(Looper.getMainLooper(), new UIHandlerCallback());
        this.waitingQueue = new LinkedBlockingQueue<>();
    }

    public void requestEnqueue(IFileDownloadMessenger iFileDownloadMessenger, boolean z) {
        if (iFileDownloadMessenger.handoverDirectly()) {
            iFileDownloadMessenger.handoverMessage();
            return;
        }
        if (interceptBlockCompleteMessage(iFileDownloadMessenger)) {
            return;
        }
        if (!isIntervalValid() && !this.waitingQueue.isEmpty()) {
            synchronized (this.queueLock) {
                if (!this.waitingQueue.isEmpty()) {
                    Iterator<IFileDownloadMessenger> it = this.waitingQueue.iterator();
                    while (it.hasNext()) {
                        handoverInUIThread(it.next());
                    }
                }
                this.waitingQueue.clear();
            }
        }
        if (!isIntervalValid() || z) {
            handoverInUIThread(iFileDownloadMessenger);
        } else {
            enqueue(iFileDownloadMessenger);
        }
    }
}
