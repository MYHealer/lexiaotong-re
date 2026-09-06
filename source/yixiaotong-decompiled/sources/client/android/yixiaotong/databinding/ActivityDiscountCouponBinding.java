package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
public final class ActivityDiscountCouponBinding implements ViewBinding {
    public final ImageView ivTimedrop;
    public final ListView lvRecord;
    public final MultiStateView multiStateView;
    public final RelativeLayout relOutofdate;
    public final RelativeLayout relTime;
    public final RelativeLayout relUse;
    public final RelativeLayout relUsed;
    private final LinearLayout rootView;
    public final PullRefreshLayout swipeRefreshLayout;
    public final TitleBar titleBar;
    public final TextView tvOutofdate;
    public final TextView tvTime;
    public final TextView tvUsedtext;
    public final TextView tvUsetext;
    public final View vLine;
    public final View vLineuse;
    public final View vLineused;
    public final View vOutofdate;
    public final View vPopbg;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityDiscountCouponBinding(LinearLayout linearLayout, ImageView imageView, ListView listView, MultiStateView multiStateView, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, PullRefreshLayout pullRefreshLayout, TitleBar titleBar, TextView textView, TextView textView2, TextView textView3, TextView textView4, View view, View view2, View view3, View view4, View view5) {
        this.rootView = linearLayout;
        this.ivTimedrop = imageView;
        this.lvRecord = listView;
        this.multiStateView = multiStateView;
        this.relOutofdate = relativeLayout;
        this.relTime = relativeLayout2;
        this.relUse = relativeLayout3;
        this.relUsed = relativeLayout4;
        this.swipeRefreshLayout = pullRefreshLayout;
        this.titleBar = titleBar;
        this.tvOutofdate = textView;
        this.tvTime = textView2;
        this.tvUsedtext = textView3;
        this.tvUsetext = textView4;
        this.vLine = view;
        this.vLineuse = view2;
        this.vLineused = view3;
        this.vOutofdate = view4;
        this.vPopbg = view5;
    }

    public static ActivityDiscountCouponBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityDiscountCouponBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_discount_coupon, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityDiscountCouponBinding bind(View view) {
        View viewFindChildViewById;
        View viewFindChildViewById2;
        View viewFindChildViewById3;
        View viewFindChildViewById4;
        View viewFindChildViewById5;
        int i = R.id.iv_timedrop;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.lv_record;
            ListView listView = (ListView) ViewBindings.findChildViewById(view, i);
            if (listView != null) {
                i = R.id.multiStateView;
                MultiStateView multiStateView = (MultiStateView) ViewBindings.findChildViewById(view, i);
                if (multiStateView != null) {
                    i = R.id.rel_outofdate;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                    if (relativeLayout != null) {
                        i = R.id.rel_time;
                        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                        if (relativeLayout2 != null) {
                            i = R.id.rel_use;
                            RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                            if (relativeLayout3 != null) {
                                i = R.id.rel_used;
                                RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                if (relativeLayout4 != null) {
                                    i = R.id.swipeRefreshLayout;
                                    PullRefreshLayout pullRefreshLayout = (PullRefreshLayout) ViewBindings.findChildViewById(view, i);
                                    if (pullRefreshLayout != null) {
                                        i = R.id.titleBar;
                                        TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                                        if (titleBar != null) {
                                            i = R.id.tv_outofdate;
                                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView != null) {
                                                i = R.id.tv_time;
                                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView2 != null) {
                                                    i = R.id.tv_usedtext;
                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView3 != null) {
                                                        i = R.id.tv_usetext;
                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView4 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.v_line))) != null && (viewFindChildViewById2 = ViewBindings.findChildViewById(view, (i = R.id.v_lineuse))) != null && (viewFindChildViewById3 = ViewBindings.findChildViewById(view, (i = R.id.v_lineused))) != null && (viewFindChildViewById4 = ViewBindings.findChildViewById(view, (i = R.id.v_outofdate))) != null && (viewFindChildViewById5 = ViewBindings.findChildViewById(view, (i = R.id.v_popbg))) != null) {
                                                            return new ActivityDiscountCouponBinding((LinearLayout) view, imageView, listView, multiStateView, relativeLayout, relativeLayout2, relativeLayout3, relativeLayout4, pullRefreshLayout, titleBar, textView, textView2, textView3, textView4, viewFindChildViewById, viewFindChildViewById2, viewFindChildViewById3, viewFindChildViewById4, viewFindChildViewById5);
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
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
