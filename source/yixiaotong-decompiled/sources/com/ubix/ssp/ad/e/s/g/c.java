package com.ubix.ssp.ad.e.s.g;

import com.ubix.ssp.open.comm.DownloadService;
import java.io.Serializable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class c implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f8857a;
    private a b;
    private int c;
    private boolean d = true;
    private DownloadService.DownloadBinder e;

    public DownloadService.DownloadBinder a() {
        return this.e;
    }

    public void a(int i) {
        this.c = i;
    }

    public void a(a aVar) {
        this.b = aVar;
    }

    public void a(DownloadService.DownloadBinder downloadBinder) {
        this.e = downloadBinder;
    }

    public a b() {
        return this.b;
    }

    public void b(int i) {
        this.f8857a = i;
    }

    public int c() {
        return this.c;
    }

    public boolean d() {
        return this.d;
    }

    public String toString() {
        return "RequestInfo{, downloadInfo=" + this.b + '}';
    }
}
