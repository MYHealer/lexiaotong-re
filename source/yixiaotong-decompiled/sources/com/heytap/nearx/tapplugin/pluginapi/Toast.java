package com.heytap.nearx.tapplugin.pluginapi;

import android.app.Activity;
import android.content.Context;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class Toast {
    public static final int LENGTH_LONG = 1;
    public static final int LENGTH_SHORT = 0;

    public static android.widget.Toast makeText(Context context, int i, int i2) {
        return makeText(context, context.getResources().getText(i), i2);
    }

    public static android.widget.Toast makeText(Context context, CharSequence charSequence, int i) {
        Activity proxyActivity = (PluginApi.sPluginMode && (context instanceof Activity)) ? PluginApi.getProxyActivity((Activity) context) : null;
        if (proxyActivity != null) {
            context = proxyActivity;
        }
        return android.widget.Toast.makeText(context, charSequence, i);
    }
}
