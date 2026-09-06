package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.hamam.PwdEditText;
import client.android.yixiaotong.ui.widget.TitleBar;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityHamamBinding implements ViewBinding {
    public final PwdEditText etPsw;
    public final ImageView imgEye;
    public final ImageView imgSex;
    public final SimpleDraweeView ivMeIcon;
    public final LinearLayout llMeInfo;
    public final RelativeLayout rel;
    private final RelativeLayout rootView;
    public final TextView tip1;
    public final TextView tip2;
    public final TextView tip3;
    public final TitleBar titleBar;
    public final TextView tvMeId;
    public final TextView tvMeName;
    public final TextView tvMeXuehao;

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    private ActivityHamamBinding(RelativeLayout relativeLayout, PwdEditText pwdEditText, ImageView imageView, ImageView imageView2, SimpleDraweeView simpleDraweeView, LinearLayout linearLayout, RelativeLayout relativeLayout2, TextView textView, TextView textView2, TextView textView3, TitleBar titleBar, TextView textView4, TextView textView5, TextView textView6) {
        this.rootView = relativeLayout;
        this.etPsw = pwdEditText;
        this.imgEye = imageView;
        this.imgSex = imageView2;
        this.ivMeIcon = simpleDraweeView;
        this.llMeInfo = linearLayout;
        this.rel = relativeLayout2;
        this.tip1 = textView;
        this.tip2 = textView2;
        this.tip3 = textView3;
        this.titleBar = titleBar;
        this.tvMeId = textView4;
        this.tvMeName = textView5;
        this.tvMeXuehao = textView6;
    }

    public static ActivityHamamBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityHamamBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_hamam, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityHamamBinding bind(View view) {
        int i = R.id.et_psw;
        PwdEditText pwdEditText = (PwdEditText) ViewBindings.findChildViewById(view, i);
        if (pwdEditText != null) {
            i = R.id.img_eye;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.img_sex;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView2 != null) {
                    i = R.id.iv_me_icon;
                    SimpleDraweeView simpleDraweeView = (SimpleDraweeView) ViewBindings.findChildViewById(view, i);
                    if (simpleDraweeView != null) {
                        i = R.id.ll_me_info;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                        if (linearLayout != null) {
                            i = R.id.rel;
                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                            if (relativeLayout != null) {
                                i = R.id.tip1;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView != null) {
                                    i = R.id.tip2;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView2 != null) {
                                        i = R.id.tip3;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView3 != null) {
                                            i = R.id.titleBar;
                                            TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                                            if (titleBar != null) {
                                                i = R.id.tv_me_id;
                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView4 != null) {
                                                    i = R.id.tv_me_name;
                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView5 != null) {
                                                        i = R.id.tv_me_xuehao;
                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView6 != null) {
                                                            return new ActivityHamamBinding((RelativeLayout) view, pwdEditText, imageView, imageView2, simpleDraweeView, linearLayout, relativeLayout, textView, textView2, textView3, titleBar, textView4, textView5, textView6);
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
