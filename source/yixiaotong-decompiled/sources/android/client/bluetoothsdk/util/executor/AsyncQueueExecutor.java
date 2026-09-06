package android.client.bluetoothsdk.util.executor;

import android.os.Process;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class AsyncQueueExecutor implements IExecutor {
    private ExecutorService mExecutor = Executors.newSingleThreadExecutor();

    private static class SingletonHolder {
        public static final AsyncQueueExecutor INSTANCE = new AsyncQueueExecutor();

        private SingletonHolder() {
        }
    }

    public static AsyncQueueExecutor getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void reset() {
        ExecutorService executorService = this.mExecutor;
        if (executorService != null) {
            executorService.shutdownNow();
        }
        this.mExecutor = Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: android.client.bluetoothsdk.util.executor.AsyncQueueExecutor.1
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(final Runnable runnable) {
                return new Thread(new Runnable() { // from class: android.client.bluetoothsdk.util.executor.AsyncQueueExecutor.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Process.setThreadPriority(10);
                        runnable.run();
                    }
                }, "AsyncQueueExecutor Runnable");
            }
        });
    }

    @Override // android.client.bluetoothsdk.util.executor.IExecutor, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.mExecutor.execute(runnable);
    }

    @Override // android.client.bluetoothsdk.util.executor.IExecutor
    public void executeDelayed(final Runnable runnable, long j) {
        MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: android.client.bluetoothsdk.util.executor.AsyncQueueExecutor.2
            @Override // java.lang.Runnable
            public void run() {
                AsyncQueueExecutor.this.execute(runnable);
            }
        }, j);
    }
}
