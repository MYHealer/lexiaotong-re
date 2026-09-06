package com.yfanads.android.adx.core.load;

import com.yfanads.android.adx.core.model.PrivateData;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class PrivateDataMgr {
    private static PrivateData mPrivateData;

    private PrivateDataMgr() {
    }

    public static PrivateData getPrivateData() {
        return mPrivateData;
    }

    public static void setPrivateData(PrivateData privateData) {
        mPrivateData = privateData;
    }
}
