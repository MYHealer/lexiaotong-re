package client.android.yixiaotong.v4.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import client.android.yixiaotong.R;
import client.android.yixiaotong.v4.http.bean.V4PaymentMethod;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4PaymentMethodAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private List<V4PaymentMethod> paymentMethods;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public V4PaymentMethodAdapter(Context context, List<V4PaymentMethod> list) {
        this.context = context;
        this.paymentMethods = list;
        this.inflater = LayoutInflater.from(context);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.paymentMethods.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.paymentMethods.get(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = this.inflater.inflate(R.layout.item_payment_method, viewGroup, false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        V4PaymentMethod v4PaymentMethod = this.paymentMethods.get(i);
        viewHolder.ivIcon.setImageResource(v4PaymentMethod.getIconRes());
        viewHolder.tvName.setText(v4PaymentMethod.getName());
        if (v4PaymentMethod.isSelected()) {
            viewHolder.ivSelected.setImageResource(R.drawable.radio_check);
        } else {
            viewHolder.ivSelected.setImageResource(R.drawable.radio_uncheck);
        }
        return view;
    }

    private static class ViewHolder {
        ImageView ivIcon;
        ImageView ivSelected;
        TextView tvName;

        ViewHolder(View view) {
            this.ivIcon = (ImageView) view.findViewById(R.id.iv_icon);
            this.tvName = (TextView) view.findViewById(R.id.tv_name);
            this.ivSelected = (ImageView) view.findViewById(R.id.iv_selected);
        }
    }

    public void setSelectedPosition(int i) {
        int i2 = 0;
        while (i2 < this.paymentMethods.size()) {
            this.paymentMethods.get(i2).setSelected(i2 == i);
            i2++;
        }
        notifyDataSetChanged();
    }

    public V4PaymentMethod getSelectedPaymentMethod() {
        for (V4PaymentMethod v4PaymentMethod : this.paymentMethods) {
            if (v4PaymentMethod.isSelected()) {
                return v4PaymentMethod;
            }
        }
        return null;
    }

    public int getSelectedPosition() {
        for (int i = 0; i < this.paymentMethods.size(); i++) {
            if (this.paymentMethods.get(i).isSelected()) {
                return i;
            }
        }
        return -1;
    }
}
