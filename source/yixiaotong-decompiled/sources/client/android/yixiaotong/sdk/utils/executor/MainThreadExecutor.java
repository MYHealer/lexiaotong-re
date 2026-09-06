package client.android.yixiaotong.sdk.utils.executor;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class MainThreadExecutor implements IExecutor {
    private final Handler mHandler;
    private Runnable mRunnable;

    /* JADX INFO: renamed from: client.android.yixiaotong.sdk.utils.executor.MainThreadExecutor$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* synthetic */ MainThreadExecutor(AnonymousClass1 anonymousClass1) {
        this();
    }

    private static class SingletonHolder {
        public static final MainThreadExecutor INSTANCE = new MainThreadExecutor(null);

        private SingletonHolder() {
        }
    }

    public static MainThreadExecutor getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private MainThreadExecutor() {
        this.mHandler = new Handler(Looper.getMainLooper());
    }

    @Override // client.android.yixiaotong.sdk.utils.executor.IExecutor, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.mHandler.post(runnable);
    }

    @Override // client.android.yixiaotong.sdk.utils.executor.IExecutor
    public void executeDelayed(Runnable runnable, long j) {
        Runnable runnable2 = this.mRunnable;
        if (runnable2 != null && j > 1000) {
            this.mHandler.removeCallbacks(runnable2);
        }
        this.mHandler.postDelayed(runnable, j);
        this.mRunnable = runnable;
    }
}
