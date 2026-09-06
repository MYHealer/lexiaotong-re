package com.byazt.gq;

import com.byazt.b.rh;
import com.byazt.nr.m;
import com.byazt.t.DownloadInfo;
import com.byazt.zz.Downloader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 52, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class z {
    public static com.byazt.de.uj c;
    public static com.byazt.de.ve tt;

    public static com.byazt.de.uj c() {
        return c;
    }

    public static void c(com.byazt.de.uj ujVar) {
        c = ujVar;
    }

    public static void c(com.byazt.de.ve veVar) {
        tt = veVar;
    }

    public static boolean c(int i) {
        return i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 7 || i == 8;
    }

    public static com.byazt.de.ve tt() {
        return tt;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public static boolean c(final com.byazt.dd.tt ttVar, DownloadInfo downloadInfo, int i, final com.byazt.tg.x xVar, final boolean z, final com.byazt.de.ve veVar) {
        ?? Tt;
        if (ttVar == null) {
            com.byazt.dm.ve.c().c("tryReverseWifi nativeModel null");
            return false;
        }
        if (downloadInfo == null) {
            com.byazt.dm.ve.c().c("tryReverseWifi info null");
            return false;
        }
        final int id = downloadInfo.getId();
        if (z) {
            Tt = com.byazt.hu.n.ve((com.byazt.dd.c) ttVar);
        } else {
            Tt = com.byazt.hu.n.tt((com.byazt.dd.c) ttVar);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("switch_status", Integer.valueOf((int) Tt));
        } catch (Exception e) {
            m.c(e);
        }
        if (z) {
            com.byazt.zn.c.c().c("cancel_pause_reserve_wifi_switch_status", jSONObject, ttVar);
        } else {
            com.byazt.zn.c.c().c("pause_reserve_wifi_switch_status", jSONObject, ttVar);
        }
        if (Tt == 0 || !c(i) || com.byazt.w.a.tt(t.getContext())) {
            return false;
        }
        if (!z && downloadInfo.hasPauseReservedOnWifi()) {
            return false;
        }
        c(new com.byazt.de.uj() { // from class: com.byazt.gq.z.1
            @Override // com.byazt.de.uj
            public void c() {
                z.c((com.byazt.de.uj) null);
                DownloadInfo downloadInfo2 = Downloader.getInstance(t.getContext()).getDownloadInfo(id);
                if (downloadInfo2 != null) {
                    downloadInfo2.startPauseReserveOnWifi();
                    rh.c().c(downloadInfo2);
                    if (z) {
                        com.byazt.zn.c.c().c("cancel_pause_reserve_wifi_confirm", ttVar);
                    } else {
                        com.byazt.zn.c.c().tt("pause_reserve_wifi_confirm", ttVar);
                    }
                }
                xVar.c(ttVar);
            }

            @Override // com.byazt.de.uj
            public void tt() {
                z.c((com.byazt.de.uj) null);
                DownloadInfo downloadInfo2 = Downloader.getInstance(t.getContext()).getDownloadInfo(id);
                if (downloadInfo2 != null) {
                    downloadInfo2.stopPauseReserveOnWifi();
                }
                if (z) {
                    com.byazt.zn.c.c().c("cancel_pause_reserve_wifi_cancel", ttVar);
                } else {
                    com.byazt.zn.c.c().tt("pause_reserve_wifi_cancel", ttVar);
                }
                xVar.c(ttVar);
            }
        });
        if (z && veVar != null) {
            c(new com.byazt.de.ve() { // from class: com.byazt.gq.z.2
                @Override // com.byazt.de.ve
                public void delete() {
                    com.byazt.zn.c.c().c("cancel_pause_reserve_wifi_delete", ttVar);
                    veVar.delete();
                }
            });
        }
        if (z) {
            TTDelegateActivity.c(ttVar, "删除");
        } else {
            TTDelegateActivity.tt(ttVar);
        }
        return true;
    }
}
