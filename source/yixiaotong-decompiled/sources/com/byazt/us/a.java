package com.byazt.us;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.byazt.hu.u;
import com.byazt.nr.m;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.android.exoplayer2.C;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_PROCESSOR_ADDR, 34})
public class a {
    public static Handler c = new Handler(Looper.getMainLooper());

    public static void c(final com.byazt.dd.tt ttVar, final x xVar) {
        boolean zTt = com.byazt.g.c.c().tt();
        if (!zTt && Build.VERSION.SDK_INT >= 29) {
            u.ve();
        }
        boolean zTt2 = com.byazt.g.c.c().tt();
        boolean z = !zTt && zTt2;
        if (ttVar != null) {
            ttVar.t(z);
        }
        xVar.c(z);
        if (ttVar == null) {
            return;
        }
        tt(ttVar, da(ttVar));
        if (zTt2) {
            return;
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        com.byazt.g.c.c().c(new com.byazt.g.c.InterfaceC0156c() { // from class: com.byazt.us.a.1
            @Override // com.byazt.g.c.InterfaceC0156c
            public void ve() {
            }

            @Override // com.byazt.g.c.InterfaceC0156c
            public void tt() {
                com.byazt.g.c.c().tt(this);
                com.byazt.di.n.c().c(new Runnable() { // from class: com.byazt.us.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        boolean zVe = u.ve(ttVar.n());
                        long jN = a.n(ttVar);
                        if (!zVe || jN >= System.currentTimeMillis() - jCurrentTimeMillis) {
                            if (System.currentTimeMillis() - jCurrentTimeMillis > a.x(ttVar)) {
                                com.byazt.zn.c.c().c("deeplink_delay_timeout", ttVar);
                                return;
                            }
                            ttVar.t(true);
                            com.byazt.zn.c.c().c("deeplink_delay_invoke", ttVar);
                            xVar.c(true);
                            a.tt(ttVar, a.da(ttVar));
                        }
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void tt(final com.byazt.dd.tt ttVar, final int i) {
        if (i <= 0) {
            return;
        }
        com.byazt.di.n.c().c(new Runnable() { // from class: com.byazt.us.a.2
            @Override // java.lang.Runnable
            public void run() {
                int i2 = 1;
                if (!u.ve(ttVar.n())) {
                    a.tt(ttVar, i - 1);
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    if (!ttVar.q()) {
                        i2 = 2;
                    }
                    jSONObject.putOpt("deeplink_source", Integer.valueOf(i2));
                } catch (JSONException e) {
                    m.c(e);
                }
                com.byazt.zn.c.c().c("deeplink_success_2", jSONObject, ttVar);
            }
        }, i(ttVar) * 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long x(com.byazt.dd.tt ttVar) {
        return com.byazt.hu.n.c((com.byazt.dd.c) ttVar).c("app_link_check_timeout", 300000L);
    }

    private static int i(com.byazt.dd.tt ttVar) {
        return com.byazt.hu.n.c((com.byazt.dd.c) ttVar).c("app_link_check_delay", 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int da(com.byazt.dd.tt ttVar) {
        return com.byazt.hu.n.c((com.byazt.dd.c) ttVar).c("app_link_check_count", 10);
    }

    public static boolean c(com.byazt.dd.tt ttVar) {
        return com.byazt.hu.n.c((com.byazt.dd.c) ttVar).tt("app_link_opt_switch") == 1;
    }

    public static boolean tt(com.byazt.dd.tt ttVar) {
        return com.byazt.hu.n.c((com.byazt.dd.c) ttVar).tt("app_link_opt_install_switch") == 1;
    }

    public static boolean ve(com.byazt.dd.tt ttVar) {
        return com.byazt.hu.n.c((com.byazt.dd.c) ttVar).tt("app_link_opt_invoke_switch") == 1;
    }

    public static boolean uj(com.byazt.dd.tt ttVar) {
        return com.byazt.hu.n.c((com.byazt.dd.c) ttVar).tt("app_link_opt_dialog_switch") == 1;
    }

    public static long n(com.byazt.dd.tt ttVar) {
        return ttVar == null ? C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS : com.byazt.hu.n.c((com.byazt.dd.c) ttVar).c("app_link_opt_back_time_limit", 3) * 1000;
    }
}
