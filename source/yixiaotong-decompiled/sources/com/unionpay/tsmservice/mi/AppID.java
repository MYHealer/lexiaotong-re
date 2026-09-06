package com.unionpay.tsmservice.mi;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class AppID implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() { // from class: com.unionpay.tsmservice.mi.AppID.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new AppID(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AppID[i];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f9348a;
    String b;

    public AppID(Parcel parcel) {
        this.f9348a = "";
        this.b = "";
        this.f9348a = parcel.readString();
        this.b = parcel.readString();
    }

    public AppID(String str, String str2) {
        this.f9348a = str;
        this.b = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAppAid() {
        return this.f9348a;
    }

    public String getAppVersion() {
        return this.b;
    }

    public void setAppAid(String str) {
        this.f9348a = str;
    }

    public void setAppVersion(String str) {
        this.b = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f9348a);
        parcel.writeString(this.b);
    }
}
