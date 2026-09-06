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
public final class DialogAdvTipBinding implements ViewBinding {
    public final TextView btnKnow;
    public final LinearLayout linRoot;
    private final LinearLayout rootView;
    public final TextView tvTitle;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private DialogAdvTipBinding(LinearLayout linearLayout, TextView textView, LinearLayout linearLayout2, TextView textView2) {
        this.rootView = linearLayout;
        this.btnKnow = textView;
        this.linRoot = linearLayout2;
        this.tvTitle = textView2;
    }

    public static DialogAdvTipBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogAdvTipBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_adv_tip, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DialogAdvTipBinding bind(View view) {
        int i = R.id.btn_know;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            int i2 = R.id.tv_title;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i2);
            if (textView2 != null) {
                return new DialogAdvTipBinding(linearLayout, textView, linearLayout, textView2);
            }
            i = i2;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
