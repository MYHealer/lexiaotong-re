package com.jd.ad.sdk.jad_hu;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView;
import com.jd.ad.sdk.dl.common.CommonConstants;
import com.jd.ad.sdk.fdt.utils.ScreenUtils;

/* JADX INFO: compiled from: DynamicRenderView.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_iv implements View.OnTouchListener {
    public String jad_an = "";
    public String jad_bo = "";
    public int jad_cp;
    public int jad_dq;
    public final /* synthetic */ Context jad_er;
    public final /* synthetic */ DynamicRenderView jad_fs;

    public jad_iv(DynamicRenderView dynamicRenderView, Context context) {
        this.jad_fs = dynamicRenderView;
        this.jad_er = context;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0079  */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.jad_an = DynamicRenderView.jad_an(this.jad_fs, x, y);
            this.jad_cp = x;
            this.jad_dq = y;
            return false;
        }
        if (action != 1) {
            return false;
        }
        DynamicRenderView dynamicRenderView = this.jad_fs;
        Context context = this.jad_er;
        float f = this.jad_cp;
        float f2 = this.jad_dq;
        float f3 = x;
        float f4 = y;
        float f5 = dynamicRenderView.jad_lw;
        float f6 = dynamicRenderView.jad_oz;
        if (context == null) {
            z = false;
        } else {
            float f7 = f3 - f;
            float f8 = f4 - f2;
            if (f5 <= 0.0f) {
                f5 = 1.0f;
            }
            if (f6 <= 0.0f) {
                f6 = 45.0f;
            }
            float fSqrt = (float) Math.sqrt(Math.pow(f8, 2.0d) + Math.pow(f7, 2.0d));
            float degrees = (float) Math.toDegrees(Math.atan2(Math.abs(f8), Math.abs(f7)));
            float f9 = 180.0f - f6;
            if (f8 >= 0.0f || fSqrt <= ScreenUtils.dip2px(context, f5) || degrees < f6 || degrees > f9) {
                z = false;
            } else {
                z = true;
            }
        }
        this.jad_bo = DynamicRenderView.jad_an(this.jad_fs, x, y);
        if (TextUtils.isEmpty(this.jad_an) || TextUtils.isEmpty(this.jad_bo) || !this.jad_an.equals(this.jad_bo)) {
            if (this.jad_fs.jad_jt != 3 || !z) {
                return false;
            }
            int iOrdinal = CommonConstants.AdTriggerSourceType.SLIDE_UP.ordinal();
            DynamicRenderView dynamicRenderView2 = this.jad_fs;
            jad_an jad_anVar = dynamicRenderView2.jad_wj.get(dynamicRenderView2.jad_xk);
            if (jad_anVar == null) {
                return false;
            }
            jad_anVar.jad_dq = iOrdinal;
            jad_anVar.jad_an(view);
            return true;
        }
        if (this.jad_bo.equals("sdkInteractiveShake")) {
            return false;
        }
        jad_an jad_anVar2 = this.jad_fs.jad_wj.get(this.jad_bo);
        int iOrdinal2 = CommonConstants.AdTriggerSourceType.CLICK.ordinal();
        if (!TextUtils.isEmpty(this.jad_an) && this.jad_an.equals(this.jad_fs.jad_xk) && this.jad_fs.jad_jt == 3 && z) {
            iOrdinal2 = CommonConstants.AdTriggerSourceType.SLIDE_UP.ordinal();
        }
        if (jad_anVar2 == null) {
            return false;
        }
        jad_anVar2.jad_dq = iOrdinal2;
        jad_anVar2.jad_an(view);
        return true;
    }
}
