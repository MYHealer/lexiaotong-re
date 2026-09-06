package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class RepairProcessRecordItemBinding implements ViewBinding {
    public final SimpleDraweeView ivHead;
    private final LinearLayout rootView;
    public final TextView tvContent;
    public final TextView tvDate;
    public final TextView tvName;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private RepairProcessRecordItemBinding(LinearLayout linearLayout, SimpleDraweeView simpleDraweeView, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = linearLayout;
        this.ivHead = simpleDraweeView;
        this.tvContent = textView;
        this.tvDate = textView2;
        this.tvName = textView3;
    }

    public static RepairProcessRecordItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static RepairProcessRecordItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.repair_process_record_item, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static RepairProcessRecordItemBinding bind(View view) {
        int i = R.id.iv_head;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) ViewBindings.findChildViewById(view, i);
        if (simpleDraweeView != null) {
            i = R.id.tv_content;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.tv_date;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = R.id.tv_name;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView3 != null) {
                        return new RepairProcessRecordItemBinding((LinearLayout) view, simpleDraweeView, textView, textView2, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
