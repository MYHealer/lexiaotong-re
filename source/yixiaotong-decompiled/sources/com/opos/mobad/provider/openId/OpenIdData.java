package com.opos.mobad.provider.openId;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class OpenIdData implements Parcelable {
    public static final Parcelable.Creator<OpenIdData> CREATOR = new Parcelable.Creator<OpenIdData>() { // from class: com.opos.mobad.provider.openId.OpenIdData.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public OpenIdData createFromParcel(Parcel parcel) {
            return new OpenIdData(parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public OpenIdData[] newArray(int i) {
            return new OpenIdData[i];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f7267a;
    public String b;
    public String c;
    public int d;

    OpenIdData(int i) {
        this.d = i;
    }

    OpenIdData(String str, String str2, String str3) {
        this.f7267a = str;
        this.b = str2;
        this.c = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "OpenIdData{ouId='" + this.f7267a + "', duId='" + this.b + "', guId='" + this.c + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(TextUtils.isEmpty(this.f7267a) ? "" : this.f7267a);
        parcel.writeString(TextUtils.isEmpty(this.b) ? "" : this.b);
        parcel.writeString(TextUtils.isEmpty(this.c) ? "" : this.c);
    }
}
