package com.byazt.pct;

import client.android.yixiaotong.v3.comman.AppTypeIdUtil;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, AppTypeIdUtil.NewDevice4GDrinkOTA_1, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_START_TIME})
public class nu {
    public static qy c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f2622a;
    public final List<yp> n;
    public final c tt;
    public final da uj;
    public final com.byazt.nl.uj ve;

    public static da c(com.byazt.nl.uj ujVar) {
        return new da(ujVar);
    }

    public <T> void c(String str, T t) {
        tt();
        this.tt.c(str, t);
    }

    public nu c(String str, n<?, ?> nVar) {
        return c(str, (String) null, nVar);
    }

    public nu c(String str, String str2, n<?, ?> nVar) {
        tt();
        this.tt.f2618a.c(str, nVar);
        return this;
    }

    public nu c(String str, uj.tt ttVar) {
        return c(str, (String) null, ttVar);
    }

    public nu c(String str, String str2, uj.tt ttVar) {
        tt();
        this.tt.f2618a.c(str, ttVar);
        return this;
    }

    public boolean c(String str) {
        c cVar = this.tt;
        if (cVar == null || cVar.f2618a == null) {
            return false;
        }
        return this.tt.f2618a.c(str);
    }

    public void c() {
        if (this.f2622a) {
            return;
        }
        this.tt.ve();
        this.f2622a = true;
        Iterator<yp> it = this.n.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    public nu(da daVar) {
        qy qyVar;
        ArrayList arrayList = new ArrayList();
        this.n = arrayList;
        this.f2622a = false;
        this.uj = daVar;
        rl rlVarC = (!daVar.x || (qyVar = c) == null) ? null : qyVar.c(daVar.sl);
        if (daVar.c != null && daVar.tt == null) {
            this.tt = new zm();
        } else {
            this.tt = daVar.tt;
        }
        this.tt.c(daVar.ve());
        this.tt.c(daVar, rlVarC);
        this.ve = daVar.c;
        arrayList.add(daVar.da);
        i.c(daVar.f2619a);
        gr.c(daVar.sp);
    }

    private void tt() {
        if (this.f2622a) {
            i.c(new IllegalStateException("JsBridge2 is already released!!!"));
        }
    }
}
