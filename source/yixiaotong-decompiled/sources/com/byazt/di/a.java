package com.byazt.di;

import android.text.TextUtils;
import com.byazt.c.eo;
import com.byazt.gq.t;
import com.byazt.nr.m;
import com.byazt.ou.gt;
import com.byazt.ou.qy;
import com.byazt.ou.rh;
import com.byazt.ou.sl;
import com.byazt.ou.u;
import com.byazt.t.DownloadInfo;
import com.byazt.z.DownloadHandlerService;
import com.byazt.zz.Downloader;
import com.byazt.zz.DownloaderBuilder;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DROP_AUDIO_PTS, 34})
public class a implements com.byazt.d.c {
    @Override // com.byazt.d.c
    public com.byazt.d.c c(com.byazt.ou.i iVar) {
        t.c(iVar);
        return this;
    }

    @Override // com.byazt.d.c
    public com.byazt.d.c c(com.byazt.ou.sp spVar) {
        t.c(spVar);
        return this;
    }

    @Override // com.byazt.d.c
    public com.byazt.d.c c(u uVar) {
        t.c(uVar);
        return this;
    }

    @Override // com.byazt.d.c
    public com.byazt.d.c c(com.byazt.ou.x xVar) {
        t.c(xVar);
        return this;
    }

    @Override // com.byazt.d.c
    public com.byazt.d.c c(com.byazt.ou.ve veVar) {
        t.c(veVar);
        return this;
    }

    @Override // com.byazt.d.c
    public com.byazt.d.c c(sl slVar) {
        t.c(slVar);
        return this;
    }

    @Override // com.byazt.d.c
    public com.byazt.d.c c(com.byazt.e.c cVar) {
        t.c(cVar);
        return this;
    }

    @Override // com.byazt.d.c
    public com.byazt.d.c c(String str) {
        t.c(str);
        return this;
    }

    @Override // com.byazt.d.c
    public com.byazt.d.c c(com.byazt.s.ve veVar) {
        t.c(veVar);
        return this;
    }

    @Override // com.byazt.d.c
    public com.byazt.d.c c(final com.byazt.ou.tt ttVar) {
        t.c(ttVar);
        com.byazt.g.c.c().c(new com.byazt.g.c.ve() { // from class: com.byazt.di.a.1
        });
        return this;
    }

    @Override // com.byazt.d.c
    public com.byazt.d.c c(DownloaderBuilder downloaderBuilder) {
        if (downloaderBuilder.getNotificationClickCallback() == null) {
            downloaderBuilder.notificationClickCallback(new eo() { // from class: com.byazt.di.a.2
                @Override // com.byazt.c.eo
                public boolean tt(DownloadInfo downloadInfo) {
                    return false;
                }

                @Override // com.byazt.c.eo
                public boolean c(DownloadInfo downloadInfo) {
                    com.byazt.k.c cVarC = com.byazt.k.c.c(downloadInfo.getId());
                    if (cVarC.tt("notification_opt_2") == 1) {
                        if (downloadInfo.getStatus() == -2) {
                            DownloadHandlerService.c(t.getContext(), downloadInfo, com.byazt.z.uj.sl().ve(), Downloader.getInstance(t.getContext()).getDownloadNotificationEventListener(downloadInfo.getId()));
                        }
                        return true;
                    }
                    boolean zUj = uj(downloadInfo);
                    if (cVarC.c("disable_delete_dialog", 0) == 1) {
                        return true;
                    }
                    return zUj;
                }

                private boolean uj(DownloadInfo downloadInfo) {
                    String strC;
                    qy qyVarMy = t.my();
                    if (qyVarMy == null) {
                        return false;
                    }
                    com.byazt.dd.tt ttVarC = com.byazt.nn.a.c().c(downloadInfo);
                    if (ttVarC != null && ttVarC.ve()) {
                        strC = com.byazt.k.c.c(downloadInfo.getId()).c("ad_notification_jump_url", (String) null);
                    } else {
                        strC = com.byazt.gq.i.c(downloadInfo);
                    }
                    if (TextUtils.isEmpty(strC)) {
                        return false;
                    }
                    return qyVarMy.c(t.getContext(), strC);
                }

                @Override // com.byazt.c.eo
                public boolean ve(DownloadInfo downloadInfo) {
                    if (downloadInfo == null) {
                        return false;
                    }
                    com.byazt.dd.tt ttVarC = com.byazt.nn.a.c().c(downloadInfo);
                    if (ttVarC != null) {
                        com.byazt.us.c.c(ttVarC);
                    } else {
                        com.byazt.hu.i.tt(t.getContext(), downloadInfo.getPackageName());
                    }
                    com.byazt.n.tt.c().a(downloadInfo.getId());
                    return true;
                }
            });
        }
        downloaderBuilder.addDownloadCompleteHandler(new com.byazt.sd.ve());
        Downloader.initOrCover(downloaderBuilder, true);
        return this;
    }

    @Override // com.byazt.d.c
    public com.byazt.d.c c(com.byazt.s.sp spVar) {
        com.byazt.z.uj.sl().c(spVar);
        return this;
    }

    @Override // com.byazt.d.c
    public com.byazt.d.c c(rh rhVar) {
        t.c(rhVar);
        return this;
    }

    @Override // com.byazt.d.c
    public com.byazt.d.c c(gt gtVar) {
        t.c(gtVar);
        return this;
    }

    @Override // com.byazt.d.c
    public com.byazt.d.c c(com.byazt.ou.da daVar) {
        t.c(daVar);
        return this;
    }

    @Override // com.byazt.d.c
    public void c() {
        if (!t.gr()) {
            com.byazt.dm.ve.c().c("ttdownloader init error");
        }
        t.c(com.byazt.dm.ve.c());
        try {
            com.byazt.z.uj.sl().tt(t.gu());
        } catch (Exception e) {
            m.c(e);
        }
        com.byazt.z.uj.sl().c(c.c());
        n.c().tt(new Runnable() { // from class: com.byazt.di.a.3
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.i.n.c("");
                if (com.byazt.i.n.z()) {
                    com.byazt.zz.ve.c(true);
                }
                if (com.byazt.k.c.ve().c("disable_security_init", 1) == 1) {
                    com.byazt.i.a.c(t.getContext());
                }
            }
        });
    }
}
