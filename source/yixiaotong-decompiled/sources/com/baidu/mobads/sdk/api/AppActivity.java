package com.baidu.mobads.sdk.api;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.baidu.mobads.sdk.internal.bv;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class AppActivity extends Activity {
    private static Activity activity;
    public static String activityName;
    private static boolean canShowWhenLock;
    private static boolean mIsShowActionBarTitle;
    private static ActionBarColorTheme mSActionBarColorTheme;
    private ClassLoader mLoader;
    private IActivityImpl mProxyActivity;

    public static void canLpShowWhenLocked(boolean z) {
        canShowWhenLock = z;
    }

    public static Activity getActivity() {
        return activity;
    }

    public static boolean getLpShowWhenLocked() {
        return canShowWhenLock;
    }

    public static void setActionBarColorTheme(ActionBarColorTheme actionBarColorTheme) {
        if (actionBarColorTheme != null) {
            mSActionBarColorTheme = actionBarColorTheme;
        }
    }

    public static void setActivityName(String str) {
        activityName = str;
    }

    public static void setIsShowActionBarTitle(boolean z) {
        mIsShowActionBarTitle = z;
    }

    @Override // android.app.Activity
    protected native void onCreate(Bundle bundle);

    static {
        StubApp.interface11(13118);
        mSActionBarColorTheme = ActionBarColorTheme.ACTION_BAR_WHITE_THEME;
        mIsShowActionBarTitle = true;
    }

    public static boolean isAnti() {
        return !TextUtils.isEmpty(activityName);
    }

    public static Class<?> getActivityClass() {
        if (!TextUtils.isEmpty(activityName)) {
            try {
                return Class.forName(activityName);
            } catch (Exception e) {
                bv.a().c(e);
            }
        }
        return AppActivity.class;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl == null || !iActivityImpl.dispatchKeyEvent(keyEvent)) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl == null || !iActivityImpl.dispatchTouchEvent(motionEvent)) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onActivityResult(i, i2, intent);
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onConfigurationChanged(configuration);
        }
        super.onConfigurationChanged(configuration);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onDestroy();
        }
        super.onDestroy();
        activity = null;
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl == null || !iActivityImpl.onKeyDown(i, keyEvent)) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl == null || !iActivityImpl.onKeyUp(i, keyEvent)) {
            return super.onKeyUp(i, keyEvent);
        }
        return true;
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onNewIntent(intent);
        }
        super.onNewIntent(intent);
    }

    @Override // android.app.Activity
    protected void onPause() {
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onPause();
        }
        super.onPause();
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onRestoreInstanceState(bundle);
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onResume();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onSaveInstanceState(bundle);
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onStart();
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onStop();
        }
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl == null || !iActivityImpl.onTouchEvent(motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onWindowFocusChanged(z);
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(i, i2);
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.overridePendingTransition(i, i2);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onAttachedToWindow();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onDetachedFromWindow();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onBackPressed();
        }
    }
}
