package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivitySeeKeyBinding implements ViewBinding {
    public final TextView et1;
    public final TextView et10;
    public final TextView et2;
    public final TextView et5;
    public final TextView et6;
    public final TextView et7;
    public final TextView et8;
    public final TextView et9;
    public final LinearLayout lin;
    private final RelativeLayout rootView;
    public final TitleBar titlebar;
    public final TextView tvHelp;
    public final TextView tvText1;
    public final TextView tvText3;
    public final TextView tvText4;

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    private ActivitySeeKeyBinding(RelativeLayout relativeLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, LinearLayout linearLayout, TitleBar titleBar, TextView textView9, TextView textView10, TextView textView11, TextView textView12) {
        this.rootView = relativeLayout;
        this.et1 = textView;
        this.et10 = textView2;
        this.et2 = textView3;
        this.et5 = textView4;
        this.et6 = textView5;
        this.et7 = textView6;
        this.et8 = textView7;
        this.et9 = textView8;
        this.lin = linearLayout;
        this.titlebar = titleBar;
        this.tvHelp = textView9;
        this.tvText1 = textView10;
        this.tvText3 = textView11;
        this.tvText4 = textView12;
    }

    public static ActivitySeeKeyBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivitySeeKeyBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_see_key, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivitySeeKeyBinding bind(View view) {
        int i = R.id.et1;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.et10;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = R.id.et2;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView3 != null) {
                    i = R.id.et5;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView4 != null) {
                        i = R.id.et6;
                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView5 != null) {
                            i = R.id.et7;
                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView6 != null) {
                                i = R.id.et8;
                                TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView7 != null) {
                                    i = R.id.et9;
                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView8 != null) {
                                        i = R.id.lin;
                                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                        if (linearLayout != null) {
                                            i = R.id.titlebar;
                                            TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                                            if (titleBar != null) {
                                                i = R.id.tv_help;
                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView9 != null) {
                                                    i = R.id.tv_text1;
                                                    TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView10 != null) {
                                                        i = R.id.tv_text3;
                                                        TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView11 != null) {
                                                            i = R.id.tv_text4;
                                                            TextView textView12 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView12 != null) {
                                                                return new ActivitySeeKeyBinding((RelativeLayout) view, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, linearLayout, titleBar, textView9, textView10, textView11, textView12);
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
