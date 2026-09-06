package com.xiaomi.onetrack.c;

import android.os.HandlerThread;
import android.text.TextUtils;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.xiaomi.onetrack.util.x;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class s {
    private p g;
    private static final String d = ijiami_1011.s.s.s.d(new byte[]{103, Ascii.SYN, 93, 92, 84, 2, 4, Ascii.SYN, 35, 12, 86, 12, 92, 3}, "2f135f");
    private static final String e = ijiami_1011.s.s.s.d(new byte[]{0, 88, 84, 92}, "c709c6");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f9480a = ijiami_1011.s.s.s.d(new byte[]{1, 94, 15, 87, 95, 5}, "b1a16b");
    public static final String b = ijiami_1011.s.s.s.d(new byte[]{89, 65, 69, 124, 83}, "815579");
    public static final String c = ijiami_1011.s.s.s.d(new byte[]{SignedBytes.MAX_POWER_OF_TWO, 92, 66, Ascii.DC2, 11, 89, 15}, "690ab6");
    private static final String f = ijiami_1011.s.s.s.d(new byte[]{48, 102, 36, 78, 93}, "e2bce4");

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final s f9481a = new s(null);

        private a() {
        }
    }

    private s() {
        b();
    }

    public /* synthetic */ s(t tVar) {
        this();
    }

    public static s a() {
        return a.f9481a;
    }

    private boolean a(JSONArray jSONArray) {
        try {
            String strB = x.a().b();
            String string = jSONArray.toString();
            String str = d;
            com.xiaomi.onetrack.util.p.a(str, ijiami_1011.s.s.s.d(new byte[]{65, 70, 4, 72, 91, 89, 0, 0, 92}, "a6e176") + string);
            byte[] bArrA = a(a(string));
            com.xiaomi.onetrack.util.p.a(str, ijiami_1011.s.s.s.d(new byte[]{90, 81, 0, 86, 17, 83, 65, Ascii.RS, 15, Ascii.DC2, 17, 4, 86, 80, 70, 92, 13, 85, 19, Ascii.GS, Ascii.SYN, Ascii.SYN, Ascii.GS, 69, 84, 81, 8, 4}, "84f9c6") + string.length() + ijiami_1011.s.s.s.d(new byte[]{74, Ascii.EM, 0, 85, 17, 82, 19, 89}, "f9a3e7") + bArrA.length);
            String strA = com.xiaomi.onetrack.g.b.a(strB, bArrA);
            com.xiaomi.onetrack.util.p.a(str, ijiami_1011.s.s.s.d(new byte[]{Ascii.SYN, 7, 94, 92, 114, 86, Ascii.NAK, 5, 50, 13, 98, 0, Ascii.ETB, Ascii.DC4, 85, 74, Ascii.SYN, 69, 4, Ascii.ETB, Ascii.SYN, 13, 95, Ascii.SYN, 0, 88, 16}, "eb0867") + strA);
            if (TextUtils.isEmpty(strA)) {
                return false;
            }
            return b(strA);
        } catch (Exception e2) {
            com.xiaomi.onetrack.util.p.b(d, ijiami_1011.s.s.s.d(new byte[]{38, 77, 1, 82, 67, 67, 8, 11, 8, 66, 70, 13, 10, 89, 7, Ascii.ETB, 70, 71, 13, 11, 7, 6, 88, 11, 4, Ascii.NAK}, "c5b737"), e2);
            return false;
        }
    }

    private static byte[] a(String str) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        GZIPOutputStream gZIPOutputStream;
        GZIPOutputStream gZIPOutputStream2 = null;
        byte[] byteArray = null;
        gZIPOutputStream2 = null;
        try {
            try {
                String str2 = f;
                byteArrayOutputStream = new ByteArrayOutputStream(str.getBytes(str2).length);
                try {
                    gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                    try {
                        gZIPOutputStream.write(str.getBytes(str2));
                        gZIPOutputStream.finish();
                        byteArray = byteArrayOutputStream.toByteArray();
                    } catch (Exception e2) {
                        e = e2;
                        com.xiaomi.onetrack.util.p.b(d, ijiami_1011.s.s.s.d(new byte[]{Ascii.CAN, 73, 8, 19, 116, 80, Ascii.NAK, 5, 70, 4, 80, 12, 84, 86, 5, 66, 16}, "83ac01") + e.toString());
                    }
                } catch (Exception e3) {
                    e = e3;
                    gZIPOutputStream = null;
                } catch (Throwable th) {
                    th = th;
                    com.xiaomi.onetrack.util.m.a((OutputStream) byteArrayOutputStream);
                    com.xiaomi.onetrack.util.m.a((OutputStream) gZIPOutputStream2);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                gZIPOutputStream2 = gZIPOutputStream;
            }
        } catch (Exception e4) {
            e = e4;
            byteArrayOutputStream = null;
            gZIPOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
        }
        com.xiaomi.onetrack.util.m.a((OutputStream) byteArrayOutputStream);
        com.xiaomi.onetrack.util.m.a((OutputStream) gZIPOutputStream);
        return byteArray;
    }

    private byte[] a(byte[] bArr) {
        if (bArr != null) {
            return com.xiaomi.onetrack.d.a.a(bArr, com.xiaomi.onetrack.d.c.a(com.xiaomi.onetrack.d.f.a().b()[0]));
        }
        com.xiaomi.onetrack.util.p.b(d, ijiami_1011.s.s.s.d(new byte[]{90, 91, 10, Ascii.ETB, 87, 10, Ascii.NAK, 68, 15, 17, 17, 11, 76, 88, 8}, "94dc2d"));
        return null;
    }

    private void b() {
        HandlerThread handlerThread = new HandlerThread(ijiami_1011.s.s.s.d(new byte[]{93, 95, 0, Ascii.SYN, 69, 83, 2, 15, 57, Ascii.ETB, 65, 9, 93, 80, 1, 7, 69, 109, Ascii.SYN, 11, Ascii.DC4, 9, 84, Ascii.ETB}, "21eb72"));
        handlerThread.start();
        this.g = new p(handlerThread.getLooper());
    }

    private boolean b(String str) {
        boolean z = false;
        try {
            JSONObject jSONObject = new JSONObject(str);
            int iOptInt = jSONObject.optInt(e);
            if (iOptInt == 0) {
                com.xiaomi.onetrack.util.p.a(d, ijiami_1011.s.s.s.d(new byte[]{-45, -67, -14, -124, -21, -89, -124, -21, -9, -117, -79, -28, -45, -96, -46, -121, -20, -106, -124, -20, -42, -124, -83, -24, -48, -65, -61, -122, -54, -105}, "55baa8"));
                com.xiaomi.onetrack.b.a.a().a(jSONObject);
                z = true;
            } else if (iOptInt == -3) {
                com.xiaomi.onetrack.util.p.b(d, ijiami_1011.s.s.s.d(new byte[]{SignedBytes.MAX_POWER_OF_TWO, 81, 86, 90, 88, Ascii.NAK, Ascii.DC4, Ascii.SYN, 3, 66, 84, Ascii.GS, 67, 81, 67, 81, 93, 77, 65, 19, 15, 14, 93, 69, 70, 72, 85, 85, 77, 4}, "38149a"));
                com.xiaomi.onetrack.d.f.a().c();
            } else {
                com.xiaomi.onetrack.util.p.b(d, ijiami_1011.s.s.s.d(new byte[]{118, Ascii.SYN, 19, 93, 71, 14, 65, Ascii.ETB, Ascii.DC2, 3, 69, 16, SignedBytes.MAX_POWER_OF_TWO, 68, 2, 93, 81, 81, 92}, "3da254") + iOptInt);
            }
        } catch (Exception e2) {
            com.xiaomi.onetrack.util.p.b(d, ijiami_1011.s.s.s.d(new byte[]{17, 87, 70, 68, 0, 100, 17, 8, 9, 3, 85, 12, 15, 81, 102, 82, Ascii.SYN, 68, 13, 16, 70, 7, 73, 6, 4, 70, SignedBytes.MAX_POWER_OF_TWO, 94, 10, 95, 65}, "a647e1"), e2);
        }
        return z;
    }

    public synchronized void a(int i, boolean z) {
        p pVar = this.g;
        if (pVar != null) {
            pVar.a(i, z);
        } else {
            com.xiaomi.onetrack.util.p.b(d, ijiami_1011.s.s.s.d(new byte[]{Ascii.RS, Ascii.US, 72, 69, 90, 90, 17, 11, Ascii.NAK, 17, 88, 7, 88, 80, 78, 69, 70, 71, 13, 11, 7, 6, 17, 17, 93, 88, 7, Ascii.ETB, 19, 68, 9, 11, 19, 14, 85, 69, 90, 90, Ascii.SYN, 69, 81, 82, 65, 10, 19, 14, 93}, "45be37"));
        }
    }

    public void a(boolean z) {
        p pVar = this.g;
        if (pVar != null) {
            pVar.a(z);
        } else {
            com.xiaomi.onetrack.util.p.b(d, ijiami_1011.s.s.s.d(new byte[]{Ascii.FS, Ascii.US, 72, Ascii.ETB, 95, 11, 17, 11, Ascii.NAK, 17, 88, 7, 90, 80, 78, Ascii.ETB, 67, Ascii.SYN, 13, 11, 7, 6, 17, 17, 95, 88, 7, 69, Ascii.SYN, Ascii.NAK, 9, 11, 19, 14, 85, 69, 88, 90, Ascii.SYN, Ascii.ETB, 84, 3, 65, 10, 19, 14, 93}, "65b76f"));
        }
    }

    public boolean a(int i) throws Throwable {
        h hVarA;
        String str;
        com.xiaomi.onetrack.util.p.a(d, ijiami_1011.s.s.s.d(new byte[]{-122, -67, -127, -124, -120, -74, -119, -53, -35, -121, -66, -13, -123, -91, -126, -121, -75, -98, -124, -34, -11, -121, -120, -45, -121, -120, -72, -123, -124, -112, -121, -15, -42, -124, -68, -53}, "c02a80"));
        do {
            hVarA = c.a().a(i);
            if (hVarA == null) {
                com.xiaomi.onetrack.util.p.a(d, ijiami_1011.s.s.s.d(new byte[]{-128, -126, -108, -38, -114, -127, -121, -7, -57, -122, -118, -45, -127, -93, -79, -38, -106, -126, -124, -39, -13, -122, -119, -33, -127, -112, -113, -35, -124, -66, -124, -23, -43, -121, -127, -29, -114, -122, -95, -41, -93, -84, 77, 68, Ascii.SYN, 16, 88, 10, Ascii.DC4, 80, 65, 75, 5}, "f95282") + i);
                return true;
            }
            ArrayList<Long> arrayList = hVarA.c;
            boolean zA = a(hVarA.f9469a);
            String str2 = ijiami_1011.s.s.s.d(new byte[]{SignedBytes.MAX_POWER_OF_TWO, 17, 84, 87, 4, 2, 65, Ascii.ETB, 19, 1, 82, 0, 70, Ascii.DC2, 2}, "5a88ef") + zA;
            str = d;
            com.xiaomi.onetrack.util.p.a(str, str2);
            if (!zA) {
                return false;
            }
            if (c.a().a(arrayList) == 0) {
                com.xiaomi.onetrack.util.p.b(str, ijiami_1011.s.s.s.d(new byte[]{81, 93, 13, 85, Ascii.NAK, 92, 65, 32, 36, 66, 87, 4, 92, 84, 4, 84, SignedBytes.MAX_POWER_OF_TWO}, "58a0a9"), new Throwable());
            }
            return true;
        } while (!hVarA.d);
        com.xiaomi.onetrack.util.p.a(str, ijiami_1011.s.s.s.d(new byte[]{127, 92, Ascii.CAN, 9, 92, 75, 4, 68, Ascii.DC4, 7, 82, 10, 67, 87, 75, 68, 85, 86, 19, 68, Ascii.SYN, 16, 88, 10, 12}, "138d39") + i);
        return true;
    }
}
