package client.android.yixiaotong.v4.http.bean;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4HomeInfoBean implements Serializable {
    public String appName;
    public List<V4HomeCustomerBean> customerNameList;
    public List<V4HomePageInfoBean> customerPageDefList;
    public List<V4NoticeInfoBean> noticeList;
    public boolean openAd = true;
    public int productId;
}
