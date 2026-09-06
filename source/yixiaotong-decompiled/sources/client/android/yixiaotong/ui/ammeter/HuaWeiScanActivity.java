package client.android.yixiaotong.ui.ammeter;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Vibrator;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.bean.AmmeterStateBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.controller.store.ClientDataManager;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.sdk.utils.HexString;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.DecimalUtil;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager;
import client.android.yixiaotong.util.ammeterbluetooth.AmmeterCommandUtils;
import client.android.yixiaotong.util.ammeterutil.AmmeterRandomUtils;
import client.android.yixiaotong.util.bluetooth.TimeOut;
import client.android.yixiaotong.util.random.RandomUtils;
import com.afollestad.materialdialogs.MaterialDialog;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.huawei.hms.hmsscankit.OnResultCallback;
import com.huawei.hms.hmsscankit.RemoteView;
import com.huawei.hms.hmsscankit.ScanUtil;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.ml.scan.HmsScanAnalyzerOptions;
import com.huawei.openalliance.ad.constant.x;
import com.stub.StubApp;
import com.unionpay.tsmservice.data.Constant;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class HuaWeiScanActivity extends BaseActivity implements AmmeterBluetoothManager.Listener {
    public static final String EXTRAS_STATE = "devicestate";
    public static final String EXTRA_WALLET = "extra_wallet";
    public static final int MESSAGE_CONNECT = 2;
    public static final int MESSAGE_CONNECTED = 3;
    public static final int MESSAGE_SCAN = 1;
    public static final int MESSAGE_SENDDATA1 = 4;
    public static final int MESSAGE_SENDDATA2 = 5;
    public static final int REQUEST_CODE_PHOTO = 4371;
    public static final String SCAN_RESULT = "scanResult";
    private static final String TAG = "ScanQrcodeOrBarcodeActivity";
    private ImageView flushBtn;
    private FrameLayout frameLayout;
    private ImageView imgBtn;
    private String mAddress;
    private AmmeterBluetoothManager mAmmeterBluetoothManager;
    private TranslateAnimation mAnimation;
    private Button mBtnInputComplet;
    private TimeOut mCurrentCheckTimeOut;
    private EditText mETInputData1;
    private Handler mHandler;
    private String mMachineid;
    private MaterialDialog mMaterialDialog;
    private String mQrcodeData;
    private RelativeLayout mRelInput;
    int mScreenHeight;
    int mScreenWidth;
    private int mState;
    private TitleBar mTitleBar;
    private TextView mTvLength;
    private WalletModel mWalletModel;
    private RemoteView remoteView;
    private ImageView scanLine;
    private TextView scantip;
    final int SCAN_FRAME_SIZE = 240;
    private int[] img = {R.drawable.flashlight_on, R.drawable.flashlight_off};
    private boolean mIsScanSuccess = false;
    private int mConnectCount = 0;
    private String mI42 = "";
    private String mI81 = "";
    private boolean mConnected = false;
    private boolean mSupport = false;
    private boolean mIsQrcode = true;
    private boolean isFoundDevice = false;
    private String mReceivedCode = "FF";
    private String mSendCode = "FF";

    static {
        StubApp.interface11(6283);
    }

    @Override // client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.Listener
    public void onBLEState(boolean z) {
        this.mConnected = z;
        this.mSupport = z;
    }

    @Override // client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.Listener
    public void onConnected(String str, boolean z) {
        this.mConnected = z;
    }

    @Override // client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.Listener
    public void onConnecting(String str) {
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    @Override // client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.Listener
    public void onDiscoveryFinished() {
    }

    @Override // client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.Listener
    public void onDiscoveryStarted() {
    }

    static /* synthetic */ int access$3708(HuaWeiScanActivity huaWeiScanActivity) {
        int i = huaWeiScanActivity.mConnectCount;
        huaWeiScanActivity.mConnectCount = i + 1;
        return i;
    }

    public static void launch(Activity activity, WalletModel walletModel, int i) {
        if (activity != null) {
            Intent intent = new Intent(activity, (Class<?>) HuaWeiScanActivity.class);
            intent.putExtra("extra_wallet", walletModel);
            intent.putExtra("devicestate", i);
            activity.startActivity(intent);
        }
    }

    private void initViewNew() {
        this.mRelInput = (RelativeLayout) findViewById(R.id.rel_input);
        this.mETInputData1 = (EditText) findViewById(R.id.et_inputdata1);
        this.mTvLength = (TextView) findViewById(R.id.tv_length);
        this.mBtnInputComplet = (Button) findViewById(R.id.btn_inputComplet);
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.ui.ammeter.HuaWeiScanActivity$1, reason: invalid class name */
    class AnonymousClass1 implements OnResultCallback {
        AnonymousClass1() {
        }

        @Override // com.huawei.hms.hmsscankit.OnResultCallback
        public void onResult(HmsScan[] hmsScanArr) {
            HmsScan hmsScan;
            if (hmsScanArr == null || hmsScanArr.length <= 0 || (hmsScan = hmsScanArr[0]) == null || TextUtils.isEmpty(hmsScan.getOriginalValue())) {
                return;
            }
            HuaWeiScanActivity.this.scanSuccess(hmsScanArr[0].getOriginalValue());
        }
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.ui.ammeter.HuaWeiScanActivity$2, reason: invalid class name */
    class AnonymousClass2 implements Runnable {
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (HuaWeiScanActivity.this.mIsScanSuccess) {
                return;
            }
            HuaWeiScanActivity.this.scantip.setVisibility(0);
        }
    }

    private void vibrator() {
        ((Vibrator) getSystemService("vibrator")).vibrate(200L);
    }

    private void setFlashOperation() {
        this.flushBtn.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.ammeter.HuaWeiScanActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HuaWeiScanActivity.this.remoteView.getLightStatus()) {
                    HuaWeiScanActivity.this.remoteView.switchLight();
                    HuaWeiScanActivity.this.flushBtn.setImageResource(HuaWeiScanActivity.this.img[1]);
                } else {
                    HuaWeiScanActivity.this.remoteView.switchLight();
                    HuaWeiScanActivity.this.flushBtn.setImageResource(HuaWeiScanActivity.this.img[0]);
                }
            }
        });
    }

    private void initTitleBar() {
        TitleBar titleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mTitleBar = titleBar;
        titleBar.setTitleView("扫描条码");
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
        this.mTitleBar.setRightView("输入条码");
        this.mTitleBar.setRightViewTextColor(getResources().getColor(R.color.ff4A90E2));
        this.mTitleBar.setRightViewOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.ammeter.HuaWeiScanActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HuaWeiScanActivity.this.mIsQrcode) {
                    HuaWeiScanActivity.this.mIsQrcode = false;
                    HuaWeiScanActivity.this.mRelInput.setVisibility(0);
                    HuaWeiScanActivity.this.mTitleBar.setTitleView("输入条码");
                    HuaWeiScanActivity.this.mTitleBar.setRightView("扫描条码");
                    HuaWeiScanActivity.this.remoteView.pauseContinuouslyScan();
                    return;
                }
                HuaWeiScanActivity.this.mIsQrcode = true;
                HuaWeiScanActivity.this.mRelInput.setVisibility(8);
                HuaWeiScanActivity.this.mTitleBar.setTitleView("扫描条码");
                HuaWeiScanActivity.this.mTitleBar.setRightView("输入条码");
                HuaWeiScanActivity.this.remoteView.resumeContinuouslyScan();
                ((InputMethodManager) HuaWeiScanActivity.this.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        });
    }

    private void initButton() {
        this.mBtnInputComplet.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.ammeter.HuaWeiScanActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String strTrim = HuaWeiScanActivity.this.mETInputData1.getText().toString().trim();
                if (strTrim.length() == 21) {
                    HuaWeiScanActivity.this.getCodeData(strTrim.trim());
                } else {
                    ToastUtils.show(HuaWeiScanActivity.this.getActivity(), "不合法的条码！");
                }
            }
        });
        this.mETInputData1.addTextChangedListener(new TextWatcher() { // from class: client.android.yixiaotong.ui.ammeter.HuaWeiScanActivity.6
            int count = 0;

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                HuaWeiScanActivity.this.mTvLength.setText(editable.length() + "位");
            }
        });
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        this.remoteView.onStart();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.remoteView.onResume();
        AmmeterBluetoothManager ammeterBluetoothManager = AmmeterBluetoothManager.getInstance();
        this.mAmmeterBluetoothManager = ammeterBluetoothManager;
        ammeterBluetoothManager.setListener(this);
        this.mHandler = new Handler() { // from class: client.android.yixiaotong.ui.ammeter.HuaWeiScanActivity.7
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    if (TimeOut.Scan == HuaWeiScanActivity.this.mCurrentCheckTimeOut) {
                        HuaWeiScanActivity.this.dismissDialog();
                        HuaWeiScanActivity.this.mAmmeterBluetoothManager.disConnectAll();
                        HuaWeiScanActivity.this.mAmmeterBluetoothManager.stopScan();
                        ToastUtils.show(HuaWeiScanActivity.this.getActivity(), "无法搜索到您宿舍的电表，请靠近电表后重试！");
                        if (HuaWeiScanActivity.this.mState == 2) {
                            HuaWeiScanActivity.this.collectionData();
                            return;
                        } else {
                            HuaWeiScanActivity.this.finish();
                            return;
                        }
                    }
                    return;
                }
                if (message.what == 2) {
                    if (TimeOut.Connect == HuaWeiScanActivity.this.mCurrentCheckTimeOut) {
                        AmmeterBluetoothManager.getInstance().disConnectAll();
                        ToastUtils.show(HuaWeiScanActivity.this.getActivity(), "连接超时，请靠近电表设备后重试");
                        if (HuaWeiScanActivity.this.mState == 2) {
                            HuaWeiScanActivity.this.collectionData();
                            return;
                        } else {
                            HuaWeiScanActivity.this.dismissDialog();
                            return;
                        }
                    }
                    return;
                }
                if (message.what == 3) {
                    TimeOut timeOut = TimeOut.Connected;
                    TimeOut unused = HuaWeiScanActivity.this.mCurrentCheckTimeOut;
                } else if (message.what == 4) {
                    if (TimeOut.ReadSetting == HuaWeiScanActivity.this.mCurrentCheckTimeOut) {
                        HuaWeiScanActivity.this.collectionData();
                    }
                } else if (message.what == 5 && TimeOut.SendConfirm == HuaWeiScanActivity.this.mCurrentCheckTimeOut) {
                    HuaWeiScanActivity.this.collectionData();
                }
            }
        };
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.remoteView.onPause();
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        this.mSupport = false;
        this.mConnected = false;
        this.mCurrentCheckTimeOut = null;
        if (this.mHandler != null) {
            this.mHandler = null;
        }
        this.mAmmeterBluetoothManager.stopScan();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.remoteView.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        this.remoteView.onStop();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        HmsScan hmsScan;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 4371) {
            try {
                HmsScan[] hmsScanArrDecodeWithBitmap = ScanUtil.decodeWithBitmap(this, MediaStore.Images.Media.getBitmap(getContentResolver(), intent.getData()), new HmsScanAnalyzerOptions.Creator().setPhotoMode(true).create());
                if (hmsScanArrDecodeWithBitmap == null || hmsScanArrDecodeWithBitmap.length <= 0 || (hmsScan = hmsScanArrDecodeWithBitmap[0]) == null || TextUtils.isEmpty(hmsScan.getOriginalValue())) {
                    return;
                }
                scanSuccess(hmsScanArrDecodeWithBitmap[0].getOriginalValue());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scanSuccess(String str) {
        Log.e("test", "scanSuccess:" + str);
        if (ClientDataManager.getInstance().getBooleanDefaultTrue(ClientDataManager.MESSAGE_VIBRATE)) {
            vibrator();
        }
        this.remoteView.pauseContinuouslyScan();
        if (this.mIsScanSuccess) {
            return;
        }
        this.mIsScanSuccess = true;
        getCodeData(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getCodeData(String str) {
        if (str.length() != 21) {
            ToastUtils.show(getActivity(), "不合法的条码！");
            finish();
            return;
        }
        this.mQrcodeData = str;
        int i = this.mState;
        if (i == 1) {
            selectAmmeterState(str);
        } else if (i == 2) {
            getAmmeterInfo(str);
        } else if (i == 4) {
            selectAmmeterState(str);
        }
    }

    private void selectAmmeterState(final String str) {
        final String randNumMaxStringNonO = RandomUtils.getRandNumMaxStringNonO(6);
        BusinessControllers.getInstance().ammeterState(getLoginAccount(), Constant.DEFAULT_CVN2 + str, randNumMaxStringNonO, new Listener<AmmeterStateBean>() { // from class: client.android.yixiaotong.ui.ammeter.HuaWeiScanActivity.8
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                if (!HuaWeiScanActivity.this.isShowingDialog()) {
                    HuaWeiScanActivity.this.showDialog();
                }
                if (HuaWeiScanActivity.this.mMaterialDialog != null) {
                    HuaWeiScanActivity.this.mMaterialDialog.setContent("正在查询电表的状态！");
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, AmmeterStateBean ammeterStateBean, Object... objArr) {
                if (randNumMaxStringNonO.equals(ammeterStateBean.rand)) {
                    if (ammeterStateBean.status.equals("2")) {
                        if (HuaWeiScanActivity.this.mState == 4) {
                            SearchAmmeterActivity.launch(HuaWeiScanActivity.this.getActivity(), HuaWeiScanActivity.this.mWalletModel, str, 4, 2);
                        } else {
                            SearchAmmeterActivity.launch(HuaWeiScanActivity.this.getActivity(), HuaWeiScanActivity.this.mWalletModel, str, 1, 2);
                        }
                        HuaWeiScanActivity.this.dismissDialog();
                        HuaWeiScanActivity.this.finish();
                        return;
                    }
                    if (ammeterStateBean.status.equals("1")) {
                        if (ammeterStateBean.isflag.equals("4") || ammeterStateBean.isflag.equals("6")) {
                            if (HuaWeiScanActivity.this.mState == 4) {
                                SearchAmmeterActivity.launch(HuaWeiScanActivity.this.getActivity(), HuaWeiScanActivity.this.mWalletModel, str, 4, 1);
                            } else {
                                SearchAmmeterActivity.launch(HuaWeiScanActivity.this.getActivity(), HuaWeiScanActivity.this.mWalletModel, str, 6, 1);
                            }
                            HuaWeiScanActivity.this.dismissDialog();
                            HuaWeiScanActivity.this.finish();
                            return;
                        }
                        if (ammeterStateBean.isflag.equals("1") || ammeterStateBean.isflag.equals("2") || ammeterStateBean.isflag.equals("3") || ammeterStateBean.isflag.equals("5")) {
                            HuaWeiScanActivity.this.dismissDialog();
                            ToastUtils.show(HuaWeiScanActivity.this.getActivity(), "其他宿舍正在使用此电表！");
                            HuaWeiScanActivity.this.finish();
                        } else if (ammeterStateBean.isflag.equals("0") && StringUtils.isNotEmpty(ammeterStateBean.devicemac) && StringUtils.isNotEmpty(ammeterStateBean.machineid)) {
                            HuaWeiScanActivity.this.mAddress = ammeterStateBean.devicemac;
                            HuaWeiScanActivity.this.mMachineid = ammeterStateBean.machineid;
                            HuaWeiScanActivity.this.searchAmmeter();
                        }
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                ToastUtils.show(HuaWeiScanActivity.this.getActivity(), clientException.getDetail());
                HuaWeiScanActivity.this.dismissDialog();
                HuaWeiScanActivity.this.finish();
            }
        });
    }

    private void getAmmeterInfo(final String str) {
        final String randNumMaxStringNonO = RandomUtils.getRandNumMaxStringNonO(6);
        BusinessControllers.getInstance().ammeterInfo(getLoginAccount(), "", randNumMaxStringNonO, Constant.DEFAULT_CVN2 + str, new Listener<AmmeterStateBean>() { // from class: client.android.yixiaotong.ui.ammeter.HuaWeiScanActivity.9
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                if (!HuaWeiScanActivity.this.isShowingDialog()) {
                    HuaWeiScanActivity.this.showDialog();
                }
                if (HuaWeiScanActivity.this.mMaterialDialog != null) {
                    HuaWeiScanActivity.this.mMaterialDialog.setContent("正在获取电表的信息！");
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, AmmeterStateBean ammeterStateBean, Object... objArr) {
                if (randNumMaxStringNonO.equals(ammeterStateBean.rand) && ammeterStateBean.machineid.contains(str) && StringUtils.isNotEmpty(ammeterStateBean.devicemac)) {
                    HuaWeiScanActivity.this.mAddress = ammeterStateBean.devicemac;
                    HuaWeiScanActivity.this.searchAmmeter();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                HuaWeiScanActivity.this.dismissDialog();
                ToastUtils.show(HuaWeiScanActivity.this.getActivity(), clientException.getDetail());
                HuaWeiScanActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void collectionData() {
        String str = getLoginAccount().getAccountManagetStore().getUserInfo().StudentName;
        final String randNumMaxStringNonO = RandomUtils.getRandNumMaxStringNonO(6);
        BusinessControllers.getInstance().ammeterCollectionData(getLoginAccount(), str, "", randNumMaxStringNonO, Constant.DEFAULT_CVN2 + this.mQrcodeData, this.mI42, this.mI81, new Listener<AmmeterStateBean>() { // from class: client.android.yixiaotong.ui.ammeter.HuaWeiScanActivity.10
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                if (!HuaWeiScanActivity.this.isShowingDialog()) {
                    HuaWeiScanActivity.this.showDialog();
                }
                if (HuaWeiScanActivity.this.mMaterialDialog != null) {
                    HuaWeiScanActivity.this.mMaterialDialog.setContent("正在采集电表的信息！");
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, AmmeterStateBean ammeterStateBean, Object... objArr) {
                HuaWeiScanActivity.this.dismissDialog();
                AmmeterBluetoothManager.getInstance().disConnectAll();
                if (randNumMaxStringNonO.equals(ammeterStateBean.rand)) {
                    ToastUtils.show(HuaWeiScanActivity.this.getActivity(), "数据采集成功，现在可以开始更换新电表了！");
                }
                HuaWeiScanActivity.this.finish();
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                HuaWeiScanActivity.this.dismissDialog();
                AmmeterBluetoothManager.getInstance().disConnectAll();
                ToastUtils.show(HuaWeiScanActivity.this.getActivity(), clientException.getDetail());
                HuaWeiScanActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void searchAmmeter() {
        if (!isShowingDialog()) {
            showDialog();
        }
        this.isFoundDevice = false;
        MaterialDialog materialDialog = this.mMaterialDialog;
        if (materialDialog != null) {
            materialDialog.setContent("正在搜索您宿舍的电表...");
        }
        this.mAmmeterBluetoothManager.disConnectAll();
        this.mAmmeterBluetoothManager.startScan();
        if (this.mHandler != null) {
            this.mCurrentCheckTimeOut = TimeOut.Scan;
            this.mHandler.sendEmptyMessageDelayed(1, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
        }
    }

    private void connetAmmeter() {
        if (!isShowingDialog()) {
            showDialog();
        }
        MaterialDialog materialDialog = this.mMaterialDialog;
        if (materialDialog != null) {
            materialDialog.setContent("正在连接电表...");
        }
        this.mAmmeterBluetoothManager.disConnectAll();
        runOnUiThread(new Runnable() { // from class: client.android.yixiaotong.ui.ammeter.HuaWeiScanActivity.11
            @Override // java.lang.Runnable
            public void run() {
                if (StringUtils.isNotEmpty(HuaWeiScanActivity.this.mAddress)) {
                    if (HuaWeiScanActivity.this.mHandler != null) {
                        HuaWeiScanActivity.this.mCurrentCheckTimeOut = TimeOut.Connect;
                        HuaWeiScanActivity.access$3708(HuaWeiScanActivity.this);
                        Message message = new Message();
                        message.what = 2;
                        message.arg1 = HuaWeiScanActivity.this.mConnectCount;
                        HuaWeiScanActivity.this.mHandler.sendMessageDelayed(message, 12000L);
                    }
                    HuaWeiScanActivity.this.mAmmeterBluetoothManager.connect(HuaWeiScanActivity.this.mAddress);
                }
            }
        }, 1200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog() {
        try {
            dismissDialog();
            MaterialDialog materialDialogShow = new MaterialDialog.Builder(this).content("正在处理中，请稍后...").progress(true, 0).dismissListener(new DialogInterface.OnDismissListener() { // from class: client.android.yixiaotong.ui.ammeter.HuaWeiScanActivity.12
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                }
            }).show();
            this.mMaterialDialog = materialDialogShow;
            materialDialogShow.setCanceledOnTouchOutside(false);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissDialog() {
        try {
            if (isShowingDialog()) {
                this.mMaterialDialog.dismiss();
                this.mMaterialDialog = null;
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShowingDialog() {
        MaterialDialog materialDialog = this.mMaterialDialog;
        return materialDialog != null && materialDialog.isShowing();
    }

    @Override // client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.Listener
    public void onDisconnected(String str) {
        ToastUtils.show(getContext(), "电表蓝牙信号不好，正在重连中");
        connetAmmeter();
    }

    @Override // client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.Listener
    public void onConnectionFailed(String str) {
        dismissDialog();
        AmmeterBluetoothManager.getInstance().disConnectAll();
        ToastUtils.show(getContext(), "连接电表失败");
        finish();
    }

    @Override // client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.Listener
    public void onDeviceFound(String str) {
        if (StringUtils.isNotEmpty(this.mAddress) && StringUtils.isNotEmpty(str) && this.mAddress.equals(str) && !this.isFoundDevice) {
            this.isFoundDevice = true;
            MaterialDialog materialDialog = this.mMaterialDialog;
            if (materialDialog != null) {
                materialDialog.setContent("已经查找到您宿舍的电表...");
            }
            this.mAmmeterBluetoothManager.stopScan();
            connetAmmeter();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendGetDeviceInfoData() {
        this.mReceivedCode = "FF";
        String randNumMaxString = AmmeterRandomUtils.getRandNumMaxString(2);
        this.mSendCode = randNumMaxString;
        this.mAmmeterBluetoothManager.sendData(this.mAddress, HexString.hexToBuffer(AmmeterCommandUtils.getDeviceInfo(randNumMaxString)));
    }

    private void sendGetDeviceTypeStateUserNoBalanceEle(String str) {
        String randNumMaxString = AmmeterRandomUtils.getRandNumMaxString(2);
        this.mSendCode = randNumMaxString;
        this.mAmmeterBluetoothManager.sendData(this.mAddress, HexString.hexToBuffer(AmmeterCommandUtils.getDeviceTypeStateUserNoBalanceEle(str, randNumMaxString)));
    }

    @Override // client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.Listener
    public void onConnectState(String str, boolean z) {
        MaterialDialog materialDialog;
        this.mSupport = z;
        if (z) {
            if (isShowingDialog() && (materialDialog = this.mMaterialDialog) != null) {
                materialDialog.setContent("电表蓝牙匹配成功");
            }
            this.mCurrentCheckTimeOut = TimeOut.Connected;
            runOnUiThread(new Runnable() { // from class: client.android.yixiaotong.ui.ammeter.HuaWeiScanActivity.13
                @Override // java.lang.Runnable
                public void run() {
                    if (HuaWeiScanActivity.this.mState == 1) {
                        HuaWeiScanActivity.this.dismissDialog();
                        InitAmmeterActivity.launch(HuaWeiScanActivity.this.getActivity(), HuaWeiScanActivity.this.mWalletModel, HuaWeiScanActivity.this.mAddress, HuaWeiScanActivity.this.mMachineid, "1", 1);
                        HuaWeiScanActivity.this.finish();
                    } else {
                        if (HuaWeiScanActivity.this.mState == 2) {
                            if (HuaWeiScanActivity.this.mMaterialDialog != null) {
                                HuaWeiScanActivity.this.mMaterialDialog.setContent("正在采集电表的数据！");
                            }
                            HuaWeiScanActivity.this.sendGetDeviceInfoData();
                            HuaWeiScanActivity.this.mCurrentCheckTimeOut = TimeOut.ReadSetting;
                            HuaWeiScanActivity.this.mHandler.sendEmptyMessageDelayed(4, 5000L);
                            return;
                        }
                        if (HuaWeiScanActivity.this.mState == 4) {
                            HuaWeiScanActivity.this.dismissDialog();
                            InitAmmeterActivity.launch(HuaWeiScanActivity.this.getActivity(), HuaWeiScanActivity.this.mWalletModel, HuaWeiScanActivity.this.mAddress, HuaWeiScanActivity.this.mMachineid, "4", 1);
                            HuaWeiScanActivity.this.finish();
                        }
                    }
                }
            }, 1000L);
        }
    }

    @Override // client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.Listener
    public void onSendDataFailed() {
        dismissDialog();
        ToastUtils.show(getContext(), "数据发送失败！");
    }

    @Override // client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.Listener
    public void onDataReceived(String str, byte[] bArr) {
        String strDivide;
        String strBufferToHex = HexString.bufferToHex(bArr);
        AmmeterCommandUtils.isConnectResult(strBufferToHex);
        if ("81".equals(strBufferToHex.substring(4, 6).toUpperCase())) {
            String upperCase = strBufferToHex.substring(0, 2).toUpperCase();
            this.mReceivedCode = upperCase;
            if (this.mSendCode.equals(upperCase)) {
                String upperCase2 = strBufferToHex.substring(2, 4).toUpperCase();
                this.mReceivedCode = upperCase2;
                sendGetDeviceTypeStateUserNoBalanceEle(upperCase2);
                this.mCurrentCheckTimeOut = TimeOut.SendConfirm;
                this.mHandler.sendEmptyMessageDelayed(5, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
                return;
            }
            ToastUtils.show(getContext(), "校验码出错啦！");
            return;
        }
        if ("B7".equals(strBufferToHex.substring(4, 6))) {
            this.mCurrentCheckTimeOut = null;
            String upperCase3 = strBufferToHex.substring(0, 2).toUpperCase();
            this.mReceivedCode = upperCase3;
            if (this.mSendCode.equals(upperCase3)) {
                this.mReceivedCode = strBufferToHex.substring(2, 4).toUpperCase();
                String strSubstring = strBufferToHex.substring(35, 42);
                String upperCase4 = strBufferToHex.substring(34, 35).toUpperCase();
                short s = Short.parseShort(upperCase4, 16);
                if (s < 8) {
                    strDivide = DecimalUtil.divide(upperCase4 + strSubstring, "100");
                } else {
                    strDivide = x.A + DecimalUtil.divide(((s - 8) + "") + strSubstring, "100");
                }
                this.mI42 = ((int) (Float.parseFloat(DecimalUtil.twoDecimal(strDivide)) * 100.0f)) + "";
                this.mI81 = ((int) Float.parseFloat(strBufferToHex.substring(42, 50))) + "";
                collectionData();
                return;
            }
            ToastUtils.show(getActivity(), "校验码出错啦！");
        }
    }
}
