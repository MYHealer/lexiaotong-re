package client.android.yixiaotong.util.http.bean;

import com.google.gson.annotations.Expose;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class BaseBeanLow<T> {

    @Expose
    public String TokenInfo;

    @Expose
    public int code;

    @Expose
    public T data;

    @Expose
    public String message;

    @Expose
    public String serial;

    public int getErrCode() {
        return 0;
    }

    public String getErrMsg() {
        return this.message;
    }

    public boolean ok() {
        return this.code == 0;
    }

    public String toString() {
        return "code:" + this.code + "serial:" + this.serial + "data:" + this.data.toString() + "message:" + this.message;
    }
}
