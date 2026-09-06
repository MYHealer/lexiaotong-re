package client.android.yixiaotong.v4.util.projectconfig;

import client.android.yixiaotong.v4.http.bean.V4PayConfigBean;
import client.android.yixiaotong.v4.http.bean.V4PayMentSBaen;
import client.android.yixiaotong.v4.http.bean.V4RefundConfigBean;
import com.google.gson.annotations.Expose;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4ProjectInfoBean {

    @Expose
    public Integer aliCartoonSign;

    @Expose
    public Integer consumeMode;

    @Expose
    public Integer dormWallet;

    @Expose
    public List<Integer> frontTypeToArray;

    @Expose
    public List<V4PayMentSBaen> payMentS;

    @Expose
    public List<Integer> productTypeToArray;

    @Expose
    public V4PayConfigBean projectPayConfigDTO;

    @Expose
    public String rechargeRemark;

    @Expose
    public V4RefundConfigBean refundConfigObj;
}
