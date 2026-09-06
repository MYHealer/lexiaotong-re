package com.cdo.oaps.ad;

import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class OapsWrapper extends ai {
    public static final String KEY_HOST = "host";
    public static final String KEY_PATH = "path";
    public static final String KEY_SCHEME = "scheme";

    protected OapsWrapper(Map<String, Object> map) {
        super(map);
    }

    public static OapsWrapper wrapper(Map<String, Object> map) {
        return new OapsWrapper(map);
    }

    public final String getHost() {
        try {
            return (String) get("host");
        } catch (ag unused) {
            return "";
        }
    }

    public final String getPath() {
        try {
            return (String) get("path");
        } catch (ag unused) {
            return "";
        }
    }

    public final String getScheme() {
        try {
            return (String) get("scheme");
        } catch (ag unused) {
            return "";
        }
    }

    public final OapsWrapper setHost(String str) {
        return (OapsWrapper) super.set("host", str);
    }

    public final OapsWrapper setPath(String str) {
        return (OapsWrapper) super.set("path", str);
    }

    public final OapsWrapper setScheme(String str) {
        return (OapsWrapper) super.set("scheme", str);
    }
}
