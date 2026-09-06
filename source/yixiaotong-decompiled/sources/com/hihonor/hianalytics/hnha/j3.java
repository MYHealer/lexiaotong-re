package com.hihonor.hianalytics.hnha;

import android.content.ContentValues;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class j3 extends h3 {
    private final int m;
    private final int n;
    private final int o;
    private final String p;

    public j3(int i, int i2, int i3, int i4, String str, long j, String str2, String str3) {
        super(0L, i3, com.hihonor.hianalytics.util.r.d(j), str2, str3, "1.0.5.300", g.d(), null);
        this.m = i;
        this.n = i2;
        this.o = i4;
        this.p = str;
    }

    public j3(long j, int i, int i2, int i3, int i4, String str, long j2, String str2, String str3, String str4, String str5, int i5, int i6, String str6) {
        super(j, i3, j2, str2, str3, str4, str5, str6);
        this.m = i;
        this.n = i2;
        this.o = i4;
        this.p = str;
        this.h = i5;
        this.i = i6;
    }

    @Override // com.hihonor.hianalytics.hnha.h3
    public ContentValues a(ContentValues contentValues) {
        ContentValues contentValuesA = super.a(contentValues);
        contentValuesA.put("_url", this.p);
        contentValuesA.put("_netCode", Integer.valueOf(this.o));
        contentValuesA.put("_type", Integer.valueOf(this.m));
        contentValuesA.put("_reportType", Integer.valueOf(this.n));
        return contentValuesA;
    }

    @Override // com.hihonor.hianalytics.hnha.h3
    protected void a(JSONObject jSONObject) throws JSONException {
        super.a(jSONObject);
        jSONObject.put("haStatUrl", this.p);
        jSONObject.put("haStatNetCode", String.valueOf(this.o));
        jSONObject.put("haStatEventType", String.valueOf(this.m));
        jSONObject.put("haStatReportType", String.valueOf(this.n));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof j3)) {
            return false;
        }
        j3 j3Var = (j3) obj;
        long j = this.f3645a;
        if (j > 0) {
            long j2 = j3Var.f3645a;
            if (j2 > 0) {
                return j == j2;
            }
        }
        return this.m == j3Var.m && this.b == j3Var.b && this.n == j3Var.n && this.o == j3Var.o && this.c == j3Var.c && Objects.equals(this.d, j3Var.d) && Objects.equals(this.p, j3Var.p) && Objects.equals(this.e, j3Var.e) && Objects.equals(this.f, j3Var.f) && Objects.equals(this.g, j3Var.g) && Objects.equals(this.j, j3Var.j);
    }

    public int hashCode() {
        int i = (((((((this.m + 527) * 31) + this.b) * 31) + this.n) * 31) + this.o) * 31;
        long j = this.c;
        int i2 = (i + ((int) (j ^ (j >>> 32)))) * 31;
        String str = this.d;
        int iHashCode = (i2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.p;
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
        return this.n;
    }

    public boolean j() {
        return this.o == 200;
    }

    public String toString() {
        return "NetSendStatInfo#" + hashCode() + "{id=" + this.f3645a + ",reportType=" + this.n + ",type=" + this.m + ",netCode=" + this.o + ",statType=" + this.b + ",statState=" + this.i + ",count=" + this.h + ",url=" + this.p + ",appId=" + this.e + ",reportTime=" + com.hihonor.hianalytics.util.r.a(this.c) + ",reportTimeZone=" + this.d + '}';
    }
}
