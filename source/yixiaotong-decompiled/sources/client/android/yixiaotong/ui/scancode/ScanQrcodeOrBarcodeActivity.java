package client.android.yixiaotong.ui.scancode;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import client.android.yixiaotong.R;
import client.android.yixiaotong.account.AccountManager;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.controller.store.ClientDataManager;
import client.android.yixiaotong.ui.card.CardScanResultControl;
import client.android.yixiaotong.ui.drinkwater.DrinkWaterScanResultControl;
import client.android.yixiaotong.ui.dry.DryScanResultControl;
import client.android.yixiaotong.ui.hairdryer.HairDryerScanResultControl;
import client.android.yixiaotong.ui.hamam.HamamScanResultControl;
import client.android.yixiaotong.ui.qrcode.BindSchoolControl;
import client.android.yixiaotong.ui.sellcard.SellCardScanResultControl;
import client.android.yixiaotong.ui.wash.WashScanResultControl;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.v3.util.LogUtil;
import client.android.yixiaotong.v4.ui.user.V4SelectSchoolControl;
import com.huawei.hms.hmsscankit.OnResultCallback;
import com.huawei.hms.hmsscankit.RemoteView;
import com.huawei.hms.hmsscankit.ScanUtil;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.ml.scan.HmsScanAnalyzerOptions;
import com.stub.StubApp;
import com.yfanads.android.libs.net.UrlHttpUtil;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ScanQrcodeOrBarcodeActivity extends Activity {
    public static final int DEVICEAUTH = 1;
    public static final int DEVICESAOMA = 3;
    public static final int REQUEST_CODE_PHOTO = 4371;
    public static final String SCAN_RESULT = "scanResult";
    private static final String TAG = "ScanQrcodeOrBarcodeActivity";
    private ImageView flushBtn;
    private FrameLayout frameLayout;
    private ImageView imgBtn;
    private TranslateAnimation mAnimation;
    private int mAuth;
    private BindSchoolControl mBindSchoolControl;
    private CardScanResultControl mCardScanResultControl;
    private String mData;
    private DrinkWaterScanResultControl mDrinkWaterScanResultControl;
    private DryScanResultControl mDryScanResultControl;
    private HairDryerScanResultControl mHairDryerScanResultControl;
    private HamamScanResultControl mHamamScanResultControl;
    private int mMode;
    int mScreenHeight;
    int mScreenWidth;
    private SellCardScanResultControl mSellCardScanResultControl;
    private TitleBar mTitleBar;
    private V4SelectSchoolControl mV4SelectSchoolControl;
    private WalletModel mWalletModel;
    private WashScanResultControl mWashScanResultControl;
    private RemoteView remoteView;
    private ImageView scanLine;
    private TextView scantip;
    final int SCAN_FRAME_SIZE = 240;
    private int[] img = {R.drawable.flashlight_on, R.drawable.flashlight_off};
    private boolean mIsScanSuccess = false;

    static {
        StubApp.interface11(7571);
    }

    @Override // android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, WalletModel walletModel, String str, int i) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) ScanQrcodeOrBarcodeActivity.class).putExtra("walletmodel", walletModel).putExtra("data", str).putExtra("mode", i));
        }
    }

    public static void launch(Activity activity, int i) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) ScanQrcodeOrBarcodeActivity.class).putExtra("mode", i));
        }
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.ui.scancode.ScanQrcodeOrBarcodeActivity$1, reason: invalid class name */
    class AnonymousClass1 implements OnResultCallback {
        AnonymousClass1() {
        }

        @Override // com.huawei.hms.hmsscankit.OnResultCallback
        public void onResult(HmsScan[] hmsScanArr) {
            HmsScan hmsScan;
            if (hmsScanArr == null || hmsScanArr.length <= 0 || (hmsScan = hmsScanArr[0]) == null || TextUtils.isEmpty(hmsScan.getOriginalValue())) {
                return;
            }
            ScanQrcodeOrBarcodeActivity.this.scanSuccess(hmsScanArr[0].getOriginalValue());
        }
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.ui.scancode.ScanQrcodeOrBarcodeActivity$2, reason: invalid class name */
    class AnonymousClass2 implements Runnable {
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ScanQrcodeOrBarcodeActivity.this.mIsScanSuccess) {
                return;
            }
            ScanQrcodeOrBarcodeActivity.this.scantip.setVisibility(0);
        }
    }

    private void vibrator() {
        ((Vibrator) getSystemService("vibrator")).vibrate(200L);
    }

    private void setPictureScanOperation() {
        ImageView imageView = (ImageView) findViewById(R.id.img_btn);
        this.imgBtn = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.scancode.ScanQrcodeOrBarcodeActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, UrlHttpUtil.FILE_TYPE_IMAGE);
                ScanQrcodeOrBarcodeActivity.this.startActivityForResult(intent, 4371);
            }
        });
    }

    private void setFlashOperation() {
        this.flushBtn.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.scancode.ScanQrcodeOrBarcodeActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ScanQrcodeOrBarcodeActivity.this.remoteView.getLightStatus()) {
                    ScanQrcodeOrBarcodeActivity.this.remoteView.switchLight();
                    ScanQrcodeOrBarcodeActivity.this.flushBtn.setImageResource(ScanQrcodeOrBarcodeActivity.this.img[1]);
                } else {
                    ScanQrcodeOrBarcodeActivity.this.remoteView.switchLight();
                    ScanQrcodeOrBarcodeActivity.this.flushBtn.setImageResource(ScanQrcodeOrBarcodeActivity.this.img[0]);
                }
            }
        });
    }

    private void initTitleBar() {
        TitleBar titleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mTitleBar = titleBar;
        if (this.mWalletModel == null) {
            titleBar.setTitleView(getString(R.string.scancode));
        } else if (this.mMode == 2) {
            titleBar.setTitleView(this.mWalletModel.name + "卡片充值扫码");
        } else {
            titleBar.setTitleView(this.mWalletModel.name + "扫码");
        }
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(this);
        this.mTitleBar.setGravity(10);
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        LogUtil.e(TAG, "onStart");
        this.remoteView.onStart();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        LogUtil.e(TAG, "onResume");
        this.remoteView.onResume();
        onResumeControl();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.remoteView.onPause();
        onPauseControl();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.remoteView.onDestroy();
        onDestroyControl();
        Log.e("ScanQrcode", "onDestroy");
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        this.remoteView.onStop();
    }

    @Override // android.app.Activity
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
        LogUtil.e(TAG, "scanSuccess:" + str + "  1");
        int i = this.mAuth;
        if (i == 1) {
            Intent intent = new Intent();
            intent.putExtra("qrcode", str);
            setResult(0, intent);
            finish();
        } else if (i == 3) {
            Intent intent2 = new Intent();
            intent2.putExtra("qrcode", str);
            setResult(3, intent2);
            finish();
        }
        if (ClientDataManager.getInstance().getBooleanDefaultTrue(ClientDataManager.MESSAGE_VIBRATE)) {
            vibrator();
        }
        this.remoteView.pauseContinuouslyScan();
        if (this.mIsScanSuccess) {
            return;
        }
        this.mIsScanSuccess = true;
        int i2 = this.mMode;
        if (i2 == 6) {
            this.mDrinkWaterScanResultControl.init(this, AccountManager.getInstance().getLoginAccount(), this.mWalletModel, str, this.mData);
            return;
        }
        if (i2 == 8) {
            this.mHairDryerScanResultControl.init(this, AccountManager.getInstance().getLoginAccount(), this.mWalletModel, str, this.mData);
            return;
        }
        if (i2 == 3) {
            this.mWashScanResultControl.init(this, AccountManager.getInstance().getLoginAccount(), this.mWalletModel, str, this.mData);
            return;
        }
        if (i2 == 2) {
            this.mCardScanResultControl.init(this, AccountManager.getInstance().getLoginAccount(), this.mWalletModel, str, this.mData);
            return;
        }
        if (i2 == 11) {
            this.mHamamScanResultControl.init(this, AccountManager.getInstance().getLoginAccount(), this.mWalletModel, str, this.mData);
            return;
        }
        if (i2 == 16) {
            this.mDryScanResultControl.init(this, AccountManager.getInstance().getLoginAccount(), this.mWalletModel, str, this.mData);
            return;
        }
        if (i2 == 100) {
            this.mBindSchoolControl.init(this, AccountManager.getInstance().getLoginAccount(), str);
        } else if (i2 == 9) {
            this.mSellCardScanResultControl.init(this, AccountManager.getInstance().getLoginAccount(), this.mWalletModel, str, this.mData);
        } else if (i2 == 101) {
            this.mV4SelectSchoolControl.init(this, AccountManager.getInstance().getLoginAccount(), str);
        }
    }

    private void onResumeControl() {
        int i = this.mMode;
        if (i == 6) {
            DrinkWaterScanResultControl drinkWaterScanResultControl = new DrinkWaterScanResultControl();
            this.mDrinkWaterScanResultControl = drinkWaterScanResultControl;
            drinkWaterScanResultControl.onResume();
            return;
        }
        if (i == 8) {
            HairDryerScanResultControl hairDryerScanResultControl = new HairDryerScanResultControl();
            this.mHairDryerScanResultControl = hairDryerScanResultControl;
            hairDryerScanResultControl.onResume();
            return;
        }
        if (i == 3) {
            WashScanResultControl washScanResultControl = new WashScanResultControl();
            this.mWashScanResultControl = washScanResultControl;
            washScanResultControl.onResume();
            return;
        }
        if (i == 2) {
            CardScanResultControl cardScanResultControl = new CardScanResultControl();
            this.mCardScanResultControl = cardScanResultControl;
            cardScanResultControl.onResume();
            return;
        }
        if (i == 11) {
            HamamScanResultControl hamamScanResultControl = new HamamScanResultControl();
            this.mHamamScanResultControl = hamamScanResultControl;
            hamamScanResultControl.onResume();
            return;
        }
        if (i == 16) {
            DryScanResultControl dryScanResultControl = new DryScanResultControl();
            this.mDryScanResultControl = dryScanResultControl;
            dryScanResultControl.onResume();
            return;
        }
        if (i == 100) {
            BindSchoolControl bindSchoolControl = new BindSchoolControl();
            this.mBindSchoolControl = bindSchoolControl;
            bindSchoolControl.onResume();
        } else if (i == 9) {
            SellCardScanResultControl sellCardScanResultControl = new SellCardScanResultControl();
            this.mSellCardScanResultControl = sellCardScanResultControl;
            sellCardScanResultControl.onResume();
        } else if (i == 101) {
            V4SelectSchoolControl v4SelectSchoolControl = new V4SelectSchoolControl();
            this.mV4SelectSchoolControl = v4SelectSchoolControl;
            v4SelectSchoolControl.onResume();
        }
    }

    private void onPauseControl() {
        if (this.mIsScanSuccess) {
            int i = this.mMode;
            if (i == 6) {
                this.mDrinkWaterScanResultControl.onPause();
                return;
            }
            if (i == 8) {
                this.mHairDryerScanResultControl.onPause();
                return;
            }
            if (i == 3) {
                this.mWashScanResultControl.onPause();
                return;
            }
            if (i == 2) {
                this.mCardScanResultControl.onPause();
                return;
            }
            if (i == 11) {
                this.mHamamScanResultControl.onPause();
                return;
            }
            if (i == 16) {
                this.mDryScanResultControl.onPause();
                return;
            }
            if (i == 100) {
                this.mBindSchoolControl.onPause();
            } else if (i == 9) {
                this.mSellCardScanResultControl.onPause();
            } else if (i == 101) {
                this.mV4SelectSchoolControl.onPause();
            }
        }
    }

    private void onDestroyControl() {
        if (this.mIsScanSuccess) {
            int i = this.mMode;
            if (i == 6) {
                this.mDrinkWaterScanResultControl.onDestroy();
                return;
            }
            if (i == 8) {
                this.mHairDryerScanResultControl.onDestroy();
                return;
            }
            if (i == 3) {
                this.mWashScanResultControl.onDestroy();
                return;
            }
            if (i == 2) {
                this.mCardScanResultControl.onDestroy();
                return;
            }
            if (i == 11) {
                this.mHamamScanResultControl.onDestroy();
                return;
            }
            if (i == 16) {
                this.mDryScanResultControl.onDestroy();
                return;
            }
            if (i == 100) {
                this.mBindSchoolControl.onDestroy();
            } else if (i == 9) {
                this.mSellCardScanResultControl.onDestroy();
            } else if (i == 101) {
                this.mV4SelectSchoolControl.onDestroy();
            }
        }
    }
}
