package com.kwad.library.b.c;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Bundle;
import com.kwad.sdk.utils.ab;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
final class a extends Application implements d {
    private final String TAG = "PluginApplicationWrapper";
    private final Application aDR;
    private b aDS;
    private String aDT;

    @Override // com.kwad.library.b.c.d
    public final Context getDelegatedContext() {
        return this.aDR;
    }

    public a(Application application, String str) {
        this.aDR = application;
        this.aDT = str;
        b bVar = new b(application, this.aDT);
        this.aDS = bVar;
        try {
            ab.b(this, "mBase", bVar);
        } catch (Throwable unused) {
            attachBaseContext(this.aDS);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        try {
            Context contextM = c.m(this.aDR, this.aDT);
            new StringBuilder("PluginApplicationWrapper getApplicationContext result:  ").append(contextM);
            return contextM;
        } catch (Throwable th) {
            com.kwad.library.solder.lib.a.e("PluginApplicationWrapper", "PluginApplicationWrapper getApplicationContext error:  ", th);
            th.printStackTrace();
            return null;
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return this.aDS.getResources();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final AssetManager getAssets() {
        return this.aDS.getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final ClassLoader getClassLoader() {
        return this.aDS.getClassLoader();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void startActivity(Intent intent) {
        this.aDR.startActivity(intent);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void startActivities(Intent[] intentArr) {
        this.aDR.startActivities(intentArr);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void startActivity(Intent intent, Bundle bundle) {
        this.aDR.startActivity(intent, bundle);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void startActivities(Intent[] intentArr, Bundle bundle) {
        this.aDR.startActivities(intentArr, bundle);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final ComponentName startForegroundService(Intent intent) {
        return this.aDR.startForegroundService(intent);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void sendBroadcast(Intent intent) {
        this.aDR.sendBroadcast(intent);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final boolean bindService(Intent intent, ServiceConnection serviceConnection, int i) {
        return this.aDR.bindService(intent, serviceConnection, i);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void unbindService(ServiceConnection serviceConnection) {
        this.aDR.unbindService(serviceConnection);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void setTheme(int i) {
        this.aDR.setTheme(i);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final ComponentName startService(Intent intent) {
        return this.aDR.startService(intent);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final boolean stopService(Intent intent) {
        return this.aDR.stopService(intent);
    }

    @Override // android.app.Application
    public final void registerActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.aDR.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }

    @Override // android.app.Application
    public final void unregisterActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.aDR.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }
}
