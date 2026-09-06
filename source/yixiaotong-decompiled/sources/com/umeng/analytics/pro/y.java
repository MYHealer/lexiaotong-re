package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SessionIdManager.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class y {
    private static volatile y c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private w f9183a = new x();
    private String b;
    private List<a> d;
    private String e;

    /* JADX INFO: compiled from: SessionIdManager.java */
    public interface a {
        void a(String str, long j, long j2, long j3);

        void a(String str, String str2, long j, long j2, long j3);
    }

    private y() {
    }

    public static y a() {
        if (c == null) {
            synchronized (y.class) {
                if (c == null) {
                    c = new y();
                }
            }
        }
        return c;
    }

    public void a(long j) {
        this.f9183a.a(j);
    }

    public long b() {
        return this.f9183a.a();
    }

    public String a(Context context) {
        Context appContext = UMGlobalContext.getAppContext(context);
        if (appContext == null) {
            return "";
        }
        String string = "";
        try {
            synchronized (y.class) {
                string = PreferenceWrapper.getDefault(appContext).getString(u.d, "");
            }
        } catch (Exception unused) {
        }
        return string;
    }

    public synchronized String b(Context context) {
        Context appContext = UMGlobalContext.getAppContext(context);
        if (appContext == null) {
            return "";
        }
        this.b = d(appContext);
        if (e(appContext)) {
            try {
                this.b = f(appContext);
            } catch (Exception unused) {
            }
        }
        return this.b;
    }

    public String c(Context context) {
        Context appContext = UMGlobalContext.getAppContext(context);
        if (appContext == null) {
            return "";
        }
        try {
            this.b = f(appContext);
        } catch (Exception unused) {
        }
        return this.b;
    }

    public String d(Context context) {
        if (TextUtils.isEmpty(this.b)) {
            try {
                this.b = PreferenceWrapper.getDefault(context).getString("session_id", null);
            } catch (Exception unused) {
            }
        }
        return this.b;
    }

    public String a(Context context, long j) {
        if (TextUtils.isEmpty(this.e)) {
            String str = "SUB" + j;
            this.e = str + String.format("%0" + (32 - str.length()) + com.kuaishou.weapon.p0.t.t, 0);
        }
        return this.e;
    }

    public boolean e(Context context) {
        if (TextUtils.isEmpty(this.b)) {
            this.b = d(context);
        }
        return TextUtils.isEmpty(this.b) || j(context) || g(context);
    }

    private String f(Context context) {
        try {
            SharedPreferences.Editor editorEdit = PreferenceWrapper.getDefault(context).edit();
            editorEdit.putString(u.d, d(context));
            editorEdit.commit();
        } catch (Exception unused) {
        }
        long jH = h(context);
        long jI = i(context);
        String str = this.b;
        long jA = u.a(context);
        long j = jA * 5000;
        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>*** 读取 foreground count 值完成，count次数：" + jA);
        if (FieldManager.allow(com.umeng.commonsdk.utils.b.E)) {
            if (UMWorkDispatch.eventHasExist()) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>*** 读取 foreground count druation值完成，终止checker timer.");
                UMWorkDispatch.removeEvent();
            } else {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>*** 读取 foreground count druation值完成，无未处理check timer事件。");
            }
        } else {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>*** foreground count druation云控参数关闭。");
        }
        a(jI, jH, j, str, false);
        this.b = this.f9183a.a(context);
        a(jI, jH, j, str, true);
        this.f9183a.a(context, this.b);
        return this.b;
    }

    private boolean g(Context context) {
        return !TextUtils.isEmpty(this.b) && i.a(context).a(this.b) > 0;
    }

    private long a(Context context, String str) {
        long j;
        try {
            j = PreferenceWrapper.getDefault(context).getLong(str, 0L);
        } catch (Exception unused) {
            j = 0;
        }
        return j <= 0 ? System.currentTimeMillis() : j;
    }

    private long h(Context context) {
        return a(context, u.f);
    }

    private long i(Context context) {
        return a(context, u.f9179a);
    }

    private void a(long j, long j2, long j3, String str, boolean z) {
        List<a> list = this.d;
        if (list != null) {
            for (a aVar : list) {
                if (z) {
                    try {
                        aVar.a(str, this.b, j, j2, j3);
                    } catch (Exception unused) {
                    }
                } else {
                    aVar.a(this.b, j, j2, j3);
                }
            }
        }
    }

    private boolean j(Context context) {
        Context appContext = UMGlobalContext.getAppContext(context);
        try {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(appContext);
            long j = sharedPreferences.getLong(u.e, 0L);
            long j2 = sharedPreferences.getLong(u.f, 0L);
            if (FieldManager.allow(com.umeng.commonsdk.utils.b.E) && j > 0 && j2 == 0) {
                long jA = u.a(appContext);
                if (jA > 0) {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> last session end time stamp = 0, reconstruct it by foreground count value.");
                    j2 = j + (jA * 5000);
                }
            }
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> interval of last session is: " + (j2 - j));
            return this.f9183a.a(j, j2);
        } catch (Exception unused) {
            return false;
        }
    }

    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        if (this.d == null) {
            this.d = new ArrayList();
        }
        if (this.d.contains(aVar)) {
            return;
        }
        this.d.add(aVar);
    }

    public void b(a aVar) {
        List<a> list;
        if (aVar == null || (list = this.d) == null || list.size() == 0) {
            return;
        }
        this.d.remove(aVar);
    }
}
