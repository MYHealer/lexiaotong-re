package com.opos.mobad.provider.record;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class CookieData implements Parcelable {
    public static final Parcelable.Creator<CookieData> CREATOR = new Parcelable.Creator<CookieData>() { // from class: com.opos.mobad.provider.record.CookieData.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public CookieData createFromParcel(Parcel parcel) {
            return new CookieData(parcel.readString(), parcel.readLong());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public CookieData[] newArray(int i) {
            return new CookieData[i];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7273a;
    public final long b;

    public CookieData(String str, long j) {
        this.f7273a = str;
        this.b = j;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(TextUtils.isEmpty(this.f7273a) ? "" : this.f7273a);
        parcel.writeLong(this.b);
    }
}
