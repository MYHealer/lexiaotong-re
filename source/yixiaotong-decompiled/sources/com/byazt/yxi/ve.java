package com.byazt.yxi;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 1133, 54})
public class ve {
    public static boolean c(int i) {
        return i >= 6803 && i < 7000;
    }

    public static SparseArray<Object> c(Function<SparseArray<Object>, Object> function) {
        if (function == null) {
            return new SparseArray<>();
        }
        Object objApply = function.apply(uj.c().c(-99999986).c(SparseArray.class).tt());
        if (objApply instanceof SparseArray) {
            return (SparseArray) objApply;
        }
        return new SparseArray<>();
    }

    public static PluginValueSet tt(Function<SparseArray<Object>, Object> function) {
        Object objApply;
        if (function == null) {
            return com.byazt.rl.c.c().tt();
        }
        if ((function instanceof Supplier) && c(com.byazt.mta.c.c().tt())) {
            objApply = ((Supplier) function).get();
        } else {
            objApply = function.apply(uj.c().c(-99999986).c(SparseArray.class).tt());
        }
        if (objApply instanceof SparseArray) {
            return com.byazt.rl.c.c((SparseArray<Object>) objApply).tt();
        }
        return com.byazt.rl.c.c().tt();
    }
}
