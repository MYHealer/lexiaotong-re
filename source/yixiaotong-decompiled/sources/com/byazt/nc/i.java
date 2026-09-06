package com.byazt.nc;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Function;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 259, 42})
public abstract class i extends da {
    public PluginValueSet c;

    public abstract void setCanInterruptVideoPlay(boolean z);

    public abstract void setDrawVideoListener(com.byazt.uz.c cVar);

    public abstract void setPauseIcon(Bitmap bitmap, int i);

    @Override // com.byazt.nc.da, com.byazt.nc.u
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
        return super.values();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.byazt.nc.da, com.byazt.nc.u, com.byazt.nc.x, java.util.function.Function
    public Object apply(SparseArray<Object> sparseArray) {
        com.byazt.lsp.ve veVar;
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet pluginValueSetTt = com.byazt.rl.c.c(sparseArray).tt();
        int iIntValue = pluginValueSetTt.intValue(-99999987);
        pluginValueSetTt.objectValue(-99999985, Class.class);
        if (iIntValue == -99999986) {
            return values().sparseArray();
        }
        if (iIntValue != 140111) {
            switch (iIntValue) {
                case 170101:
                    setCanInterruptVideoPlay(pluginValueSetTt.booleanValue(0));
                    break;
                case 170102:
                    setPauseIcon((Bitmap) pluginValueSetTt.objectValue(0, Bitmap.class), pluginValueSetTt.intValue(1));
                    break;
                case 170103:
                    setDrawVideoListener(new com.byazt.uz.c((Function) pluginValueSetTt.objectValue(0, Function.class)));
                    break;
                default:
                    return super.apply(sparseArray);
            }
        } else {
            Function function = (Function) pluginValueSetTt.objectValue(0, Function.class);
            if (pluginValueSetTt.intValue(1) == 1) {
                veVar = new com.byazt.am.n(function);
            } else {
                veVar = new com.byazt.lsp.ve(function);
            }
            setExpressRenderListener(veVar);
        }
        return null;
    }
}
