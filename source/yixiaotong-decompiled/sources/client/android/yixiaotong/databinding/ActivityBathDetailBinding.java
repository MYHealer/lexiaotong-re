package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.ui.widget.WrapGridView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityBathDetailBinding implements ViewBinding {
    public final Button btnClose;
    public final TextView connecttiptext;
    public final FrameLayout flContainer;
    public final WrapGridView gvAdv;
    public final ImageView ivCircle;
    public final ImageView ivConnected;
    public final LinearLayout linTip;
    public final RelativeLayout relClose;
    public final RelativeLayout relConnect;
    public final RelativeLayout rlContainer;
    private final RelativeLayout rootView;
    public final TitleBar titleBar;
    public final TextView tvAdvname;
    public final TextView tvBathtiptext;
    public final TextView tvConnectedtext;
    public final TextView tvConnecttext;
    public final TextView tvMac;
    public final TextView tvTime;
    public final TextView tvTip;

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    private ActivityBathDetailBinding(RelativeLayout relativeLayout, Button button, TextView textView, FrameLayout frameLayout, WrapGridView wrapGridView, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, TitleBar titleBar, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8) {
        this.rootView = relativeLayout;
        this.btnClose = button;
        this.connecttiptext = textView;
        this.flContainer = frameLayout;
        this.gvAdv = wrapGridView;
        this.ivCircle = imageView;
        this.ivConnected = imageView2;
        this.linTip = linearLayout;
        this.relClose = relativeLayout2;
        this.relConnect = relativeLayout3;
        this.rlContainer = relativeLayout4;
        this.titleBar = titleBar;
        this.tvAdvname = textView2;
        this.tvBathtiptext = textView3;
        this.tvConnectedtext = textView4;
        this.tvConnecttext = textView5;
        this.tvMac = textView6;
        this.tvTime = textView7;
        this.tvTip = textView8;
    }

    public static ActivityBathDetailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityBathDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_bath_detail, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityBathDetailBinding bind(View view) {
        int i = R.id.btn_close;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.connecttiptext;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.flContainer;
                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                if (frameLayout != null) {
                    i = R.id.gv_adv;
                    WrapGridView wrapGridView = (WrapGridView) ViewBindings.findChildViewById(view, i);
                    if (wrapGridView != null) {
                        i = R.id.iv_circle;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView != null) {
                            i = R.id.iv_connected;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView2 != null) {
                                i = R.id.lin_tip;
                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                if (linearLayout != null) {
                                    i = R.id.rel_close;
                                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                    if (relativeLayout != null) {
                                        i = R.id.rel_connect;
                                        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                        if (relativeLayout2 != null) {
                                            i = R.id.rlContainer;
                                            RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                            if (relativeLayout3 != null) {
                                                i = R.id.titleBar;
                                                TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                                                if (titleBar != null) {
                                                    i = R.id.tv_advname;
                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView2 != null) {
                                                        i = R.id.tv_bathtiptext;
                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView3 != null) {
                                                            i = R.id.tv_connectedtext;
                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView4 != null) {
                                                                i = R.id.tv_connecttext;
                                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView5 != null) {
                                                                    i = R.id.tv_mac;
                                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView6 != null) {
                                                                        i = R.id.tv_time;
                                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView7 != null) {
                                                                            i = R.id.tv_tip;
                                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                            if (textView8 != null) {
                                                                                return new ActivityBathDetailBinding((RelativeLayout) view, button, textView, frameLayout, wrapGridView, imageView, imageView2, linearLayout, relativeLayout, relativeLayout2, relativeLayout3, titleBar, textView2, textView3, textView4, textView5, textView6, textView7, textView8);
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
