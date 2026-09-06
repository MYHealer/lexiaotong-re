package client.android.yixiaotong.v3.bean.order;

import client.android.yixiaotong.v3.bean.card.PayInfoBean;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class NoPayOrderResultBean {
    public String createTime;
    public boolean hasUnPayMergeOrder;
    public String mergeOrderId;
    public String msg;
    public String orderId;
    public List<NoPayOrderBean> orderInfo;
    public int payFlag;
    public int payFlagType;
    public PayInfoBean payInfo;
    public int paymentFlag;
    public int statusFlag = -1;
    public int totalPrice;
}
