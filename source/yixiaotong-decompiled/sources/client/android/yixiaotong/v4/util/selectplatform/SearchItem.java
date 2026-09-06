package client.android.yixiaotong.v4.util.selectplatform;

import java.io.Serializable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class SearchItem implements Serializable {
    private String id;
    private int platform;
    private String schoolname;
    private long timestamp = System.currentTimeMillis();

    public String getId() {
        return this.id;
    }

    public int getPlatform() {
        return this.platform;
    }

    public String getSchoolName() {
        return this.schoolname;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public SearchItem(String str, String str2, int i) {
        this.id = str;
        this.schoolname = str2;
        this.platform = i;
    }
}
