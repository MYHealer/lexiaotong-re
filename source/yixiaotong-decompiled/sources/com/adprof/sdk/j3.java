package com.adprof.sdk;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.IOException;
import java.lang.reflect.Array;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class j3 implements Parcelable.Creator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final di f1241a;

    public j3(di diVar) {
        this.f1241a = diVar;
    }

    @Override // android.os.Parcelable.Creator
    public Object createFromParcel(Parcel parcel) {
        try {
            return this.f1241a.a(parcel.createByteArray());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // android.os.Parcelable.Creator
    public Object[] newArray(int i) {
        return (Object[]) Array.newInstance((Class<?>) this.f1241a.f223a, i);
    }
}
