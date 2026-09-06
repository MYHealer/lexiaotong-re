package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class DialogPaymentSelectorBinding implements ViewBinding {
    public final Button btnCancel;
    public final Button btnConfirm;
    public final ListView lvPaymentMethods;
    private final LinearLayout rootView;
    public final TextView tvTitle;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private DialogPaymentSelectorBinding(LinearLayout linearLayout, Button button, Button button2, ListView listView, TextView textView) {
        this.rootView = linearLayout;
        this.btnCancel = button;
        this.btnConfirm = button2;
        this.lvPaymentMethods = listView;
        this.tvTitle = textView;
    }

    public static DialogPaymentSelectorBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogPaymentSelectorBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_payment_selector, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DialogPaymentSelectorBinding bind(View view) {
        int i = R.id.btn_cancel;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.btn_confirm;
            Button button2 = (Button) ViewBindings.findChildViewById(view, i);
            if (button2 != null) {
                i = R.id.lv_payment_methods;
                ListView listView = (ListView) ViewBindings.findChildViewById(view, i);
                if (listView != null) {
                    i = R.id.tv_title;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        return new DialogPaymentSelectorBinding((LinearLayout) view, button, button2, listView, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
