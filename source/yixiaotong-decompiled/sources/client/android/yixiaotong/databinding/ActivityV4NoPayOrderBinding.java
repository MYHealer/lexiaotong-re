package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.ui.widget.WrapListView;
import client.android.yixiaotong.view.load.MultiStateView;
import client.android.yixiaotong.view.load.PullRefreshLayout;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityV4NoPayOrderBinding implements ViewBinding {
    public final Button btnPay;
    public final CheckBox cbSelectall;
    public final LinearLayout linPayway;
    public final WrapListView listview;
    public final ListView lvRecord;
    public final MultiStateView multiStateView;
    public final RelativeLayout relPay;
    private final RelativeLayout rootView;
    public final PullRefreshLayout swipeRefreshLayout;
    public final TextView textpayway;
    public final TitleBar titleBar;
    public final TextView tvTotalmoney;
    public final TextView tvTotaltext;

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    private ActivityV4NoPayOrderBinding(RelativeLayout relativeLayout, Button button, CheckBox checkBox, LinearLayout linearLayout, WrapListView wrapListView, ListView listView, MultiStateView multiStateView, RelativeLayout relativeLayout2, PullRefreshLayout pullRefreshLayout, TextView textView, TitleBar titleBar, TextView textView2, TextView textView3) {
        this.rootView = relativeLayout;
        this.btnPay = button;
        this.cbSelectall = checkBox;
        this.linPayway = linearLayout;
        this.listview = wrapListView;
        this.lvRecord = listView;
        this.multiStateView = multiStateView;
        this.relPay = relativeLayout2;
        this.swipeRefreshLayout = pullRefreshLayout;
        this.textpayway = textView;
        this.titleBar = titleBar;
        this.tvTotalmoney = textView2;
        this.tvTotaltext = textView3;
    }

    public static ActivityV4NoPayOrderBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityV4NoPayOrderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_v4_no_pay_order, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityV4NoPayOrderBinding bind(View view) {
        int i = R.id.btn_pay;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.cb_selectall;
            CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, i);
            if (checkBox != null) {
                i = R.id.lin_payway;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                if (linearLayout != null) {
                    i = R.id.listview;
                    WrapListView wrapListView = (WrapListView) ViewBindings.findChildViewById(view, i);
                    if (wrapListView != null) {
                        i = R.id.lv_record;
                        ListView listView = (ListView) ViewBindings.findChildViewById(view, i);
                        if (listView != null) {
                            i = R.id.multiStateView;
                            MultiStateView multiStateView = (MultiStateView) ViewBindings.findChildViewById(view, i);
                            if (multiStateView != null) {
                                i = R.id.rel_pay;
                                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                if (relativeLayout != null) {
                                    i = R.id.swipeRefreshLayout;
                                    PullRefreshLayout pullRefreshLayout = (PullRefreshLayout) ViewBindings.findChildViewById(view, i);
                                    if (pullRefreshLayout != null) {
                                        i = R.id.textpayway;
                                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView != null) {
                                            i = R.id.titleBar;
                                            TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                                            if (titleBar != null) {
                                                i = R.id.tv_totalmoney;
                                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView2 != null) {
                                                    i = R.id.tv_totaltext;
                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView3 != null) {
                                                        return new ActivityV4NoPayOrderBinding((RelativeLayout) view, button, checkBox, linearLayout, wrapListView, listView, multiStateView, relativeLayout, pullRefreshLayout, textView, titleBar, textView2, textView3);
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
