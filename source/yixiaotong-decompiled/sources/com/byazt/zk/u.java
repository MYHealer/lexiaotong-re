package com.byazt.zk;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.View;
import com.byazt.ga.rl;
import com.huawei.hms.ads.nativead.DetailedCreativeType;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, DetailedCreativeType.SINGLE_IMG, 67})
public class u extends sp {
    public final Map<String, Object> da;
    public int i;
    public int x;

    public u(com.byazt.ga.x xVar, x xVar2, Context context) {
        super(xVar, xVar2);
        this.x = -1;
        this.i = -1;
        HashMap map = new HashMap();
        this.da = map;
        if (this.sp != null) {
            float fC = com.byazt.kk.da.c();
            this.x = (int) (this.sp.c() * fC);
            this.i = (int) (this.sp.tt() * fC);
            map.put("ugen_url", this.sp.uj());
            map.put("ugen_md5", this.sp.n());
            map.put("ugen_v", this.sp.a());
            map.put("ugen_w", Integer.valueOf(this.x));
            map.put("ugen_h", Integer.valueOf(this.i));
        }
    }

    @Override // com.byazt.zk.sp, com.byazt.zk.ve
    public void tt(Canvas canvas, Matrix matrix, int i) {
        rl rlVarC = this.tt.c();
        View viewC = rlVarC != null ? rlVarC.c("view:", this.da) : null;
        if (this.x <= 0 || viewC == null) {
            return;
        }
        canvas.save();
        canvas.concat(matrix);
        c(i);
        float fX = x();
        c(viewC, this.x, this.i);
        viewC.setAlpha(fX);
        viewC.draw(canvas);
        canvas.restore();
    }

    private static void c(View view, int i, int i2) {
        view.layout(0, 0, i, i2);
        view.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(i2, 1073741824));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
    }
}
