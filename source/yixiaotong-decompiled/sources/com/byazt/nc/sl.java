package com.byazt.nc;

import android.app.Activity;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 259, 158})
public abstract class sl extends x {
    public PluginValueSet c;

    public abstract long getExpirationTimestamp();

    public abstract int getFullVideoAdType();

    public abstract int getInteractionType();

    public abstract Map<String, Object> getMediaExtraInfo();

    public abstract com.byazt.sbm.uj getMediationManager();

    public abstract void setDownloadListener(com.byazt.ocd.ve veVar);

    public abstract void setFullScreenVideoAdInteractionListener(com.byazt.gl.c cVar);

    public abstract void showFullScreenVideoAd(Activity activity);

    public abstract void showFullScreenVideoAd(Activity activity, Object obj, String str);

    public PluginValueSet values() {
        PluginValueSet pluginValueSet = this.c;
        if (pluginValueSet != null) {
            return pluginValueSet;
        }
        PluginValueSet pluginValueSetC = c();
        this.c = pluginValueSetC;
        return pluginValueSetC;
    }

    private PluginValueSet c() {
        com.byazt.rl.c cVarC = com.byazt.rl.c.c();
        cVarC.c(130001, com.byazt.lq.uj.c(new Supplier<Integer>() { // from class: com.byazt.nc.sl.1
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(sl.this.getInteractionType());
            }
        }));
        cVarC.c(130002, com.byazt.lq.uj.c(new Supplier<Map<String, Object>>() { // from class: com.byazt.nc.sl.2
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public Map<String, Object> get() {
                return sl.this.getMediaExtraInfo();
            }
        }));
        cVarC.c(130003, com.byazt.lq.uj.c(new Supplier<Integer>() { // from class: com.byazt.nc.sl.3
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(sl.this.getFullVideoAdType());
            }
        }));
        cVarC.c(130004, com.byazt.lq.uj.c(new Supplier<Long>() { // from class: com.byazt.nc.sl.4
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public Long get() {
                return Long.valueOf(sl.this.getExpirationTimestamp());
            }
        }));
        return cVarC.tt();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.byazt.nc.x, java.util.function.Function
    public Object apply(SparseArray<Object> sparseArray) {
        com.byazt.gl.c cVar;
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet pluginValueSetTt = com.byazt.rl.c.c(sparseArray).tt();
        int iIntValue = pluginValueSetTt.intValue(-99999987);
        if (iIntValue == -99999986) {
            return values().sparseArray();
        }
        if (iIntValue != 130106) {
            switch (iIntValue) {
                case 130101:
                    Function function = (Function) pluginValueSetTt.objectValue(0, Function.class);
                    if (pluginValueSetTt.intValue(1) == 1) {
                        cVar = new com.byazt.cw.tt(function);
                    } else {
                        cVar = new com.byazt.gl.c(function);
                    }
                    setFullScreenVideoAdInteractionListener(cVar);
                    return null;
                case 130102:
                    setDownloadListener(new com.byazt.ocd.ve((Function) pluginValueSetTt.objectValue(0, Function.class)));
                    return null;
                case 130103:
                    showFullScreenVideoAd((Activity) pluginValueSetTt.objectValue(0, Activity.class));
                    return null;
                case 130104:
                    showFullScreenVideoAd((Activity) pluginValueSetTt.objectValue(0, Activity.class), pluginValueSetTt.objectValue(1, Object.class), (String) pluginValueSetTt.objectValue(2, String.class));
                    return null;
                default:
                    return super.apply(sparseArray);
            }
        }
        return getMediationManager();
    }
}
