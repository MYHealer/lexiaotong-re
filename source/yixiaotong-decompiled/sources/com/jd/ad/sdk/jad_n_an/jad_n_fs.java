package com.jd.ad.sdk.jad_n_an;

import android.content.Context;
import android.view.ViewGroup;
import com.jd.ad.sdk.bl.dynamicrender.ShakeListener;
import com.jd.ad.sdk.nativead.JADNative;

/* JADX INFO: compiled from: JADNativeViewController.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_n_fs extends ShakeListener {
    public final /* synthetic */ float jad_n_an;
    public final /* synthetic */ float jad_n_bo;
    public final /* synthetic */ float jad_n_cp;
    public final /* synthetic */ jad_n_er jad_n_dq;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jad_n_fs(jad_n_er jad_n_erVar, Context context, float f, float f2, float f3, boolean z, float f4, float f5, float f6) {
        super(context, f, f2, f3, z);
        this.jad_n_dq = jad_n_erVar;
        this.jad_n_an = f4;
        this.jad_n_bo = f5;
        this.jad_n_cp = f6;
    }

    @Override // com.jd.ad.sdk.bl.dynamicrender.ShakeListener
    public void onShake() {
        JADNative jADNative = this.jad_n_dq.jad_n_an;
        if (jADNative == null || jADNative.getSlot() == null) {
            return;
        }
        if (this.jad_n_dq.jad_n_an.getSlot().getAdType() == 1) {
            jad_n_er jad_n_erVar = this.jad_n_dq;
            if (jad_n_er.jad_n_an(jad_n_erVar, jad_n_erVar.jad_n_fs)) {
                jad_n_er jad_n_erVar2 = this.jad_n_dq;
                jad_n_erVar2.jad_n_jw = jad_n_er.jad_n_an(jad_n_erVar2, this.jad_n_an, this.jad_n_bo, this.jad_n_cp);
                jad_n_er jad_n_erVar3 = this.jad_n_dq;
                jad_n_erVar3.jad_n_bo(jad_n_erVar3.jad_n_fs);
                return;
            }
            return;
        }
        jad_n_er jad_n_erVar4 = this.jad_n_dq;
        ViewGroup viewGroup = jad_n_erVar4.jad_n_fs;
        if (viewGroup == null || !jad_n_erVar4.jad_n_an(viewGroup)) {
            return;
        }
        jad_n_er jad_n_erVar5 = this.jad_n_dq;
        if (jad_n_er.jad_n_an(jad_n_erVar5, jad_n_erVar5.jad_n_fs.getContext(), this.jad_n_dq.jad_n_an.getInstanceId())) {
            jad_n_er jad_n_erVar6 = this.jad_n_dq;
            jad_n_erVar6.jad_n_jw = jad_n_er.jad_n_an(jad_n_erVar6, this.jad_n_an, this.jad_n_bo, this.jad_n_cp);
            jad_n_er jad_n_erVar7 = this.jad_n_dq;
            jad_n_erVar7.jad_n_bo(jad_n_erVar7.jad_n_fs);
        }
    }
}
