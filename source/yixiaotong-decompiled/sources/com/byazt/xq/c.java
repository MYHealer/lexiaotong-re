package com.byazt.xq;

import android.util.SparseArray;
import com.byazt.bp.tt;
import com.byazt.bp.ve;
import com.byazt.dna.rl;
import java.util.function.Function;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 1802, 20})
public class c implements rl, Function {
    public com.byazt.dna.c c;

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        int iIntValue = ((Integer) ((SparseArray) obj).get(0)).intValue();
        if (iIntValue == 1) {
            return getMediationAppLogUrl();
        }
        if (iIntValue == 2) {
            return Boolean.valueOf(isAppLogV2());
        }
        if (iIntValue != 3) {
            return null;
        }
        return Integer.valueOf(getEventBatchSize());
    }

    public c(com.byazt.dna.c cVar) {
        this.c = cVar;
    }

    @Override // com.byazt.dna.rl
    public String getMediationAppLogUrl() {
        return ve.tt();
    }

    @Override // com.byazt.dna.rl
    public boolean isAppLogV2() {
        return tt.tt().uj();
    }

    @Override // com.byazt.dna.rl
    public int getEventBatchSize() {
        return tt.tt().qp();
    }
}
