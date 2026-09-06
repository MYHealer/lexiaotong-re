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
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityPayOrderBinding implements ViewBinding {
    public final SimpleDraweeView icon;
    public final TextView money;
    public final TextView name;
    public final Button pay;
    private final LinearLayout rootView;
    public final TextView temperature;
    public final TextView test;
    public final TextView text;
    public final TextView time;
    public final TitleBar titlebar;
    public final TextView tvTemperature;
    public final TextView usemoney;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityPayOrderBinding(LinearLayout linearLayout, SimpleDraweeView simpleDraweeView, TextView textView, TextView textView2, Button button, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TitleBar titleBar, TextView textView7, TextView textView8) {
        this.rootView = linearLayout;
        this.icon = simpleDraweeView;
        this.money = textView;
        this.name = textView2;
        this.pay = button;
        this.temperature = textView3;
        this.test = textView4;
        this.text = textView5;
        this.time = textView6;
        this.titlebar = titleBar;
        this.tvTemperature = textView7;
        this.usemoney = textView8;
    }

    public static ActivityPayOrderBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityPayOrderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_pay_order, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityPayOrderBinding bind(View view) {
        int i = R.id.icon;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) ViewBindings.findChildViewById(view, i);
        if (simpleDraweeView != null) {
            i = R.id.money;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.name;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = R.id.pay;
                    Button button = (Button) ViewBindings.findChildViewById(view, i);
                    if (button != null) {
                        i = R.id.temperature;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView3 != null) {
                            i = R.id.test;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView4 != null) {
                                i = R.id.text;
                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView5 != null) {
                                    i = R.id.time;
                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView6 != null) {
                                        i = R.id.titlebar;
                                        TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                                        if (titleBar != null) {
                                            i = R.id.tv_temperature;
                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView7 != null) {
                                                i = R.id.usemoney;
                                                TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView8 != null) {
                                                    return new ActivityPayOrderBinding((LinearLayout) view, simpleDraweeView, textView, textView2, button, textView3, textView4, textView5, textView6, titleBar, textView7, textView8);
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
