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
public final class DialogSetpswLayoutBinding implements ViewBinding {
    public final Button btnNext;
    public final EditText etPsw1;
    public final EditText etPsw2;
    private final RelativeLayout rootView;
    public final TextView tvTitle;
    public final View vLine;
    public final View vLine2;
    public final View vLine3;

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    private DialogSetpswLayoutBinding(RelativeLayout relativeLayout, Button button, EditText editText, EditText editText2, TextView textView, View view, View view2, View view3) {
        this.rootView = relativeLayout;
        this.btnNext = button;
        this.etPsw1 = editText;
        this.etPsw2 = editText2;
        this.tvTitle = textView;
        this.vLine = view;
        this.vLine2 = view2;
        this.vLine3 = view3;
    }

    public static DialogSetpswLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogSetpswLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_setpsw_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DialogSetpswLayoutBinding bind(View view) {
        View viewFindChildViewById;
        View viewFindChildViewById2;
        View viewFindChildViewById3;
        int i = R.id.btn_next;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.et_psw1;
            EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
            if (editText != null) {
                i = R.id.et_psw2;
                EditText editText2 = (EditText) ViewBindings.findChildViewById(view, i);
                if (editText2 != null) {
                    i = R.id.tv_title;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.v_line))) != null && (viewFindChildViewById2 = ViewBindings.findChildViewById(view, (i = R.id.v_line2))) != null && (viewFindChildViewById3 = ViewBindings.findChildViewById(view, (i = R.id.v_line3))) != null) {
                        return new DialogSetpswLayoutBinding((RelativeLayout) view, button, editText, editText2, textView, viewFindChildViewById, viewFindChildViewById2, viewFindChildViewById3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
