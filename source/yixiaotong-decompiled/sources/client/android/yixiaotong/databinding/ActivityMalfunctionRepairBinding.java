package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.view.load.MultiStateView;
import client.android.yixiaotong.view.load.PullRefreshLayout;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityMalfunctionRepairBinding implements ViewBinding {
    public final Button btnBaoxiu;
    public final ListView lvRepair;
    public final MultiStateView multiStateView;
    private final RelativeLayout rootView;
    public final PullRefreshLayout swipeRefreshLayout;
    public final TitleBar titlebar;

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    private ActivityMalfunctionRepairBinding(RelativeLayout relativeLayout, Button button, ListView listView, MultiStateView multiStateView, PullRefreshLayout pullRefreshLayout, TitleBar titleBar) {
        this.rootView = relativeLayout;
        this.btnBaoxiu = button;
        this.lvRepair = listView;
        this.multiStateView = multiStateView;
        this.swipeRefreshLayout = pullRefreshLayout;
        this.titlebar = titleBar;
    }

    public static ActivityMalfunctionRepairBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityMalfunctionRepairBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_malfunction_repair, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityMalfunctionRepairBinding bind(View view) {
        int i = R.id.btn_baoxiu;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.lv_repair;
            ListView listView = (ListView) ViewBindings.findChildViewById(view, i);
            if (listView != null) {
                i = R.id.multiStateView;
                MultiStateView multiStateView = (MultiStateView) ViewBindings.findChildViewById(view, i);
                if (multiStateView != null) {
                    i = R.id.swipeRefreshLayout;
                    PullRefreshLayout pullRefreshLayout = (PullRefreshLayout) ViewBindings.findChildViewById(view, i);
                    if (pullRefreshLayout != null) {
                        i = R.id.titlebar;
                        TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                        if (titleBar != null) {
                            return new ActivityMalfunctionRepairBinding((RelativeLayout) view, button, listView, multiStateView, pullRefreshLayout, titleBar);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
