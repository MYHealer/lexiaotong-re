package client.android.yixiaotong.controller.bean;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class SoundWaveCardRecordListBean {
    public List<SoundWaveCardRecordBean> Records;
    public int count;
    public int pageCount;
    public int pageIndex;
    public int pageSize;
    public String serial;

    public List<SoundWaveCardRecordBean> getSortList() {
        if (this.Records == null) {
            this.Records = new ArrayList();
        }
        return this.Records;
    }
}
