package com.byazt.kk;

import com.byazt.ga.sl;
import com.byazt.nr.m;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SWITCH_SUBID, 46})
public class n implements sl {
    public static final Set<String> c = new HashSet();

    @Override // com.byazt.ga.sl
    public void c(String str) {
        c(str, null);
    }

    @Override // com.byazt.ga.sl
    public void c(String str, Throwable th) {
        Set<String> set = c;
        if (set.contains(str)) {
            return;
        }
        m.tt("LOTTIE", str, th);
        set.add(str);
    }

    @Override // com.byazt.ga.sl
    public void tt(String str, Throwable th) {
        boolean z = com.byazt.ga.n.c;
    }
}
