package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.view.load.MultiStateView;
import client.android.yixiaotong.view.load.PullRefreshLayout;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityAnnouncementInfoBinding implements ViewBinding {
    public final MultiStateView multiStateView;
    private final LinearLayout rootView;
    public final RecyclerView rvGgl;
    public final PullRefreshLayout swipeRefreshLayout;
    public final TitleBar titlebar;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityAnnouncementInfoBinding(LinearLayout linearLayout, MultiStateView multiStateView, RecyclerView recyclerView, PullRefreshLayout pullRefreshLayout, TitleBar titleBar) {
        this.rootView = linearLayout;
        this.multiStateView = multiStateView;
        this.rvGgl = recyclerView;
        this.swipeRefreshLayout = pullRefreshLayout;
        this.titlebar = titleBar;
    }

    public static ActivityAnnouncementInfoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityAnnouncementInfoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_announcement_info, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityAnnouncementInfoBinding bind(View view) {
        int i = R.id.multiStateView;
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
                        return new ActivityAnnouncementInfoBinding((LinearLayout) view, multiStateView, recyclerView, pullRefreshLayout, titleBar);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
