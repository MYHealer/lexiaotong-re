package client.android.yixiaotong.controller.bean;

import client.android.yixiaotong.util.TimeUtils;
import java.util.Comparator;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class RecordBean {
    public static final int TYPE_CHARGE = 1;
    public static final int TYPE_CONSUME = 3;
    public static final int TYPE_GET_CASH = 4;
    public static final int TYPE_TO_SAMLL_WALLET = 2;
    public String ConsumeAmount;
    public String ConsumeDetails;
    public long ConsumeTime;
    public int IsOnline;
    public int OffLineTimes;
    public int TypeId;
    public int state;

    public String getTypeName() {
        int i = this.TypeId;
        if (i == 1) {
            return "充值";
        }
        if (i == 2) {
            return "划拨到小钱包";
        }
        return (i != 3 && i == 4) ? "提现" : "消费";
    }

    public String getTimeStr() {
        return TimeUtils.formatTime(this.ConsumeTime);
    }

    public String getTimeStr1() {
        return TimeUtils.formatTime1(this.ConsumeTime);
    }

    public static Comparator<RecordBean> getTimeComparetor() {
        return new Comparator<RecordBean>() { // from class: client.android.yixiaotong.controller.bean.RecordBean.1
            @Override // java.util.Comparator
            public int compare(RecordBean recordBean, RecordBean recordBean2) {
                if (recordBean.ConsumeTime > recordBean2.ConsumeTime) {
                    return -1;
                }
                return recordBean.ConsumeTime < recordBean2.ConsumeTime ? 1 : 0;
            }
        };
    }
}
