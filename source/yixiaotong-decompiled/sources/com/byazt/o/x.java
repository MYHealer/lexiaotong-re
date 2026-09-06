package com.byazt.o;

import com.byazt.nr.m;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.huawei.openalliance.ad.views.PPSLabelView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_START_TIME, 71})
public class x extends Exception {
    public Throwable c;
    public int tt;
    public int ve;

    public x(String str, sp spVar, Throwable th) {
        super((str == null ? "" : str + PPSLabelView.Code) + (spVar == null ? "" : "(position:" + spVar.uj() + ") ") + (th != null ? "caused by: " + th : ""));
        this.tt = -1;
        this.ve = -1;
        if (spVar != null) {
            this.tt = spVar.ve();
            this.ve = spVar.a();
        }
        this.c = th;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        if (this.c == null) {
            super.printStackTrace();
            return;
        }
        synchronized (System.err) {
            System.err.println(super.getMessage() + "; nested exception is:");
            m.c(this.c);
        }
    }
}
