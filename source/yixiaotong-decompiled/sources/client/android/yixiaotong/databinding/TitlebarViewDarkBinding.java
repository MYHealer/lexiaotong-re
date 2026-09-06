package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class TitlebarViewDarkBinding implements ViewBinding {
    public final TextView leftTextView;
    public final RelativeLayout relTitle;
    public final TextView rightTextView;
    private final RelativeLayout rootView;
    public final TextView titleTextView;
    public final TextView titleTextView2;

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    private TitlebarViewDarkBinding(RelativeLayout relativeLayout, TextView textView, RelativeLayout relativeLayout2, TextView textView2, TextView textView3, TextView textView4) {
        this.rootView = relativeLayout;
        this.leftTextView = textView;
        this.relTitle = relativeLayout2;
        this.rightTextView = textView2;
        this.titleTextView = textView3;
        this.titleTextView2 = textView4;
    }

    public static TitlebarViewDarkBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TitlebarViewDarkBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.titlebar_view_dark, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static TitlebarViewDarkBinding bind(View view) {
        int i = R.id.leftTextView;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            RelativeLayout relativeLayout = (RelativeLayout) view;
            i = R.id.rightTextView;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = R.id.titleTextView;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView3 != null) {
                    i = R.id.titleTextView2;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView4 != null) {
                        return new TitlebarViewDarkBinding(relativeLayout, textView, relativeLayout, textView2, textView3, textView4);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
