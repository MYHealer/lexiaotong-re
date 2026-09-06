package client.android.yixiaotong.controller.bean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class CombindBean {
    private String returnStr = "";

    public CombindBean combind(String str, String str2) {
        if (str2 != null && !str2.equals("null")) {
            this.returnStr += (str + "=" + str2 + "#?");
        }
        return this;
    }

    public String toString() {
        String str = new String(this.returnStr);
        return str.length() >= 2 ? str.substring(0, str.length() - 2) : str;
    }
}
