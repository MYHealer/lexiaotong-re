package com.yfanads.android.adx.thirdpart.filedownload;

import com.yfanads.android.adx.thirdpart.filedownload.message.MessageSnapshotFlow;
import com.yfanads.android.adx.thirdpart.filedownload.util.FileDownloadExecutors;
import com.yfanads.android.adx.thirdpart.filedownload.util.FileDownloadLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
class FileDownloadTaskLauncher {
    private final LaunchTaskPool mLaunchTaskPool = new LaunchTaskPool();

    public static class HolderClass {
        private static final FileDownloadTaskLauncher INSTANCE = new FileDownloadTaskLauncher();

        static {
            MessageSnapshotFlow.getImpl().setReceiver(new MessageSnapshotGate());
        }

        private HolderClass() {
        }
    }

    public static class LaunchTaskPool {
        private ThreadPoolExecutor mPool;
        private LinkedBlockingQueue<Runnable> mWorkQueue;

        public LaunchTaskPool() {
            init();
        }

        private void init() {
            LinkedBlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<>();
            this.mWorkQueue = linkedBlockingQueue;
            this.mPool = FileDownloadExecutors.newDefaultThreadPool(3, linkedBlockingQueue, "LauncherTask");
        }

        public void asyncExecute(ITaskHunter.IStarter iStarter) {
            this.mPool.execute(new LaunchTaskRunnable(iStarter));
        }

        public void expire(ITaskHunter.IStarter iStarter) {
            this.mWorkQueue.remove(iStarter);
        }

        public void expireAll() {
            if (FileDownloadLog.NEED_LOG) {
                FileDownloadLog.d(this, "expire %d tasks", Integer.valueOf(this.mWorkQueue.size()));
            }
            this.mPool.shutdownNow();
            init();
        }

        public void expire(FileDownloadListener fileDownloadListener) {
            if (fileDownloadListener == null) {
                FileDownloadLog.w(this, "want to expire by listener, but the listener provided is null", new Object[0]);
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (Runnable runnable : this.mWorkQueue) {
                LaunchTaskRunnable launchTaskRunnable = (LaunchTaskRunnable) runnable;
                if (launchTaskRunnable.isSameListener(fileDownloadListener)) {
                    launchTaskRunnable.expire();
                    arrayList.add(runnable);
                }
            }
            if (arrayList.isEmpty()) {
                return;
            }
            if (FileDownloadLog.NEED_LOG) {
                FileDownloadLog.d(this, "expire %d tasks with listener[%s]", Integer.valueOf(arrayList.size()), fileDownloadListener);
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.mPool.remove((Runnable) it.next());
            }
        }
    }

    public static FileDownloadTaskLauncher getImpl() {
        return HolderClass.INSTANCE;
    }

    public synchronized void expire(ITaskHunter.IStarter iStarter) {
        this.mLaunchTaskPool.expire(iStarter);
    }

    public synchronized void expireAll() {
        this.mLaunchTaskPool.expireAll();
    }

    public synchronized void launch(ITaskHunter.IStarter iStarter) {
        this.mLaunchTaskPool.asyncExecute(iStarter);
    }

    public synchronized void expire(FileDownloadListener fileDownloadListener) {
        this.mLaunchTaskPool.expire(fileDownloadListener);
    }

    public static class LaunchTaskRunnable implements Runnable {
        private boolean mExpired = false;
        private final ITaskHunter.IStarter mTaskStarter;

        public LaunchTaskRunnable(ITaskHunter.IStarter iStarter) {
            this.mTaskStarter = iStarter;
        }

        public boolean equals(Object obj) {
            return super.equals(obj) || obj == this.mTaskStarter;
        }

        public void expire() {
            this.mExpired = true;
        }

        public boolean isSameListener(FileDownloadListener fileDownloadListener) {
            ITaskHunter.IStarter iStarter = this.mTaskStarter;
            return iStarter != null && iStarter.equalListener(fileDownloadListener);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mExpired) {
                return;
            }
            this.mTaskStarter.start();
        }
    }
}
