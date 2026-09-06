package client.android.yixiaotong.ui.scancode;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.account.AccountManager;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.sdk.qrcode.camera.CameraManager;
import client.android.yixiaotong.sdk.qrcode.decode.DecodeThread;
import client.android.yixiaotong.sdk.qrcode.utils.IActivityHandler;
import client.android.yixiaotong.sdk.qrcode.utils.InactivityTimer;
import client.android.yixiaotong.ui.card.CardScanResultControl;
import client.android.yixiaotong.ui.drinkwater.DrinkWaterScanResultControl;
import client.android.yixiaotong.ui.dry.DryScanResultControl;
import client.android.yixiaotong.ui.hairdryer.HairDryerScanResultControl;
import client.android.yixiaotong.ui.hamam.HamamScanResultControl;
import client.android.yixiaotong.ui.qrcode.BindSchoolControl;
import client.android.yixiaotong.ui.sellcard.SellCardScanResultControl;
import client.android.yixiaotong.ui.wash.WashScanResultControl;
import client.android.yixiaotong.ui.widget.TitleBar;
import com.google.zxing.Result;
import com.stub.StubApp;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ZxingScanActivity extends BaseActivity implements SurfaceHolder.Callback, IActivityHandler {
    private static final String TAG = "ZxingScanActivity";
    private ZxingScanActivityHandler handler;
    private TranslateAnimation mAnimation;
    private BindSchoolControl mBindSchoolControl;
    private CameraManager mCameraManager;
    private CardScanResultControl mCardScanResultControl;
    private String mData;
    private DrinkWaterScanResultControl mDrinkWaterScanResultControl;
    private DryScanResultControl mDryScanResultControl;
    private HairDryerScanResultControl mHairDryerScanResultControl;
    private HamamScanResultControl mHamamScanResultControl;
    private InactivityTimer mInactivityTimer;
    private int mMode;
    private SellCardScanResultControl mSellCardScanResultControl;
    private TitleBar mTitleBar;
    private WalletModel mWalletModel;
    private WashScanResultControl mWashScanResultControl;
    private RelativeLayout scanContainer;
    private RelativeLayout scanCropView;
    private ImageView scanLine;
    private boolean mIsScanSuccess = false;
    private SurfaceView scanPreview = null;
    private Rect mCropRect = null;
    private boolean isHasSurface = false;

    static {
        StubApp.interface11(7574);
    }

    @Override // client.android.yixiaotong.sdk.qrcode.utils.IActivityHandler
    public CameraManager getCameraManager() {
        return this.mCameraManager;
    }

    @Override // client.android.yixiaotong.sdk.qrcode.utils.IActivityHandler
    public Rect getCropRect() {
        return this.mCropRect;
    }

    @Override // client.android.yixiaotong.sdk.qrcode.utils.IActivityHandler
    public Handler getHandler() {
        return this.handler;
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.isHasSurface = false;
    }

    public static void launch(Activity activity, WalletModel walletModel, String str, int i) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) ZxingScanActivity.class).putExtra("walletmodel", walletModel).putExtra("data", str).putExtra("mode", i));
        }
    }

    public static void launch(Activity activity, int i) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) ZxingScanActivity.class).putExtra("mode", i));
        }
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

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mCameraManager = new CameraManager(getApplication());
        this.handler = null;
        if (this.isHasSurface) {
            initCamera(this.scanPreview.getHolder());
        } else {
            this.scanPreview.getHolder().addCallback(this);
        }
        this.mInactivityTimer.onResume();
        onResumeControl();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        ZxingScanActivityHandler zxingScanActivityHandler = this.handler;
        if (zxingScanActivityHandler != null) {
            zxingScanActivityHandler.quitSynchronously();
            this.handler = null;
        }
        this.mInactivityTimer.onPause();
        this.mCameraManager.closeDriver();
        if (!this.isHasSurface) {
            this.scanPreview.getHolder().removeCallback(this);
        }
        super.onPause();
        onPauseControl();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.mInactivityTimer.shutdown();
        super.onDestroy();
        onDestroyControl();
        Log.e("ZxingScan", "onDestroy");
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (surfaceHolder == null) {
            Log.e(TAG, "*** WARNING *** surfaceCreated() gave us a null surface!");
        }
        if (this.isHasSurface) {
            return;
        }
        this.isHasSurface = true;
        initCamera(surfaceHolder);
    }

    @Override // client.android.yixiaotong.sdk.qrcode.utils.IActivityHandler
    public void handleDecode(Result result, Bundle bundle) {
        this.mInactivityTimer.onActivity();
        scanSuccess(result.getText());
    }

    private void initCamera(SurfaceHolder surfaceHolder) {
        if (surfaceHolder == null) {
            throw new IllegalStateException("No SurfaceHolder provided");
        }
        if (this.mCameraManager.isOpen()) {
            Log.w(TAG, "initCamera() while already open -- late SurfaceView callback?");
            return;
        }
        try {
            this.mCameraManager.openDriver(surfaceHolder);
            if (this.handler == null) {
                this.handler = new ZxingScanActivityHandler(this, this.mCameraManager, DecodeThread.ALL_MODE);
            }
            initCrop();
        } catch (IOException e) {
            Log.w(TAG, e);
            displayFrameworkBugMessageAndExit();
        } catch (RuntimeException e2) {
            Log.w(TAG, "Unexpected error initializing camera", e2);
            displayFrameworkBugMessageAndExit();
        }
    }

    private void displayFrameworkBugMessageAndExit() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("提示");
        builder.setMessage("相机打开出错，请稍后重试");
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() { // from class: client.android.yixiaotong.ui.scancode.ZxingScanActivity.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        builder.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: client.android.yixiaotong.ui.scancode.ZxingScanActivity.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
            }
        });
        builder.show();
    }

    public void restartPreviewAfterDelay(long j) {
        ZxingScanActivityHandler zxingScanActivityHandler = this.handler;
        if (zxingScanActivityHandler != null) {
            zxingScanActivityHandler.sendEmptyMessageDelayed(client.android.yixiaotong.sdk.R.id.restart_preview, j);
        }
    }

    private void initCrop() {
        int i = this.mCameraManager.getCameraResolution().y;
        int i2 = this.mCameraManager.getCameraResolution().x;
        int[] iArr = new int[2];
        this.scanCropView.getLocationInWindow(iArr);
        int i3 = iArr[0];
        int statusBarHeight = iArr[1] - getStatusBarHeight();
        int width = this.scanCropView.getWidth();
        int height = this.scanCropView.getHeight();
        int width2 = this.scanContainer.getWidth();
        int height2 = this.scanContainer.getHeight();
        int i4 = (i3 * i) / width2;
        int i5 = (statusBarHeight * i2) / height2;
        this.mCropRect = new Rect(i4, i5, ((width * i) / width2) + i4, ((height * i2) / height2) + i5);
    }

    private int getStatusBarHeight() {
        try {
            Class<?> cls = Class.forName("com.android.internal.R$dimen");
            return getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    private void scanSuccess(String str) {
        if (this.mIsScanSuccess) {
            return;
        }
        this.mIsScanSuccess = true;
        int i = this.mMode;
        if (i == 6) {
            this.mDrinkWaterScanResultControl.init(this, AccountManager.getInstance().getLoginAccount(), this.mWalletModel, str, this.mData);
            return;
        }
        if (i == 8) {
            this.mHairDryerScanResultControl.init(this, AccountManager.getInstance().getLoginAccount(), this.mWalletModel, str, this.mData);
            return;
        }
        if (i == 3) {
            this.mWashScanResultControl.init(this, AccountManager.getInstance().getLoginAccount(), this.mWalletModel, str, this.mData);
            return;
        }
        if (i == 2) {
            this.mCardScanResultControl.init(this, AccountManager.getInstance().getLoginAccount(), this.mWalletModel, str, this.mData);
            return;
        }
        if (i == 11) {
            this.mHamamScanResultControl.init(this, AccountManager.getInstance().getLoginAccount(), this.mWalletModel, str, this.mData);
            return;
        }
        if (i == 16) {
            this.mDryScanResultControl.init(this, AccountManager.getInstance().getLoginAccount(), this.mWalletModel, str, this.mData);
        } else if (i == 100) {
            this.mBindSchoolControl.init(this, AccountManager.getInstance().getLoginAccount(), str);
        } else if (i == 9) {
            this.mSellCardScanResultControl.init(this, AccountManager.getInstance().getLoginAccount(), this.mWalletModel, str, this.mData);
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
        } else if (i == 100) {
            BindSchoolControl bindSchoolControl = new BindSchoolControl();
            this.mBindSchoolControl = bindSchoolControl;
            bindSchoolControl.onResume();
        } else if (i == 9) {
            SellCardScanResultControl sellCardScanResultControl = new SellCardScanResultControl();
            this.mSellCardScanResultControl = sellCardScanResultControl;
            sellCardScanResultControl.onResume();
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
            } else if (i == 100) {
                this.mBindSchoolControl.onPause();
            } else if (i == 9) {
                this.mSellCardScanResultControl.onPause();
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
            } else if (i == 100) {
                this.mBindSchoolControl.onDestroy();
            } else if (i == 9) {
                this.mSellCardScanResultControl.onDestroy();
            }
        }
    }
}
