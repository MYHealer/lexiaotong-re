package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityDeviceInitWayBinding implements ViewBinding {
    public final ImageView img1;
    public final ImageView img2;
    public final ImageView img3;
    public final RelativeLayout relBle;
    public final RelativeLayout relSaoma;
    public final RelativeLayout relSet;
    private final LinearLayout rootView;
    public final TitleBar tbName;
    public final TextView tvSaoma1;
    public final TextView tvSaoma2;
    public final TextView tvSaoma3;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityDeviceInitWayBinding(LinearLayout linearLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, TitleBar titleBar, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = linearLayout;
        this.img1 = imageView;
        this.img2 = imageView2;
        this.img3 = imageView3;
        this.relBle = relativeLayout;
        this.relSaoma = relativeLayout2;
        this.relSet = relativeLayout3;
        this.tbName = titleBar;
        this.tvSaoma1 = textView;
        this.tvSaoma2 = textView2;
        this.tvSaoma3 = textView3;
    }

    public static ActivityDeviceInitWayBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityDeviceInitWayBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_device_init_way, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityDeviceInitWayBinding bind(View view) {
        int i = R.id.img1;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.img2;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                i = R.id.img3;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView3 != null) {
                    i = R.id.rel_ble;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                    if (relativeLayout != null) {
                        i = R.id.rel_saoma;
                        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                        if (relativeLayout2 != null) {
                            i = R.id.rel_set;
                            RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                            if (relativeLayout3 != null) {
                                i = R.id.tb_name;
                                TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                                if (titleBar != null) {
                                    i = R.id.tv_saoma1;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView != null) {
                                        i = R.id.tv_saoma2;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView2 != null) {
                                            i = R.id.tv_saoma3;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView3 != null) {
                                                return new ActivityDeviceInitWayBinding((LinearLayout) view, imageView, imageView2, imageView3, relativeLayout, relativeLayout2, relativeLayout3, titleBar, textView, textView2, textView3);
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
