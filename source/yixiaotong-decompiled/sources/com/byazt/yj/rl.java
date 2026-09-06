package com.byazt.yj;

import android.util.SparseArray;
import client.android.yixiaotong.v3.comman.AppTypeIdUtil;
import java.util.function.Function;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 1197, AppTypeIdUtil.Drink4GCostControl_1})
public class rl implements gt, Function {
    public volatile Function c;
    public volatile gt tt;

    public rl(gt gtVar) {
        this.tt = gtVar;
    }

    public rl(Function function) {
        this.c = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        if (((Integer) sparseArray.get(0)).intValue() != 1) {
            return null;
        }
        Object obj2 = sparseArray.get(1);
        this.tt.onStep(((Integer) obj2).intValue(), sparseArray.get(2));
        return null;
    }

    @Override // com.byazt.yj.gt
    public void onStep(int i, Object obj) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, Integer.valueOf(i));
        sparseArray.put(2, obj);
        this.c.apply(sparseArray);
    }
}
