package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityAuthenticationSuccessBinding implements ViewBinding {
    public final Button btnFinish;
    public final RelativeLayout rel1;
    public final RelativeLayout rel2;
    private final RelativeLayout rootView;
    public final TitleBar titlebar;
    public final TextView tvAddress;
    public final TextView tvAddresstext;
    public final TextView tvIdentityId;
    public final TextView tvIdentityidtext;
    public final TextView tvName;
    public final TextView tvNametext;
    public final TextView tvSex;
    public final TextView tvSextext;
    public final TextView tvTitle;

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    private ActivityAuthenticationSuccessBinding(RelativeLayout relativeLayout, Button button, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, TitleBar titleBar, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9) {
        this.rootView = relativeLayout;
        this.btnFinish = button;
        this.rel1 = relativeLayout2;
        this.rel2 = relativeLayout3;
        this.titlebar = titleBar;
        this.tvAddress = textView;
        this.tvAddresstext = textView2;
        this.tvIdentityId = textView3;
        this.tvIdentityidtext = textView4;
        this.tvName = textView5;
        this.tvNametext = textView6;
        this.tvSex = textView7;
        this.tvSextext = textView8;
        this.tvTitle = textView9;
    }

    public static ActivityAuthenticationSuccessBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityAuthenticationSuccessBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_authentication_success, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityAuthenticationSuccessBinding bind(View view) {
        int i = R.id.btn_finish;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.rel1;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
            if (relativeLayout != null) {
                i = R.id.rel2;
                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                if (relativeLayout2 != null) {
                    i = R.id.titlebar;
                    TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                    if (titleBar != null) {
                        i = R.id.tv_address;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView != null) {
                            i = R.id.tv_addresstext;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView2 != null) {
                                i = R.id.tv_identityId;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView3 != null) {
                                    i = R.id.tv_identityidtext;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView4 != null) {
                                        i = R.id.tv_name;
                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView5 != null) {
                                            i = R.id.tv_nametext;
                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView6 != null) {
                                                i = R.id.tv_sex;
                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView7 != null) {
                                                    i = R.id.tv_sextext;
                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView8 != null) {
                                                        i = R.id.tv_title;
                                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView9 != null) {
                                                            return new ActivityAuthenticationSuccessBinding((RelativeLayout) view, button, relativeLayout, relativeLayout2, titleBar, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9);
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
