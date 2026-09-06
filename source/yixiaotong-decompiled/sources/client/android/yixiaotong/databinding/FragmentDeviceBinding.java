package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class FragmentDeviceBinding implements ViewBinding {
    public final ImageView img;
    public final ImageView img2;
    public final ImageView imgRefresh;
    public final ImageView imgReset;
    public final LinearLayout linDevice;
    public final LinearLayout linRefund;
    public final ListView recyclerView;
    public final RelativeLayout rel;
    public final RelativeLayout relQuyu;
    private final LinearLayout rootView;
    public final TitleBar tbName;
    public final TextView tvBalance;
    public final TextView tvBalancetext;
    public final TextView tvContent;
    public final TextView tvContent2;
    public final TextView tvDate;
    public final TextView tvDate2;
    public final TextView tvDate3;
    public final TextView tvQuyu;
    public final TextView tvSetquyu;
    public final TextView tvText1;
    public final TextView tvText2;
    public final TextView tvText3;
    public final TextView tvTime;
    public final TextView tvTime2;
    public final TextView tvTime3;
    public final View view1;
    public final View view2;
    public final ImageView view3;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private FragmentDeviceBinding(LinearLayout linearLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, LinearLayout linearLayout2, LinearLayout linearLayout3, ListView listView, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, TitleBar titleBar, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, View view, View view2, ImageView imageView5) {
        this.rootView = linearLayout;
        this.img = imageView;
        this.img2 = imageView2;
        this.imgRefresh = imageView3;
        this.imgReset = imageView4;
        this.linDevice = linearLayout2;
        this.linRefund = linearLayout3;
        this.recyclerView = listView;
        this.rel = relativeLayout;
        this.relQuyu = relativeLayout2;
        this.tbName = titleBar;
        this.tvBalance = textView;
        this.tvBalancetext = textView2;
        this.tvContent = textView3;
        this.tvContent2 = textView4;
        this.tvDate = textView5;
        this.tvDate2 = textView6;
        this.tvDate3 = textView7;
        this.tvQuyu = textView8;
        this.tvSetquyu = textView9;
        this.tvText1 = textView10;
        this.tvText2 = textView11;
        this.tvText3 = textView12;
        this.tvTime = textView13;
        this.tvTime2 = textView14;
        this.tvTime3 = textView15;
        this.view1 = view;
        this.view2 = view2;
        this.view3 = imageView5;
    }

    public static FragmentDeviceBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentDeviceBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_device, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentDeviceBinding bind(View view) {
        View viewFindChildViewById;
        View viewFindChildViewById2;
        int i = R.id.img;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.img2;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                i = R.id.img_refresh;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView3 != null) {
                    i = R.id.img_reset;
                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView4 != null) {
                        i = R.id.lin_device;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                        if (linearLayout != null) {
                            i = R.id.lin_refund;
                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                            if (linearLayout2 != null) {
                                i = R.id.recycler_view;
                                ListView listView = (ListView) ViewBindings.findChildViewById(view, i);
                                if (listView != null) {
                                    i = R.id.rel;
                                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                    if (relativeLayout != null) {
                                        i = R.id.rel_quyu;
                                        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                        if (relativeLayout2 != null) {
                                            i = R.id.tb_name;
                                            TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                                            if (titleBar != null) {
                                                i = R.id.tv_balance;
                                                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView != null) {
                                                    i = R.id.tv_balancetext;
                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView2 != null) {
                                                        i = R.id.tv_content;
                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView3 != null) {
                                                            i = R.id.tv_content2;
                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView4 != null) {
                                                                i = R.id.tv_date;
                                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView5 != null) {
                                                                    i = R.id.tv_date2;
                                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView6 != null) {
                                                                        i = R.id.tv_date3;
                                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView7 != null) {
                                                                            i = R.id.tv_quyu;
                                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                            if (textView8 != null) {
                                                                                i = R.id.tv_setquyu;
                                                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                if (textView9 != null) {
                                                                                    i = R.id.tv_text1;
                                                                                    TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                    if (textView10 != null) {
                                                                                        i = R.id.tv_text2;
                                                                                        TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                        if (textView11 != null) {
                                                                                            i = R.id.tv_text3;
                                                                                            TextView textView12 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                            if (textView12 != null) {
                                                                                                i = R.id.tv_time;
                                                                                                TextView textView13 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                if (textView13 != null) {
                                                                                                    i = R.id.tv_time2;
                                                                                                    TextView textView14 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                    if (textView14 != null) {
                                                                                                        i = R.id.tv_time3;
                                                                                                        TextView textView15 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                        if (textView15 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.view1))) != null && (viewFindChildViewById2 = ViewBindings.findChildViewById(view, (i = R.id.view2))) != null) {
                                                                                                            i = R.id.view3;
                                                                                                            ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                            if (imageView5 != null) {
                                                                                                                return new FragmentDeviceBinding((LinearLayout) view, imageView, imageView2, imageView3, imageView4, linearLayout, linearLayout2, listView, relativeLayout, relativeLayout2, titleBar, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14, textView15, viewFindChildViewById, viewFindChildViewById2, imageView5);
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
