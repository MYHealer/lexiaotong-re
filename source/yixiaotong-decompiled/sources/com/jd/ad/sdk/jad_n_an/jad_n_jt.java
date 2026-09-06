package com.jd.ad.sdk.jad_n_an;

import android.view.MotionEvent;
import android.view.View;
import com.jd.ad.sdk.dl.common.CommonConstants;
import com.jd.ad.sdk.fdt.utils.ScreenUtils;

/* JADX INFO: compiled from: JADNativeViewController.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_n_jt implements View.OnTouchListener {
    public final /* synthetic */ float[] jad_n_an;
    public final /* synthetic */ float[] jad_n_bo;
    public final /* synthetic */ float jad_n_cp;
    public final /* synthetic */ float jad_n_dq;
    public final /* synthetic */ jad_n_er jad_n_er;

    public jad_n_jt(jad_n_er jad_n_erVar, float[] fArr, float[] fArr2, float f, float f2) {
        this.jad_n_er = jad_n_erVar;
        this.jad_n_an = fArr;
        this.jad_n_bo = fArr2;
        this.jad_n_cp = f;
        this.jad_n_dq = f2;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.jad_n_an[0] = motionEvent.getX();
            this.jad_n_an[1] = motionEvent.getY();
            return true;
        }
        if (action == 1) {
            this.jad_n_bo[0] = motionEvent.getX();
            this.jad_n_bo[1] = motionEvent.getY();
            jad_n_er jad_n_erVar = this.jad_n_er;
            float[] fArr = this.jad_n_an;
            float f = fArr[0];
            float f2 = fArr[1];
            float[] fArr2 = this.jad_n_bo;
            float f3 = fArr2[0];
            float f4 = fArr2[1];
            float f5 = this.jad_n_cp;
            float f6 = this.jad_n_dq;
            if (jad_n_erVar.jad_n_fs != null) {
                float f7 = f3 - f;
                float f8 = f4 - f2;
                if (f5 <= 0.0f) {
                    f5 = 1.0f;
                }
                if (f6 <= 0.0f) {
                    f6 = 45.0f;
                }
                float f9 = 180.0f - f6;
                float fSqrt = (float) Math.sqrt(Math.pow(f8, 2.0d) + Math.pow(f7, 2.0d));
                float degrees = (float) Math.toDegrees(Math.atan2(Math.abs(f8), Math.abs(f7)));
                if (f8 < 0.0f && fSqrt > ScreenUtils.dip2px(jad_n_erVar.jad_n_fs.getContext(), f5) && degrees >= f6 && degrees <= f9) {
                    jad_n_erVar.jad_n_jw = CommonConstants.AdTriggerSourceType.SLIDE_UP.ordinal();
                    jad_n_erVar.jad_n_bo(jad_n_erVar.jad_n_fs);
                }
            }
        }
        return false;
    }
}
