package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityRefundToAliV3Binding implements ViewBinding {
    public final Button btnRefund;
    public final EditText etAliaccount;
    public final EditText etName;
    public final EditText etPhone;
    public final ImageView imgCamera;
    public final ImageView imgUnion;
    public final RelativeLayout relAli;
    public final RelativeLayout relUnioninfo;
    private final LinearLayout rootView;
    public final TextView textali;
    public final TextView textname;
    public final TextView textphone;
    public final TextView tvRefundrule;
    public final TextView tvUnionname;
    public final TitleBar vTitleBar;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityRefundToAliV3Binding(LinearLayout linearLayout, Button button, EditText editText, EditText editText2, EditText editText3, ImageView imageView, ImageView imageView2, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TitleBar titleBar) {
        this.rootView = linearLayout;
        this.btnRefund = button;
        this.etAliaccount = editText;
        this.etName = editText2;
        this.etPhone = editText3;
        this.imgCamera = imageView;
        this.imgUnion = imageView2;
        this.relAli = relativeLayout;
        this.relUnioninfo = relativeLayout2;
        this.textali = textView;
        this.textname = textView2;
        this.textphone = textView3;
        this.tvRefundrule = textView4;
        this.tvUnionname = textView5;
        this.vTitleBar = titleBar;
    }

    public static ActivityRefundToAliV3Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityRefundToAliV3Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_refund_to_ali_v3, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityRefundToAliV3Binding bind(View view) {
        int i = R.id.btn_refund;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.et_aliaccount;
            EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
            if (editText != null) {
                i = R.id.et_name;
                EditText editText2 = (EditText) ViewBindings.findChildViewById(view, i);
                if (editText2 != null) {
                    i = R.id.et_phone;
                    EditText editText3 = (EditText) ViewBindings.findChildViewById(view, i);
                    if (editText3 != null) {
                        i = R.id.img_camera;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView != null) {
                            i = R.id.img_union;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView2 != null) {
                                i = R.id.rel_ali;
                                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                if (relativeLayout != null) {
                                    i = R.id.rel_unioninfo;
                                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                    if (relativeLayout2 != null) {
                                        i = R.id.textali;
                                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView != null) {
                                            i = R.id.textname;
                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView2 != null) {
                                                i = R.id.textphone;
                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView3 != null) {
                                                    i = R.id.tv_refundrule;
                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView4 != null) {
                                                        i = R.id.tv_unionname;
                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView5 != null) {
                                                            i = R.id.v_titleBar;
                                                            TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                                                            if (titleBar != null) {
                                                                return new ActivityRefundToAliV3Binding((LinearLayout) view, button, editText, editText2, editText3, imageView, imageView2, relativeLayout, relativeLayout2, textView, textView2, textView3, textView4, textView5, titleBar);
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
