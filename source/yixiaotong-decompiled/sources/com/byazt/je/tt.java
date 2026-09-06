package com.byazt.je;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 725, 13})
public class tt {
    public final PluginValueSet c;

    public tt(SparseArray<Object> sparseArray) {
        this.c = com.byazt.rl.c.c(sparseArray).tt();
    }

    public List<String> c() {
        return (List) this.c.objectValue(262114, List.class);
    }

    public List<String> tt() {
        return (List) this.c.objectValue(262115, List.class);
    }

    public boolean ve() {
        return this.c.booleanValue(262116);
    }

    public boolean uj() {
        return this.c.booleanValue(262117);
    }

    public boolean n() {
        return this.c.booleanValue(262118);
    }
}
