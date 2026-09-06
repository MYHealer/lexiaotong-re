package com.huawei.hms.ads;

import android.content.Context;
import android.view.View;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.views.PPSNativeView;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class cg implements cf<View> {
    private static final String Code = "cg";
    private com.huawei.openalliance.ad.inter.data.l B;
    private PPSNativeView.e C;
    private View I;
    private Context V;
    private AdContentData Z;

    public cg(Context context, View view) {
        this.V = context;
        Code(view);
    }

    private void Code(kr krVar) {
        jk.Code(this.V, this.Z, 0, 0, krVar.Z(), com.huawei.openalliance.ad.utils.b.Code(I()), com.huawei.openalliance.ad.utils.bg.V(I()));
    }

    @Override // com.huawei.hms.ads.cf
    public void Code() {
        jk.Code(this.V, this.Z);
    }

    @Override // com.huawei.hms.ads.cf
    public void Code(long j, int i) {
        jk.Code(this.V, this.Z, j, i);
    }

    public final void Code(View view) {
        this.I = view;
    }

    @Override // com.huawei.hms.ads.cf
    public void Code(com.huawei.openalliance.ad.inter.data.l lVar) {
        this.B = lVar;
        this.Z = lVar != null ? lVar.q() : null;
    }

    @Override // com.huawei.hms.ads.cf
    public void Code(PPSNativeView.e eVar) {
        this.C = eVar;
    }

    @Override // com.huawei.hms.ads.cf
    public void Code(Long l, Integer num, Integer num2, boolean z) {
        ji.a aVar = new ji.a();
        if (z) {
            aVar.V(Long.valueOf(com.huawei.openalliance.ad.utils.z.Code()));
        }
        String strCode = com.huawei.openalliance.ad.utils.bg.Code(I());
        com.huawei.openalliance.ad.inter.data.l lVar = this.B;
        if (lVar != null) {
            fh.Code(Code, "slotId: %s, contentId: %s, slot pos: %s", lVar.r(), this.B.d(), strCode);
        }
        aVar.Code(l).Code(num).V(num2).B(strCode).Code(ky.Code(I())).I(com.huawei.openalliance.ad.utils.b.Code(I()));
        jk.Code(this.V, this.Z, aVar.Code());
    }

    @Override // com.huawei.hms.ads.cf
    public void Code(String str) {
        AdContentData adContentData = this.Z;
        if (adContentData == null) {
            return;
        }
        adContentData.I(str);
    }

    @Override // com.huawei.hms.ads.cf
    public void Code(List<String> list) {
        jk.Code(this.V, this.Z, 0, 0, list);
    }

    public View I() {
        return this.I;
    }

    @Override // com.huawei.hms.ads.cf
    public boolean V() {
        com.huawei.openalliance.ad.inter.data.l lVar = this.B;
        if (lVar == null) {
            return false;
        }
        lVar.Code(true);
        fh.Code(Code, "deal click");
        kr krVarCode = ks.Code(this.V, this.Z, this.B.au());
        boolean zCode = krVarCode.Code();
        if (zCode) {
            Code(krVarCode);
            PPSNativeView.e eVar = this.C;
            if (eVar != null) {
                eVar.V();
                this.C.I();
            }
        }
        return zCode;
    }
}
