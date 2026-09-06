package client.android.yixiaotong.ui.doorlock;

import android.app.Activity;
import android.client.bluetoothsdk.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.controller.store.LocalBusinessStore;
import client.android.yixiaotong.ui.widget.TitleBar;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.stub.StubApp;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class RouseTipActivity extends BaseActivity {
    private static final String EXTRA_DEVICE = "bluetoothdevice";
    private static final String EXTRA_STATE = "extra_state";
    private BluetoothDevice mBluetoothDevice;
    private ImageView mImgGif;
    private ImageView mImgTip;
    private boolean mIsSelectTip = false;
    private int mState;
    private TitleBar mTitleBar;
    private WalletModel mWalletModel;

    static {
        StubApp.interface11(7002);
    }

    private boolean isDelectKey() {
        int i = this.mState;
        return i == 8 || i == 10 || i == 11 || i == 14;
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, int i, BluetoothDevice bluetoothDevice) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) RouseTipActivity.class).putExtra("extra_state", i).putExtra("bluetoothdevice", bluetoothDevice));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titlebar);
        this.mImgTip = (ImageView) findViewById(R.id.img);
        this.mImgGif = (ImageView) findViewById(R.id.img_gif);
    }

    private void initTitleBar() {
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
        this.mTitleBar.setTitleView("唤醒设备");
        this.mTitleBar.setLeftView(R.mipmap.back);
    }

    private void initWallet() {
        BusinessControllers.getInstance().getWalletModels(getLoginAccount(), new Listener<List<WalletModel>>() { // from class: client.android.yixiaotong.ui.doorlock.RouseTipActivity.1
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, List<WalletModel> list, Object... objArr) {
                if (list != null && list.size() > 0) {
                    for (WalletModel walletModel : list) {
                        if (walletModel.typeId == 10) {
                            RouseTipActivity.this.mWalletModel = walletModel;
                        }
                    }
                }
                if (RouseTipActivity.this.mWalletModel == null) {
                    RouseTipActivity.this.finish();
                }
            }
        });
    }

    private void initClickListeners() {
        findViewById(R.id.rel_tip).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.doorlock.RouseTipActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m114x86f436f9(view);
            }
        });
        findViewById(R.id.btn_next).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.doorlock.RouseTipActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m115x882a89d8(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-ui-doorlock-RouseTipActivity, reason: not valid java name */
    /* synthetic */ void m114x86f436f9(View view) {
        toggleTipSelection();
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$1$client-android-yixiaotong-ui-doorlock-RouseTipActivity, reason: not valid java name */
    /* synthetic */ void m115x882a89d8(View view) {
        toLaunch(this.mBluetoothDevice);
    }

    private void toggleTipSelection() {
        boolean z = !this.mIsSelectTip;
        this.mIsSelectTip = z;
        this.mImgTip.setBackgroundResource(z ? R.mipmap.l_choose_box2 : R.mipmap.l_choose_box);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (isDelectKey()) {
            DelectKeyController.getInstance().onResume();
        } else if (this.mState == 13) {
            RecordController.getInstance().onResume();
        }
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        if (isDelectKey()) {
            DelectKeyController.getInstance().onPause();
        } else if (this.mState == 13) {
            RecordController.getInstance().onPause();
        }
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        LocalBusinessStore.saveDoorLockTip(getContext(), this.mIsSelectTip);
    }

    private void toLaunch(BluetoothDevice bluetoothDevice) {
        Log.e("test", (bluetoothDevice == null) + PPSLabelView.Code + this.mState);
        int i = this.mState;
        if (i == 5) {
            AddKeyActivity.launch(getActivity(), bluetoothDevice);
            finish();
            return;
        }
        if (i == 6) {
            UpdateKeyActivity.launch(getActivity(), bluetoothDevice, "");
            finish();
            return;
        }
        if (i == 8) {
            DelectKeyController.getInstance().init(getActivity(), getLoginAccount(), this.mWalletModel, bluetoothDevice, this.mState);
            return;
        }
        if (i == 7) {
            return;
        }
        if (i == 9) {
            AddCardActivity.launch(getActivity(), bluetoothDevice);
            finish();
            return;
        }
        if (i == 10) {
            DelectKeyController.getInstance().init(getActivity(), getLoginAccount(), this.mWalletModel, bluetoothDevice, this.mState);
            return;
        }
        if (i == 11) {
            DelectKeyController.getInstance().init(getActivity(), getLoginAccount(), this.mWalletModel, bluetoothDevice, this.mState);
            return;
        }
        if (i == 12) {
            AddPressActivity.launch(getActivity(), bluetoothDevice);
            finish();
        } else if (i == 13) {
            RecordController.getInstance().init(getLoginAccount(), getActivity(), bluetoothDevice);
        } else if (i == 14) {
            DelectKeyController.getInstance().init(getActivity(), getLoginAccount(), this.mWalletModel, bluetoothDevice, this.mState);
        }
    }
}
