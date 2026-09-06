package com.bytedance.android.openliveplugin.process.server;

import android.app.Application;
import android.content.Context;
import com.byazt.bog.a;
import com.bytedance.android.dy.sdk.pangle.ZeusPlatformServerManager;
import com.bytedance.android.dy.sdk.pangle.ZeusPlatformUtils;
import com.bytedance.android.openliveplugin.stub.logger.TTLogger;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class LiveServerManager extends ZeusPlatformServerManager {
    @Override // com.byazt.quv.AbsServerManager, android.content.ContentProvider
    public boolean onCreate() {
        TTLogger.d("LiveServerManager onCreate");
        if (getContext() != null) {
            Context origApplicationContext = StubApp.getOrigApplicationContext(getContext().getApplicationContext());
            if (origApplicationContext instanceof Application) {
                try {
                    TTLogger.d("LiveServerManager initZeus");
                    ZeusPlatformUtils.initZeus((Application) origApplicationContext, true, "com.byted.live.lite");
                } catch (Throwable th) {
                    a.c(th);
                }
            }
        }
        return super.onCreate();
    }
}
