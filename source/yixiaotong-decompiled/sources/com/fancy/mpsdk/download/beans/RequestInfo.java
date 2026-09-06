package com.fancy.mpsdk.download.beans;

import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.fancy._cq;
import com.fancy._d1;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public class RequestInfo implements Parcelable {
    public static final Parcelable.Creator<RequestInfo> CREATOR = new _a();
    public String _a;
    public String _b;
    public String _c;
    public int _d;
    public Messenger _e;
    public _d1 _f;
    public _cq _g;
    public boolean _h;

    public class _a implements Parcelable.Creator<RequestInfo> {
        @Override // android.os.Parcelable.Creator
        public final RequestInfo createFromParcel(Parcel parcel) {
            return new RequestInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final RequestInfo[] newArray(int i) {
            return new RequestInfo[i];
        }
    }

    public RequestInfo(Parcel parcel) {
        this._c = parcel.readString();
        this._a = parcel.readString();
        this._b = parcel.readString();
        this._d = parcel.readInt();
        this._e = (Messenger) parcel.readParcelable(Messenger.class.getClassLoader());
        this._f = (_d1) parcel.readSerializable();
        this._h = parcel.readByte() != 0;
    }

    public RequestInfo(String str) {
        this._c = str;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return TextUtils.equals(this._c, ((RequestInfo) obj)._c);
    }

    public final int hashCode() {
        String str = this._c;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this._c);
        parcel.writeString(this._a);
        parcel.writeString(this._b);
        parcel.writeInt(this._d);
        parcel.writeParcelable(this._e, i);
        parcel.writeSerializable(this._f);
        parcel.writeByte(this._h ? (byte) 1 : (byte) 0);
    }
}
