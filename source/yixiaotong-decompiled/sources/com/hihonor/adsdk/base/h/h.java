package com.hihonor.adsdk.base.h;

import com.hihonor.adsdk.base.net.m;
import com.hihonor.adsdk.base.net.resp.GameReserveResult;
import retrofit2.Callback;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class h {

    static /* synthetic */ class a {
    }

    private static final class b {
        private static final h hnadsa = new h(null);

        private b() {
        }
    }

    /* synthetic */ h(a aVar) {
        this();
    }

    public static h hnadsa() {
        return b.hnadsa;
    }

    private h() {
    }

    public void hnadsa(String str, Callback<GameReserveResult> callback) {
        m.hnadsb().hnadsc().hnadsb(str).enqueue(callback);
    }
}
