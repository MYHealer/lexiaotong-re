package client.android.yixiaotong.ui.doorlock;

import android.app.Activity;
import android.client.bluetoothsdk.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.controller.store.LocalBusinessStore;
import client.android.yixiaotong.ui.widget.TitleBar;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class DangerTipActivity extends BaseActivity {
    private static final String EXTRA_DEVICE = "bluetoothdevice";
    private BluetoothDevice mBluetoothDevice;
    private long mDangerStartTime;
    private TitleBar mTitleBar;
    private TextView mTvAddress;
    private TextView mTvDay;
    private TextView mTvDayText;
    private TextView mTvHour;
    private TextView mTvSec;
    private WalletModel mWalletModel;
    private List<String> mTimeList = new ArrayList();
    private Handler mHandler = new Handler() { // from class: client.android.yixiaotong.ui.doorlock.DangerTipActivity.2
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            DangerTipActivity.this.mHandler.sendEmptyMessageDelayed(0, 60000L);
            DangerTipActivity.this.initTimeView();
        }
    };

    static {
        StubApp.interface11(6931);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, BluetoothDevice bluetoothDevice) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) DangerTipActivity.class).putExtra("bluetoothdevice", bluetoothDevice));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titlebar);
        this.mTvAddress = (TextView) findViewById(R.id.tv_address);
        this.mTvDay = (TextView) findViewById(R.id.tv_day);
        this.mTvDayText = (TextView) findViewById(R.id.tv_textday);
        this.mTvHour = (TextView) findViewById(R.id.tv_hour);
        this.mTvSec = (TextView) findViewById(R.id.tv_sec);
    }

    private void initTitleBar() {
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
        this.mTitleBar.setTitleView(getResources().getString(R.string.doorlock_safe_tip));
    }

    private void initWallet() {
        BusinessControllers.getInstance().getWalletModels(getLoginAccount(), new Listener<List<WalletModel>>() { // from class: client.android.yixiaotong.ui.doorlock.DangerTipActivity.1
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, List<WalletModel> list, Object... objArr) {
                if (list != null && list.size() > 0) {
                    for (WalletModel walletModel : list) {
                        if (walletModel.typeId == 10) {
                            DangerTipActivity.this.mWalletModel = walletModel;
                        }
                    }
                }
                if (DangerTipActivity.this.mWalletModel == null) {
                    DangerTipActivity.this.finish();
                }
            }
        });
    }

    private void initView() {
        this.mTvAddress.setText(LocalBusinessStore.getDoorLockRoomAddress(getContext()));
        this.mDangerStartTime = LocalBusinessStore.getDoorLockDangerTime(getContext());
        initTimeView();
        this.mHandler.sendEmptyMessageDelayed(0, 60000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initTimeView() {
        List<String> listChange = change((int) ((System.currentTimeMillis() / 1000) - this.mDangerStartTime));
        this.mTimeList = listChange;
        if (listChange.size() == 3) {
            if (this.mTimeList.get(0).equals("0")) {
                this.mTvDay.setVisibility(8);
                this.mTvDayText.setVisibility(8);
            } else {
                this.mTvDay.setVisibility(0);
                this.mTvDayText.setVisibility(0);
            }
            this.mTvDay.setText(this.mTimeList.get(0));
            this.mTvHour.setText(this.mTimeList.get(1));
            this.mTvSec.setText(this.mTimeList.get(2));
        }
    }

    private void initClickListeners() {
        findViewById(R.id.btn_manage).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.doorlock.DangerTipActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m103x8a67ff0e(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-ui-doorlock-DangerTipActivity, reason: not valid java name */
    /* synthetic */ void m103x8a67ff0e(View view) {
        toLaunch();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DelectKeyController.getInstance().onResume();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        DelectKeyController.getInstance().onPause();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.mHandler.removeMessages(0);
        this.mHandler.removeCallbacksAndMessages(null);
    }

    private void toLaunch() {
        if (LocalBusinessStore.getDoorLockTip(getContext())) {
            DelectKeyController.getInstance().init(getActivity(), getLoginAccount(), this.mWalletModel, this.mBluetoothDevice, 14);
        } else {
            RouseTipActivity.launch(getActivity(), 14, this.mBluetoothDevice);
            finish();
        }
    }

    public List<String> change(int i) {
        int i2;
        int i3;
        int i4;
        this.mTimeList.clear();
        if (i >= 86400) {
            i2 = i / 86400;
            int i5 = i - (86400 * i2);
            i4 = i5 / 3600;
            i3 = (i5 - (i4 * 3600)) / 60;
        } else {
            i2 = 0;
            if (i >= 3600) {
                i4 = i / 3600;
                i3 = (i - (i4 * 3600)) / 60;
            } else if (i >= 60) {
                i3 = i / 60;
                i4 = 0;
            } else {
                i3 = 0;
                i4 = 0;
            }
        }
        this.mTimeList.add(i2 + "");
        this.mTimeList.add(i4 + "");
        this.mTimeList.add(i3 + "");
        return this.mTimeList;
    }
}
