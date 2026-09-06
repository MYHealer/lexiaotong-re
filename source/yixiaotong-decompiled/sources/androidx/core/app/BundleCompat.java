package androidx.core.app;

import android.os.Bundle;
import android.os.IBinder;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
@Deprecated
public final class BundleCompat {
    private BundleCompat() {
    }

    public static IBinder getBinder(Bundle bundle, String str) {
        return androidx.core.os.BundleCompat.getBinder(bundle, str);
    }

    public static void putBinder(Bundle bundle, String str, IBinder iBinder) {
        androidx.core.os.BundleCompat.putBinder(bundle, str, iBinder);
    }
}
