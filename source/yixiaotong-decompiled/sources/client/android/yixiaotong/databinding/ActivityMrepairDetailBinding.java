package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager.widget.ViewPager;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityMrepairDetailBinding implements ViewBinding {
    public final Button btnComfirm;
    public final Button btnIgnored;
    public final GridView gridimg;
    public final RelativeLayout lin;
    public final LinearLayout linRepairdetail;
    public final LinearLayout llContainer;
    private final RelativeLayout rootView;
    public final TitleBar titlebar;
    public final TextView tvAddress;
    public final TextView tvDetail;
    public final TextView tvDevice;
    public final TextView tvDeviceid;
    public final TextView tvDevicestate;
    public final TextView tvId;
    public final TextView tvPhone;
    public final TextView tvRepairid;
    public final TextView tvRepairstate;
    public final TextView tvRepairtime;
    public final TextView tvTime;
    public final ViewPager viewpager;

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    private ActivityMrepairDetailBinding(RelativeLayout relativeLayout, Button button, Button button2, GridView gridView, RelativeLayout relativeLayout2, LinearLayout linearLayout, LinearLayout linearLayout2, TitleBar titleBar, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, ViewPager viewPager) {
        this.rootView = relativeLayout;
        this.btnComfirm = button;
        this.btnIgnored = button2;
        this.gridimg = gridView;
        this.lin = relativeLayout2;
        this.linRepairdetail = linearLayout;
        this.llContainer = linearLayout2;
        this.titlebar = titleBar;
        this.tvAddress = textView;
        this.tvDetail = textView2;
        this.tvDevice = textView3;
        this.tvDeviceid = textView4;
        this.tvDevicestate = textView5;
        this.tvId = textView6;
        this.tvPhone = textView7;
        this.tvRepairid = textView8;
        this.tvRepairstate = textView9;
        this.tvRepairtime = textView10;
        this.tvTime = textView11;
        this.viewpager = viewPager;
    }

    public static ActivityMrepairDetailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityMrepairDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_mrepair_detail, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityMrepairDetailBinding bind(View view) {
        int i = R.id.btn_comfirm;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.btn_ignored;
            Button button2 = (Button) ViewBindings.findChildViewById(view, i);
            if (button2 != null) {
                i = R.id.gridimg;
                GridView gridView = (GridView) ViewBindings.findChildViewById(view, i);
                if (gridView != null) {
                    i = R.id.lin;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                    if (relativeLayout != null) {
                        i = R.id.lin_repairdetail;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                        if (linearLayout != null) {
                            i = R.id.ll_container;
                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                            if (linearLayout2 != null) {
                                i = R.id.titlebar;
                                TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                                if (titleBar != null) {
                                    i = R.id.tv_address;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView != null) {
                                        i = R.id.tv_detail;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView2 != null) {
                                            i = R.id.tv_device;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView3 != null) {
                                                i = R.id.tv_deviceid;
                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView4 != null) {
                                                    i = R.id.tv_devicestate;
                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView5 != null) {
                                                        i = R.id.tv_id;
                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView6 != null) {
                                                            i = R.id.tv_phone;
                                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView7 != null) {
                                                                i = R.id.tv_repairid;
                                                                TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView8 != null) {
                                                                    i = R.id.tv_repairstate;
                                                                    TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView9 != null) {
                                                                        i = R.id.tv_repairtime;
                                                                        TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView10 != null) {
                                                                            i = R.id.tv_time;
                                                                            TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                            if (textView11 != null) {
                                                                                i = R.id.viewpager;
                                                                                ViewPager viewPager = (ViewPager) ViewBindings.findChildViewById(view, i);
                                                                                if (viewPager != null) {
                                                                                    return new ActivityMrepairDetailBinding((RelativeLayout) view, button, button2, gridView, relativeLayout, linearLayout, linearLayout2, titleBar, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, viewPager);
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
