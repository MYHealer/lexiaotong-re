package client.android.yixiaotong.icbcPay;

import android.app.Activity;
import android.widget.Toast;
import client.android.yixiaotong.BaseApplication;
import client.android.yixiaotong.v3.util.LogUtil;
import com.icbc.paysdk.AliPayAPI;
import com.icbc.paysdk.ICBCAPI;
import com.icbc.paysdk.WXPayAPI;
import com.icbc.paysdk.model.ThirdPayReq;
import com.icbc.paysdk.model.UnionPayReq;
import com.ubixnow.ooooo.ooooO0O0;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class ICBCPayUtils {
    private static final String TAG = "ICBCPayUtils";

    public interface OnPayListener {
        void payFail();

        void paySuccess();

        void payWaitting();
    }

    private ICBCPayUtils() {
    }

    public static void payAll(int i, String str, Activity activity, UnionPayReq unionPayReq, OnPayListener onPayListener) {
        if (i == 1) {
            payE(activity, unionPayReq);
        } else if (i == 3) {
            payWX(str, activity, unionPayReq);
        } else if (i == 2) {
            payAli(activity, unionPayReq, onPayListener);
        }
    }

    private static void payE(Activity activity, UnionPayReq unionPayReq) {
        LogUtil.e(TAG, "工银e支付");
        ICBCAPI.getInstance().sendReq(activity, unionPayReq);
    }

    private static void payWX(String str, Activity activity, UnionPayReq unionPayReq) {
        LogUtil.e(TAG, "工行微信支付");
        WXPayAPI.init(BaseApplication.app, str);
        WXPayAPI.getInstance().doSdk(activity, unionPayReq);
    }

    private static void payAliBox(final Activity activity, final OnPayListener onPayListener) {
        ThirdPayReq thirdPayReq = new ThirdPayReq();
        thirdPayReq.setInterfaceName("ICBC_WAPB_THIRD");
        thirdPayReq.setInterfaceVersion(ooooO0O0.OooOo0O);
        thirdPayReq.setTranData("tranDataMsgId");
        thirdPayReq.setTranData("tranDataBizContent");
        thirdPayReq.setTranData("tranDataTimestamp");
        thirdPayReq.setMerSignMsg("merSignMsg");
        thirdPayReq.setMerCert("merCert");
        thirdPayReq.setClientType("24");
        AliPayAPI.getInstance().doAliPay2(activity, thirdPayReq, new AliPayAPI.AliPayResultCallBack() { // from class: client.android.yixiaotong.icbcPay.ICBCPayUtils.1
            @Override // com.icbc.paysdk.AliPayAPI.AliPayResultCallBack
            public void onResp(String str) {
                if ("9000".equals(str)) {
                    Toast.makeText(activity, "支付成功", 0).show();
                    OnPayListener onPayListener2 = onPayListener;
                    if (onPayListener2 != null) {
                        onPayListener2.paySuccess();
                        return;
                    }
                    return;
                }
                if ("6001".equals(str)) {
                    Toast.makeText(activity, "支付取消", 0).show();
                    OnPayListener onPayListener3 = onPayListener;
                    if (onPayListener3 != null) {
                        onPayListener3.payFail();
                        return;
                    }
                    return;
                }
                Toast.makeText(activity, "支付失败", 0).show();
                OnPayListener onPayListener4 = onPayListener;
                if (onPayListener4 != null) {
                    onPayListener4.payFail();
                }
            }
        });
    }

    private static void payAli(final Activity activity, UnionPayReq unionPayReq, final OnPayListener onPayListener) {
        LogUtil.e(TAG, "工行支付宝支付");
        AliPayAPI.getInstance().doSdk(activity, unionPayReq, new AliPayAPI.AliPayResultCallBack() { // from class: client.android.yixiaotong.icbcPay.ICBCPayUtils.2
            @Override // com.icbc.paysdk.AliPayAPI.AliPayResultCallBack
            public void onResp(String str) {
                if ("9000".equals(str)) {
                    Toast.makeText(activity, "支付成功", 0).show();
                    OnPayListener onPayListener2 = onPayListener;
                    if (onPayListener2 != null) {
                        onPayListener2.paySuccess();
                        return;
                    }
                    return;
                }
                if ("6001".equals(str)) {
                    Toast.makeText(activity, "支付取消", 0).show();
                    OnPayListener onPayListener3 = onPayListener;
                    if (onPayListener3 != null) {
                        onPayListener3.payFail();
                        return;
                    }
                    return;
                }
                Toast.makeText(activity, "支付失败", 0).show();
                OnPayListener onPayListener4 = onPayListener;
                if (onPayListener4 != null) {
                    onPayListener4.payFail();
                }
            }
        });
    }

    public static UnionPayReq getUnionPayReq(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        UnionPayReq unionPayReq = new UnionPayReq();
        unionPayReq.setAppId(str);
        unionPayReq.setMsgId(str2);
        unionPayReq.setFormat(str3);
        unionPayReq.setCharset(str4);
        unionPayReq.setEncryptType(str5);
        unionPayReq.setSignType(str6);
        unionPayReq.setSign(str7);
        unionPayReq.setTimestamp(str8);
        unionPayReq.setCa(str9);
        unionPayReq.setBizContent(str10);
        unionPayReq.setEncryptKey(str11);
        return unionPayReq;
    }
}
