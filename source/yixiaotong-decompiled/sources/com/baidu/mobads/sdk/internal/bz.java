package com.baidu.mobads.sdk.internal;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public class bz implements Parcelable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f1762a = "MD5";
    public static final Parcelable.Creator<bz> b = new ca();
    private JSONObject c;
    private double d;
    private String e;
    private String f;
    private String g;
    private int h;
    private int i;

    public double b() {
        return this.d;
    }

    public String d() {
        return this.f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.g;
    }

    /* synthetic */ bz(Parcel parcel, ca caVar) {
        this(parcel);
    }

    public bz(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.c = jSONObject;
            this.d = jSONObject.getDouble("version");
            this.e = this.c.getString("url");
            this.f = this.c.getString("sign");
            this.i = 1;
            this.g = "";
            this.h = 0;
        } catch (JSONException unused) {
            this.i = 0;
        }
        this.i = c() == null ? 0 : 1;
    }

    public bz(bz bzVar, String str, Boolean bool) {
        this.d = bzVar.b();
        this.e = bzVar.c();
        this.f = bzVar.d();
        this.i = bzVar.a().booleanValue() ? 1 : 0;
        this.g = str;
        this.h = bool.booleanValue() ? 1 : 0;
    }

    private bz(Parcel parcel) {
        this.f = parcel.readString();
        this.i = parcel.readInt();
        this.e = parcel.readString();
        this.d = parcel.readDouble();
        this.g = parcel.readString();
        this.h = parcel.readInt();
    }

    public Boolean a() {
        return Boolean.valueOf(this.i == 1);
    }

    public String c() {
        return cs.a().c(this.e);
    }

    public Boolean f() {
        return Boolean.valueOf(this.h == 1);
    }

    public String toString() {
        return this.c.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f);
        parcel.writeInt(this.i);
        parcel.writeString(this.e);
        parcel.writeDouble(this.d);
        parcel.writeString(this.g);
        parcel.writeInt(this.h);
    }
}
