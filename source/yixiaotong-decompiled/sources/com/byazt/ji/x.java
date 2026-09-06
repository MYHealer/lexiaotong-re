package com.byazt.ji;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_DECODER_ERROR, 71})
public class x extends tt implements sp {
    public String sl;
    public String t;

    public x(Context context) {
        super(context);
    }

    @Override // com.byazt.ji.tt
    public boolean c(Object... objArr) {
        if (this.n != null && !this.n.isEmpty()) {
            Object obj = this.n.get("name");
            if (obj != null) {
                this.sl = String.valueOf(obj);
            }
            Object obj2 = this.n.get("state");
            if (obj2 != null) {
                this.t = String.valueOf(obj2);
            }
        }
        com.byazt.xj.ve veVarTt = this.tt.tt(this.tt);
        if (veVarTt == null) {
            return false;
        }
        tt(veVarTt);
        return false;
    }

    private void tt(com.byazt.xj.ve veVar) {
        List<com.byazt.xj.ve<View>> listSp;
        List<tt> listTt;
        if (veVar == null) {
            return;
        }
        com.byazt.pm.i iVarKp = veVar.kp();
        if (iVarKp != null && (listTt = iVarKp.tt("timer")) != null && !listTt.isEmpty()) {
            for (tt ttVar : listTt) {
                if (ttVar instanceof a) {
                    a aVar = (a) ttVar;
                    if (TextUtils.isEmpty(this.sl) || TextUtils.equals(this.sl, aVar.tt())) {
                        aVar.c(this);
                    }
                }
            }
        }
        if (!(veVar instanceof com.byazt.xj.c) || (listSp = ((com.byazt.xj.c) veVar).sp()) == null || listSp.isEmpty()) {
            return;
        }
        Iterator<com.byazt.xj.ve<View>> it = listSp.iterator();
        while (it.hasNext()) {
            tt(it.next());
        }
    }

    @Override // com.byazt.ji.sp
    public void c(String str) {
        if (TextUtils.equals(this.t, "start") || TextUtils.isEmpty(this.t)) {
            if ((TextUtils.isEmpty(this.sl) || TextUtils.equals(this.sl, str)) && this.c != null) {
                this.c.c(this.tt, this.f2381a, this.ve.tt(), this.ve);
            }
        }
    }

    @Override // com.byazt.ji.sp
    public void tt(String str) {
        if (TextUtils.equals(this.t, "complete") || TextUtils.isEmpty(this.t)) {
            if ((TextUtils.isEmpty(this.sl) || TextUtils.equals(this.sl, str)) && this.c != null) {
                this.c.c(this.tt, this.f2381a, this.ve.tt(), this.ve);
            }
        }
    }
}
