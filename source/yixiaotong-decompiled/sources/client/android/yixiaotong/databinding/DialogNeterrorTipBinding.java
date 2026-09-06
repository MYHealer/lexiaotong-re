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
public final class DialogNeterrorTipBinding implements ViewBinding {
    public final LinearLayout lin;
    public final LinearLayout linMorehelp;
    private final RelativeLayout rootView;
    public final TextView tvContent;
    public final TextView tvContent2;
    public final Button tvPositive;
    public final TextView tvTitle;

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    private DialogNeterrorTipBinding(RelativeLayout relativeLayout, LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView, TextView textView2, Button button, TextView textView3) {
        this.rootView = relativeLayout;
        this.lin = linearLayout;
        this.linMorehelp = linearLayout2;
        this.tvContent = textView;
        this.tvContent2 = textView2;
        this.tvPositive = button;
        this.tvTitle = textView3;
    }

    public static DialogNeterrorTipBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogNeterrorTipBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_neterror_tip, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DialogNeterrorTipBinding bind(View view) {
        int i = R.id.lin;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = R.id.lin_morehelp;
            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout2 != null) {
                i = R.id.tv_content;
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
                                return new DialogNeterrorTipBinding((RelativeLayout) view, linearLayout, linearLayout2, textView, textView2, button, textView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
