package com.huawei.hms.feature.dynamic.e;

import android.content.Context;
import android.os.Bundle;
import com.huawei.hms.common.util.Logger;
import com.huawei.hms.feature.dynamic.DynamicModule;
import com.huawei.openalliance.ad.constant.x;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class e implements DynamicModule.VersionPolicy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f4034a = "e";

    @Override // com.huawei.hms.feature.dynamic.DynamicModule.VersionPolicy
    public Bundle getModuleInfo(Context context, String str) throws DynamicModule.LoadingException {
        Bundle remoteModuleInfo = DynamicModule.getRemoteModuleInfo(context, str);
        if (remoteModuleInfo.getInt("module_version") > 0) {
            Logger.i(f4034a, "Prefer remote: The version of remote module " + str + x.bQ + remoteModuleInfo.getInt("module_version"));
            return remoteModuleInfo;
        }
        Bundle localModuleInfo = DynamicModule.getLocalModuleInfo(context, str);
        if (localModuleInfo.getInt("local_module_version") > 0) {
            Logger.i(f4034a, "Choose local: The version of local module " + str + x.bQ + localModuleInfo.getInt("local_module_version"));
            return localModuleInfo;
        }
        Logger.i(f4034a, "Cannot get module info in remote or local.");
        return new Bundle();
    }
}
