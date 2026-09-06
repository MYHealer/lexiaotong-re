package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class DialogSetidentityidBinding implements ViewBinding {
    public final View line;
    private final RelativeLayout rootView;
    public final TextView tvContent1;
    public final TextView tvContent2;
    public final Button tvPositive;
    public final TextView tvTitle;
    public final Button tvWait;

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    private DialogSetidentityidBinding(RelativeLayout relativeLayout, View view, TextView textView, TextView textView2, Button button, TextView textView3, Button button2) {
        this.rootView = relativeLayout;
        this.line = view;
        this.tvContent1 = textView;
        this.tvContent2 = textView2;
        this.tvPositive = button;
        this.tvTitle = textView3;
        this.tvWait = button2;
    }

    public static DialogSetidentityidBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogSetidentityidBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_setidentityid, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DialogSetidentityidBinding bind(View view) {
        int i = R.id.line;
        View viewFindChildViewById = ViewBindings.findChildViewById(view, i);
        if (viewFindChildViewById != null) {
            i = R.id.tv_content1;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.tv_content2;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = R.id.tv_positive;
                    Button button = (Button) ViewBindings.findChildViewById(view, i);
                    if (button != null) {
                        i = R.id.tv_title;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView3 != null) {
                            i = R.id.tv_wait;
                            Button button2 = (Button) ViewBindings.findChildViewById(view, i);
                            if (button2 != null) {
                                return new DialogSetidentityidBinding((RelativeLayout) view, viewFindChildViewById, textView, textView2, button, textView3, button2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
