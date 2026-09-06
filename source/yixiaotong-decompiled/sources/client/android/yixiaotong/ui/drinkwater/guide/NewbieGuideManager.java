package client.android.yixiaotong.ui.drinkwater.guide;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.view.View;
import client.android.yixiaotong.R;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class NewbieGuideManager {
    private static final String TAG = "newbie_guide";
    public static final int TYPE_COLLECT = 101;
    public static final int TYPE_LIST = 0;
    public static NewbieGuide mNewbieGuide;
    private Activity mActivity;
    private int mType;
    private SharedPreferences sp;

    public static boolean isNeverShowed(Activity activity, int i) {
        return true;
    }

    public NewbieGuideManager(Activity activity, int i) {
        mNewbieGuide = new NewbieGuide(activity);
        this.sp = activity.getSharedPreferences(TAG, 0);
        this.mActivity = activity;
        this.mType = i;
    }

    public NewbieGuideManager addView(View view, int i) {
        mNewbieGuide.addHighLightView(view, i);
        return this;
    }

    public void show() {
        show(0);
    }

    public void show(int i) {
        SharedPreferences.Editor editorEdit = this.sp.edit();
        editorEdit.putBoolean(TAG + this.mType, false);
        editorEdit.apply();
        new Handler().postDelayed(new Runnable() { // from class: client.android.yixiaotong.ui.drinkwater.guide.NewbieGuideManager.1
            @Override // java.lang.Runnable
            public void run() {
                if (NewbieGuideManager.this.mType != 101) {
                    return;
                }
                NewbieGuideManager.mNewbieGuide.addIndicateImg(R.drawable.j_drink_water_rightup, ScreenUtils.dpToPx((Context) NewbieGuideManager.this.mActivity, -3), ScreenUtils.dpToPx((Context) NewbieGuideManager.this.mActivity, 60)).addMsgAndKnowTv("1.点击这里显示预付费金额\n\n2.扫码成功后会扣除预付费金\n额，请勿多次扫码", ScreenUtils.dpToPx((Context) NewbieGuideManager.this.mActivity, 150)).show();
            }
        }, i);
    }

    public void showWithListener(int i, NewbieGuide.OnGuideChangedListener onGuideChangedListener) {
        mNewbieGuide.setOnGuideChangedListener(onGuideChangedListener);
        show(i);
    }
}
