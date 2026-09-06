package com.huawei.hms.common.internal.safeparcel;

import com.huawei.hms.support.api.client.Result;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public abstract class AbstractSafeParcelable extends Result implements SafeParcelable {
    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }
}
