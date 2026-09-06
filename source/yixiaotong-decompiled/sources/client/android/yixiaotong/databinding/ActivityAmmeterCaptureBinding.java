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
public final class ActivityAmmeterCaptureBinding implements ViewBinding {
    public final Button btnInputComplet;
    public final RelativeLayout captureContainer;
    public final RelativeLayout captureCropView;
    public final ImageView captureMaskBottom;
    public final ImageView captureMaskLeft;
    public final ImageView captureMaskRight;
    public final ImageView captureMaskTop;
    public final FrameLayout capturePreview;
    public final Button captureRestartScan;
    public final ImageView captureScanLine;
    public final TextView captureScanResult;
    public final EditText etInputdata1;
    public final View line;
    public final LinearLayout rel;
    public final RelativeLayout relInput;
    private final RelativeLayout rootView;
    public final TextView text;
    public final TitleBar titleBar;
    public final TextView tvLength;

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    private ActivityAmmeterCaptureBinding(RelativeLayout relativeLayout, Button button, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, FrameLayout frameLayout, Button button2, ImageView imageView5, TextView textView, EditText editText, View view, LinearLayout linearLayout, RelativeLayout relativeLayout4, TextView textView2, TitleBar titleBar, TextView textView3) {
        this.rootView = relativeLayout;
        this.btnInputComplet = button;
        this.captureContainer = relativeLayout2;
        this.captureCropView = relativeLayout3;
        this.captureMaskBottom = imageView;
        this.captureMaskLeft = imageView2;
        this.captureMaskRight = imageView3;
        this.captureMaskTop = imageView4;
        this.capturePreview = frameLayout;
        this.captureRestartScan = button2;
        this.captureScanLine = imageView5;
        this.captureScanResult = textView;
        this.etInputdata1 = editText;
        this.line = view;
        this.rel = linearLayout;
        this.relInput = relativeLayout4;
        this.text = textView2;
        this.titleBar = titleBar;
        this.tvLength = textView3;
    }

    public static ActivityAmmeterCaptureBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityAmmeterCaptureBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_ammeter_capture, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityAmmeterCaptureBinding bind(View view) {
        View viewFindChildViewById;
        int i = R.id.btn_inputComplet;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.capture_container;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
            if (relativeLayout != null) {
                i = R.id.capture_crop_view;
                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                if (relativeLayout2 != null) {
                    i = R.id.capture_mask_bottom;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView != null) {
                        i = R.id.capture_mask_left;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView2 != null) {
                            i = R.id.capture_mask_right;
                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView3 != null) {
                                i = R.id.capture_mask_top;
                                ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                                if (imageView4 != null) {
                                    i = R.id.capture_preview;
                                    FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                                    if (frameLayout != null) {
                                        i = R.id.capture_restart_scan;
                                        Button button2 = (Button) ViewBindings.findChildViewById(view, i);
                                        if (button2 != null) {
                                            i = R.id.capture_scan_line;
                                            ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i);
                                            if (imageView5 != null) {
                                                i = R.id.capture_scan_result;
                                                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView != null) {
                                                    i = R.id.et_inputdata1;
                                                    EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
                                                    if (editText != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.line))) != null) {
                                                        i = R.id.rel;
                                                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                        if (linearLayout != null) {
                                                            i = R.id.rel_input;
                                                            RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                            if (relativeLayout3 != null) {
                                                                i = R.id.text;
                                                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView2 != null) {
                                                                    i = R.id.titleBar;
                                                                    TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                                                                    if (titleBar != null) {
                                                                        i = R.id.tv_length;
                                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView3 != null) {
                                                                            return new ActivityAmmeterCaptureBinding((RelativeLayout) view, button, relativeLayout, relativeLayout2, imageView, imageView2, imageView3, imageView4, frameLayout, button2, imageView5, textView, editText, viewFindChildViewById, linearLayout, relativeLayout3, textView2, titleBar, textView3);
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
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
