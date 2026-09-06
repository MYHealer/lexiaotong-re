package com.byazt.euv;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.bytedance.pangle.activity.IPluginActivity;
import com.bytedance.pangle.plugin.Plugin;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public interface tt {
    void finish();

    Application getApplication();

    Context getBaseContext();

    Intent getIntent();

    Plugin getPlugin();

    String getPluginPkgName();

    void setPlugin(Plugin plugin);

    void setTargetActivity(IPluginActivity iPluginActivity);

    void zeusSuperAttachBaseContext(Context context);

    void zeusSuperOnCreate(Bundle bundle);

    void zeusSuperSetTheme(int i);
}
