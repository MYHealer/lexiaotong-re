package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityV4ErrorTipBinding implements ViewBinding {
    public final Button btnKnow;
    public final Button btnUpdate;
    public final ImageView imgErrorpic;
    public final ImageView imgUsecard;
    public final ImageView imgUsepsw;
    public final RelativeLayout relBluetoothfailtip;
    public final RelativeLayout relCard;
    public final RelativeLayout relPsw;
    private final RelativeLayout rootView;
    public final TitleBar tbName;
    public final TextView tvBindcard;
    public final TextView tvContent1;
    public final EditText tvContent2;
    public final TextView tvGuidetext;
    public final TextView tvSetpsw;
    public final TextView tvTraceid;
    public final TextView tvUseCardtext;
    public final TextView tvUseCardtiptext;
    public final TextView tvUsePswtext;
    public final TextView tvUsePswtiptext;

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    private ActivityV4ErrorTipBinding(RelativeLayout relativeLayout, Button button, Button button2, ImageView imageView, ImageView imageView2, ImageView imageView3, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, TitleBar titleBar, TextView textView, TextView textView2, EditText editText, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9) {
        this.rootView = relativeLayout;
        this.btnKnow = button;
        this.btnUpdate = button2;
        this.imgErrorpic = imageView;
        this.imgUsecard = imageView2;
        this.imgUsepsw = imageView3;
        this.relBluetoothfailtip = relativeLayout2;
        this.relCard = relativeLayout3;
        this.relPsw = relativeLayout4;
        this.tbName = titleBar;
        this.tvBindcard = textView;
        this.tvContent1 = textView2;
        this.tvContent2 = editText;
        this.tvGuidetext = textView3;
        this.tvSetpsw = textView4;
        this.tvTraceid = textView5;
        this.tvUseCardtext = textView6;
        this.tvUseCardtiptext = textView7;
        this.tvUsePswtext = textView8;
        this.tvUsePswtiptext = textView9;
    }

    public static ActivityV4ErrorTipBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityV4ErrorTipBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_v4_error_tip, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityV4ErrorTipBinding bind(View view) {
        int i = R.id.btn_know;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.btn_update;
            Button button2 = (Button) ViewBindings.findChildViewById(view, i);
            if (button2 != null) {
                i = R.id.img_errorpic;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = R.id.img_usecard;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView2 != null) {
                        i = R.id.img_usepsw;
                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView3 != null) {
                            i = R.id.rel_bluetoothfailtip;
                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                            if (relativeLayout != null) {
                                i = R.id.rel_card;
                                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                if (relativeLayout2 != null) {
                                    i = R.id.rel_psw;
                                    RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                    if (relativeLayout3 != null) {
                                        i = R.id.tb_name;
                                        TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                                        if (titleBar != null) {
                                            i = R.id.tv_bindcard;
                                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView != null) {
                                                i = R.id.tv_content1;
                                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView2 != null) {
                                                    i = R.id.tv_content2;
                                                    EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
                                                    if (editText != null) {
                                                        i = R.id.tv_guidetext;
                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView3 != null) {
                                                            i = R.id.tv_setpsw;
                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView4 != null) {
                                                                i = R.id.tv_traceid;
                                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView5 != null) {
                                                                    i = R.id.tv_use_cardtext;
                                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView6 != null) {
                                                                        i = R.id.tv_use_cardtiptext;
                                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView7 != null) {
                                                                            i = R.id.tv_use_pswtext;
                                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                            if (textView8 != null) {
                                                                                i = R.id.tv_use_pswtiptext;
                                                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                if (textView9 != null) {
                                                                                    return new ActivityV4ErrorTipBinding((RelativeLayout) view, button, button2, imageView, imageView2, imageView3, relativeLayout, relativeLayout2, relativeLayout3, titleBar, textView, textView2, editText, textView3, textView4, textView5, textView6, textView7, textView8, textView9);
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
