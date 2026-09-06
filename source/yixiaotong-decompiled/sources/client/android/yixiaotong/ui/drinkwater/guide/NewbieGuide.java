package client.android.yixiaotong.ui.drinkwater.guide;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import client.android.yixiaotong.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class NewbieGuide {
    public static final int CENTER = 0;
    private Activity mActivity;
    private boolean mEveryWhereTouchable = true;
    private GuideView mGuideView;
    private List<HoleBean> mHoleList;
    private OnGuideChangedListener mOnGuideChangedListener;
    private FrameLayout mParentView;

    public interface OnGuideChangedListener {
        void onRemoved();

        void onShowed();
    }

    public NewbieGuide setEveryWhereTouchable(boolean z) {
        this.mEveryWhereTouchable = z;
        return this;
    }

    public void setOnGuideChangedListener(OnGuideChangedListener onGuideChangedListener) {
        this.mOnGuideChangedListener = onGuideChangedListener;
    }

    public NewbieGuide(Activity activity) {
        init(activity);
    }

    private NewbieGuide init(Activity activity) {
        this.mActivity = activity;
        this.mParentView = (FrameLayout) activity.getWindow().getDecorView();
        this.mGuideView = new GuideView(this.mActivity);
        this.mHoleList = new ArrayList();
        return this;
    }

    public NewbieGuide addHighLightView(View view, int i) {
        this.mHoleList.add(new HoleBean(view, i));
        return this;
    }

    public NewbieGuide addIndicateImg(int i, int i2, int i3) {
        ImageView imageView = new ImageView(this.mActivity);
        imageView.setImageResource(i);
        this.mGuideView.addView(imageView, getLp(i2, i3));
        return this;
    }

    public NewbieGuide addMessage(String str, int i, int i2) {
        this.mGuideView.addView(generateMsgTv(str), getLp(i, i2));
        return this;
    }

    public NewbieGuide addKnowTv(String str, int i, int i2) {
        this.mGuideView.addView(generateKnowTv(str), getLp(i, i2));
        return this;
    }

    public NewbieGuide addMsgAndKnowTv(String str, int i) {
        this.mGuideView.addView(generateMsgAndKnowTv(str), getLp(0, i));
        return this;
    }

    private TextView generateMsgTv(String str) {
        TextView textView = new TextView(this.mActivity);
        textView.setText(str);
        textView.setTextColor(-1);
        textView.setTextSize(15.0f);
        textView.setLineSpacing(ScreenUtils.dpToPx((Context) this.mActivity, 5), 1.0f);
        textView.setGravity(17);
        return textView;
    }

    private TextView generateKnowTv(String str) {
        TextView textView = new TextView(this.mActivity);
        textView.setTextColor(-1);
        textView.setTextSize(15.0f);
        textView.setPadding(ScreenUtils.dpToPx((Context) this.mActivity, 15), ScreenUtils.dpToPx((Context) this.mActivity, 5), ScreenUtils.dpToPx((Context) this.mActivity, 15), ScreenUtils.dpToPx((Context) this.mActivity, 5));
        textView.setBackgroundResource(R.drawable.j_drink_water_guide_solid_white_bg);
        textView.setText(str);
        textView.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.drinkwater.guide.NewbieGuide.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NewbieGuide.this.remove();
            }
        });
        return textView;
    }

    private LinearLayout generateMsgAndKnowTv(String str) {
        LinearLayout linearLayout = new LinearLayout(this.mActivity);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        linearLayout.addView(generateMsgTv(str), layoutParams);
        layoutParams.topMargin = ScreenUtils.dpToPx((Context) this.mActivity, 70);
        linearLayout.addView(generateKnowTv("我知道啦"), layoutParams);
        return linearLayout;
    }

    private RelativeLayout.LayoutParams getLp(int i, int i2) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (i == 0) {
            layoutParams.addRule(14, -1);
        } else if (i < 0) {
            layoutParams.addRule(11, -1);
            layoutParams.rightMargin = -i;
        } else {
            layoutParams.leftMargin = i;
        }
        if (i2 == 0) {
            layoutParams.addRule(15, -1);
        } else if (i2 < 0) {
            layoutParams.addRule(12, -1);
            layoutParams.bottomMargin = -i2;
        } else {
            layoutParams.topMargin = i2;
        }
        return layoutParams;
    }

    public void show() {
        this.mGuideView.setPadding(0, 0, ScreenUtils.getStatusBarHeight(this.mActivity), 0);
        this.mGuideView.setDate(this.mHoleList);
        this.mParentView.addView(this.mGuideView, new FrameLayout.LayoutParams(-1, -1));
        OnGuideChangedListener onGuideChangedListener = this.mOnGuideChangedListener;
        if (onGuideChangedListener != null) {
            onGuideChangedListener.onShowed();
        }
        if (this.mEveryWhereTouchable) {
            this.mGuideView.setOnTouchListener(new View.OnTouchListener() { // from class: client.android.yixiaotong.ui.drinkwater.guide.NewbieGuide.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    NewbieGuide.this.remove();
                    return false;
                }
            });
        }
    }

    public void remove() {
        GuideView guideView = this.mGuideView;
        if (guideView == null || guideView.getParent() == null) {
            return;
        }
        this.mGuideView.recycler();
        ((ViewGroup) this.mGuideView.getParent()).removeView(this.mGuideView);
        OnGuideChangedListener onGuideChangedListener = this.mOnGuideChangedListener;
        if (onGuideChangedListener != null) {
            onGuideChangedListener.onRemoved();
        }
    }
}
