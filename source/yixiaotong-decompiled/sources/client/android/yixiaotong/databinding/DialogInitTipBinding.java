package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class DialogInitTipBinding implements ViewBinding {
    public final Button btnDevicedetail;
    public final Button btnInit;
    public final Button btnSet;
    public final LinearLayout linMorehelp;
    private final LinearLayout rootView;
    public final TextView text1;
    public final TextView text2;
    public final TextView text3;
    public final TextView text4;
    public final TextView tvDeviceaddress;
    public final TextView tvDevicename;
    public final TextView tvDevicetype;
    public final TextView tvSchoolname;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private DialogInitTipBinding(LinearLayout linearLayout, Button button, Button button2, Button button3, LinearLayout linearLayout2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8) {
        this.rootView = linearLayout;
        this.btnDevicedetail = button;
        this.btnInit = button2;
        this.btnSet = button3;
        this.linMorehelp = linearLayout2;
        this.text1 = textView;
        this.text2 = textView2;
        this.text3 = textView3;
        this.text4 = textView4;
        this.tvDeviceaddress = textView5;
        this.tvDevicename = textView6;
        this.tvDevicetype = textView7;
        this.tvSchoolname = textView8;
    }

    public static DialogInitTipBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogInitTipBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_init_tip, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DialogInitTipBinding bind(View view) {
        int i = R.id.btn_devicedetail;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.btn_init;
            Button button2 = (Button) ViewBindings.findChildViewById(view, i);
            if (button2 != null) {
                i = R.id.btn_set;
                Button button3 = (Button) ViewBindings.findChildViewById(view, i);
                if (button3 != null) {
                    i = R.id.lin_morehelp;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                    if (linearLayout != null) {
                        i = R.id.text1;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView != null) {
                            i = R.id.text2;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView2 != null) {
                                i = R.id.text3;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView3 != null) {
                                    i = R.id.text4;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView4 != null) {
                                        i = R.id.tv_deviceaddress;
                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView5 != null) {
                                            i = R.id.tv_devicename;
                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView6 != null) {
                                                i = R.id.tv_devicetype;
                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView7 != null) {
                                                    i = R.id.tv_schoolname;
                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView8 != null) {
                                                        return new DialogInitTipBinding((LinearLayout) view, button, button2, button3, linearLayout, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8);
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
