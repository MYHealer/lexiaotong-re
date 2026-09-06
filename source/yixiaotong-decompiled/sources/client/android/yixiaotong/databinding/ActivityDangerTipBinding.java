package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityDangerTipBinding implements ViewBinding {
    public final Button btnManage;
    private final LinearLayout rootView;
    public final TitleBar titlebar;
    public final TextView tvAddress;
    public final TextView tvDay;
    public final TextView tvHour;
    public final TextView tvSec;
    public final TextView tvText1;
    public final TextView tvText11;
    public final TextView tvText12;
    public final TextView tvText13;
    public final TextView tvText2;
    public final TextView tvText3;
    public final TextView tvTextday;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityDangerTipBinding(LinearLayout linearLayout, Button button, TitleBar titleBar, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11) {
        this.rootView = linearLayout;
        this.btnManage = button;
        this.titlebar = titleBar;
        this.tvAddress = textView;
        this.tvDay = textView2;
        this.tvHour = textView3;
        this.tvSec = textView4;
        this.tvText1 = textView5;
        this.tvText11 = textView6;
        this.tvText12 = textView7;
        this.tvText13 = textView8;
        this.tvText2 = textView9;
        this.tvText3 = textView10;
        this.tvTextday = textView11;
    }

    public static ActivityDangerTipBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityDangerTipBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_danger_tip, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityDangerTipBinding bind(View view) {
        int i = R.id.btn_manage;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.titlebar;
            TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
            if (titleBar != null) {
                i = R.id.tv_address;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.tv_day;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = R.id.tv_hour;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView3 != null) {
                            i = R.id.tv_sec;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView4 != null) {
                                i = R.id.tv_text1;
                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView5 != null) {
                                    i = R.id.tv_text11;
                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView6 != null) {
                                        i = R.id.tv_text12;
                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView7 != null) {
                                            i = R.id.tv_text13;
                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView8 != null) {
                                                i = R.id.tv_text2;
                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView9 != null) {
                                                    i = R.id.tv_text3;
                                                    TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView10 != null) {
                                                        i = R.id.tv_textday;
                                                        TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView11 != null) {
                                                            return new ActivityDangerTipBinding((LinearLayout) view, button, titleBar, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11);
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
