package com.byazt.di;

import android.content.SharedPreferences;
import android.util.SparseArray;
import com.byazt.gq.t;
import com.byazt.hu.u;
import com.byazt.nr.m;
import com.byazt.t.DownloadInfo;
import com.byazt.zz.Downloader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DROP_AUDIO_PTS, 46})
public class n {
    public ExecutorService c;
    public ExecutorService tt;
    public ExecutorService uj;
    public ScheduledExecutorService ve;

    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DROP_AUDIO_PTS, 151})
    private static class c {
        public static n c = new n();
    }

    public static n c() {
        return c.c;
    }

    private n() {
    }

    public void c(Runnable runnable) {
        c(runnable, false);
    }

    public void tt(Runnable runnable) {
        tt(runnable, false);
    }

    public void c(Runnable runnable, boolean z) {
        if (runnable == null) {
            return;
        }
        if (z && !u.tt()) {
            runnable.run();
        } else {
            tt().execute(runnable);
        }
    }

    public void ve(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        n().execute(runnable);
    }

    public void tt(Runnable runnable, boolean z) {
        if (runnable == null) {
            return;
        }
        if (z && !u.tt()) {
            runnable.run();
        } else {
            ve().execute(runnable);
        }
    }

    public void c(Runnable runnable, long j) {
        try {
            uj().schedule(runnable, j, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            m.c(th);
        }
    }

    public ExecutorService tt() {
        if (this.c == null) {
            synchronized (n.class) {
                if (this.c == null) {
                    this.c = new com.byazt.jtc.uj(0, Integer.MAX_VALUE, 30L, TimeUnit.SECONDS, new SynchronousQueue(), new com.byazt.u.c(da.class.getName() + "-CPUThreadPool"));
                }
            }
        }
        return this.c;
    }

    public ExecutorService ve() {
        if (this.tt == null) {
            synchronized (n.class) {
                if (this.tt == null) {
                    this.tt = new com.byazt.jtc.uj(0, Integer.MAX_VALUE, 30L, TimeUnit.SECONDS, new SynchronousQueue(), new com.byazt.u.c(da.class.getName() + "-IOThreadPool"));
                }
            }
        }
        return this.tt;
    }

    public ScheduledExecutorService uj() {
        if (this.ve == null) {
            synchronized (n.class) {
                if (this.ve == null) {
                    this.ve = new com.byazt.jtc.n(0, new com.byazt.u.c(da.class.getName() + "-ScheduledThreadPool"));
                }
            }
        }
        return this.ve;
    }

    public ExecutorService n() {
        if (this.uj == null) {
            synchronized (n.class) {
                if (this.uj == null) {
                    this.uj = new com.byazt.jtc.uj(5, Integer.MAX_VALUE, 30L, TimeUnit.SECONDS, new SynchronousQueue(), new com.byazt.u.c(da.class.getName() + "-InstallFinishCheckCPUThreadPool"));
                }
            }
        }
        return this.uj;
    }

    public void a() {
        c(new Runnable() { // from class: com.byazt.di.n.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (n.class) {
                    try {
                        try {
                            String[] strArr = {"sp_ad_download_event", "sp_download_finish_cache", "sp_delay_operation_info", "sp_ttdownloader_md5", "sp_name_installed_app", "misc_config", "sp_ad_install_back_dialog", "sp_ttdownloader_clean", "sp_order_download", "sp_a_b_c", "sp_ah_config", "sp_download_info", "sp_appdownloader"};
                            for (int i = 0; i < 13; i++) {
                                SharedPreferences kVStore = com.byazt.ut.a.getKVStore(t.getContext(), strArr[i], 0);
                                if (kVStore != null) {
                                    kVStore.edit().clear().apply();
                                }
                            }
                            com.byazt.zz.da daVarZm = com.byazt.zz.ve.zm();
                            if (!(daVarZm instanceof com.byazt.b.uj)) {
                                return;
                            }
                            SparseArray<DownloadInfo> sparseArrayC = ((com.byazt.b.uj) daVarZm).c().c();
                            for (int size = sparseArrayC.size() - 1; size >= 0; size--) {
                                DownloadInfo downloadInfo = sparseArrayC.get(sparseArrayC.keyAt(size));
                                if (downloadInfo != null) {
                                    Downloader.getInstance(t.getContext()).clearDownloadData(downloadInfo.getId());
                                }
                            }
                        } catch (Throwable unused) {
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        });
    }
}
