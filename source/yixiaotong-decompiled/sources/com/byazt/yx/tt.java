package com.byazt.yx;

import com.byazt.eg.gt;
import com.byazt.eg.h;
import com.byazt.eg.yv;
import com.byazt.mk.rh;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import cz.msebera.android.httpclient.protocol.HTTP;
import java.io.IOException;
import java.net.ProtocolException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF, 13})
public final class tt implements gt {
    public final boolean c;

    public tt(boolean z) {
        this.c = z;
    }

    @Override // com.byazt.eg.gt
    public h c(gt.c cVar) throws IOException {
        h hVarC;
        sp spVar = (sp) cVar;
        ve veVarSp = spVar.sp();
        com.byazt.iq.sp spVarA = spVar.a();
        com.byazt.iq.ve veVar = (com.byazt.iq.ve) spVar.n();
        yv yvVarC = spVar.c();
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (yvVarC != null && yvVarC.f2148a != null) {
            yvVarC.f2148a.c(jCurrentTimeMillis);
        }
        spVar.call();
        veVarSp.c(yvVarC);
        spVar.call();
        h.c cVarC = null;
        if (a.ve(yvVarC.tt()) && yvVarC.uj() != null) {
            if (HTTP.EXPECT_CONTINUE.equalsIgnoreCase(yvVarC.c("Expect"))) {
                veVarSp.c();
                spVar.call();
                cVarC = veVarSp.c(true);
            }
            if (cVarC == null) {
                spVar.call();
                com.byazt.mk.uj ujVarC = com.byazt.mk.t.c(new c(veVarSp.c(yvVarC, yvVarC.uj().tt())));
                yvVarC.uj().c(ujVarC);
                ujVarC.close();
                spVar.call();
            } else if (!veVar.n()) {
                spVarA.uj();
            }
        }
        veVarSp.tt();
        if (cVarC == null) {
            spVar.call();
            cVarC = veVarSp.c(false);
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        if (yvVarC.f2148a != null) {
            yvVarC.f2148a.tt(jCurrentTimeMillis2);
        }
        h hVarC2 = cVarC.c(yvVarC).c(spVarA.tt().uj()).c(jCurrentTimeMillis).tt(jCurrentTimeMillis2).c();
        spVar.call();
        int iVe = hVarC2.ve();
        if (this.c && iVe == 101) {
            hVarC = hVarC2.i().c(com.byazt.kh.ve.ve).c();
        } else {
            hVarC = hVarC2.i().c(veVarSp.c(hVarC2)).c();
        }
        if ("close".equalsIgnoreCase(hVarC.c().c("Connection")) || "close".equalsIgnoreCase(hVarC.c("Connection"))) {
            spVarA.uj();
        }
        if ((iVe == 204 || iVe == 205) && hVarC.x().tt() > 0) {
            throw new ProtocolException("HTTP " + iVe + " had non-zero Content-Length: " + hVarC.x().tt());
        }
        return hVarC;
    }

    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF, MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY})
    static final class c extends com.byazt.mk.sp {
        public long c;

        public c(rh rhVar) {
            super(rhVar);
        }

        @Override // com.byazt.mk.sp, com.byazt.mk.rh
        public void a_(com.byazt.mk.ve veVar, long j) throws IOException {
            super.a_(veVar, j);
            this.c += j;
        }
    }
}
