package com.bytedance.sdk.openadsdk.mediation.bridge.valueset;

import com.byazt.zqa.c;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.ValueSet;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@c(c = {0, 80, 81, 82, 83, 265, AVMDLDataLoader.KeyIsIsTestSpeedVersion, 2239})
public class MediationValueUtil {
    public static <T> T checkClassType(Class<T> cls) {
        if (cls == Boolean.class || cls == Boolean.TYPE) {
            return (T) Boolean.FALSE;
        }
        if (cls == Integer.class || cls == Integer.TYPE) {
            return (T) 0;
        }
        if (cls == Long.class || cls == Long.TYPE) {
            return (T) 0L;
        }
        if (cls == Float.class || cls == Float.TYPE) {
            return (T) Float.valueOf(0.0f);
        }
        if (cls == Double.class || cls == Double.TYPE) {
            return (T) Double.valueOf(0.0d);
        }
        return null;
    }

    public static <T> T objectValue(Object obj, Class<T> cls, T t) {
        if (obj instanceof ValueSet.ValueGetter) {
            obj = (T) ((ValueSet.ValueGetter) obj).get();
        }
        return cls.isInstance(obj) ? (T) obj : t;
    }
}
