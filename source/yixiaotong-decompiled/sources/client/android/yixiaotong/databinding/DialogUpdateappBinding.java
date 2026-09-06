package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class DialogUpdateappBinding implements ViewBinding {
    public final Button btnPositive;
    public final Button btnWait;
    public final LinearLayout lin;
    public final View line;
    public final View line1;
    private final RelativeLayout rootView;
    public final TextView tvContent;
    public final TextView tvPositive;
    public final TextView tvTitle;

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    private DialogUpdateappBinding(RelativeLayout relativeLayout, Button button, Button button2, LinearLayout linearLayout, View view, View view2, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = relativeLayout;
        this.btnPositive = button;
        this.btnWait = button2;
        this.lin = linearLayout;
        this.line = view;
        this.line1 = view2;
        this.tvContent = textView;
        this.tvPositive = textView2;
        this.tvTitle = textView3;
    }

    public static DialogUpdateappBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogUpdateappBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_updateapp, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DialogUpdateappBinding bind(View view) {
        View viewFindChildViewById;
        View viewFindChildViewById2;
        int i = R.id.btn_positive;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.btn_wait;
            Button button2 = (Button) ViewBindings.findChildViewById(view, i);
            if (button2 != null) {
                i = R.id.lin;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                if (linearLayout != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.line))) != null && (viewFindChildViewById2 = ViewBindings.findChildViewById(view, (i = R.id.line1))) != null) {
                    i = R.id.tv_content;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        i = R.id.tv_positive;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            i = R.id.tv_title;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView3 != null) {
                                return new DialogUpdateappBinding((RelativeLayout) view, button, button2, linearLayout, viewFindChildViewById, viewFindChildViewById2, textView, textView2, textView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
