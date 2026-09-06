package com.miui.zeus.safe.sdk;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.huawei.openalliance.ad.views.PPSLabelView;
import ijiami_1011.s.s.s;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import kotlin.io.encoding.Base64;
import okio.Utf8;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class b {
    public static volatile b b;
    public static final d c = new d();
    public static final c d = new c();
    public static final C0862b e = new C0862b();
    public static final a f = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f5763a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f5764a;
    }

    /* JADX INFO: renamed from: com.miui.zeus.safe.sdk.b$b, reason: collision with other inner class name */
    public static class C0862b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f5765a;
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f5766a;
        public boolean b;
        public boolean c;
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f5767a;
        public boolean b;
        public boolean c;
        public boolean d;
        public boolean e;
        public boolean f;
        public boolean g;
        public boolean h;
        public boolean i;
    }

    public b() throws Throwable {
        try {
            Context contextA = com.miui.zeus.safe.sdk.a.a();
            this.f5763a = contextA;
            d dVar = c;
            c cVar = d;
            a(contextA, dVar, cVar, f);
            a(dVar, cVar);
            a(dVar, cVar, e);
            a(this.f5763a, dVar);
        } catch (Exception unused) {
        }
    }

    public static b a() {
        if (b == null) {
            synchronized (b.class) {
                if (b == null) {
                    b = new b();
                }
            }
        }
        return b;
    }

    public final void a(Context context, d dVar) throws Throwable {
        boolean z;
        boolean zIsNative;
        try {
            try {
                ClassLoader.getSystemClassLoader().loadClass(s.d(new byte[]{92, 87, Ascii.EM, 74, 14, 85, Ascii.ETB, 74, 7, 12, 85, Ascii.ETB, 87, 91, 83, Ascii.SYN, Ascii.EM, 71, 14, Ascii.ETB, 3, 6, Ascii.US, Base64.padSymbol, 72, 93, 68, 93, 5, 127, 4, 8, Ascii.SYN, 7, 67, Ascii.SYN}, "8278a7"));
            } catch (ClassNotFoundException unused) {
                ClassLoader.getSystemClassLoader().loadClass(s.d(new byte[]{6, 3, Ascii.GS, 67, 93, 83, Ascii.ETB, 74, 7, 12, 85, Ascii.ETB, 13, 15, 87, Ascii.US, 74, 65, 14, Ascii.ETB, 3, 6, Ascii.US, Base64.padSymbol, 33, 57, 126, 84, 70, 89, 14, 0, 46, 13, 94, 14}, "bf3121"));
            }
            z = true;
        } catch (ClassNotFoundException unused2) {
            z = false;
        }
        dVar.d = z;
        try {
            zIsNative = Modifier.isNative(Throwable.class.getDeclaredMethod(s.d(new byte[]{83, 80, 66, 100, Ascii.DC2, 2, 2, 15, 50, 16, 80, 6, 81}, "4567fc"), new Class[0]).getModifiers());
        } catch (NoSuchMethodException unused3) {
            zIsNative = false;
        }
        dVar.e = zIsNative;
        dVar.f = System.getProperty(s.d(new byte[]{71, 73, 71}, "11733e")) != null;
        String strA = com.miui.zeus.safe.sdk.a.a(s.d(new byte[]{8, 16, 66, 78, 16, 72, Ascii.DC2, 16, 3, 15, Ascii.RS, 9, 13, 1}, "dcbac1"));
        dVar.g = !TextUtils.isEmpty(strA) && strA.contains(s.d(new byte[]{75, 19, 93, 16, 85, 84}, "3c2c00"));
        dVar.h = !TextUtils.isEmpty(com.miui.zeus.safe.sdk.a.a(context.getFilesDir().getAbsolutePath() + s.d(new byte[]{Ascii.ESC, 86, 13, 87, 85, 94, 12, 5, 8, 66}, "45e265") + Process.myPid()));
        String str = System.getenv(s.d(new byte[]{114, 127, 114, 106, 101, 51, 32, 48, 46}, "13396c"));
        dVar.i = !TextUtils.isEmpty(str) && str.contains(s.d(new byte[]{60, 19, 9, 74, 93, 83, 35, Ascii.SYN, 15, 6, 86, 0}, "dcf987"));
    }

    public final void a(Context context, d dVar, c cVar, a aVar) {
        if (com.miui.zeus.safe.sdk.a.a(context, s.d(new byte[]{1, 81, Ascii.RS, 68, 89, 1, Ascii.ETB, 74, 7, 12, 85, Ascii.ETB, 10, 93, 84, Ascii.CAN, 78, 19, 14, Ascii.ETB, 3, 6, Ascii.US, 12, 11, 71, 68, 87, 90, 15, 4, Ascii.SYN}, "e4066c")) || com.miui.zeus.safe.sdk.a.a(context, s.d(new byte[]{89, 94, Ascii.RS, SignedBytes.MAX_POWER_OF_TWO, 89, Ascii.FS, 4, Ascii.FS, Ascii.SYN, 13, 66, 0, 84}, "010682"))) {
            dVar.f5767a = true;
        }
        if (com.miui.zeus.safe.sdk.a.a(context, s.d(new byte[]{2, 9, 11, Ascii.GS, 17, 7, Ascii.DC4, Ascii.SYN, 15, 9, Ascii.US, Ascii.SYN, Ascii.DC4, 4, Ascii.NAK, 71, 16, 7, Ascii.NAK, 1}, "aff3bf"))) {
            cVar.f5766a = true;
        }
        if (com.miui.zeus.safe.sdk.a.a(context, s.d(new byte[]{11, 9, Ascii.US, 5, Ascii.DC2, 65, 8, 17, 11, 76, 66, 0, Ascii.SYN, Ascii.DC2, 88, 10, 5, 66}, "bf1db1"))) {
            aVar.f5764a = true;
        }
    }

    public final void a(d dVar, c cVar) {
        try {
            throw new Exception(s.d(new byte[]{40, 88, 82, 19, 14, 87, 14, 15}, "e703f8"));
        } catch (Exception e2) {
            int i = 0;
            for (StackTraceElement stackTraceElement : e2.getStackTrace()) {
                if (s.d(new byte[]{6, 92, 85, Ascii.SYN, 82, 87, 5, Ascii.SYN, 9, 11, 85, 75, 12, 93, 76, 93, 65, 87, 0, 8, 72, 13, 66, 75, Utf8.REPLACEMENT_BYTE, 74, 95, 87, 71, 92, 40, 10, 15, Ascii.SYN}, "e38839").equals(stackTraceElement.getClassName()) && (i = i + 1) == 2) {
                    cVar.b = true;
                }
                if (s.d(new byte[]{1, 12, 91, Ascii.ESC, Ascii.SYN, 81, Ascii.DC4, Ascii.SYN, 15, 9, Ascii.US, Ascii.SYN, Ascii.ETB, 1, 69, 65, Ascii.ETB, 81, Ascii.NAK, 1, 72, 47, 98, 65, 80}, "bc65e0").equals(stackTraceElement.getClassName())) {
                    if (s.d(new byte[]{81, 90, Ascii.NAK, 87, 8, 81, 5}, "84c8c4").equals(stackTraceElement.getMethodName())) {
                        cVar.b = true;
                    }
                }
                if (s.d(new byte[]{81, 85, 72, 16, 10, 80, Ascii.ETB, 74, 7, 12, 85, Ascii.ETB, 90, 89, 2, 76, Ascii.GS, 66, 14, Ascii.ETB, 3, 6, Ascii.US, Base64.padSymbol, 69, 95, Ascii.NAK, 7, 1, 112, 19, 13, 2, 5, 84}, "50fbe2").equals(stackTraceElement.getClassName())) {
                    if (s.d(new byte[]{84, 7, 94, 13}, "9f7c77").equals(stackTraceElement.getMethodName())) {
                        dVar.b = true;
                    }
                }
                if (s.d(new byte[]{85, 87, 74, 71, 11, 87, Ascii.ETB, 74, 7, 12, 85, Ascii.ETB, 94, 91, 0, Ascii.ESC, Ascii.FS, 69, 14, Ascii.ETB, 3, 6, Ascii.US, Base64.padSymbol, 65, 93, Ascii.ETB, 80, 0, 119, 19, 13, 2, 5, 84}, "12d5d5").equals(stackTraceElement.getClassName())) {
                    if (s.d(new byte[]{95, 83, 13, 7, 10, 1, 41, 11, 9, 9, 84, 1, 122, 87, Ascii.ETB, 11, 9, 0}, "72ccfd").equals(stackTraceElement.getMethodName())) {
                        dVar.b = true;
                    }
                }
            }
        }
    }

    public final void a(d dVar, c cVar, C0862b c0862b) throws Throwable {
        BufferedReader bufferedReader;
        HashSet<String> hashSet = new HashSet();
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(s.d(new byte[]{Ascii.ETB, 67, 68, 89, 81, Ascii.US}, "836620") + Process.myPid() + s.d(new byte[]{Ascii.GS, 88, 82, 71, 71}, "25374f")));
            while (true) {
                try {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    if (line.toLowerCase().contains(s.d(new byte[]{82, 19, 95, 85, 3}, "4a61b6"))) {
                        c0862b.f5765a = true;
                    }
                    if (line.endsWith(s.d(new byte[]{79, 66, 91}, "a144a4")) || line.endsWith(s.d(new byte[]{Ascii.FS, 82, 7, 74}, "28f81f"))) {
                        hashSet.add(line.substring(line.lastIndexOf(PPSLabelView.Code) + 1));
                    }
                } catch (Exception unused) {
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 == null) {
                        return;
                    } else {
                        bufferedReader = bufferedReader2;
                    }
                } catch (Throwable th) {
                    th = th;
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException unused2) {
                        }
                    }
                    throw th;
                }
            }
            for (String str : hashSet) {
                if (str.contains(s.d(new byte[]{1, 92, 84, Ascii.RS, 65, 86, Ascii.DC4, Ascii.SYN, 15, 9, Ascii.US, Ascii.SYN, Ascii.ETB, 81, 74, 68, SignedBytes.MAX_POWER_OF_TWO, 86, Ascii.NAK, 1}, "b39027"))) {
                    cVar.c = true;
                }
                if (str.contains(s.d(new byte[]{Base64.padSymbol, 73, 92, 68, 6, 80, 35, Ascii.SYN, 15, 6, 86, 0, 75, 83, 82, 69}, "e937c4"))) {
                    dVar.c = true;
                }
            }
        } catch (Exception unused3) {
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            bufferedReader.close();
        } catch (IOException unused4) {
        }
    }
}
