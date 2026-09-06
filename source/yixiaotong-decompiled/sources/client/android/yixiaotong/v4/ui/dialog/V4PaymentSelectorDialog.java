package client.android.yixiaotong.v4.ui.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import client.android.yixiaotong.R;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.v4.http.bean.V4PaymentMethod;
import client.android.yixiaotong.v4.ui.adapter.V4PaymentMethodAdapter;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4PaymentSelectorDialog {
    public static final int TYPE_ALIPAY = 3;
    public static final int TYPE_WALLET = 1;
    public static final int TYPE_WECHAT = 2;
    private V4PaymentMethodAdapter adapter;
    private Context context;
    private Dialog dialog;
    private OnPaymentSelectedListener listener;
    private List<V4PaymentMethod> paymentMethods;

    public interface OnPaymentSelectedListener {
        void onCancel();

        void onPaymentSelected(V4PaymentMethod v4PaymentMethod);
    }

    public void setOnPaymentSelectedListener(OnPaymentSelectedListener onPaymentSelectedListener) {
        this.listener = onPaymentSelectedListener;
    }

    public V4PaymentSelectorDialog(Context context) {
        this.context = context;
        initPaymentMethods();
    }

    private void initPaymentMethods() {
        ArrayList arrayList = new ArrayList();
        this.paymentMethods = arrayList;
        if (arrayList.isEmpty()) {
            return;
        }
        this.paymentMethods.get(0).setSelected(true);
    }

    public void setPaymentMethods(List<V4PaymentMethod> list) {
        this.paymentMethods.clear();
        this.paymentMethods.addAll(list);
        if (this.paymentMethods.isEmpty() || this.adapter == null) {
            return;
        }
        this.paymentMethods.get(0).setSelected(true);
        this.adapter.notifyDataSetChanged();
    }

    public void show() {
        Dialog dialog = this.dialog;
        if (dialog == null || !dialog.isShowing()) {
            createDialog();
            Dialog dialog2 = this.dialog;
            if (dialog2 != null) {
                dialog2.show();
                setDialogWidth();
            }
        }
    }

    private void createDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        View viewInflate = LayoutInflater.from(this.context).inflate(R.layout.dialog_payment_selector, (ViewGroup) null);
        builder.setView(viewInflate);
        initViews(viewInflate);
        AlertDialog alertDialogCreate = builder.create();
        this.dialog = alertDialogCreate;
        alertDialogCreate.setCancelable(true);
        this.dialog.setCanceledOnTouchOutside(true);
        if (this.dialog.getWindow() != null) {
            this.dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
    }

    private void setDialogWidth() {
        Dialog dialog = this.dialog;
        if (dialog == null || dialog.getWindow() == null) {
            return;
        }
        WindowManager.LayoutParams attributes = this.dialog.getWindow().getAttributes();
        attributes.width = (int) (((double) this.context.getResources().getDisplayMetrics().widthPixels) * 0.85d);
        attributes.height = -2;
        this.dialog.getWindow().setAttributes(attributes);
    }

    private void initViews(View view) {
        ListView listView = (ListView) view.findViewById(R.id.lv_payment_methods);
        Button button = (Button) view.findViewById(R.id.btn_cancel);
        Button button2 = (Button) view.findViewById(R.id.btn_confirm);
        V4PaymentMethodAdapter v4PaymentMethodAdapter = new V4PaymentMethodAdapter(this.context, this.paymentMethods);
        this.adapter = v4PaymentMethodAdapter;
        listView.setAdapter((ListAdapter) v4PaymentMethodAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: client.android.yixiaotong.v4.ui.dialog.V4PaymentSelectorDialog.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                V4PaymentSelectorDialog.this.adapter.setSelectedPosition(i);
            }
        });
        button.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.dialog.V4PaymentSelectorDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                V4PaymentSelectorDialog.this.dismiss();
                if (V4PaymentSelectorDialog.this.listener != null) {
                    V4PaymentSelectorDialog.this.listener.onCancel();
                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.dialog.V4PaymentSelectorDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                V4PaymentMethod selectedPaymentMethod = V4PaymentSelectorDialog.this.adapter.getSelectedPaymentMethod();
                if (selectedPaymentMethod == null) {
                    ToastUtils.show(V4PaymentSelectorDialog.this.context, "请选择支付方式");
                    return;
                }
                V4PaymentSelectorDialog.this.dismiss();
                if (V4PaymentSelectorDialog.this.listener != null) {
                    V4PaymentSelectorDialog.this.listener.onPaymentSelected(selectedPaymentMethod);
                }
            }
        });
    }

    public void dismiss() {
        Dialog dialog = this.dialog;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        this.dialog.dismiss();
    }

    public void setDefaultPayment(int i) {
        for (int i2 = 0; i2 < this.paymentMethods.size(); i2++) {
            if (this.paymentMethods.get(i2).getType() == i) {
                this.adapter.setSelectedPosition(i2);
                return;
            }
        }
    }

    public boolean isShowing() {
        Dialog dialog = this.dialog;
        return dialog != null && dialog.isShowing();
    }
}
