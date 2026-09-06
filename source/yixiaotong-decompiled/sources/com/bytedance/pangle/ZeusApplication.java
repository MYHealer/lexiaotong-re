package com.bytedance.pangle;

import android.app.Application;
import android.content.Context;
import com.bytedance.pangle.plugin.Plugin;
import java.util.function.Function;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class ZeusApplication extends PluginContext {
    public Application mHostApplication;

    public Function attach(Function function) {
        return null;
    }

    public Function initMainService(Function function) {
        return null;
    }

    public void onCreate() {
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public void attach(Plugin plugin, Application application) {
        this.mPlugin = plugin;
        this.mHostApplication = application;
        Function mainService = Zeus.getMainService();
        Function functionInitMainService = initMainService(mainService);
        if (mainService == null && functionInitMainService != null) {
            Zeus.setMainService(functionInitMainService);
        }
        this.mPlugin.setPluginBridge(attach(this.mPlugin.getApiBridge()));
        attachBaseContext(application);
        onCreate();
    }
}
