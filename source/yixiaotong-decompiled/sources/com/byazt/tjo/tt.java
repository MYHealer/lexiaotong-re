package com.byazt.tjo;

import android.os.Bundle;
import android.util.SparseArray;
import com.byazt.omf.md;
import com.byazt.omf.p;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 516, 13})
public class tt {
    public static String uj() {
        return "7.6.1.1";
    }

    public static int c() {
        return p.uj;
    }

    public static md tt() {
        return DispatchAdSdkInitializerHolder.getCsjManger();
    }

    public static String ve() {
        return p.n;
    }

    public static boolean n() {
        return DispatchAdSdkInitializerHolder.isInitSuccess();
    }

    public static void c(int i) {
        md mdVarTt = tt();
        if (mdVarTt != null) {
            mdVarTt.setThemeStatus(i);
        }
    }

    public static void c(boolean z) {
        md mdVarTt = tt();
        if (mdVarTt == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_paid", z);
        if (bundle.keySet().isEmpty()) {
            return;
        }
        mdVarTt.getExtra(SparseArray.class, bundle);
    }
}
