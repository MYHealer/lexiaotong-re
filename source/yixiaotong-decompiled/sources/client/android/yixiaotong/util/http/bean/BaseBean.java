package client.android.yixiaotong.util.http.bean;

import com.google.gson.annotations.Expose;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class BaseBean<T> {

    @Expose
    public int Code;

    @Expose
    public T Data;

    @Expose
    public String Message;

    @Expose
    public String Serial;

    @Expose
    public String TokenInfo;

    public int getErrCode() {
        return 0;
    }

    public String getErrMsg() {
        return this.Message;
    }

    public boolean ok() {
        return this.Code == 0;
    }

    public String toString() {
        return "Code:" + this.Code + "Serial:" + this.Serial + "Data:" + this.Data.toString() + "Message:" + this.Message;
    }
}
