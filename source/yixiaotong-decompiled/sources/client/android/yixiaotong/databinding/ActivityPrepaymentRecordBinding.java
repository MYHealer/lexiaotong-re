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
public final class ActivityPrepaymentRecordBinding implements ViewBinding {
    public final ListView lvRecord;
    public final MultiStateView multiStateView;
    public final RelativeLayout relButie;
    public final RelativeLayout relRecharge;
    public final RelativeLayout relRefund;
    private final LinearLayout rootView;
    public final PullRefreshLayout swipeRefreshLayout;
    public final TitleBar titleBar;
    public final TextView tvButietext;
    public final TextView tvRechargetext;
    public final TextView tvRefundtext;
    public final View vLinebutie;
    public final View vLinerechange;
    public final View vLinerefund;
    public final View vPopbg;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityPrepaymentRecordBinding(LinearLayout linearLayout, ListView listView, MultiStateView multiStateView, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, PullRefreshLayout pullRefreshLayout, TitleBar titleBar, TextView textView, TextView textView2, TextView textView3, View view, View view2, View view3, View view4) {
        this.rootView = linearLayout;
        this.lvRecord = listView;
        this.multiStateView = multiStateView;
        this.relButie = relativeLayout;
        this.relRecharge = relativeLayout2;
        this.relRefund = relativeLayout3;
        this.swipeRefreshLayout = pullRefreshLayout;
        this.titleBar = titleBar;
        this.tvButietext = textView;
        this.tvRechargetext = textView2;
        this.tvRefundtext = textView3;
        this.vLinebutie = view;
        this.vLinerechange = view2;
        this.vLinerefund = view3;
        this.vPopbg = view4;
    }

    public static ActivityPrepaymentRecordBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityPrepaymentRecordBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_prepayment_record, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityPrepaymentRecordBinding bind(View view) {
        View viewFindChildViewById;
        View viewFindChildViewById2;
        View viewFindChildViewById3;
        View viewFindChildViewById4;
        int i = R.id.lv_record;
        ListView listView = (ListView) ViewBindings.findChildViewById(view, i);
        if (listView != null) {
            i = R.id.multiStateView;
            MultiStateView multiStateView = (MultiStateView) ViewBindings.findChildViewById(view, i);
            if (multiStateView != null) {
                i = R.id.rel_butie;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                if (relativeLayout != null) {
                    i = R.id.rel_recharge;
                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                    if (relativeLayout2 != null) {
                        i = R.id.rel_refund;
                        RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                        if (relativeLayout3 != null) {
                            i = R.id.swipeRefreshLayout;
                            PullRefreshLayout pullRefreshLayout = (PullRefreshLayout) ViewBindings.findChildViewById(view, i);
                            if (pullRefreshLayout != null) {
                                i = R.id.titleBar;
                                TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                                if (titleBar != null) {
                                    i = R.id.tv_butietext;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView != null) {
                                        i = R.id.tv_rechargetext;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView2 != null) {
                                            i = R.id.tv_refundtext;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView3 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.v_linebutie))) != null && (viewFindChildViewById2 = ViewBindings.findChildViewById(view, (i = R.id.v_linerechange))) != null && (viewFindChildViewById3 = ViewBindings.findChildViewById(view, (i = R.id.v_linerefund))) != null && (viewFindChildViewById4 = ViewBindings.findChildViewById(view, (i = R.id.v_popbg))) != null) {
                                                return new ActivityPrepaymentRecordBinding((LinearLayout) view, listView, multiStateView, relativeLayout, relativeLayout2, relativeLayout3, pullRefreshLayout, titleBar, textView, textView2, textView3, viewFindChildViewById, viewFindChildViewById2, viewFindChildViewById3, viewFindChildViewById4);
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
