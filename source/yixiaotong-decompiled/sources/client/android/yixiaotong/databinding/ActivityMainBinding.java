package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.ViewFlipper;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityMainBinding implements ViewBinding {
    public final ImageView imgvTabProjectNew;
    public final LinearLayout llToolbar;
    public final FrameLayout mainLayoutTab1;
    public final FrameLayout mainLayoutTab2;
    public final FrameLayout mainLayoutTab3;
    public final FrameLayout mainLayoutTab4;
    public final ViewFlipper mainSwitcher;
    public final RadioButton rbtnAccount;
    public final RadioButton rbtnDevice;
    public final RadioButton rbtnMe;
    public final RadioButton rbtnMessage;
    private final RelativeLayout rootView;
    public final View vCover;

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    private ActivityMainBinding(RelativeLayout relativeLayout, ImageView imageView, LinearLayout linearLayout, FrameLayout frameLayout, FrameLayout frameLayout2, FrameLayout frameLayout3, FrameLayout frameLayout4, ViewFlipper viewFlipper, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, RadioButton radioButton4, View view) {
        this.rootView = relativeLayout;
        this.imgvTabProjectNew = imageView;
        this.llToolbar = linearLayout;
        this.mainLayoutTab1 = frameLayout;
        this.mainLayoutTab2 = frameLayout2;
        this.mainLayoutTab3 = frameLayout3;
        this.mainLayoutTab4 = frameLayout4;
        this.mainSwitcher = viewFlipper;
        this.rbtnAccount = radioButton;
        this.rbtnDevice = radioButton2;
        this.rbtnMe = radioButton3;
        this.rbtnMessage = radioButton4;
        this.vCover = view;
    }

    public static ActivityMainBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityMainBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_main, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityMainBinding bind(View view) {
        View viewFindChildViewById;
        int i = R.id.imgv_tab_project_new;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.ll_toolbar;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                i = R.id.main_layout_tab1;
                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                if (frameLayout != null) {
                    i = R.id.main_layout_tab2;
                    FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                    if (frameLayout2 != null) {
                        i = R.id.main_layout_tab3;
                        FrameLayout frameLayout3 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                        if (frameLayout3 != null) {
                            i = R.id.main_layout_tab4;
                            FrameLayout frameLayout4 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                            if (frameLayout4 != null) {
                                i = R.id.main_switcher;
                                ViewFlipper viewFlipper = (ViewFlipper) ViewBindings.findChildViewById(view, i);
                                if (viewFlipper != null) {
                                    i = R.id.rbtn_account;
                                    RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, i);
                                    if (radioButton != null) {
                                        i = R.id.rbtn_device;
                                        RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, i);
                                        if (radioButton2 != null) {
                                            i = R.id.rbtn_me;
                                            RadioButton radioButton3 = (RadioButton) ViewBindings.findChildViewById(view, i);
                                            if (radioButton3 != null) {
                                                i = R.id.rbtn_message;
                                                RadioButton radioButton4 = (RadioButton) ViewBindings.findChildViewById(view, i);
                                                if (radioButton4 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.v_cover))) != null) {
                                                    return new ActivityMainBinding((RelativeLayout) view, imageView, linearLayout, frameLayout, frameLayout2, frameLayout3, frameLayout4, viewFlipper, radioButton, radioButton2, radioButton3, radioButton4, viewFindChildViewById);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
