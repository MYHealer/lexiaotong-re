package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityBathControlDemoBinding implements ViewBinding {
    public final FrameLayout flContainer;
    public final ImageView ivAppointment;
    public final TextView ivAppointmenttext;
    public final ImageView ivAppointmenttop;
    public final ImageView ivBathhelp;
    public final ImageView ivDd;
    public final ImageView ivPswopen;
    public final ImageView ivScan;
    public final ImageView ivWddd;
    public final ImageView ivWdddtop;
    public final ImageView ivWdqb;
    public final ImageView ivWdqbtop;
    public final ImageView ivYhq;
    public final RelativeLayout relAppointment;
    public final RelativeLayout relBluetoothopen;
    public final RelativeLayout relMyorder;
    public final RelativeLayout relMywallet;
    public final RelativeLayout relPswopen;
    public final RelativeLayout relTopspeedopen;
    private final RelativeLayout rootView;
    public final TitleBar titleBar;
    public final TextView tvWdddtext;
    public final TextView tvWdqbtext;

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    private ActivityBathControlDemoBinding(RelativeLayout relativeLayout, FrameLayout frameLayout, ImageView imageView, TextView textView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, ImageView imageView8, ImageView imageView9, ImageView imageView10, ImageView imageView11, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, RelativeLayout relativeLayout5, RelativeLayout relativeLayout6, RelativeLayout relativeLayout7, TitleBar titleBar, TextView textView2, TextView textView3) {
        this.rootView = relativeLayout;
        this.flContainer = frameLayout;
        this.ivAppointment = imageView;
        this.ivAppointmenttext = textView;
        this.ivAppointmenttop = imageView2;
        this.ivBathhelp = imageView3;
        this.ivDd = imageView4;
        this.ivPswopen = imageView5;
        this.ivScan = imageView6;
        this.ivWddd = imageView7;
        this.ivWdddtop = imageView8;
        this.ivWdqb = imageView9;
        this.ivWdqbtop = imageView10;
        this.ivYhq = imageView11;
        this.relAppointment = relativeLayout2;
        this.relBluetoothopen = relativeLayout3;
        this.relMyorder = relativeLayout4;
        this.relMywallet = relativeLayout5;
        this.relPswopen = relativeLayout6;
        this.relTopspeedopen = relativeLayout7;
        this.titleBar = titleBar;
        this.tvWdddtext = textView2;
        this.tvWdqbtext = textView3;
    }

    public static ActivityBathControlDemoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityBathControlDemoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_bath_control_demo, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityBathControlDemoBinding bind(View view) {
        int i = R.id.flContainer;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
        if (frameLayout != null) {
            i = R.id.iv_appointment;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.iv_appointmenttext;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.iv_appointmenttop;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView2 != null) {
                        i = R.id.iv_bathhelp;
                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView3 != null) {
                            i = R.id.iv_dd;
                            ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView4 != null) {
                                i = R.id.iv_pswopen;
                                ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i);
                                if (imageView5 != null) {
                                    i = R.id.iv_scan;
                                    ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, i);
                                    if (imageView6 != null) {
                                        i = R.id.iv_wddd;
                                        ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(view, i);
                                        if (imageView7 != null) {
                                            i = R.id.iv_wdddtop;
                                            ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(view, i);
                                            if (imageView8 != null) {
                                                i = R.id.iv_wdqb;
                                                ImageView imageView9 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                if (imageView9 != null) {
                                                    i = R.id.iv_wdqbtop;
                                                    ImageView imageView10 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                    if (imageView10 != null) {
                                                        i = R.id.iv_yhq;
                                                        ImageView imageView11 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                        if (imageView11 != null) {
                                                            i = R.id.rel_appointment;
                                                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                            if (relativeLayout != null) {
                                                                i = R.id.rel_bluetoothopen;
                                                                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                                if (relativeLayout2 != null) {
                                                                    i = R.id.rel_myorder;
                                                                    RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                                    if (relativeLayout3 != null) {
                                                                        i = R.id.rel_mywallet;
                                                                        RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                                        if (relativeLayout4 != null) {
                                                                            i = R.id.rel_pswopen;
                                                                            RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                                            if (relativeLayout5 != null) {
                                                                                i = R.id.rel_topspeedopen;
                                                                                RelativeLayout relativeLayout6 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                                                if (relativeLayout6 != null) {
                                                                                    i = R.id.titleBar;
                                                                                    TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                                                                                    if (titleBar != null) {
                                                                                        i = R.id.tv_wdddtext;
                                                                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                        if (textView2 != null) {
                                                                                            i = R.id.tv_wdqbtext;
                                                                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                            if (textView3 != null) {
                                                                                                return new ActivityBathControlDemoBinding((RelativeLayout) view, frameLayout, imageView, textView, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, imageView9, imageView10, imageView11, relativeLayout, relativeLayout2, relativeLayout3, relativeLayout4, relativeLayout5, relativeLayout6, titleBar, textView2, textView3);
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
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
