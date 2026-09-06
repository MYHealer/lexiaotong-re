package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityAboutBinding implements ViewBinding {
    public final RelativeLayout agreement;
    public final RelativeLayout agreement1;
    public final RelativeLayout email;
    public final RelativeLayout phone;
    public final RelativeLayout relApp;
    public final RelativeLayout relCancelaccount;
    public final RelativeLayout relContactus;
    private final RelativeLayout rootView;
    public final TitleBar titleBar;
    public final TextView tvBeian;
    public final TextView tvVersion;
    public final RelativeLayout website;
    public final RelativeLayout website1;

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    private ActivityAboutBinding(RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, RelativeLayout relativeLayout5, RelativeLayout relativeLayout6, RelativeLayout relativeLayout7, RelativeLayout relativeLayout8, TitleBar titleBar, TextView textView, TextView textView2, RelativeLayout relativeLayout9, RelativeLayout relativeLayout10) {
        this.rootView = relativeLayout;
        this.agreement = relativeLayout2;
        this.agreement1 = relativeLayout3;
        this.email = relativeLayout4;
        this.phone = relativeLayout5;
        this.relApp = relativeLayout6;
        this.relCancelaccount = relativeLayout7;
        this.relContactus = relativeLayout8;
        this.titleBar = titleBar;
        this.tvBeian = textView;
        this.tvVersion = textView2;
        this.website = relativeLayout9;
        this.website1 = relativeLayout10;
    }

    public static ActivityAboutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityAboutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_about, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityAboutBinding bind(View view) {
        int i = R.id.agreement;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
        if (relativeLayout != null) {
            i = R.id.agreement1;
            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
            if (relativeLayout2 != null) {
                i = R.id.email;
                RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                if (relativeLayout3 != null) {
                    i = R.id.phone;
                    RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                    if (relativeLayout4 != null) {
                        i = R.id.rel_app;
                        RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                        if (relativeLayout5 != null) {
                            i = R.id.rel_cancelaccount;
                            RelativeLayout relativeLayout6 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                            if (relativeLayout6 != null) {
                                i = R.id.rel_contactus;
                                RelativeLayout relativeLayout7 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                if (relativeLayout7 != null) {
                                    i = R.id.titleBar;
                                    TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                                    if (titleBar != null) {
                                        i = R.id.tv_beian;
                                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView != null) {
                                            i = R.id.tv_version;
                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView2 != null) {
                                                i = R.id.website;
                                                RelativeLayout relativeLayout8 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                if (relativeLayout8 != null) {
                                                    i = R.id.website1;
                                                    RelativeLayout relativeLayout9 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                    if (relativeLayout9 != null) {
                                                        return new ActivityAboutBinding((RelativeLayout) view, relativeLayout, relativeLayout2, relativeLayout3, relativeLayout4, relativeLayout5, relativeLayout6, relativeLayout7, titleBar, textView, textView2, relativeLayout8, relativeLayout9);
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
