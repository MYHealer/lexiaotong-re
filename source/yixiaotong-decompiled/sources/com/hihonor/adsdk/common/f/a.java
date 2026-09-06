package com.hihonor.adsdk.common.f;

import android.app.Application;
import com.yfanads.android.qapp.Val;
import java.lang.ref.SoftReference;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class a {
    private static final String hnadsb = "AdtUtil";
    private SoftReference<Application> hnadsa;

    /* JADX INFO: renamed from: com.hihonor.adsdk.common.f.a$a, reason: collision with other inner class name */
    static /* synthetic */ class C0458a {
    }

    private static final class b {
        private static final a hnadsa = new a(null);

        private b() {
        }
    }

    /* synthetic */ a(C0458a c0458a) {
        this();
    }

    private Application hnadsa() {
        try {
            return (Application) Class.forName(Val.AT).getMethod("currentApplication", new Class[0]).invoke(null, new Object[0]);
        } catch (Throwable th) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsb, "currentApplication, getMethod currentApplication error, Exception: " + th.getMessage(), new Object[0]);
            return null;
        }
    }

    private Application hnadsc() {
        try {
            return (Application) Class.forName("android.app.AppGlobals").getMethod("getInitialApplication", new Class[0]).invoke(null, new Object[0]);
        } catch (Throwable th) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsb, "getInitialApplication, getMethod getInitialApplication error, Exception: " + th.getMessage(), new Object[0]);
            return null;
        }
    }

    public static a hnadsd() {
        return b.hnadsa;
    }

    public Application hnadsb() {
        SoftReference<Application> softReference = this.hnadsa;
        if (softReference == null || softReference.get() == null) {
            Application applicationHnadsa = hnadsa();
            if (applicationHnadsa == null) {
                applicationHnadsa = hnadsc();
            }
            this.hnadsa = new SoftReference<>(applicationHnadsa);
        }
        return this.hnadsa.get();
    }

    private a() {
        this.hnadsa = null;
    }
}
