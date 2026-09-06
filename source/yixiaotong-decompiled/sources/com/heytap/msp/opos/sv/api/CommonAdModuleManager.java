package com.heytap.msp.opos.sv.api;

import android.content.Context;
import com.heytap.msp.opos.sv.a.a.a;
import com.heytap.msp.opos.sv.a.a.b;
import com.heytap.msp.opos.sv.interapi.bean.commonad.deeplink.DeepLinkRequest;
import com.heytap.msp.opos.sv.interapi.bean.commonad.deeplink.DeepLinkResult;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class CommonAdModuleManager implements b {
    private static volatile CommonAdModuleManager sInstance;
    private final b mManagerImpl = new a();

    private CommonAdModuleManager() {
    }

    public static CommonAdModuleManager getInstance() {
        if (sInstance == null) {
            synchronized (CommonAdModuleManager.class) {
                if (sInstance == null) {
                    sInstance = new CommonAdModuleManager();
                }
            }
        }
        return sInstance;
    }

    @Override // com.heytap.msp.opos.sv.a.a.b
    public DeepLinkResult executeDeepLink(Context context, DeepLinkRequest deepLinkRequest) {
        return this.mManagerImpl.executeDeepLink(context, deepLinkRequest);
    }
}
