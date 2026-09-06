package client.android.yixiaotong.ui.drinkwater;

import android.app.Activity;
import android.client.bluetoothsdk.BluetoothSDK;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.bean.SoundWaveDrinkWaterCleanData;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.ui.widget.WaterWaveView;
import client.android.yixiaotong.util.OrderIdUtils;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.android.LocalPreferencesHelper;
import client.android.yixiaotong.zksoundwave.SWCommandUtil;
import client.android.yixiaotong.zksoundwave.soundwavedatamanage.SoundWaveDataListener;
import client.android.yixiaotong.zksoundwave.soundwaveplay.JNISoundWavePlay;
import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.google.android.exoplayer2.ExoPlayer;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class DrinkWaterCleanDataActivity extends BaseActivity {
    public static final String EXTRA_FLAG = "extra_flag";
    public static final String EXTRA_MONEY = "extra_money";
    public static final String EXTRA_ORDERID = "extra_orderid";
    public static final String EXTRA_QRCODEDATA = "extra_qrcodedata";
    public static final String EXTRA_WALLET = "extra_wallet";
    private static final int MSG_EXIT_ACTIVITY = 10;
    private static final int MSG_PLAT_END = 2;
    private static final int MSG_PLAY_ENABLE = 9;
    private static final int MSG_RECG_TEXT = 1;
    private static final int MSG_TRYAGAIN_PLAY = 11;
    private JNISoundWavePlay jniSoundWavePlay;
    private AudioManager mAudioManager;
    private int mAudioVolume;
    private Handler mHandler;
    private ImageView mIvPlay;
    private MaterialDialog mMaterialDialog;
    private RelativeLayout mRootLayout;
    private RelativeLayout mRootLayout1;
    private WaterWaveView mRvImg;
    private TextView mTvPlayTip;
    private TitleBar mVTitleBar;
    private WalletModel mWalletModel;
    private TextView regText;
    private String mFlag = "";
    private String mSystemTime = "";
    private String mSystemData = "";
    private String mOrderID = "";
    private String mQrcodeData = "";
    private boolean isPlay = false;
    public boolean mIsSucceed = false;
    private boolean mGetOrderState = false;
    private boolean mIsEnable = true;

    static {
        StubApp.interface11(7073);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    private void initViewNew() {
        this.mVTitleBar = (TitleBar) findViewById(R.id.v_titleBar);
        this.mIvPlay = (ImageView) findViewById(R.id.play_soundwave);
        this.mTvPlayTip = (TextView) findViewById(R.id.tv_playtip);
        this.mRvImg = (WaterWaveView) findViewById(R.id.rv);
        this.mRootLayout = (RelativeLayout) findViewById(R.id.root_layout);
        this.mRootLayout1 = (RelativeLayout) findViewById(R.id.root_layout1);
        this.regText = (TextView) findViewById(R.id.regText);
    }

    public static void launch(Activity activity, WalletModel walletModel, String str, String str2) {
        Intent intent = new Intent(activity, (Class<?>) DrinkWaterCleanDataActivity.class);
        intent.putExtra("extra_wallet", walletModel);
        intent.putExtra("extra_qrcodedata", str);
        intent.putExtra("extra_flag", str2);
        activity.startActivity(intent);
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.ui.drinkwater.DrinkWaterCleanDataActivity$1, reason: invalid class name */
    class AnonymousClass1 implements SoundWaveDataListener {
        @Override // client.android.yixiaotong.zksoundwave.soundwavedatamanage.SoundWaveDataListener
        public void onGetQrcodeData(String str) {
        }

        AnonymousClass1() {
        }

        @Override // client.android.yixiaotong.zksoundwave.soundwavedatamanage.SoundWaveDataListener
        public void onQrcodeData(String str, String str2, int i) {
            Log.e("test", "设备号:" + str);
            String str3 = DrinkWaterCleanDataActivity.this.getLoginAccount().getAccountManagetStore().getUserInfo().InvestorId;
            if (!DrinkWaterCleanDataActivity.this.mFlag.equals("1")) {
                if (DrinkWaterCleanDataActivity.this.mFlag.equals("2")) {
                    String string = new LocalPreferencesHelper(DrinkWaterCleanDataActivity.this.getContext(), "default_userinfo_preferences").getString("StudentName");
                    String localDate = OrderIdUtils.getLocalDate("yyyyMMddHHmmss");
                    long j = DrinkWaterCleanDataActivity.this.getLoginAccount().getAccountManagetStore().getUserInfo().AreaId;
                    if (!StringUtils.isNotEmpty(string)) {
                        string = "管理员";
                    }
                    BusinessControllers.getInstance().soundWaveWaterSettingData(DrinkWaterCleanDataActivity.this.getLoginAccount(), str3, DrinkWaterCleanDataActivity.this.mWalletModel.typeId + "", "1", str, str2, "0", localDate, string, j + "", "1", new Listener<SoundWaveDrinkWaterCleanData>() { // from class: client.android.yixiaotong.ui.drinkwater.DrinkWaterCleanDataActivity.1.2
                        @Override // client.android.yixiaotong.controller.core.Listener
                        public void onStart(Controller controller) {
                            try {
                                DrinkWaterCleanDataActivity.this.mMaterialDialog = new MaterialDialog.Builder(DrinkWaterCleanDataActivity.this.getActivity()).content("正在请求服务器中,请稍候...").cancelable(false).progress(true, 0).show();
                            } catch (Exception unused) {
                            }
                        }

                        @Override // client.android.yixiaotong.controller.core.Listener
                        public void onComplete(Controller controller, SoundWaveDrinkWaterCleanData soundWaveDrinkWaterCleanData, Object... objArr) {
                            try {
                                DrinkWaterCleanDataActivity.this.mMaterialDialog.dismiss();
                            } catch (Exception unused) {
                            }
                            if (soundWaveDrinkWaterCleanData.type.equals("0")) {
                                ToastUtils.show(DrinkWaterCleanDataActivity.this.getActivity(), "设备上没有数据");
                                DrinkWaterCleanDataActivity.this.finish();
                                return;
                            }
                            DrinkWaterCleanDataActivity.this.mSystemData = soundWaveDrinkWaterCleanData.systemdata;
                            DrinkWaterCleanDataActivity.this.mSystemTime = soundWaveDrinkWaterCleanData.systemtime;
                            new MaterialDialog.Builder(DrinkWaterCleanDataActivity.this.getContext()).title("参数").content("机器ID:" + soundWaveDrinkWaterCleanData.machineid + "  限额：" + soundWaveDrinkWaterCleanData.define + "  扇区：" + soundWaveDrinkWaterCleanData.sector).positiveText("确定设置").onPositive(new MaterialDialog.SingleButtonCallback() { // from class: client.android.yixiaotong.ui.drinkwater.DrinkWaterCleanDataActivity.1.2.2
                                @Override // com.afollestad.materialdialogs.MaterialDialog.SingleButtonCallback
                                public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
                                    DrinkWaterCleanDataActivity.this.mRvImg.startWave(true);
                                    DrinkWaterCleanDataActivity.this.mTvPlayTip.setText("饮水机正在设置数据中，请不要将手机拿离饮水机的感应区");
                                    if (StringUtils.isNotEmpty(DrinkWaterCleanDataActivity.this.mSystemData) && StringUtils.isNotEmpty(DrinkWaterCleanDataActivity.this.mSystemTime) && SWCommandUtil.getInstance().checkDataOne(DrinkWaterCleanDataActivity.this.mSystemTime, DrinkWaterCleanDataActivity.this.mSystemData)) {
                                        DrinkWaterCleanDataActivity.this.jniSoundWavePlay.play(DrinkWaterCleanDataActivity.this.mSystemData, DrinkWaterCleanDataActivity.this.mSystemTime, 60);
                                        DrinkWaterCleanDataActivity.this.mHandler.sendEmptyMessageDelayed(11, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
                                        SWCommandUtil.getInstance().sendGetQrcodeData(DrinkWaterCleanDataActivity.this.mSystemData, DrinkWaterCleanDataActivity.this.mSystemTime);
                                    }
                                    DrinkWaterCleanDataActivity.this.mIvPlay.setEnabled(false);
                                    DrinkWaterCleanDataActivity.this.mIvPlay.setBackgroundResource(R.drawable.play);
                                }
                            }).negativeText("取消设置").onNegative(new MaterialDialog.SingleButtonCallback() { // from class: client.android.yixiaotong.ui.drinkwater.DrinkWaterCleanDataActivity.1.2.1
                                @Override // com.afollestad.materialdialogs.MaterialDialog.SingleButtonCallback
                                public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
                                }
                            }).show();
                        }

                        @Override // client.android.yixiaotong.controller.core.Listener
                        public void onFail(Controller controller, ClientException clientException) {
                            try {
                                DrinkWaterCleanDataActivity.this.mMaterialDialog.dismiss();
                            } catch (Exception unused) {
                            }
                            ToastUtils.show(DrinkWaterCleanDataActivity.this.getActivity(), clientException.getDetail());
                            DrinkWaterCleanDataActivity.this.getActivity().finish();
                        }
                    });
                    return;
                }
                return;
            }
            BusinessControllers.getInstance().soundWaveWaterCleanData(DrinkWaterCleanDataActivity.this.getLoginAccount(), str3, DrinkWaterCleanDataActivity.this.mWalletModel.typeId + "", "1", str, str2, "0", "1", new Listener<SoundWaveDrinkWaterCleanData>() { // from class: client.android.yixiaotong.ui.drinkwater.DrinkWaterCleanDataActivity.1.1
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onStart(Controller controller) {
                    if (DrinkWaterCleanDataActivity.this.mIsEnable && DrinkWaterCleanDataActivity.this.mMaterialDialog == null) {
                        try {
                            DrinkWaterCleanDataActivity.this.mMaterialDialog = new MaterialDialog.Builder(DrinkWaterCleanDataActivity.this.getActivity()).content("正在请求服务器中,请稍候...").cancelable(false).progress(true, 0).show();
                        } catch (Exception unused) {
                        }
                    }
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, SoundWaveDrinkWaterCleanData soundWaveDrinkWaterCleanData, Object... objArr) {
                    if (DrinkWaterCleanDataActivity.this.mIsEnable) {
                        if (DrinkWaterCleanDataActivity.this.mMaterialDialog != null) {
                            try {
                                DrinkWaterCleanDataActivity.this.mMaterialDialog.dismiss();
                            } catch (Exception unused) {
                            }
                        }
                        if (soundWaveDrinkWaterCleanData.type.equals("0")) {
                            ToastUtils.show(DrinkWaterCleanDataActivity.this.getActivity(), "设备上没有数据");
                            DrinkWaterCleanDataActivity.this.finish();
                            return;
                        }
                        DrinkWaterCleanDataActivity.this.mSystemData = soundWaveDrinkWaterCleanData.systemdata;
                        DrinkWaterCleanDataActivity.this.mSystemTime = soundWaveDrinkWaterCleanData.systemtime;
                        DrinkWaterCleanDataActivity.this.mRvImg.startWave(true);
                        DrinkWaterCleanDataActivity.this.mTvPlayTip.setText("饮水机正在清除数据中，请不要将手机拿离饮水机的感应区");
                        if (StringUtils.isNotEmpty(DrinkWaterCleanDataActivity.this.mSystemData) && StringUtils.isNotEmpty(DrinkWaterCleanDataActivity.this.mSystemTime) && SWCommandUtil.getInstance().checkDataOne(DrinkWaterCleanDataActivity.this.mSystemTime, DrinkWaterCleanDataActivity.this.mSystemData)) {
                            DrinkWaterCleanDataActivity.this.jniSoundWavePlay.play(DrinkWaterCleanDataActivity.this.mSystemData, DrinkWaterCleanDataActivity.this.mSystemTime, 60);
                            DrinkWaterCleanDataActivity.this.mHandler.sendEmptyMessageDelayed(11, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
                            SWCommandUtil.getInstance().sendGetQrcodeData(DrinkWaterCleanDataActivity.this.mSystemData, DrinkWaterCleanDataActivity.this.mSystemTime);
                        }
                        DrinkWaterCleanDataActivity.this.mIvPlay.setEnabled(false);
                        DrinkWaterCleanDataActivity.this.mIvPlay.setBackgroundResource(R.drawable.play);
                    }
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onFail(Controller controller, ClientException clientException) {
                    if (DrinkWaterCleanDataActivity.this.mIsEnable) {
                        if (DrinkWaterCleanDataActivity.this.mMaterialDialog != null) {
                            try {
                                DrinkWaterCleanDataActivity.this.mMaterialDialog.dismiss();
                            } catch (Exception unused) {
                            }
                        }
                        ToastUtils.show(DrinkWaterCleanDataActivity.this.getActivity(), clientException.getDetail());
                        DrinkWaterCleanDataActivity.this.getActivity().finish();
                    }
                }
            });
        }
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.ui.drinkwater.DrinkWaterCleanDataActivity$2, reason: invalid class name */
    class AnonymousClass2 implements View.OnClickListener {
        AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            DrinkWaterCleanDataActivity.this.mTvPlayTip.setText("饮水机正在开阀中，请不要将手机拿离饮水机的感应区");
            if (StringUtils.isNotEmpty(DrinkWaterCleanDataActivity.this.mSystemData) && StringUtils.isNotEmpty(DrinkWaterCleanDataActivity.this.mSystemTime) && SWCommandUtil.getInstance().checkDataOne(DrinkWaterCleanDataActivity.this.mSystemTime, DrinkWaterCleanDataActivity.this.mSystemData)) {
                DrinkWaterCleanDataActivity.this.jniSoundWavePlay.play(DrinkWaterCleanDataActivity.this.mSystemData, DrinkWaterCleanDataActivity.this.mSystemTime, 60);
                DrinkWaterCleanDataActivity.this.mHandler.sendEmptyMessageDelayed(11, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
                SWCommandUtil.getInstance().sendGetQrcodeData(DrinkWaterCleanDataActivity.this.mSystemData, DrinkWaterCleanDataActivity.this.mSystemTime);
            }
            DrinkWaterCleanDataActivity.this.mIvPlay.setEnabled(false);
            DrinkWaterCleanDataActivity.this.mIvPlay.setBackgroundResource(R.drawable.play);
        }
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.ui.drinkwater.DrinkWaterCleanDataActivity$3, reason: invalid class name */
    class AnonymousClass3 implements View.OnClickListener {
        AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            DrinkWaterCleanDataActivity.this.mRootLayout1.setVisibility(8);
        }
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.ui.drinkwater.DrinkWaterCleanDataActivity$4, reason: invalid class name */
    class AnonymousClass4 extends Handler {
        AnonymousClass4() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                if (((String) message.obj).equals("success55")) {
                    DrinkWaterCleanDataActivity.this.mIsSucceed = true;
                    ToastUtils.show(DrinkWaterCleanDataActivity.this.getActivity(), "饮水消费成功！");
                    DrinkWaterCleanDataActivity.this.getActivity().finish();
                    return;
                }
                return;
            }
            if (message.what != 2 && message.what == 11) {
                DrinkWaterCleanDataActivity.this.mIvPlay.setEnabled(true);
                DrinkWaterCleanDataActivity.this.mIvPlay.setBackgroundResource(R.drawable.playenable);
                DrinkWaterCleanDataActivity.this.mTvPlayTip.setText("点击重试");
            }
        }
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.ui.drinkwater.DrinkWaterCleanDataActivity$5, reason: invalid class name */
    class AnonymousClass5 implements SoundWaveDataListener {
        @Override // client.android.yixiaotong.zksoundwave.soundwavedatamanage.SoundWaveDataListener
        public void onQrcodeData(String str, String str2, int i) {
        }

        AnonymousClass5() {
        }

        @Override // client.android.yixiaotong.zksoundwave.soundwavedatamanage.SoundWaveDataListener
        public void onGetQrcodeData(String str) {
            Log.d("--s", str);
            Log.e("test", "onGetQrcodeData:");
            if (!StringUtils.isNotEmpty(str)) {
                ToastUtils.show(DrinkWaterCleanDataActivity.this.getActivity(), "数据为空");
            } else {
                BluetoothSDK.getInstance().SendDataManagerDevice(str);
            }
        }
    }

    private void initTitleBar() {
        if (this.mFlag.equals("1")) {
            this.mVTitleBar.setTitleView("清除数据");
        } else if (this.mFlag.equals("2")) {
            this.mVTitleBar.setTitleView("设置参数");
        }
        this.mVTitleBar.setTitleViewIsVisible2();
        this.mVTitleBar.setRightView(R.drawable.soundwavehelp);
        this.mVTitleBar.setLeftView(R.mipmap.back);
        this.mVTitleBar.setLeftViewOnClickBack(getActivity());
        this.mVTitleBar.setRightViewOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.drinkwater.DrinkWaterCleanDataActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DrinkWaterCleanDataActivity.this.mRootLayout1.setVisibility(0);
            }
        });
    }

    private void initView() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        this.mRvImg.setWeightView(i);
        this.mRvImg.setFillAllView(true);
    }

    public void autoSetAudioVolumn() {
        this.mAudioVolume = this.mAudioManager.getStreamVolume(3);
        this.mAudioManager.setStreamVolume(3, (int) (((double) this.mAudioManager.getStreamMaxVolume(3)) * 0.85d), 0);
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
        MaterialDialog materialDialog = this.mMaterialDialog;
        if (materialDialog != null) {
            materialDialog.dismiss();
        }
        this.mAudioManager.setStreamVolume(3, this.mAudioVolume, 0);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        BluetoothSDK.getInstance().closeBLE();
    }
}
