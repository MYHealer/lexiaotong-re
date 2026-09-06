package com.miui.zeus.mimo.sdk;

import android.text.TextUtils;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep;
import com.miui.zeus.mimo.sdk.server.http.HttpRequest;
import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class c5 extends a5 {
    public static final int d = e9.f5418a * 3;
    public final ExecutorService c = Executors.newFixedThreadPool(5);

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f5386a;
        public String b;
        public long c = System.currentTimeMillis();
        public e5 d;

        public a(String str, String str2, e5 e5Var) {
            this.f5386a = str;
            this.b = str2;
            this.d = e5Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            n5 n5Var = new n5();
            l5<HttpRequest> l5VarA = HttpRequest.a(this.f5386a, this.d.f5415a, true);
            if (!l5VarA.b()) {
                c5.this.a(this.f5386a, this.d, this.c, l5VarA.c);
                return;
            }
            l5<j5> l5VarA2 = n5Var.a(l5VarA.f5520a, c5.d);
            if (!l5VarA2.b()) {
                c5.this.a(this.f5386a, this.d, this.c, l5VarA2.c);
                return;
            }
            try {
                InputStream inputStream = l5VarA2.f5520a.c;
                Files.copy(inputStream, Paths.get(this.b, new String[0]), StandardCopyOption.REPLACE_EXISTING);
                b.a((Closeable) null);
                b.a(inputStream);
                String str = this.b;
                if (TextUtils.isEmpty(str) || !new File(str).exists()) {
                    c5.this.a(this.f5386a, this.d, this.c, new i5(DiagnosisStep.KEY_EXCEPTION_WHEN_DOWNLOAD_TO_FILE, (String) null, new Throwable(ijiami_1011.s.s.s.d(new byte[]{85, 94, 90, 0, 13, 78, 78}, "376e7a") + this.b + ijiami_1011.s.s.s.d(new byte[]{67, 8, SignedBytes.MAX_POWER_OF_TWO, Ascii.CAN, 95, 11, Ascii.NAK, 68, 3, 26, 88, Ascii.SYN, Ascii.ETB}, "ca381d"))));
                } else {
                    c5.this.a(this.f5386a, this.d, this.c);
                }
            } catch (Exception e) {
                c5.this.a(this.f5386a, this.d, this.c, new i5(DiagnosisStep.KEY_EXCEPTION_WHEN_DOWNLOAD_TO_FILE, ijiami_1011.s.s.s.d(new byte[]{Ascii.DC4, 67, 13, 66, 82, 68, Ascii.NAK, 11, 70, 4, 88, 9, 6, 17, 1, 78, 84, 1, 17, 16, 15, 13, 95, 69, 89, 17}, "c1d67d"), e));
            }
        }
    }
}
