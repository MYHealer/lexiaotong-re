package com.huawei.hms.feature.dynamic.e;

import android.content.Context;
import android.os.Bundle;
import com.huawei.hms.common.util.Logger;
import com.huawei.hms.feature.dynamic.DynamicModule;
import com.huawei.openalliance.ad.constant.x;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class c implements DynamicModule.VersionPolicy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f4032a = "c";

    @Override // com.huawei.hms.feature.dynamic.DynamicModule.VersionPolicy
    public Bundle getModuleInfo(Context context, String str) throws DynamicModule.LoadingException {
        DynamicModule.LoadingException loadingException;
        Bundle bundle;
        try {
            bundle = DynamicModule.getRemoteModuleInfo(context, str);
            loadingException = null;
        } catch (DynamicModule.LoadingException e) {
            loadingException = e.getBundle() != null ? new DynamicModule.LoadingException(e.getMessage(), e.getBundle()) : new DynamicModule.LoadingException(e.getMessage());
            Logger.w(f4032a, "Get remote module info failed: " + e.getMessage() + ". try to query local.");
            bundle = new Bundle();
        }
        Bundle localModuleInfo = DynamicModule.getLocalModuleInfo(context, str);
        String str2 = f4032a;
        Logger.i(str2, "The version of remote module " + str + x.bQ + bundle.getInt("module_version"));
        Logger.i(str2, "The version of local module " + str + x.bQ + localModuleInfo.getInt("local_module_version"));
        if (localModuleInfo.getInt("local_module_version") > 0 && localModuleInfo.getInt("local_module_version") >= bundle.getInt("module_version")) {
            Logger.i(str2, "Choose local module info.");
            return localModuleInfo;
        }
        if (loadingException != null && bundle.getInt("module_version") == 0) {
            throw loadingException;
        }
        Logger.i(str2, "Choose remote module info.");
        return bundle;
    }
}
