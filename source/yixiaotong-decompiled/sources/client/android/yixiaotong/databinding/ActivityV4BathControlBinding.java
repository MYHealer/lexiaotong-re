package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityV4BathControlBinding implements ViewBinding {
    public final RelativeLayout flContainer;
    public final ImageView ivAppointment;
    public final TextView ivAppointmenttext;
    public final ImageView ivAppointmenttop;
    public final ImageView ivBathhelp;
    public final ImageView ivClose;
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
    public final RelativeLayout relClose;
    public final RelativeLayout relError;
    public final RelativeLayout relMyorder;
    public final RelativeLayout relMywallet;
    public final RelativeLayout relPswopen;
    public final RelativeLayout relTopspeedopen;
    private final RelativeLayout rootView;
    public final ScrollView scrollview;
    public final TitleBar titleBar;
    public final TextView tvAdvname;
    public final TextView tvWdddtext;
    public final TextView tvWdqbtext;

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    private ActivityV4BathControlBinding(RelativeLayout relativeLayout, RelativeLayout relativeLayout2, ImageView imageView, TextView textView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, ImageView imageView8, ImageView imageView9, ImageView imageView10, ImageView imageView11, ImageView imageView12, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, RelativeLayout relativeLayout5, RelativeLayout relativeLayout6, RelativeLayout relativeLayout7, RelativeLayout relativeLayout8, RelativeLayout relativeLayout9, RelativeLayout relativeLayout10, ScrollView scrollView, TitleBar titleBar, TextView textView2, TextView textView3, TextView textView4) {
        this.rootView = relativeLayout;
        this.flContainer = relativeLayout2;
        this.ivAppointment = imageView;
        this.ivAppointmenttext = textView;
        this.ivAppointmenttop = imageView2;
        this.ivBathhelp = imageView3;
        this.ivClose = imageView4;
        this.ivDd = imageView5;
        this.ivPswopen = imageView6;
        this.ivScan = imageView7;
        this.ivWddd = imageView8;
        this.ivWdddtop = imageView9;
        this.ivWdqb = imageView10;
        this.ivWdqbtop = imageView11;
        this.ivYhq = imageView12;
        this.relAppointment = relativeLayout3;
        this.relBluetoothopen = relativeLayout4;
        this.relClose = relativeLayout5;
        this.relError = relativeLayout6;
        this.relMyorder = relativeLayout7;
        this.relMywallet = relativeLayout8;
        this.relPswopen = relativeLayout9;
        this.relTopspeedopen = relativeLayout10;
        this.scrollview = scrollView;
        this.titleBar = titleBar;
        this.tvAdvname = textView2;
        this.tvWdddtext = textView3;
        this.tvWdqbtext = textView4;
    }

    public static ActivityV4BathControlBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityV4BathControlBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_v4_bath_control, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityV4BathControlBinding bind(View view) {
        int i = R.id.flContainer;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
        if (relativeLayout != null) {
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
                            i = R.id.iv_close;
                            ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView4 != null) {
                                i = R.id.iv_dd;
                                ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i);
                                if (imageView5 != null) {
                                    i = R.id.iv_pswopen;
                                    ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, i);
                                    if (imageView6 != null) {
                                        i = R.id.iv_scan;
                                        ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(view, i);
                                        if (imageView7 != null) {
                                            i = R.id.iv_wddd;
                                            ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(view, i);
                                            if (imageView8 != null) {
                                                i = R.id.iv_wdddtop;
                                                ImageView imageView9 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                if (imageView9 != null) {
                                                    i = R.id.iv_wdqb;
                                                    ImageView imageView10 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                    if (imageView10 != null) {
                                                        i = R.id.iv_wdqbtop;
                                                        ImageView imageView11 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                        if (imageView11 != null) {
                                                            i = R.id.iv_yhq;
                                                            ImageView imageView12 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                            if (imageView12 != null) {
                                                                i = R.id.rel_appointment;
                                                                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                                if (relativeLayout2 != null) {
                                                                    i = R.id.rel_bluetoothopen;
                                                                    RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                                    if (relativeLayout3 != null) {
                                                                        i = R.id.rel_close;
                                                                        RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                                        if (relativeLayout4 != null) {
                                                                            i = R.id.rel_error;
                                                                            RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                                            if (relativeLayout5 != null) {
                                                                                i = R.id.rel_myorder;
                                                                                RelativeLayout relativeLayout6 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                                                if (relativeLayout6 != null) {
                                                                                    i = R.id.rel_mywallet;
                                                                                    RelativeLayout relativeLayout7 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                                                    if (relativeLayout7 != null) {
                                                                                        i = R.id.rel_pswopen;
                                                                                        RelativeLayout relativeLayout8 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                                                        if (relativeLayout8 != null) {
                                                                                            i = R.id.rel_topspeedopen;
                                                                                            RelativeLayout relativeLayout9 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                                                            if (relativeLayout9 != null) {
                                                                                                i = R.id.scrollview;
                                                                                                ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(view, i);
                                                                                                if (scrollView != null) {
                                                                                                    i = R.id.titleBar;
                                                                                                    TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                                                                                                    if (titleBar != null) {
                                                                                                        i = R.id.tv_advname;
                                                                                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                        if (textView2 != null) {
                                                                                                            i = R.id.tv_wdddtext;
                                                                                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                            if (textView3 != null) {
                                                                                                                i = R.id.tv_wdqbtext;
                                                                                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                if (textView4 != null) {
                                                                                                                    return new ActivityV4BathControlBinding((RelativeLayout) view, relativeLayout, imageView, textView, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, imageView9, imageView10, imageView11, imageView12, relativeLayout2, relativeLayout3, relativeLayout4, relativeLayout5, relativeLayout6, relativeLayout7, relativeLayout8, relativeLayout9, scrollView, titleBar, textView2, textView3, textView4);
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
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
