package com.hihonor.hianalytics.hnha;

import android.content.ContentValues;
import androidx.core.app.NotificationCompat;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class i3 extends h3 {
    private final String m;
    private final int n;
    private final String o;
    private final int p;

    public i3(long j, String str, int i, String str2, int i2, int i3, long j2, String str3, String str4, String str5, String str6, int i4, int i5, String str7) {
        super(j, i3, j2, str3, str4, str5, str6, str7);
        this.m = str;
        this.n = i;
        this.o = str2;
        this.p = i2;
        this.h = i4;
        this.i = i5;
    }

    public i3(String str, int i, String str2, int i2, int i3, long j, String str3) {
        super(0L, i3, com.hihonor.hianalytics.util.r.d(j), str3, g.a(str), "1.0.5.300", g.d(), null);
        this.m = str;
        this.n = i;
        this.o = str2;
        this.p = i2;
    }

    public i3(String str, int i, String str2, int i2, String str3, int i3, long j, String str4) {
        super(0L, i3, com.hihonor.hianalytics.util.r.d(j), str4, str3, "1.0.5.300", g.d(), null);
        this.m = str;
        this.n = i;
        this.o = str2;
        this.p = i2;
    }

    @Override // com.hihonor.hianalytics.hnha.h3
    public ContentValues a(ContentValues contentValues) {
        ContentValues contentValuesA = super.a(contentValues);
        contentValuesA.put("_tag", this.m);
        contentValuesA.put("_type", Integer.valueOf(this.n));
        contentValuesA.put("_evtId", this.o);
        contentValuesA.put("_sourceType", Integer.valueOf(this.p));
        return contentValuesA;
    }

    @Override // com.hihonor.hianalytics.hnha.h3
    protected void a(JSONObject jSONObject) throws JSONException {
        super.a(jSONObject);
        jSONObject.put("servicetag", this.m);
        jSONObject.put("haStatEventType", String.valueOf(this.n));
        jSONObject.put(NotificationCompat.CATEGORY_EVENT, this.o);
        jSONObject.put("haStatSourceType", String.valueOf(this.p));
        jSONObject.put("haTagUid", h.i(this.m));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof i3)) {
            return false;
        }
        i3 i3Var = (i3) obj;
        long j = this.f3645a;
        if (j > 0) {
            long j2 = i3Var.f3645a;
            if (j2 > 0) {
                return j == j2;
            }
        }
        return this.n == i3Var.n && this.b == i3Var.b && this.p == i3Var.p && this.c == i3Var.c && Objects.equals(this.d, i3Var.d) && Objects.equals(this.m, i3Var.m) && Objects.equals(this.o, i3Var.o) && Objects.equals(this.e, i3Var.e) && Objects.equals(this.f, i3Var.f) && Objects.equals(this.g, i3Var.g) && Objects.equals(this.j, i3Var.j);
    }

    public int hashCode() {
        int i = (((((this.n + 527) * 31) + this.b) * 31) + this.p) * 31;
        long j = this.c;
        int i2 = (i + ((int) (j ^ (j >>> 32)))) * 31;
        String str = this.d;
        int iHashCode = (i2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.m;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.o;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.e;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.f;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.g;
        int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.j;
        return iHashCode6 + (str7 != null ? str7.hashCode() : 0);
    }

    public String toString() {
        return "EventStatInfo#" + hashCode() + "{id=" + this.f3645a + ",eventId=" + this.o + ",tag=" + this.m + ",type=" + this.n + ",statType=" + this.b + ",statState=" + this.i + ",sourceType=" + this.p + ",count=" + this.h + ",appId=" + this.e + ",eventTime=" + com.hihonor.hianalytics.util.r.a(this.c) + ",eventTimeZone=" + this.d + '}';
    }
}
