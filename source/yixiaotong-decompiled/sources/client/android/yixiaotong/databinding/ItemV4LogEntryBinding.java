package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ItemV4LogEntryBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final TextView tvContent;
    public final TextView tvIndex;
    public final TextView tvTime;
    public final View vLevelDot;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ItemV4LogEntryBinding(LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, View view) {
        this.rootView = linearLayout;
        this.tvContent = textView;
        this.tvIndex = textView2;
        this.tvTime = textView3;
        this.vLevelDot = view;
    }

    public static ItemV4LogEntryBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemV4LogEntryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_v4_log_entry, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemV4LogEntryBinding bind(View view) {
        View viewFindChildViewById;
        int i = R.id.tv_content;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.tv_index;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = R.id.tv_time;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView3 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.v_level_dot))) != null) {
                    return new ItemV4LogEntryBinding((LinearLayout) view, textView, textView2, textView3, viewFindChildViewById);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
