package com.jd.ad.sdk.bl.dynamicrender;

import android.content.Context;
import android.view.View;

/* JADX INFO: compiled from: DynamicRenderView.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_bo implements View.OnClickListener {
    public final /* synthetic */ Context jad_an;
    public final /* synthetic */ DynamicRenderView jad_bo;

    public jad_bo(DynamicRenderView dynamicRenderView, Context context) {
        this.jad_bo = dynamicRenderView;
        this.jad_an = context;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        DynamicRenderView.IDynamicRenderCallback iDynamicRenderCallback = this.jad_bo.jad_cn;
        if (iDynamicRenderCallback != null) {
            iDynamicRenderCallback.onFullLottieViewClick(this.jad_an);
        }
    }
}
