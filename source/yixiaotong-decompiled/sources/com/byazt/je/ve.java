package com.byazt.je;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 725, 54})
public class ve {
    public final PluginValueSet c;

    public ve(SparseArray<Object> sparseArray) {
        this.c = com.byazt.rl.c.c(sparseArray).tt();
    }

    public Map<String, String> c() {
        return (Map) this.c.objectValue(265007, Map.class);
    }

    public String tt() {
        return (String) this.c.objectValue(265001, String.class);
    }

    public String ve() {
        return (String) this.c.objectValue(265002, String.class);
    }

    public String uj() {
        return (String) this.c.objectValue(265003, String.class);
    }

    public int n() {
        return this.c.intValue(265004);
    }

    public String a() {
        return (String) this.c.objectValue(265005, String.class);
    }

    public String sp() {
        return (String) this.c.objectValue(265006, String.class);
    }
}
