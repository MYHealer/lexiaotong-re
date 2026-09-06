package com.fancy;

import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import client.android.yixiaotong.v3.comman.AppTypeIdUtil;
import com.fancy.adsdk.lib.PtgAdSdk;
import com.fancy.adsdk.lib.R;
import com.fancy.adsdk.lib.doodle.Doodle;
import com.fancy.adsdk.lib.utils.dev.ScreenUtils;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _p5 {
    public static int _a(View view) {
        if (view == null) {
            return 0;
        }
        Object tag = view.getTag(R.id.fancy_native_view_tag);
        if (tag instanceof _ok) {
            return ((_ok) tag)._k;
        }
        return 0;
    }

    public static void _b(View view) {
        if (view != null) {
            Object tag = view.getTag(R.id.fancy_native_view_tag);
            if (tag instanceof _ok) {
                ((_ok) tag)._k = 0;
            }
        }
    }

    public static void _a(View view, int i) {
        if (view != null) {
            Object tag = view.getTag(R.id.fancy_native_view_tag);
            if (tag instanceof _ok) {
                ((_ok) tag)._k = i;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int i2 = iArr[0];
            int i3 = iArr[1];
            int width = view.getWidth();
            int height = view.getHeight();
            if (width <= 0 || height <= 0) {
                return;
            }
            int i4 = (width / 4) + i2;
            int i5 = ((width * 3) / 4) + i2;
            int i6 = (height / 4) + i3;
            int i7 = ((height * 3) / 4) + i3;
            int iNextInt = com.fancy.adsdk.lib.utils._a._a.nextInt((i5 - i4) + 1) + i4;
            int iNextInt2 = com.fancy.adsdk.lib.utils._a._a.nextInt((i7 - i6) + 1) + i6;
            int[] iArr2 = {iNextInt, iNextInt2, iNextInt, iNextInt2};
            long jUptimeMillis = SystemClock.uptimeMillis();
            long jUptimeMillis2 = SystemClock.uptimeMillis();
            int i8 = iArr2[0];
            int i9 = iArr2[1];
            int i10 = iArr2[2];
            int i11 = iArr2[3];
            MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis2, 0, i8, i9, 0);
            view.dispatchTouchEvent(motionEventObtain);
            motionEventObtain.recycle();
            long jNextInt = new Random().nextInt(AppTypeIdUtil.NewDevice4GBathOTA);
            _fv._a.postDelayed(new _p4(view, jUptimeMillis, jUptimeMillis2 + jNextInt, i10, i11), jNextInt);
        }
    }

    public static void _a(ImageView imageView) {
        _m3 _m3VarLoad;
        int i = R.drawable.fancy_api_logo;
        try {
            int iDpToPx = ScreenUtils.dpToPx(PtgAdSdk.getContext(), 9.0f);
            int iDpToPx2 = ScreenUtils.dpToPx(PtgAdSdk.getContext(), 9.0f);
            if (imageView != null) {
                int sdkLogoId = PtgAdSdk.getConfig().getSdkLogoId();
                if (sdkLogoId != 0) {
                    AtomicBoolean atomicBoolean = _ev._a;
                    if (sdkLogoId == 0) {
                        return;
                    }
                    _m3VarLoad = Doodle.load(sdkLogoId);
                    _m3VarLoad._d = iDpToPx;
                    _m3VarLoad._e = iDpToPx2;
                    _m3VarLoad._h = false;
                    _m3VarLoad._n = new _ew(imageView, sdkLogoId);
                } else {
                    String sdkLogoUrl = PtgAdSdk.getConfig().getSdkLogoUrl();
                    if (!TextUtils.isEmpty(sdkLogoUrl)) {
                        _ev._a(imageView, sdkLogoUrl, iDpToPx, iDpToPx2);
                        return;
                    }
                    if (i == 0) {
                        return;
                    }
                    AtomicBoolean atomicBoolean2 = _ev._a;
                    if (i == 0) {
                        return;
                    }
                    _m3 _m3VarLoad2 = Doodle.load(i);
                    _m3VarLoad2._d = iDpToPx;
                    _m3VarLoad2._e = iDpToPx2;
                    _m3VarLoad2._h = false;
                    _m3VarLoad2._n = new _ew(imageView, i);
                    _m3VarLoad = _m3VarLoad2;
                }
                _m3VarLoad._a(iDpToPx, iDpToPx2);
            }
        } catch (Exception unused) {
        }
    }
}
