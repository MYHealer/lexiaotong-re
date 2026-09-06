package com.miui.zeus.mimo.sdk;

import com.google.common.base.Ascii;
import com.miui.zeus.jni.NativeUtils;
import com.miui.zeus.mimo.sdk.utils.MimoSdkInitHolder;
import java.io.PrintWriter;
import java.io.StringWriter;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class j4 implements Thread.UncaughtExceptionHandler {
    public static volatile j4 b = new j4();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Thread.UncaughtExceptionHandler f5498a = Thread.getDefaultUncaughtExceptionHandler();

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.close();
        String string = stringWriter.toString();
        if (b.h(string) && (string.contains(MimoSdk.class.getPackage().getName()) || string.contains(NativeUtils.class.getPackage().getName()) || string.contains(ijiami_1011.s.s.s.d(new byte[]{1, 93, 9, 74, 91, 88, Ascii.DC4, 13, 72, Ascii.CAN, 84, 16, 17}, "b2dd61")))) {
            String versionName = MimoSdkInitHolder.getVersionName();
            if (y8.f5752a != null) {
                h6 h6VarA = h6.a();
                h6VarA.getClass();
                if (!b.g(string)) {
                    x8.i.execute(new f6(h6VarA, ijiami_1011.s.s.s.d(new byte[]{43, 90, 7, 97, 16, 0, 2, 15, 3, 16}, "d4b5ba"), ijiami_1011.s.s.s.d(new byte[]{41, 10, 4, 109, 19, 85, 2, 15, 50, 16, 80, 6, 13, 1, 19, Ascii.EM, 5, 93, 0, 3, 8, 13, 66, 12, Ascii.NAK, 39, 19, 88, Ascii.DC2, 92, 65, 1, Ascii.RS, 1, 84, Ascii.NAK, Ascii.DC2, 13, 14, 87, 91}, "fda9a4"), versionName, string));
                }
            }
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f5498a;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }
}
