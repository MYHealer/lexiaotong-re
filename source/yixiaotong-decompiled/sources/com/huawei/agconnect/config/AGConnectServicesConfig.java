package com.huawei.agconnect.config;

import android.content.Context;
import com.huawei.agconnect.AGCRoutePolicy;
import com.huawei.agconnect.AGConnectOptions;
import com.huawei.agconnect.config.impl.c;
import com.stub.StubApp;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
@Deprecated
public abstract class AGConnectServicesConfig implements AGConnectOptions {
    private static final Map<String, AGConnectServicesConfig> INSTANCES = new HashMap();
    private static final Object INSTANCES_LOCK = new Object();

    public static AGConnectServicesConfig fromContext(Context context) {
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        if (origApplicationContext != null) {
            context = origApplicationContext;
        }
        return fromContext(context, context.getPackageName());
    }

    public static AGConnectServicesConfig fromContext(Context context, String str) {
        AGConnectServicesConfig cVar;
        synchronized (INSTANCES_LOCK) {
            Map<String, AGConnectServicesConfig> map = INSTANCES;
            cVar = map.get(str);
            if (cVar == null) {
                cVar = new c(context, str);
                map.put(str, cVar);
            }
        }
        return cVar;
    }

    public abstract void overlayWith(LazyInputStream lazyInputStream);

    public abstract void overlayWith(InputStream inputStream);

    public abstract void setParam(String str, String str2);

    public abstract void setRoutePolicy(AGCRoutePolicy aGCRoutePolicy);
}
