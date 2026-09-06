package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class AppointmentAreaItemBinding implements ViewBinding {
    public final TextView name;
    private final RelativeLayout rootView;
    public final View vLine;

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    private AppointmentAreaItemBinding(RelativeLayout relativeLayout, TextView textView, View view) {
        this.rootView = relativeLayout;
        this.name = textView;
        this.vLine = view;
    }

    public static AppointmentAreaItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static AppointmentAreaItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.appointment_area_item, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static AppointmentAreaItemBinding bind(View view) {
        View viewFindChildViewById;
        int i = R.id.name;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.v_line))) != null) {
            return new AppointmentAreaItemBinding((RelativeLayout) view, textView, viewFindChildViewById);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
