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
public final class ActivityRecordListBinding implements ViewBinding {
    public final ImageView img;
    public final ImageView img2;
    public final ListView lvRecord;
    public final MultiStateView multiStateView;
    public final RelativeLayout rel;
    public final RelativeLayout rel2;
    public final LinearLayout relAll;
    private final LinearLayout rootView;
    public final PullRefreshLayout swipeRefreshLayout;
    public final TitleBar titlebar;
    public final TextView tvAppname;
    public final TextView tvDate2;
    public final TextView tvQiehuan;
    public final TextView tvQiehuan2;
    public final View vView;
    public final View view;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityRecordListBinding(LinearLayout linearLayout, ImageView imageView, ImageView imageView2, ListView listView, MultiStateView multiStateView, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, LinearLayout linearLayout2, PullRefreshLayout pullRefreshLayout, TitleBar titleBar, TextView textView, TextView textView2, TextView textView3, TextView textView4, View view, View view2) {
        this.rootView = linearLayout;
        this.img = imageView;
        this.img2 = imageView2;
        this.lvRecord = listView;
        this.multiStateView = multiStateView;
        this.rel = relativeLayout;
        this.rel2 = relativeLayout2;
        this.relAll = linearLayout2;
        this.swipeRefreshLayout = pullRefreshLayout;
        this.titlebar = titleBar;
        this.tvAppname = textView;
        this.tvDate2 = textView2;
        this.tvQiehuan = textView3;
        this.tvQiehuan2 = textView4;
        this.vView = view;
        this.view = view2;
    }

    public static ActivityRecordListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityRecordListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_record_list, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityRecordListBinding bind(View view) {
        View viewFindChildViewById;
        View viewFindChildViewById2;
        int i = R.id.img;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.img2;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                i = R.id.lv_record;
                ListView listView = (ListView) ViewBindings.findChildViewById(view, i);
                if (listView != null) {
                    i = R.id.multiStateView;
                    MultiStateView multiStateView = (MultiStateView) ViewBindings.findChildViewById(view, i);
                    if (multiStateView != null) {
                        i = R.id.rel;
                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                        if (relativeLayout != null) {
                            i = R.id.rel2;
                            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                            if (relativeLayout2 != null) {
                                i = R.id.rel_all;
                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                if (linearLayout != null) {
                                    i = R.id.swipeRefreshLayout;
                                    PullRefreshLayout pullRefreshLayout = (PullRefreshLayout) ViewBindings.findChildViewById(view, i);
                                    if (pullRefreshLayout != null) {
                                        i = R.id.titlebar;
                                        TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                                        if (titleBar != null) {
                                            i = R.id.tv_appname;
                                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView != null) {
                                                i = R.id.tv_date2;
                                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView2 != null) {
                                                    i = R.id.tv_qiehuan;
                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView3 != null) {
                                                        i = R.id.tv_qiehuan2;
                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView4 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.v_view))) != null && (viewFindChildViewById2 = ViewBindings.findChildViewById(view, (i = R.id.view))) != null) {
                                                            return new ActivityRecordListBinding((LinearLayout) view, imageView, imageView2, listView, multiStateView, relativeLayout, relativeLayout2, linearLayout, pullRefreshLayout, titleBar, textView, textView2, textView3, textView4, viewFindChildViewById, viewFindChildViewById2);
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
