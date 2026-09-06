package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
public final class ActivityV4UserInfoBinding implements ViewBinding {
    public final RelativeLayout flContainer;
    public final ImageView img1;
    public final ImageView img2;
    public final ImageView img3;
    public final ImageView img4;
    public final ImageView ivIcon;
    public final RelativeLayout relName;
    public final RelativeLayout relNo;
    public final RelativeLayout relSex;
    private final LinearLayout rootView;
    public final TitleBar titleBar;
    public final TextView tvAdvname;
    public final TextView tvArea;
    public final TextView tvAreatext;
    public final EditText tvName;
    public final TextView tvNametext;
    public final TextView tvSex;
    public final TextView tvSextext;
    public final EditText tvStudentno;
    public final TextView tvStudentnotext;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityV4UserInfoBinding(LinearLayout linearLayout, RelativeLayout relativeLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, TitleBar titleBar, TextView textView, TextView textView2, TextView textView3, EditText editText, TextView textView4, TextView textView5, TextView textView6, EditText editText2, TextView textView7) {
        this.rootView = linearLayout;
        this.flContainer = relativeLayout;
        this.img1 = imageView;
        this.img2 = imageView2;
        this.img3 = imageView3;
        this.img4 = imageView4;
        this.ivIcon = imageView5;
        this.relName = relativeLayout2;
        this.relNo = relativeLayout3;
        this.relSex = relativeLayout4;
        this.titleBar = titleBar;
        this.tvAdvname = textView;
        this.tvArea = textView2;
        this.tvAreatext = textView3;
        this.tvName = editText;
        this.tvNametext = textView4;
        this.tvSex = textView5;
        this.tvSextext = textView6;
        this.tvStudentno = editText2;
        this.tvStudentnotext = textView7;
    }

    public static ActivityV4UserInfoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityV4UserInfoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_v4_user_info, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityV4UserInfoBinding bind(View view) {
        int i = R.id.flContainer;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
        if (relativeLayout != null) {
            i = R.id.img1;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.img2;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView2 != null) {
                    i = R.id.img3;
                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView3 != null) {
                        i = R.id.img4;
                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView4 != null) {
                            i = R.id.iv_icon;
                            ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView5 != null) {
                                i = R.id.rel_name;
                                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                if (relativeLayout2 != null) {
                                    i = R.id.rel_no;
                                    RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                    if (relativeLayout3 != null) {
                                        i = R.id.rel_sex;
                                        RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                        if (relativeLayout4 != null) {
                                            i = R.id.titleBar;
                                            TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                                            if (titleBar != null) {
                                                i = R.id.tv_advname;
                                                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView != null) {
                                                    i = R.id.tv_area;
                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView2 != null) {
                                                        i = R.id.tv_areatext;
                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView3 != null) {
                                                            i = R.id.tv_name;
                                                            EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
                                                            if (editText != null) {
                                                                i = R.id.tv_nametext;
                                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView4 != null) {
                                                                    i = R.id.tv_sex;
                                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView5 != null) {
                                                                        i = R.id.tv_sextext;
                                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView6 != null) {
                                                                            i = R.id.tv_studentno;
                                                                            EditText editText2 = (EditText) ViewBindings.findChildViewById(view, i);
                                                                            if (editText2 != null) {
                                                                                i = R.id.tv_studentnotext;
                                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                if (textView7 != null) {
                                                                                    return new ActivityV4UserInfoBinding((LinearLayout) view, relativeLayout, imageView, imageView2, imageView3, imageView4, imageView5, relativeLayout2, relativeLayout3, relativeLayout4, titleBar, textView, textView2, textView3, editText, textView4, textView5, textView6, editText2, textView7);
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
