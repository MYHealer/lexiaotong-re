package com.byazt.nm;

import android.content.Context;
import com.byazt.omf.h;
import com.stub.StubApp;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 585, 72})
public class da extends tt {
    public com.byazt.ll.tt tt;
    public com.byazt.dv.tt ve;

    public da(com.byazt.db.tt ttVar) {
        super(ttVar);
    }

    @Override // com.byazt.sp.tt
    public void startLoad(Context context, com.byazt.dv.tt ttVar, com.byazt.ll.tt ttVar2, Map<String, Object> map) {
        h pluginCSJLoader;
        this.tt = ttVar2;
        this.ve = ttVar;
        if (ttVar2 == null) {
            notifyLoadFail(new com.byazt.pp.c("load ad fail adSlot is null"));
            return;
        }
        if (map == null || (pluginCSJLoader = getPluginCSJLoader(StubApp.getOrigApplicationContext(context.getApplicationContext()))) == null) {
            return;
        }
        com.byazt.dj.tt.c cVarC = com.byazt.xf.tt.c(this.tt, this.ve, false);
        int iQy = this.tt.qy();
        int iGu = this.tt.gu();
        if (iQy > 0 && iGu > 0) {
            cVarC.c(iQy).tt(iGu);
        }
        Object obj = map.get("tt_ad_origin_type");
        if (obj != null) {
            int iIntValue = ((Integer) obj).intValue();
            if (iIntValue == 1) {
                c(pluginCSJLoader, cVarC);
            } else if (iIntValue == 2) {
                tt(pluginCSJLoader, cVarC);
            } else if (iIntValue == 3) {
                notifyLoadFail(new com.byazt.pp.c("渲染类型错误"));
            }
        }
    }

    private void c(h hVar, com.byazt.dj.tt.c cVar) {
        if (this.tt.yp() > 0.0f) {
            cVar.c(this.tt.u()).tt(this.tt.yp());
        } else {
            cVar.c(this.tt.u()).tt(0.0f);
        }
        new i().c(this.ve.c(), hVar, cVar.c(), this);
    }

    private void tt(h hVar, com.byazt.dj.tt.c cVar) {
        com.byazt.eu.tt.tt("TTMediationSDK", "PangleNativeLoader_loadNativeAd_renderControl:" + this.tt.z());
        cVar.ve(this.tt.z());
        new x().c(this.ve.c(), hVar, cVar.c(), this);
    }
}
