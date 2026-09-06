package com.cdo.oaps.ad.wrapper;

import com.cdo.oaps.ad.ag;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class OnlineServiceWrapper extends BaseWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f3130a = "gr";

    protected OnlineServiceWrapper(Map<String, Object> map) {
        super(map);
    }

    public static OnlineServiceWrapper wrapper(Map<String, Object> map) {
        return new OnlineServiceWrapper(map);
    }

    public int getGrade() {
        try {
            return getInt(f3130a);
        } catch (ag | NumberFormatException unused) {
            return 0;
        }
    }

    public OnlineServiceWrapper setGrade(int i) {
        return (OnlineServiceWrapper) set(f3130a, Integer.valueOf(i));
    }
}
