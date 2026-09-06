package client.android.yixiaotong.v4.http.bean;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4MeterConsumeDailySummaryBean implements Serializable {
    public String endDate;
    public List<V4MeterConsumeDailySummaryItemBean> list;
    public String startDate;
    public int timeRange;
    public String timeRangeName;
    public int totalConsumeCount;
    public double totalUsageAmount;
    public double totalUsageAmountMoney;
}
