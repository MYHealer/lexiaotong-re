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
public final class ActivityV4RepairRecordBinding implements ViewBinding {
    public final ImageView ivAdd;
    public final ListView lvRecord;
    public final MultiStateView multiStateView;
    public final RelativeLayout relAdd;
    public final RelativeLayout relDelete;
    public final RelativeLayout relFinish;
    public final RelativeLayout relUnfinish;
    private final LinearLayout rootView;
    public final PullRefreshLayout swipeRefreshLayout;
    public final TitleBar titleBar;
    public final TextView tvDeletetext;
    public final TextView tvFinishtext;
    public final TextView tvUnfinishtext;
    public final View vLinedelect;
    public final View vLineleft;
    public final View vLineright;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityV4RepairRecordBinding(LinearLayout linearLayout, ImageView imageView, ListView listView, MultiStateView multiStateView, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, PullRefreshLayout pullRefreshLayout, TitleBar titleBar, TextView textView, TextView textView2, TextView textView3, View view, View view2, View view3) {
        this.rootView = linearLayout;
        this.ivAdd = imageView;
        this.lvRecord = listView;
        this.multiStateView = multiStateView;
        this.relAdd = relativeLayout;
        this.relDelete = relativeLayout2;
        this.relFinish = relativeLayout3;
        this.relUnfinish = relativeLayout4;
        this.swipeRefreshLayout = pullRefreshLayout;
        this.titleBar = titleBar;
        this.tvDeletetext = textView;
        this.tvFinishtext = textView2;
        this.tvUnfinishtext = textView3;
        this.vLinedelect = view;
        this.vLineleft = view2;
        this.vLineright = view3;
    }

    public static ActivityV4RepairRecordBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityV4RepairRecordBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_v4_repair_record, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityV4RepairRecordBinding bind(View view) {
        View viewFindChildViewById;
        View viewFindChildViewById2;
        View viewFindChildViewById3;
        int i = R.id.iv_add;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.lv_record;
            ListView listView = (ListView) ViewBindings.findChildViewById(view, i);
            if (listView != null) {
                i = R.id.multiStateView;
                MultiStateView multiStateView = (MultiStateView) ViewBindings.findChildViewById(view, i);
                if (multiStateView != null) {
                    i = R.id.rel_add;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                    if (relativeLayout != null) {
                        i = R.id.rel_delete;
                        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                        if (relativeLayout2 != null) {
                            i = R.id.rel_finish;
                            RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                            if (relativeLayout3 != null) {
                                i = R.id.rel_unfinish;
                                RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                if (relativeLayout4 != null) {
                                    i = R.id.swipeRefreshLayout;
                                    PullRefreshLayout pullRefreshLayout = (PullRefreshLayout) ViewBindings.findChildViewById(view, i);
                                    if (pullRefreshLayout != null) {
                                        i = R.id.titleBar;
                                        TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                                        if (titleBar != null) {
                                            i = R.id.tv_deletetext;
                                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView != null) {
                                                i = R.id.tv_finishtext;
                                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView2 != null) {
                                                    i = R.id.tv_unfinishtext;
                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView3 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.v_linedelect))) != null && (viewFindChildViewById2 = ViewBindings.findChildViewById(view, (i = R.id.v_lineleft))) != null && (viewFindChildViewById3 = ViewBindings.findChildViewById(view, (i = R.id.v_lineright))) != null) {
                                                        return new ActivityV4RepairRecordBinding((LinearLayout) view, imageView, listView, multiStateView, relativeLayout, relativeLayout2, relativeLayout3, relativeLayout4, pullRefreshLayout, titleBar, textView, textView2, textView3, viewFindChildViewById, viewFindChildViewById2, viewFindChildViewById3);
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
