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
public final class ActivityBluetoothListBinding implements ViewBinding {
    public final ImageView imgRefresh;
    public final LinearLayout linAddress;
    public final ListView recyclerView;
    public final RelativeLayout relArea1;
    public final RelativeLayout relArea2;
    public final RelativeLayout relArea3;
    public final RelativeLayout relArea4;
    public final RelativeLayout relAreadevice;
    public final RelativeLayout relNeardevice;
    private final LinearLayout rootView;
    public final TitleBar titleBar;
    public final TextView tvArea1;
    public final TextView tvArea2;
    public final TextView tvArea3;
    public final TextView tvArea4;
    public final TextView tvAreatext;
    public final TextView tvAreatext1;
    public final TextView tvAreatext2;
    public final TextView tvAreatext3;
    public final TextView tvAreatext4;
    public final TextView tvNeartext;
    public final TextView tvScantip;
    public final View vLineleft;
    public final View vLineright;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityBluetoothListBinding(LinearLayout linearLayout, ImageView imageView, LinearLayout linearLayout2, ListView listView, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, RelativeLayout relativeLayout5, RelativeLayout relativeLayout6, TitleBar titleBar, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, View view, View view2) {
        this.rootView = linearLayout;
        this.imgRefresh = imageView;
        this.linAddress = linearLayout2;
        this.recyclerView = listView;
        this.relArea1 = relativeLayout;
        this.relArea2 = relativeLayout2;
        this.relArea3 = relativeLayout3;
        this.relArea4 = relativeLayout4;
        this.relAreadevice = relativeLayout5;
        this.relNeardevice = relativeLayout6;
        this.titleBar = titleBar;
        this.tvArea1 = textView;
        this.tvArea2 = textView2;
        this.tvArea3 = textView3;
        this.tvArea4 = textView4;
        this.tvAreatext = textView5;
        this.tvAreatext1 = textView6;
        this.tvAreatext2 = textView7;
        this.tvAreatext3 = textView8;
        this.tvAreatext4 = textView9;
        this.tvNeartext = textView10;
        this.tvScantip = textView11;
        this.vLineleft = view;
        this.vLineright = view2;
    }

    public static ActivityBluetoothListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityBluetoothListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_bluetooth_list, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityBluetoothListBinding bind(View view) {
        View viewFindChildViewById;
        View viewFindChildViewById2;
        int i = R.id.img_refresh;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.lin_address;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                i = R.id.recycler_view;
                ListView listView = (ListView) ViewBindings.findChildViewById(view, i);
                if (listView != null) {
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
                                    i = R.id.rel_areadevice;
                                    RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                    if (relativeLayout5 != null) {
                                        i = R.id.rel_neardevice;
                                        RelativeLayout relativeLayout6 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                        if (relativeLayout6 != null) {
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
                                                                i = R.id.tv_areatext;
                                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView5 != null) {
                                                                    i = R.id.tv_areatext1;
                                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView6 != null) {
                                                                        i = R.id.tv_areatext2;
                                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView7 != null) {
                                                                            i = R.id.tv_areatext3;
                                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                            if (textView8 != null) {
                                                                                i = R.id.tv_areatext4;
                                                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                if (textView9 != null) {
                                                                                    i = R.id.tv_neartext;
                                                                                    TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                    if (textView10 != null) {
                                                                                        i = R.id.tv_scantip;
                                                                                        TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                        if (textView11 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.v_lineleft))) != null && (viewFindChildViewById2 = ViewBindings.findChildViewById(view, (i = R.id.v_lineright))) != null) {
                                                                                            return new ActivityBluetoothListBinding((LinearLayout) view, imageView, linearLayout, listView, relativeLayout, relativeLayout2, relativeLayout3, relativeLayout4, relativeLayout5, relativeLayout6, titleBar, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, viewFindChildViewById, viewFindChildViewById2);
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
