package com.cdo.oaps.ad.compatible.gamecenter.wrapper;

import com.cdo.oaps.ad.ag;
import com.cdo.oaps.ad.wrapper.IDWrapper;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class StrategyWrapper extends IDWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final String f3120a;

    protected StrategyWrapper(Map<String, Object> map) {
        super(map);
        this.f3120a = "tab";
    }

    public static StrategyWrapper wrapper(Map<String, Object> map) {
        return new StrategyWrapper(map);
    }

    public int getTab() {
        try {
            return getInt("tab");
        } catch (ag | NumberFormatException unused) {
            return -1;
        }
    }

    public StrategyWrapper setTab(int i) {
        return (StrategyWrapper) set("tab", Integer.valueOf(i));
    }
}
