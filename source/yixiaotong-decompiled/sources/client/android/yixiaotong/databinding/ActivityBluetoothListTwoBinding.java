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
public final class ActivityBluetoothListTwoBinding implements ViewBinding {
    public final MultiStateView multiStateView;
    public final ListView recyclerView;
    private final LinearLayout rootView;
    public final PullRefreshLayout swipeRefreshLayout;
    public final TitleBar titleBar;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityBluetoothListTwoBinding(LinearLayout linearLayout, MultiStateView multiStateView, ListView listView, PullRefreshLayout pullRefreshLayout, TitleBar titleBar) {
        this.rootView = linearLayout;
        this.multiStateView = multiStateView;
        this.recyclerView = listView;
        this.swipeRefreshLayout = pullRefreshLayout;
        this.titleBar = titleBar;
    }

    public static ActivityBluetoothListTwoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityBluetoothListTwoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_bluetooth_list_two, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityBluetoothListTwoBinding bind(View view) {
        int i = R.id.multiStateView;
        MultiStateView multiStateView = (MultiStateView) ViewBindings.findChildViewById(view, i);
        if (multiStateView != null) {
            i = R.id.recycler_view;
            ListView listView = (ListView) ViewBindings.findChildViewById(view, i);
            if (listView != null) {
                i = R.id.swipeRefreshLayout;
                PullRefreshLayout pullRefreshLayout = (PullRefreshLayout) ViewBindings.findChildViewById(view, i);
                if (pullRefreshLayout != null) {
                    i = R.id.titleBar;
                    TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                    if (titleBar != null) {
                        return new ActivityBluetoothListTwoBinding((LinearLayout) view, multiStateView, listView, pullRefreshLayout, titleBar);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
