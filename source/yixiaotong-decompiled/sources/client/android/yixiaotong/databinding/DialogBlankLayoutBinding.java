package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class DialogBlankLayoutBinding implements ViewBinding {
    public final TextView img;
    public final View line;
    private final RelativeLayout rootView;
    public final EditText tvContent1;
    public final Button tvPositive;

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    private DialogBlankLayoutBinding(RelativeLayout relativeLayout, TextView textView, View view, EditText editText, Button button) {
        this.rootView = relativeLayout;
        this.img = textView;
        this.line = view;
        this.tvContent1 = editText;
        this.tvPositive = button;
    }

    public static DialogBlankLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogBlankLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_blank_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DialogBlankLayoutBinding bind(View view) {
        View viewFindChildViewById;
        int i = R.id.img;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.line))) != null) {
            i = R.id.tv_content1;
            EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
            if (editText != null) {
                i = R.id.tv_positive;
                Button button = (Button) ViewBindings.findChildViewById(view, i);
                if (button != null) {
                    return new DialogBlankLayoutBinding((RelativeLayout) view, textView, viewFindChildViewById, editText, button);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
