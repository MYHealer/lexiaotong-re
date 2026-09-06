package com.byazt.dg;

import android.graphics.Path;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEODECODER_FPS, 71})
public class x {
    public final List<c<com.byazt.jx.yp, Path>> c;
    public final List<c<Integer, Integer>> tt;
    public final List<com.byazt.jx.x> ve;

    public List<com.byazt.jx.x> c() {
        return this.ve;
    }

    public List<c<com.byazt.jx.yp, Path>> tt() {
        return this.c;
    }

    public List<c<Integer, Integer>> ve() {
        return this.tt;
    }

    public x(List<com.byazt.jx.x> list) {
        this.ve = list;
        this.c = new ArrayList(list.size());
        this.tt = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            this.c.add(list.get(i).tt().c());
            this.tt.add(list.get(i).ve().c());
        }
    }
}
