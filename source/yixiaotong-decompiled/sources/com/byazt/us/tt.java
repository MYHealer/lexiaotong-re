package com.byazt.us;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_PROCESSOR_ADDR, 13})
public class tt {
    public void c(final com.byazt.dd.tt ttVar, final sp spVar, int i) {
        com.byazt.di.n.c().c(new Runnable() { // from class: com.byazt.us.tt.1
            @Override // java.lang.Runnable
            public void run() {
                if (i.c(ttVar)) {
                    spVar.c(false);
                } else if (!a.c(ttVar)) {
                    spVar.c(false);
                } else {
                    a.c(ttVar, new x() { // from class: com.byazt.us.tt.1.1
                        @Override // com.byazt.us.x
                        public void c(boolean z) {
                            spVar.c(z);
                        }
                    });
                }
            }
        }, i);
    }
}
