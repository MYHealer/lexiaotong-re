package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.view.load.MultiStateView;
import client.android.yixiaotong.view.load.PullRefreshLayout;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityRepairDetailBinding implements ViewBinding {
    public final EditText etRevert;
    public final RelativeLayout llRevert;
    public final ListView lvRepair;
    public final MultiStateView multiStateView;
    private final RelativeLayout rootView;
    public final PullRefreshLayout swipeRefreshLayout;
    public final TitleBar titlebar;
    public final TextView tvSend;

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    private ActivityRepairDetailBinding(RelativeLayout relativeLayout, EditText editText, RelativeLayout relativeLayout2, ListView listView, MultiStateView multiStateView, PullRefreshLayout pullRefreshLayout, TitleBar titleBar, TextView textView) {
        this.rootView = relativeLayout;
        this.etRevert = editText;
        this.llRevert = relativeLayout2;
        this.lvRepair = listView;
        this.multiStateView = multiStateView;
        this.swipeRefreshLayout = pullRefreshLayout;
        this.titlebar = titleBar;
        this.tvSend = textView;
    }

    public static ActivityRepairDetailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityRepairDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_repair_detail, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityRepairDetailBinding bind(View view) {
        int i = R.id.et_revert;
        EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
        if (editText != null) {
            i = R.id.ll_revert;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
            if (relativeLayout != null) {
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
                                i = R.id.tv_send;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView != null) {
                                    return new ActivityRepairDetailBinding((RelativeLayout) view, editText, relativeLayout, listView, multiStateView, pullRefreshLayout, titleBar, textView);
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
