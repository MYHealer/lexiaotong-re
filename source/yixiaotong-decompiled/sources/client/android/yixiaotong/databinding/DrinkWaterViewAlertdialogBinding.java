package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class DrinkWaterViewAlertdialogBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final Button viewAlertdialogButtonCancle;
    public final Button viewAlertdialogButtonNeg;
    public final Button viewAlertdialogButtonPos;
    public final ImageView viewAlertdialogImageviewLeftIcon;
    public final ImageView viewAlertdialogImageviewLine;
    public final ImageView viewAlertdialogImageviewRightIcon;
    public final LinearLayout viewAlertdialogLayoutBg;
    public final LinearLayout viewAlertdialogLayoutFunction;
    public final LinearLayout viewAlertdialogLayoutLeftPanel;
    public final LinearLayout viewAlertdialogLayoutList;
    public final LinearLayout viewAlertdialogLayoutMainview;
    public final LinearLayout viewAlertdialogLayoutRightPanel;
    public final LinearLayout viewAlertdialogLayoutSelectPanel;
    public final LinearLayout viewAlertdialogLayoutTitle;
    public final ScrollView viewAlertdialogScrollviewId;
    public final TextView viewAlertdialogTextviewLeftText;
    public final TextView viewAlertdialogTextviewMsg;
    public final TextView viewAlertdialogTextviewRightText;
    public final TextView viewAlertdialogTextviewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private DrinkWaterViewAlertdialogBinding(LinearLayout linearLayout, Button button, Button button2, Button button3, ImageView imageView, ImageView imageView2, ImageView imageView3, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, LinearLayout linearLayout6, LinearLayout linearLayout7, LinearLayout linearLayout8, LinearLayout linearLayout9, ScrollView scrollView, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.rootView = linearLayout;
        this.viewAlertdialogButtonCancle = button;
        this.viewAlertdialogButtonNeg = button2;
        this.viewAlertdialogButtonPos = button3;
        this.viewAlertdialogImageviewLeftIcon = imageView;
        this.viewAlertdialogImageviewLine = imageView2;
        this.viewAlertdialogImageviewRightIcon = imageView3;
        this.viewAlertdialogLayoutBg = linearLayout2;
        this.viewAlertdialogLayoutFunction = linearLayout3;
        this.viewAlertdialogLayoutLeftPanel = linearLayout4;
        this.viewAlertdialogLayoutList = linearLayout5;
        this.viewAlertdialogLayoutMainview = linearLayout6;
        this.viewAlertdialogLayoutRightPanel = linearLayout7;
        this.viewAlertdialogLayoutSelectPanel = linearLayout8;
        this.viewAlertdialogLayoutTitle = linearLayout9;
        this.viewAlertdialogScrollviewId = scrollView;
        this.viewAlertdialogTextviewLeftText = textView;
        this.viewAlertdialogTextviewMsg = textView2;
        this.viewAlertdialogTextviewRightText = textView3;
        this.viewAlertdialogTextviewTitle = textView4;
    }

    public static DrinkWaterViewAlertdialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DrinkWaterViewAlertdialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.drink_water_view_alertdialog, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DrinkWaterViewAlertdialogBinding bind(View view) {
        int i = R.id.view_alertdialog_button_cancle;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.view_alertdialog_button_neg;
            Button button2 = (Button) ViewBindings.findChildViewById(view, i);
            if (button2 != null) {
                i = R.id.view_alertdialog_button_pos;
                Button button3 = (Button) ViewBindings.findChildViewById(view, i);
                if (button3 != null) {
                    i = R.id.view_alertdialog_imageview_left_icon;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView != null) {
                        i = R.id.view_alertdialog_imageview_line;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView2 != null) {
                            i = R.id.view_alertdialog_imageview_right_icon;
                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView3 != null) {
                                i = R.id.view_alertdialog_layout_bg;
                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                if (linearLayout != null) {
                                    i = R.id.view_alertdialog_layout_function;
                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                    if (linearLayout2 != null) {
                                        i = R.id.view_alertdialog_layout_left_panel;
                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                        if (linearLayout3 != null) {
                                            i = R.id.view_alertdialog_layout_list;
                                            LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                            if (linearLayout4 != null) {
                                                i = R.id.view_alertdialog_layout_mainview;
                                                LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                if (linearLayout5 != null) {
                                                    i = R.id.view_alertdialog_layout_right_panel;
                                                    LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                    if (linearLayout6 != null) {
                                                        i = R.id.view_alertdialog_layout_select_panel;
                                                        LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                        if (linearLayout7 != null) {
                                                            i = R.id.view_alertdialog_layout_title;
                                                            LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                            if (linearLayout8 != null) {
                                                                i = R.id.view_alertdialog_scrollview_id;
                                                                ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(view, i);
                                                                if (scrollView != null) {
                                                                    i = R.id.view_alertdialog_textview_left_text;
                                                                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView != null) {
                                                                        i = R.id.view_alertdialog_textview_msg;
                                                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView2 != null) {
                                                                            i = R.id.view_alertdialog_textview_right_text;
                                                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                            if (textView3 != null) {
                                                                                i = R.id.view_alertdialog_textview_title;
                                                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                if (textView4 != null) {
                                                                                    return new DrinkWaterViewAlertdialogBinding((LinearLayout) view, button, button2, button3, imageView, imageView2, imageView3, linearLayout, linearLayout2, linearLayout3, linearLayout4, linearLayout5, linearLayout6, linearLayout7, linearLayout8, scrollView, textView, textView2, textView3, textView4);
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
