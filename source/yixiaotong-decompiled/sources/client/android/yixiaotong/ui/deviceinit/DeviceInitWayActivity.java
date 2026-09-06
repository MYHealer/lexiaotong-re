package client.android.yixiaotong.ui.deviceinit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.ui.scancode.ScanQrcodeOrBarcodeActivity;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.ToastUtils;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class DeviceInitWayActivity extends BaseActivity {
    public static final String EXTRA_WALLET = "extra_wallet";
    private RelativeLayout mRelBle;
    private RelativeLayout mRelSaoMa;
    private RelativeLayout mRelSet;
    private TitleBar mTitleBar;
    private WalletModel mWalletModel;

    static {
        StubApp.interface11(6732);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, WalletModel walletModel) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) DeviceInitWayActivity.class).putExtra("extra_wallet", walletModel));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.tb_name);
        this.mRelSaoMa = (RelativeLayout) findViewById(R.id.rel_saoma);
        this.mRelBle = (RelativeLayout) findViewById(R.id.rel_ble);
        this.mRelSet = (RelativeLayout) findViewById(R.id.rel_set);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView("设备管理");
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
        this.mTitleBar.setLeftView(R.mipmap.back);
    }

    private void initView() {
        this.mRelSaoMa.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.deviceinit.DeviceInitWayActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DeviceInitWayActivity.this.initWay(true);
            }
        });
        this.mRelBle.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.deviceinit.DeviceInitWayActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DeviceInitWayActivity.this.initWay(false);
            }
        });
        this.mRelSet.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.deviceinit.DeviceInitWayActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (DeviceInitWayActivity.this.mWalletModel.typeId == 6) {
                    ToastUtils.show(DeviceInitWayActivity.this.getContext(), "暂未开通！");
                } else if (DeviceInitWayActivity.this.mWalletModel.typeId == 1) {
                    DeviceInitBathActivity.launch(DeviceInitWayActivity.this.getActivity(), DeviceInitWayActivity.this.mWalletModel, false);
                    DeviceInitWayActivity.this.finish();
                } else {
                    ToastUtils.show(DeviceInitWayActivity.this.getContext(), "暂未开通！");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initWay(boolean z) {
        if (this.mWalletModel.typeId == 6) {
            if (z) {
                ToastUtils.show(getContext(), "暂未开通！");
                return;
            } else {
                ToastUtils.show(getContext(), "暂未开通！");
                return;
            }
        }
        if (this.mWalletModel.typeId == 1) {
            if (z) {
                ToastUtils.show(getContext(), "暂未开通！");
                return;
            } else {
                DeviceInitBathActivity.launch(getActivity(), this.mWalletModel, true);
                finish();
                return;
            }
        }
        if (this.mWalletModel.typeId == 11) {
            if (z) {
                ScanQrcodeOrBarcodeActivity.launch(getActivity(), this.mWalletModel, "", 11);
                finish();
            } else {
                ToastUtils.show(getContext(), "暂未开通！");
            }
        }
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }
}
