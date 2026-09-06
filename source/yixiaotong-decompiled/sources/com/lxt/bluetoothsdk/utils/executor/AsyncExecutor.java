package com.lxt.bluetoothsdk.utils.executor;

import android.os.Process;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class AsyncExecutor implements IExecutor {
    private ExecutorService mExecutor;

    private static class SingletonHolder {
        public static final AsyncExecutor INSTANCE = new AsyncExecutor();

        private SingletonHolder() {
        }
    }

    public static AsyncExecutor getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private AsyncExecutor() {
        reset();
    }

    public void reset() {
        ExecutorService executorService = this.mExecutor;
        if (executorService != null) {
            executorService.shutdownNow();
        }
        this.mExecutor = Executors.newCachedThreadPool(new ThreadFactory() { // from class: com.lxt.bluetoothsdk.utils.executor.AsyncExecutor.1
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(final Runnable runnable) {
                return new Thread(new Runnable() { // from class: com.lxt.bluetoothsdk.utils.executor.AsyncExecutor.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Process.setThreadPriority(10);
                        runnable.run();
                    }
                }, "AsyncExecutor Runnable");
            }
        });
    }

    @Override // com.lxt.bluetoothsdk.utils.executor.IExecutor, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.mExecutor.execute(runnable);
    }

    @Override // com.lxt.bluetoothsdk.utils.executor.IExecutor
    public void executeDelayed(final Runnable runnable, long j) {
        MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: com.lxt.bluetoothsdk.utils.executor.AsyncExecutor.2
            @Override // java.lang.Runnable
            public void run() {
                AsyncExecutor.this.execute(runnable);
            }
        }, j);
    }
}
