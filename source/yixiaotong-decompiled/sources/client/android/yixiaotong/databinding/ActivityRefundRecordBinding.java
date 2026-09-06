package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.view.load.MultiStateView;
import client.android.yixiaotong.view.load.PullRefreshLayout;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityRefundRecordBinding implements ViewBinding {
    public final PullRefreshLayout pullRefreshLayout;
    private final LinearLayout rootView;
    public final TitleBar titlebar;
    public final MultiStateView vLoadingview;
    public final ListView vLvMessage;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityRefundRecordBinding(LinearLayout linearLayout, PullRefreshLayout pullRefreshLayout, TitleBar titleBar, MultiStateView multiStateView, ListView listView) {
        this.rootView = linearLayout;
        this.pullRefreshLayout = pullRefreshLayout;
        this.titlebar = titleBar;
        this.vLoadingview = multiStateView;
        this.vLvMessage = listView;
    }

    public static ActivityRefundRecordBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityRefundRecordBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_refund_record, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityRefundRecordBinding bind(View view) {
        int i = R.id.pullRefreshLayout;
        PullRefreshLayout pullRefreshLayout = (PullRefreshLayout) ViewBindings.findChildViewById(view, i);
        if (pullRefreshLayout != null) {
            i = R.id.titlebar;
            TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
            if (titleBar != null) {
                i = R.id.v_loadingview;
                MultiStateView multiStateView = (MultiStateView) ViewBindings.findChildViewById(view, i);
                if (multiStateView != null) {
                    i = R.id.v_lv_message;
                    ListView listView = (ListView) ViewBindings.findChildViewById(view, i);
                    if (listView != null) {
                        return new ActivityRefundRecordBinding((LinearLayout) view, pullRefreshLayout, titleBar, multiStateView, listView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
