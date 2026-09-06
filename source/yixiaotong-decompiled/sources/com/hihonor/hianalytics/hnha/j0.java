package com.hihonor.hianalytics.hnha;

import android.content.ContentValues;
import android.text.TextUtils;
import java.util.Objects;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public final class j0 extends i0 {
    private long b;
    public final h0 c;
    private final p0 d;
    private String e;
    private JSONObject f;
    private JSONObject g;
    private String h;
    private int i;
    private String j;
    private String k;
    private String l;
    private int m;

    public j0(long j, String str, String str2, long j2, int i, String str3, p0 p0Var, String str4, String str5, String str6) {
        super(j);
        h0 h0Var = new h0();
        this.c = h0Var;
        this.i = 0;
        this.m = 0;
        h0Var.a(str);
        h0Var.b(str2);
        this.b = j2;
        this.i = i;
        this.h = str3;
        this.d = p0Var;
        this.j = str4;
        this.k = str5;
        this.l = str6;
    }

    public j0(long j, String str, String str2, long j2, String str3, p0 p0Var, String str4, String str5, String str6) {
        this(j, str, str2, j2, 0, str3, p0Var, str4, str5, str6);
    }

    public j0(p0 p0Var) {
        this(p0Var, null, null);
    }

    public j0(p0 p0Var, JSONObject jSONObject, JSONObject jSONObject2) {
        super(0L);
        h0 h0Var = new h0();
        this.c = h0Var;
        this.i = 0;
        this.m = 0;
        this.d = p0Var;
        this.f = jSONObject;
        this.g = jSONObject2;
        h0Var.a(g.a(p0Var.b));
        int i = p0Var.c;
        h0Var.b(com.hihonor.hianalytics.util.g.a(i, h.b(p0Var.b, i)));
        this.b = System.currentTimeMillis();
    }

    public ContentValues a(ContentValues contentValues) {
        contentValues.clear();
        contentValues.put("_iiTtId", Long.valueOf(this.d.a()));
        contentValues.put("_cTime", Long.valueOf(this.b));
        contentValues.put("_appId", this.c.a());
        contentValues.put("_url", this.c.b());
        contentValues.put("_priority", Integer.valueOf(this.i));
        contentValues.put("_idsInfoHash", Integer.valueOf(h()));
        contentValues.put("_idsInfo", d());
        contentValues.put("_crMd", this.j);
        contentValues.put("_kMd", this.k);
        contentValues.put("_ksMd", this.l);
        return contentValues;
    }

    public j0 a(String str) {
        this.c.a(str);
        return this;
    }

    public void a(String str, int i) {
        this.e = str;
        this.m = i;
    }

    public boolean a(j0 j0Var) {
        return j0Var != null && Objects.equals(this.d, j0Var.o()) && Objects.equals(this.c, j0Var.c) && com.hihonor.hianalytics.util.l.a(this.f, j0Var.f, true) && com.hihonor.hianalytics.util.l.a(this.g, j0Var.g, true);
    }

    public void b(String str) {
        this.h = str;
    }

    public String c() {
        return this.c.a();
    }

    public void c(String str) {
        this.j = str;
    }

    public String d() {
        if (TextUtils.isEmpty(this.e) || !TextUtils.isEmpty(this.h)) {
            return this.h;
        }
        synchronized (this) {
            if (TextUtils.isEmpty(this.h)) {
                k.c().b(this);
                return this.h;
            }
            return this.h;
        }
    }

    public void d(String str) {
        this.k = str;
    }

    public String e() {
        return this.j;
    }

    public void e(String str) {
        this.l = str;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof j0)) {
            return false;
        }
        j0 j0Var = (j0) obj;
        long j = this.f3645a;
        if (j > 0) {
            long j2 = j0Var.f3645a;
            if (j2 > 0) {
                return j == j2;
            }
        }
        return Objects.equals(this.c, j0Var.c) && Objects.equals(this.e, j0Var.e);
    }

    public JSONObject f() {
        return this.g;
    }

    public String g() {
        if (TextUtils.isEmpty(this.h) || !TextUtils.isEmpty(this.e)) {
            return this.e;
        }
        synchronized (this) {
            if (TextUtils.isEmpty(this.e)) {
                k.c().a(this);
                return this.e;
            }
            return this.e;
        }
    }

    public int h() {
        String str = this.e;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public int hashCode() {
        int iHashCode = (this.c.hashCode() + 527) * 31;
        String str = this.e;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public int i() {
        String str = this.e;
        if (str == null) {
            return 0;
        }
        return str.length();
    }

    public int j() {
        return this.m;
    }

    public JSONObject k() {
        return this.f;
    }

    public String l() {
        return this.k;
    }

    public String m() {
        return this.l;
    }

    public String n() {
        return "EventIdAttrs#" + hashCode() + "{id='" + this.f3645a + ",priority=" + this.i + ",len=" + i() + ",appId=" + this.c.a() + ",urlEmpty=" + TextUtils.isEmpty(this.c.b()) + '}';
    }

    public p0 o() {
        return this.d;
    }

    public String p() {
        return this.c.b();
    }

    public boolean q() {
        return this.f3645a > 0;
    }

    public boolean r() {
        return (TextUtils.isEmpty(this.c.a()) || TextUtils.isEmpty(this.c.b()) || TextUtils.isEmpty(this.e)) ? false : true;
    }

    public j0 s() {
        if (!TextUtils.isEmpty(this.e)) {
            return this;
        }
        synchronized (this) {
            if (!TextUtils.isEmpty(this.e)) {
                return this;
            }
            p0 p0Var = this.d;
            this.i = h.d(p0Var.b, p0Var.c);
            p0 p0Var2 = this.d;
            this.e = h.a(p0Var2.b, p0Var2.c, this.c.a(), this.f, this.g);
            return this;
        }
    }

    public String toString() {
        return "EventIdAttrs#" + hashCode() + "{id='" + this.f3645a + ",priority=" + this.i + ",idUrl=" + this.c + ",len=" + i() + ",tagTypeInfo=" + this.d + '}';
    }
}
