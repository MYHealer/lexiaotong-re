package client.android.yixiaotong.util.ammeterbluetooth;

import android.os.Handler;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class UiThreadUtils {
    private UiThreadUtils() {
    }

    public static void runOnUiThread(Runnable runnable, Handler handler, long j) {
        if (runnable != null) {
            if (handler == null) {
                handler = new Handler();
            }
            try {
                handler.postDelayed(runnable, Math.max(0L, j));
            } catch (Exception unused) {
            }
        }
    }

    public static void clearHandler(Handler handler, Runnable runnable) {
        if (handler != null) {
            handler.removeCallbacks(runnable);
        }
    }
}
