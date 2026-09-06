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
public final class ActivityCardDetailOldBinding implements ViewBinding {
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
    public final TextView tvAuthstate;
    public final TextView tvBindcard;
    public final TextView tvBindcardstate;
    public final TextView tvBindcardtip;
    public final TextView tvCardid;
    public final TextView tvNametext;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityCardDetailOldBinding(LinearLayout linearLayout, Button button, RelativeLayout relativeLayout, ImageButton imageButton, ImageView imageView, ImageView imageView2, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, ScrollView scrollView, TitleBar titleBar, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
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
        this.tvAuthstate = textView;
        this.tvBindcard = textView2;
        this.tvBindcardstate = textView3;
        this.tvBindcardtip = textView4;
        this.tvCardid = textView5;
        this.tvNametext = textView6;
    }

    public static ActivityCardDetailOldBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityCardDetailOldBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_card_detail_old, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityCardDetailOldBinding bind(View view) {
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
                                                i = R.id.tv_authstate;
                                                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView != null) {
                                                    i = R.id.tv_bindcard;
                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView2 != null) {
                                                        i = R.id.tv_bindcardstate;
                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView3 != null) {
                                                            i = R.id.tv_bindcardtip;
                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView4 != null) {
                                                                i = R.id.tv_cardid;
                                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView5 != null) {
                                                                    i = R.id.tv_nametext;
                                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView6 != null) {
                                                                        return new ActivityCardDetailOldBinding((LinearLayout) view, button, relativeLayout, imageButton, imageView, imageView2, relativeLayout2, relativeLayout3, relativeLayout4, scrollView, titleBar, textView, textView2, textView3, textView4, textView5, textView6);
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
