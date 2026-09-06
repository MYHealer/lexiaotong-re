package com.byazt.us;

import android.os.Build;
import com.byazt.hu.u;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_PROCESSOR_ADDR, 54})
public class ve {
    public static void c(final com.byazt.dd.tt ttVar, final com.byazt.ok.c cVar) {
        boolean zTt = com.byazt.g.c.c().tt();
        if (!zTt && Build.VERSION.SDK_INT >= 29) {
            u.ve();
        }
        boolean zTt2 = com.byazt.g.c.c().tt();
        if (!zTt && zTt2 && ttVar != null) {
            ttVar.t(true);
        }
        cVar.c();
        com.byazt.x.c.tt("AppInstallOptimiseHelper", "AppInstallOptimiseHelper-->isAppForegroundSecond:::".concat(String.valueOf(zTt2)));
        if (zTt2) {
            return;
        }
        com.byazt.g.c.c().c(new com.byazt.g.c.InterfaceC0156c() { // from class: com.byazt.us.ve.1
            @Override // com.byazt.g.c.InterfaceC0156c
            public void ve() {
            }

            @Override // com.byazt.g.c.InterfaceC0156c
            public void tt() {
                com.byazt.x.c.tt("AppInstallOptimiseHelper", "AppInstallOptimiseHelper-->onAppForeground");
                com.byazt.g.c.c().tt(this);
                if (u.tt(ttVar)) {
                    return;
                }
                ttVar.u(true);
                com.byazt.zn.c.c().c("install_delay_invoke", ttVar);
                cVar.c();
            }
        });
    }
}
