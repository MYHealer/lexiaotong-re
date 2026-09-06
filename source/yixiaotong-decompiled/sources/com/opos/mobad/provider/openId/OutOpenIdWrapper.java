package com.opos.mobad.provider.openId;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class OutOpenIdWrapper extends OpenIdData implements Parcelable {
    public static final Parcelable.Creator<OutOpenIdWrapper> CREATOR = new Parcelable.Creator<OutOpenIdWrapper>() { // from class: com.opos.mobad.provider.openId.OutOpenIdWrapper.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public OutOpenIdWrapper createFromParcel(Parcel parcel) {
            return new OutOpenIdWrapper(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public OutOpenIdWrapper[] newArray(int i) {
            return new OutOpenIdWrapper[i];
        }
    };
    public int e;
    public String f;
    public String g;
    public String h;

    public OutOpenIdWrapper(int i) {
        super(i);
        this.e = i;
    }

    OutOpenIdWrapper(String str, String str2, String str3, int i) {
        super(str, str2, str3);
        this.f = str;
        this.g = str2;
        this.h = str3;
        this.e = i;
    }

    public int a() {
        return this.e;
    }

    public void a(int i) {
        this.e = i;
    }

    @Override // com.opos.mobad.provider.openId.OpenIdData, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.opos.mobad.provider.openId.OpenIdData, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(TextUtils.isEmpty(this.f7267a) ? "" : this.f7267a);
        parcel.writeString(TextUtils.isEmpty(this.b) ? "" : this.b);
        parcel.writeString(TextUtils.isEmpty(this.c) ? "" : this.c);
        parcel.writeInt(this.e);
    }
}
