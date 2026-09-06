package com.huawei.hms.mlkit.common.ha.event;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import com.huawei.hms.mlkit.common.ha.HianalyticsLogProvider;
import com.huawei.hms.mlkit.common.ha.a;
import com.huawei.hms.mlkit.common.ha.d;
import com.stub.StubApp;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public abstract class BaseInfoGatherEvent {
    public static final int TYPE_MAINT = 2;
    public static final int TYPE_OPERATE = 1;
    public static final int TYPE_PRELOAD = 4;

    private LinkedHashMap<String, String> getCommonData(Context context) {
        a aVarA = d.a(context, getAppInfo());
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("package", aVarA.f4150a);
        linkedHashMap.put("appid", aVarA.b);
        linkedHashMap.put("appName", aVarA.d);
        linkedHashMap.put("version", aVarA.c);
        linkedHashMap.put("service", "MLKit");
        linkedHashMap.put("transId", HianalyticsLogProvider.getInstance().getTransId());
        linkedHashMap.put("operator", d.b(StubApp.getOrigApplicationContext(context.getApplicationContext())));
        linkedHashMap.put("networkType", d.a(StubApp.getOrigApplicationContext(context.getApplicationContext())));
        linkedHashMap.put("apkVersion", getModelApkVersion());
        linkedHashMap.put("apiName", getApiName());
        linkedHashMap.put("countryCode", aVarA.f);
        linkedHashMap.put("deviceType", Build.MODEL);
        linkedHashMap.put("emuiVersion", d.a());
        linkedHashMap.put("moduleName", getModuleName());
        linkedHashMap.put("moduleVersion", getModuleVersion());
        linkedHashMap.put("deviceCategory", "");
        return linkedHashMap;
    }

    public abstract String getApiName();

    public abstract Bundle getAppInfo();

    public abstract LinkedHashMap<String, String> getCustomizedData();

    public final LinkedHashMap<String, String> getEventData(Context context) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.putAll(getCommonData(context));
        linkedHashMap.putAll(getCustomizedData());
        return linkedHashMap;
    }

    public abstract String getEventId();

    public abstract String getExtension(String str);

    public abstract String getModelApkVersion();

    public abstract String getModuleName();

    public abstract String getModuleVersion();
}
