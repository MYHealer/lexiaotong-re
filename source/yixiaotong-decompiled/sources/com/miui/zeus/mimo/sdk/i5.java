package com.miui.zeus.mimo.sdk;

import android.text.TextUtils;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class i5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DiagnosisStep f5460a;
    public Throwable b;
    public String c;
    public a d;
    public int e = 0;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f5461a;
        public String b;
        public String c;

        public a(int i, String str, String str2) {
            this.f5461a = i;
            this.b = str;
            this.c = str2;
        }
    }

    public i5(DiagnosisStep diagnosisStep, String str) {
        this.f5460a = diagnosisStep;
        this.c = str;
    }

    public i5(DiagnosisStep diagnosisStep, String str, a aVar) {
        this.f5460a = diagnosisStep;
        this.c = str;
        this.d = aVar;
    }

    public i5(DiagnosisStep diagnosisStep, String str, Throwable th) {
        this.f5460a = diagnosisStep;
        this.c = str;
        this.b = th;
    }

    public int a() {
        a aVar = this.d;
        if (aVar != null) {
            return aVar.f5461a;
        }
        return 0;
    }

    public final String a(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            sb.append(str2);
        }
        return sb.toString();
    }

    public String b() {
        a aVar = this.d;
        return aVar != null ? aVar.b : "";
    }

    public String c() {
        Throwable th = this.b;
        return th != null ? th.getMessage() : "";
    }

    public String d() {
        a aVar;
        int i = this.e;
        if (i == 0) {
            return a(this.c, "");
        }
        if (i == 1) {
            String str = this.c;
            Throwable th = this.b;
            return a(str, th != null ? th.getMessage() : "");
        }
        StringBuilder sb = new StringBuilder();
        if (this.e == 2 && (aVar = this.d) != null) {
            if (TextUtils.equals(aVar.c, ijiami_1011.s.s.s.d(new byte[]{94, 68, 66, 71, 58, 85, 19, Ascii.SYN, 9, 16}, "6067e0"))) {
                sb.append(ijiami_1011.s.s.s.d(new byte[]{93, Ascii.GS, Ascii.NAK, 7, 19, 93, 0, 8, 46, Ascii.SYN, 69, Ascii.NAK, 125, Ascii.ETB, 19, 13, 19, 112, 14, 0, 3, 66, 12, 69}, "8eaba3"));
            } else {
                sb.append(TextUtils.equals(this.d.c, ijiami_1011.s.s.s.d(new byte[]{71, 7, 70, 71, 91, 11, Ascii.DC2, 1, 57, 7, 67, Ascii.ETB, 90, 16}, "5b574e")) ? ijiami_1011.s.s.s.d(new byte[]{92, 72, Ascii.ETB, 1, SignedBytes.MAX_POWER_OF_TWO, 94, 0, 8, 52, 7, 66, Ascii.NAK, 86, 94, 16, 1, 119, 66, 19, 11, Ascii.DC4, 33, 94, 1, 92, 16, 94, 68}, "90cd20") : ijiami_1011.s.s.s.d(new byte[]{87, 26, SignedBytes.MAX_POWER_OF_TWO, 81, Ascii.DC4, 93, 0, 8, 35, 16, 67, 10, SignedBytes.MAX_POWER_OF_TWO, 33, 91, 80, 3, 19, 92, 68}, "2b44f3"));
            }
            sb.append(this.d.f5461a);
            String str2 = this.d.b;
            if (!TextUtils.isEmpty(str2)) {
                sb.append(ijiami_1011.s.s.s.d(new byte[]{Ascii.GS, 17}, "113fa6"));
                if (TextUtils.equals(this.d.c, ijiami_1011.s.s.s.d(new byte[]{10, 16, SignedBytes.MAX_POWER_OF_TWO, 68, 109, 83, 19, Ascii.SYN, 9, 16}, "bd4426"))) {
                    sb.append(ijiami_1011.s.s.s.d(new byte[]{82, Ascii.EM, 69, 3, Ascii.ETB, 92, 0, 8, 46, Ascii.SYN, 69, Ascii.NAK, 114, 19, 67, 9, Ascii.ETB, 127, 4, Ascii.ETB, Ascii.NAK, 3, 86, 0, Ascii.ETB, 92, 17}, "7a1fe2"));
                } else {
                    sb.append(TextUtils.equals(this.d.c, ijiami_1011.s.s.s.d(new byte[]{16, 92, 17, Ascii.DC4, 86, 88, Ascii.DC2, 1, 57, 7, 67, Ascii.ETB, 13, 75}, "b9bd96")) ? ijiami_1011.s.s.s.d(new byte[]{3, Ascii.EM, 65, 1, 69, 95, 0, 8, 52, 7, 66, Ascii.NAK, 9, 15, 70, 1, 114, 67, 19, 11, Ascii.DC4, 47, 84, Ascii.SYN, Ascii.NAK, 0, 82, 1, Ascii.ETB, 12, 65}, "fa5d71") : ijiami_1011.s.s.s.d(new byte[]{82, 77, 66, 0, 17, 94, 0, 8, 35, 16, 67, 10, 69, 120, 83, Ascii.SYN, 16, 81, 6, 1, 70, 95, 17}, "756ec0"));
                }
                sb.append(str2);
            }
        }
        StringBuilder sb2 = new StringBuilder();
        String string = sb.toString();
        if (!TextUtils.isEmpty(string)) {
            sb2.append(ijiami_1011.s.s.s.d(new byte[]{67}, "897a6d"));
            sb2.append(string);
            sb2.append(ijiami_1011.s.s.s.d(new byte[]{77}, "0d7dd9"));
        }
        return a(this.c, sb2.toString());
    }
}
