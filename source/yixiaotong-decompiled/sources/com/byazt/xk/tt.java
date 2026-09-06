package com.byazt.xk;

import com.byazt.nn.a;
import com.byazt.s.da;
import com.byazt.s.sl;
import com.byazt.t.DownloadInfo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_HTTP_REQ_FINSIH_TIME, 13})
public class tt implements sl {
    @Override // com.byazt.s.sl
    public void c(DownloadInfo downloadInfo, da daVar) {
        com.byazt.dd.tt ttVarC;
        if (downloadInfo != null && (ttVarC = a.c().c(downloadInfo)) != null) {
            downloadInfo.setLinkMode(ttVarC.ic());
        }
        if (daVar != null) {
            daVar.c();
        }
    }
}
