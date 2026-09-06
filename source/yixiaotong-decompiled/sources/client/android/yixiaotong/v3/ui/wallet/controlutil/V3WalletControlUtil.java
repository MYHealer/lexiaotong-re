package client.android.yixiaotong.v3.ui.wallet.controlutil;

import android.app.Activity;
import android.text.TextUtils;
import client.android.yixiaotong.v3.userinfo.InvestorInfoUtilControl;
import client.android.yixiaotong.v3.util.LogUtil;
import com.gnete.upbc.cashier.GnetePayChannel;
import com.gnete.upbc.cashier.GnetePayConfig;
import com.gnete.upbc.cashier.GnetePayListener;
import com.gnete.upbc.cashier.GnetePayPlugin;
import com.gnete.upbc.cashier.GnetePayRequest;
import com.gnete.upbc.cashier.GnetePayResult;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V3WalletControlUtil {
    public static final int ALIPAY = 2;
    public static final int CASHIER = 4;
    public static final int CUPPAY = 3;
    private static final String TAG = "V3WalletControlUtil";
    public static final int WXPAY = 1;
    private Activity mActivity;
    private GnetePayListener mPayListener;

    private void V3WalletControlUtil() {
    }

    private static class SingletonHolder {
        public static final V3WalletControlUtil INSTANCE = new V3WalletControlUtil();

        private SingletonHolder() {
        }
    }

    public static V3WalletControlUtil getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void init(Activity activity) {
        this.mActivity = activity;
        this.mPayListener = new GnetePayListener() { // from class: client.android.yixiaotong.v3.ui.wallet.controlutil.V3WalletControlUtil.1
            @Override // com.gnete.upbc.cashier.GnetePayListener
            public void onGnetePayResult(GnetePayChannel gnetePayChannel, GnetePayResult gnetePayResult, String str) {
                LogUtil.e(V3WalletControlUtil.TAG, gnetePayChannel.toString() + "  " + gnetePayResult.getMsg() + "  " + str);
            }
        };
    }

    private void sendPayRequest(String str, int i) {
        GnetePayRequest gnetePayRequest = new GnetePayRequest();
        gnetePayRequest.chnlUrl = str;
        if (i == 1) {
            gnetePayRequest.payChannel = GnetePayChannel.WXPAY;
        } else if (i == 2) {
            gnetePayRequest.payChannel = GnetePayChannel.ALIPAY;
        } else if (i == 3) {
            gnetePayRequest.payChannel = GnetePayChannel.CUPPAY;
        } else {
            gnetePayRequest.payChannel = GnetePayChannel.CASHIER;
        }
        GnetePayPlugin.sendPayRequest(this.mActivity, gnetePayRequest, this.mPayListener);
    }

    public void sendPayRequestForWX(String str, String str2) {
        GnetePayConfig.builder().createWXAPI(this.mActivity, str);
        JsonObject asJsonObject = new JsonParser().parse(str2).getAsJsonObject();
        if (TextUtils.equals("00000", asJsonObject.get("retCode").getAsString())) {
            String asString = asJsonObject.get("chnlUrl").getAsString();
            GnetePayRequest gnetePayRequest = new GnetePayRequest();
            gnetePayRequest.chnlUrl = asString;
            gnetePayRequest.payChannel = GnetePayChannel.WXPAY;
            GnetePayPlugin.sendPayRequest(this.mActivity, gnetePayRequest);
        }
    }

    public void sendPayRequestForALi(String str) {
        JsonObject asJsonObject = new JsonParser().parse(str).getAsJsonObject();
        if (TextUtils.equals("00000", asJsonObject.get("retCode").getAsString())) {
            String asString = asJsonObject.get("chnlUrl").getAsString();
            GnetePayRequest gnetePayRequest = new GnetePayRequest();
            gnetePayRequest.chnlUrl = asString;
            gnetePayRequest.payChannel = GnetePayChannel.ALIPAY;
            GnetePayPlugin.sendPayRequest(this.mActivity, gnetePayRequest);
        }
    }

    public void sendPayRequestForCUP(String str) {
        GnetePayRequest gnetePayRequest = new GnetePayRequest();
        gnetePayRequest.chnlUrl = str;
        gnetePayRequest.payChannel = GnetePayChannel.CUPPAY;
        GnetePayPlugin.sendPayRequest(this.mActivity, gnetePayRequest);
    }

    public void sendPayRequestForCashier(String str) {
        GnetePayRequest gnetePayRequest = new GnetePayRequest();
        gnetePayRequest.chnlUrl = str;
        gnetePayRequest.payChannel = GnetePayChannel.CASHIER;
        GnetePayPlugin.sendPayRequest(this.mActivity, gnetePayRequest);
    }

    public void sendPayRequest(String str, int i, int i2) {
        if (isCashier(i, i2)) {
            sendPayRequestForCashier(str);
        } else {
            sendPayRequestForCUP(str);
        }
    }

    private boolean isCashier(int i, int i2) {
        List<Integer> payFlagTypeList;
        if ((i == 1 || i == 2) && (payFlagTypeList = InvestorInfoUtilControl.getInstance().getPayFlagTypeList(i)) != null) {
            Iterator<Integer> it = payFlagTypeList.iterator();
            while (it.hasNext()) {
                int iIntValue = it.next().intValue();
                if (iIntValue == 1 || iIntValue == 2) {
                    return false;
                }
            }
        }
        LogUtil.e(TAG, "isCashier");
        if (i2 > 0) {
            return !InvestorInfoUtilControl.getInstance().isContainWxAndAliPay(i2);
        }
        return true;
    }
}
