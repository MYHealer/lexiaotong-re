package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class DrinkwaterInputmoneyDialogBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final EditText tvInputmoney;
    public final TextView tvMoneyfive;
    public final TextView tvMoneyone;
    public final TextView tvMoneythree;
    public final TextView tvMoneytwo;
    public final TextView tvPositive;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private DrinkwaterInputmoneyDialogBinding(LinearLayout linearLayout, EditText editText, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.rootView = linearLayout;
        this.tvInputmoney = editText;
        this.tvMoneyfive = textView;
        this.tvMoneyone = textView2;
        this.tvMoneythree = textView3;
        this.tvMoneytwo = textView4;
        this.tvPositive = textView5;
    }

    public static DrinkwaterInputmoneyDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DrinkwaterInputmoneyDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.drinkwater_inputmoney_dialog, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DrinkwaterInputmoneyDialogBinding bind(View view) {
        int i = R.id.tv_inputmoney;
        EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
        if (editText != null) {
            i = R.id.tv_moneyfive;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.tv_moneyone;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = R.id.tv_moneythree;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView3 != null) {
                        i = R.id.tv_moneytwo;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView4 != null) {
                            i = R.id.tv_positive;
                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView5 != null) {
                                return new DrinkwaterInputmoneyDialogBinding((LinearLayout) view, editText, textView, textView2, textView3, textView4, textView5);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
