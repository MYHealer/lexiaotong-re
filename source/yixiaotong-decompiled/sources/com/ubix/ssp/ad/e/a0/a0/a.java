package com.ubix.ssp.ad.e.a0.a0;

import android.text.TextUtils;
import com.fancy.adsdk.lib.constants.PtgErrorCode;
import com.hihonor.adsdk.base.ErrorCode;
import com.ubix.ssp.ad.e.a0.u;
import com.ubix.ssp.open.AdError;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a extends AdError {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f8626a;
    private String b;
    private int c;
    private int d;
    private int e;
    private String f;
    private boolean g;

    private a() {
        this.f8626a = -1;
        this.b = "";
        this.f = "unknown";
        this.g = false;
    }

    private a(int i, int i2, int i3, String str) {
        this.f8626a = -1;
        this.b = "";
        this.g = false;
        this.f = str;
        this.c = i;
        this.d = i2;
        this.e = i3;
    }

    public static AdError a(int i, String str) {
        return new a(6, 8, i, str);
    }

    public static AdError b(int i, String str) {
        return new a(4, 1, i, str);
    }

    private void b() {
        if (this.g) {
            return;
        }
        this.g = true;
        u.b("", "[ErrorCode=" + a() + ",ErrorMessage=" + this.f + "]");
    }

    public static AdError c(int i, String str) {
        return new a(4, 5, i, str);
    }

    public static AdError d(int i, String str) {
        return new a(4, 4, i, str);
    }

    public static AdError e(int i, String str) {
        return new a(1, 1, i, str);
    }

    public static AdError f(int i, String str) {
        return new a(1, 3, i, str);
    }

    public static AdError g(int i, String str) {
        return new a(3, 1, i, str);
    }

    public static AdError h(int i, String str) {
        return new a(3, 4, i, str);
    }

    public static AdError i(int i, String str) {
        return new a(3, 3, i, str);
    }

    public static AdError j(int i, String str) {
        return new a(2, 1, i, str);
    }

    public static AdError k(int i, String str) {
        return new a(2, 3, i, str);
    }

    public String a() {
        StringBuilder sbAppend = new StringBuilder().append(this.c).append("").append(this.d).append("0");
        int i = this.e;
        return sbAppend.append(i / 10 != 0 ? Integer.valueOf(i) : "0" + this.e).toString();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:24:0x005e. Please report as an issue. */
    @Override // com.ubix.ssp.open.AdError
    public int getErrorCode() {
        String str;
        String str2;
        int i;
        b();
        int i2 = this.d;
        if (i2 == 1) {
            str = "传入参数有误，请查看logcat检查 [code:%s]";
            switch (this.e) {
                case 1:
                    this.f8626a = 10001;
                    str2 = "APP_ID为空，请检查对应的值是否传入正确 [code:%s]";
                    break;
                case 2:
                    this.f8626a = 10002;
                    str2 = "POS_ID为空，请检查对应的值是否传入正确 [code:%s]";
                    break;
                case 3:
                    this.f8626a = 10003;
                    str2 = "AdSize参数异常，请检查对应的值是否传入正确 [code:%s]";
                    break;
                case 4:
                    i = 10006;
                    this.f8626a = i;
                    str2 = str;
                    break;
                case 5:
                    this.f8626a = 30001;
                    str2 = "Activity为空，或广告不可见 [code:%s]";
                    break;
                case 6:
                default:
                    this.f8626a = 10007;
                    str2 = "请求发生错误 [code:%s]";
                    break;
                case 7:
                    this.f8626a = 10008;
                    str2 = "请勿频繁请求 [code:%s]";
                    break;
                case 8:
                    this.f8626a = 10004;
                    str2 = "SDK未初始化，请先初始化SDK [code:%s]";
                    break;
                case 9:
                    this.f8626a = 10005;
                    str2 = "SDK已关闭，请勿重复请求 [code:%s]";
                    break;
                case 10:
                    i = 10009;
                    this.f8626a = i;
                    str2 = str;
                    break;
            }
            this.b = str2;
        } else if (i2 == 8) {
            int i3 = this.e;
            if (i3 == 1 || i3 == 2 || i3 == 3 || i3 == 4) {
                this.f8626a = PtgErrorCode.SDK_CLICK_ERR;
                str2 = "激励视频奖励获取失败 [code:%s]";
                this.b = str2;
            }
        } else if (i2 == 3) {
            str = "无填充，请勿频繁重试 [code:%s]";
            switch (this.e) {
                case 1:
                case 2:
                    this.f8626a = 20002;
                    str2 = "网络连接异常 [code:%s]";
                    this.b = str2;
                    break;
                case 3:
                    this.f8626a = 20003;
                    str2 = "请求超时 [code:%s]";
                    this.b = str2;
                    break;
                case 4:
                case 5:
                    this.f8626a = 20001;
                    str2 = String.format("无填充，请勿频繁重试 [code:%s]", this.f, a());
                    this.b = str2;
                    break;
                case 6:
                case 7:
                case 8:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                case 16:
                    this.f8626a = 20001;
                    str2 = str;
                    this.b = str2;
                    break;
            }
        } else {
            if (i2 == 4) {
                switch (this.e) {
                    case 1:
                    case 2:
                        this.f8626a = ErrorCode.RESPONSE_DATA_EMPTY;
                        str2 = "视频加载出错 [code:%s]";
                        break;
                    case 3:
                        this.f8626a = ErrorCode.RESPONSE_FAIL;
                        str2 = "视频播放中出错 [code:%s]";
                        break;
                    case 4:
                        this.f8626a = 30002;
                        str2 = "广告已过期，请重新请求新广告 [code:%s]";
                        break;
                    case 5:
                        this.f8626a = ErrorCode.AD_SLOT_ID_EMPTY;
                        str2 = "资源下载失败 [code:%s]";
                        break;
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                        this.f8626a = ErrorCode.AD_SLOT_ID_EMPTY;
                        str2 = "模板渲染失败 [code:%s]";
                        break;
                    default:
                        this.f8626a = ErrorCode.AD_MEDIA_DISABLE;
                        str2 = "渲染异常 [code:%s]";
                        break;
                }
            } else if (i2 == 5 && this.e == 3) {
                this.f8626a = ErrorCode.AD_SLOT_NONE;
                str2 = "同一条广告请勿多次展示 [code:%s]";
            }
            this.b = str2;
        }
        return this.f8626a;
    }

    @Override // com.ubix.ssp.open.AdError
    public String getErrorMessage() {
        if (TextUtils.isEmpty(this.b)) {
            getErrorCode();
        }
        if (this.b.contains("[code:%s]")) {
            this.b = String.format(this.b, a());
        }
        return this.b;
    }
}
