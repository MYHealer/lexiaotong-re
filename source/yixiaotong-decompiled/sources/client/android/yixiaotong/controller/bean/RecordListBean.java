package client.android.yixiaotong.controller.bean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class RecordListBean {
    public String NextMonth;
    public List<RecordBean> Records;
    public int Total;
    public String TotalConsume;

    public static List<RecordBean> getSortList(List<RecordBean> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        Collections.sort(list, RecordBean.getTimeComparetor());
        for (int i = 0; i < list.size(); i++) {
            RecordBean recordBean = list.get(i);
            if (list.size() == 1) {
                recordBean.state = 3;
            }
            if (i == 0) {
                recordBean.state = 0;
                if (!list.get(0).getTimeStr().equals(list.get(1).getTimeStr())) {
                    recordBean.state = 3;
                }
            } else if (i == list.size() - 1) {
                recordBean.state = 2;
                if (!list.get(i).getTimeStr().equals(list.get(i - 1).getTimeStr())) {
                    recordBean.state = 3;
                }
            } else {
                RecordBean recordBean2 = list.get(i - 1);
                RecordBean recordBean3 = list.get(i + 1);
                if (!recordBean.getTimeStr().equals(recordBean2.getTimeStr()) && recordBean.getTimeStr().equals(recordBean3.getTimeStr())) {
                    recordBean.state = 0;
                } else if (recordBean.getTimeStr().equals(recordBean2.getTimeStr()) && recordBean.getTimeStr().equals(recordBean3.getTimeStr())) {
                    recordBean.state = 1;
                } else if (recordBean.getTimeStr().equals(recordBean2.getTimeStr()) && !recordBean.getTimeStr().equals(recordBean3.getTimeStr())) {
                    recordBean.state = 2;
                } else if (!recordBean.getTimeStr().equals(recordBean2.getTimeStr()) && !recordBean.getTimeStr().equals(recordBean3.getTimeStr())) {
                    recordBean.state = 3;
                }
            }
        }
        return list;
    }

    public List<RecordBean> getSortList() {
        if (this.Records == null) {
            this.Records = new ArrayList();
        }
        Collections.sort(this.Records, RecordBean.getTimeComparetor());
        for (int i = 0; i < this.Records.size(); i++) {
            RecordBean recordBean = this.Records.get(i);
            if (this.Records.size() == 1) {
                recordBean.state = 3;
            } else if (i == 0) {
                recordBean.state = 0;
                if (!this.Records.get(0).getTimeStr().equals(this.Records.get(1).getTimeStr())) {
                    recordBean.state = 3;
                }
            } else if (i == this.Records.size() - 1) {
                recordBean.state = 2;
                if (!this.Records.get(i).getTimeStr().equals(this.Records.get(i - 1).getTimeStr())) {
                    recordBean.state = 3;
                }
            } else {
                RecordBean recordBean2 = this.Records.get(i - 1);
                RecordBean recordBean3 = this.Records.get(i + 1);
                if (!recordBean.getTimeStr().equals(recordBean2.getTimeStr()) && recordBean.getTimeStr().equals(recordBean3.getTimeStr())) {
                    recordBean.state = 0;
                } else if (recordBean.getTimeStr().equals(recordBean2.getTimeStr()) && recordBean.getTimeStr().equals(recordBean3.getTimeStr())) {
                    recordBean.state = 1;
                } else if (recordBean.getTimeStr().equals(recordBean2.getTimeStr()) && !recordBean.getTimeStr().equals(recordBean3.getTimeStr())) {
                    recordBean.state = 2;
                } else if (!recordBean.getTimeStr().equals(recordBean2.getTimeStr()) && !recordBean.getTimeStr().equals(recordBean3.getTimeStr())) {
                    recordBean.state = 3;
                }
            }
        }
        return this.Records;
    }
}
