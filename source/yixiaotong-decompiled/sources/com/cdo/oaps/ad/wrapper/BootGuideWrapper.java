package com.cdo.oaps.ad.wrapper;

import com.cdo.oaps.ad.OapsKey;
import com.cdo.oaps.ad.ag;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class BootGuideWrapper extends BaseWrapper {
    protected BootGuideWrapper(Map<String, Object> map) {
        super(map);
    }

    public static BootGuideWrapper wrapper(Map<String, Object> map) {
        return new BootGuideWrapper(map);
    }

    public String getAction() {
        try {
            return (String) get("action");
        } catch (ag unused) {
            return "";
        }
    }

    public String getPkgName() {
        try {
            return (String) get(OapsKey.KEY_PKG);
        } catch (ag unused) {
            return "";
        }
    }

    public BootGuideWrapper setAction(String str) {
        return (BootGuideWrapper) set("action", str);
    }

    public BootGuideWrapper setPkgName(String str) {
        return (BootGuideWrapper) set(OapsKey.KEY_PKG, str);
    }
}
