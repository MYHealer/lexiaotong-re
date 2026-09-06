package com.baidu.mobads.sdk.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
class ca implements Parcelable.Creator<bz> {
    ca() {
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public bz createFromParcel(Parcel parcel) {
        return new bz(parcel, null);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public bz[] newArray(int i) {
        return new bz[i];
    }
}
