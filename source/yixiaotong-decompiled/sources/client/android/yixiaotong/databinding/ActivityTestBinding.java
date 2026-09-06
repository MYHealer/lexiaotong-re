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
import client.android.yixiaotong.ui.widget.TitleBar;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityTestBinding implements ViewBinding {
    public final TextView id1;
    public final TextView id2;
    public final ImageView imgSex;
    public final SimpleDraweeView ivMeIcon;
    public final LinearLayout lin;
    public final LinearLayout llMeInfo;
    public final ImageView qrcode;
    private final RelativeLayout rootView;
    public final TitleBar titlebar;
    public final TextView tvChakanrecord;
    public final TextView tvMeId;
    public final TextView tvMeName;
    public final TextView tvMeXuehao;

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    private ActivityTestBinding(RelativeLayout relativeLayout, TextView textView, TextView textView2, ImageView imageView, SimpleDraweeView simpleDraweeView, LinearLayout linearLayout, LinearLayout linearLayout2, ImageView imageView2, TitleBar titleBar, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        this.rootView = relativeLayout;
        this.id1 = textView;
        this.id2 = textView2;
        this.imgSex = imageView;
        this.ivMeIcon = simpleDraweeView;
        this.lin = linearLayout;
        this.llMeInfo = linearLayout2;
        this.qrcode = imageView2;
        this.titlebar = titleBar;
        this.tvChakanrecord = textView3;
        this.tvMeId = textView4;
        this.tvMeName = textView5;
        this.tvMeXuehao = textView6;
    }

    public static ActivityTestBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityTestBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_test, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityTestBinding bind(View view) {
        int i = R.id.id1;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.id2;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = R.id.img_sex;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = R.id.iv_me_icon;
                    SimpleDraweeView simpleDraweeView = (SimpleDraweeView) ViewBindings.findChildViewById(view, i);
                    if (simpleDraweeView != null) {
                        i = R.id.lin;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                        if (linearLayout != null) {
                            i = R.id.ll_me_info;
                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                            if (linearLayout2 != null) {
                                i = R.id.qrcode;
                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                                if (imageView2 != null) {
                                    i = R.id.titlebar;
                                    TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                                    if (titleBar != null) {
                                        i = R.id.tv_chakanrecord;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView3 != null) {
                                            i = R.id.tv_me_id;
                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView4 != null) {
                                                i = R.id.tv_me_name;
                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView5 != null) {
                                                    i = R.id.tv_me_xuehao;
                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView6 != null) {
                                                        return new ActivityTestBinding((RelativeLayout) view, textView, textView2, imageView, simpleDraweeView, linearLayout, linearLayout2, imageView2, titleBar, textView3, textView4, textView5, textView6);
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
