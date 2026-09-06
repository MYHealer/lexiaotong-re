package com.kwad.sdk.api.loader;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class l {
    public static int aIm;

    public static void a(com.kwad.sdk.api.loader.a.C0726a c0726a) {
        aIm++;
        a(1, c0726a, 0L, 0, "");
    }

    public static void a(com.kwad.sdk.api.loader.a.C0726a c0726a, long j) {
        a(2, c0726a, j, 0, "");
    }

    public static void a(com.kwad.sdk.api.loader.a.C0726a c0726a, long j, String str) {
        a(3, c0726a, j, 0, str);
    }

    public static void a(com.kwad.sdk.api.loader.a.C0726a c0726a, int i, String str) {
        a(4, c0726a, 0L, i, str);
    }

    public static void b(com.kwad.sdk.api.loader.a.C0726a c0726a) {
        a(5, c0726a, 0L, 0, "");
    }

    public static void b(com.kwad.sdk.api.loader.a.C0726a c0726a, long j) {
        a(6, c0726a, j, 0, "");
    }

    public static void b(com.kwad.sdk.api.loader.a.C0726a c0726a, int i, String str) {
        a(7, c0726a, 0L, i, str);
    }

    private static void a(int i, com.kwad.sdk.api.loader.a.C0726a c0726a, long j, int i2, String str) {
        if (c0726a == null) {
            return;
        }
        try {
            JSONObject json = new a((byte) 0).dp(i).dq(aIm).db(c0726a.sdkVersion).dc(c0726a.aHD).av(j).dr(i2).dd(str).toJson();
            new StringBuilder("status:").append(i).append("--jo:").append(json);
            com.kwad.sdk.api.c.g("reportDynamicUpdate", json);
        } catch (Throwable unused) {
        }
    }

    static class a {
        private int aIn;
        private int aIo;
        private String aIp;
        private String aIq;
        private long aIr;
        private int aIs;
        private String aIt;

        /* JADX INFO: Access modifiers changed from: private */
        public a av(long j) {
            this.aIr = j;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a db(String str) {
            this.aIp = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a dc(String str) {
            this.aIq = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a dd(String str) {
            this.aIt = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a dp(int i) {
            this.aIn = i;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a dq(int i) {
            this.aIo = i;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a dr(int i) {
            this.aIs = i;
            return this;
        }

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("load_status", Integer.valueOf(this.aIn));
                jSONObject.putOpt("update_count", Integer.valueOf(this.aIo));
                jSONObject.putOpt("dynamic_version", this.aIp);
                jSONObject.putOpt("download_url", this.aIq);
                jSONObject.putOpt("duration_ms", Long.valueOf(this.aIr));
                jSONObject.putOpt("error_code", Integer.valueOf(this.aIs));
                jSONObject.putOpt(com.hihonor.adsdk.base.g.j.e.a.hnadst, this.aIt);
            } catch (Exception unused) {
            }
            return jSONObject;
        }

        public final String toString() {
            return "MonitorInfo{load_status=" + this.aIn + ", update_count=" + this.aIo + ", dynamic_version='" + this.aIp + "', download_url='" + this.aIq + "', duration_ms=" + this.aIr + ", error_code=" + this.aIs + ", error_msg='" + this.aIt + "'}";
        }
    }
}
