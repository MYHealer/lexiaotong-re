package client.android.yixiaotong.sdk.bluetooth.utils;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class LimitedLinkHashMap<K, V> extends LinkedHashMap<K, V> {
    private static final long serialVersionUID = -5375660288461724925L;
    private final int mMaxSize;

    public LimitedLinkHashMap(int i) {
        super(i + 1, 1.0f, false);
        this.mMaxSize = i;
    }

    @Override // java.util.LinkedHashMap
    protected boolean removeEldestEntry(Map.Entry<K, V> entry) {
        return size() > this.mMaxSize;
    }
}
