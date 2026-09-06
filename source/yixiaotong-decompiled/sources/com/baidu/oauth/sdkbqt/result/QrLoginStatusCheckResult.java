package com.baidu.oauth.sdkbqt.result;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public class QrLoginStatusCheckResult extends OauthResult {
    public static final int ERROR_CODE_QR_CODE_EXPRIED = -208;
    public static final String ERROR_MSG_QR_CODE_EXPRIED = "二维码过期";
    public static final int QR_LOGIN_STATUS_LOGIN_DONE = 0;
    public static final int QR_LOGIN_STATUS_QR_CODE_expired = 2;
    public static final int QR_LOGIN_STATUS_SCAN_DONE = 1;
    public static final int QR_LOGIN_STATUS_UEER_CANCEL = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f1901a;
    private String b;
    public int status;

    public String getCode() {
        return this.f1901a;
    }

    public String getState() {
        return this.b;
    }

    public void setCode(String str) {
        this.f1901a = str;
    }

    public void setState(String str) {
        this.b = str;
    }

    public QrLoginStatusCheckResult() {
        this.msgMap.put(-208, ERROR_MSG_QR_CODE_EXPRIED);
    }
}
