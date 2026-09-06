package com.volcengine.mobsecBiz.metasec.ml;

import java.util.Map;
import ms.bz.bd.c.Pgl.pblv;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public final class PglMSConfig extends pblv {
    private final pblv q;

    public static class Builder extends pblv.pgla<Builder> {
        public Builder(String str, String str2) {
            super(str, str2, pblv.COLLECT_MODE_DEFAULT);
        }

        public Builder(String str, String str2, int i) {
            super(str, str2, i);
        }

        public Builder(String str, String str2, String str3) {
            super(str, str2, str3, pblv.COLLECT_MODE_DEFAULT);
        }

        public Builder(String str, String str2, String str3, int i) {
            super(str, str2, str3, i);
        }

        public Builder addAdvanceInfo(String str, String str2) {
            addAdvanceInfo0(str, str2);
            return this;
        }

        public PglMSConfig build() {
            return new PglMSConfig(a(), 0);
        }

        public Builder setChannel(String str) {
            setChannel0(str);
            return this;
        }

        public Builder setClientType(int i) {
            setClientType0(i);
            return this;
        }

        public Builder setCustomInfo(Map<String, String> map) {
            setCustomInfo0(map);
            return this;
        }

        public Builder setDeviceID(String str) {
            setDeviceID0(str);
            return this;
        }

        public Builder setInstallID(String str) {
            setInstallID0(str);
            return this;
        }

        public Builder setOaid(String str) {
            setOaid0(str);
            return this;
        }
    }

    private PglMSConfig(pblv.pgla pglaVar) {
        this.q = pglaVar;
    }

    /* synthetic */ PglMSConfig(pblv.pgla pglaVar, int i) {
        this(pglaVar);
    }

    final pblv a() {
        return this.q;
    }
}
