package com.byazt.th;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.MethodUtils;
import com.yfanads.android.qapp.Val;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 78, 20})
public class c {
    public static Class c;
    public static Object tt;

    public static final Object c() {
        if (tt == null) {
            try {
                synchronized (c.class) {
                    if (tt == null) {
                        if (c == null) {
                            c = Class.forName(Val.AT);
                        }
                        tt = MethodUtils.invokeStaticMethod(c, Val.CAT, new Object[0]);
                    }
                    if (tt == null && Looper.myLooper() != Looper.getMainLooper()) {
                        final Object obj = new Object();
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.byazt.th.c.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    try {
                                        Object unused = c.tt = MethodUtils.invokeStaticMethod(c.c, Val.CAT, new Object[0]);
                                        synchronized (obj) {
                                            obj.notify();
                                        }
                                    } catch (Exception e) {
                                        ZeusLogger.errReport(ZeusLogger.TAG, "ActivityThreadHelper main looper invoke currentActivityThread failed.", e);
                                        synchronized (obj) {
                                            obj.notify();
                                        }
                                    }
                                } catch (Throwable th) {
                                    synchronized (obj) {
                                        obj.notify();
                                        throw th;
                                    }
                                }
                            }
                        });
                        if (tt == null) {
                            synchronized (obj) {
                                try {
                                    obj.wait(5000L);
                                } catch (InterruptedException e) {
                                    ZeusLogger.errReport(ZeusLogger.TAG, "ActivityThreadHelper currentActivityThread interruptedException failed.", e);
                                }
                            }
                        }
                    }
                }
            } catch (Exception e2) {
                ZeusLogger.errReport(ZeusLogger.TAG, "ActivityThreadHelper currentActivityThread failed.", e2);
            }
        }
        return tt;
    }
}
