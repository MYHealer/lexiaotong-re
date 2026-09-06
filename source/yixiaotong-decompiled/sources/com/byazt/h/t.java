package com.byazt.h;

import com.byazt.m.BaseException;
import com.byazt.t.DownloadInfo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_TCP_FAST_OPEN_SUCCESS, 66})
public class t implements n {
    public final i c;
    public final com.byazt.t.n tt;
    public final n ve;

    public n c() {
        return this.ve;
    }

    public i n() {
        return this.c;
    }

    public t(DownloadInfo downloadInfo, tt ttVar, i iVar) throws BaseException {
        this.c = iVar;
        this.tt = c(downloadInfo, iVar);
        this.ve = new x(ttVar, this);
    }

    @Override // com.byazt.h.n
    public void tt(c cVar) throws IOException {
        this.tt.c(cVar.c, 0, cVar.ve);
        this.c.tt(cVar.ve);
    }

    public void tt() throws IOException {
        this.tt.tt();
    }

    public void ve() throws IOException {
        this.tt.ve();
    }

    public void uj() {
        com.byazt.w.a.c(this.tt);
    }

    private com.byazt.t.n c(DownloadInfo downloadInfo, i iVar) throws BaseException {
        com.byazt.t.n nVarC = com.byazt.w.a.c(downloadInfo, downloadInfo.getTempPath(), downloadInfo.getTempName(), com.byazt.k.c.c(downloadInfo.getId()).c("flush_buffer_size_byte", -1));
        try {
            nVarC.c(iVar.n());
            return nVarC;
        } catch (IOException e) {
            throw new BaseException(1054, e);
        }
    }
}
