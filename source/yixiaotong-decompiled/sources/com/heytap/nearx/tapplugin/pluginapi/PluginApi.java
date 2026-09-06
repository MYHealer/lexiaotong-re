package com.heytap.nearx.tapplugin.pluginapi;

import android.app.Activity;
import android.app.Service;
import android.content.Context;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class PluginApi {
    public static long sHostApiCode;
    public static Context sHostContext;
    public static Context sPluginContext;
    public static boolean sPluginMode;
    public static String sPluginName;
    public static int sPluginVersionCode;

    public static Activity getProxyActivity(Activity activity) {
        return (Activity) RefInvoker.invokeMethod(activity, "getProxyActivity", new Class[0], new Object[0]);
    }

    public static Service getProxyService(Service service) {
        return (Service) RefInvoker.invokeMethod(service, "getProxyService", new Class[0], new Object[0]);
    }
}
