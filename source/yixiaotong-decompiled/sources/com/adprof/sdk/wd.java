package com.adprof.sdk;

import com.adprof.sdk.api.AdRequest;
import java.io.Serializable;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class wd implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1499a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f793a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public AdRequest f794a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f795a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Map f796a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f797b;
    public int c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public String f798c;
    public int d;

    public wd() {
    }

    public wd(AdRequest adRequest, int i) {
        if (adRequest == null) {
            return;
        }
        this.f794a = adRequest;
        this.f1499a = i;
        this.f795a = adRequest.getCodeId();
        this.c = adRequest.getWidth();
        this.d = adRequest.getHeight();
        this.b = adRequest.getBidFloor();
        this.f796a = adRequest.getExtOption();
    }
}
