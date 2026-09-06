package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class FragmentMeBinding implements ViewBinding {
    public final Button btnExitApp;
    public final Button btnXuehao;
    public final ImageView ivArrow;
    public final SimpleDraweeView ivMeIcon;
    public final LinearLayout linClean;
    public final LinearLayout linId;
    public final LinearLayout linInit;
    public final LinearLayout linName;
    public final LinearLayout linService;
    public final LinearLayout llMeAbountMe;
    public final LinearLayout llMeBaoixiu;
    public final LinearLayout llMeChongzhiRecord;
    public final LinearLayout llMeClean;
    public final LinearLayout llMeInit;
    public final LinearLayout llMeMessageSetting;
    public final LinearLayout llMeRecord;
    public final LinearLayout llMeRepair;
    public final LinearLayout llMeUpdate;
    public final RelativeLayout relInfo;
    private final LinearLayout rootView;
    public final TitleBar tbName;
    public final TextView tvId;
    public final TextView tvIdentityId;
    public final TextView tvMeNewVersion;
    public final TextView tvMyinfo;
    public final TextView tvName;
    public final View vDot;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private FragmentMeBinding(LinearLayout linearLayout, Button button, Button button2, ImageView imageView, SimpleDraweeView simpleDraweeView, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, LinearLayout linearLayout6, LinearLayout linearLayout7, LinearLayout linearLayout8, LinearLayout linearLayout9, LinearLayout linearLayout10, LinearLayout linearLayout11, LinearLayout linearLayout12, LinearLayout linearLayout13, LinearLayout linearLayout14, LinearLayout linearLayout15, RelativeLayout relativeLayout, TitleBar titleBar, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, View view) {
        this.rootView = linearLayout;
        this.btnExitApp = button;
        this.btnXuehao = button2;
        this.ivArrow = imageView;
        this.ivMeIcon = simpleDraweeView;
        this.linClean = linearLayout2;
        this.linId = linearLayout3;
        this.linInit = linearLayout4;
        this.linName = linearLayout5;
        this.linService = linearLayout6;
        this.llMeAbountMe = linearLayout7;
        this.llMeBaoixiu = linearLayout8;
        this.llMeChongzhiRecord = linearLayout9;
        this.llMeClean = linearLayout10;
        this.llMeInit = linearLayout11;
        this.llMeMessageSetting = linearLayout12;
        this.llMeRecord = linearLayout13;
        this.llMeRepair = linearLayout14;
        this.llMeUpdate = linearLayout15;
        this.relInfo = relativeLayout;
        this.tbName = titleBar;
        this.tvId = textView;
        this.tvIdentityId = textView2;
        this.tvMeNewVersion = textView3;
        this.tvMyinfo = textView4;
        this.tvName = textView5;
        this.vDot = view;
    }

    public static FragmentMeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentMeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_me, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentMeBinding bind(View view) {
        View viewFindChildViewById;
        int i = R.id.btn_exit_app;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.btn_xuehao;
            Button button2 = (Button) ViewBindings.findChildViewById(view, i);
            if (button2 != null) {
                i = R.id.iv_arrow;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = R.id.iv_me_icon;
                    SimpleDraweeView simpleDraweeView = (SimpleDraweeView) ViewBindings.findChildViewById(view, i);
                    if (simpleDraweeView != null) {
                        i = R.id.lin_clean;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                        if (linearLayout != null) {
                            i = R.id.lin_id;
                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                            if (linearLayout2 != null) {
                                i = R.id.lin_init;
                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                if (linearLayout3 != null) {
                                    i = R.id.lin_name;
                                    LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                    if (linearLayout4 != null) {
                                        i = R.id.lin_service;
                                        LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                        if (linearLayout5 != null) {
                                            i = R.id.ll_me_abount_me;
                                            LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                            if (linearLayout6 != null) {
                                                i = R.id.ll_me_baoixiu;
                                                LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                if (linearLayout7 != null) {
                                                    i = R.id.ll_me_chongzhi_record;
                                                    LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                    if (linearLayout8 != null) {
                                                        i = R.id.ll_me_clean;
                                                        LinearLayout linearLayout9 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                        if (linearLayout9 != null) {
                                                            i = R.id.ll_me_init;
                                                            LinearLayout linearLayout10 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                            if (linearLayout10 != null) {
                                                                i = R.id.ll_me_message_setting;
                                                                LinearLayout linearLayout11 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                if (linearLayout11 != null) {
                                                                    i = R.id.ll_me_record;
                                                                    LinearLayout linearLayout12 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                    if (linearLayout12 != null) {
                                                                        i = R.id.ll_me_repair;
                                                                        LinearLayout linearLayout13 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                        if (linearLayout13 != null) {
                                                                            i = R.id.ll_me_update;
                                                                            LinearLayout linearLayout14 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                            if (linearLayout14 != null) {
                                                                                i = R.id.rel_info;
                                                                                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                                                if (relativeLayout != null) {
                                                                                    i = R.id.tb_name;
                                                                                    TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                                                                                    if (titleBar != null) {
                                                                                        i = R.id.tv_id;
                                                                                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                        if (textView != null) {
                                                                                            i = R.id.tv_identityId;
                                                                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                            if (textView2 != null) {
                                                                                                i = R.id.tv_me_new_version;
                                                                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                if (textView3 != null) {
                                                                                                    i = R.id.tv_myinfo;
                                                                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                    if (textView4 != null) {
                                                                                                        i = R.id.tv_name;
                                                                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                        if (textView5 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.v_dot))) != null) {
                                                                                                            return new FragmentMeBinding((LinearLayout) view, button, button2, imageView, simpleDraweeView, linearLayout, linearLayout2, linearLayout3, linearLayout4, linearLayout5, linearLayout6, linearLayout7, linearLayout8, linearLayout9, linearLayout10, linearLayout11, linearLayout12, linearLayout13, linearLayout14, relativeLayout, titleBar, textView, textView2, textView3, textView4, textView5, viewFindChildViewById);
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
