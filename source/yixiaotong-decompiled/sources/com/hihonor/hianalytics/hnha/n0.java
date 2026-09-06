package com.hihonor.hianalytics.hnha;

import android.content.ContentValues;
import android.text.TextUtils;
import com.huawei.hms.ads.ez;
import java.util.Map;
import java.util.Objects;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public final class n0 extends i0 {
    private p0 b;
    private j0 c;
    private String d;
    private long e;
    private long f;
    private String g;
    private int h;
    private int i;
    private String j;
    private String k;
    private String l;
    private int m;
    private String n;
    private String o;
    private String p;
    private String q;
    private int r;

    public n0(long j, j0 j0Var, String str, int i, long j2, String str2, long j3, int i2, String str3, String str4, int i3, String str5, String str6, String str7, String str8) {
        super(j);
        this.m = 0;
        this.r = 0;
        this.b = j0Var.o();
        this.c = j0Var;
        this.d = str;
        this.h = i;
        this.e = j2;
        this.g = str2;
        this.f = j3;
        this.i = i2;
        this.k = str3;
        this.l = str4;
        this.m = i3;
        this.n = str5;
        this.o = str6;
        this.p = str7;
        this.q = str8;
    }

    public n0(long j, String str, int i, String str2, int i2, long j2, String str3, long j3, int i3, String str4, String str5, int i4, String str6) {
        this(j, new j0(new p0(str, i)), str2, i2, j2, str3, j3, i3, str4, str5, i4, str6, null, null, null);
    }

    public n0(j0 j0Var, String str, int i, long j, String str2, String str3) {
        super(0L);
        this.m = 0;
        this.r = 0;
        this.b = j0Var.o();
        this.c = j0Var;
        this.d = str;
        this.h = i;
        this.e = j;
        this.g = str2;
        this.i = 0;
        this.j = str3;
    }

    public n0(String str, int i, String str2, int i2, long j, String str3, String str4) {
        this(str, i, str2, i2, j, str3, str4, null, null);
    }

    public n0(String str, int i, String str2, int i2, long j, String str3, String str4, String str5, int i3, JSONObject jSONObject, JSONObject jSONObject2) {
        super(0L);
        this.m = 0;
        this.r = 0;
        p0 p0VarA = j.a(str, i);
        this.b = p0VarA;
        this.c = new j0(p0VarA, jSONObject, jSONObject2);
        this.d = str2;
        this.h = i2;
        this.e = j;
        this.g = str3;
        this.i = 0;
        this.j = str4;
        this.l = str5;
        this.m = i3;
    }

    public n0(String str, int i, String str2, int i2, long j, String str3, String str4, Map<String, String> map, Map<String, String> map2) {
        super(0L);
        this.m = 0;
        this.r = 0;
        p0 p0VarA = j.a(str, i);
        this.b = p0VarA;
        this.c = new j0(p0VarA, com.hihonor.hianalytics.util.l.a(map, true), com.hihonor.hianalytics.util.l.a(map2, true));
        this.d = str2;
        this.h = i2;
        this.e = j;
        this.g = str3;
        this.i = 0;
        this.j = str4;
        if (i == 0 && f.i(str, "oper")) {
            l1 l1VarC = k1.a().c(str, j);
            this.l = l1VarC.b();
            this.m = l1VarC.c() ? 1 : 2;
        }
    }

    public ContentValues a(ContentValues contentValues) {
        contentValues.clear();
        contentValues.put("_eTtId", Long.valueOf(this.b.a()));
        contentValues.put("_eIdsId", Long.valueOf(this.c.a()));
        contentValues.put("_cTime", Long.valueOf(this.e));
        contentValues.put("_cTimeZone", this.g);
        contentValues.put("_uTime", Long.valueOf(this.f));
        contentValues.put("_evtId", this.d);
        contentValues.put("_sourceType", Integer.valueOf(this.h));
        contentValues.put("_size", Long.valueOf(k()));
        contentValues.put("_cnt", e());
        contentValues.put("_state", Integer.valueOf(this.i));
        contentValues.put("_sPId", (Integer) 0);
        String strD = d();
        if (strD == null) {
            strD = "";
        }
        contentValues.put("_evtAppId", strD);
        contentValues.put("_sdkVersion", "1.0.5.300");
        contentValues.put("_sId", this.l);
        contentValues.put("_sState", Integer.valueOf(this.m));
        contentValues.put("_reqId", this.n);
        contentValues.put("_crMd", this.o);
        contentValues.put("_kMd", this.p);
        contentValues.put("_ksMd", this.q);
        return contentValues;
    }

    public n0 a(boolean z) {
        b(z);
        return this;
    }

    public void a(int i) {
        this.h = i;
    }

    public synchronized void a(j0 j0Var) {
        if (j0Var.r()) {
            this.c = j0Var;
        } else {
            j2.e("HaEvent", "updateEventIdAttrs illegal attrs=" + j0Var + ",nowAttrs=" + this.c);
        }
    }

    public void a(p0 p0Var) {
        this.b = p0Var;
    }

    public void a(String str) {
        this.k = str;
    }

    public void a(String str, int i) {
        this.j = str;
        this.r = i;
    }

    public String b(boolean z) {
        if (TextUtils.isEmpty(this.j) || !TextUtils.isEmpty(this.k)) {
            return this.k;
        }
        synchronized (this) {
            if (TextUtils.isEmpty(this.k)) {
                k.c().b(this, z);
                return this.k;
            }
            return this.k;
        }
    }

    public void b(String str) {
        this.o = str;
    }

    public boolean b(long j) {
        return com.hihonor.hianalytics.util.r.b() - this.e > j;
    }

    public n0 c() {
        return a(false);
    }

    public void c(String str) {
        this.p = str;
    }

    public String d() {
        return this.c.c();
    }

    public void d(String str) {
        this.q = str;
    }

    public String e() {
        return b(false);
    }

    public void e(String str) {
        this.n = str;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof n0)) {
            return false;
        }
        n0 n0Var = (n0) obj;
        long j = this.f3645a;
        if (j > 0) {
            long j2 = n0Var.f3645a;
            if (j2 > 0) {
                return j == j2;
            }
        }
        return this.e == n0Var.e && Objects.equals(this.b, n0Var.b) && Objects.equals(this.d, n0Var.d);
    }

    public String f() {
        return this.o;
    }

    public int g() {
        return this.r;
    }

    public String h() {
        if (TextUtils.isEmpty(this.k) || !TextUtils.isEmpty(this.j)) {
            return this.j;
        }
        synchronized (this) {
            if (TextUtils.isEmpty(this.j)) {
                k.c().a(this);
                return this.j;
            }
            return this.j;
        }
    }

    public int hashCode() {
        long j = this.e;
        int iHashCode = (((((int) (j ^ (j >>> 32))) + 527) * 31) + this.b.hashCode()) * 31;
        String str = this.d;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String i() {
        return this.d;
    }

    public j0 j() {
        return this.c;
    }

    public long k() {
        String str = this.k;
        long length = str == null ? 0L : str.length();
        String str2 = this.d;
        long length2 = length + (str2 == null ? 0L : str2.length());
        String str3 = this.l;
        return length2 + (str3 != null ? str3.length() : 0L) + 48;
    }

    public String l() {
        return this.b.b;
    }

    public long m() {
        return this.e;
    }

    public String n() {
        return this.g;
    }

    public int o() {
        return this.b.c;
    }

    public String p() {
        return this.p;
    }

    public String q() {
        return this.q;
    }

    public int r() {
        if (TextUtils.isEmpty(this.j) && TextUtils.isEmpty(this.k)) {
            return 4097;
        }
        if (TextUtils.isEmpty(this.c.c())) {
            return 4098;
        }
        if (TextUtils.isEmpty(this.c.p())) {
            return 4099;
        }
        return TextUtils.isEmpty(this.c.g()) ? 4100 : 0;
    }

    public String s() {
        return this.n;
    }

    public String t() {
        return this.l;
    }

    public String toString() {
        StringBuilder sbAppend = new StringBuilder("HaEvent#").append(hashCode()).append("{id=").append(this.f3645a).append(",eventID=").append(this.d).append(",eventState=").append(this.i).append(",eventLen=");
        String str = this.j;
        StringBuilder sbAppend2 = sbAppend.append(str == null ? 0 : str.length()).append(",cipherLen=");
        String str2 = this.k;
        return sbAppend2.append(str2 != null ? str2.length() : 0).append(",decryptStatType=").append(this.r).append(",sessionState=").append(this.m).append(",reqId=").append(this.n).append(",eventTime=").append(com.hihonor.hianalytics.util.r.a(this.e)).append(",attrs=").append(this.c.n()).append(",tagTypeInfo=").append(this.b).append('}').toString();
    }

    public int u() {
        return this.m;
    }

    public String v() {
        int i = this.m;
        if (i == 1) {
            return ez.Code;
        }
        if (i == 2) {
            return ez.V;
        }
        return null;
    }

    public int w() {
        return this.h;
    }

    public p0 x() {
        return this.b;
    }

    public boolean y() {
        return r() == 0;
    }

    public n0 z() {
        if (this.c.r()) {
            return this;
        }
        synchronized (this) {
            if (this.c.r()) {
                return this;
            }
            this.c = j.a(this.b, this.c.k(), this.c.f()).s();
            return this;
        }
    }
}
