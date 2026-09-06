package com.icbc.paysdk;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.icbc.paysdk.model.ThirdPayReq;
import com.icbc.paysdk.services.ReqManager;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class PayModeListActivity extends Activity {
    ICBCAPI api;
    private Button btn_back;
    private Button btn_next;
    private ImageView iv_alipay_checked;
    private ImageView iv_alipay_unchecked;
    private ImageView iv_icbcpay_checked;
    private ImageView iv_icbcpay_unchecked;
    private ImageView iv_wxpay_checked;
    private ImageView iv_wxpay_unchecked;
    private RelativeLayout rl_alipay;
    private RelativeLayout rl_icbcpay;
    private RelativeLayout rl_wxpay;
    private TextView tv_orderAmount;
    private TextView tv_shopName;
    View.OnClickListener doICBCPay = new View.OnClickListener() { // from class: com.icbc.paysdk.PayModeListActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PayModeListActivity.this.iv_icbcpay_unchecked.getVisibility() == 0) {
                PayModeListActivity.this.iv_icbcpay_unchecked.setVisibility(8);
                PayModeListActivity.this.iv_icbcpay_checked.setVisibility(0);
                if (PayModeListActivity.this.iv_wxpay_checked.getVisibility() == 0) {
                    PayModeListActivity.this.iv_wxpay_checked.setVisibility(8);
                    PayModeListActivity.this.iv_wxpay_unchecked.setVisibility(0);
                }
                if (PayModeListActivity.this.iv_alipay_checked.getVisibility() == 0) {
                    PayModeListActivity.this.iv_alipay_checked.setVisibility(8);
                    PayModeListActivity.this.iv_alipay_unchecked.setVisibility(0);
                    return;
                }
                return;
            }
            if (PayModeListActivity.this.iv_icbcpay_checked.getVisibility() == 0) {
                PayModeListActivity.this.iv_icbcpay_checked.setVisibility(8);
                PayModeListActivity.this.iv_icbcpay_unchecked.setVisibility(0);
            }
        }
    };
    View.OnClickListener doWXPay = new View.OnClickListener() { // from class: com.icbc.paysdk.PayModeListActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PayModeListActivity.this.iv_wxpay_unchecked.getVisibility() == 0) {
                PayModeListActivity.this.iv_wxpay_unchecked.setVisibility(8);
                PayModeListActivity.this.iv_wxpay_checked.setVisibility(0);
                if (PayModeListActivity.this.iv_icbcpay_checked.getVisibility() == 0) {
                    PayModeListActivity.this.iv_icbcpay_checked.setVisibility(8);
                    PayModeListActivity.this.iv_icbcpay_unchecked.setVisibility(0);
                }
                if (PayModeListActivity.this.iv_alipay_checked.getVisibility() == 0) {
                    PayModeListActivity.this.iv_alipay_checked.setVisibility(8);
                    PayModeListActivity.this.iv_alipay_unchecked.setVisibility(0);
                    return;
                }
                return;
            }
            if (PayModeListActivity.this.iv_wxpay_checked.getVisibility() == 0) {
                PayModeListActivity.this.iv_wxpay_checked.setVisibility(8);
                PayModeListActivity.this.iv_wxpay_unchecked.setVisibility(0);
            }
        }
    };
    View.OnClickListener doAliPay = new View.OnClickListener() { // from class: com.icbc.paysdk.PayModeListActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PayModeListActivity.this.iv_alipay_unchecked.getVisibility() == 0) {
                PayModeListActivity.this.iv_alipay_unchecked.setVisibility(8);
                PayModeListActivity.this.iv_alipay_checked.setVisibility(0);
                if (PayModeListActivity.this.iv_icbcpay_checked.getVisibility() == 0) {
                    PayModeListActivity.this.iv_icbcpay_checked.setVisibility(8);
                    PayModeListActivity.this.iv_icbcpay_unchecked.setVisibility(0);
                }
                if (PayModeListActivity.this.iv_wxpay_checked.getVisibility() == 0) {
                    PayModeListActivity.this.iv_wxpay_checked.setVisibility(8);
                    PayModeListActivity.this.iv_wxpay_unchecked.setVisibility(0);
                    return;
                }
                return;
            }
            if (PayModeListActivity.this.iv_alipay_checked.getVisibility() == 0) {
                PayModeListActivity.this.iv_alipay_checked.setVisibility(8);
                PayModeListActivity.this.iv_alipay_unchecked.setVisibility(0);
            }
        }
    };
    View.OnClickListener doReturn = new View.OnClickListener() { // from class: com.icbc.paysdk.PayModeListActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PayModeListActivity.this.finish();
        }
    };
    View.OnClickListener doPay = new View.OnClickListener() { // from class: com.icbc.paysdk.PayModeListActivity.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PayModeListActivity.this.iv_icbcpay_checked.getVisibility() != 0) {
                if (PayModeListActivity.this.iv_wxpay_checked.getVisibility() != 0) {
                    if (PayModeListActivity.this.iv_alipay_checked.getVisibility() != 0) {
                        PayModeListActivity payModeListActivity = PayModeListActivity.this;
                        payModeListActivity.show(payModeListActivity, "请选择有效的支付方式");
                        return;
                    } else {
                        ThirdPayReq thirdPayReq = ReqManager.getInstance().getThirdPayReq();
                        thirdPayReq.setClientType("24");
                        AliPayAPI.getInstance().doAliPay(PayModeListActivity.this, thirdPayReq);
                        return;
                    }
                }
                ThirdPayReq thirdPayReq2 = ReqManager.getInstance().getThirdPayReq();
                thirdPayReq2.setClientType(BaseWrapper.ENTER_ID_SHORTCUT);
                WXPayAPI.init(StubApp.getOrigApplicationContext(PayModeListActivity.this.getApplicationContext()), PayModeListActivity.this.getIntent().getStringExtra("wxappid"));
                WXPayAPI.getInstance().doWXPay(PayModeListActivity.this, thirdPayReq2);
                return;
            }
            ICBCAPI.getInstance().sendReq(PayModeListActivity.this, ReqManager.getInstance().getICBCPayReq());
        }
    };

    static {
        StubApp.interface11(36593);
    }

    @Override // android.app.Activity
    protected native void onCreate(Bundle bundle);

    private void findViews() {
        this.tv_orderAmount = (TextView) findViewById(R.id.tv_orderamount);
        this.tv_shopName = (TextView) findViewById(R.id.tv_shopname);
        this.rl_icbcpay = (RelativeLayout) findViewById(R.id.rl_icbcpay);
        this.rl_wxpay = (RelativeLayout) findViewById(R.id.rl_wxpay);
        this.rl_alipay = (RelativeLayout) findViewById(R.id.rl_alipay);
        this.iv_icbcpay_unchecked = (ImageView) findViewById(R.id.iv_icbcpay_unchecked);
        this.iv_icbcpay_checked = (ImageView) findViewById(R.id.iv_icbcpay_checked);
        this.iv_wxpay_unchecked = (ImageView) findViewById(R.id.iv_wxpay_unchecked);
        this.iv_wxpay_checked = (ImageView) findViewById(R.id.iv_wxpay_checked);
        this.iv_alipay_unchecked = (ImageView) findViewById(R.id.iv_alipay_unchecked);
        this.iv_alipay_checked = (ImageView) findViewById(R.id.iv_alipay_checked);
        this.btn_next = (Button) findViewById(R.id.btn_next);
        this.btn_back = (Button) findViewById(R.id.btn_back);
    }

    private void initViews() {
        this.tv_shopName.setText(getIntent().getStringExtra("shopname"));
        this.tv_orderAmount.setText(getIntent().getStringExtra("totalamount"));
        this.rl_icbcpay.setVisibility(0);
        if ("1".equals(getIntent().getStringExtra("wxpayflag"))) {
            this.rl_wxpay.setVisibility(0);
        } else {
            this.rl_wxpay.setVisibility(8);
        }
        if ("1".equals(getIntent().getStringExtra("alipayflag"))) {
            this.rl_alipay.setVisibility(0);
        } else {
            this.rl_alipay.setVisibility(8);
        }
        this.iv_icbcpay_unchecked.setVisibility(0);
        this.iv_icbcpay_checked.setVisibility(8);
        this.iv_wxpay_unchecked.setVisibility(0);
        this.iv_wxpay_checked.setVisibility(8);
        this.iv_alipay_unchecked.setVisibility(0);
        this.iv_alipay_checked.setVisibility(8);
        this.rl_icbcpay.setOnClickListener(this.doICBCPay);
        this.rl_wxpay.setOnClickListener(this.doWXPay);
        this.rl_alipay.setOnClickListener(this.doAliPay);
        this.btn_back.setOnClickListener(this.doReturn);
        this.btn_next.setOnClickListener(this.doPay);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void show(final Context context, final String str) {
        runOnUiThread(new Runnable() { // from class: com.icbc.paysdk.PayModeListActivity.6
            @Override // java.lang.Runnable
            public void run() {
                Toast.makeText(context, str, 0).show();
            }
        });
    }
}
