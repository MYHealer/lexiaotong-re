package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
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
public final class ActivityPrepaymentRedPackageActivityBinding implements ViewBinding {
    public final ListView lvRecord;
    public final MultiStateView multiStateView;
    public final RelativeLayout relOutofdate;
    public final RelativeLayout relUse;
    public final RelativeLayout relUsed;
    private final LinearLayout rootView;
    public final PullRefreshLayout swipeRefreshLayout;
    public final TitleBar titleBar;
    public final TextView tvOutofdate;
    public final TextView tvUsedtext;
    public final TextView tvUsetext;
    public final View vLineuse;
    public final View vLineused;
    public final View vOutofdate;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityPrepaymentRedPackageActivityBinding(LinearLayout linearLayout, ListView listView, MultiStateView multiStateView, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, PullRefreshLayout pullRefreshLayout, TitleBar titleBar, TextView textView, TextView textView2, TextView textView3, View view, View view2, View view3) {
        this.rootView = linearLayout;
        this.lvRecord = listView;
        this.multiStateView = multiStateView;
        this.relOutofdate = relativeLayout;
        this.relUse = relativeLayout2;
        this.relUsed = relativeLayout3;
        this.swipeRefreshLayout = pullRefreshLayout;
        this.titleBar = titleBar;
        this.tvOutofdate = textView;
        this.tvUsedtext = textView2;
        this.tvUsetext = textView3;
        this.vLineuse = view;
        this.vLineused = view2;
        this.vOutofdate = view3;
    }

    public static ActivityPrepaymentRedPackageActivityBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityPrepaymentRedPackageActivityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_prepayment_red_package_activity, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityPrepaymentRedPackageActivityBinding bind(View view) {
        View viewFindChildViewById;
        View viewFindChildViewById2;
        View viewFindChildViewById3;
        int i = R.id.lv_record;
        ListView listView = (ListView) ViewBindings.findChildViewById(view, i);
        if (listView != null) {
            i = R.id.multiStateView;
            MultiStateView multiStateView = (MultiStateView) ViewBindings.findChildViewById(view, i);
            if (multiStateView != null) {
                i = R.id.rel_outofdate;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                if (relativeLayout != null) {
                    i = R.id.rel_use;
                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                    if (relativeLayout2 != null) {
                        i = R.id.rel_used;
                        RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                        if (relativeLayout3 != null) {
                            i = R.id.swipeRefreshLayout;
                            PullRefreshLayout pullRefreshLayout = (PullRefreshLayout) ViewBindings.findChildViewById(view, i);
                            if (pullRefreshLayout != null) {
                                i = R.id.titleBar;
                                TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                                if (titleBar != null) {
                                    i = R.id.tv_outofdate;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView != null) {
                                        i = R.id.tv_usedtext;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView2 != null) {
                                            i = R.id.tv_usetext;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView3 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.v_lineuse))) != null && (viewFindChildViewById2 = ViewBindings.findChildViewById(view, (i = R.id.v_lineused))) != null && (viewFindChildViewById3 = ViewBindings.findChildViewById(view, (i = R.id.v_outofdate))) != null) {
                                                return new ActivityPrepaymentRedPackageActivityBinding((LinearLayout) view, listView, multiStateView, relativeLayout, relativeLayout2, relativeLayout3, pullRefreshLayout, titleBar, textView, textView2, textView3, viewFindChildViewById, viewFindChildViewById2, viewFindChildViewById3);
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
