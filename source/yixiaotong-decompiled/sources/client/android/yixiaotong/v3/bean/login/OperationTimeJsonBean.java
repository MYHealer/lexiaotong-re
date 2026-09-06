package client.android.yixiaotong.v3.bean.login;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class OperationTimeJsonBean implements Serializable {
    public MerchantJsonBean merchantJson;
    public int operationFlag;
    public List<OperationTimeListBean> operationTimeList;
    public ZlPaymentJsonBean zlPaymentJson;
}
