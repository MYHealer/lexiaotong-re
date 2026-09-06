package com.meishu.sdk.core;

import android.content.Context;
import java.util.List;

/* JADX INFO: compiled from: ISdkConfig.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface d {
    List<String> getNeededPermissions();

    void init(Context context, String str, String str2);
}
