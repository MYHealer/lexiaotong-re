package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityPswdetailBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final TitleBar titlebar;
    public final TextView tvAccounttext;
    public final TextView tvPsw1;
    public final TextView tvPsw10;
    public final TextView tvPsw11;
    public final TextView tvPsw2;
    public final TextView tvPsw21;
    public final TextView tvPsw22;
    public final TextView tvPsw23;
    public final TextView tvPsw24;
    public final TextView tvPsw25;
    public final TextView tvPsw26;
    public final TextView tvPsw3;
    public final TextView tvPsw4;
    public final TextView tvPsw5;
    public final TextView tvPsw6;
    public final TextView tvPsw7;
    public final TextView tvPsw8;
    public final TextView tvPsw9;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityPswdetailBinding(LinearLayout linearLayout, TitleBar titleBar, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, TextView textView16, TextView textView17, TextView textView18) {
        this.rootView = linearLayout;
        this.titlebar = titleBar;
        this.tvAccounttext = textView;
        this.tvPsw1 = textView2;
        this.tvPsw10 = textView3;
        this.tvPsw11 = textView4;
        this.tvPsw2 = textView5;
        this.tvPsw21 = textView6;
        this.tvPsw22 = textView7;
        this.tvPsw23 = textView8;
        this.tvPsw24 = textView9;
        this.tvPsw25 = textView10;
        this.tvPsw26 = textView11;
        this.tvPsw3 = textView12;
        this.tvPsw4 = textView13;
        this.tvPsw5 = textView14;
        this.tvPsw6 = textView15;
        this.tvPsw7 = textView16;
        this.tvPsw8 = textView17;
        this.tvPsw9 = textView18;
    }

    public static ActivityPswdetailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityPswdetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_pswdetail, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityPswdetailBinding bind(View view) {
        int i = R.id.titlebar;
        TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
        if (titleBar != null) {
            i = R.id.tv_accounttext;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.tv_psw1;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = R.id.tv_psw10;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView3 != null) {
                        i = R.id.tv_psw11;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView4 != null) {
                            i = R.id.tv_psw2;
                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView5 != null) {
                                i = R.id.tv_psw21;
                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView6 != null) {
                                    i = R.id.tv_psw22;
                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView7 != null) {
                                        i = R.id.tv_psw23;
                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView8 != null) {
                                            i = R.id.tv_psw24;
                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView9 != null) {
                                                i = R.id.tv_psw25;
                                                TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView10 != null) {
                                                    i = R.id.tv_psw26;
                                                    TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView11 != null) {
                                                        i = R.id.tv_psw3;
                                                        TextView textView12 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView12 != null) {
                                                            i = R.id.tv_psw4;
                                                            TextView textView13 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView13 != null) {
                                                                i = R.id.tv_psw5;
                                                                TextView textView14 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView14 != null) {
                                                                    i = R.id.tv_psw6;
                                                                    TextView textView15 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView15 != null) {
                                                                        i = R.id.tv_psw7;
                                                                        TextView textView16 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView16 != null) {
                                                                            i = R.id.tv_psw8;
                                                                            TextView textView17 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                            if (textView17 != null) {
                                                                                i = R.id.tv_psw9;
                                                                                TextView textView18 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                if (textView18 != null) {
                                                                                    return new ActivityPswdetailBinding((LinearLayout) view, titleBar, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14, textView15, textView16, textView17, textView18);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
