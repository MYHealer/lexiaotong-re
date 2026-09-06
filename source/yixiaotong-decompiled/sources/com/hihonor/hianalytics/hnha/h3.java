package com.hihonor.hianalytics.hnha;

import android.content.ContentValues;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class h3 extends i0 {
    protected final int b;
    protected final long c;
    protected final String d;
    protected final String e;
    protected final String f;
    protected final String g;
    protected int h;
    protected int i;
    protected String j;
    protected long k;
    protected String l;

    public h3(long j, int i, long j2, String str, String str2, String str3, String str4, String str5) {
        super(j);
        this.k = com.hihonor.hianalytics.util.r.b();
        this.l = null;
        this.b = i;
        this.c = j2;
        this.d = str;
        this.e = str2;
        this.f = str3;
        this.g = str4;
        this.j = str5;
        this.h = 1;
    }

    public ContentValues a(ContentValues contentValues) {
        contentValues.clear();
        contentValues.put("_statType", Integer.valueOf(this.b));
        contentValues.put("_sTime", Long.valueOf(this.c));
        contentValues.put("_cTime", Long.valueOf(this.k));
        contentValues.put("_sTimeZone", this.d);
        contentValues.put("_appId", this.e);
        contentValues.put("_sdkVersion", this.f);
        contentValues.put("_appVersion", this.g);
        contentValues.put("_statNum", Integer.valueOf(this.h));
        contentValues.put("_state", Integer.valueOf(this.i));
        contentValues.put("_reqId", this.j);
        contentValues.put("_otherDesc", this.l);
        return contentValues;
    }

    public h3 a(String str) {
        this.l = str;
        return this;
    }

    public void a(int i) {
        this.h += i;
    }

    protected void a(JSONObject jSONObject) throws JSONException {
        jSONObject.put("haStatDataId", String.valueOf(this.f3645a));
        jSONObject.put("haStatType", String.valueOf(this.b));
        jSONObject.put("haStatTime", String.valueOf(this.c));
        jSONObject.put("haStatCreateTime", String.valueOf(this.k));
        jSONObject.put("haStatTimeZone", this.d);
        jSONObject.put("appid", this.e);
        jSONObject.put("_lib_ver", this.f);
        jSONObject.put("_app_ver", this.g);
        jSONObject.put("haStatCount", String.valueOf(this.h));
    }

    public boolean a(long j, long j2) {
        long j3 = this.c;
        return j3 >= j && j3 <= j2;
    }

    public h3 b(long j) {
        this.k = j;
        return this;
    }

    public void b(String str) {
        this.j = str;
    }

    public int c() {
        return this.h;
    }

    public String d() {
        return this.j;
    }

    public long e() {
        return this.c;
    }

    public int f() {
        return this.b;
    }

    public boolean g() {
        return this.i == 0;
    }

    public final JSONObject h() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        a(jSONObject);
        return jSONObject;
    }
}
