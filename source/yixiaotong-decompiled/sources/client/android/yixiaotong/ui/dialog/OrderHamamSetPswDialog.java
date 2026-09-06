package client.android.yixiaotong.ui.dialog;

import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import client.android.yixiaotong.R;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class OrderHamamSetPswDialog extends BaseDialog {
    private Activity mActivity;
    private Listener mListener;

    public interface Listener {
        void onComfirt(String str);
    }

    private OrderHamamSetPswDialog() {
    }

    private static final class SigleHolder {
        public static final OrderHamamSetPswDialog INSTANCE = new OrderHamamSetPswDialog();

        private SigleHolder() {
        }
    }

    public static OrderHamamSetPswDialog getInstance() {
        return SigleHolder.INSTANCE;
    }

    public void showDialog(Activity activity, Listener listener) {
        this.mActivity = activity;
        this.mListener = listener;
        View viewInflate = activity.getLayoutInflater().inflate(R.layout.dialog_setpsw_layout, (ViewGroup) null);
        final EditText editText = (EditText) viewInflate.findViewById(R.id.et_psw1);
        final EditText editText2 = (EditText) viewInflate.findViewById(R.id.et_psw2);
        final Button button = (Button) viewInflate.findViewById(R.id.btn_next);
        showTipDialog(this.mActivity, viewInflate);
        editText.addTextChangedListener(new TextWatcher() { // from class: client.android.yixiaotong.ui.dialog.OrderHamamSetPswDialog.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (!StringUtils.isNotEmpty(editable.toString()) || editable.toString().length() < 6 || !StringUtils.isNotEmpty(editText2.getText().toString()) || editText2.getText().toString().length() < 6) {
                    button.setBackground(OrderHamamSetPswDialog.this.mActivity.getResources().getDrawable(R.drawable.round_radius_button_background));
                    button.setText("下一步");
                    button.setTextColor(OrderHamamSetPswDialog.this.mActivity.getResources().getColor(R.color.ff008AFF));
                } else {
                    button.setBackground(OrderHamamSetPswDialog.this.mActivity.getResources().getDrawable(R.drawable.round_radius_button_background));
                    button.setText("创建");
                    button.setTextColor(OrderHamamSetPswDialog.this.mActivity.getResources().getColor(R.color.white));
                }
            }
        });
        editText2.addTextChangedListener(new TextWatcher() { // from class: client.android.yixiaotong.ui.dialog.OrderHamamSetPswDialog.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (!StringUtils.isNotEmpty(editable.toString()) || editable.toString().length() < 6 || !StringUtils.isNotEmpty(editText.getText().toString()) || editText.getText().toString().length() < 6) {
                    button.setBackground(OrderHamamSetPswDialog.this.mActivity.getResources().getDrawable(R.drawable.round_radius_button_background));
                    button.setText("下一步");
                    button.setTextColor(OrderHamamSetPswDialog.this.mActivity.getResources().getColor(R.color.ff008AFF));
                } else {
                    button.setBackground(OrderHamamSetPswDialog.this.mActivity.getResources().getDrawable(R.drawable.round_radius_button_background));
                    button.setText("创建");
                    button.setTextColor(OrderHamamSetPswDialog.this.mActivity.getResources().getColor(R.color.white));
                }
            }
        });
        button.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.dialog.OrderHamamSetPswDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (editText.getText().toString().equals(editText2.getText().toString())) {
                    OrderHamamSetPswDialog.this.mListener.onComfirt(editText.getText().toString());
                } else {
                    ToastUtils.show(OrderHamamSetPswDialog.this.mActivity, "两次输入密钥不一致");
                }
            }
        });
    }
}
