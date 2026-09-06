package client.android.yixiaotong.ui.dry;

import android.app.Activity;
import android.client.bluetoothsdk.BluetoothSDK;
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
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.executor.MainThreadExecutor;
import client.android.yixiaotong.util.permission.PermissionUtil;
import client.android.yixiaotong.v3.ui.adv.AdvControlUtil;
import client.android.yixiaotong.v3.ui.adv.Common;
import client.android.yixiaotong.v3.ui.adv.InsertUtil;
import client.android.yixiaotong.zksoundwave.SWCommandUtil;
import client.android.yixiaotong.zksoundwave.soundwavedatamanage.SoundWaveDataListener;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class DryingActivity extends BaseActivity {
    public static final String EXTRAS_DEVICE_ADDRESS = "deviceAddress";
    public static final String EXTRA_DATA = "extra_data";
    public static final String EXTRA_DEVICENO = "extra_deviceno";
    public static final String EXTRA_FUNCTION_TYPE = "extra_functiontype";
    public static final String EXTRA_MAC = "extra_mac";
    public static final String EXTRA_ORDERID = "extra_orderid";
    public static final String EXTRA_PAY = "extra_pay";
    public static final String EXTRA_WALLET = "extra_wallet";
    private static final String TAG = "DryingActivity";
    private FrameLayout flContainer;
    private AdvControlUtil.AdvListener mAdvListener;
    private InsertUtil mInsertUtil;
    private String mPlayData;
    private String mPlayTime;
    private TextView mTime;
    private TextView mTvTip;
    private TitleBar mVTitleBar;
    private WalletModel mWalletModel;
    private TimeCount time;
    private String mDeviceNo = "";
    private String mData = "";
    private boolean mIsEnable = true;
    private SystemErrorTip.SystemErrorDialogListener systemErrorDialogListener = new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.ui.dry.DryingActivity.1
        @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
        public void onConfirm() {
            DryingActivity.this.finish();
        }
    };
    private PermissionUtil.PermissionGrant permissionGrant = new PermissionUtil.PermissionGrant() { // from class: client.android.yixiaotong.ui.dry.DryingActivity.4
        @Override // client.android.yixiaotong.util.permission.PermissionUtil.PermissionGrant
        public void onPermissionGranted(int i) {
        }
    };
    private boolean mIsOpenPopAdv = false;

    static {
        StubApp.interface11(7194);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public native void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    private void initViewNew() {
        this.mVTitleBar = (TitleBar) findViewById(R.id.v_titleBar);
        this.mTvTip = (TextView) findViewById(R.id.tv_tip);
        this.mTime = (TextView) findViewById(R.id.time);
        this.flContainer = (FrameLayout) findViewById(R.id.flContainer);
    }

    public static void launch(Activity activity, WalletModel walletModel, String str, String str2, String str3, int i, String str4, String str5) {
        Intent intent = new Intent(activity, (Class<?>) DryingActivity.class);
        intent.putExtra("extra_wallet", walletModel);
        intent.putExtra("extra_deviceno", str);
        intent.putExtra("extra_data", str2);
        intent.putExtra("extra_orderid", str3);
        intent.putExtra("extra_pay", i);
        intent.putExtra("extra_functiontype", str4);
        intent.putExtra("extra_mac", str5);
        activity.startActivity(intent);
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.ui.dry.DryingActivity$2, reason: invalid class name */
    class AnonymousClass2 implements SoundWaveDataListener {
        @Override // client.android.yixiaotong.zksoundwave.soundwavedatamanage.SoundWaveDataListener
        public void onQrcodeData(String str, String str2, int i) {
        }

        AnonymousClass2() {
        }

        @Override // client.android.yixiaotong.zksoundwave.soundwavedatamanage.SoundWaveDataListener
        public void onGetQrcodeData(String str) {
            if (!StringUtils.isNotEmpty(str)) {
                ToastUtils.show(DryingActivity.this.getActivity(), "数据为空");
            } else {
                Log.e("test", "发送数据:" + str);
                BluetoothSDK.getInstance().SendDataManagerDevice(str);
            }
        }
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.ui.dry.DryingActivity$3, reason: invalid class name */
    class AnonymousClass3 implements Runnable {
        AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DryingActivity.this.getAdv();
        }
    }

    private void initTitleBar() {
        this.mVTitleBar.setTitleView("干衣");
        this.mVTitleBar.setLeftView(R.mipmap.back);
        this.mVTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void open() {
        if (StringUtils.isNotEmpty(this.mPlayData) && StringUtils.isNotEmpty(this.mPlayTime)) {
            this.mTime.setVisibility(0);
            this.time.start();
            this.mTvTip.setText("正在启动干衣机");
            Log.e("test", this.mPlayData + "  " + this.mPlayTime);
            if (SWCommandUtil.getInstance().checkDataOne(this.mPlayTime, this.mPlayData)) {
                SWCommandUtil.getInstance().sendGetQrcodeData(this.mPlayData, this.mPlayTime);
                return;
            } else {
                SystemErrorTip.getInstance().showTipDialog(getActivity(), this.systemErrorDialogListener, "数据校验出错");
                return;
            }
        }
        SystemErrorTip.getInstance().showTipDialog(getActivity(), this.systemErrorDialogListener, "没有从服务器上获取到数据");
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
        this.mIsEnable = false;
        AdvControlUtil.getInstance().onPause();
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        BluetoothSDK.getInstance().closeBLE();
        AdvControlUtil.getInstance().onDestroy(getActivity());
        InsertUtil insertUtil = this.mInsertUtil;
        if (insertUtil != null) {
            insertUtil.onDestroy(getActivity());
        }
    }

    class TimeCount extends CountDownTimer {
        public TimeCount(long j, long j2) {
            super(j, j2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            DryingActivity.this.finish();
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            DryingActivity.this.mTime.setTextColor(-10066330);
            DryingActivity.this.mTime.setClickable(false);
            DryingActivity.this.mTime.setText(Html.fromHtml("该页面将在" + (j / 1000) + "后自动关闭"));
            DryingActivity.this.mTime.setTextSize(12.0f);
            DryingActivity.this.mTime.setPadding(5, 5, 5, 5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getAdv() {
        this.mInsertUtil = new InsertUtil();
        this.mAdvListener = new AdvControlUtil.AdvListener() { // from class: client.android.yixiaotong.ui.dry.DryingActivity.5
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
                    DryingActivity.this.mIsOpenPopAdv = true;
                    DryingActivity.this.mInsertUtil.onCreate(DryingActivity.this.getActivity());
                    DryingActivity.this.requestInteraction();
                }
                if (i2 == 1) {
                    MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.ui.dry.DryingActivity.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AdvControlUtil.getInstance().requestBanner(DryingActivity.this.flContainer);
                        }
                    });
                }
            }
        };
        AdvControlUtil.getInstance().init(getActivity(), this.mAdvListener, 16, false, getLoginAccount().getAccountManagetStore().getUserInfo().AreaId + "");
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
