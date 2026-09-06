package client.android.yixiaotong.v3.ui.appcontrol.payutil;

import android.app.Activity;
import client.android.yixiaotong.alipay.AliPayUtils;
import client.android.yixiaotong.icbcPay.ICBCPayUtils;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.v3.bean.drawmoney.DMGetOrderBean;
import client.android.yixiaotong.v3.ui.wallet.controlutil.V3WalletControlUtil;
import client.android.yixiaotong.wxapi.WxPayUtils;
import com.gnete.upbc.cashier.GnetePayConfig;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class PayWayControlUtil {
    private OnPayWayListener mOnPayWayListener;

    public interface OnPayWayListener {
        void onPayResult(int i);
    }

    public void setListener(OnPayWayListener onPayWayListener) {
        this.mOnPayWayListener = onPayWayListener;
    }

    private PayWayControlUtil() {
    }

    private static final class SingleHolder {
        private static final PayWayControlUtil INSTANCE = new PayWayControlUtil();

        private SingleHolder() {
        }
    }

    public static PayWayControlUtil getInstance() {
        return SingleHolder.INSTANCE;
    }

    public void pay(final Activity activity, DMGetOrderBean dMGetOrderBean, int i, int i2) {
        String str = "";
        if (dMGetOrderBean.payInfo != null && (StringUtils.isNotEmpty(dMGetOrderBean.payInfo.tradeNo) || StringUtils.isNotEmpty(dMGetOrderBean.payInfo.orderString))) {
            if (dMGetOrderBean.payInfo.mode == 0) {
                str = dMGetOrderBean.payInfo.orderString;
            } else if (dMGetOrderBean.payInfo.mode == 1) {
                str = dMGetOrderBean.payInfo.tradeNo;
            }
            AliPayUtils.pay(activity, str, new AliPayUtils.OnPayListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.payutil.PayWayControlUtil.1
                @Override // client.android.yixiaotong.alipay.AliPayUtils.OnPayListener
                public void paySuccess() {
                    if (PayWayControlUtil.this.mOnPayWayListener != null) {
                        PayWayControlUtil.this.mOnPayWayListener.onPayResult(0);
                    }
                    ToastUtils.show(activity, "支付成功");
                }

                @Override // client.android.yixiaotong.alipay.AliPayUtils.OnPayListener
                public void payWaitting() {
                    ToastUtils.show(activity, "正在等待支付结果,稍后会收到服务器确认的支付结果");
                }

                @Override // client.android.yixiaotong.alipay.AliPayUtils.OnPayListener
                public void payFail() {
                    if (PayWayControlUtil.this.mOnPayWayListener != null) {
                        PayWayControlUtil.this.mOnPayWayListener.onPayResult(-1);
                    }
                    ToastUtils.show(activity, "支付失败");
                }
            });
            return;
        }
        if (dMGetOrderBean.payInfo != null && StringUtils.isNotEmpty(dMGetOrderBean.payInfo.appid)) {
            WxPayUtils.pay(activity, dMGetOrderBean.payInfo.appid, dMGetOrderBean.payInfo.partnerid, dMGetOrderBean.payInfo.prepayid, dMGetOrderBean.payInfo.noncestr, dMGetOrderBean.payInfo.timestamp, dMGetOrderBean.payInfo.sign);
            return;
        }
        if (dMGetOrderBean.payInfo != null && dMGetOrderBean.payInfo.msgBody != null) {
            if (dMGetOrderBean.payInfo.msgBody.retCode.equals("00000")) {
                GnetePayConfig.builder().createWXAPI(activity, "wxd9320c1760b6d01f");
                V3WalletControlUtil.getInstance().init(activity);
                V3WalletControlUtil.getInstance().sendPayRequest(dMGetOrderBean.payInfo.msgBody.chnlUrl, 0, 0);
                return;
            }
            SystemErrorTip.getInstance().showTipDialog(activity, dMGetOrderBean.payInfo.msgBody.retMsg);
            return;
        }
        if (dMGetOrderBean.payInfo != null && StringUtils.isNotEmpty(dMGetOrderBean.payInfo.tranData) && StringUtils.isNotEmpty(dMGetOrderBean.payInfo.merSignMsg)) {
            payICBC(activity, dMGetOrderBean, i2);
            return;
        }
        if (dMGetOrderBean.payInfo == null) {
            SystemErrorTip.getInstance().showTipDialog(activity, "数据异常");
            return;
        }
        if (i == 1) {
            WxPayUtils.pay(activity, dMGetOrderBean.payInfo.appid, dMGetOrderBean.payInfo.partnerid, dMGetOrderBean.payInfo.prepayid, dMGetOrderBean.payInfo.noncestr, dMGetOrderBean.payInfo.timestamp, dMGetOrderBean.payInfo.sign);
            return;
        }
        if (i == 2) {
            if (dMGetOrderBean.payInfo.mode == 0) {
                str = dMGetOrderBean.payInfo.orderString;
            } else if (dMGetOrderBean.payInfo.mode == 1) {
                str = dMGetOrderBean.payInfo.tradeNo;
            }
            AliPayUtils.pay(activity, str, new AliPayUtils.OnPayListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.payutil.PayWayControlUtil.2
                @Override // client.android.yixiaotong.alipay.AliPayUtils.OnPayListener
                public void paySuccess() {
                    if (PayWayControlUtil.this.mOnPayWayListener != null) {
                        PayWayControlUtil.this.mOnPayWayListener.onPayResult(0);
                    }
                    ToastUtils.show(activity, "支付成功");
                }

                @Override // client.android.yixiaotong.alipay.AliPayUtils.OnPayListener
                public void payWaitting() {
                    ToastUtils.show(activity, "正在等待支付结果,稍后会收到服务器确认的支付结果");
                }

                @Override // client.android.yixiaotong.alipay.AliPayUtils.OnPayListener
                public void payFail() {
                    ToastUtils.show(activity, "支付失败");
                    if (PayWayControlUtil.this.mOnPayWayListener != null) {
                        PayWayControlUtil.this.mOnPayWayListener.onPayResult(-1);
                    }
                }
            });
            return;
        }
        if (i != 3) {
            if (i == 12) {
                payICBC(activity, dMGetOrderBean, i2);
            }
        } else if (dMGetOrderBean.payInfo != null && dMGetOrderBean.payInfo.msgBody != null && dMGetOrderBean.payInfo.msgBody.retCode.equals("00000")) {
            GnetePayConfig.builder().createWXAPI(activity, "wxd9320c1760b6d01f");
            V3WalletControlUtil.getInstance().sendPayRequest(dMGetOrderBean.payInfo.msgBody.chnlUrl, 0, 0);
        } else if (dMGetOrderBean.payInfo != null && dMGetOrderBean.payInfo.msgBody != null) {
            SystemErrorTip.getInstance().showTipDialog(activity, dMGetOrderBean.payInfo.msgBody.retMsg);
        } else {
            SystemErrorTip.getInstance().showTipDialog(activity, "数据异常");
        }
    }

    private void payICBC(final Activity activity, DMGetOrderBean dMGetOrderBean, int i) {
        ICBCPayUtils.payAll(i, dMGetOrderBean.payInfo.appId, activity, ICBCPayUtils.getUnionPayReq(dMGetOrderBean.payInfo.appId, dMGetOrderBean.payInfo.msgId, dMGetOrderBean.payInfo.format, dMGetOrderBean.payInfo.charset, dMGetOrderBean.payInfo.encryptType, dMGetOrderBean.payInfo.signType, dMGetOrderBean.payInfo.merSignMsg, dMGetOrderBean.payInfo.timestamp, dMGetOrderBean.payInfo.ca, dMGetOrderBean.payInfo.tranData, dMGetOrderBean.payInfo.encryptKey), new ICBCPayUtils.OnPayListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.payutil.PayWayControlUtil.3
            @Override // client.android.yixiaotong.icbcPay.ICBCPayUtils.OnPayListener
            public void paySuccess() {
                ToastUtils.show(activity, "支付成功");
            }

            @Override // client.android.yixiaotong.icbcPay.ICBCPayUtils.OnPayListener
            public void payWaitting() {
                ToastUtils.show(activity, "正在等待支付结果,稍后会收到服务器确认的支付结果");
            }

            @Override // client.android.yixiaotong.icbcPay.ICBCPayUtils.OnPayListener
            public void payFail() {
                ToastUtils.show(activity, "支付失败");
            }
        });
    }
}
