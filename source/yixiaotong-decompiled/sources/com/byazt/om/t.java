package com.byazt.om;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlayer;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SAMPLE_RATE, 66})
public class t implements c {
    public final long c = 500;

    @Override // com.byazt.om.c
    public void c(c.InterfaceC0233c interfaceC0233c) {
        com.byazt.iz.tt ttVarC = interfaceC0233c.c();
        if (ttVarC.m() == null && ttVarC.gu().my() == 3 && !com.byazt.bp.tt.tt().pf() && ttVarC.or() != null) {
            com.byazt.eu.tt.uj("TTMediationSDK", "执行开启开屏兜底...............");
            c(interfaceC0233c, ttVarC, ttVarC.gu(), ttVarC.or());
        } else {
            interfaceC0233c.c(ttVarC);
        }
    }

    public void c(final c.InterfaceC0233c interfaceC0233c, final com.byazt.iz.tt ttVar, com.byazt.ll.tt ttVar2, com.byazt.yf.sl slVar) {
        if (slVar != null && ttVar2 != null) {
            com.byazt.eu.tt.uj("TTMediationSDK", com.byazt.eu.uj.c(ttVar2.gt()) + "settings config.......AdUnitId = " + ttVar2.gt() + "  开屏广告走了开发者自定义兜底方案   adnName:" + com.byazt.yl.c.c(slVar.c()));
        }
        com.byazt.ng.a.tt(ttVar2, -4);
        com.byazt.eu.tt.uj("TTMediationSDK", "开屏广告走了开发者自定义开屏兜底，数据为: getAdNetworkFlatFromId = " + slVar.c() + " getAppId = " + slVar.ve() + " getAppKey = " + slVar.uj() + " getAdNetworkSlotId = " + slVar.tt());
        if (slVar == null || TextUtils.isEmpty(slVar.tt()) || (TextUtils.isEmpty(slVar.ve()) && TextUtils.isEmpty(slVar.uj()))) {
            c(ttVar, 840027);
            ttVar.c(new com.byazt.pp.c(840027, com.byazt.pp.c.c(840027)));
            return;
        }
        int iC = slVar.c();
        final String strC = com.byazt.yl.c.c(iC);
        final String strTt = slVar.tt();
        if (TextUtils.isEmpty(strC)) {
            c(ttVar, 840027);
            ttVar.c(new com.byazt.pp.c(840027, com.byazt.pp.c.c(840027)));
            return;
        }
        if (iC == 3) {
            new com.byazt.uu.c(slVar).c(slVar);
            Looper looperTt = com.byazt.eu.n.tt();
            if (looperTt != null) {
                new Handler(looperTt).postDelayed(new Runnable() { // from class: com.byazt.om.t.1
                    @Override // java.lang.Runnable
                    public void run() {
                        t.this.c(interfaceC0233c, ttVar, strC, strTt);
                    }
                }, 500L);
                return;
            }
            return;
        }
        if (iC == 7 || iC == 6 || iC == 4 || iC == 8) {
            new com.byazt.uu.c(slVar).c(slVar);
            c(interfaceC0233c, ttVar, strC, strTt);
        } else if (iC == 1 || iC == 9) {
            new com.byazt.uu.c(slVar).c(slVar, new com.byazt.ly.ve() { // from class: com.byazt.om.t.2
                @Override // com.byazt.ly.ve
                public void c() {
                    t.this.c(interfaceC0233c, ttVar, strC, strTt);
                }

                @Override // com.byazt.ly.ve
                public void c(com.byazt.pp.c cVar) {
                    t.this.c(ttVar, 840027);
                    ttVar.c(new com.byazt.pp.c(840027, com.byazt.pp.c.c(840027)));
                }
            });
        } else {
            c(ttVar, 840027);
            ttVar.c(new com.byazt.pp.c(840027, com.byazt.pp.c.c(840027)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.byazt.iz.tt ttVar, int i) {
        com.byazt.ng.a.c(ttVar.gu(), (String) null, !ttVar.yv(), ttVar.pf().c, i, (Map<String, Object>) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(c.InterfaceC0233c interfaceC0233c, com.byazt.iz.tt ttVar, String str, String str2) {
        ttVar.c(c(ttVar.gu().gt(), str, str2));
        interfaceC0233c.c(ttVar);
    }

    @Override // com.byazt.om.c
    public void tt(c.InterfaceC0233c interfaceC0233c) {
        interfaceC0233c.c((String) null);
    }

    private com.byazt.nbs.tt c(String str, String str2, String str3) {
        com.byazt.nbs.da daVarC = com.byazt.oi.ve.c(str3, str2, -4, -4);
        if (daVarC == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(daVarC);
        com.byazt.nbs.tt ttVar = new com.byazt.nbs.tt();
        ttVar.uj(str);
        ttVar.m(3);
        ttVar.n(400L);
        ttVar.a(ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
        ttVar.sp(5000L);
        ttVar.x(C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
        ttVar.c(arrayList);
        return ttVar;
    }
}
