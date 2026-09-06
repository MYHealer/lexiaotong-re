package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivitySchoolCardBinding implements ViewBinding {
    public final Button btnUnbind;
    public final RelativeLayout flContainer;
    public final ImageButton ibEye;
    public final ImageView ivIcon1;
    public final ImageView ivNext;
    public final RelativeLayout relAuth;
    public final RelativeLayout relBindcardtip;
    public final RelativeLayout relScanbindcard;
    private final LinearLayout rootView;
    public final ScrollView scrollview;
    public final TitleBar titleBar;
    public final TextView tvAdvname;
    public final TextView tvAuthstate;
    public final TextView tvBindcard;
    public final TextView tvBindcardstate;
    public final TextView tvBindcardtip;
    public final TextView tvCardid;
    public final TextView tvClickset;
    public final TextView tvNametext;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivitySchoolCardBinding(LinearLayout linearLayout, Button button, RelativeLayout relativeLayout, ImageButton imageButton, ImageView imageView, ImageView imageView2, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, ScrollView scrollView, TitleBar titleBar, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8) {
        this.rootView = linearLayout;
        this.btnUnbind = button;
        this.flContainer = relativeLayout;
        this.ibEye = imageButton;
        this.ivIcon1 = imageView;
        this.ivNext = imageView2;
        this.relAuth = relativeLayout2;
        this.relBindcardtip = relativeLayout3;
        this.relScanbindcard = relativeLayout4;
        this.scrollview = scrollView;
        this.titleBar = titleBar;
        this.tvAdvname = textView;
        this.tvAuthstate = textView2;
        this.tvBindcard = textView3;
        this.tvBindcardstate = textView4;
        this.tvBindcardtip = textView5;
        this.tvCardid = textView6;
        this.tvClickset = textView7;
        this.tvNametext = textView8;
    }

    public static ActivitySchoolCardBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivitySchoolCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_school_card, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivitySchoolCardBinding bind(View view) {
        int i = R.id.btn_unbind;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.flContainer;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
            if (relativeLayout != null) {
                i = R.id.ib_eye;
                ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, i);
                if (imageButton != null) {
                    i = R.id.iv_icon1;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView != null) {
                        i = R.id.iv_next;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView2 != null) {
                            i = R.id.rel_auth;
                            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                            if (relativeLayout2 != null) {
                                i = R.id.rel_bindcardtip;
                                RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                if (relativeLayout3 != null) {
                                    i = R.id.rel_scanbindcard;
                                    RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                    if (relativeLayout4 != null) {
                                        i = R.id.scrollview;
                                        ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(view, i);
                                        if (scrollView != null) {
                                            i = R.id.titleBar;
                                            TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                                            if (titleBar != null) {
                                                i = R.id.tv_advname;
                                                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView != null) {
                                                    i = R.id.tv_authstate;
                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView2 != null) {
                                                        i = R.id.tv_bindcard;
                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView3 != null) {
                                                            i = R.id.tv_bindcardstate;
                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView4 != null) {
                                                                i = R.id.tv_bindcardtip;
                                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView5 != null) {
                                                                    i = R.id.tv_cardid;
                                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView6 != null) {
                                                                        i = R.id.tv_clickset;
                                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView7 != null) {
                                                                            i = R.id.tv_nametext;
                                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                            if (textView8 != null) {
                                                                                return new ActivitySchoolCardBinding((LinearLayout) view, button, relativeLayout, imageButton, imageView, imageView2, relativeLayout2, relativeLayout3, relativeLayout4, scrollView, titleBar, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8);
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
