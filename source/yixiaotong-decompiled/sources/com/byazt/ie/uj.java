package com.byazt.ie;

import android.text.TextUtils;
import com.byazt.gq.t;
import com.byazt.nr.m;
import com.byazt.t.DownloadInfo;
import com.byazt.zz.Downloader;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
@com.byazt.zqa.c(c = {0, 1, 1041, 15})
public class uj {
    public static volatile uj c;
    public long tt = 0;
    public ConcurrentHashMap<String, n> ve = new ConcurrentHashMap<>();
    public HashMap<String, Integer> uj = new HashMap<>();
    public List<String> n = new CopyOnWriteArrayList();

    public long tt() {
        return this.tt;
    }

    public static uj c() {
        if (c == null) {
            synchronized (uj.class) {
                if (c == null) {
                    c = new uj();
                }
            }
        }
        return c;
    }

    public void c(String str, n nVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.ve.put(str, nVar);
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.ve.remove(str);
    }

    public void ve() {
        this.tt = System.currentTimeMillis();
    }

    public int tt(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if (this.uj == null) {
            this.uj = new HashMap<>();
        }
        if (this.uj.containsKey(str)) {
            return this.uj.get(str).intValue();
        }
        return 0;
    }

    public static void c(com.byazt.dd.tt ttVar) {
        DownloadInfo downloadInfo;
        if (ttVar == null || ttVar.tt() <= 0 || (downloadInfo = Downloader.getInstance(t.getContext()).getDownloadInfo(ttVar.my())) == null) {
            return;
        }
        c(downloadInfo);
    }

    public static void c(DownloadInfo downloadInfo) {
        if (downloadInfo == null || com.byazt.k.c.c(downloadInfo.getId()).c("delete_file_after_install", 0) == 0) {
            return;
        }
        try {
            String str = downloadInfo.getSavePath() + File.separator + downloadInfo.getName();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            File file = new File(str);
            if (file.isFile() && file.exists()) {
                file.delete();
            }
        } catch (Exception e) {
            m.c(e);
        }
    }
}
