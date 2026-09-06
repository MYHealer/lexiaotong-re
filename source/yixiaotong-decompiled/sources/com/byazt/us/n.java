package com.byazt.us;

import com.byazt.gq.t;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.huawei.openalliance.ad.constant.ai;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_PROCESSOR_ADDR, 46})
public class n implements com.byazt.g.c.InterfaceC0156c {
    public long c;

    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_PROCESSOR_ADDR, 151})
    private static class c {
        public static n c = new n();
    }

    @Override // com.byazt.g.c.InterfaceC0156c
    public void ve() {
    }

    public static n c() {
        return c.c;
    }

    private n() {
        this.c = 0L;
        com.byazt.g.c.c().c(this);
    }

    @Override // com.byazt.g.c.InterfaceC0156c
    public void tt() {
        this.c = System.currentTimeMillis();
    }

    public void c(final uj ujVar, final long j) {
        if (ujVar == null) {
            return;
        }
        com.byazt.di.n.c().c(new Runnable() { // from class: com.byazt.us.n.1
            @Override // java.lang.Runnable
            public void run() {
                if (!com.byazt.g.c.c().ve() || System.currentTimeMillis() - n.this.c <= j) {
                    ujVar.c(true);
                } else {
                    ujVar.c(false);
                }
            }
        }, j);
    }

    public void c(uj ujVar) {
        c(ujVar, 5000L);
    }

    public void tt(uj ujVar) {
        if (ujVar == null) {
            return;
        }
        JSONObject jSONObjectI = t.i();
        int i = ai.af;
        int iOptInt = jSONObjectI.optInt("check_an_result_delay", ai.af);
        if (iOptInt > 0) {
            i = iOptInt;
        }
        c(ujVar, i);
    }
}
