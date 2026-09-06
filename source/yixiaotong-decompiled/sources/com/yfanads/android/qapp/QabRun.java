package com.yfanads.android.qapp;

import android.app.Instrumentation;
import android.content.Context;
import android.util.Log;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class QabRun implements Qab {
    private static String TAG = "YFAds";

    @Override // com.yfanads.android.qapp.Qab
    public void install(Context context, String str, String[] strArr) {
        try {
            TAG = str;
            if (context.getMainLooper() != null && context.getMainLooper().getThread() != Thread.currentThread()) {
                Log.w(TAG, "Not in main thread, post to main thread");
                return;
            }
            Object objInvoke = Class.forName(Val.AT).getDeclaredMethod(Val.CAT, new Class[0]).invoke(null, new Object[0]);
            Field declaredField = objInvoke.getClass().getDeclaredField(Val.IN);
            declaredField.setAccessible(true);
            Instrumentation instrumentation = (Instrumentation) declaredField.get(objInvoke);
            if (instrumentation instanceof Pr) {
                Log.w(TAG, "Already hooked, skip");
            } else {
                declaredField.set(objInvoke, new Pr(instrumentation, str, strArr));
                Log.i(TAG, "hook & init success");
            }
        } catch (Throwable th) {
            Log.e(TAG, "hook failed " + th.getMessage());
        }
    }
}
