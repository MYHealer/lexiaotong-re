package com.huawei.hms.hmsscankit;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.OrientationEventListener;
import android.view.WindowManager;
import com.huawei.hms.ml.scan.HmsScan;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class ScanKitActivity extends Activity {
    private static final String TAG = "ScanKitActivity";
    private int lastRotation = Integer.MAX_VALUE;
    private OrientationEventListener mOrientationListener;
    private RemoteView remoteView;

    /* JADX INFO: renamed from: com.huawei.hms.hmsscankit.ScanKitActivity$1, reason: invalid class name */
    class AnonymousClass1 implements OnResultCallback {
        AnonymousClass1() {
        }

        @Override // com.huawei.hms.hmsscankit.OnResultCallback
        public void onResult(HmsScan[] hmsScanArr) {
            HmsScan hmsScan;
            if (hmsScanArr == null || hmsScanArr.length <= 0 || (hmsScan = hmsScanArr[0]) == null || TextUtils.isEmpty(hmsScan.originalValue)) {
                return;
            }
            Log.i(ScanKitActivity.TAG, "onResult: obtain scanResult");
            Intent intent = new Intent();
            intent.putExtra(ScanUtil.RESULT, hmsScanArr[0]);
            ScanKitActivity.this.setResult(-1, intent);
            ScanKitActivity.this.finish();
        }
    }

    static {
        StubApp.interface11(34812);
    }

    private void setActivityUseNotchScreen(Activity activity) {
        if (activity != null) {
            WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
            if (Build.VERSION.SDK_INT >= 28) {
                attributes.layoutInDisplayCutoutMode = 1;
            }
            activity.getWindow().setAttributes(attributes);
        }
    }

    private void startOrientationChangeListener() {
        OrientationEventListener orientationEventListener = new OrientationEventListener(this) { // from class: com.huawei.hms.hmsscankit.ScanKitActivity.2
            @Override // android.view.OrientationEventListener
            public void onOrientationChanged(int i) {
                try {
                    int rotation = ScanKitActivity.this.getWindowManager().getDefaultDisplay().getRotation();
                    if (Math.abs(ScanKitActivity.this.lastRotation - rotation) == 2) {
                        ScanKitActivity.this.recreate();
                        Log.i(ScanKitActivity.TAG, "onOrientationChanged: currentRotation" + rotation);
                    }
                    ScanKitActivity.this.lastRotation = rotation;
                } catch (RuntimeException unused) {
                    Log.e(ScanKitActivity.TAG, "onOrientationChanged: RuntimeException");
                }
            }
        };
        this.mOrientationListener = orientationEventListener;
        orientationEventListener.enable();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.remoteView.onActivityResult(i, i2, intent);
    }

    @Override // android.app.Activity
    protected native void onCreate(Bundle bundle);

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.remoteView.onDestroy();
        Log.i(TAG, "ScankitActivity onDestroy");
        OrientationEventListener orientationEventListener = this.mOrientationListener;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.remoteView.onPause();
        Log.i(TAG, "ScankitActivity onPause");
    }

    @Override // android.app.Activity
    public native void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.remoteView.onResume();
        Log.i(TAG, "ScankitActivity onResume");
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.remoteView.onStart();
        Log.i(TAG, "ScankitActivity onStart");
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        this.remoteView.onStop();
        Log.i(TAG, "ScankitActivity onStop");
    }
}
