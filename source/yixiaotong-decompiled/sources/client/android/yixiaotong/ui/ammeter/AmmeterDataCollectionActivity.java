package client.android.yixiaotong.ui.ammeter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.ui.widget.TitleBar;
import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class AmmeterDataCollectionActivity extends BaseActivity {
    public static final String EXTRA_QRCODEDATA = "extra_qrcodedata";
    public static final String EXTRA_WALLET = "extra_wallet";
    private RelativeLayout mChargeAmmeter;
    private RelativeLayout mDataColection;
    private String mQrcodeData;
    private TitleBar mTitleBar;
    private WalletModel mWalletModel;

    static {
        StubApp.interface11(6194);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, WalletModel walletModel) {
        if (activity != null) {
            Intent intent = new Intent(activity, (Class<?>) AmmeterDataCollectionActivity.class);
            intent.putExtra("extra_wallet", walletModel);
            activity.startActivity(intent);
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mDataColection = (RelativeLayout) findViewById(R.id.rel_datacolection);
        this.mChargeAmmeter = (RelativeLayout) findViewById(R.id.rel_chargerammeter);
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.ui.ammeter.AmmeterDataCollectionActivity$1, reason: invalid class name */
    class AnonymousClass1 implements View.OnClickListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            new MaterialDialog.Builder(AmmeterDataCollectionActivity.this.getContext()).title("提示").content("采集数据后这台电表就不能正常给学生充值使用了，需要更换新电表后才能正常使用，是否要继续采集数据？").positiveText("确定").onPositive(new MaterialDialog.SingleButtonCallback() { // from class: client.android.yixiaotong.ui.ammeter.AmmeterDataCollectionActivity.1.2
                @Override // com.afollestad.materialdialogs.MaterialDialog.SingleButtonCallback
                public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
                    HuaWeiScanActivity.launch(AmmeterDataCollectionActivity.this.getActivity(), AmmeterDataCollectionActivity.this.mWalletModel, 2);
                }
            }).negativeText("取消").onNegative(new MaterialDialog.SingleButtonCallback() { // from class: client.android.yixiaotong.ui.ammeter.AmmeterDataCollectionActivity.1.1
                @Override // com.afollestad.materialdialogs.MaterialDialog.SingleButtonCallback
                public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
                }
            }).show();
        }
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.ui.ammeter.AmmeterDataCollectionActivity$2, reason: invalid class name */
    class AnonymousClass2 implements View.OnClickListener {
        AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            HuaWeiScanActivity.launch(AmmeterDataCollectionActivity.this.getActivity(), AmmeterDataCollectionActivity.this.mWalletModel, 4);
            AmmeterDataCollectionActivity.this.finish();
        }
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView("选择操作");
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }
}
