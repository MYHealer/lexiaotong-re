package client.android.yixiaotong.util.drinkwater;

import com.alibaba.fastjson.annotation.JSONType;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
@JSONType(orders = {"F", "M", "N"})
public class MessageDto {
    private String F;
    private String M;
    private String N;

    public String getF() {
        return this.F;
    }

    public String getM() {
        return this.M;
    }

    public String getN() {
        return this.N;
    }

    public void setF(String str) {
        this.F = str;
    }

    public void setM(String str) {
        this.M = str;
    }

    public void setN(String str) {
        this.N = str;
    }
}
