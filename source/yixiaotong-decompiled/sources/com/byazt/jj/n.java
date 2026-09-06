package com.byazt.jj;

import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 292, 46})
public class n {
    public static Function<SparseArray<Object>, Object> c;

    public static void c(Function<SparseArray<Object>, Object> function) {
        c = function;
    }

    public static String c() {
        Function<SparseArray<Object>, Object> function = c;
        if (function != null) {
            Object objApply = function.apply(com.byazt.yxi.uj.c().c(10004).c(String.class).tt());
            if (objApply instanceof String) {
                return objApply.toString();
            }
        }
        return null;
    }

    public static String tt() {
        Function<SparseArray<Object>, Object> function = c;
        if (function != null) {
            Object objApply = function.apply(com.byazt.yxi.uj.c().c(10005).c(String.class).tt());
            if (objApply instanceof String) {
                return objApply.toString();
            }
        }
        return null;
    }

    public static String ve() {
        Function<SparseArray<Object>, Object> function = c;
        if (function != null) {
            Object objApply = function.apply(com.byazt.yxi.uj.c().c(10006).c(String.class).tt());
            if (objApply instanceof String) {
                return objApply.toString();
            }
        }
        return null;
    }
}
