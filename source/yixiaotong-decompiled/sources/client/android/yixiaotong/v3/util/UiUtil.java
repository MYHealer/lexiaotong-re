package client.android.yixiaotong.v3.util;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ScrollView;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class UiUtil {
    private static String TAG = "com.ads.demo.UiUtil";

    public static int dip2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int px2dip(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static float getScreenWidthDp(Context context) {
        float f = context.getResources().getDisplayMetrics().density;
        float f2 = context.getResources().getDisplayMetrics().widthPixels;
        if (f <= 0.0f) {
            f = 1.0f;
        }
        return (f2 / f) + 0.5f;
    }

    public static float getScreenHeightDp(Context context) {
        return px2dip(context, context.getResources().getDisplayMetrics().heightPixels);
    }

    public static int getScreenWidthInPx(Context context) {
        return StubApp.getOrigApplicationContext(context.getApplicationContext()).getResources().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeightInPx(Context context) {
        return StubApp.getOrigApplicationContext(context.getApplicationContext()).getResources().getDisplayMetrics().heightPixels;
    }

    public static void removeFromParent(View view) {
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view);
            }
        }
    }

    public static int getHeight(Activity activity, ScrollView scrollView) {
        int measuredHeight = scrollView.getChildAt(0).getMeasuredHeight();
        int height = scrollView.getHeight() - (scrollView.getPaddingTop() + scrollView.getPaddingBottom());
        int iDip2px = (height - measuredHeight) - dip2px(activity, 10.0f);
        LogUtil.e(TAG, "ScrollView页面剩余的高度为：" + height + PPSLabelView.Code + measuredHeight + PPSLabelView.Code + dip2px(activity, 60.0f));
        if (iDip2px > 0) {
            return px2dip(activity, iDip2px);
        }
        return 0;
    }
}
