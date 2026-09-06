package client.android.yixiaotong.v4.http.bean;

import com.google.gson.annotations.Expose;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4BaseBean<T> {

    @Expose
    public int code;

    @Expose
    public T data;

    @Expose
    public boolean goWhite = false;

    @Expose
    public String message;

    @Expose
    public String openPassword;

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
        return "code:" + this.code + "data:" + this.data.toString() + "message:" + this.message;
    }
}
