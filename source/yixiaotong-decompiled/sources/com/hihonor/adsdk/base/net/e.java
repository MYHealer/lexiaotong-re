package com.hihonor.adsdk.base.net;

import android.text.TextUtils;
import com.hihonor.adsdk.base.HnAds;
import com.hihonor.adsdk.base.init.HnAdConfig;
import java.util.LinkedHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class e {
    private static final String hnadsl = "Header";
    private String hnadsa;
    private long hnadsb;
    private String hnadsc;
    private String hnadsd;
    private String hnadse;
    private String hnadsf;
    private String hnadsg;
    private String hnadsh;
    private String hnadsi;
    private String hnadsj;
    private String hnadsk;

    public static class a {
        private String hnadsa;
        private long hnadsb;
        private String hnadsc;
        private String hnadsd;
        private String hnadse;
        private String hnadsf;
        private String hnadsg;
        private String hnadsh;
        private String hnadsi;
        private String hnadsj;
        private String hnadsk;

        public a hnadsa(long j) {
            this.hnadsb = j;
            return this;
        }

        public a hnadsb(String str) {
            this.hnadsk = hnadsa(str);
            return this;
        }

        public a hnadsc(String str) {
            this.hnadsj = hnadsa(str);
            return this;
        }

        public a hnadsd(String str) {
            this.hnadsh = hnadsa(str);
            return this;
        }

        public a hnadse(String str) {
            this.hnadsg = hnadsa(str);
            return this;
        }

        public a hnadsf(String str) {
            this.hnadsa = hnadsa(str);
            return this;
        }

        public a hnadsg(String str) {
            this.hnadsi = hnadsa(str);
            return this;
        }

        public a hnadsh(String str) {
            this.hnadsc = hnadsa(str);
            return this;
        }

        public a hnadsi(String str) {
            this.hnadsd = hnadsa(str);
            return this;
        }

        public a hnadsj(String str) {
            this.hnadse = hnadsa(str);
            return this;
        }

        public a hnadsk(String str) {
            this.hnadsf = hnadsa(str);
            return this;
        }

        private String hnadsa(String str) {
            return !TextUtils.isEmpty(str) ? str : "";
        }

        public String hnadsb() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(com.hihonor.adsdk.base.c.m0.hnadsa, this.hnadsh);
                jSONObject.put(com.hihonor.adsdk.base.c.m0.hnadsd, this.hnadsg);
                jSONObject.put(com.hihonor.adsdk.base.c.m0.hnadse, this.hnadsc);
                jSONObject.put(com.hihonor.adsdk.base.c.m0.hnadsf, this.hnadsb + "");
                jSONObject.put(com.hihonor.adsdk.base.c.m0.hnadsg, this.hnadsc);
                jSONObject.put(com.hihonor.adsdk.base.c.m0.hnadsh, "HmacSHA256");
                jSONObject.put(com.hihonor.adsdk.base.c.m0.hnadsi, this.hnadse);
                if (!TextUtils.isEmpty(this.hnadsf)) {
                    jSONObject.put(com.hihonor.adsdk.base.c.m0.hnadsj, this.hnadsf);
                }
                HnAdConfig cfg = HnAds.get().getCfg();
                if (cfg != null && cfg.isUseMock()) {
                    jSONObject.put(com.hihonor.adsdk.base.c.m0.hnadsk, "mock");
                }
            } catch (JSONException e) {
                com.hihonor.adsdk.common.b.b.hnadse(e.hnadsl, "getToken, Header builder get token parse json exception. msg is %s", e.getMessage());
            }
            return jSONObject.toString();
        }

        public e hnadsa() {
            return new e(this);
        }
    }

    public e(a aVar) {
        this.hnadsa = aVar.hnadsa;
        this.hnadsb = aVar.hnadsb;
        this.hnadsc = aVar.hnadsc;
        this.hnadsd = aVar.hnadsd;
        this.hnadsf = aVar.hnadse;
        this.hnadse = aVar.hnadsf;
        this.hnadsg = aVar.hnadsg;
        this.hnadsh = aVar.hnadsh;
        this.hnadsi = aVar.hnadsi;
        this.hnadsj = aVar.hnadsj;
        this.hnadsk = aVar.hnadsk;
    }

    private String hnadsa(String str) {
        return str == null ? "" : str;
    }

    public String hnadsa() {
        return this.hnadsk;
    }

    public LinkedHashMap<String, String> hnadsb() {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(com.hihonor.adsdk.base.c.m0.hnadsa, hnadsa(this.hnadsh));
        linkedHashMap.put(com.hihonor.adsdk.base.c.m0.hnadsb, hnadsa(this.hnadsi));
        linkedHashMap.put(com.hihonor.adsdk.base.c.m0.hnadsc, hnadsa(this.hnadsj));
        linkedHashMap.put(com.hihonor.adsdk.base.c.m0.hnadsd, hnadsa(this.hnadsg));
        linkedHashMap.put(com.hihonor.adsdk.base.c.m0.hnadse, hnadsa(this.hnadsa));
        linkedHashMap.put(com.hihonor.adsdk.base.c.m0.hnadsf, this.hnadsb + "");
        linkedHashMap.put(com.hihonor.adsdk.base.c.m0.hnadsg, hnadsa(this.hnadsc));
        linkedHashMap.put(com.hihonor.adsdk.base.c.m0.hnadsh, "HmacSHA256");
        linkedHashMap.put(com.hihonor.adsdk.base.c.m0.hnadsi, hnadsa(this.hnadsf));
        linkedHashMap.put(com.hihonor.adsdk.base.c.m0.hnadsj, hnadsa(this.hnadse));
        HnAdConfig cfg = HnAds.get().getCfg();
        if (cfg != null && cfg.isUseMock()) {
            linkedHashMap.put(com.hihonor.adsdk.base.c.m0.hnadsk, "mock");
        }
        return linkedHashMap;
    }

    public String hnadsc() {
        return this.hnadsh;
    }

    public String hnadsd() {
        return this.hnadsg;
    }

    public String hnadse() {
        return this.hnadsa;
    }

    public String hnadsf() {
        return this.hnadsc;
    }

    public String hnadsg() {
        return this.hnadsd;
    }

    public String hnadsh() {
        return this.hnadsf;
    }

    public long hnadsi() {
        return this.hnadsb;
    }

    public String hnadsj() {
        return this.hnadse;
    }
}
