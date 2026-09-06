package client.android.yixiaotong.controller.core;

import android.os.Looper;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.util.executor.AsyncExecutor;
import client.android.yixiaotong.util.executor.AsyncQueueExecutor;
import client.android.yixiaotong.util.executor.MainThreadExecutor;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class BaseControllers {
    public static final int TYPE_ADD_PET = 2;
    public static final int TYPE_ADD_SHARE = 6;
    public static final int TYPE_COMPLETE_ADDRESS = 1;
    public static final int TYPE_LIKE = 9;
    public static final int TYPE_REVIEW_HELP = 8;
    public static final int TYPE_REVIEW_SHARE = 7;
    public static final int TYPE_USE_INVICE_CODE = 4;

    protected final void callStart(final Controller controller) {
        runToMainThread(new Runnable() { // from class: client.android.yixiaotong.controller.core.BaseControllers.1
            @Override // java.lang.Runnable
            public void run() {
                Listener<?> listener = controller.getListener();
                if (listener != null) {
                    listener.onStart(controller);
                }
            }
        });
    }

    protected final <R> void callProgress(final Controller controller, final long j, final long j2, final int i) {
        runToMainThread(new Runnable() { // from class: client.android.yixiaotong.controller.core.BaseControllers.2
            @Override // java.lang.Runnable
            public void run() {
                Listener<?> listener = controller.getListener();
                if (listener != null) {
                    listener.onProgress(controller, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i));
                }
            }
        });
    }

    protected final <R> void callCacheComplete(final Controller controller, final R r, final Object... objArr) {
        runToMainThread(new Runnable() { // from class: client.android.yixiaotong.controller.core.BaseControllers.3
            @Override // java.lang.Runnable
            public void run() {
                Listener<?> listener = controller.getListener();
                if (listener != null) {
                    listener.onCacheComplete(controller, r, objArr);
                }
            }
        });
    }

    protected final <R> void callCacheFail(final Controller controller) {
        runToMainThread(new Runnable() { // from class: client.android.yixiaotong.controller.core.BaseControllers.4
            @Override // java.lang.Runnable
            public void run() {
                Listener<?> listener = controller.getListener();
                if (listener != null) {
                    listener.onCacheFail(controller);
                }
            }
        });
    }

    protected final <R> void callProgressComplete(final Controller controller, final boolean z, final R r, final Object... objArr) {
        runToMainThread(new Runnable() { // from class: client.android.yixiaotong.controller.core.BaseControllers.5
            @Override // java.lang.Runnable
            public void run() {
                Listener<?> listener = controller.getListener();
                if (listener != null) {
                    listener.onProgressLoadComplete(controller, z, r, objArr);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <R> void callComplete(final Controller controller, final R r, final Object... objArr) {
        runToMainThread(new Runnable() { // from class: client.android.yixiaotong.controller.core.BaseControllers.6
            @Override // java.lang.Runnable
            public void run() {
                Listener<?> listener = controller.getListener();
                if (listener != null) {
                    listener.onComplete(controller, r, objArr);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void callFail(final Controller controller, final ClientException clientException) {
        if (clientException.getException() != null) {
            clientException.getException().printStackTrace();
        }
        runToMainThread(new Runnable() { // from class: client.android.yixiaotong.controller.core.BaseControllers.7
            @Override // java.lang.Runnable
            public void run() {
                Listener<?> listener = controller.getListener();
                if (listener != null) {
                    listener.onFail(controller, clientException);
                }
            }
        }, 1000L);
    }

    protected final void runToAsyncThread(Runnable runnable) {
        AsyncExecutor.getInstance().execute(runnable);
    }

    protected final void runToAsyncCommandQueue(Runnable runnable) {
        AsyncQueueExecutor.getInstance().execute(runnable);
    }

    protected final void runToMainThread(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            MainThreadExecutor.getInstance().execute(runnable);
        }
    }

    protected final void runToMainThread(Runnable runnable, long j) {
        MainThreadExecutor.getInstance().executeDelayed(runnable, j);
    }

    public final void cancelController(Controller controller) {
        if (controller != null) {
            controller.cancelController();
        }
    }
}
