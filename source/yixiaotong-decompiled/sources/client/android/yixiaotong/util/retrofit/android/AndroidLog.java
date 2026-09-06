package client.android.yixiaotong.util.retrofit.android;

import android.util.Log;
import client.android.yixiaotong.util.retrofit.RestAdapter;
import client.android.yixiaotong.v3.util.LogReceivedUtil;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class AndroidLog implements RestAdapter.Log {
    private static final int LOG_CHUNK_SIZE = 4000;
    private final String tag;

    public String getTag() {
        return this.tag;
    }

    public AndroidLog(String str) {
        this.tag = str;
    }

    @Override // client.android.yixiaotong.util.retrofit.RestAdapter.Log
    public final void log(String str) {
        int length = str.length();
        int i = 0;
        while (i < length) {
            int i2 = i + 4000;
            logChunk(str.substring(i, Math.min(length, i2)));
            i = i2;
        }
    }

    public void logChunk(String str) {
        Log.d(getTag(), str);
        LogReceivedUtil.getInstance().saveData(str);
    }
}
