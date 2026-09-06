package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.ViewFlipper;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivitySellCardMainBinding implements ViewBinding {
    public final LinearLayout llToolbar;
    public final FrameLayout mainLayoutTab1;
    public final FrameLayout mainLayoutTab2;
    public final ViewFlipper mainSwitcher;
    public final RadioButton rbtnAccount;
    public final RadioButton rbtnMe;
    private final RelativeLayout rootView;
    public final View vCover;

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    private ActivitySellCardMainBinding(RelativeLayout relativeLayout, LinearLayout linearLayout, FrameLayout frameLayout, FrameLayout frameLayout2, ViewFlipper viewFlipper, RadioButton radioButton, RadioButton radioButton2, View view) {
        this.rootView = relativeLayout;
        this.llToolbar = linearLayout;
        this.mainLayoutTab1 = frameLayout;
        this.mainLayoutTab2 = frameLayout2;
        this.mainSwitcher = viewFlipper;
        this.rbtnAccount = radioButton;
        this.rbtnMe = radioButton2;
        this.vCover = view;
    }

    public static ActivitySellCardMainBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivitySellCardMainBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_sell_card_main, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivitySellCardMainBinding bind(View view) {
        View viewFindChildViewById;
        int i = R.id.ll_toolbar;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = R.id.main_layout_tab1;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
            if (frameLayout != null) {
                i = R.id.main_layout_tab2;
                FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                if (frameLayout2 != null) {
                    i = R.id.main_switcher;
                    ViewFlipper viewFlipper = (ViewFlipper) ViewBindings.findChildViewById(view, i);
                    if (viewFlipper != null) {
                        i = R.id.rbtn_account;
                        RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, i);
                        if (radioButton != null) {
                            i = R.id.rbtn_me;
                            RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, i);
                            if (radioButton2 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.v_cover))) != null) {
                                return new ActivitySellCardMainBinding((RelativeLayout) view, linearLayout, frameLayout, frameLayout2, viewFlipper, radioButton, radioButton2, viewFindChildViewById);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
