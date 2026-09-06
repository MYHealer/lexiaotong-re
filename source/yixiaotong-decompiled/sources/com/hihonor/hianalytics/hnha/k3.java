package com.hihonor.hianalytics.hnha;

import android.content.ContentValues;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class k3 extends h3 {
    private final String m;
    private final int n;
    private final int o;

    public k3(long j, String str, int i, int i2, int i3, long j2, String str2, String str3, String str4, String str5, int i4, int i5, String str6) {
        super(j, i3, j2, str2, str3, str4, str5, str6);
        this.m = str;
        this.n = i;
        this.o = i2;
        this.h = i4;
        this.i = i5;
    }

    public k3(String str, int i, int i2, int i3, long j, String str2) {
        super(0L, i3, com.hihonor.hianalytics.util.r.d(j), str2, g.a(str), "1.0.5.300", g.d(), null);
        this.m = str;
        this.n = i;
        this.o = i2;
    }

    @Override // com.hihonor.hianalytics.hnha.h3
    public ContentValues a(ContentValues contentValues) {
        ContentValues contentValuesA = super.a(contentValues);
        contentValuesA.put("_tag", this.m);
        contentValuesA.put("_type", Integer.valueOf(this.n));
        contentValuesA.put("_reportType", Integer.valueOf(this.o));
        return contentValuesA;
    }

    @Override // com.hihonor.hianalytics.hnha.h3
    protected void a(JSONObject jSONObject) throws JSONException {
        super.a(jSONObject);
        jSONObject.put("servicetag", this.m);
        jSONObject.put("haStatEventType", String.valueOf(this.n));
        jSONObject.put("haStatReportType", String.valueOf(this.o));
        jSONObject.put("haTagUid", h.i(this.m));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof k3)) {
            return false;
        }
        k3 k3Var = (k3) obj;
        long j = this.f3645a;
        if (j > 0) {
            long j2 = k3Var.f3645a;
            if (j2 > 0) {
                return j == j2;
            }
        }
        return this.n == k3Var.n && this.b == k3Var.b && this.o == k3Var.o && this.c == k3Var.c && Objects.equals(this.d, k3Var.d) && Objects.equals(this.m, k3Var.m) && Objects.equals(this.e, k3Var.e) && Objects.equals(this.f, k3Var.f) && Objects.equals(this.g, k3Var.g) && Objects.equals(this.j, k3Var.j);
    }

    public int hashCode() {
        int i = (((((this.n + 527) * 31) + this.b) * 31) + this.o) * 31;
        long j = this.c;
        int i2 = (i + ((int) (j ^ (j >>> 32)))) * 31;
        String str = this.d;
        int iHashCode = (i2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.m;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.e;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.f;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.g;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.j;
        return iHashCode5 + (str6 != null ? str6.hashCode() : 0);
    }

    public int i() {
        return this.o;
    }

    public String toString() {
        return "ReportStatInfo#" + hashCode() + "{id=" + this.f3645a + ",reportType=" + this.o + ",tag=" + this.m + ",type=" + this.n + ",statType=" + this.b + ",statState=" + this.i + ",count=" + this.h + ",appId=" + this.e + ",reportTime=" + com.hihonor.hianalytics.util.r.a(this.c) + ",reportTimeZone=" + this.d + '}';
    }
}
