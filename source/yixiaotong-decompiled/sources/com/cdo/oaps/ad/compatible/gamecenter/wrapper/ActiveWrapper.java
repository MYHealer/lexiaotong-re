package com.cdo.oaps.ad.compatible.gamecenter.wrapper;

import com.cdo.oaps.ad.OapsKey;
import com.cdo.oaps.ad.ag;
import com.cdo.oaps.ad.wrapper.IDWrapper;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class ActiveWrapper extends IDWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final String f3119a;

    protected ActiveWrapper(Map<String, Object> map) {
        super(map);
        this.f3119a = OapsKey.KEY_ACTIVE_CODE;
    }

    public static ActiveWrapper wrapper(Map<String, Object> map) {
        return new ActiveWrapper(map);
    }

    public int getActiveCode() {
        try {
            return getInt(OapsKey.KEY_ACTIVE_CODE);
        } catch (ag | NumberFormatException unused) {
            return -1;
        }
    }

    public ActiveWrapper setActiveCode(int i) {
        return (ActiveWrapper) set(OapsKey.KEY_ACTIVE_CODE, Integer.valueOf(i));
    }
}
