package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class WashRecordListItemBinding implements ViewBinding {
    public final ImageView img;
    public final RelativeLayout lin;
    public final View line1;
    private final RelativeLayout rootView;
    public final TextView tvChongzhistate;
    public final TextView tvDatetime;
    public final TextView tvMoney;
    public final TextView tvXiaofei;

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    private WashRecordListItemBinding(RelativeLayout relativeLayout, ImageView imageView, RelativeLayout relativeLayout2, View view, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.rootView = relativeLayout;
        this.img = imageView;
        this.lin = relativeLayout2;
        this.line1 = view;
        this.tvChongzhistate = textView;
        this.tvDatetime = textView2;
        this.tvMoney = textView3;
        this.tvXiaofei = textView4;
    }

    public static WashRecordListItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static WashRecordListItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.wash_record_list_item, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static WashRecordListItemBinding bind(View view) {
        int i = R.id.img;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            RelativeLayout relativeLayout = (RelativeLayout) view;
            i = R.id.line1;
            View viewFindChildViewById = ViewBindings.findChildViewById(view, i);
            if (viewFindChildViewById != null) {
                i = R.id.tv_chongzhistate;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.tv_datetime;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = R.id.tv_money;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView3 != null) {
                            i = R.id.tv_xiaofei;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView4 != null) {
                                return new WashRecordListItemBinding(relativeLayout, imageView, relativeLayout, viewFindChildViewById, textView, textView2, textView3, textView4);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
