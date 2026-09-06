package client.android.yixiaotong.wxapi;

import android.content.Context;
import client.android.yixiaotong.util.ToastUtils;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class WxPayUtils {
    private WxPayUtils() {
    }

    public static void pay(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        IWXAPI iwxapiCreateWXAPI = WXAPIFactory.createWXAPI(context, null);
        iwxapiCreateWXAPI.registerApp(str);
        PayReq payReq = new PayReq();
        payReq.appId = str;
        payReq.partnerId = str2;
        payReq.prepayId = str3;
        payReq.packageValue = "Sign=WXPay";
        payReq.nonceStr = str4;
        payReq.timeStamp = str5;
        payReq.sign = str6;
        if (iwxapiCreateWXAPI.sendReq(payReq)) {
            return;
        }
        ToastUtils.show(context, "跳转微信失败");
    }
}
