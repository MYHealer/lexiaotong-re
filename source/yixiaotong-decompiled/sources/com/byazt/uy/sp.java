package com.byazt.uy;

import android.app.Application;
import android.content.Context;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.stub.StubApp;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 1180, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_AUTO_RECOVERY})
public final class sp {
    public static boolean c;
    public static boolean tt;
    public static boolean uj;
    public static boolean ve;

    public static synchronized void c(Context context, n nVar, boolean z, boolean z2) {
        c(context, nVar, z, false, z2);
    }

    public static synchronized void c(Context context, n nVar, boolean z, boolean z2, boolean z3) {
        c(context, nVar, z, z, z2, z3);
    }

    public static synchronized void c(final Context context, n nVar, boolean z, boolean z2, boolean z3, final boolean z4) {
        if (c) {
            return;
        }
        if (context == null) {
            throw new IllegalArgumentException("context must be not null.");
        }
        if (nVar == null) {
            throw new IllegalArgumentException("params must be not null.");
        }
        if (!(context instanceof Application)) {
            context = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        if (com.byazt.mg.c.ve(context)) {
            return;
        }
        x.c(context, nVar);
        com.byazt.ia.n.c(context);
        if (z || z2) {
            com.byazt.yg.c cVarC = com.byazt.yg.c.c();
            if (z) {
                cVarC.c(new com.byazt.yg.ve(context));
            }
            tt = true;
        }
        uj = z3;
        c = true;
        ve = z4;
        com.byazt.rx.sp.tt().post(new Runnable() { // from class: com.byazt.uy.sp.1
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.kr.c.c().c(context);
                com.byazt.jz.uj.c(context);
                if (z4) {
                    com.byazt.kg.a.c(context).c();
                }
            }
        });
    }

    @Deprecated
    public static void c(String str) {
        if (x.n().c()) {
            com.byazt.yg.c.c(str);
        }
    }

    public static void c(a aVar) {
        x.tt().c(aVar);
    }

    public static void c(Map<? extends String, ? extends String> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        x.tt().c(map);
    }

    public static void c(final com.byazt.ba.tt ttVar) {
        com.byazt.rx.sp.tt().post(new Runnable() { // from class: com.byazt.uy.sp.2
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.ba.c.c(ttVar);
            }
        });
    }

    public static void c() {
        com.byazt.yg.c.tt();
    }
}
