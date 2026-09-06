package com.huawei.openalliance.ad.download;

import android.content.Context;
import com.huawei.hms.ads.fh;
import com.huawei.openalliance.ad.download.DownloadTask;
import com.stub.StubApp;
import java.util.Iterator;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class b<T extends DownloadTask> {
    private static final String Z = "DownloadManager";
    protected Context Code;
    protected c<T> I;
    protected DownloadListener<T> V;

    public b(Context context) {
        this.Code = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    protected T Code(String str) {
        return (T) this.I.Code(str);
    }

    public void Code() {
        if (this.I == null) {
            this.I = new c<>();
        }
    }

    public void Code(DownloadListener<T> downloadListener) {
        this.V = downloadListener;
    }

    protected void Code(T t) {
        this.I.Code(t);
        if (fh.Code()) {
            fh.Code(Z, "addTask, task:%s, priority:%s", t.F(), Integer.valueOf(t.C()));
        }
    }

    public boolean I(T t) {
        if (t == null) {
            return false;
        }
        boolean zV = this.I.V(t);
        fh.V(Z, "removeTask, succ:" + zV);
        if (!zV) {
            return true;
        }
        Z(t);
        return true;
    }

    public void V() {
        fh.V(Z, "cancelAllDownload");
        Iterator<T> it = this.I.Code().iterator();
        while (it.hasNext()) {
            Z(it.next());
        }
        this.I.V();
    }

    public void V(T t) {
        if (t == null) {
            return;
        }
        fh.V(Z, "deleteTask, succ:%s, taskId:%s", Boolean.valueOf(this.I.V(t)), t.F());
    }

    protected void Z(T t) {
        if (t == null) {
            return;
        }
        if (fh.Code()) {
            fh.Code(Z, "onDownloadDeleted, taskId:%s", t.F());
        }
        DownloadListener<T> downloadListener = this.V;
        if (downloadListener != null) {
            downloadListener.onDownloadDeleted(t);
        }
    }
}
