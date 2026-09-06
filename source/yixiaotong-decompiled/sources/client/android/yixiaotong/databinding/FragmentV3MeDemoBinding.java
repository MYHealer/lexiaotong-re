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

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class FragmentV3MeDemoBinding implements ViewBinding {
    public final ImageView ivAbountme;
    public final ImageView ivCard;
    public final ImageView ivChangeloginpsw;
    public final ImageView ivChangephone;
    public final ImageView ivDd;
    public final ImageView ivHb;
    public final ImageView ivIcon;
    public final ImageView ivNextver;
    public final ImageView ivRepair;
    public final ImageView ivSchoolqrcode;
    public final ImageView ivVersionupdate;
    public final ImageView ivWaterpsw;
    public final ImageView ivYeicon;
    public final ImageView ivYhq;
    public final RelativeLayout relAbountme;
    public final RelativeLayout relCard;
    public final RelativeLayout relCardinfo;
    public final RelativeLayout relChangeloginpsw;
    public final RelativeLayout relChangephone;
    public final RelativeLayout relDiscountcoupon;
    public final RelativeLayout relExitlogin;
    public final RelativeLayout relFqa;
    public final RelativeLayout relInfo;
    public final RelativeLayout relOrder;
    public final RelativeLayout relRedpackage;
    public final RelativeLayout relRepair;
    public final RelativeLayout relSchoolqrcode;
    public final RelativeLayout relVersionupdate;
    public final RelativeLayout relWaterpsw;
    private final LinearLayout rootView;
    public final TextView tvEditinfo;
    public final TextView tvName;
    public final TextView tvVetsion;
    public final View vDot;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private FragmentV3MeDemoBinding(LinearLayout linearLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, ImageView imageView8, ImageView imageView9, ImageView imageView10, ImageView imageView11, ImageView imageView12, ImageView imageView13, ImageView imageView14, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, RelativeLayout relativeLayout5, RelativeLayout relativeLayout6, RelativeLayout relativeLayout7, RelativeLayout relativeLayout8, RelativeLayout relativeLayout9, RelativeLayout relativeLayout10, RelativeLayout relativeLayout11, RelativeLayout relativeLayout12, RelativeLayout relativeLayout13, RelativeLayout relativeLayout14, RelativeLayout relativeLayout15, TextView textView, TextView textView2, TextView textView3, View view) {
        this.rootView = linearLayout;
        this.ivAbountme = imageView;
        this.ivCard = imageView2;
        this.ivChangeloginpsw = imageView3;
        this.ivChangephone = imageView4;
        this.ivDd = imageView5;
        this.ivHb = imageView6;
        this.ivIcon = imageView7;
        this.ivNextver = imageView8;
        this.ivRepair = imageView9;
        this.ivSchoolqrcode = imageView10;
        this.ivVersionupdate = imageView11;
        this.ivWaterpsw = imageView12;
        this.ivYeicon = imageView13;
        this.ivYhq = imageView14;
        this.relAbountme = relativeLayout;
        this.relCard = relativeLayout2;
        this.relCardinfo = relativeLayout3;
        this.relChangeloginpsw = relativeLayout4;
        this.relChangephone = relativeLayout5;
        this.relDiscountcoupon = relativeLayout6;
        this.relExitlogin = relativeLayout7;
        this.relFqa = relativeLayout8;
        this.relInfo = relativeLayout9;
        this.relOrder = relativeLayout10;
        this.relRedpackage = relativeLayout11;
        this.relRepair = relativeLayout12;
        this.relSchoolqrcode = relativeLayout13;
        this.relVersionupdate = relativeLayout14;
        this.relWaterpsw = relativeLayout15;
        this.tvEditinfo = textView;
        this.tvName = textView2;
        this.tvVetsion = textView3;
        this.vDot = view;
    }

    public static FragmentV3MeDemoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentV3MeDemoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_v3_me_demo, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentV3MeDemoBinding bind(View view) {
        View viewFindChildViewById;
        int i = R.id.iv_abountme;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.iv_card;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                i = R.id.iv_changeloginpsw;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView3 != null) {
                    i = R.id.iv_changephone;
                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView4 != null) {
                        i = R.id.iv_dd;
                        ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView5 != null) {
                            i = R.id.iv_hb;
                            ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView6 != null) {
                                i = R.id.iv_icon;
                                ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(view, i);
                                if (imageView7 != null) {
                                    i = R.id.iv_nextver;
                                    ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(view, i);
                                    if (imageView8 != null) {
                                        i = R.id.iv_repair;
                                        ImageView imageView9 = (ImageView) ViewBindings.findChildViewById(view, i);
                                        if (imageView9 != null) {
                                            i = R.id.iv_schoolqrcode;
                                            ImageView imageView10 = (ImageView) ViewBindings.findChildViewById(view, i);
                                            if (imageView10 != null) {
                                                i = R.id.iv_versionupdate;
                                                ImageView imageView11 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                if (imageView11 != null) {
                                                    i = R.id.iv_waterpsw;
                                                    ImageView imageView12 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                    if (imageView12 != null) {
                                                        i = R.id.iv_yeicon;
                                                        ImageView imageView13 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                        if (imageView13 != null) {
                                                            i = R.id.iv_yhq;
                                                            ImageView imageView14 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                            if (imageView14 != null) {
                                                                i = R.id.rel_abountme;
                                                                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                                if (relativeLayout != null) {
                                                                    i = R.id.rel_card;
                                                                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                                    if (relativeLayout2 != null) {
                                                                        i = R.id.rel_cardinfo;
                                                                        RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                                        if (relativeLayout3 != null) {
                                                                            i = R.id.rel_changeloginpsw;
                                                                            RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                                            if (relativeLayout4 != null) {
                                                                                i = R.id.rel_changephone;
                                                                                RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                                                if (relativeLayout5 != null) {
                                                                                    i = R.id.rel_discountcoupon;
                                                                                    RelativeLayout relativeLayout6 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                                                    if (relativeLayout6 != null) {
                                                                                        i = R.id.rel_exitlogin;
                                                                                        RelativeLayout relativeLayout7 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                                                        if (relativeLayout7 != null) {
                                                                                            i = R.id.rel_fqa;
                                                                                            RelativeLayout relativeLayout8 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                                                            if (relativeLayout8 != null) {
                                                                                                i = R.id.rel_info;
                                                                                                RelativeLayout relativeLayout9 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                                                                if (relativeLayout9 != null) {
                                                                                                    i = R.id.rel_order;
                                                                                                    RelativeLayout relativeLayout10 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                                                                    if (relativeLayout10 != null) {
                                                                                                        i = R.id.rel_redpackage;
                                                                                                        RelativeLayout relativeLayout11 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                                                                        if (relativeLayout11 != null) {
                                                                                                            i = R.id.rel_repair;
                                                                                                            RelativeLayout relativeLayout12 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                                                                            if (relativeLayout12 != null) {
                                                                                                                i = R.id.rel_schoolqrcode;
                                                                                                                RelativeLayout relativeLayout13 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                if (relativeLayout13 != null) {
                                                                                                                    i = R.id.rel_versionupdate;
                                                                                                                    RelativeLayout relativeLayout14 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                    if (relativeLayout14 != null) {
                                                                                                                        i = R.id.rel_waterpsw;
                                                                                                                        RelativeLayout relativeLayout15 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                        if (relativeLayout15 != null) {
                                                                                                                            i = R.id.tv_editinfo;
                                                                                                                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                            if (textView != null) {
                                                                                                                                i = R.id.tv_name;
                                                                                                                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                if (textView2 != null) {
                                                                                                                                    i = R.id.tv_vetsion;
                                                                                                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                    if (textView3 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.v_dot))) != null) {
                                                                                                                                        return new FragmentV3MeDemoBinding((LinearLayout) view, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, imageView9, imageView10, imageView11, imageView12, imageView13, imageView14, relativeLayout, relativeLayout2, relativeLayout3, relativeLayout4, relativeLayout5, relativeLayout6, relativeLayout7, relativeLayout8, relativeLayout9, relativeLayout10, relativeLayout11, relativeLayout12, relativeLayout13, relativeLayout14, relativeLayout15, textView, textView2, textView3, viewFindChildViewById);
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
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
