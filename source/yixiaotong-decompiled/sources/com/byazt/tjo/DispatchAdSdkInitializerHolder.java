package com.byazt.tjo;

import android.content.Context;
import android.os.Bundle;
import android.util.SparseArray;
import com.byazt.dna.my;
import com.byazt.omf.h;
import com.byazt.omf.md;
import java.util.function.Function;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 516, 2164})
public class DispatchAdSdkInitializerHolder implements my, Function {
    public static volatile Object c;
    public static com.byazt.omf.ve tt;

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        if (((Integer) sparseArray.get(0)).intValue() != 1) {
            return null;
        }
        return getDispatchAdSdkInitializer((Bundle) sparseArray.get(1), sparseArray.get(2));
    }

    @Override // com.byazt.dna.my
    public Object getDispatchAdSdkInitializer(Bundle bundle, Object obj) {
        com.byazt.omf.ve veVar = (com.byazt.omf.ve) obj;
        tt = veVar;
        if (c == null) {
            synchronized (DispatchAdSdkInitializerHolder.class) {
                if (c == null) {
                    c = new t(bundle, veVar);
                }
            }
        }
        return c;
    }

    public static md getCsjManger() {
        com.byazt.omf.ve veVar = tt;
        if (veVar != null) {
            return veVar.getManager();
        }
        return null;
    }

    public static boolean isInitSuccess() {
        com.byazt.omf.ve veVar = tt;
        return veVar != null && veVar.isInitSuccess();
    }

    public static h getCsjLoader(Context context) {
        if (getCsjManger() != null) {
            return getCsjManger().createLoader(context);
        }
        return null;
    }
}
