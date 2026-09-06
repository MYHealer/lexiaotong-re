package com.huawei.hms.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.stub.StubApp;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class gk {
    private static final String B = "NotificationActionManager";
    public static final String Code = "com.huawei.ads.notification.action.CLICK";
    public static final int I = 1;
    private static gk S = null;
    public static final String V = "com.huawei.ads.notification.action.DELETE";
    public static final String Z = "type";
    private Context D;
    private ej L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, Class<? extends gj>> f3852a = new HashMap();
    private BroadcastReceiver b = new BroadcastReceiver() { // from class: com.huawei.hms.ads.gk.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || TextUtils.isEmpty(intent.getAction())) {
                fh.Code(gk.B, "intent or action maybe empty.");
            } else {
                fh.Code(gk.B, " action name:%s", intent.getAction());
                gk.this.Code(context, intent);
            }
        }
    };
    private static final byte[] C = new byte[0];
    private static final byte[] F = new byte[0];

    private gk(Context context) {
        this.D = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.L = ej.Code(context);
    }

    public static gk Code(Context context) {
        synchronized (C) {
            if (S == null) {
                S = new gk(context);
            }
        }
        return S;
    }

    private void V() {
        this.f3852a.put("com.huawei.ads.notification.action.CLICK1", ge.class);
        this.f3852a.put("com.huawei.ads.notification.action.DELETE1", gg.class);
    }

    public void Code() {
        String str;
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(V);
            com.huawei.openalliance.ad.utils.z.Code(this.D, this.b, intentFilter);
        } catch (IllegalStateException unused) {
            str = "init IllegalStateException";
            fh.I(B, str);
        } catch (Exception unused2) {
            str = "init Exception";
            fh.I(B, str);
        }
        V();
    }

    public void Code(Context context, Intent intent) {
        StringBuilder sb;
        String str;
        try {
            String str2 = intent.getAction() + intent.getIntExtra("type", 1);
            Class<? extends gj> cls = this.f3852a.get(str2);
            if (cls != null) {
                try {
                    cls.newInstance().Code(this.D, intent);
                } catch (InstantiationException unused) {
                    str = "InstantiationException can not instantiation notification Action";
                    fh.I(B, str);
                } catch (Throwable unused2) {
                    str = "Throwable can not instantiation notification Action";
                    fh.I(B, str);
                }
            } else {
                fh.V(B, "can not find action key:" + str2);
            }
        } catch (IllegalStateException e) {
            e = e;
            sb = new StringBuilder("actionReceiver.onReceive IllegalStateException:");
            fh.I(B, sb.append(e.getClass().getSimpleName()).toString());
        } catch (Throwable th) {
            e = th;
            sb = new StringBuilder("actionReceiver.onReceive Exception:");
            fh.I(B, sb.append(e.getClass().getSimpleName()).toString());
        }
    }

    public void Code(String str) {
        if (TextUtils.isEmpty(str)) {
            fh.V(B, "add packageName is Empty.");
            return;
        }
        synchronized (F) {
            try {
                Set<String> setAk = this.L.ak();
                if (setAk != null) {
                    setAk.add(str);
                    ej.Code(this.D).Code(setAk);
                }
            } catch (Throwable th) {
                fh.V(B, "addPackage" + th.getClass().getSimpleName());
            }
        }
    }

    public boolean I(String str) {
        if (TextUtils.isEmpty(str)) {
            fh.V(B, "isPackageExist packageName is Empty.");
            return false;
        }
        synchronized (F) {
            Set<String> setAk = this.L.ak();
            if (setAk == null) {
                return false;
            }
            return setAk.contains(str);
        }
    }

    public void V(String str) {
        if (TextUtils.isEmpty(str)) {
            fh.V(B, "remove packageName is Empty.");
            return;
        }
        synchronized (F) {
            try {
                Set<String> setAk = this.L.ak();
                if (setAk != null) {
                    setAk.remove(str);
                    ej.Code(this.D).Code(setAk);
                }
            } catch (Throwable th) {
                fh.V(B, "removePackage" + th.getClass().getSimpleName());
            }
        }
    }
}
