package com.bytedance.pangle.activity;

import android.content.Context;
import android.os.Bundle;
import com.byazt.euv.tt;
import com.bytedance.pangle.plugin.Plugin;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public interface IPluginActivity {
    void _requestPermissions(String[] strArr, int i);

    void attachBaseContext(Context context);

    String getPluginPkgName();

    void onCreate(Bundle bundle);

    void setPluginProxyActivity(tt ttVar, Plugin plugin);

    void setProxyTheme2Plugin(int i);
}
