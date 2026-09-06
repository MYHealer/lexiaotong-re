package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.PickerView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ListviewLayoutBinding implements ViewBinding {
    public final PickerView list;
    private final LinearLayout rootView;
    public final TextView tvCanle;
    public final TextView tvPostive;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ListviewLayoutBinding(LinearLayout linearLayout, PickerView pickerView, TextView textView, TextView textView2) {
        this.rootView = linearLayout;
        this.list = pickerView;
        this.tvCanle = textView;
        this.tvPostive = textView2;
    }

    public static ListviewLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ListviewLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.listview_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ListviewLayoutBinding bind(View view) {
        int i = R.id.list;
        PickerView pickerView = (PickerView) ViewBindings.findChildViewById(view, i);
        if (pickerView != null) {
            i = R.id.tv_canle;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.tv_postive;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    return new ListviewLayoutBinding((LinearLayout) view, pickerView, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
