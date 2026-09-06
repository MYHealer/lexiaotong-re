package com.huawei.hms.framework.network.grs.f;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.AssetsUtil;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsApp;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class b {
    private static final Map<String, b> b = new ConcurrentHashMap(16);
    private static final Object c = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f4045a;

    public b(Context context, boolean z) {
        a(context, z);
        b.put(context.getPackageName(), this);
    }

    public static b a(String str) {
        return b.get(str);
    }

    private void a(Context context, boolean z) {
        String[] list = AssetsUtil.list(context, GrsApp.getInstance().getBrand(""));
        List<String> arrayList = list == null ? new ArrayList<>() : Arrays.asList(list);
        String appConfigName = GrsApp.getInstance().getAppConfigName();
        Logger.i("LocalManagerProxy", "appConfigName is: " + appConfigName);
        this.f4045a = new d(false, z);
        if (arrayList.contains("grs_app_global_route_config.json") || !TextUtils.isEmpty(appConfigName)) {
            this.f4045a = new d(context, appConfigName, z);
        }
        if (!this.f4045a.c() && arrayList.contains("grs_sdk_global_route_config.json")) {
            this.f4045a = new c(context, z);
        }
        this.f4045a.a(context, arrayList);
    }

    public com.huawei.hms.framework.network.grs.local.model.a a() {
        return this.f4045a.a();
    }

    public String a(Context context, com.huawei.hms.framework.network.grs.e.a aVar, GrsBaseInfo grsBaseInfo, String str, String str2, boolean z) {
        String strA;
        synchronized (c) {
            strA = this.f4045a.a(context, aVar, grsBaseInfo, str, str2, z);
        }
        return strA;
    }

    public Map<String, String> a(Context context, com.huawei.hms.framework.network.grs.e.a aVar, GrsBaseInfo grsBaseInfo, String str, boolean z) {
        Map<String, String> mapA;
        synchronized (c) {
            mapA = this.f4045a.a(context, aVar, grsBaseInfo, str, z);
        }
        return mapA;
    }

    public void a(GrsBaseInfo grsBaseInfo) {
        this.f4045a.a(grsBaseInfo);
    }

    public Set<String> b() {
        return this.f4045a.b();
    }
}
