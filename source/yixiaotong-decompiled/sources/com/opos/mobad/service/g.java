package com.opos.mobad.service;

import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.huawei.openalliance.ad.constant.x;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f7378a = 1;
    private JSONObject b;
    private long c;
    private long d;
    private String e;

    g(String str) {
        this.e = str;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        this.d = jElapsedRealtime;
        this.c = jElapsedRealtime;
        this.b = new JSONObject();
    }

    private String a(int i, String str) {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.e)) {
            sb.append(this.e);
            sb.append(x.A);
        }
        sb.append(i);
        if (!TextUtils.isEmpty(str)) {
            sb.append(x.A);
            sb.append(str);
        }
        return sb.toString();
    }

    private JSONObject a() {
        try {
            this.b.put(a(0, TtmlNode.COMBINE_ALL), SystemClock.elapsedRealtime() - this.c);
        } catch (JSONException unused) {
        }
        return this.b;
    }

    public String toString() {
        return a().toString();
    }
}
