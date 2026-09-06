package com.meishu.sdk.core;

import android.content.Context;
import android.text.TextUtils;
import java.util.List;

/* JADX INFO: compiled from: BaseConfig.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public abstract class b implements d {
    public String appId;

    public String getAppId() {
        return this.appId;
    }

    @Override // com.meishu.sdk.core.d
    public List<String> getNeededPermissions() {
        return null;
    }

    @Override // com.meishu.sdk.core.d
    public void init(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(this.appId) || context == null) {
            return;
        }
        this.appId = str;
        onInit(context, str, str2);
    }

    public void onInit(Context context, String str, String str2) {
    }
}
