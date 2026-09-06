package com.hihonor.adsdk.base.mediation;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class ServerSideVerificationOptions {
    public static final String TRANS_ID = "transId";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f3510a;
    private String b;
    private final JSONObject c;

    static /* synthetic */ class a {
    }

    public static class b {
        private String hnadsa;
        private String hnadsb;

        public b hnadsa(String str) {
            this.hnadsa = str;
            return this;
        }

        public b hnadsb(String str) {
            this.hnadsb = str;
            return this;
        }

        public ServerSideVerificationOptions hnadsa() {
            return new ServerSideVerificationOptions(this, null);
        }
    }

    /* synthetic */ ServerSideVerificationOptions(b bVar, a aVar) {
        this(bVar);
    }

    public String getCustomData() {
        return this.f3510a;
    }

    public JSONObject getOptions() {
        return this.c;
    }

    public String getUserId() {
        return this.b;
    }

    private ServerSideVerificationOptions(b bVar) {
        this.c = new JSONObject();
        this.f3510a = bVar.hnadsa;
        this.b = bVar.hnadsb;
    }
}
