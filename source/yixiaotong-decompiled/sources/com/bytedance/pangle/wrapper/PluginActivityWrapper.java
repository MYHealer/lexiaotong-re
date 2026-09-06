package com.bytedance.pangle.wrapper;

import android.app.Activity;
import android.app.Application;
import android.view.View;
import android.view.Window;
import com.byazt.uk.c;
import com.bytedance.pangle.Zeus;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class PluginActivityWrapper extends GenerateActivityWrapper {
    public static final int OBJECT_TAG = Integer.MAX_VALUE;

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:10:0x0026
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1478)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    public PluginActivityWrapper(android.app.Activity r4, com.bytedance.pangle.PluginContext r5) {
        /*
            r3 = this;
            java.lang.String r0 = "mBase"
            r3.<init>()
            r3.mOriginActivity = r4
            r3.pluginContext = r5
            android.app.Activity r1 = r3.mOriginActivity     // Catch: java.lang.Exception -> L26
            boolean r1 = r1.isDestroyed()     // Catch: java.lang.Exception -> L26
            if (r1 != 0) goto L29
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L26
            r2 = 29
            if (r1 < r2) goto L22
            android.app.Activity r1 = r3.mOriginActivity     // Catch: java.lang.Exception -> L26
            com.bytedance.pangle.wrapper.PluginActivityWrapper$1 r2 = new com.bytedance.pangle.wrapper.PluginActivityWrapper$1     // Catch: java.lang.Exception -> L26
            r2.<init>()     // Catch: java.lang.Exception -> L26
            r1.registerActivityLifecycleCallbacks(r2)     // Catch: java.lang.Exception -> L26
            goto L29
        L22:
            r3.setTag()     // Catch: java.lang.Exception -> L26
            goto L29
        L26:
            r3.registerApplicationLifecycleCallbacks()
        L29:
            com.bytedance.pangle.util.FieldUtils.writeField(r3, r0, r5)     // Catch: java.lang.IllegalAccessException -> L3b
            boolean r1 = com.byazt.uq.i.c()     // Catch: java.lang.IllegalAccessException -> L3b
            if (r1 != 0) goto L3b
            java.lang.Class<android.content.ContextWrapper> r1 = android.content.ContextWrapper.class
            java.lang.reflect.Field r0 = com.bytedance.pangle.util.FieldUtils.getField(r1, r0)     // Catch: java.lang.IllegalAccessException -> L3b
            com.bytedance.pangle.util.FieldUtils.writeField(r0, r3, r5)     // Catch: java.lang.IllegalAccessException -> L3b
        L3b:
            java.lang.String r5 = "mApplication"
            android.app.Application r0 = r4.getApplication()     // Catch: java.lang.IllegalAccessException -> L44
            com.bytedance.pangle.util.FieldUtils.writeField(r3, r5, r0)     // Catch: java.lang.IllegalAccessException -> L44
        L44:
            com.byazt.uq.c.c(r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.wrapper.PluginActivityWrapper.<init>(android.app.Activity, com.bytedance.pangle.PluginContext):void");
    }

    private void registerApplicationLifecycleCallbacks() {
        final Application appApplication = Zeus.getAppApplication();
        if (appApplication == null) {
            return;
        }
        appApplication.registerActivityLifecycleCallbacks(new c() { // from class: com.bytedance.pangle.wrapper.PluginActivityWrapper.2
            @Override // com.byazt.uk.c, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                super.onActivityDestroyed(activity);
                if (activity == PluginActivityWrapper.this.mOriginActivity) {
                    appApplication.unregisterActivityLifecycleCallbacks(this);
                }
            }
        });
    }

    private void setTag() {
        View decorView;
        String pluginPackageName;
        Window window = this.mOriginActivity.getWindow();
        if (window == null || (decorView = window.getDecorView()) == null || (pluginPackageName = this.pluginContext.getPluginPackageName()) == null) {
            return;
        }
        decorView.setTag(pluginPackageName.hashCode(), new c() { // from class: com.bytedance.pangle.wrapper.PluginActivityWrapper.3
        });
    }
}
