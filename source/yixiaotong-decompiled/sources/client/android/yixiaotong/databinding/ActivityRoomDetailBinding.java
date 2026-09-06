package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityRoomDetailBinding implements ViewBinding {
    public final TextView deviceno;
    public final LinearLayout linUserno;
    private final LinearLayout rootView;
    public final TitleBar titlebar;
    public final TextView tvRoomaddress;
    public final TextView tvUserno;
    public final TextView tvUsernotext;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityRoomDetailBinding(LinearLayout linearLayout, TextView textView, LinearLayout linearLayout2, TitleBar titleBar, TextView textView2, TextView textView3, TextView textView4) {
        this.rootView = linearLayout;
        this.deviceno = textView;
        this.linUserno = linearLayout2;
        this.titlebar = titleBar;
        this.tvRoomaddress = textView2;
        this.tvUserno = textView3;
        this.tvUsernotext = textView4;
    }

    public static ActivityRoomDetailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityRoomDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_room_detail, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityRoomDetailBinding bind(View view) {
        int i = R.id.deviceno;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.lin_userno;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                i = R.id.titlebar;
                TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                if (titleBar != null) {
                    i = R.id.tv_roomaddress;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = R.id.tv_userno;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView3 != null) {
                            i = R.id.tv_usernotext;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView4 != null) {
                                return new ActivityRoomDetailBinding((LinearLayout) view, textView, linearLayout, titleBar, textView2, textView3, textView4);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
