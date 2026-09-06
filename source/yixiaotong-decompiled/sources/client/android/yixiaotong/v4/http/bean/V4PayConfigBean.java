package client.android.yixiaotong.v4.http.bean;

import com.google.gson.annotations.Expose;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4PayConfigBean implements Serializable {

    @Expose
    public Integer consumePayBank;

    @Expose
    public int consumePayMent;

    @Expose
    public int payChannel;

    @Expose
    public ArrayList<Integer> projectPayMentToArray;

    @Expose
    public Integer settleUnpayOrder;

    @Expose
    public List<V4ConsumePayMentBean> sortList;
}
