package client.android.yixiaotong.ui.drinkwater;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.drinkwater.PreferenceUtil;
import client.android.yixiaotong.util.executor.MainThreadExecutor;
import client.android.yixiaotong.util.permission.PermissionUtil;
import client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil;
import client.android.yixiaotong.v3.ui.adv.AdvControlUtil;
import client.android.yixiaotong.v3.ui.adv.Common;
import client.android.yixiaotong.v3.ui.adv.InsertUtil;
import client.android.yixiaotong.zksoundwave.SWCommandUtil;
import client.android.yixiaotong.zksoundwave.soundwavedatamanage.SoundWaveDataListener;
import com.lxt.bluetoothsdk.BluetoothSDK;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class DrinkWaterActivity extends BaseActivity {
    private static final String EXTRA_SCANRESULT = "extra_scanresult";
    private static final String EXTRA_SYSTEM_DATA = "extra_system_data";
    private static final String EXTRA_SYSTEM_TIME = "extra_system_time";
    public static final String EXTRA_WALLET = "extra_wallet";
    private static final String TAG = "DrinkWaterActivity";
    private static final String TYPE_BLUE_CONNECT_AGAIN = "type_blue_connect_again";
    private static final String TYPE_IS_BLUE_CONNECT = "type_is_blue_connect";
    private FrameLayout flContainer;
    private AdvControlUtil.AdvListener mAdvListener;
    private InsertUtil mInsertUtil;
    private String mScanResult;
    private String mSystemData;
    private String mSystemTime;
    private TextView mTime;
    private TimeCount mTimeCount;
    private TitleBar mVTitleBar;
    private WalletModel mWalletModel;
    private boolean mIsEnable = true;
    private PermissionUtil.PermissionGrant permissionGrant = new PermissionUtil.PermissionGrant() { // from class: client.android.yixiaotong.ui.drinkwater.DrinkWaterActivity.3
        @Override // client.android.yixiaotong.util.permission.PermissionUtil.PermissionGrant
        public void onPermissionGranted(int i) {
        }
    };
    private boolean mIsOpenPopAdv = false;

    static {
        StubApp.interface11(7061);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public native void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    private void initViewNew() {
        this.mVTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mTime = (TextView) findViewById(R.id.time);
        this.flContainer = (FrameLayout) findViewById(R.id.flContainer);
    }

    public static void launch(Activity activity, WalletModel walletModel, String str, String str2, String str3) {
        Intent intent = new Intent(activity, (Class<?>) DrinkWaterActivity.class);
        intent.putExtra("extra_wallet", walletModel);
        intent.putExtra(EXTRA_SYSTEM_DATA, str);
        intent.putExtra(EXTRA_SYSTEM_TIME, str2);
        intent.putExtra(EXTRA_SCANRESULT, str3);
        activity.startActivity(intent);
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.ui.drinkwater.DrinkWaterActivity$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DrinkWaterActivity.this.getAdv();
        }
    }

    private void open() {
        if (StringUtils.isNotEmpty(this.mSystemData) && StringUtils.isNotEmpty(this.mSystemTime) && SWCommandUtil.getInstance().checkDataOne(this.mSystemTime, this.mSystemData) && this.mScanResult.length() >= 52) {
            SWCommandUtil.getInstance().sendGetQrcodeData(this.mSystemData, this.mSystemTime);
        }
    }

    private void initEvent() {
        SWCommandUtil.getInstance().initDataManage();
        SWCommandUtil.getInstance().setDataListener(new SoundWaveDataListener() { // from class: client.android.yixiaotong.ui.drinkwater.DrinkWaterActivity.2
            @Override // client.android.yixiaotong.zksoundwave.soundwavedatamanage.SoundWaveDataListener
            public void onQrcodeData(String str, String str2, int i) {
            }

            @Override // client.android.yixiaotong.zksoundwave.soundwavedatamanage.SoundWaveDataListener
            public void onGetQrcodeData(final String str) {
                MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.ui.drinkwater.DrinkWaterActivity.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (StringUtils.isNotEmpty(str)) {
                            BluetoothSDK.getInstance().init(DrinkWaterActivity.this.getActivity());
                            BluetoothControlUtil.getInstance().init(DrinkWaterActivity.this.getActivity());
                            BluetoothControlUtil.getInstance().setSendTimeOut(10000);
                            BluetoothControlUtil.getInstance().sendData(str);
                            return;
                        }
                        ToastUtils.show(DrinkWaterActivity.this.getActivity(), "数据为空");
                    }
                });
            }
        });
    }

    private void initTitleBar() {
        this.mVTitleBar.setTitleView("饮水消费");
        this.mVTitleBar.setLeftView(R.mipmap.back);
        this.mVTitleBar.setLeftViewOnClickBackConnect(getActivity());
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mIsEnable = true;
        AdvControlUtil.getInstance().onResume();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        AdvControlUtil.getInstance().onPause();
        Log.e("onPause", "onPause:" + (this.mInsertUtil != null));
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        Log.e("finish", "finish:" + (this.mInsertUtil != null));
        InsertUtil insertUtil = this.mInsertUtil;
        if (insertUtil != null) {
            insertUtil.onDestroy(getActivity());
        }
        AdvControlUtil.getInstance().onDestroy(getActivity());
        this.mIsEnable = false;
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        BluetoothControlUtil.getInstance().disconnect();
        PreferenceUtil.putIsBlueConnect(getContext(), TYPE_IS_BLUE_CONNECT, false);
        PreferenceUtil.putIsBlueConnectAgain(getContext(), TYPE_BLUE_CONNECT_AGAIN, false);
    }

    class TimeCount extends CountDownTimer {
        public TimeCount(long j, long j2) {
            super(j, j2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            if (DrinkWaterActivity.this.mIsEnable) {
                DrinkWaterActivity.this.finish();
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            if (DrinkWaterActivity.this.mIsEnable) {
                DrinkWaterActivity.this.mTime.setTextColor(-10066330);
                DrinkWaterActivity.this.mTime.setClickable(false);
                DrinkWaterActivity.this.mTime.setText(Html.fromHtml("该页面将在" + (j / 1000) + "后自动关闭"));
                DrinkWaterActivity.this.mTime.setTextSize(12.0f);
                DrinkWaterActivity.this.mTime.setPadding(5, 5, 5, 5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getAdv() {
        this.mInsertUtil = new InsertUtil();
        this.mAdvListener = new AdvControlUtil.AdvListener() { // from class: client.android.yixiaotong.ui.drinkwater.DrinkWaterActivity.4
            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void onAdClosed(Common.AdvType advType) {
            }

            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void onAdShow(String str, Common.AdvType advType) {
            }

            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void onRenderSuccess(View view, int i) {
            }

            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void isOpen(int i, int i2, int i3, int i4, int i5) {
                if (i == 1) {
                    DrinkWaterActivity.this.mIsOpenPopAdv = true;
                    DrinkWaterActivity.this.mInsertUtil.onCreate(DrinkWaterActivity.this.getActivity());
                    DrinkWaterActivity.this.requestInteraction();
                }
                if (i2 == 1) {
                    MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.ui.drinkwater.DrinkWaterActivity.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AdvControlUtil.getInstance().requestBanner(DrinkWaterActivity.this.flContainer);
                        }
                    });
                }
            }
        };
        AdvControlUtil.getInstance().init(getActivity(), this.mAdvListener, 6, false, getLoginAccount().getAccountManagetStore().getUserInfo().AreaId + "");
        AdvControlUtil.getInstance().initAdvInfo();
    }

    public void requestInteraction() {
        if (this.mIsOpenPopAdv) {
            PermissionUtil.requestPerssion(getActivity(), 4, this.permissionGrant);
            this.mInsertUtil.initInsert(getActivity(), this.mAdvListener, false, getLoginAccount().getAccountManagetStore().getUserInfo().AreaId + "", false);
            this.mInsertUtil.onInsert();
        }
    }
}
