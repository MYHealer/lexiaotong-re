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

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityWashSelectOperate2Binding implements ViewBinding {
    public final ListView lvList;
    public final TextView no;
    private final LinearLayout rootView;
    public final TextView state;
    public final TextView tvState;
    public final TextView tvWashNo;
    public final TitleBar vTitleBar;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityWashSelectOperate2Binding(LinearLayout linearLayout, ListView listView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TitleBar titleBar) {
        this.rootView = linearLayout;
        this.lvList = listView;
        this.no = textView;
        this.state = textView2;
        this.tvState = textView3;
        this.tvWashNo = textView4;
        this.vTitleBar = titleBar;
    }

    public static ActivityWashSelectOperate2Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityWashSelectOperate2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_wash_select_operate2, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityWashSelectOperate2Binding bind(View view) {
        int i = R.id.lv_list;
        ListView listView = (ListView) ViewBindings.findChildViewById(view, i);
        if (listView != null) {
            i = R.id.no;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.state;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = R.id.tv_state;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView3 != null) {
                        i = R.id.tv_wash_no;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView4 != null) {
                            i = R.id.v_titleBar;
                            TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                            if (titleBar != null) {
                                return new ActivityWashSelectOperate2Binding((LinearLayout) view, listView, textView, textView2, textView3, textView4, titleBar);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
