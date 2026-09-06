package com.huawei.hms.feature;

import android.content.Context;
import android.util.Log;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class DynamicModuleInitializer {
    private static WeakReference<Context> sContext;

    public static void initializeModule(Context context) {
        sContext = new WeakReference<>(context);
    }

    public static Context getContext() {
        WeakReference<Context> weakReference = sContext;
        if (weakReference != null) {
            return weakReference.get();
        }
        Log.i("DynamicModuleInitia", "getContext: is null");
        return null;
    }
}
