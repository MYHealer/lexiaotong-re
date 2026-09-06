package testlanya.android.client.sdk.util;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class MainThreadExecutor implements IExecutor {
    private final Handler mHandler;
    private Runnable mRunnable;

    /* JADX INFO: renamed from: testlanya.android.client.sdk.util.MainThreadExecutor$1, reason: invalid class name */
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

    @Override // testlanya.android.client.sdk.util.IExecutor, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.mHandler.post(runnable);
    }

    @Override // testlanya.android.client.sdk.util.IExecutor
    public void executeDelayed(Runnable runnable, long j) {
        this.mHandler.postDelayed(runnable, j);
        this.mRunnable = runnable;
    }

    public void removeCallback() {
        Runnable runnable = this.mRunnable;
        if (runnable != null) {
            this.mHandler.removeCallbacks(runnable);
        }
    }
}
