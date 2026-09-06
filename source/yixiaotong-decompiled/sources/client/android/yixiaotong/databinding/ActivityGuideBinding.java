package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager.widget.ViewPager;
import client.android.yixiaotong.R;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityGuideBinding implements ViewBinding {
    public final LinearLayout llContainer;
    private final RelativeLayout rootView;
    public final Button startBtn;
    public final ViewPager vpGuide;

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    private ActivityGuideBinding(RelativeLayout relativeLayout, LinearLayout linearLayout, Button button, ViewPager viewPager) {
        this.rootView = relativeLayout;
        this.llContainer = linearLayout;
        this.startBtn = button;
        this.vpGuide = viewPager;
    }

    public static ActivityGuideBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityGuideBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_guide, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityGuideBinding bind(View view) {
        int i = R.id.ll_container;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = R.id.start_btn;
            Button button = (Button) ViewBindings.findChildViewById(view, i);
            if (button != null) {
                i = R.id.vp_guide;
                ViewPager viewPager = (ViewPager) ViewBindings.findChildViewById(view, i);
                if (viewPager != null) {
                    return new ActivityGuideBinding((RelativeLayout) view, linearLayout, button, viewPager);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
