package client.android.yixiaotong.v3.ui.appcontrol.drawmoney;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.ammeter.AmmeterWalletDetailActivity;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.v3.bean.drawmoney.DMGetQrcodeBean;
import client.android.yixiaotong.v3.bean.drawmoney.DMHandleDataBean;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.ui.error.V3ErrorTipActivity;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import com.huawei.hms.hmsscankit.ScanUtil;
import com.huawei.hms.hmsscankit.WriterException;
import com.huawei.hms.ml.scan.HmsBuildBitmapOption;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class DWQrcodeActivity extends BaseActivity {
    private boolean mIsEnable = true;
    private ImageView mIvQrcode;
    private String mMachineId;
    private int mMoney;
    private String mOrderId;
    private String mQrcode;
    private TitleBar mTitleBar;

    static {
        StubApp.interface11(9155);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, String str, int i, String str2) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) DWQrcodeActivity.class).putExtra("qrcode", str).putExtra(AmmeterWalletDetailActivity.EXTRA_MONEY, i).putExtra(AmmeterWalletDetailActivity.EXTRA_ORDERID, str2));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mIvQrcode = (ImageView) findViewById(R.id.iv_qrcode);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView("领款机");
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mIsEnable = true;
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mIsEnable = false;
        BaseMaterialDialog.dissmisMaterialDialog();
    }

    private void handleData() {
        V3BusinessControllers.getInstance().postDMHandleData(getLoginAccount(), 20, this.mMachineId, this.mQrcode, new Listener<DMHandleDataBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.drawmoney.DWQrcodeActivity.1
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(DWQrcodeActivity.this.getActivity(), "加载中..", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, DMHandleDataBean dMHandleDataBean, Object... objArr) {
                if (DWQrcodeActivity.this.mIsEnable) {
                    DWQrcodeActivity.this.getQrcode();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (DWQrcodeActivity.this.mIsEnable) {
                    DWQrcodeActivity.this.onError(clientException);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getQrcode() {
        V3BusinessControllers.getInstance().getDMChargeQRCode(getLoginAccount(), 20, this.mMachineId, this.mQrcode, this.mMoney, this.mOrderId, new Listener<DMGetQrcodeBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.drawmoney.DWQrcodeActivity.2
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(DWQrcodeActivity.this.getActivity(), "加载中...", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, DMGetQrcodeBean dMGetQrcodeBean, Object... objArr) {
                Bitmap bitmapBuildBitmap;
                if (DWQrcodeActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    if (dMGetQrcodeBean == null || !StringUtils.isNotEmpty(dMGetQrcodeBean.qrCode)) {
                        DWQrcodeActivity.this.showDialog(true, true, false, "数据异常");
                        return;
                    }
                    try {
                        bitmapBuildBitmap = ScanUtil.buildBitmap(dMGetQrcodeBean.qrCode, 0, DWQrcodeActivity.this.mIvQrcode.getWidth(), DWQrcodeActivity.this.mIvQrcode.getHeight(), new HmsBuildBitmapOption.Creator().setBitmapMargin(1).setBitmapColor(-16777216).setBitmapBackgroundColor(-1).create());
                    } catch (WriterException e) {
                        e.printStackTrace();
                        bitmapBuildBitmap = null;
                    }
                    if (bitmapBuildBitmap != null) {
                        DWQrcodeActivity.this.mIvQrcode.setImageBitmap(bitmapBuildBitmap);
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (DWQrcodeActivity.this.mIsEnable) {
                    DWQrcodeActivity.this.onError(clientException);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(ClientException clientException) {
        BaseMaterialDialog.dissmisMaterialDialog();
        if (clientException.isNeedTip(clientException.getCode())) {
            showDialog(true, true, false, clientException.getDetail());
        } else {
            V3ErrorTipActivity.launch(getActivity(), this.mTitleBar.getTitleViewContent(), clientException.getDetail(), clientException.getCode(), 2, clientException.getSerial());
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog(boolean z, boolean z2, boolean z3, String str) {
        if (z2) {
            str = str + "\n(" + LocalDataUtil.getTraceID(getContext()) + ")";
        }
        String str2 = str;
        if (z && !z3) {
            SystemErrorTip.getInstance().showTipDialog(getActivity(), "", str2, "", false, new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.drawmoney.DWQrcodeActivity.3
                @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                public void onConfirm() {
                    DWQrcodeActivity.this.finish();
                }
            });
        } else if (z && z3) {
            SystemErrorTip.getInstance().showTipDialog(getActivity(), new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.drawmoney.DWQrcodeActivity.4
                @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                public void onConfirm() {
                    DWQrcodeActivity.this.finish();
                }
            }, str2);
        } else {
            SystemErrorTip.getInstance().showTipDialog(getActivity(), str2);
        }
    }
}
