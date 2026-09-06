package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.view.load.PullRefreshLayout;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityElecMeterRechargeRecordBinding implements ViewBinding {
    public final ListView lvRecord;
    public final PullRefreshLayout pullrefreshlayout;
    private final LinearLayout rootView;
    public final TitleBar titlebar;
    public final TextView tvNodata;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityElecMeterRechargeRecordBinding(LinearLayout linearLayout, ListView listView, PullRefreshLayout pullRefreshLayout, TitleBar titleBar, TextView textView) {
        this.rootView = linearLayout;
        this.lvRecord = listView;
        this.pullrefreshlayout = pullRefreshLayout;
        this.titlebar = titleBar;
        this.tvNodata = textView;
    }

    public static ActivityElecMeterRechargeRecordBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityElecMeterRechargeRecordBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_elec_meter_recharge_record, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityElecMeterRechargeRecordBinding bind(View view) {
        int i = R.id.lv_record;
        ListView listView = (ListView) ViewBindings.findChildViewById(view, i);
        if (listView != null) {
            i = R.id.pullrefreshlayout;
            PullRefreshLayout pullRefreshLayout = (PullRefreshLayout) ViewBindings.findChildViewById(view, i);
            if (pullRefreshLayout != null) {
                i = R.id.titlebar;
                TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                if (titleBar != null) {
                    i = R.id.tv_nodata;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        return new ActivityElecMeterRechargeRecordBinding((LinearLayout) view, listView, pullRefreshLayout, titleBar, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
