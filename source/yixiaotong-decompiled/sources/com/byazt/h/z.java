package com.byazt.h;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_TCP_FAST_OPEN_SUCCESS, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class z {
    public static long c(List<i> list) {
        int size = list.size();
        long jN = 0;
        for (int i = 0; i < size; i++) {
            i iVar = list.get(i);
            if (iVar.ve() > jN) {
                break;
            }
            if (iVar.n() > jN) {
                jN = iVar.n();
            }
        }
        return jN;
    }

    public static long tt(List<i> list) {
        long jVe;
        long jUj;
        Iterator<i> it = list.iterator();
        long j = 0;
        loop0: while (true) {
            jVe = -1;
            jUj = -1;
            while (true) {
                if (!it.hasNext()) {
                    break loop0;
                }
                i next = it.next();
                if (jVe == -1) {
                    if (next.c() > 0) {
                        jVe = next.ve();
                        jUj = next.uj();
                    }
                } else if (next.ve() > jUj) {
                    j += jUj - jVe;
                    if (next.c() > 0) {
                        jVe = next.ve();
                        jUj = next.uj();
                    }
                } else if (next.uj() > jUj) {
                    jUj = next.uj();
                }
            }
        }
        return (jVe < 0 || jUj <= jVe) ? j : j + (jUj - jVe);
    }
}
