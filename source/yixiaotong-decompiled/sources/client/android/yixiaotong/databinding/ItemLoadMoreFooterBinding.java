package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ItemLoadMoreFooterBinding implements ViewBinding {
    public final LinearLayout llLoadMore;
    public final TextView loadmore;
    public final ProgressBar progressBar;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ItemLoadMoreFooterBinding(LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView, ProgressBar progressBar) {
        this.rootView = linearLayout;
        this.llLoadMore = linearLayout2;
        this.loadmore = textView;
        this.progressBar = progressBar;
    }

    public static ItemLoadMoreFooterBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemLoadMoreFooterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_load_more_footer, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemLoadMoreFooterBinding bind(View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        int i = R.id.loadmore;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.progress_bar;
            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
            if (progressBar != null) {
                return new ItemLoadMoreFooterBinding(linearLayout, linearLayout, textView, progressBar);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
