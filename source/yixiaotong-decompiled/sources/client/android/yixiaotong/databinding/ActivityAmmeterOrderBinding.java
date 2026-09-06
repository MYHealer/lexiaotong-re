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
import client.android.yixiaotong.view.load.MultiStateView;
import client.android.yixiaotong.view.load.PullRefreshLayout;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityAmmeterOrderBinding implements ViewBinding {
    public final TextView btnButie;
    public final TextView btnChongzhi;
    public final ListView lvCardrecord;
    public final MultiStateView multiStateView;
    private final LinearLayout rootView;
    public final PullRefreshLayout swipeRefreshLayout;
    public final TitleBar vTitleBar;
    public final View view1;
    public final View view2;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityAmmeterOrderBinding(LinearLayout linearLayout, TextView textView, TextView textView2, ListView listView, MultiStateView multiStateView, PullRefreshLayout pullRefreshLayout, TitleBar titleBar, View view, View view2) {
        this.rootView = linearLayout;
        this.btnButie = textView;
        this.btnChongzhi = textView2;
        this.lvCardrecord = listView;
        this.multiStateView = multiStateView;
        this.swipeRefreshLayout = pullRefreshLayout;
        this.vTitleBar = titleBar;
        this.view1 = view;
        this.view2 = view2;
    }

    public static ActivityAmmeterOrderBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityAmmeterOrderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_ammeter_order, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityAmmeterOrderBinding bind(View view) {
        View viewFindChildViewById;
        View viewFindChildViewById2;
        int i = R.id.btn_butie;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.btn_chongzhi;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = R.id.lv_cardrecord;
                ListView listView = (ListView) ViewBindings.findChildViewById(view, i);
                if (listView != null) {
                    i = R.id.multiStateView;
                    MultiStateView multiStateView = (MultiStateView) ViewBindings.findChildViewById(view, i);
                    if (multiStateView != null) {
                        i = R.id.swipeRefreshLayout;
                        PullRefreshLayout pullRefreshLayout = (PullRefreshLayout) ViewBindings.findChildViewById(view, i);
                        if (pullRefreshLayout != null) {
                            i = R.id.v_titleBar;
                            TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                            if (titleBar != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.view1))) != null && (viewFindChildViewById2 = ViewBindings.findChildViewById(view, (i = R.id.view2))) != null) {
                                return new ActivityAmmeterOrderBinding((LinearLayout) view, textView, textView2, listView, multiStateView, pullRefreshLayout, titleBar, viewFindChildViewById, viewFindChildViewById2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
