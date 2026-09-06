package client.android.yixiaotong.v4.http.bean;

import com.google.gson.annotations.Expose;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4RefundConfigBean implements Serializable {

    @Expose
    public List<Integer> autoRefundAccount;

    @Expose
    public Integer autoRefundType;

    @Expose
    public List<Integer> manualRefundAccount;

    @Expose
    public Integer refundApply;

    @Expose
    public String refundEndTime;

    @Expose
    public List<Integer> refundMethod;

    @Expose
    public Integer refundReason;

    @Expose
    public String refundStartTime;

    @Expose
    public Integer refundStudentId;
}
