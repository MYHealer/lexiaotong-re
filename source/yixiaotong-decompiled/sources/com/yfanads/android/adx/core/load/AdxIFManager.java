package com.yfanads.android.adx.core.load;

import com.yfanads.android.adx.api.AdVideoPlayConfig;
import com.yfanads.android.adx.api.AdxScene;
import com.yfanads.android.adx.core.impl.a;
import com.yfanads.android.adx.core.impl.c;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class AdxIFManager {
    private static final Map<Class<?>, Class<?>> aLq = new HashMap();
    private static boolean aLs = false;

    private static void Init() {
        putClass(AdVideoPlayConfig.class, a.class);
        putClass(AdxScene.class, c.class);
    }

    public static Class<?> getClass(Class<?> cls) {
        checkInit();
        return aLq.get(cls);
    }

    public static void putClass(Class<?> cls, Class<?> cls2) {
        aLq.put(cls, cls2);
    }

    private static synchronized void checkInit() {
        if (!aLs) {
            Init();
            aLs = true;
        }
    }
}
