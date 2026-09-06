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
public final class ActivityHamamInitBinding implements ViewBinding {
    public final Button btnFinish;
    public final EditText etAnzhuangAddress;
    public final TextView initTvBingRoom;
    public final ImageView ivArrow101;
    public final RelativeLayout relAddress;
    public final RelativeLayout relCount;
    public final RelativeLayout relName;
    public final RelativeLayout rlBindHamam;
    private final LinearLayout rootView;
    public final TitleBar titleBar;
    public final TextView tvChooseHamam;
    public final EditText tvConnectCount;
    public final EditText tvDeviceName;
    public final TextView tvDeviceType;
    public final TextView tvDevicenametext;
    public final TextView tvOwner;
    public final TextView tvScholl;
    public final TextView tvSchoolnametext;
    public final TextView vEtAnzhuangAddressTitle;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityHamamInitBinding(LinearLayout linearLayout, Button button, EditText editText, TextView textView, ImageView imageView, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, TitleBar titleBar, TextView textView2, EditText editText2, EditText editText3, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8) {
        this.rootView = linearLayout;
        this.btnFinish = button;
        this.etAnzhuangAddress = editText;
        this.initTvBingRoom = textView;
        this.ivArrow101 = imageView;
        this.relAddress = relativeLayout;
        this.relCount = relativeLayout2;
        this.relName = relativeLayout3;
        this.rlBindHamam = relativeLayout4;
        this.titleBar = titleBar;
        this.tvChooseHamam = textView2;
        this.tvConnectCount = editText2;
        this.tvDeviceName = editText3;
        this.tvDeviceType = textView3;
        this.tvDevicenametext = textView4;
        this.tvOwner = textView5;
        this.tvScholl = textView6;
        this.tvSchoolnametext = textView7;
        this.vEtAnzhuangAddressTitle = textView8;
    }

    public static ActivityHamamInitBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityHamamInitBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_hamam_init, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityHamamInitBinding bind(View view) {
        int i = R.id.btn_finish;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.et_anzhuang_address;
            EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
            if (editText != null) {
                i = R.id.init_tv_bing_room;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.iv_arrow101;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView != null) {
                        i = R.id.rel_address;
                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                        if (relativeLayout != null) {
                            i = R.id.rel_count;
                            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                            if (relativeLayout2 != null) {
                                i = R.id.rel_name;
                                RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                if (relativeLayout3 != null) {
                                    i = R.id.rl_bind_hamam;
                                    RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                    if (relativeLayout4 != null) {
                                        i = R.id.titleBar;
                                        TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                                        if (titleBar != null) {
                                            i = R.id.tv_choose_hamam;
                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView2 != null) {
                                                i = R.id.tv_connect_count;
                                                EditText editText2 = (EditText) ViewBindings.findChildViewById(view, i);
                                                if (editText2 != null) {
                                                    i = R.id.tv_device_name;
                                                    EditText editText3 = (EditText) ViewBindings.findChildViewById(view, i);
                                                    if (editText3 != null) {
                                                        i = R.id.tv_device_type;
                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView3 != null) {
                                                            i = R.id.tv_devicenametext;
                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView4 != null) {
                                                                i = R.id.tv_owner;
                                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView5 != null) {
                                                                    i = R.id.tv_scholl;
                                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView6 != null) {
                                                                        i = R.id.tv_schoolnametext;
                                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView7 != null) {
                                                                            i = R.id.v_et_anzhuang_address_title;
                                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                            if (textView8 != null) {
                                                                                return new ActivityHamamInitBinding((LinearLayout) view, button, editText, textView, imageView, relativeLayout, relativeLayout2, relativeLayout3, relativeLayout4, titleBar, textView2, editText2, editText3, textView3, textView4, textView5, textView6, textView7, textView8);
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
