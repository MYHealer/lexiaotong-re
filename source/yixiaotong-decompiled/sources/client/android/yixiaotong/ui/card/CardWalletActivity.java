package client.android.yixiaotong.ui.card;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.baseutil.BrightnessUtils;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.bean.SoundWaveBean;
import client.android.yixiaotong.controller.bean.SoundWaveOrderBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.error.ErrorUtil;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.AppTipDialog;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.executor.MainThreadExecutor;
import client.android.yixiaotong.util.random.RandomUtils;
import client.android.yixiaotong.zksoundwave.SWCommandUtil;
import client.android.yixiaotong.zksoundwave.soundwavedatamanage.SoundWaveDataListener;
import com.huawei.hms.hmsscankit.ScanUtil;
import com.huawei.hms.hmsscankit.WriterException;
import com.huawei.hms.ml.scan.HmsBuildBitmapOption;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class CardWalletActivity extends BaseActivity {
    public static final String EXTRA_DATA = "extra_data";
    public static final String EXTRA_DEVICENO = "extra_deviceno";
    public static final String EXTRA_MONEY = "extra_money";
    public static final String EXTRA_ORDERID = "extra_orderid";
    public static final String EXTRA_QRCODEDATA = "extra_qrcodedata";
    public static final String EXTRA_SYSTEMDATA = "extra_systemdata";
    public static final String EXTRA_SYSTEMTIME = "extra_systemtime";
    public static final String EXTRA_WALLET = "extra_wallet";
    private static final int MSG_EXIT_AGAIN = 11;
    private static final int MSG_PLAT_END = 2;
    private static final int MSG_PLAY = 12;
    private static final int MSG_RECG_TEXT = 1;
    private int mBrightness;
    private Handler mHandler;
    private ImageView mIvPlay;
    private LinearLayout mLinSaoMa;
    private LinearLayout mLinSelectSaoMa;
    private LinearLayout mLinSelectSoundWave;
    private LinearLayout mLinSoundWave;
    private String mQrcodeData1;
    private RelativeLayout mRootLayout1;
    private TextView mTvPlayTip;
    private TextView mTvQrcodeTip;
    private TitleBar mVTitleBar;
    private WalletModel mWalletModel;
    private ImageView qrcodeImg;
    private String mMoney = "";
    private String mSystemTime = "";
    private String mSystemData = "";
    private String mOrderID = "";
    private String mQrcodeData = "";
    private String mDeviceNo = "";
    private String mData = "";
    private boolean isPlay = false;
    public boolean mIsSucceed = false;
    private boolean isAutoBrightness = false;
    private boolean mIsEnable = true;
    private boolean isGetOrderIding = false;

    static {
        StubApp.interface11(6643);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    private void initViewNew() {
        this.mVTitleBar = (TitleBar) findViewById(R.id.v_titleBar);
        this.mIvPlay = (ImageView) findViewById(R.id.play_soundwave);
        this.mTvPlayTip = (TextView) findViewById(R.id.tv_playtip);
        this.mRootLayout1 = (RelativeLayout) findViewById(R.id.root_layout1);
        this.qrcodeImg = (ImageView) findViewById(R.id.qrcode);
        this.mLinSoundWave = (LinearLayout) findViewById(R.id.lin_soundwave);
        this.mLinSaoMa = (LinearLayout) findViewById(R.id.lin_saoma);
        this.mLinSelectSaoMa = (LinearLayout) findViewById(R.id.lin_select_saoma);
        this.mLinSelectSoundWave = (LinearLayout) findViewById(R.id.lin_select_soundwave);
        this.mTvQrcodeTip = (TextView) findViewById(R.id.tv_qrcodetip);
    }

    public static void launch1(Activity activity, WalletModel walletModel, String str, String str2, String str3, String str4, String str5) {
        Intent intent = new Intent(activity, (Class<?>) CardWalletActivity.class);
        intent.putExtra("extra_wallet", walletModel);
        intent.putExtra("extra_orderid", str);
        intent.putExtra("extra_money", str2);
        intent.putExtra("extra_qrcodedata", str3);
        intent.putExtra(EXTRA_SYSTEMDATA, str4);
        intent.putExtra(EXTRA_SYSTEMTIME, str5);
        activity.startActivity(intent);
    }

    public static void launch(Activity activity, WalletModel walletModel, String str, String str2, String str3, String str4, String str5) {
        Intent intent = new Intent(activity, (Class<?>) CardWalletActivity.class);
        intent.putExtra("extra_wallet", walletModel);
        intent.putExtra("extra_orderid", str);
        intent.putExtra("extra_money", str2);
        intent.putExtra("extra_qrcodedata", str3);
        intent.putExtra("extra_deviceno", str4);
        intent.putExtra("extra_data", str5);
        activity.startActivity(intent);
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.ui.card.CardWalletActivity$1, reason: invalid class name */
    class AnonymousClass1 extends Handler {
        AnonymousClass1() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                if (((String) message.obj).equals("success55")) {
                    CardWalletActivity.this.mIsSucceed = true;
                    ToastUtils.show(CardWalletActivity.this.getActivity(), "充值卡片成功！");
                    CardWalletActivity.this.getActivity().finish();
                    return;
                }
                return;
            }
            if (message.what == 11) {
                CardWalletActivity.this.mIvPlay.setEnabled(true);
                CardWalletActivity.this.mIvPlay.setBackgroundResource(R.drawable.l_card_playenable);
                CardWalletActivity.this.mTvPlayTip.setText("请按按钮进行卡片充值");
            } else if (message.what == 12) {
                if (StringUtils.isNotEmpty(CardWalletActivity.this.mSystemData) && StringUtils.isNotEmpty(CardWalletActivity.this.mSystemTime)) {
                    SWCommandUtil.getInstance().checkDataOne(CardWalletActivity.this.mSystemTime, CardWalletActivity.this.mSystemData);
                } else {
                    CardWalletActivity.this.finish();
                }
                CardWalletActivity.this.mIvPlay.setEnabled(false);
                CardWalletActivity.this.mIvPlay.setBackgroundResource(R.drawable.l_card_play);
            }
        }
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.ui.card.CardWalletActivity$2, reason: invalid class name */
    class AnonymousClass2 implements SoundWaveDataListener {
        @Override // client.android.yixiaotong.zksoundwave.soundwavedatamanage.SoundWaveDataListener
        public void onQrcodeData(String str, String str2, int i) {
        }

        AnonymousClass2() {
        }

        @Override // client.android.yixiaotong.zksoundwave.soundwavedatamanage.SoundWaveDataListener
        public void onGetQrcodeData(String str) {
            CardWalletActivity.this.mQrcodeData1 = str;
            CardWalletActivity cardWalletActivity = CardWalletActivity.this;
            cardWalletActivity.refreshQrcode(cardWalletActivity.mQrcodeData1);
        }
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.ui.card.CardWalletActivity$3, reason: invalid class name */
    class AnonymousClass3 extends Listener<SoundWaveOrderBean> {
        AnonymousClass3() {
        }

        @Override // client.android.yixiaotong.controller.core.Listener
        public void onStart(Controller controller) {
            BaseMaterialDialog.showMaterialDialog(CardWalletActivity.this.getActivity(), "正在下单中,请稍候...", false);
        }

        @Override // client.android.yixiaotong.controller.core.Listener
        public void onComplete(Controller controller, SoundWaveOrderBean soundWaveOrderBean, Object... objArr) {
            if (CardWalletActivity.this.mIsEnable) {
                CardWalletActivity.this.isGetOrderIding = false;
                BaseMaterialDialog.dissmisMaterialDialog();
                CardWalletActivity.this.mOrderID = soundWaveOrderBean.orderId;
                CardWalletActivity.this.shouquan();
            }
        }

        @Override // client.android.yixiaotong.controller.core.Listener
        public void onFail(Controller controller, ClientException clientException) {
            if (CardWalletActivity.this.mIsEnable) {
                CardWalletActivity.this.isGetOrderIding = false;
                BaseMaterialDialog.dissmisMaterialDialog();
                if (clientException.getCode() == 4060) {
                    CardRecordActivity.launch(CardWalletActivity.this.getActivity(), CardWalletActivity.this.mWalletModel, "1", CardWalletActivity.this.mQrcodeData.substring(2, 10));
                    CardWalletActivity.this.getActivity().finish();
                } else {
                    ErrorUtil.onFailResult(CardWalletActivity.this.getActivity(), CardWalletActivity.this.mVTitleBar.getTitleViewContent(), clientException, true);
                }
            }
        }
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.ui.card.CardWalletActivity$4, reason: invalid class name */
    class AnonymousClass4 implements View.OnClickListener {
        AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CardWalletActivity.this.mTvPlayTip.setText("正在充值中，请不要将手机拿离充值机的感应区");
            CardWalletActivity.this.mHandler.sendEmptyMessageDelayed(12, 300L);
        }
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.ui.card.CardWalletActivity$5, reason: invalid class name */
    class AnonymousClass5 implements View.OnClickListener {
        AnonymousClass5() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CardWalletActivity.this.mRootLayout1.setVisibility(8);
        }
    }

    private void initTitleBar() {
        this.mVTitleBar.setTitleView("卡片充值");
        this.mVTitleBar.setTitleViewIsVisible2();
        this.mVTitleBar.setRightView(R.drawable.soundwavehelp);
        this.mVTitleBar.setLeftView(R.mipmap.back);
        this.mVTitleBar.setLeftViewOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.card.CardWalletActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CardWalletActivity.this.backTip();
            }
        });
        this.mVTitleBar.setRightViewOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.card.CardWalletActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CardWalletActivity.this.mRootLayout1.setVisibility(0);
            }
        });
    }

    private void ininView() {
        this.mLinSelectSaoMa.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.card.CardWalletActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CardWalletActivity.this.mLinSoundWave.setVisibility(8);
                CardWalletActivity.this.mLinSaoMa.setVisibility(0);
                SWCommandUtil.getInstance().sendGetQrcodeData(CardWalletActivity.this.mSystemData, CardWalletActivity.this.mSystemTime);
                BrightnessUtils.stopAutoBrightness(CardWalletActivity.this.getActivity());
                BrightnessUtils.setBrightness(CardWalletActivity.this.getActivity(), 1.0f);
            }
        });
        this.mLinSelectSoundWave.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.card.CardWalletActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CardWalletActivity.this.mLinSaoMa.setVisibility(8);
                CardWalletActivity.this.mLinSoundWave.setVisibility(0);
                BrightnessUtils.setBrightness(CardWalletActivity.this.getActivity(), CardWalletActivity.this.mBrightness);
                if (CardWalletActivity.this.isAutoBrightness) {
                    BrightnessUtils.startAutoBrightness(CardWalletActivity.this.getActivity());
                } else {
                    BrightnessUtils.stopAutoBrightness(CardWalletActivity.this.getActivity());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void shouquan() {
        final String randNumMaxStringNonO = RandomUtils.getRandNumMaxStringNonO(6);
        BusinessControllers.getInstance().soundWave1(getLoginAccount(), this.mOrderID, 0, this.mDeviceNo, this.mData, this.mWalletModel.ID, this.mWalletModel.typeId, 1, 1, randNumMaxStringNonO, 1, new Listener<SoundWaveBean>() { // from class: client.android.yixiaotong.ui.card.CardWalletActivity.10
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(CardWalletActivity.this.getActivity(), "正在授权中,请稍候...", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SoundWaveBean soundWaveBean, Object... objArr) {
                if (CardWalletActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    CardWalletActivity.this.mSystemData = soundWaveBean.systemData;
                    CardWalletActivity.this.mSystemTime = soundWaveBean.systemTime;
                    if (!StringUtils.isNotEmpty(CardWalletActivity.this.mSystemData) || !StringUtils.isNotEmpty(CardWalletActivity.this.mSystemTime) || !soundWaveBean.rand.equals(randNumMaxStringNonO)) {
                        ToastUtils.show(CardWalletActivity.this.getActivity(), "数据出错");
                    } else if (SWCommandUtil.getInstance().checkDataOne(CardWalletActivity.this.mSystemTime, CardWalletActivity.this.mSystemData)) {
                        SWCommandUtil.getInstance().sendGetQrcodeData(CardWalletActivity.this.mSystemData, CardWalletActivity.this.mSystemTime);
                    } else {
                        ToastUtils.show(CardWalletActivity.this.getActivity(), "数据检验出错");
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (CardWalletActivity.this.mIsEnable) {
                    ErrorUtil.onFailResult(CardWalletActivity.this.getActivity(), CardWalletActivity.this.mVTitleBar.getTitleViewContent(), clientException, true);
                }
            }
        });
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
        BrightnessUtils.setBrightness(getActivity(), this.mBrightness);
        if (this.isAutoBrightness) {
            BrightnessUtils.startAutoBrightness(getActivity());
        } else {
            BrightnessUtils.stopAutoBrightness(getActivity());
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.mIsEnable) {
            backTip();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void backTip() {
        new AppTipDialog().showTipDialog(getActivity(), new AppTipDialog.TipDialogListener() { // from class: client.android.yixiaotong.ui.card.CardWalletActivity.11
            @Override // client.android.yixiaotong.ui.dialog.AppTipDialog.TipDialogListener
            public void onCanle() {
            }

            @Override // client.android.yixiaotong.ui.dialog.AppTipDialog.TipDialogListener
            public void onConfirt() {
                CardWalletActivity.this.finish();
            }
        }, "1、请确认卡片是否充值成功了。\n2、充值失败时请重新将手机上的二维码对准充值机上的反扫区域。\n3、多次反扫仍然充值失败的话，可能是设备故障，请到故障报修报修。\n4、充值失败可在充值记录点击这笔订单再次充值。", "充值失败", "充值成功");
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshQrcode(final String str) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.ui.card.CardWalletActivity.12
            @Override // java.lang.Runnable
            public void run() {
                Bitmap bitmapBuildBitmap;
                try {
                    bitmapBuildBitmap = ScanUtil.buildBitmap(str, 0, CardWalletActivity.this.qrcodeImg.getWidth(), CardWalletActivity.this.qrcodeImg.getHeight(), new HmsBuildBitmapOption.Creator().setBitmapMargin(1).setBitmapColor(-16777216).setBitmapBackgroundColor(-1).create());
                } catch (WriterException e) {
                    e.printStackTrace();
                    bitmapBuildBitmap = null;
                }
                if (bitmapBuildBitmap != null) {
                    CardWalletActivity.this.qrcodeImg.setImageBitmap(bitmapBuildBitmap);
                }
            }
        });
    }
}
