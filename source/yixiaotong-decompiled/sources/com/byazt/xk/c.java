package com.byazt.xk;

import com.byazt.nn.a;
import com.byazt.s.da;
import com.byazt.s.sl;
import com.byazt.t.DownloadInfo;
import com.byazt.us.i;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.ss.android.downloadlib.activity.TTDelegateActivity;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_HTTP_REQ_FINSIH_TIME, 20})
public class c implements sl {
    @Override // com.byazt.s.sl
    public void c(DownloadInfo downloadInfo, final da daVar) {
        c(downloadInfo, new com.byazt.ok.c() { // from class: com.byazt.xk.c.1
            @Override // com.byazt.ok.c
            public void c() {
                daVar.c();
            }
        });
    }

    public void c(final DownloadInfo downloadInfo, final com.byazt.ok.c cVar) {
        com.byazt.dd.tt ttVarC = a.c().c(downloadInfo);
        if (ttVarC != null && i.c(ttVarC)) {
            TTDelegateActivity.c(ttVarC, new com.byazt.ok.c() { // from class: com.byazt.xk.c.2
                @Override // com.byazt.ok.c
                public void c() {
                    c.this.tt(downloadInfo, cVar);
                }
            });
        } else {
            tt(downloadInfo, cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tt(DownloadInfo downloadInfo, final com.byazt.ok.c cVar) {
        com.byazt.dd.tt ttVarC = a.c().c(downloadInfo);
        boolean zC = com.byazt.us.a.c(ttVarC);
        boolean zTt = com.byazt.us.a.tt(ttVarC);
        if (!zC || !zTt) {
            cVar.c();
        } else {
            com.byazt.us.ve.c(ttVarC, new com.byazt.ok.c() { // from class: com.byazt.xk.c.3
                @Override // com.byazt.ok.c
                public void c() {
                    cVar.c();
                }
            });
        }
    }
}
