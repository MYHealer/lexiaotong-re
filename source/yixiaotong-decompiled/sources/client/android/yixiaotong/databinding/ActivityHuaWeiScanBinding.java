package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityHuaWeiScanBinding implements ViewBinding {
    public final Button btnInputComplet;
    public final ImageView captureScanLine;
    public final EditText etInputdata1;
    public final ImageView flushBtn;
    public final View line;
    public final LinearLayout rel;
    public final RelativeLayout relInput;
    public final FrameLayout rim;
    private final FrameLayout rootView;
    public final ImageView scanArea;
    public final TextView text;
    public final TitleBar titleBar;
    public final TextView tvLength;
    public final TextView tvScantip;

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    private ActivityHuaWeiScanBinding(FrameLayout frameLayout, Button button, ImageView imageView, EditText editText, ImageView imageView2, View view, LinearLayout linearLayout, RelativeLayout relativeLayout, FrameLayout frameLayout2, ImageView imageView3, TextView textView, TitleBar titleBar, TextView textView2, TextView textView3) {
        this.rootView = frameLayout;
        this.btnInputComplet = button;
        this.captureScanLine = imageView;
        this.etInputdata1 = editText;
        this.flushBtn = imageView2;
        this.line = view;
        this.rel = linearLayout;
        this.relInput = relativeLayout;
        this.rim = frameLayout2;
        this.scanArea = imageView3;
        this.text = textView;
        this.titleBar = titleBar;
        this.tvLength = textView2;
        this.tvScantip = textView3;
    }

    public static ActivityHuaWeiScanBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityHuaWeiScanBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_hua_wei_scan, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityHuaWeiScanBinding bind(View view) {
        View viewFindChildViewById;
        int i = R.id.btn_inputComplet;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.capture_scan_line;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.et_inputdata1;
                EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
                if (editText != null) {
                    i = R.id.flush_btn;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView2 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.line))) != null) {
                        i = R.id.rel;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                        if (linearLayout != null) {
                            i = R.id.rel_input;
                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                            if (relativeLayout != null) {
                                i = R.id.rim;
                                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                                if (frameLayout != null) {
                                    i = R.id.scan_area;
                                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                    if (imageView3 != null) {
                                        i = R.id.text;
                                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView != null) {
                                            i = R.id.titleBar;
                                            TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                                            if (titleBar != null) {
                                                i = R.id.tv_length;
                                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView2 != null) {
                                                    i = R.id.tv_scantip;
                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView3 != null) {
                                                        return new ActivityHuaWeiScanBinding((FrameLayout) view, button, imageView, editText, imageView2, viewFindChildViewById, linearLayout, relativeLayout, frameLayout, imageView3, textView, titleBar, textView2, textView3);
                                                    }
                                                }
                                            }
                                        }
                                    }
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
