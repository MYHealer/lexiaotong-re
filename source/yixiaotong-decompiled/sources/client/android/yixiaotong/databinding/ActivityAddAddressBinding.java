package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityAddAddressBinding implements ViewBinding {
    public final Button btnAddaddress;
    public final EditText etPhone;
    public final RelativeLayout relArea1;
    public final RelativeLayout relArea2;
    public final RelativeLayout relArea3;
    public final RelativeLayout relArea4;
    public final RelativeLayout relPhone;
    private final LinearLayout rootView;
    public final TitleBar titleBar;
    public final TextView tvArea1;
    public final TextView tvArea2;
    public final TextView tvArea3;
    public final TextView tvArea4;
    public final TextView tvAreatext1;
    public final TextView tvAreatext2;
    public final TextView tvAreatext3;
    public final TextView tvAreatext4;
    public final TextView tvPhonetext;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityAddAddressBinding(LinearLayout linearLayout, Button button, EditText editText, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, RelativeLayout relativeLayout5, TitleBar titleBar, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9) {
        this.rootView = linearLayout;
        this.btnAddaddress = button;
        this.etPhone = editText;
        this.relArea1 = relativeLayout;
        this.relArea2 = relativeLayout2;
        this.relArea3 = relativeLayout3;
        this.relArea4 = relativeLayout4;
        this.relPhone = relativeLayout5;
        this.titleBar = titleBar;
        this.tvArea1 = textView;
        this.tvArea2 = textView2;
        this.tvArea3 = textView3;
        this.tvArea4 = textView4;
        this.tvAreatext1 = textView5;
        this.tvAreatext2 = textView6;
        this.tvAreatext3 = textView7;
        this.tvAreatext4 = textView8;
        this.tvPhonetext = textView9;
    }

    public static ActivityAddAddressBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityAddAddressBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_add_address, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityAddAddressBinding bind(View view) {
        int i = R.id.btn_addaddress;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.et_phone;
            EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
            if (editText != null) {
                i = R.id.rel_area1;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                if (relativeLayout != null) {
                    i = R.id.rel_area2;
                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                    if (relativeLayout2 != null) {
                        i = R.id.rel_area3;
                        RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                        if (relativeLayout3 != null) {
                            i = R.id.rel_area4;
                            RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                            if (relativeLayout4 != null) {
                                i = R.id.rel_phone;
                                RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                if (relativeLayout5 != null) {
                                    i = R.id.titleBar;
                                    TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                                    if (titleBar != null) {
                                        i = R.id.tv_area1;
                                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView != null) {
                                            i = R.id.tv_area2;
                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView2 != null) {
                                                i = R.id.tv_area3;
                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView3 != null) {
                                                    i = R.id.tv_area4;
                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView4 != null) {
                                                        i = R.id.tv_areatext1;
                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView5 != null) {
                                                            i = R.id.tv_areatext2;
                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView6 != null) {
                                                                i = R.id.tv_areatext3;
                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView7 != null) {
                                                                    i = R.id.tv_areatext4;
                                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView8 != null) {
                                                                        i = R.id.tv_phonetext;
                                                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView9 != null) {
                                                                            return new ActivityAddAddressBinding((LinearLayout) view, button, editText, relativeLayout, relativeLayout2, relativeLayout3, relativeLayout4, relativeLayout5, titleBar, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9);
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
