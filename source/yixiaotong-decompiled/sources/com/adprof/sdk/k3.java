package com.adprof.sdk;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class k3 extends de implements Parcelable {
    public k3(di diVar, q6 q6Var) {
        super(diVar, q6Var);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeByteArray(((de) this).f212a.m609a((Object) this));
    }
}
