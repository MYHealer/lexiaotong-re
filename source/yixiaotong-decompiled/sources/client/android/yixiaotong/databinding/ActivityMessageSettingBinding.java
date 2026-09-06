package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityMessageSettingBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final CheckBox vRbtMessageRemind;
    public final CheckBox vRbtSound;
    public final CheckBox vRbtVibrate;
    public final TitleBar vTitleBar;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityMessageSettingBinding(LinearLayout linearLayout, CheckBox checkBox, CheckBox checkBox2, CheckBox checkBox3, TitleBar titleBar) {
        this.rootView = linearLayout;
        this.vRbtMessageRemind = checkBox;
        this.vRbtSound = checkBox2;
        this.vRbtVibrate = checkBox3;
        this.vTitleBar = titleBar;
    }

    public static ActivityMessageSettingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityMessageSettingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_message_setting, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityMessageSettingBinding bind(View view) {
        int i = R.id.v_rbt_message_remind;
        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, i);
        if (checkBox != null) {
            i = R.id.v_rbt_sound;
            CheckBox checkBox2 = (CheckBox) ViewBindings.findChildViewById(view, i);
            if (checkBox2 != null) {
                i = R.id.v_rbt_vibrate;
                CheckBox checkBox3 = (CheckBox) ViewBindings.findChildViewById(view, i);
                if (checkBox3 != null) {
                    i = R.id.v_titleBar;
                    TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                    if (titleBar != null) {
                        return new ActivityMessageSettingBinding((LinearLayout) view, checkBox, checkBox2, checkBox3, titleBar);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
