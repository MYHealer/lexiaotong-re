package com.kwad.sdk.api.loader;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class e {
    public static Context bm(Context context) {
        if (context == null) {
            return null;
        }
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        if (origApplicationContext == null) {
            return context;
        }
        if (!origApplicationContext.getClassLoader().equals(context.getClassLoader())) {
            return new a(context);
        }
        return StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    static class a extends Application {
        private final Context aHW;

        @Override // android.content.ContextWrapper, android.content.Context
        public final Context getApplicationContext() {
            return this.aHW;
        }

        a(Context context) {
            this.aHW = context;
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public final ApplicationInfo getApplicationInfo() {
            return this.aHW.getApplicationInfo();
        }
    }
}
