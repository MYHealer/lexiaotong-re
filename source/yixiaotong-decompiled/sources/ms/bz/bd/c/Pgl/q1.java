package ms.bz.bd.c.Pgl;

import android.text.TextUtils;
import android.view.Display;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.io.encoding.Base64;
import okio.Utf8;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class q1 {
    private static q1 c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f9704a;
    private boolean da;
    private String i;
    private int n = 1;
    private String sp;
    private long tt;
    private long uj;
    private long ve;
    private String x;

    private q1() {
    }

    public static Object c(Object obj, String str) {
        Field field;
        try {
            Method declaredMethod = Class.class.getDeclaredMethod((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "bd8d6e", new byte[]{116, 99, 95, 52, 12, 113, 109, 68, 123, 49, 119, SignedBytes.MAX_POWER_OF_TWO, 66, Ascii.NAK, 5, 118}), String.class);
            if (declaredMethod == null || (field = (Field) declaredMethod.invoke(obj.getClass(), str)) == null) {
                return null;
            }
            field.setAccessible(true);
            return field.get(obj);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String c(Display[] displayArr) {
        try {
            StringBuilder sb = new StringBuilder();
            for (Display display : displayArr) {
                Object objC = c(display, (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "c92e80", new byte[]{127, Ascii.DC4, 86, Ascii.US, 2, 53, 80, Ascii.EM, 96, 62, 115, 60, 68, Utf8.REPLACEMENT_BYTE, 6, 42, 101}));
                if (objC != null && !sb.toString().contains(objC.toString())) {
                    sb.append(objC);
                    sb.append((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "a8f663", new byte[]{43}));
                }
            }
            if (sb.length() > 0) {
                return sb.toString();
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static q1 c() {
        if (c == null) {
            c = new q1();
        }
        return c;
    }

    public static String tt(Display[] displayArr) {
        try {
            StringBuilder sb = new StringBuilder();
            for (Display display : displayArr) {
                StringBuilder sb2 = new StringBuilder();
                Object objC = c(display, (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "fbb0ac", new byte[]{122, 68, Ascii.CAN, 87, 78, 120, 100, 90, 26, 110, 113, 111}));
                sb2.append(c(objC, (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f42403", new byte[]{120, 33, 79, 69, Ascii.GS, Ascii.DC4, 100, Ascii.SYN, 104, 101, 112, 51, 111, 65, 2, 33}))).append((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "998e4c", new byte[]{100}));
                sb2.append(c(objC, (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "9b3c3e", new byte[]{46, 108, 65, 16, Ascii.US}))).append((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "0740f6", new byte[]{109}));
                sb2.append(c(objC, (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "de4d23", new byte[]{123, 102, 74, Ascii.NAK}))).append((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "6e7e5e", new byte[]{107}));
                sb2.append(c(objC, (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "ce6dea", new byte[]{102, 126, 85, Ascii.NAK})));
                if (!sb.toString().contains(sb2.toString())) {
                    if (sb.length() > 0) {
                        sb.append((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "d3b45b", new byte[]{46}));
                    }
                    sb.append((CharSequence) sb2);
                }
            }
            if (sb.length() > 0) {
                return sb.toString();
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public final void c(int i) {
        if (this.n != i) {
            this.f9704a = System.currentTimeMillis() / 1000;
        }
        this.n = i;
    }

    public final void c(long j) {
        this.tt = j;
        this.sp = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "4a97c0", new byte[]{36, 103, 78});
    }

    public final void c(String str) {
        this.x = str;
    }

    public final void tt() {
        this.da = true;
    }

    public final void tt(long j) {
        this.ve = j;
        this.sp = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "0c789b", new byte[]{51, 100, 73, 67, 16, 112});
    }

    public final void tt(String str) {
        this.i = str;
    }

    public final boolean uj() {
        return this.tt > 0 || this.ve > 0 || this.f9704a > 0;
    }

    public final JSONObject ve() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "315e4f", new byte[]{35, 39}), this.tt);
            jSONObject.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "12d1e2", new byte[]{50, 36}), this.ve);
            jSONObject.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f6de21", new byte[]{115, 57}), this.n);
            jSONObject.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "01d3d1", new byte[]{37, 39}), this.f9704a);
            jSONObject.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "1d94a2", new byte[]{35, 103, 78}), this.da ? 1 : 0);
            jSONObject.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "596875", new byte[]{41, Utf8.REPLACEMENT_BYTE}), this.sp);
            if (!TextUtils.isEmpty(this.x)) {
                jSONObject.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "6e2e84", new byte[]{55, 108}), this.x);
            }
            if (!TextUtils.isEmpty(this.i)) {
                jSONObject.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "861d89", new byte[]{45, Base64.padSymbol}), this.i);
            }
            this.uj = System.currentTimeMillis();
            jSONObject.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "881a67", new byte[]{42, 46}), this.uj / 1000);
            if (jSONObject.length() > 0) {
                return jSONObject;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
