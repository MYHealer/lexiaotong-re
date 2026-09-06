package com.byazt.nys;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.io.File;
import java.util.List;
import java.util.function.Function;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 430, 54})
public class ve {
    public static final String c = File.separator + "next";
    public static final String tt = File.separator + "tmp";
    public static volatile ve ve;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public x.c f2543a;
    public final Function<SparseArray<Object>, Object> n = new i.ve();
    public volatile boolean sp;
    public final Context uj;

    private ve(Context context) {
        this.uj = context;
    }

    public static ve c(Context context) {
        if (ve == null) {
            synchronized (ve.class) {
                if (ve == null) {
                    ve = new ve(context);
                }
            }
        }
        return ve;
    }

    public void c(List<x.c> list) {
        if (list == null || list.isEmpty()) {
            n.c("plugin_download", "plugin is empty");
            return;
        }
        x.c cVar = list.get(0);
        this.f2543a = cVar;
        if (TextUtils.isEmpty(cVar.ve)) {
            return;
        }
        String str = this.f2543a.c + com.huawei.openalliance.ad.constant.x.A + this.f2543a.tt + com.huawei.openalliance.ad.constant.x.A + this.f2543a.f2544a + com.huawei.openalliance.ad.constant.x.A + this.f2543a.sp + ".apk";
        File fileVe = ve();
        File file = new File(fileVe, str);
        if (file.exists()) {
            n.c("plugin_download", "plugin file already exists");
            com.byazt.bog.a.tt("FileDownloadTask", "Plugin file already exists.");
            this.f2543a.i = file.getAbsolutePath();
            x.c cVar2 = this.f2543a;
            cVar2.da = cVar2.tt < 7611;
            c(true, this.f2543a.c, this.f2543a.toString());
            return;
        }
        File fileTt = tt();
        if (!fileVe.exists()) {
            fileVe.mkdirs();
        }
        if (!fileTt.exists()) {
            fileTt.mkdirs();
        }
        c(this.f2543a.ve, fileVe.getAbsolutePath(), fileTt.getAbsolutePath(), str);
    }

    private void c(String str, String str2, String str3, String str4) {
        if (this.sp) {
            com.byazt.bog.a.tt("FileDownloadTask", "Downloading...");
            return;
        }
        this.sp = true;
        try {
            File file = new File(str2 + "/" + str4);
            if (file.exists()) {
                file.delete();
            }
            com.byazt.uc.ve.c().c(str, str2, str4, new EventListener() { // from class: com.byazt.nys.ve.1
                @Override // com.bykv.vk.openvk.api.proto.EventListener
                public ValueSet onEvent(int i, Result result) {
                    ve.this.sp = false;
                    if (i == 0) {
                        n.c("plugin_download", "download success");
                        ve.this.f2543a.i = result.message();
                        com.byazt.bog.a.tt("FileDownloadTask", "Download end." + ve.this.f2543a.i);
                        ve.this.f2543a.da = ve.this.f2543a.tt < 7611;
                        ve veVar = ve.this;
                        veVar.c(true, veVar.f2543a.c, ve.this.f2543a.toString());
                        return null;
                    }
                    String strMessage = result.message();
                    n.c("plugin_download", "download failed: ".concat(String.valueOf(strMessage)));
                    com.byazt.bog.a.n("FileDownloadTask", "Download failed. ".concat(String.valueOf(strMessage)));
                    ve veVar2 = ve.this;
                    veVar2.c(false, veVar2.f2543a.c, ve.this.f2543a.toString());
                    return null;
                }
            });
            n.c("plugin_download", "start download");
            com.byazt.bog.a.tt("FileDownloadTask", "Download start.");
        } catch (Throwable th) {
            n.c("plugin_download", "download error: ".concat(String.valueOf(th)));
            com.byazt.bog.a.n("FileDownloadTask", "Download file error: ".concat(String.valueOf(th)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, String str, String str2) {
        ValueSet valueSetTt = com.byazt.rl.ve.c().c(-999900, z ? 0 : 1004).c(-999903, z).c(-999902, com.byazt.rl.ve.c().c(2, str2).c(3, str).tt().sparseArray()).tt();
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 1);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(-99999979, valueSetTt.sparseArray());
        this.n.apply(sparseArray);
    }

    private File c() {
        return tt.c(this.uj, "tt_pangle_bykv_file", 0);
    }

    private File tt() {
        return new File(c(), tt);
    }

    private File ve() {
        return new File(c(), c);
    }
}
