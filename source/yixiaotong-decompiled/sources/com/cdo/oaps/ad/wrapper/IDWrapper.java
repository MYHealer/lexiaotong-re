package com.cdo.oaps.ad.wrapper;

import com.cdo.oaps.ad.ag;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class IDWrapper extends BaseWrapper {
    protected IDWrapper(Map<String, Object> map) {
        super(map);
    }

    public static IDWrapper wrapper(Map<String, Object> map) {
        return new IDWrapper(map);
    }

    public long getId() {
        try {
            return getLong("id");
        } catch (ag | NumberFormatException unused) {
            return -1L;
        }
    }

    public IDWrapper setId(long j) {
        return (IDWrapper) set("id", Long.valueOf(j));
    }
}
