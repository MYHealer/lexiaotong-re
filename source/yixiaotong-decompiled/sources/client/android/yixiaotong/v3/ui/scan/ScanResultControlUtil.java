package client.android.yixiaotong.v3.ui.scan;

import android.app.Activity;
import android.content.Intent;
import client.android.yixiaotong.account.Account;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.v3.ui.appcontrol.bath.BathDetailActivity;
import client.android.yixiaotong.v3.ui.appcontrol.drawmoney.DMRechargeActivity;
import client.android.yixiaotong.v3.ui.appcontrol.drawmoney.DWQrcodeActivity;
import client.android.yixiaotong.v3.ui.appcontrol.drinkwater.DrinkWaterDetailActivity;
import client.android.yixiaotong.v3.ui.appcontrol.dry.DryModeActivity;
import client.android.yixiaotong.v3.ui.appcontrol.hairdryer.HairdryerDetailActivity;
import client.android.yixiaotong.v3.ui.appcontrol.wash.WashModeActivity;
import client.android.yixiaotong.v3.ui.control.ScanControlUtil;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import client.android.yixiaotong.v3.util.LogUtil;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ScanResultControlUtil {
    private static final String TAG = "ScanResultControlUtil";
    private Account mAccount;
    private Activity mActivity;

    public ScanResultControlUtil(Activity activity, Account account) {
        this.mActivity = activity;
        this.mAccount = account;
    }

    public void onResume() {
        ScanControlUtil.getInstance().onResume();
    }

    public void onPause() {
        ScanControlUtil.getInstance().onPause();
    }

    public void onResult(int i, String str) {
        String str2 = TAG;
        LogUtil.e(str2, "onResult:" + i + "  " + str);
        if (i == 1) {
            Intent intent = new Intent();
            intent.putExtra("qrcode", str);
            this.mActivity.setResult(1, intent);
            this.mActivity.finish();
            return;
        }
        if (i == 3) {
            Intent intent2 = new Intent();
            intent2.putExtra("qrcode", str);
            this.mActivity.setResult(3, intent2);
            this.mActivity.finish();
            return;
        }
        if (i == 5) {
            if (str.contains("?")) {
                String[] strArrSplit = str.split("\\?");
                if (strArrSplit.length > 1 && strArrSplit[1].length() >= 52) {
                    str = strArrSplit[1];
                }
            }
            DrinkWaterDetailActivity.launch(this.mActivity, str);
            this.mActivity.finish();
            return;
        }
        if (i == 6) {
            if (str.contains("?")) {
                String[] strArrSplit2 = str.split("\\?");
                if (strArrSplit2.length > 1 && strArrSplit2[1].length() >= 52) {
                    str = strArrSplit2[1];
                }
            }
            HairdryerDetailActivity.launch(this.mActivity, str);
            this.mActivity.finish();
            return;
        }
        if (i == 7) {
            WashModeActivity.launch(this.mActivity, str);
            this.mActivity.finish();
            return;
        }
        if (i == 9) {
            DryModeActivity.launch(this.mActivity, str);
            this.mActivity.finish();
            return;
        }
        if (i == 8) {
            String unFinshOrderTd = LocalDataUtil.getUnFinshOrderTd(this.mActivity);
            if (StringUtils.isNotEmpty(unFinshOrderTd)) {
                if (str.contains("?")) {
                    String[] strArrSplit3 = str.split("\\?");
                    if (strArrSplit3.length > 1) {
                        str = strArrSplit3[1];
                    }
                }
                String[] strArrSplit4 = unFinshOrderTd.split(",");
                LogUtil.e(str2, str + "  " + strArrSplit4[2]);
                if (StringUtils.isNotEmpty(str) && str.length() > 10) {
                    if (str.substring(2, 10).equals(strArrSplit4[2])) {
                        DWQrcodeActivity.launch(this.mActivity, str, Integer.parseInt(strArrSplit4[1]), strArrSplit4[0]);
                    } else {
                        ToastUtils.show(this.mActivity, "请勿更换设备领款");
                    }
                    this.mActivity.finish();
                    return;
                }
                ToastUtils.show(this.mActivity, "不合法的二维码");
                this.mActivity.finish();
                return;
            }
            if (str.contains("?")) {
                String[] strArrSplit5 = str.split("\\?");
                if (strArrSplit5.length > 1) {
                    str = strArrSplit5[1];
                }
            }
            DMRechargeActivity.launch(this.mActivity, str);
            this.mActivity.finish();
            return;
        }
        if (i == 10) {
            if (str.contains("?")) {
                String[] strArrSplit6 = str.split("\\?");
                if (strArrSplit6.length > 1 && strArrSplit6[1].length() >= 52) {
                    str = strArrSplit6[1];
                }
            }
            BathDetailActivity.launch(this.mActivity, str, false);
            this.mActivity.finish();
            return;
        }
        if (i == 11) {
            ScanControlUtil.getInstance().init(this.mActivity, this.mAccount, "首页扫一扫");
            ScanControlUtil.getInstance().onScan(str);
            return;
        }
        if (i == 13) {
            Intent intent3 = new Intent();
            intent3.putExtra("qrcode", str);
            this.mActivity.setResult(13, intent3);
            this.mActivity.finish();
            return;
        }
        if (i == 14) {
            Intent intent4 = new Intent();
            intent4.putExtra("qrcode", str);
            this.mActivity.setResult(14, intent4);
            this.mActivity.finish();
            return;
        }
        if (i == 15) {
            Intent intent5 = new Intent();
            intent5.putExtra("qrcode", str);
            this.mActivity.setResult(15, intent5);
            this.mActivity.finish();
            return;
        }
        if (i == 16) {
            if (str.contains("?")) {
                String[] strArrSplit7 = str.split("\\?");
                if (strArrSplit7.length > 1 && strArrSplit7[1].length() >= 52) {
                    str = strArrSplit7[1];
                }
            }
            Intent intent6 = new Intent();
            intent6.putExtra("qrcode", str);
            this.mActivity.setResult(16, intent6);
            this.mActivity.finish();
            return;
        }
        this.mActivity.finish();
    }
}
