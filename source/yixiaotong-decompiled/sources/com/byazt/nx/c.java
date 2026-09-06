package com.byazt.nx;

import android.util.SparseArray;
import com.byazt.am.ve;
import com.byazt.ch.tt;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Function;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 2323, 20})
public class c {
    public PluginValueSet c;
    public com.byazt.ch.c tt;

    public c(SparseArray<Object> sparseArray) {
        this.c = com.byazt.rl.c.c(sparseArray).tt();
        this.tt = new com.byazt.ch.c(sparseArray, com.byazt.vxy.c.tt());
    }

    public int c() {
        return this.tt.a();
    }

    public int tt() {
        return this.tt.sp();
    }

    public float ve() {
        return this.tt.x();
    }

    public float uj() {
        return this.tt.i();
    }

    public String n() {
        return this.tt.uj();
    }

    public tt a() {
        com.byazt.ch.c cVar = this.tt;
        if (cVar != null) {
            return cVar.md();
        }
        return null;
    }

    public ve sp() {
        if (a() != null) {
            return a().u();
        }
        return null;
    }

    public Function<SparseArray<Object>, Object> x() {
        PluginValueSet pluginValueSet = this.c;
        if (pluginValueSet != null) {
            return com.byazt.gxc.ve.c(pluginValueSet.objectValue(8302, Object.class));
        }
        return null;
    }

    public int i() {
        PluginValueSet pluginValueSet = this.c;
        if (pluginValueSet != null) {
            return pluginValueSet.intValue(3);
        }
        return 0;
    }
}
