package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class WalletGridItemBinding implements ViewBinding {
    public final SimpleDraweeView ivWallet1;
    public final RelativeLayout llWallet1;
    private final LinearLayout rootView;
    public final TextView tvWallet1Amount;
    public final TextView tvWallet1Name;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private WalletGridItemBinding(LinearLayout linearLayout, SimpleDraweeView simpleDraweeView, RelativeLayout relativeLayout, TextView textView, TextView textView2) {
        this.rootView = linearLayout;
        this.ivWallet1 = simpleDraweeView;
        this.llWallet1 = relativeLayout;
        this.tvWallet1Amount = textView;
        this.tvWallet1Name = textView2;
    }

    public static WalletGridItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static WalletGridItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.wallet_grid_item, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static WalletGridItemBinding bind(View view) {
        int i = R.id.iv_wallet1;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) ViewBindings.findChildViewById(view, i);
        if (simpleDraweeView != null) {
            i = R.id.ll_wallet1;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
            if (relativeLayout != null) {
                i = R.id.tv_wallet1_amount;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.tv_wallet1_name;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        return new WalletGridItemBinding((LinearLayout) view, simpleDraweeView, relativeLayout, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
