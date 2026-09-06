package client.android.yixiaotong.v4.ui.scan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.store.ClientDataManager;
import client.android.yixiaotong.ui.widget.TitleBar;
import com.huawei.hms.hmsscankit.OnResultCallback;
import com.huawei.hms.hmsscankit.RemoteView;
import com.huawei.hms.hmsscankit.ScanUtil;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.ml.scan.HmsScanAnalyzerOptions;
import com.stub.StubApp;
import com.yfanads.android.libs.net.UrlHttpUtil;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4ScanQrcodeActivity extends BaseActivity {
    public static final int REQUEST_CODE_PHOTO = 4371;
    public static final String SCAN_RESULT = "scanResult";
    private static final String TAG = "ScanQrcodeOrBarcodeActivity";
    private ImageView flushBtn;
    private FrameLayout frameLayout;
    private ImageView imgBtn;
    private TranslateAnimation mAnimation;
    private int mMode;
    private V4ScanResultControlUtil mScanResultControlUtil;
    int mScreenHeight;
    int mScreenWidth;
    private TitleBar mTitleBar;
    private RemoteView remoteView;
    private ImageView scanLine;
    private TextView scantip;
    final int SCAN_FRAME_SIZE = 240;
    private int[] img = {R.drawable.flashlight_on, R.drawable.flashlight_off};
    private boolean mIsScanSuccess = false;

    static {
        StubApp.interface11(11021);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, int i) {
        if (activity != null) {
            activity.startActivityForResult(new Intent(activity, (Class<?>) V4ScanQrcodeActivity.class).putExtra("mode", i), 1);
        }
    }

    public static void launch(Activity activity) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) V4ScanQrcodeActivity.class));
        }
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.v4.ui.scan.V4ScanQrcodeActivity$1, reason: invalid class name */
    class AnonymousClass1 implements OnResultCallback {
        AnonymousClass1() {
        }

        @Override // com.huawei.hms.hmsscankit.OnResultCallback
        public void onResult(HmsScan[] hmsScanArr) {
            HmsScan hmsScan;
            if (hmsScanArr == null || hmsScanArr.length <= 0 || (hmsScan = hmsScanArr[0]) == null || TextUtils.isEmpty(hmsScan.getOriginalValue())) {
                return;
            }
            V4ScanQrcodeActivity.this.scanSuccess(hmsScanArr[0].getOriginalValue());
        }
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.v4.ui.scan.V4ScanQrcodeActivity$2, reason: invalid class name */
    class AnonymousClass2 implements Runnable {
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (V4ScanQrcodeActivity.this.mIsScanSuccess) {
                return;
            }
            V4ScanQrcodeActivity.this.scantip.setVisibility(0);
        }
    }

    private void vibrator() {
        ((Vibrator) getSystemService("vibrator")).vibrate(200L);
    }

    private void setPictureScanOperation() {
        ImageView imageView = (ImageView) findViewById(R.id.img_btn);
        this.imgBtn = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.scan.V4ScanQrcodeActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, UrlHttpUtil.FILE_TYPE_IMAGE);
                V4ScanQrcodeActivity.this.startActivityForResult(intent, 4371);
            }
        });
    }

    private void setFlashOperation() {
        this.flushBtn.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.scan.V4ScanQrcodeActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (V4ScanQrcodeActivity.this.remoteView.getLightStatus()) {
                    V4ScanQrcodeActivity.this.remoteView.switchLight();
                    V4ScanQrcodeActivity.this.flushBtn.setImageResource(V4ScanQrcodeActivity.this.img[1]);
                } else {
                    V4ScanQrcodeActivity.this.remoteView.switchLight();
                    V4ScanQrcodeActivity.this.flushBtn.setImageResource(V4ScanQrcodeActivity.this.img[0]);
                }
            }
        });
    }

    private void initTitleBar() {
        TitleBar titleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mTitleBar = titleBar;
        titleBar.setTitleView(getResources().getString(R.string.scancode));
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
        this.mTitleBar.setGravity(10);
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
        this.mScanResultControlUtil.onResume();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.remoteView.onPause();
        this.mScanResultControlUtil.onPause();
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
        if (ClientDataManager.getInstance().getBooleanDefaultTrue(ClientDataManager.MESSAGE_VIBRATE)) {
            vibrator();
        }
        this.remoteView.pauseContinuouslyScan();
        if (this.mIsScanSuccess) {
            return;
        }
        this.mIsScanSuccess = true;
        this.mScanResultControlUtil.onResult(this.mMode, str);
    }
}
