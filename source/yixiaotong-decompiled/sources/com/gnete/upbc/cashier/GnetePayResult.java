package com.gnete.upbc.cashier;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public enum GnetePayResult {
    SUCCESS("SUCCESS", "下单成功，等待完成支付"),
    CANCEL("CANCEL", "用户取消支付"),
    FAILURE("FAILURE", "支付失败");

    private final String msg;
    private final String status;

    GnetePayResult(String str, String str2) {
        this.status = str;
        this.msg = str2;
    }

    public String getMsg() {
        return this.msg;
    }

    public String getStatus() {
        return this.status;
    }
}
