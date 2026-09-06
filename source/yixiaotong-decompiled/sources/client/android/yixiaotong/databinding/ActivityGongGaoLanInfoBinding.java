package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.view.load.MultiStateView;
import client.android.yixiaotong.view.load.PullRefreshLayout;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityGongGaoLanInfoBinding implements ViewBinding {
    public final LinearLayout lin;
    public final MultiStateView multiStateView;
    private final LinearLayout rootView;
    public final RecyclerView rvGgl;
    public final PullRefreshLayout swipeRefreshLayout;
    public final TitleBar titlebar;
    public final TextView tvBluetooth;
    public final TextView tvFoot;
    public final TextView tvQw;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityGongGaoLanInfoBinding(LinearLayout linearLayout, LinearLayout linearLayout2, MultiStateView multiStateView, RecyclerView recyclerView, PullRefreshLayout pullRefreshLayout, TitleBar titleBar, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = linearLayout;
        this.lin = linearLayout2;
        this.multiStateView = multiStateView;
        this.rvGgl = recyclerView;
        this.swipeRefreshLayout = pullRefreshLayout;
        this.titlebar = titleBar;
        this.tvBluetooth = textView;
        this.tvFoot = textView2;
        this.tvQw = textView3;
    }

    public static ActivityGongGaoLanInfoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityGongGaoLanInfoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_gong_gao_lan_info, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityGongGaoLanInfoBinding bind(View view) {
        int i = R.id.lin;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = R.id.multiStateView;
            MultiStateView multiStateView = (MultiStateView) ViewBindings.findChildViewById(view, i);
            if (multiStateView != null) {
                i = R.id.rv_ggl;
                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                if (recyclerView != null) {
                    i = R.id.swipeRefreshLayout;
                    PullRefreshLayout pullRefreshLayout = (PullRefreshLayout) ViewBindings.findChildViewById(view, i);
                    if (pullRefreshLayout != null) {
                        i = R.id.titlebar;
                        TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                        if (titleBar != null) {
                            i = R.id.tv_bluetooth;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView != null) {
                                i = R.id.tv_foot;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView2 != null) {
                                    i = R.id.tv_qw;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView3 != null) {
                                        return new ActivityGongGaoLanInfoBinding((LinearLayout) view, linearLayout, multiStateView, recyclerView, pullRefreshLayout, titleBar, textView, textView2, textView3);
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
