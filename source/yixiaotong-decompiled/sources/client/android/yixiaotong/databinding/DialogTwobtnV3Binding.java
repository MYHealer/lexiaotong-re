package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class DialogTwobtnV3Binding implements ViewBinding {
    public final ImageView imgCheckbox;
    public final View line;
    public final RelativeLayout relNoagaintip;
    private final RelativeLayout rootView;
    public final TextView tvContent;
    public final Button tvPositive;
    public final TextView tvTitle;
    public final Button tvWait;

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    private DialogTwobtnV3Binding(RelativeLayout relativeLayout, ImageView imageView, View view, RelativeLayout relativeLayout2, TextView textView, Button button, TextView textView2, Button button2) {
        this.rootView = relativeLayout;
        this.imgCheckbox = imageView;
        this.line = view;
        this.relNoagaintip = relativeLayout2;
        this.tvContent = textView;
        this.tvPositive = button;
        this.tvTitle = textView2;
        this.tvWait = button2;
    }

    public static DialogTwobtnV3Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogTwobtnV3Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_twobtn_v3, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DialogTwobtnV3Binding bind(View view) {
        View viewFindChildViewById;
        int i = R.id.img_checkbox;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.line))) != null) {
            i = R.id.rel_noagaintip;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
            if (relativeLayout != null) {
                i = R.id.tv_content;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.tv_positive;
                    Button button = (Button) ViewBindings.findChildViewById(view, i);
                    if (button != null) {
                        i = R.id.tv_title;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            i = R.id.tv_wait;
                            Button button2 = (Button) ViewBindings.findChildViewById(view, i);
                            if (button2 != null) {
                                return new DialogTwobtnV3Binding((RelativeLayout) view, imageView, viewFindChildViewById, relativeLayout, textView, button, textView2, button2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
