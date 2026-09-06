package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class DialogBindschoolBinding implements ViewBinding {
    public final Button btnConfirm;
    public final EditText etStudentno;
    public final ImageView ivDw;
    public final ImageView ivXuehao;
    private final RelativeLayout rootView;
    public final TextView tvAddress;
    public final TextView tvSchoolname;
    public final View vLine;

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    private DialogBindschoolBinding(RelativeLayout relativeLayout, Button button, EditText editText, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2, View view) {
        this.rootView = relativeLayout;
        this.btnConfirm = button;
        this.etStudentno = editText;
        this.ivDw = imageView;
        this.ivXuehao = imageView2;
        this.tvAddress = textView;
        this.tvSchoolname = textView2;
        this.vLine = view;
    }

    public static DialogBindschoolBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogBindschoolBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_bindschool, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DialogBindschoolBinding bind(View view) {
        View viewFindChildViewById;
        int i = R.id.btn_confirm;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.et_studentno;
            EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
            if (editText != null) {
                i = R.id.iv_dw;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = R.id.iv_xuehao;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView2 != null) {
                        i = R.id.tv_address;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView != null) {
                            i = R.id.tv_schoolname;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView2 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.v_line))) != null) {
                                return new DialogBindschoolBinding((RelativeLayout) view, button, editText, imageView, imageView2, textView, textView2, viewFindChildViewById);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
