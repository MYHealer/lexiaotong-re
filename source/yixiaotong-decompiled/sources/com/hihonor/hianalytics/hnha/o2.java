package com.hihonor.hianalytics.hnha;

import android.os.Process;
import android.text.TextUtils;
import com.hihonor.hianalytics.util.SystemUtils;
import com.huawei.openalliance.ad.views.PPSLabelView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public class o2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f3666a;
    private int b;
    private String d;
    private int e;
    private int f;
    private int g;
    private String i;
    private long c = 0;
    private final StringBuilder h = new StringBuilder();

    o2(int i, String str, int i2, String str2) {
        this.f3666a = null;
        this.b = 0;
        this.g = 0;
        this.g = i;
        this.b = i2;
        this.f3666a = (str2 == null || str2.equals("HianalyticsSDK")) ? "HianalyticsSDK-1.0.5.300" : "HianalyticsSDK-1.0.5.300-" + str2;
        b();
    }

    private StringBuilder a(StringBuilder sb) {
        sb.append(' ').append((CharSequence) this.h);
        return sb;
    }

    private o2 b() {
        System.currentTimeMillis();
        Thread threadCurrentThread = Thread.currentThread();
        this.c = threadCurrentThread.getId();
        this.e = Process.myPid();
        StackTraceElement[] stackTrace = threadCurrentThread.getStackTrace();
        int length = stackTrace.length;
        int i = this.g;
        if (length > i) {
            StackTraceElement stackTraceElement = stackTrace[i];
            this.d = stackTraceElement.getFileName();
            this.f = stackTraceElement.getLineNumber();
        }
        return this;
    }

    private StringBuilder b(StringBuilder sb) {
        sb.append('[');
        sb.append("HaSdk-").append(c()).append(com.huawei.openalliance.ad.constant.x.bQ).append(this.e).append(':').append(this.c);
        if (!TextUtils.isEmpty(this.d) && this.f >= 0) {
            sb.append(' ').append(this.d).append(':').append(this.f);
        }
        sb.append(PPSLabelView.Code).append(m2.a(this.b));
        sb.append(']');
        return sb;
    }

    public <T> o2 a(T t) {
        this.h.append(t);
        return this;
    }

    public String a() {
        StringBuilder sb = new StringBuilder();
        a(sb);
        return sb.toString();
    }

    public String c() {
        if (TextUtils.isEmpty(this.i)) {
            this.i = SystemUtils.d();
        }
        return this.i;
    }

    public String d() {
        StringBuilder sb = new StringBuilder();
        b(sb);
        return sb.toString();
    }

    public String e() {
        return this.f3666a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(4096);
        b(sb);
        a(sb);
        return sb.toString();
    }
}
