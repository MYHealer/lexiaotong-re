package client.android.yixiaotong.v3.ui.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import client.android.yixiaotong.R;
import client.android.yixiaotong.util.DecimalUtil;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.v3.ui.adapter.PayWayAdapter;
import client.android.yixiaotong.v3.util.ClickUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import com.huawei.openalliance.ad.views.PPSLabelView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ConsumerPriceBottonDialog {
    private static final String TAG = "ConsumerPriceBottonDialog";
    private Activity mActivity;
    private Button mBtnConfirm;
    private Dialog mDialog;
    private ImageView mImgClose;
    private Listener mListener;
    private ListView mLvPayWay;
    private PayWayAdapter mPayWayAdapter;
    private int mSelectIndex;
    private TextView mTvConsumerMoney;
    private TextView mTvConsumerScenarios;
    private TextView mTvDiscountMoney;
    private TextView mTvMoney;

    public interface Listener {
        void onConfirm(int i);
    }

    private ConsumerPriceBottonDialog() {
        this.mSelectIndex = 0;
    }

    private static final class SigleHolder {
        public static final ConsumerPriceBottonDialog INSTANCE = new ConsumerPriceBottonDialog();

        private SigleHolder() {
        }
    }

    public static ConsumerPriceBottonDialog getInstance() {
        return SigleHolder.INSTANCE;
    }

    public void showDialog(Activity activity, Listener listener, int i, List<Integer> list, int i2, int i3, int i4, int i5, String str) {
        Dialog dialog = this.mDialog;
        if ((dialog != null && dialog.isShowing()) || activity == null || listener == null) {
            return;
        }
        LogUtil.e(TAG, i + PPSLabelView.Code + i3 + PPSLabelView.Code + i4 + PPSLabelView.Code + i5);
        this.mListener = listener;
        this.mActivity = activity;
        Dialog dialog2 = new Dialog(this.mActivity, R.style.mydialog);
        this.mDialog = dialog2;
        Window window = dialog2.getWindow();
        View viewInflate = this.mActivity.getLayoutInflater().inflate(R.layout.layout_consumer_price_dialog, (ViewGroup) null);
        this.mImgClose = (ImageView) viewInflate.findViewById(R.id.img_close);
        this.mTvMoney = (TextView) viewInflate.findViewById(R.id.tv_money);
        this.mTvConsumerScenarios = (TextView) viewInflate.findViewById(R.id.tv_consumer_scenarios);
        this.mTvConsumerMoney = (TextView) viewInflate.findViewById(R.id.tv_consumer_money);
        this.mTvDiscountMoney = (TextView) viewInflate.findViewById(R.id.tv_discount_money);
        this.mLvPayWay = (ListView) viewInflate.findViewById(R.id.listview);
        this.mBtnConfirm = (Button) viewInflate.findViewById(R.id.btn_confirm);
        this.mTvMoney.setText(this.mActivity.getResources().getString(R.string.renminbi) + DecimalUtil.divide(i3 + "", "100"));
        this.mTvConsumerMoney.setText(DecimalUtil.divide(i4 + "", "100") + this.mActivity.getResources().getString(R.string.yuan));
        this.mTvDiscountMoney.setText(DecimalUtil.divide(i5 + "", "100") + this.mActivity.getResources().getString(R.string.yuan));
        if (StringUtils.isNotEmpty(str)) {
            this.mTvConsumerScenarios.setText(str);
        }
        this.mPayWayAdapter = new PayWayAdapter(this.mActivity, new PayWayAdapter.OnItemClickListener() { // from class: client.android.yixiaotong.v3.ui.dialog.ConsumerPriceBottonDialog.1
            @Override // client.android.yixiaotong.v3.ui.adapter.PayWayAdapter.OnItemClickListener
            public void onItemClick(int i6) {
                LogUtil.e(ConsumerPriceBottonDialog.TAG, "onItemClick:" + i6);
                ConsumerPriceBottonDialog.this.mSelectIndex = i6;
                ConsumerPriceBottonDialog.this.mPayWayAdapter.notifyDataSetChanged();
            }
        });
        ArrayList arrayList = new ArrayList();
        if (i == 1) {
            arrayList.add(0);
        } else {
            arrayList.addAll(list);
        }
        this.mSelectIndex = 0;
        this.mPayWayAdapter.setData(arrayList, i2);
        this.mLvPayWay.setOnItemClickListener(this.mPayWayAdapter);
        this.mLvPayWay.setAdapter((ListAdapter) this.mPayWayAdapter);
        this.mPayWayAdapter.notifyDataSetChanged();
        this.mDialog.setContentView(viewInflate);
        this.mDialog.setCancelable(false);
        closeOnclick();
        confirmOnclick();
        Display defaultDisplay = this.mActivity.getWindowManager().getDefaultDisplay();
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (arrayList.size() > 2) {
            attributes.height = (int) (((double) defaultDisplay.getHeight()) * 0.7d);
        } else {
            attributes.height = (int) (((double) defaultDisplay.getHeight()) * 0.6d);
        }
        attributes.width = defaultDisplay.getWidth();
        window.setGravity(80);
        window.setAttributes(attributes);
        this.mDialog.show();
    }

    private void closeOnclick() {
        this.mImgClose.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.dialog.ConsumerPriceBottonDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConsumerPriceBottonDialog.this.mDialog.dismiss();
            }
        });
    }

    private void confirmOnclick() {
        this.mBtnConfirm.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.dialog.ConsumerPriceBottonDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ClickUtil.isFastDoubleClick()) {
                    return;
                }
                ConsumerPriceBottonDialog.this.mDialog.dismiss();
                ConsumerPriceBottonDialog.this.mListener.onConfirm(ConsumerPriceBottonDialog.this.mSelectIndex);
            }
        });
    }
}
