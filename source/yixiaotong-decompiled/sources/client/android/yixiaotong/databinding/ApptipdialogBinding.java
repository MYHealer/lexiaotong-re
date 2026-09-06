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
public final class ApptipdialogBinding implements ViewBinding {
    public final TextView img;
    public final View line;
    private final RelativeLayout rootView;
    public final TextView tvContent1;
    public final Button tvPositive;
    public final Button tvWait;

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    private ApptipdialogBinding(RelativeLayout relativeLayout, TextView textView, View view, TextView textView2, Button button, Button button2) {
        this.rootView = relativeLayout;
        this.img = textView;
        this.line = view;
        this.tvContent1 = textView2;
        this.tvPositive = button;
        this.tvWait = button2;
    }

    public static ApptipdialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ApptipdialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.apptipdialog, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ApptipdialogBinding bind(View view) {
        View viewFindChildViewById;
        int i = R.id.img;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.line))) != null) {
            i = R.id.tv_content1;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = R.id.tv_positive;
                Button button = (Button) ViewBindings.findChildViewById(view, i);
                if (button != null) {
                    i = R.id.tv_wait;
                    Button button2 = (Button) ViewBindings.findChildViewById(view, i);
                    if (button2 != null) {
                        return new ApptipdialogBinding((RelativeLayout) view, textView, viewFindChildViewById, textView2, button, button2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
