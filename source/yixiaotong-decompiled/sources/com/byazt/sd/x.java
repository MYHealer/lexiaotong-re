package com.byazt.sd;

import com.byazt.gq.t;
import com.byazt.hu.u;
import com.byazt.m.BaseException;
import com.byazt.t.DownloadInfo;
import com.byazt.zz.Downloader;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 470, 71})
public class x {

    @com.byazt.zqa.c(c = {0, 1, 470, 62})
    private static class c {
        public static x c = new x();
    }

    public static x c() {
        return c.c;
    }

    private x() {
    }

    public void c(com.byazt.dd.tt ttVar) {
        tt(ttVar, 5L);
    }

    public void tt(com.byazt.dd.tt ttVar) {
        if (ttVar == null) {
            return;
        }
        tt(ttVar, com.byazt.k.c.c(ttVar.my()).c("noti_continue_delay_secs", 5));
    }

    private void tt(final com.byazt.dd.tt ttVar, long j) {
        final int iMy = ttVar.my();
        if (com.byazt.k.c.c(iMy).tt("notification_opt_2") != 1) {
            return;
        }
        c(iMy);
        com.byazt.di.n.c().c(new Runnable() { // from class: com.byazt.sd.x.1
            @Override // java.lang.Runnable
            public void run() {
                DownloadInfo downloadInfo = Downloader.getInstance(t.getContext()).getDownloadInfo(iMy);
                JSONObject jSONObject = new JSONObject();
                u.c(jSONObject, "ttdownloader_type", (Object) 1);
                com.byazt.hu.a.ve(downloadInfo, jSONObject);
                if (downloadInfo != null && -2 == downloadInfo.getRealStatus() && !downloadInfo.isPauseReserveOnWifi()) {
                    x.this.c(iMy, ttVar, jSONObject);
                } else {
                    u.c(jSONObject, "error_code", (Object) 1001);
                }
                com.byazt.zn.c.c().tt("download_notification_try_show", jSONObject, ttVar);
            }
        }, j * 1000);
    }

    public void ve(com.byazt.dd.tt ttVar) {
        ve(ttVar, 5L);
    }

    public void uj(com.byazt.dd.tt ttVar) {
        ve(ttVar, com.byazt.k.c.c(ttVar.my()).c("noti_install_delay_secs", 5));
    }

    private void ve(final com.byazt.dd.tt ttVar, long j) {
        final int iMy = ttVar.my();
        if (com.byazt.k.c.c(iMy).tt("notification_opt_2") != 1) {
            return;
        }
        c(iMy);
        com.byazt.di.n.c().c(new Runnable() { // from class: com.byazt.sd.x.2
            @Override // java.lang.Runnable
            public void run() {
                DownloadInfo downloadInfo = Downloader.getInstance(t.getContext()).getDownloadInfo(iMy);
                JSONObject jSONObject = new JSONObject();
                u.c(jSONObject, "ttdownloader_type", (Object) 2);
                com.byazt.hu.a.ve(downloadInfo, jSONObject);
                if (!u.tt(ttVar)) {
                    x.this.c(iMy, ttVar, jSONObject);
                } else {
                    u.c(jSONObject, "error_code", (Object) 1002);
                }
                com.byazt.zn.c.c().tt("download_notification_try_show", jSONObject, ttVar);
            }
        }, j * 1000);
    }

    public void n(com.byazt.dd.tt ttVar) {
        c(ttVar, 5L);
    }

    public void a(com.byazt.dd.tt ttVar) {
        c(ttVar, com.byazt.k.c.c(ttVar.my()).c("noti_open_delay_secs", 5));
    }

    public void c(final com.byazt.dd.tt ttVar, long j) {
        final int iMy = ttVar.my();
        if (com.byazt.k.c.c(iMy).tt("notification_opt_2") != 1) {
            return;
        }
        c(iMy);
        com.byazt.di.n.c().c(new Runnable() { // from class: com.byazt.sd.x.3
            @Override // java.lang.Runnable
            public void run() {
                DownloadInfo downloadInfo = Downloader.getInstance(t.getContext()).getDownloadInfo(iMy);
                JSONObject jSONObject = new JSONObject();
                u.c(jSONObject, "ttdownloader_type", (Object) 3);
                com.byazt.hu.a.ve(downloadInfo, jSONObject);
                if (!u.ve(ttVar.n())) {
                    x.this.c(iMy, ttVar, jSONObject);
                } else {
                    u.c(jSONObject, "error_code", (Object) 1003);
                }
                com.byazt.zn.c.c().tt("download_notification_try_show", jSONObject, ttVar);
            }
        }, j * 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i, com.byazt.dd.tt ttVar, JSONObject jSONObject) {
        if (!com.byazt.p.uj.c()) {
            u.c(jSONObject, "error_code", (Object) 1004);
            return;
        }
        DownloadInfo downloadInfo = Downloader.getInstance(t.getContext()).getDownloadInfo(i);
        if (downloadInfo == null) {
            u.c(jSONObject, "error_code", (Object) 1005);
            return;
        }
        if (com.byazt.n.tt.c().n(i) != null) {
            com.byazt.n.tt.c().a(i);
        }
        com.byazt.p.c cVar = new com.byazt.p.c(t.getContext(), i, downloadInfo.getTitle(), downloadInfo.getSavePath(), downloadInfo.getName(), downloadInfo.getExtra());
        cVar.c(downloadInfo.getCurBytes());
        cVar.tt(downloadInfo.getTotalBytes());
        cVar.c(downloadInfo.getStatus(), null, false, false);
        com.byazt.n.tt.c().c(cVar);
        cVar.c((BaseException) null, false);
        com.byazt.zn.c.c().tt("download_notification_show", jSONObject, ttVar);
    }

    public void c(int i) {
        DownloadInfo downloadInfo;
        if (com.byazt.p.ve.c().c(i) != null || (downloadInfo = Downloader.getInstance(t.getContext()).getDownloadInfo(i)) == null) {
            return;
        }
        com.byazt.p.ve.c().c(i, downloadInfo.getIconUrl());
    }
}
