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
public final class ActivityAddKeyBinding implements ViewBinding {
    public final Button btnSetkey;
    public final EditText et1;
    public final EditText et10;
    public final EditText et2;
    public final EditText et5;
    public final EditText et6;
    public final EditText et7;
    public final EditText et8;
    public final EditText et9;
    public final EditText etName;
    public final LinearLayout lin;
    public final RelativeLayout rel;
    public final RelativeLayout rel2;
    private final RelativeLayout rootView;
    public final ScrollView srrollview;
    public final TitleBar titlebar;
    public final TextView tvHelp;
    public final TextView tvText1;
    public final TextView tvText2;
    public final TextView tvText3;
    public final TextView tvText4;
    public final TextView tvText5;
    public final TextView tvText6;

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    private ActivityAddKeyBinding(RelativeLayout relativeLayout, Button button, EditText editText, EditText editText2, EditText editText3, EditText editText4, EditText editText5, EditText editText6, EditText editText7, EditText editText8, EditText editText9, LinearLayout linearLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, ScrollView scrollView, TitleBar titleBar, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7) {
        this.rootView = relativeLayout;
        this.btnSetkey = button;
        this.et1 = editText;
        this.et10 = editText2;
        this.et2 = editText3;
        this.et5 = editText4;
        this.et6 = editText5;
        this.et7 = editText6;
        this.et8 = editText7;
        this.et9 = editText8;
        this.etName = editText9;
        this.lin = linearLayout;
        this.rel = relativeLayout2;
        this.rel2 = relativeLayout3;
        this.srrollview = scrollView;
        this.titlebar = titleBar;
        this.tvHelp = textView;
        this.tvText1 = textView2;
        this.tvText2 = textView3;
        this.tvText3 = textView4;
        this.tvText4 = textView5;
        this.tvText5 = textView6;
        this.tvText6 = textView7;
    }

    public static ActivityAddKeyBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityAddKeyBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_add_key, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityAddKeyBinding bind(View view) {
        int i = R.id.btn_setkey;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.et1;
            EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
            if (editText != null) {
                i = R.id.et10;
                EditText editText2 = (EditText) ViewBindings.findChildViewById(view, i);
                if (editText2 != null) {
                    i = R.id.et2;
                    EditText editText3 = (EditText) ViewBindings.findChildViewById(view, i);
                    if (editText3 != null) {
                        i = R.id.et5;
                        EditText editText4 = (EditText) ViewBindings.findChildViewById(view, i);
                        if (editText4 != null) {
                            i = R.id.et6;
                            EditText editText5 = (EditText) ViewBindings.findChildViewById(view, i);
                            if (editText5 != null) {
                                i = R.id.et7;
                                EditText editText6 = (EditText) ViewBindings.findChildViewById(view, i);
                                if (editText6 != null) {
                                    i = R.id.et8;
                                    EditText editText7 = (EditText) ViewBindings.findChildViewById(view, i);
                                    if (editText7 != null) {
                                        i = R.id.et9;
                                        EditText editText8 = (EditText) ViewBindings.findChildViewById(view, i);
                                        if (editText8 != null) {
                                            i = R.id.et_name;
                                            EditText editText9 = (EditText) ViewBindings.findChildViewById(view, i);
                                            if (editText9 != null) {
                                                i = R.id.lin;
                                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                if (linearLayout != null) {
                                                    i = R.id.rel;
                                                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                    if (relativeLayout != null) {
                                                        i = R.id.rel2;
                                                        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                        if (relativeLayout2 != null) {
                                                            i = R.id.srrollview;
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
                                                                            i = R.id.tv_text2;
                                                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                            if (textView3 != null) {
                                                                                i = R.id.tv_text3;
                                                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                if (textView4 != null) {
                                                                                    i = R.id.tv_text4;
                                                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                    if (textView5 != null) {
                                                                                        i = R.id.tv_text5;
                                                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                        if (textView6 != null) {
                                                                                            i = R.id.tv_text6;
                                                                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                            if (textView7 != null) {
                                                                                                return new ActivityAddKeyBinding((RelativeLayout) view, button, editText, editText2, editText3, editText4, editText5, editText6, editText7, editText8, editText9, linearLayout, relativeLayout, relativeLayout2, scrollView, titleBar, textView, textView2, textView3, textView4, textView5, textView6, textView7);
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
