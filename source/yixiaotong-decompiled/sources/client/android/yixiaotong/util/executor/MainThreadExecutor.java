package client.android.yixiaotong.util.executor;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class MainThreadExecutor implements IExecutor {
    private final Handler mHandler;

    /* JADX INFO: renamed from: client.android.yixiaotong.util.executor.MainThreadExecutor$1, reason: invalid class name */
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

    @Override // client.android.yixiaotong.util.executor.IExecutor, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.mHandler.post(runnable);
    }

    @Override // client.android.yixiaotong.util.executor.IExecutor
    public void executeDelayed(Runnable runnable, long j) {
        this.mHandler.postDelayed(runnable, j);
    }
}
