package com.hihonor.hianalytics.hnha;

import android.content.ContentValues;
import android.text.TextUtils;
import com.hihonor.hianalytics.util.SystemUtils;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class o0 extends i0 {
    private long b;
    public final String c;

    public o0() {
        this(0L, System.currentTimeMillis(), SystemUtils.getProcessName());
    }

    public o0(long j, long j2, String str) {
        super(j);
        this.b = j2;
        this.c = str;
    }

    public ContentValues a(ContentValues contentValues) {
        contentValues.clear();
        contentValues.put("_pName", this.c);
        contentValues.put("_cTime", Long.valueOf(this.b));
        return contentValues;
    }

    public boolean c() {
        return Objects.equals(this.c, SystemUtils.getProcessName());
    }

    public boolean d() {
        return TextUtils.isEmpty(this.c);
    }

    public boolean e() {
        return this.f3645a > 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof o0)) {
            return false;
        }
        o0 o0Var = (o0) obj;
        long j = this.f3645a;
        if (j > 0) {
            long j2 = o0Var.f3645a;
            if (j2 > 0) {
                return j == j2;
            }
        }
        return Objects.equals(this.c, o0Var.c);
    }

    public int hashCode() {
        return this.c.hashCode() + 527;
    }

    public String toString() {
        return "ProcessInfo#" + hashCode() + "{id=" + this.f3645a + ",processName=" + com.hihonor.hianalytics.util.b.b(this.c) + ",createTime=" + com.hihonor.hianalytics.util.r.a(this.b) + '}';
    }
}
