package com.byazt.zk;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.huawei.hms.ads.nativead.DetailedCreativeType;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, DetailedCreativeType.SINGLE_IMG, 42})
public class i extends ve {
    public i(com.byazt.ga.x xVar, x xVar2) {
        super(xVar, xVar2);
    }

    @Override // com.byazt.zk.ve
    public void tt(Canvas canvas, Matrix matrix, int i) {
        super.tt(canvas, matrix, i);
    }

    @Override // com.byazt.zk.ve, com.byazt.zy.n
    public void c(RectF rectF, Matrix matrix, boolean z) {
        super.c(rectF, matrix, z);
        rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
    }
}
