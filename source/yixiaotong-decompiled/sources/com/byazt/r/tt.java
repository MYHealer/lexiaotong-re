package com.byazt.r;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.byazt.nr.m;
import com.byazt.s.x;
import com.byazt.t.DownloadInfo;
import com.byazt.w.a;
import com.byazt.z.uj;
import com.byazt.z.ve;
import com.byazt.zz.Downloader;
import com.byazt.zz.rh;
import com.byazt.zz.t;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 957, 13})
public class tt implements t {
    public List<Integer> c;
    public BroadcastReceiver tt;

    @Override // com.byazt.zz.t
    public List<String> c() {
        return ve.ve();
    }

    @Override // com.byazt.zz.t
    public void c(final List<DownloadInfo> list, final int i) {
        if (a.uj()) {
            com.byazt.zz.ve.t().execute(new Runnable() { // from class: com.byazt.r.tt.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        tt.this.tt(list, i);
                    } catch (Exception e) {
                        m.c(e);
                    }
                }
            });
        } else {
            tt(list, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tt(List<DownloadInfo> list, int i) {
        if (list == null || list.isEmpty()) {
            return;
        }
        uj.sl();
        Context contextIc = com.byazt.zz.ve.ic();
        if (contextIc == null) {
            return;
        }
        boolean zTt = a.tt(contextIc);
        Iterator<DownloadInfo> it = list.iterator();
        while (it.hasNext()) {
            c(contextIc, it.next(), zTt, i);
        }
        List<Integer> list2 = this.c;
        if (list2 == null || list2.isEmpty() || this.tt != null) {
            return;
        }
        this.tt = new BroadcastReceiver() { // from class: com.byazt.r.tt.2
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                final Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
                if (a.tt(origApplicationContext)) {
                    com.byazt.x.c.tt("LaunchResume", "onReceive : wifi connected !!!");
                    com.byazt.zz.ve.t().execute(new Runnable() { // from class: com.byazt.r.tt.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                if (tt.this.c != null && !tt.this.c.isEmpty()) {
                                    int size = tt.this.c.size();
                                    Integer[] numArr = new Integer[size];
                                    tt.this.c.toArray(numArr);
                                    tt.this.c.clear();
                                    for (int i2 = 0; i2 < size; i2++) {
                                        DownloadInfo downloadInfo = Downloader.getInstance(origApplicationContext).getDownloadInfo(numArr[i2].intValue());
                                        if (downloadInfo != null && (downloadInfo.getRealStatus() == -5 || (downloadInfo.getRealStatus() == -2 && downloadInfo.isPauseReserveOnWifi()))) {
                                            tt.this.c(origApplicationContext, downloadInfo, true, 2);
                                        }
                                    }
                                }
                            } catch (Exception e) {
                                m.c(e);
                            }
                        }
                    });
                    try {
                        origApplicationContext.unregisterReceiver(tt.this.tt);
                    } catch (Throwable th) {
                        m.c(th);
                    }
                    tt.this.tt = null;
                }
            }
        };
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            contextIc.registerReceiver(this.tt, intentFilter);
        } catch (Throwable th) {
            m.c(th);
            this.tt = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Context context, DownloadInfo downloadInfo, boolean z, int i) {
        boolean z2;
        if (downloadInfo == null || !downloadInfo.isShowNotification()) {
            return;
        }
        int realStatus = downloadInfo.getRealStatus();
        if (realStatus == -5 && ("application/ttpatch".equalsIgnoreCase(downloadInfo.getMimeType()) || !downloadInfo.isDownloaded())) {
            com.byazt.k.c cVarC = com.byazt.k.c.c(downloadInfo.getId());
            int iC = cVarC.c("failed_resume_max_count", 0);
            double dC = cVarC.c("failed_resume_max_hours", 72.0d);
            double dC2 = cVarC.c("failed_resume_min_hours", 12.0d);
            long jCurrentTimeMillis = System.currentTimeMillis();
            boolean z3 = (downloadInfo.isPauseReserveOnWifi() && z) ? true : downloadInfo.getFailedResumeCount() < iC && ((double) (jCurrentTimeMillis - downloadInfo.getLastDownloadTime())) < dC * 3600000.0d && ((double) (jCurrentTimeMillis - downloadInfo.getLastFailedResumeTime())) > dC2 * 3600000.0d;
            if (z3) {
                boolean z4 = cVarC.c("failed_resume_need_wifi", 1) == 1;
                boolean z5 = cVarC.c("failed_resume_need_wait_wifi", 0) == 1;
                if (z || !z4 || !z5) {
                    ve.c(downloadInfo, true, z4);
                    downloadInfo.setLastFailedResumeTime(jCurrentTimeMillis);
                    downloadInfo.setFailedResumeCount(downloadInfo.getFailedResumeCount() + 1);
                    downloadInfo.updateSpData();
                    if (downloadInfo.isPauseReserveOnWifi() && z) {
                        downloadInfo.setDownloadFromReserveWifi(true);
                        rh rhVarZ = uj.sl().z();
                        if (rhVarZ != null) {
                            rhVarZ.c(downloadInfo, 5, i);
                        }
                    }
                    z2 = true;
                } else {
                    if (this.c == null) {
                        this.c = new ArrayList();
                    }
                    int id = downloadInfo.getId();
                    if (!this.c.contains(Integer.valueOf(id))) {
                        this.c.add(Integer.valueOf(id));
                    }
                    downloadInfo.setOnlyWifi(true);
                    com.byazt.b.rh.c().c(downloadInfo);
                    z2 = false;
                }
            } else {
                z2 = false;
            }
            com.byazt.x.c.ve("LaunchResume", "launchResume, name = " + downloadInfo.getTitle() + ", canShowNotification = " + z3 + ", downloadResumed = " + z2);
            x xVarYp = uj.sl().yp();
            if (xVarYp != null) {
                xVarYp.c(downloadInfo, z2);
                return;
            }
            return;
        }
        if (realStatus == -3 && c(downloadInfo)) {
            com.byazt.k.c cVarC2 = com.byazt.k.c.c(downloadInfo.getId());
            if (ve.c(context, downloadInfo)) {
                return;
            }
            int iC2 = cVarC2.c("uninstall_resume_max_count", 0);
            double dC3 = cVarC2.c("uninstall_resume_max_hours", 72.0d);
            double dC4 = cVarC2.c("uninstall_resume_min_hours", 12.0d);
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            boolean z6 = downloadInfo.getUninstallResumeCount() < iC2 && ((double) (jCurrentTimeMillis2 - downloadInfo.getLastDownloadTime())) < dC3 * 3600000.0d && ((double) (jCurrentTimeMillis2 - downloadInfo.getLastUninstallResumeTime())) > dC4 * 3600000.0d;
            com.byazt.x.c.ve("LaunchResume", "uninstallResume, name = " + downloadInfo.getTitle() + ", canShowNotification = " + z6);
            if (z6) {
                com.byazt.n.c cVarN = com.byazt.n.tt.c().n(downloadInfo.getId());
                if (cVarN == null) {
                    cVarN = new com.byazt.p.c(context, downloadInfo.getId(), downloadInfo.getTitle(), downloadInfo.getSavePath(), downloadInfo.getName(), downloadInfo.getExtra());
                    com.byazt.n.tt.c().c(cVarN);
                } else {
                    cVarN.c(downloadInfo);
                }
                cVarN.tt(downloadInfo.getTotalBytes());
                cVarN.c(downloadInfo.getTotalBytes());
                cVarN.c(downloadInfo.getStatus(), null, false, false);
                downloadInfo.setLastUninstallResumeTime(jCurrentTimeMillis2);
                downloadInfo.setUninstallResumeCount(downloadInfo.getUninstallResumeCount() + 1);
                downloadInfo.updateSpData();
                return;
            }
            return;
        }
        if (realStatus == -2) {
            if (downloadInfo.isPauseReserveOnWifi()) {
                if (z) {
                    ve.c(downloadInfo, true, true);
                    downloadInfo.updateSpData();
                    downloadInfo.setDownloadFromReserveWifi(true);
                    x xVarYp2 = uj.sl().yp();
                    if (xVarYp2 != null) {
                        xVarYp2.c(downloadInfo, true);
                    }
                    rh rhVarZ2 = uj.sl().z();
                    if (rhVarZ2 != null) {
                        rhVarZ2.c(downloadInfo, 5, i);
                        return;
                    }
                    return;
                }
                if (this.c == null) {
                    this.c = new ArrayList();
                }
                int id2 = downloadInfo.getId();
                if (!this.c.contains(Integer.valueOf(id2))) {
                    this.c.add(Integer.valueOf(id2));
                }
                com.byazt.b.rh.c().c(downloadInfo);
            }
            c(downloadInfo, context);
        }
    }

    private void c(DownloadInfo downloadInfo, Context context) {
        com.byazt.k.c cVarC = com.byazt.k.c.c(downloadInfo.getId());
        int iC = cVarC.c("paused_resume_max_count", 0);
        double dC = cVarC.c("paused_resume_max_hours", 72.0d);
        int pausedResumeCount = downloadInfo.getPausedResumeCount();
        if (pausedResumeCount >= iC || System.currentTimeMillis() - downloadInfo.getLastDownloadTime() >= dC * 3600000.0d) {
            return;
        }
        com.byazt.n.c cVarN = com.byazt.n.tt.c().n(downloadInfo.getId());
        if (cVarN == null) {
            cVarN = new com.byazt.p.c(context, downloadInfo.getId(), downloadInfo.getTitle(), downloadInfo.getSavePath(), downloadInfo.getName(), downloadInfo.getExtra());
            com.byazt.n.tt.c().c(cVarN);
        } else {
            cVarN.c(downloadInfo);
        }
        cVarN.tt(downloadInfo.getTotalBytes());
        cVarN.c(downloadInfo.getCurBytes());
        cVarN.c(downloadInfo.getStatus(), null, false, false);
        downloadInfo.setPausedResumeCount(pausedResumeCount + 1);
        downloadInfo.updateSpData();
    }

    private boolean c(DownloadInfo downloadInfo) {
        if (com.byazt.k.c.c(downloadInfo.getId()).tt("uninstall_can_not_resume_for_force_task", false)) {
            return a.c(downloadInfo, false, downloadInfo.getMd5());
        }
        return downloadInfo.isDownloaded();
    }
}
