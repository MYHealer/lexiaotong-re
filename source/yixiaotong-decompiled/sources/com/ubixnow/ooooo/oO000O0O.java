package com.ubixnow.ooooo;

import android.util.Log;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class oO000O0O {
    private static final String OooO00o = "SpHelper";
    private static boolean OooO0O0 = false;
    private static String OooO0OO = "android.app.QueuedWork";
    private static String OooO0Oo = "sPendingWorkFinishers";
    private static ConcurrentLinkedQueue<Runnable> OooO0o0;

    private static void OooO00o() {
        Log.d(OooO00o, "getPendingWorkFinishers");
        try {
            Field declaredField = Class.forName(OooO0OO).getDeclaredField(OooO0Oo);
            declaredField.setAccessible(true);
            OooO0o0 = (ConcurrentLinkedQueue) declaredField.get(null);
            Log.d(OooO00o, "getPendingWorkFinishers success");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (NoSuchFieldException e3) {
            e3.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void OooO00o(String str) {
        if (!OooO0O0) {
            OooO00o();
            OooO0O0 = true;
        }
        Log.d(OooO00o, "beforeSpBlock " + str);
        ConcurrentLinkedQueue<Runnable> concurrentLinkedQueue = OooO0o0;
        if (concurrentLinkedQueue != null) {
            concurrentLinkedQueue.clear();
        }
    }
}
