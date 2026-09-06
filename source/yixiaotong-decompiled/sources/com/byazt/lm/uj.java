package com.byazt.lm;

import android.app.Application;
import android.util.SparseArray;
import com.byazt.qde.Stub_SingleTask_Activity_T;
import com.byazt.qde.Stub_Standard_Activity;
import com.byazt.qde.Stub_Standard_Activity_T;
import com.byazt.qde.Stub_Standard_Landscape_Activity;
import com.byazt.qde.Stub_Standard_Portrait_Activity;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import java.util.HashMap;
import java.util.function.Function;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 1949, 15})
public final class uj implements Function<SparseArray<Object>, Object> {
    public static volatile uj c;
    public ve tt;
    public final c ve = new c();

    public Application.ActivityLifecycleCallbacks getActivityLifecycleCallback() {
        return this.ve;
    }

    public void setBridgeFactory(ve veVar) {
        this.tt = veVar;
    }

    private uj() {
    }

    public static uj instance() {
        if (c == null) {
            synchronized (uj.class) {
                if (c == null) {
                    c = new uj();
                }
            }
        }
        return c;
    }

    private Function<SparseArray<Object>, Object> c(int i) {
        if (i == 2) {
            return com.byazt.we.ve.instance();
        }
        if (i == 3) {
            return com.byazt.nu.ve.instance(TTAppContextHolder.getContext());
        }
        if (i != 4) {
            return null;
        }
        return com.byazt.qc.c.instance();
    }

    private void c(final tt ttVar) {
        this.ve.c(new c.InterfaceC0210c() { // from class: com.byazt.lm.uj.1
            @Override // com.byazt.lm.c.InterfaceC0210c
            public void c() {
                ttVar.c();
            }

            @Override // com.byazt.lm.c.InterfaceC0210c
            public void tt() {
                ttVar.tt();
            }
        });
    }

    @Override // java.util.function.Function
    public Object apply(SparseArray<Object> sparseArray) {
        Function<SparseArray<Object>, Object> functionC;
        int iIntValue = ((Integer) sparseArray.get(-99999987)).intValue();
        if (iIntValue != -99999986) {
            switch (iIntValue) {
                case 2:
                    return this.ve.c();
                case 3:
                    return TTAppContextHolder.getContext();
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                    ve veVar = this.tt;
                    if (veVar != null && (functionC = veVar.c(4)) != null) {
                        return functionC.apply(sparseArray);
                    }
                    return null;
                case 9:
                    Object obj = sparseArray.get(0);
                    if (obj instanceof Function) {
                        c(new tt((Function) obj));
                    }
                    return null;
                case 10:
                    ve veVar2 = this.tt;
                    if (veVar2 == null) {
                        return c(((Integer) sparseArray.get(0)).intValue());
                    }
                    return veVar2.c(((Integer) sparseArray.get(0)).intValue());
                default:
                    switch (iIntValue) {
                        case 14:
                            return this.ve.tt();
                        case 15:
                            HashMap map = new HashMap();
                            map.put("STUB_STANDARD_ACTIVITY_T", Stub_Standard_Activity_T.class.getName());
                            map.put("STUB_STANDARD_PORTRAIT_ACTIVITY_T", Stub_Standard_Portrait_Activity.class.getName());
                            map.put("STUB_STANDARD_ACTIVITY", Stub_Standard_Activity.class.getName());
                            map.put("STUB_STANDARD_LANDSCAPE_ACTIVITY", Stub_Standard_Landscape_Activity.class.getName());
                            map.put("STUB_SINGLE_TASK_ACTIVITY_T", Stub_SingleTask_Activity_T.class.getName());
                            return map;
                        case 16:
                            return TTAppContextHolder.class;
                        case 17:
                            return n.c();
                        case 18:
                            com.byazt.zqa.c cVar = (com.byazt.zqa.c) ((Class) sparseArray.get(0)).getAnnotation(com.byazt.zqa.c.class);
                            if (cVar != null) {
                                return cVar.c();
                            }
                            return null;
                        default:
                            return null;
                    }
            }
        }
        SparseArray sparseArray2 = new SparseArray();
        sparseArray2.put(10000, 5);
        return sparseArray2;
    }
}
