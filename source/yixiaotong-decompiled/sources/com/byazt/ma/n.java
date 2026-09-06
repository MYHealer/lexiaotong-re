package com.byazt.ma;

import android.view.View;
import android.view.ViewGroup;
import com.byazt.ete.ic;
import com.byazt.ete.ir;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_MASTER_CLOCK_BY_PTS, 46})
public class n extends c {
    public n(ic icVar, com.byazt.sy.c cVar, ir irVar) {
        super(icVar, cVar, irVar);
    }

    public void c(View view) {
        ViewGroup viewGroupVe;
        if (view == null || this.uj == null || !com.byazt.sy.uj.c(this.uj.uj()) || (viewGroupVe = com.byazt.sy.uj.ve(view)) == null) {
            return;
        }
        tt(viewGroupVe, viewGroupVe);
    }
}
