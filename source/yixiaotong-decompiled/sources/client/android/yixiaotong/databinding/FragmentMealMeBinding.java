package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class FragmentMealMeBinding implements ViewBinding {
    public final SimpleDraweeView ivMeIcon;
    public final RelativeLayout rel;
    public final RelativeLayout relChongzhi;
    public final RelativeLayout relRefund;
    public final RelativeLayout relSetpsw;
    public final RelativeLayout relXiaofei;
    private final LinearLayout rootView;
    public final TitleBar tbName;
    public final EditText tvMeId;
    public final EditText tvMeName;
    public final EditText tvMeXuehao;
    public final RelativeLayout vLlIcon;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private FragmentMealMeBinding(LinearLayout linearLayout, SimpleDraweeView simpleDraweeView, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, RelativeLayout relativeLayout5, TitleBar titleBar, EditText editText, EditText editText2, EditText editText3, RelativeLayout relativeLayout6) {
        this.rootView = linearLayout;
        this.ivMeIcon = simpleDraweeView;
        this.rel = relativeLayout;
        this.relChongzhi = relativeLayout2;
        this.relRefund = relativeLayout3;
        this.relSetpsw = relativeLayout4;
        this.relXiaofei = relativeLayout5;
        this.tbName = titleBar;
        this.tvMeId = editText;
        this.tvMeName = editText2;
        this.tvMeXuehao = editText3;
        this.vLlIcon = relativeLayout6;
    }

    public static FragmentMealMeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentMealMeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_meal_me, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentMealMeBinding bind(View view) {
        int i = R.id.iv_me_icon;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) ViewBindings.findChildViewById(view, i);
        if (simpleDraweeView != null) {
            i = R.id.rel;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
            if (relativeLayout != null) {
                i = R.id.rel_chongzhi;
                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                if (relativeLayout2 != null) {
                    i = R.id.rel_refund;
                    RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                    if (relativeLayout3 != null) {
                        i = R.id.rel_setpsw;
                        RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                        if (relativeLayout4 != null) {
                            i = R.id.rel_xiaofei;
                            RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                            if (relativeLayout5 != null) {
                                i = R.id.tb_name;
                                TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                                if (titleBar != null) {
                                    i = R.id.tv_me_id;
                                    EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
                                    if (editText != null) {
                                        i = R.id.tv_me_name;
                                        EditText editText2 = (EditText) ViewBindings.findChildViewById(view, i);
                                        if (editText2 != null) {
                                            i = R.id.tv_me_xuehao;
                                            EditText editText3 = (EditText) ViewBindings.findChildViewById(view, i);
                                            if (editText3 != null) {
                                                i = R.id.v_ll_icon;
                                                RelativeLayout relativeLayout6 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                if (relativeLayout6 != null) {
                                                    return new FragmentMealMeBinding((LinearLayout) view, simpleDraweeView, relativeLayout, relativeLayout2, relativeLayout3, relativeLayout4, relativeLayout5, titleBar, editText, editText2, editText3, relativeLayout6);
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
