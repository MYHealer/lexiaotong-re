package client.android.yixiaotong.alipay;

import android.text.TextUtils;
import com.alipay.sdk.util.i;
import com.alipay.sdk.util.l;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class PayResult {
    private String memo;
    private String result;
    private String resultStatus;

    public String getMemo() {
        return this.memo;
    }

    public String getResult() {
        return this.result;
    }

    public String getResultStatus() {
        return this.resultStatus;
    }

    public PayResult(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        for (String str2 : str.split(";")) {
            if (str2.startsWith(l.f1664a)) {
                this.resultStatus = gatValue(str2, l.f1664a);
            }
            if (str2.startsWith("result")) {
                this.result = gatValue(str2, "result");
            }
            if (str2.startsWith(l.b)) {
                this.memo = gatValue(str2, l.b);
            }
        }
    }

    public String toString() {
        return "resultStatus={" + this.resultStatus + "};memo={" + this.memo + "};result={" + this.result + i.d;
    }

    private String gatValue(String str, String str2) {
        String str3 = str2 + "={";
        return str.substring(str.indexOf(str3) + str3.length(), str.lastIndexOf(i.d));
    }
}
