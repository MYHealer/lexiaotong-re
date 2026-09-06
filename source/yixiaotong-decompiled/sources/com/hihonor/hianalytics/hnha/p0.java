package com.hihonor.hianalytics.hnha;

import android.content.ContentValues;
import android.text.TextUtils;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class p0 extends i0 {
    public final String b;
    public final int c;
    private long d;
    public o0 e;

    public p0(long j, long j2, String str, int i, o0 o0Var) {
        super(j);
        this.d = j2;
        this.b = str;
        this.c = i;
        this.e = o0Var;
    }

    public p0(String str, int i) {
        this(0L, System.currentTimeMillis(), str, i, j.b());
    }

    public ContentValues a(ContentValues contentValues) {
        contentValues.clear();
        contentValues.put("_ttpId", Long.valueOf(this.e.a()));
        contentValues.put("_cTime", Long.valueOf(this.d));
        contentValues.put("_tag", this.b);
        contentValues.put("_type", Integer.valueOf(this.c));
        return contentValues;
    }

    public void a(o0 o0Var) {
        this.e = o0Var;
    }

    public boolean a(p0 p0Var) {
        return p0Var != null && this.c == p0Var.c && Objects.equals(this.b, p0Var.b);
    }

    public String c() {
        return this.b + "_" + this.c + "_" + this.f3645a + "_" + com.hihonor.hianalytics.util.b.b(this.e.c) + "_" + this.e.a();
    }

    public boolean d() {
        return this.f3645a > 0 && this.e.e();
    }

    public boolean e() {
        return TextUtils.isEmpty(this.b);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof p0)) {
            return false;
        }
        p0 p0Var = (p0) obj;
        long j = this.f3645a;
        if (j > 0) {
            long j2 = p0Var.f3645a;
            if (j2 > 0) {
                return j == j2;
            }
        }
        return this.c == p0Var.c && Objects.equals(this.b, p0Var.b) && Objects.equals(this.e, p0Var.e);
    }

    public boolean f() {
        return this.f3645a > 0;
    }

    public int hashCode() {
        return ((((this.c + 527) * 31) + this.b.hashCode()) * 31) + this.e.hashCode();
    }

    public String toString() {
        return "TagTypeInfo#" + hashCode() + "{id=" + this.f3645a + ",type=" + this.c + ",tag=" + this.b + ",createTime=" + com.hihonor.hianalytics.util.r.a(this.d) + ",processInfo=" + this.e + '}';
    }
}
