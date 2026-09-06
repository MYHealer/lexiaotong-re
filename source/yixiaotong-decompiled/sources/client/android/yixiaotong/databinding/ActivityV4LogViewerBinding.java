package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityV4LogViewerBinding implements ViewBinding {
    public final LinearLayout llFilter;
    private final LinearLayout rootView;
    public final RecyclerView rvLogs;
    public final TextView tvAutoScroll;
    public final TextView tvClear;
    public final TextView tvClose;
    public final TextView tvFilterAll;
    public final TextView tvFilterD;
    public final TextView tvFilterE;
    public final TextView tvFilterI;
    public final TextView tvFilterV;
    public final TextView tvFilterW;
    public final TextView tvLogCount;
    public final TextView tvPause;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityV4LogViewerBinding(LinearLayout linearLayout, LinearLayout linearLayout2, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11) {
        this.rootView = linearLayout;
        this.llFilter = linearLayout2;
        this.rvLogs = recyclerView;
        this.tvAutoScroll = textView;
        this.tvClear = textView2;
        this.tvClose = textView3;
        this.tvFilterAll = textView4;
        this.tvFilterD = textView5;
        this.tvFilterE = textView6;
        this.tvFilterI = textView7;
        this.tvFilterV = textView8;
        this.tvFilterW = textView9;
        this.tvLogCount = textView10;
        this.tvPause = textView11;
    }

    public static ActivityV4LogViewerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityV4LogViewerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_v4_log_viewer, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityV4LogViewerBinding bind(View view) {
        int i = R.id.ll_filter;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = R.id.rv_logs;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
            if (recyclerView != null) {
                i = R.id.tv_auto_scroll;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.tv_clear;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = R.id.tv_close;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView3 != null) {
                            i = R.id.tv_filter_all;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView4 != null) {
                                i = R.id.tv_filter_d;
                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView5 != null) {
                                    i = R.id.tv_filter_e;
                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView6 != null) {
                                        i = R.id.tv_filter_i;
                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView7 != null) {
                                            i = R.id.tv_filter_v;
                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView8 != null) {
                                                i = R.id.tv_filter_w;
                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView9 != null) {
                                                    i = R.id.tv_log_count;
                                                    TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView10 != null) {
                                                        i = R.id.tv_pause;
                                                        TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView11 != null) {
                                                            return new ActivityV4LogViewerBinding((LinearLayout) view, linearLayout, recyclerView, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11);
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
