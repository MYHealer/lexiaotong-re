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
public final class ActivitySelectOperateBinding implements ViewBinding {
    public final TextView deviceid;
    public final TextView devicemac;
    public final ImageView ivAppicon1;
    public final ImageView ivAppicon2;
    public final ImageView ivAppicon3;
    public final ImageView ivAppicon4;
    public final ImageView ivAppicon5;
    public final ImageView ivAppicon6;
    public final ImageView ivAppicon7;
    public final ImageView ivArrow;
    public final ImageView ivArrow1;
    public final ImageView ivArrow2;
    public final ImageView ivArrow3;
    public final RelativeLayout relAmmeter;
    public final RelativeLayout relBindRoom;
    public final RelativeLayout relButie;
    public final RelativeLayout relChongzhi;
    public final RelativeLayout relDevicebindRoom;
    public final RelativeLayout relOrder;
    private final LinearLayout rootView;
    public final TextView sushe;
    public final TitleBar titleBar;
    public final TextView tvBindroom;
    public final TextView tvDeviceaddress;
    public final TextView tvDeviceid;
    public final TextView tvSusheaddress;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivitySelectOperateBinding(LinearLayout linearLayout, TextView textView, TextView textView2, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, ImageView imageView8, ImageView imageView9, ImageView imageView10, ImageView imageView11, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, RelativeLayout relativeLayout5, RelativeLayout relativeLayout6, TextView textView3, TitleBar titleBar, TextView textView4, TextView textView5, TextView textView6, TextView textView7) {
        this.rootView = linearLayout;
        this.deviceid = textView;
        this.devicemac = textView2;
        this.ivAppicon1 = imageView;
        this.ivAppicon2 = imageView2;
        this.ivAppicon3 = imageView3;
        this.ivAppicon4 = imageView4;
        this.ivAppicon5 = imageView5;
        this.ivAppicon6 = imageView6;
        this.ivAppicon7 = imageView7;
        this.ivArrow = imageView8;
        this.ivArrow1 = imageView9;
        this.ivArrow2 = imageView10;
        this.ivArrow3 = imageView11;
        this.relAmmeter = relativeLayout;
        this.relBindRoom = relativeLayout2;
        this.relButie = relativeLayout3;
        this.relChongzhi = relativeLayout4;
        this.relDevicebindRoom = relativeLayout5;
        this.relOrder = relativeLayout6;
        this.sushe = textView3;
        this.titleBar = titleBar;
        this.tvBindroom = textView4;
        this.tvDeviceaddress = textView5;
        this.tvDeviceid = textView6;
        this.tvSusheaddress = textView7;
    }

    public static ActivitySelectOperateBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivitySelectOperateBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_select_operate, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivitySelectOperateBinding bind(View view) {
        int i = R.id.deviceid;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.devicemac;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = R.id.iv_appicon1;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = R.id.iv_appicon2;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView2 != null) {
                        i = R.id.iv_appicon3;
                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView3 != null) {
                            i = R.id.iv_appicon4;
                            ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView4 != null) {
                                i = R.id.iv_appicon5;
                                ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i);
                                if (imageView5 != null) {
                                    i = R.id.iv_appicon6;
                                    ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, i);
                                    if (imageView6 != null) {
                                        i = R.id.iv_appicon7;
                                        ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(view, i);
                                        if (imageView7 != null) {
                                            i = R.id.iv_arrow;
                                            ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(view, i);
                                            if (imageView8 != null) {
                                                i = R.id.iv_arrow1;
                                                ImageView imageView9 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                if (imageView9 != null) {
                                                    i = R.id.iv_arrow2;
                                                    ImageView imageView10 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                    if (imageView10 != null) {
                                                        i = R.id.iv_arrow3;
                                                        ImageView imageView11 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                        if (imageView11 != null) {
                                                            i = R.id.rel_ammeter;
                                                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                            if (relativeLayout != null) {
                                                                i = R.id.rel_bindRoom;
                                                                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                                if (relativeLayout2 != null) {
                                                                    i = R.id.rel_butie;
                                                                    RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                                    if (relativeLayout3 != null) {
                                                                        i = R.id.rel_chongzhi;
                                                                        RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                                        if (relativeLayout4 != null) {
                                                                            i = R.id.rel_devicebindRoom;
                                                                            RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                                            if (relativeLayout5 != null) {
                                                                                i = R.id.rel_order;
                                                                                RelativeLayout relativeLayout6 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                                                if (relativeLayout6 != null) {
                                                                                    i = R.id.sushe;
                                                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                    if (textView3 != null) {
                                                                                        i = R.id.titleBar;
                                                                                        TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                                                                                        if (titleBar != null) {
                                                                                            i = R.id.tv_bindroom;
                                                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                            if (textView4 != null) {
                                                                                                i = R.id.tv_deviceaddress;
                                                                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                if (textView5 != null) {
                                                                                                    i = R.id.tv_deviceid;
                                                                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                    if (textView6 != null) {
                                                                                                        i = R.id.tv_susheaddress;
                                                                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                        if (textView7 != null) {
                                                                                                            return new ActivitySelectOperateBinding((LinearLayout) view, textView, textView2, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, imageView9, imageView10, imageView11, relativeLayout, relativeLayout2, relativeLayout3, relativeLayout4, relativeLayout5, relativeLayout6, textView3, titleBar, textView4, textView5, textView6, textView7);
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
