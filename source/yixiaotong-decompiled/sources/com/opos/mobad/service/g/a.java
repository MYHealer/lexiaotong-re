package com.opos.mobad.service.g;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.opos.cmn.an.c.c;
import com.opos.cmn.i.f;
import com.opos.mobad.ad.e;
import com.opos.mobad.b.a.ae;
import com.opos.mobad.b.a.al;
import com.opos.mobad.b.a.h;
import com.opos.mobad.b.a.l;
import com.opos.mobad.b.a.m;
import com.opos.mobad.b.a.n;
import com.opos.mobad.b.a.o;
import com.opos.mobad.b.a.p;
import com.opos.mobad.b.a.q;
import com.opos.mobad.b.a.w;
import com.opos.mobad.b.a.z;
import com.opos.mobad.service.e.d;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ae f7379a;
    private static o b;

    public static final h a(Context context, String str, String str2, String str3) {
        int iValueOf;
        HashMap map = new HashMap();
        int i = 1;
        if (Build.VERSION.SDK_INT <= 33) {
            iValueOf = 1;
        } else {
            int i2 = 0;
            try {
                int iUnsafeCheckOp = ((AppOpsManager) context.getSystemService("appops")).unsafeCheckOp("android:direction_sensors", Process.myUid(), context.getPackageName());
                com.opos.cmn.an.f.a.b("", "unsafeCheckOp:" + iUnsafeCheckOp);
                if (iUnsafeCheckOp == 3) {
                    i = 2;
                } else if (iUnsafeCheckOp != 0) {
                    i = 0;
                }
                i2 = i;
            } catch (Throwable th) {
                com.opos.cmn.an.f.a.a("", "getAppInfo", th);
            }
            iValueOf = Integer.valueOf(i2);
        }
        map.put("accelerationStatus", iValueOf);
        return new h.a().a(str).b(str2).c(str3).a(map).b();
    }

    public static final n a(Context context) {
        m.a aVarK = new m.a().b(com.opos.mobad.service.e.b.n().f()).c("").g(com.opos.mobad.service.d.a.a().n()).h(com.opos.mobad.service.d.a.a().h()).i(com.opos.mobad.service.d.a.a().i()).j(com.opos.mobad.service.d.a.a().j()).k(com.opos.mobad.service.e.b.n().d() ? f.a(context) : "");
        com.opos.mobad.service.d.a.C0991a c0991aL = com.opos.mobad.service.d.a.a().l();
        if (c0991aL != null) {
            m.a aVarA = aVarK.a(c0991aL.f7355a);
            c0991aL.getClass();
            aVarA.a((Integer) 1);
        } else {
            aVarK.a("");
        }
        m mVarB = aVarK.b();
        p pVarB = new p.a().a(Float.valueOf(com.opos.cmn.an.h.f.a.f(context))).a(Integer.valueOf(com.opos.cmn.an.h.f.a.c(context))).b(Integer.valueOf(com.opos.cmn.an.h.f.a.b(context))).b();
        double[] dArr = {0.0d, 0.0d};
        e.a aVarC = com.opos.mobad.service.e.b.n().c();
        if (aVarC != null) {
            dArr[0] = aVarC.a();
            dArr[1] = aVarC.b();
        }
        return new n.a().a(mVarB).a(f()).a(pVarB).a(new q.a().a(new l.a().b(String.valueOf(dArr[0])).a(String.valueOf(dArr[1])).a(Long.valueOf(System.currentTimeMillis())).b()).a(c(context)).a(a(d.a().r())).a(Integer.valueOf(com.opos.cmn.an.h.f.a.i(context))).b()).a(c.a()).b(d()).c(com.opos.cmn.an.c.a.a(context)).d(com.opos.mobad.service.d.a.a().c()).e(com.opos.mobad.service.d.a.a().d()).a(Boolean.valueOf(com.opos.cmn.an.f.a.b(context))).b();
    }

    private static final q.c a(String str) {
        q.c cVar = q.c.UNKNOWN_OPERATOR;
        if (TextUtils.isEmpty(str)) {
            return cVar;
        }
        str.hashCode();
        switch (str) {
            case "telecom":
                return q.c.CHINA_TELECOM;
            case "mobile":
                return q.c.CHINA_MOBILE;
            case "unicom":
                return q.c.CHINA_UNICOM;
            default:
                return cVar;
        }
    }

    public static final w a() {
        return new w.a().a(Boolean.valueOf(d.a().c())).a(d.a().d()).b(d.a().b()).a(Long.valueOf(d.a().q())).b();
    }

    public static final al b() {
        return new al.a().a(Boolean.valueOf(d.a().e())).a(d.a().f()).b(d.a().g()).b();
    }

    public static final z b(Context context) {
        d.b bVarK = d.a().k();
        return new z.a().a(bVarK.b).a(Integer.valueOf(bVarK.f7370a)).b();
    }

    public static final com.opos.mobad.b.a.e c() {
        d.b bVarL = d.a().l();
        if (bVarL == null) {
            return null;
        }
        return new com.opos.mobad.b.a.e.a().a(bVarL.b).a(Integer.valueOf(bVarL.f7370a)).b();
    }

    private static final q.b c(Context context) {
        q.b bVar = q.b.CONNECTION_UNKNOWN;
        String strH = com.opos.cmn.an.h.c.a.h(context);
        strH.hashCode();
        switch (strH) {
            case "2g":
                return q.b.CELL_2G;
            case "3g":
                return q.b.CELL_3G;
            case "4g":
                return q.b.CELL_4G;
            case "5g":
                return q.b.CELL_5G;
            case "wifi":
                return q.b.WIFI;
            default:
                return bVar;
        }
    }

    public static final String d() {
        try {
            return System.getProperty("http.agent");
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("", "", (Throwable) e);
            return "";
        }
    }

    public static final ae e() {
        if (f7379a == null) {
            f7379a = new ae.a().a(Integer.valueOf(d.a().m())).a(d.a().n()).b(Integer.valueOf(d.a().o())).c(Integer.valueOf(com.opos.cmn.f.c.a().a())).b();
        }
        return f7379a;
    }

    private static final o f() {
        if (b == null) {
            b = new o.a().a(d.a().h()).c(d.a().j()).b(d.a().i()).b();
        }
        return b;
    }
}
