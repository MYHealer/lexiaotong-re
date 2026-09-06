package com.jd.ad.sdk.banner;

import com.jd.ad.sdk.bl.adinteraction.deeplink.OnUserCancelJdJumpCallback;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: JADBannerRender.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_b_an implements OnUserCancelJdJumpCallback {
    public final /* synthetic */ jad_b_bo jad_b_an;

    public jad_b_an(jad_b_bo jad_b_boVar) {
        this.jad_b_an = jad_b_boVar;
    }

    @Override // com.jd.ad.sdk.bl.adinteraction.deeplink.OnUserCancelJdJumpCallback
    public void callback(int i) {
        JADBanner.jad_b_jw jad_b_jwVar;
        WeakReference<JADBanner> weakReference;
        jad_b_bo.InterfaceC0545jad_b_bo interfaceC0545jad_b_bo = this.jad_b_an.jad_b_iv;
        if (interfaceC0545jad_b_bo == null || (weakReference = (jad_b_jwVar = (JADBanner.jad_b_jw) interfaceC0545jad_b_bo).jad_b_an) == null || weakReference.get() == null) {
            return;
        }
        jad_b_jwVar.jad_b_an.get().reportClickEvent(i);
    }
}
