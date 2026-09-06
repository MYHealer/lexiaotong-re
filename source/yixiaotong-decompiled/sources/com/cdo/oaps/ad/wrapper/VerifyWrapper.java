package com.cdo.oaps.ad.wrapper;

import com.cdo.oaps.ad.OapsKey;
import com.cdo.oaps.ad.ag;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class VerifyWrapper extends BaseWrapper {
    protected VerifyWrapper(Map<String, Object> map) {
        super(map);
    }

    public static VerifyWrapper wrapper(Map<String, Object> map) {
        return new VerifyWrapper(map);
    }

    public String getChecksum() {
        try {
            return (String) get(OapsKey.KEY_CK);
        } catch (ag unused) {
            return "";
        }
    }

    public String getId() {
        try {
            return (String) get(OapsKey.KEY_SRC);
        } catch (ag unused) {
            return "";
        }
    }

    public String getTimestamp() {
        try {
            return (String) get("ts");
        } catch (ag unused) {
            return "";
        }
    }

    public VerifyWrapper setChecksum(String str) {
        return (VerifyWrapper) set(OapsKey.KEY_CK, str);
    }

    public VerifyWrapper setId(String str) {
        return (VerifyWrapper) set(OapsKey.KEY_SRC, str);
    }

    public VerifyWrapper setTimestamp(String str) {
        return (VerifyWrapper) set("ts", String.valueOf(str));
    }
}
