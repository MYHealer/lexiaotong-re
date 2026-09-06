package com.cdo.oaps.ad.wrapper;

import com.cdo.oaps.ad.OapsKey;
import com.cdo.oaps.ad.ag;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class HomeWrapper extends BaseWrapper {
    protected HomeWrapper(Map<String, Object> map) {
        super(map);
    }

    public static HomeWrapper wrapper(Map<String, Object> map) {
        return new HomeWrapper(map);
    }

    public String getModule() {
        try {
            return (String) get("m");
        } catch (ag unused) {
            return "";
        }
    }

    public int getPageKey() {
        try {
            return getInt(OapsKey.KEY_PAGEKEY);
        } catch (ag unused) {
            return 0;
        }
    }

    public HomeWrapper setModule(String str) {
        return (HomeWrapper) set("m", str);
    }

    public HomeWrapper setPageKey(int i) {
        return (HomeWrapper) set(OapsKey.KEY_PAGEKEY, Integer.valueOf(i));
    }
}
