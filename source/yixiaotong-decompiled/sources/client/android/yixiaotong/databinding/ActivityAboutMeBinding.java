package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityAboutMeBinding implements ViewBinding {
    public final ImageView ivLanguage;
    public final ImageView ivLogo;
    public final ImageView ivUpdate;
    public final RelativeLayout relAgreement;
    public final RelativeLayout relCancelaccount;
    public final RelativeLayout relInformationpermissions;
    public final RelativeLayout relLanuage;
    public final RelativeLayout relLoadapp;
    public final RelativeLayout relPrivacypolicy;
    public final RelativeLayout relThirdpartyinformationsdk;
    public final RelativeLayout relVer;
    public final RelativeLayout relVerupdate;
    private final RelativeLayout rootView;
    public final TitleBar titleBar;
    public final TextView tvBeian;
    public final TextView tvLanuage;
    public final TextView tvName;
    public final TextView tvServerversion;
    public final TextView tvVersion;
    public final View vDot;

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    private ActivityAboutMeBinding(RelativeLayout relativeLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, RelativeLayout relativeLayout5, RelativeLayout relativeLayout6, RelativeLayout relativeLayout7, RelativeLayout relativeLayout8, RelativeLayout relativeLayout9, RelativeLayout relativeLayout10, TitleBar titleBar, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, View view) {
        this.rootView = relativeLayout;
        this.ivLanguage = imageView;
        this.ivLogo = imageView2;
        this.ivUpdate = imageView3;
        this.relAgreement = relativeLayout2;
        this.relCancelaccount = relativeLayout3;
        this.relInformationpermissions = relativeLayout4;
        this.relLanuage = relativeLayout5;
        this.relLoadapp = relativeLayout6;
        this.relPrivacypolicy = relativeLayout7;
        this.relThirdpartyinformationsdk = relativeLayout8;
        this.relVer = relativeLayout9;
        this.relVerupdate = relativeLayout10;
        this.titleBar = titleBar;
        this.tvBeian = textView;
        this.tvLanuage = textView2;
        this.tvName = textView3;
        this.tvServerversion = textView4;
        this.tvVersion = textView5;
        this.vDot = view;
    }

    public static ActivityAboutMeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityAboutMeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_about_me, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityAboutMeBinding bind(View view) {
        View viewFindChildViewById;
        int i = R.id.iv_language;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.iv_logo;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                i = R.id.iv_update;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView3 != null) {
                    i = R.id.rel_agreement;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                    if (relativeLayout != null) {
                        i = R.id.rel_cancelaccount;
                        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                        if (relativeLayout2 != null) {
                            i = R.id.rel_informationpermissions;
                            RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                            if (relativeLayout3 != null) {
                                i = R.id.rel_lanuage;
                                RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                if (relativeLayout4 != null) {
                                    i = R.id.rel_loadapp;
                                    RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                    if (relativeLayout5 != null) {
                                        i = R.id.rel_privacypolicy;
                                        RelativeLayout relativeLayout6 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                        if (relativeLayout6 != null) {
                                            i = R.id.rel_thirdpartyinformationsdk;
                                            RelativeLayout relativeLayout7 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                            if (relativeLayout7 != null) {
                                                i = R.id.rel_ver;
                                                RelativeLayout relativeLayout8 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                if (relativeLayout8 != null) {
                                                    i = R.id.rel_verupdate;
                                                    RelativeLayout relativeLayout9 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                    if (relativeLayout9 != null) {
                                                        i = R.id.titleBar;
                                                        TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                                                        if (titleBar != null) {
                                                            i = R.id.tv_beian;
                                                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView != null) {
                                                                i = R.id.tv_lanuage;
                                                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView2 != null) {
                                                                    i = R.id.tv_name;
                                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView3 != null) {
                                                                        i = R.id.tv_serverversion;
                                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView4 != null) {
                                                                            i = R.id.tv_version;
                                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                            if (textView5 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.v_dot))) != null) {
                                                                                return new ActivityAboutMeBinding((RelativeLayout) view, imageView, imageView2, imageView3, relativeLayout, relativeLayout2, relativeLayout3, relativeLayout4, relativeLayout5, relativeLayout6, relativeLayout7, relativeLayout8, relativeLayout9, titleBar, textView, textView2, textView3, textView4, textView5, viewFindChildViewById);
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
