package com.ta.utdid2.device;

import android.content.Context;
import android.os.Binder;
import android.provider.Settings;
import android.text.TextUtils;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.ta.utdid2.a.a.f;
import com.ta.utdid2.a.a.g;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Random;
import java.util.regex.Pattern;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static c f8538a;
    private static final Object e = new Object();
    private static final String k = ".UTSystemConfig" + File.separator + "Global";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private com.ta.utdid2.b.a.c f955a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private d f956a;
    private com.ta.utdid2.b.a.c b;
    private String i;
    private String j;
    private Context mContext;
    private String h = null;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private Pattern f957b = Pattern.compile("[^0-9a-zA-Z=/+]+");

    private c(Context context) {
        this.mContext = null;
        this.f956a = null;
        this.i = "xx_utdid_key";
        this.j = "xx_utdid_domain";
        this.f955a = null;
        this.b = null;
        this.mContext = context;
        this.b = new com.ta.utdid2.b.a.c(context, k, "Alvin2", false, true);
        this.f955a = new com.ta.utdid2.b.a.c(context, ".DataStorage", "ContextData", false, true);
        this.f956a = new d();
        this.i = String.format("K_%d", Integer.valueOf(g.a(this.i)));
        this.j = String.format("D_%d", Integer.valueOf(g.a(this.j)));
    }

    private void c() throws Throwable {
        boolean z;
        com.ta.utdid2.b.a.c cVar = this.b;
        if (cVar != null) {
            if (g.m1003a(cVar.getString("UTDID2"))) {
                String string = this.b.getString("UTDID");
                if (!g.m1003a(string)) {
                    f(string);
                }
            }
            boolean z2 = true;
            if (g.m1003a(this.b.getString("DID"))) {
                z = false;
            } else {
                this.b.remove("DID");
                z = true;
            }
            if (g.m1003a(this.b.getString("EI"))) {
                z2 = z;
            } else {
                this.b.remove("EI");
            }
            if (!g.m1003a(this.b.getString("SI"))) {
                this.b.remove("SI");
            } else if (!z2) {
                return;
            }
            this.b.commit();
        }
    }

    public static c a(Context context) {
        if (context != null && f8538a == null) {
            synchronized (e) {
                if (f8538a == null) {
                    c cVar = new c(context);
                    f8538a = cVar;
                    cVar.c();
                }
            }
        }
        return f8538a;
    }

    private void f(String str) throws Throwable {
        com.ta.utdid2.b.a.c cVar;
        if (b(str)) {
            if (str.endsWith(IOUtils.LINE_SEPARATOR_UNIX)) {
                str = str.substring(0, str.length() - 1);
            }
            if (str.length() != 24 || (cVar = this.b) == null) {
                return;
            }
            cVar.putString("UTDID2", str);
            this.b.commit();
        }
    }

    private void g(String str) throws Throwable {
        com.ta.utdid2.b.a.c cVar;
        if (str == null || (cVar = this.f955a) == null || str.equals(cVar.getString(this.i))) {
            return;
        }
        this.f955a.putString(this.i, str);
        this.f955a.commit();
    }

    private void h(String str) {
        String string;
        if (f() && b(str)) {
            if (str.endsWith(IOUtils.LINE_SEPARATOR_UNIX)) {
                str = str.substring(0, str.length() - 1);
            }
            if (24 == str.length()) {
                try {
                    string = Settings.System.getString(this.mContext.getContentResolver(), "mqBRboGZkQPcAkyk");
                } catch (Exception unused) {
                    string = null;
                }
                if (b(string)) {
                    return;
                }
                try {
                    Settings.System.putString(this.mContext.getContentResolver(), "mqBRboGZkQPcAkyk", str);
                } catch (Exception unused2) {
                }
            }
        }
    }

    private void i(String str) {
        String string;
        try {
            string = Settings.System.getString(this.mContext.getContentResolver(), "dxCRMxhQkdGePGnp");
        } catch (Exception unused) {
            string = null;
        }
        if (str.equals(string)) {
            return;
        }
        try {
            Settings.System.putString(this.mContext.getContentResolver(), "dxCRMxhQkdGePGnp", str);
        } catch (Exception unused2) {
        }
    }

    private void j(String str) {
        if (!f() || str == null) {
            return;
        }
        i(str);
    }

    private String g() throws Throwable {
        com.ta.utdid2.b.a.c cVar = this.b;
        if (cVar == null) {
            return null;
        }
        String string = cVar.getString("UTDID2");
        if (g.m1003a(string) || this.f956a.c(string) == null) {
            return null;
        }
        return string;
    }

    private boolean b(String str) {
        if (str != null) {
            if (str.endsWith(IOUtils.LINE_SEPARATOR_UNIX)) {
                str = str.substring(0, str.length() - 1);
            }
            if (24 == str.length() && !this.f957b.matcher(str).find()) {
                return true;
            }
        }
        return false;
    }

    public synchronized String getValue() {
        String str = this.h;
        if (str != null) {
            return str;
        }
        return h();
    }

    public synchronized String h() {
        try {
            String strI = i();
            this.h = strI;
            if (!TextUtils.isEmpty(strI)) {
                return this.h;
            }
            try {
                byte[] bArrM1010c = m1010c();
                if (bArrM1010c != null) {
                    String strEncodeToString = com.ta.utdid2.a.a.b.encodeToString(bArrM1010c, 2);
                    this.h = strEncodeToString;
                    f(strEncodeToString);
                    String strC = this.f956a.c(bArrM1010c);
                    if (strC != null) {
                        j(strC);
                        g(strC);
                    }
                    return this.h;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized String i() {
        String string;
        boolean z;
        String string2 = "";
        try {
            string2 = Settings.System.getString(this.mContext.getContentResolver(), "mqBRboGZkQPcAkyk");
        } catch (Exception unused) {
        }
        if (b(string2)) {
            return string2;
        }
        e eVar = new e();
        try {
            string = Settings.System.getString(this.mContext.getContentResolver(), "dxCRMxhQkdGePGnp");
        } catch (Exception unused2) {
            string = null;
        }
        if (g.m1003a(string)) {
            z = true;
        } else {
            String strE = eVar.e(string);
            if (b(strE)) {
                h(strE);
                return strE;
            }
            String strD = eVar.d(string);
            if (b(strD)) {
                String strC = this.f956a.c(strD);
                if (!g.m1003a(strC)) {
                    j(strC);
                    try {
                        string = Settings.System.getString(this.mContext.getContentResolver(), "dxCRMxhQkdGePGnp");
                    } catch (Exception unused3) {
                    }
                }
            }
            String strD2 = this.f956a.d(string);
            if (b(strD2)) {
                this.h = strD2;
                f(strD2);
                g(string);
                h(this.h);
                return this.h;
            }
            z = false;
        }
        String strG = g();
        if (b(strG)) {
            String strC2 = this.f956a.c(strG);
            if (z) {
                j(strC2);
            }
            h(strG);
            g(strC2);
            this.h = strG;
            return strG;
        }
        String string3 = this.f955a.getString(this.i);
        if (!g.m1003a(string3)) {
            String strD3 = eVar.d(string3);
            if (!b(strD3)) {
                strD3 = this.f956a.d(string3);
            }
            if (b(strD3)) {
                String strC3 = this.f956a.c(strD3);
                if (!g.m1003a(strD3)) {
                    this.h = strD3;
                    if (z) {
                        j(strC3);
                    }
                    f(this.h);
                    return this.h;
                }
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    private byte[] m1010c() throws Exception {
        String strA;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int iCurrentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int iNextInt = new Random().nextInt();
        byte[] bytes = com.ta.utdid2.a.a.d.getBytes(iCurrentTimeMillis);
        byte[] bytes2 = com.ta.utdid2.a.a.d.getBytes(iNextInt);
        byteArrayOutputStream.write(bytes, 0, 4);
        byteArrayOutputStream.write(bytes2, 0, 4);
        byteArrayOutputStream.write(3);
        byteArrayOutputStream.write(0);
        try {
            strA = com.ta.utdid2.a.a.e.a(this.mContext);
        } catch (Exception unused) {
            strA = "" + new Random().nextInt();
        }
        byteArrayOutputStream.write(com.ta.utdid2.a.a.d.getBytes(g.a(strA)), 0, 4);
        byteArrayOutputStream.write(com.ta.utdid2.a.a.d.getBytes(g.a(b(byteArrayOutputStream.toByteArray()))));
        return byteArrayOutputStream.toByteArray();
    }

    public static String b(byte[] bArr) throws Exception {
        byte[] bArr2 = {69, 114, 116, -33, 125, -54, -31, 86, -11, 11, -78, -96, -17, -99, SignedBytes.MAX_POWER_OF_TWO, Ascii.ETB, -95, -126, -82, -64, 113, 116, -16, -103, 49, -30, 9, -39, 33, -80, -68, -78, -117, 53, Ascii.RS, -122, SignedBytes.MAX_POWER_OF_TWO, -104, 74, -49, 106, 85, -38, -93};
        Mac mac = Mac.getInstance("HmacSHA1");
        mac.init(new SecretKeySpec(f.a(bArr2), mac.getAlgorithm()));
        return com.ta.utdid2.a.a.b.encodeToString(mac.doFinal(bArr), 2);
    }

    private boolean f() {
        return this.mContext.checkPermission("android.permission.WRITE_SETTINGS", Binder.getCallingPid(), Binder.getCallingUid()) == 0;
    }
}
