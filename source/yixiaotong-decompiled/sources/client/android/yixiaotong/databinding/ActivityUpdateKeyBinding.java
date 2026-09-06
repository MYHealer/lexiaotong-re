package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityUpdateKeyBinding implements ViewBinding {
    public final Button btnUpdatekey;
    public final EditText et1;
    public final EditText et10;
    public final EditText et100;
    public final EditText et11;
    public final EditText et2;
    public final EditText et22;
    public final EditText et5;
    public final EditText et55;
    public final EditText et6;
    public final EditText et66;
    public final EditText et7;
    public final EditText et77;
    public final EditText et8;
    public final EditText et88;
    public final EditText et9;
    public final EditText et99;
    public final LinearLayout lin;
    public final LinearLayout lin2;
    public final View line;
    private final RelativeLayout rootView;
    public final ScrollView scrollview;
    public final TitleBar titlebar;
    public final TextView tvHelp;
    public final TextView tvText1;
    public final TextView tvText3;
    public final TextView tvText4;
    public final TextView tvText44;
    public final TextView tvText5;

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    private ActivityUpdateKeyBinding(RelativeLayout relativeLayout, Button button, EditText editText, EditText editText2, EditText editText3, EditText editText4, EditText editText5, EditText editText6, EditText editText7, EditText editText8, EditText editText9, EditText editText10, EditText editText11, EditText editText12, EditText editText13, EditText editText14, EditText editText15, EditText editText16, LinearLayout linearLayout, LinearLayout linearLayout2, View view, ScrollView scrollView, TitleBar titleBar, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        this.rootView = relativeLayout;
        this.btnUpdatekey = button;
        this.et1 = editText;
        this.et10 = editText2;
        this.et100 = editText3;
        this.et11 = editText4;
        this.et2 = editText5;
        this.et22 = editText6;
        this.et5 = editText7;
        this.et55 = editText8;
        this.et6 = editText9;
        this.et66 = editText10;
        this.et7 = editText11;
        this.et77 = editText12;
        this.et8 = editText13;
        this.et88 = editText14;
        this.et9 = editText15;
        this.et99 = editText16;
        this.lin = linearLayout;
        this.lin2 = linearLayout2;
        this.line = view;
        this.scrollview = scrollView;
        this.titlebar = titleBar;
        this.tvHelp = textView;
        this.tvText1 = textView2;
        this.tvText3 = textView3;
        this.tvText4 = textView4;
        this.tvText44 = textView5;
        this.tvText5 = textView6;
    }

    public static ActivityUpdateKeyBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityUpdateKeyBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_update_key, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityUpdateKeyBinding bind(View view) {
        View viewFindChildViewById;
        int i = R.id.btn_updatekey;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.et1;
            EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
            if (editText != null) {
                i = R.id.et10;
                EditText editText2 = (EditText) ViewBindings.findChildViewById(view, i);
                if (editText2 != null) {
                    i = R.id.et100;
                    EditText editText3 = (EditText) ViewBindings.findChildViewById(view, i);
                    if (editText3 != null) {
                        i = R.id.et11;
                        EditText editText4 = (EditText) ViewBindings.findChildViewById(view, i);
                        if (editText4 != null) {
                            i = R.id.et2;
                            EditText editText5 = (EditText) ViewBindings.findChildViewById(view, i);
                            if (editText5 != null) {
                                i = R.id.et22;
                                EditText editText6 = (EditText) ViewBindings.findChildViewById(view, i);
                                if (editText6 != null) {
                                    i = R.id.et5;
                                    EditText editText7 = (EditText) ViewBindings.findChildViewById(view, i);
                                    if (editText7 != null) {
                                        i = R.id.et55;
                                        EditText editText8 = (EditText) ViewBindings.findChildViewById(view, i);
                                        if (editText8 != null) {
                                            i = R.id.et6;
                                            EditText editText9 = (EditText) ViewBindings.findChildViewById(view, i);
                                            if (editText9 != null) {
                                                i = R.id.et66;
                                                EditText editText10 = (EditText) ViewBindings.findChildViewById(view, i);
                                                if (editText10 != null) {
                                                    i = R.id.et7;
                                                    EditText editText11 = (EditText) ViewBindings.findChildViewById(view, i);
                                                    if (editText11 != null) {
                                                        i = R.id.et77;
                                                        EditText editText12 = (EditText) ViewBindings.findChildViewById(view, i);
                                                        if (editText12 != null) {
                                                            i = R.id.et8;
                                                            EditText editText13 = (EditText) ViewBindings.findChildViewById(view, i);
                                                            if (editText13 != null) {
                                                                i = R.id.et88;
                                                                EditText editText14 = (EditText) ViewBindings.findChildViewById(view, i);
                                                                if (editText14 != null) {
                                                                    i = R.id.et9;
                                                                    EditText editText15 = (EditText) ViewBindings.findChildViewById(view, i);
                                                                    if (editText15 != null) {
                                                                        i = R.id.et99;
                                                                        EditText editText16 = (EditText) ViewBindings.findChildViewById(view, i);
                                                                        if (editText16 != null) {
                                                                            i = R.id.lin;
                                                                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                            if (linearLayout != null) {
                                                                                i = R.id.lin2;
                                                                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                if (linearLayout2 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.line))) != null) {
                                                                                    i = R.id.scrollview;
                                                                                    ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(view, i);
                                                                                    if (scrollView != null) {
                                                                                        i = R.id.titlebar;
                                                                                        TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                                                                                        if (titleBar != null) {
                                                                                            i = R.id.tv_help;
                                                                                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                            if (textView != null) {
                                                                                                i = R.id.tv_text1;
                                                                                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                if (textView2 != null) {
                                                                                                    i = R.id.tv_text3;
                                                                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                    if (textView3 != null) {
                                                                                                        i = R.id.tv_text4;
                                                                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                        if (textView4 != null) {
                                                                                                            i = R.id.tv_text44;
                                                                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                            if (textView5 != null) {
                                                                                                                i = R.id.tv_text5;
                                                                                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                if (textView6 != null) {
                                                                                                                    return new ActivityUpdateKeyBinding((RelativeLayout) view, button, editText, editText2, editText3, editText4, editText5, editText6, editText7, editText8, editText9, editText10, editText11, editText12, editText13, editText14, editText15, editText16, linearLayout, linearLayout2, viewFindChildViewById, scrollView, titleBar, textView, textView2, textView3, textView4, textView5, textView6);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
