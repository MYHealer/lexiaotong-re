package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.ui.widget.WrapListView;
import client.android.yixiaotong.view.load.PullRefreshLayout;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivitySwllCardControlBinding implements ViewBinding {
    public final Button btnBuycard;
    public final Button btnTakecard;
    public final ImageView imgBill;
    public final LinearLayout linBottom;
    public final WrapListView listview;
    private final RelativeLayout rootView;
    public final ScrollView scrollview;
    public final PullRefreshLayout swipeRefreshLayout;
    public final TitleBar titlebar;
    public final TextView tvMoney;
    public final TextView tvUnit;

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    private ActivitySwllCardControlBinding(RelativeLayout relativeLayout, Button button, Button button2, ImageView imageView, LinearLayout linearLayout, WrapListView wrapListView, ScrollView scrollView, PullRefreshLayout pullRefreshLayout, TitleBar titleBar, TextView textView, TextView textView2) {
        this.rootView = relativeLayout;
        this.btnBuycard = button;
        this.btnTakecard = button2;
        this.imgBill = imageView;
        this.linBottom = linearLayout;
        this.listview = wrapListView;
        this.scrollview = scrollView;
        this.swipeRefreshLayout = pullRefreshLayout;
        this.titlebar = titleBar;
        this.tvMoney = textView;
        this.tvUnit = textView2;
    }

    public static ActivitySwllCardControlBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivitySwllCardControlBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_swll_card_control, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivitySwllCardControlBinding bind(View view) {
        int i = R.id.btn_buycard;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.btn_takecard;
            Button button2 = (Button) ViewBindings.findChildViewById(view, i);
            if (button2 != null) {
                i = R.id.img_bill;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = R.id.lin_bottom;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                    if (linearLayout != null) {
                        i = R.id.listview;
                        WrapListView wrapListView = (WrapListView) ViewBindings.findChildViewById(view, i);
                        if (wrapListView != null) {
                            i = R.id.scrollview;
                            ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(view, i);
                            if (scrollView != null) {
                                i = R.id.swipeRefreshLayout;
                                PullRefreshLayout pullRefreshLayout = (PullRefreshLayout) ViewBindings.findChildViewById(view, i);
                                if (pullRefreshLayout != null) {
                                    i = R.id.titlebar;
                                    TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                                    if (titleBar != null) {
                                        i = R.id.tv_money;
                                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView != null) {
                                            i = R.id.tv_unit;
                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView2 != null) {
                                                return new ActivitySwllCardControlBinding((RelativeLayout) view, button, button2, imageView, linearLayout, wrapListView, scrollView, pullRefreshLayout, titleBar, textView, textView2);
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
