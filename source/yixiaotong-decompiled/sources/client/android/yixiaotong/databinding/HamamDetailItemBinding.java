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
public final class HamamDetailItemBinding implements ViewBinding {
    public final RelativeLayout lin;
    private final LinearLayout rootView;
    public final TextView tvAddress;
    public final TextView tvWeizhanyong;
    public final TextView tvYizhanyong;
    public final Button yuyuestate;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private HamamDetailItemBinding(LinearLayout linearLayout, RelativeLayout relativeLayout, TextView textView, TextView textView2, TextView textView3, Button button) {
        this.rootView = linearLayout;
        this.lin = relativeLayout;
        this.tvAddress = textView;
        this.tvWeizhanyong = textView2;
        this.tvYizhanyong = textView3;
        this.yuyuestate = button;
    }

    public static HamamDetailItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static HamamDetailItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.hamam_detail_item, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static HamamDetailItemBinding bind(View view) {
        int i = R.id.lin;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
        if (relativeLayout != null) {
            i = R.id.tv_address;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.tv_weizhanyong;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = R.id.tv_yizhanyong;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView3 != null) {
                        i = R.id.yuyuestate;
                        Button button = (Button) ViewBindings.findChildViewById(view, i);
                        if (button != null) {
                            return new HamamDetailItemBinding((LinearLayout) view, relativeLayout, textView, textView2, textView3, button);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
