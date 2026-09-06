package com.huawei.hms.ads;

import android.os.Process;
import android.util.Log;
import java.text.SimpleDateFormat;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class fo {
    private static final String Code = "HA";
    private String C;
    private String I;
    private int S;
    private String V;
    private int Z;
    private long B = 0;
    private final StringBuilder F = new StringBuilder();

    fo(String str, int i, String str2) {
        this.V = null;
        this.I = Code;
        this.Z = 0;
        this.V = str;
        this.Z = i;
        if (str2 != null) {
            this.I = str2;
        }
        I();
    }

    private StringBuilder Code(StringBuilder sb) {
        SimpleDateFormat simpleDateFormatCode = com.huawei.openalliance.ad.utils.z.Code("yyyy-MM-dd HH:mm:ss.SSS");
        sb.append('[');
        sb.append(simpleDateFormatCode.format(Long.valueOf(this.B)));
        sb.append(' ').append(fl.Code(this.Z)).append(IOUtils.DIR_SEPARATOR_UNIX).append(this.V).append(IOUtils.DIR_SEPARATOR_UNIX).append(this.I);
        sb.append(' ').append(this.S).append(':').append(this.C);
        sb.append(']');
        return sb;
    }

    private fo I() {
        this.B = System.currentTimeMillis();
        this.C = Thread.currentThread().getName();
        this.S = Process.myPid();
        return this;
    }

    private StringBuilder V(StringBuilder sb) {
        sb.append(' ').append((CharSequence) this.F);
        return sb;
    }

    public <T> fo Code(T t) {
        this.F.append(t);
        return this;
    }

    public fo Code(Throwable th) {
        if (th != null) {
            Code('\n').Code(Log.getStackTraceString(th));
        }
        return this;
    }

    public String Code() {
        StringBuilder sb = new StringBuilder();
        Code(sb);
        return sb.toString();
    }

    public String V() {
        StringBuilder sb = new StringBuilder();
        V(sb);
        return sb.toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Code(sb);
        V(sb);
        return sb.toString();
    }
}
