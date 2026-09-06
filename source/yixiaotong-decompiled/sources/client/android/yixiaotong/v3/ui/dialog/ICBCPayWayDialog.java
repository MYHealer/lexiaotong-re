package client.android.yixiaotong.v3.ui.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Point;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import client.android.yixiaotong.R;
import client.android.yixiaotong.v3.util.LogUtil;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ICBCPayWayDialog {
    private static final String TAG = "ICBCPayWayDialog";
    private Activity mActivity;
    private Button mBtnToPay;
    private Dialog mDialog;
    private ImageView mImgBack;
    private ImageView mImgSelectWx;
    private ImageView mImgSelectZfb;
    private ImageView mImgSelecte;
    private Listener mListener;
    private String mMoney;
    private RelativeLayout mRelIcbcWx;
    private RelativeLayout mRelIcbcZfb;
    private RelativeLayout mRelIcbce;
    private int mSelectIndex;
    private TextView mTvMoney;

    public interface Listener {
        void onPay(int i);
    }

    private ICBCPayWayDialog() {
        this.mSelectIndex = 1;
    }

    private static final class SigleHolder {
        public static final ICBCPayWayDialog INSTANCE = new ICBCPayWayDialog();

        private SigleHolder() {
        }
    }

    public static ICBCPayWayDialog getInstance() {
        return SigleHolder.INSTANCE;
    }

    public void showDialog(Activity activity, Listener listener, String str) {
        this.mActivity = activity;
        this.mListener = listener;
        this.mMoney = str;
        this.mSelectIndex = 1;
        Dialog dialog = this.mDialog;
        if ((dialog != null && dialog.isShowing()) || this.mActivity == null || this.mListener == null) {
            return;
        }
        Dialog dialog2 = new Dialog(this.mActivity, R.style.mydialog);
        this.mDialog = dialog2;
        Window window = dialog2.getWindow();
        View viewInflate = this.mActivity.getLayoutInflater().inflate(R.layout.dialog_icbc_payway, (ViewGroup) null);
        this.mImgBack = (ImageView) viewInflate.findViewById(R.id.img_back);
        this.mTvMoney = (TextView) viewInflate.findViewById(R.id.tv_money);
        this.mRelIcbce = (RelativeLayout) viewInflate.findViewById(R.id.rel_icbce);
        this.mImgSelecte = (ImageView) viewInflate.findViewById(R.id.img_selecte);
        this.mRelIcbcWx = (RelativeLayout) viewInflate.findViewById(R.id.rel_icbcweixin);
        this.mImgSelectWx = (ImageView) viewInflate.findViewById(R.id.img_selectwx);
        this.mRelIcbcZfb = (RelativeLayout) viewInflate.findViewById(R.id.rel_icbczfb);
        this.mImgSelectZfb = (ImageView) viewInflate.findViewById(R.id.img_selectzfb);
        this.mBtnToPay = (Button) viewInflate.findViewById(R.id.btn_topay);
        initView();
        this.mDialog.setContentView(viewInflate);
        this.mDialog.setCancelable(false);
        Display defaultDisplay = this.mActivity.getWindowManager().getDefaultDisplay();
        WindowManager.LayoutParams attributes = window.getAttributes();
        Point point = new Point();
        defaultDisplay.getSize(point);
        attributes.height = point.y;
        LogUtil.e(TAG, point.y + "  " + defaultDisplay.getHeight());
        attributes.width = point.x;
        window.setAttributes(attributes);
        window.setGravity(80);
        this.mDialog.show();
        onPayOnClick();
    }

    private void onPayOnClick() {
        this.mBtnToPay.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.dialog.ICBCPayWayDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ICBCPayWayDialog.this.mDialog.dismiss();
                ICBCPayWayDialog.this.mListener.onPay(ICBCPayWayDialog.this.mSelectIndex);
            }
        });
    }

    private void initView() {
        this.mTvMoney.setText(this.mMoney + this.mActivity.getString(R.string.yuan));
        this.mImgBack.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.dialog.ICBCPayWayDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ICBCPayWayDialog.this.mDialog.dismiss();
            }
        });
        this.mRelIcbce.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.dialog.ICBCPayWayDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ICBCPayWayDialog.this.initRadioView(0);
            }
        });
        this.mRelIcbcWx.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.dialog.ICBCPayWayDialog.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ICBCPayWayDialog.this.initRadioView(1);
            }
        });
        this.mRelIcbcZfb.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.dialog.ICBCPayWayDialog.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ICBCPayWayDialog.this.initRadioView(2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initRadioView(int i) {
        if (i == 0) {
            this.mSelectIndex = 1;
            this.mImgSelecte.setImageResource(R.mipmap.icbc_select);
            this.mImgSelectWx.setImageResource(R.mipmap.wxz);
            this.mImgSelectZfb.setImageResource(R.mipmap.wxz);
            return;
        }
        if (i == 1) {
            this.mSelectIndex = 3;
            this.mImgSelecte.setImageResource(R.mipmap.wxz);
            this.mImgSelectWx.setImageResource(R.mipmap.icbc_select);
            this.mImgSelectZfb.setImageResource(R.mipmap.wxz);
            return;
        }
        if (i == 2) {
            this.mSelectIndex = 2;
            this.mImgSelecte.setImageResource(R.mipmap.wxz);
            this.mImgSelectWx.setImageResource(R.mipmap.wxz);
            this.mImgSelectZfb.setImageResource(R.mipmap.icbc_select);
        }
    }
}
