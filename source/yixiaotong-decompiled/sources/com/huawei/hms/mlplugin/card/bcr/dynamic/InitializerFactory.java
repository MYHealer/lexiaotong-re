package com.huawei.hms.mlplugin.card.bcr.dynamic;

import com.huawei.hms.mlsdk.dynamic.IInitializer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class InitializerFactory {
    public static IInitializer getRemoteBcrInitializer() {
        return RemoteBcrInitializer.getInstance();
    }
}
