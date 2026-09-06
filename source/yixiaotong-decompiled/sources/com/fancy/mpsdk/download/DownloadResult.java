package com.fancy.mpsdk.download;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public class DownloadResult implements Parcelable {
    public static final Parcelable.Creator<DownloadResult> CREATOR = new _a();
    public String _a;
    public String _b;
    public String _c;
    public long _d;
    public long _e;

    public class _a implements Parcelable.Creator<DownloadResult> {
        @Override // android.os.Parcelable.Creator
        public final DownloadResult createFromParcel(Parcel parcel) {
            return new DownloadResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final DownloadResult[] newArray(int i) {
            return new DownloadResult[i];
        }
    }

    public DownloadResult(Parcel parcel) {
        this._b = parcel.readString();
        this._c = parcel.readString();
    }

    public DownloadResult(String str, long j, long j2, String str2, String str3) {
        this._a = str;
        this._d = j;
        this._e = j2;
        this._b = str2;
        this._c = str3;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this._b);
        parcel.writeString(this._c);
    }
}
