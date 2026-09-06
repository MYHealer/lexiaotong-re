package com.opos.cmn.an.f.c;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.huawei.hms.ads.ez;
import com.huawei.hms.ml.camera.CountryCodeBean;
import com.huawei.openalliance.ad.constant.x;
import com.opos.cmn.an.f.b.g;
import com.yfanads.android.qapp.Val;
import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f5919a = b("ZGVidWcuY29tLm9wb3MuY21uLmxvZw==");
    private static volatile Boolean b = null;
    private static volatile Boolean c = null;
    private static volatile String d = "";

    private static String a(long j) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date(j));
        } catch (Exception unused) {
            return "";
        }
    }

    public static String a(com.opos.cmn.an.f.b.b.d dVar) {
        StringBuilder sb = new StringBuilder("[");
        sb.append(dVar.f5903a).append("][").append(a(dVar.g)).append("][").append(Process.myPid()).append("][").append(dVar.f).append(x.bQ).append(dVar.e).append("]:");
        if (dVar.h == 2) {
            Object[] objArr = (Object[]) dVar.b;
            int length = objArr.length;
            if (length > 0) {
                for (int i = 0; i < length; i++) {
                    sb.append(objArr[i]);
                    if (i < length - 1) {
                        sb.append(",");
                    }
                }
            }
        } else {
            sb.append(dVar.b);
        }
        if (dVar.c != null) {
            sb.append(IOUtils.LINE_SEPARATOR_UNIX);
            sb.append(Log.getStackTraceString(dVar.c));
        }
        return sb.toString();
    }

    public static String a(String str) {
        try {
            if (com.opos.cmn.an.d.a.a(str)) {
                return "";
            }
            Class<?> cls = Class.forName(CountryCodeBean.ANDRIOD_SYSTEMPROP);
            String str2 = (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, "unknown");
            return str2 != null ? str2 : "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static String a(byte[] bArr) {
        return bArr != null ? new String(Base64.decode(bArr, 2)) : "";
    }

    public static void a() {
        boolean z;
        if (b == null) {
            try {
                String strA = a(f5919a);
                z = !TextUtils.isEmpty(strA) && strA.contentEquals(ez.Code);
            } catch (Throwable unused) {
            }
            b = Boolean.valueOf(z);
        }
    }

    public static void a(Context context) {
        if (c == null) {
            boolean z = false;
            try {
                if ((context.getApplicationInfo().flags & 2) != 0) {
                    z = true;
                }
            } catch (Throwable unused) {
            }
            c = Boolean.valueOf(z);
        }
    }

    public static String b(Context context) {
        if (Build.VERSION.SDK_INT >= 29 || context == null) {
            return "";
        }
        try {
            g.a(context);
            return "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static String b(String str) {
        return !com.opos.cmn.an.d.a.a(str) ? a(str.getBytes()) : "";
    }

    public static synchronized boolean b() {
        if (b == null) {
            return false;
        }
        return b.booleanValue();
    }

    public static void c() {
        if (b()) {
            c = true;
        }
    }

    public static boolean d() {
        if (c == null) {
            return false;
        }
        return c.booleanValue();
    }

    public static boolean e() {
        try {
            return Environment.getExternalStorageState().equals("mounted");
        } catch (Exception unused) {
            return false;
        }
    }

    public static String f() {
        if (!TextUtils.isEmpty(d)) {
            return d;
        }
        d = g();
        if (TextUtils.isEmpty(d)) {
            d = h();
        }
        if (TextUtils.isEmpty(d)) {
            d = i();
        }
        return d;
    }

    public static String g() {
        if (Build.VERSION.SDK_INT >= 28) {
            return Application.getProcessName();
        }
        return null;
    }

    public static String h() {
        try {
            Method declaredMethod = Class.forName(Val.AT, false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(null, new Object[0]);
            if (objInvoke instanceof String) {
                return (String) objInvoke;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String i() {
        String line = null;
        if (TextUtils.isEmpty(null)) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/" + Process.myPid() + "/cmdline"));
                try {
                    line = bufferedReader.readLine();
                    if (!TextUtils.isEmpty(line)) {
                        line = line.trim();
                    }
                    bufferedReader.close();
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                        throw th2;
                    }
                }
            } catch (Exception unused) {
            }
        }
        return line;
    }
}
