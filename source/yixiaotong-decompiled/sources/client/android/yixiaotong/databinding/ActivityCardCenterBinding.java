package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.view.load.MultiStateView;
import client.android.yixiaotong.view.load.PullRefreshLayout;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityCardCenterBinding implements ViewBinding {
    public final ImageView ivBuycard;
    public final ListView lvCard;
    public final MultiStateView multiStateView;
    private final RelativeLayout rootView;
    public final RecyclerView rvApp;
    public final PullRefreshLayout swipeRefreshLayout;
    public final TitleBar titleBar;

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    private ActivityCardCenterBinding(RelativeLayout relativeLayout, ImageView imageView, ListView listView, MultiStateView multiStateView, RecyclerView recyclerView, PullRefreshLayout pullRefreshLayout, TitleBar titleBar) {
        this.rootView = relativeLayout;
        this.ivBuycard = imageView;
        this.lvCard = listView;
        this.multiStateView = multiStateView;
        this.rvApp = recyclerView;
        this.swipeRefreshLayout = pullRefreshLayout;
        this.titleBar = titleBar;
    }

    public static ActivityCardCenterBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityCardCenterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_card_center, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityCardCenterBinding bind(View view) {
        int i = R.id.iv_buycard;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.lv_card;
            ListView listView = (ListView) ViewBindings.findChildViewById(view, i);
            if (listView != null) {
                i = R.id.multiStateView;
                MultiStateView multiStateView = (MultiStateView) ViewBindings.findChildViewById(view, i);
                if (multiStateView != null) {
                    i = R.id.rv_app;
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                    if (recyclerView != null) {
                        i = R.id.swipeRefreshLayout;
                        PullRefreshLayout pullRefreshLayout = (PullRefreshLayout) ViewBindings.findChildViewById(view, i);
                        if (pullRefreshLayout != null) {
                            i = R.id.titleBar;
                            TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                            if (titleBar != null) {
                                return new ActivityCardCenterBinding((RelativeLayout) view, imageView, listView, multiStateView, recyclerView, pullRefreshLayout, titleBar);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
