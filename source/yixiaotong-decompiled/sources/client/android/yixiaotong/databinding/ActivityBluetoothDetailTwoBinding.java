package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityBluetoothDetailTwoBinding implements ViewBinding {
    public final TextView address;
    public final Button controller;
    public final FrameLayout flContainer;
    public final TextView name;
    private final RelativeLayout rootView;
    public final TextView tip;
    public final TitleBar titleBar;

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    private ActivityBluetoothDetailTwoBinding(RelativeLayout relativeLayout, TextView textView, Button button, FrameLayout frameLayout, TextView textView2, TextView textView3, TitleBar titleBar) {
        this.rootView = relativeLayout;
        this.address = textView;
        this.controller = button;
        this.flContainer = frameLayout;
        this.name = textView2;
        this.tip = textView3;
        this.titleBar = titleBar;
    }

    public static ActivityBluetoothDetailTwoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityBluetoothDetailTwoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_bluetooth_detail_two, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityBluetoothDetailTwoBinding bind(View view) {
        int i = R.id.address;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.controller;
            Button button = (Button) ViewBindings.findChildViewById(view, i);
            if (button != null) {
                i = R.id.flContainer;
                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                if (frameLayout != null) {
                    i = R.id.name;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = R.id.tip;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView3 != null) {
                            i = R.id.titleBar;
                            TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                            if (titleBar != null) {
                                return new ActivityBluetoothDetailTwoBinding((RelativeLayout) view, textView, button, frameLayout, textView2, textView3, titleBar);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
