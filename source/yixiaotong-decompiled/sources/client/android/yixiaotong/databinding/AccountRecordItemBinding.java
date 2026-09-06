package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class AccountRecordItemBinding implements ViewBinding {
    public final ImageView ivItemLine;
    public final LinearLayout llDetailLayout;
    public final RelativeLayout llRecordDetailBottom;
    public final RelativeLayout rlDetail;
    private final LinearLayout rootView;
    public final TextView tvItemButtomTime;
    public final TextView tvItemTime;
    public final TextView tvRecordDetailAmount;
    public final TextView tvRecordDetailDevice;
    public final TextView tvRecordOfflineCount;
    public final TextView tvRecordType;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private AccountRecordItemBinding(LinearLayout linearLayout, ImageView imageView, LinearLayout linearLayout2, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        this.rootView = linearLayout;
        this.ivItemLine = imageView;
        this.llDetailLayout = linearLayout2;
        this.llRecordDetailBottom = relativeLayout;
        this.rlDetail = relativeLayout2;
        this.tvItemButtomTime = textView;
        this.tvItemTime = textView2;
        this.tvRecordDetailAmount = textView3;
        this.tvRecordDetailDevice = textView4;
        this.tvRecordOfflineCount = textView5;
        this.tvRecordType = textView6;
    }

    public static AccountRecordItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static AccountRecordItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.account_record_item, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static AccountRecordItemBinding bind(View view) {
        int i = R.id.iv_item_line;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.ll_detail_layout;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                i = R.id.ll_record_detail_bottom;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                if (relativeLayout != null) {
                    i = R.id.rl_detail;
                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                    if (relativeLayout2 != null) {
                        i = R.id.tv_item_buttom_time;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView != null) {
                            i = R.id.tv_item_time;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView2 != null) {
                                i = R.id.tv_record_detail_amount;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView3 != null) {
                                    i = R.id.tv_record_detail_device;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView4 != null) {
                                        i = R.id.tv_record_offline_count;
                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView5 != null) {
                                            i = R.id.tv_record_type;
                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView6 != null) {
                                                return new AccountRecordItemBinding((LinearLayout) view, imageView, linearLayout, relativeLayout, relativeLayout2, textView, textView2, textView3, textView4, textView5, textView6);
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
