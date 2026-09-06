package com.ubixnow.ooooo;

import android.text.TextUtils;
import com.ubixnow.utils.BaseUtils;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b1 {
    private static final String[] OooO00o = {"多选项", "永久移动", "临时移动", "参见其他", "未改动", "使用代理", "", "暂时重定向"};
    private static final String[] OooO0O0 = {"错误请求", "未授权", "要求付费", "禁止", "未找到", "不允许的方法", "不被采纳", "要求代理授权", oOO00O0.ubix_timeout_msg, "冲突", "过期的", "要求的长度", "前提不成立", "请求实例太大", "请求URI太大", "不支持的媒体类型", "无法满足的请求范围", "失败的预期"};
    private static final String[] OooO0OO = {"内部服务器错误", "未被使用", "网关错误", "不可用的服务", "网关超时", "HTTP版本未被支持"};
    private HttpURLConnection OooO0Oo;
    private String OooO0o;
    private InputStream OooO0o0;
    private int OooO0oO;

    public b1(HttpURLConnection httpURLConnection) throws IOException {
        this.OooO0Oo = httpURLConnection;
        this.OooO0oO = httpURLConnection.getResponseCode();
    }

    public static String OooO00o(int i) {
        String str;
        StringBuilder sbAppend;
        String str2;
        if (300 > i || i >= 400) {
            str = "";
        } else {
            str = "重定向:" + i;
            int i2 = i - 300;
            String[] strArr = OooO00o;
            if (i2 < strArr.length) {
                str = str + "----->" + strArr[i2];
            }
        }
        if (400 <= i && i < 500) {
            String str3 = "客户端错误:" + i;
            int i3 = i - 400;
            String[] strArr2 = OooO0O0;
            if (i3 >= strArr2.length) {
                return str3;
            }
            sbAppend = new StringBuilder().append(str3).append("----->");
            str2 = strArr2[i3];
        } else {
            if (500 > i) {
                return str;
            }
            String str4 = "服务器错误:" + i;
            int i4 = i - 500;
            String[] strArr3 = OooO0OO;
            if (i4 >= strArr3.length) {
                return str4;
            }
            sbAppend = new StringBuilder().append(str4).append("----->");
            str2 = strArr3[i4];
        }
        return sbAppend.append(str2).toString();
    }

    public void OooO00o() {
        ooo0o.OooO00o(this.OooO0o0);
        HttpURLConnection httpURLConnection = this.OooO0Oo;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    public int OooO0O0() {
        return this.OooO0oO;
    }

    public HttpURLConnection OooO0OO() {
        return this.OooO0Oo;
    }

    public InputStream OooO0Oo() {
        if (this.OooO0o0 == null && OooO0O0() < 400) {
            try {
                this.OooO0o0 = this.OooO0Oo.getInputStream();
            } catch (Exception e) {
                ooooO000.OooO00o(e);
            }
        }
        return this.OooO0o0;
    }

    public String OooO0o() {
        if (!TextUtils.isEmpty(this.OooO0o)) {
            return this.OooO0o;
        }
        try {
            String inputString = BaseUtils.parseInputString(BaseUtils.decodeInputStream(OooO0Oo(), this.OooO0Oo.getContentEncoding()));
            this.OooO0o = inputString;
            if (TextUtils.isEmpty(inputString)) {
                this.OooO0o = this.OooO0Oo.getResponseMessage();
            }
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
        return this.OooO0o;
    }

    public long OooO0o0() {
        if (OooO0O0() < 200 || OooO0O0() >= 400) {
            return 0L;
        }
        return this.OooO0Oo.getContentLength();
    }
}
