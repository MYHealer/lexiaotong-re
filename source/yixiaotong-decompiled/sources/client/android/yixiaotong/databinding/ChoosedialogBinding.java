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
public final class ChoosedialogBinding implements ViewBinding {
    public final Button btnContent1;
    public final Button btnContent2;
    public final TextView img;
    public final View line;
    private final RelativeLayout rootView;
    public final TextView tvContent1;
    public final TextView tvContent2;
    public final Button tvPositive;
    public final Button tvWait;

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    private ChoosedialogBinding(RelativeLayout relativeLayout, Button button, Button button2, TextView textView, View view, TextView textView2, TextView textView3, Button button3, Button button4) {
        this.rootView = relativeLayout;
        this.btnContent1 = button;
        this.btnContent2 = button2;
        this.img = textView;
        this.line = view;
        this.tvContent1 = textView2;
        this.tvContent2 = textView3;
        this.tvPositive = button3;
        this.tvWait = button4;
    }

    public static ChoosedialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ChoosedialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.choosedialog, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ChoosedialogBinding bind(View view) {
        View viewFindChildViewById;
        int i = R.id.btn_content1;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.btn_content2;
            Button button2 = (Button) ViewBindings.findChildViewById(view, i);
            if (button2 != null) {
                i = R.id.img;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.line))) != null) {
                    i = R.id.tv_content1;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = R.id.tv_content2;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView3 != null) {
                            i = R.id.tv_positive;
                            Button button3 = (Button) ViewBindings.findChildViewById(view, i);
                            if (button3 != null) {
                                i = R.id.tv_wait;
                                Button button4 = (Button) ViewBindings.findChildViewById(view, i);
                                if (button4 != null) {
                                    return new ChoosedialogBinding((RelativeLayout) view, button, button2, textView, viewFindChildViewById, textView2, textView3, button3, button4);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
