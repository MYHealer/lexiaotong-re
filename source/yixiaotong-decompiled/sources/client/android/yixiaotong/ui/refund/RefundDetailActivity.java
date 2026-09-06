package client.android.yixiaotong.ui.refund;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.bean.refund.RefundRecordBean;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.TimeUtils;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class RefundDetailActivity extends BaseActivity {
    public static final String EXTRA_DETAL = "extra_datail";
    ImageView mImg2;
    ImageView mImg3;
    private RefundRecordBean mRefundBean;
    RelativeLayout mRelFail;
    TitleBar mTitleBar;
    TextView mTvAccount;
    TextView mTvContent;
    TextView mTvContent2;
    TextView mTvDate;
    TextView mTvDate2;
    TextView mTvDate3;
    TextView mTvFailTime;
    TextView mTvGetMoneyTime;
    TextView mTvMoney;
    TextView mTvRefundTime;
    TextView mTvRenson;
    TextView mTvStatus;
    TextView mTvText3;
    TextView mTvTime;
    TextView mTvTime2;
    TextView mTvTime3;
    View mVLine2;

    static {
        StubApp.interface11(7559);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, RefundRecordBean refundRecordBean) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) RefundDetailActivity.class).putExtra(EXTRA_DETAL, refundRecordBean));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titlebar);
        this.mTvMoney = (TextView) findViewById(R.id.tv_money);
        this.mTvAccount = (TextView) findViewById(R.id.tv_account);
        this.mTvRefundTime = (TextView) findViewById(R.id.tv_refundtime);
        this.mTvGetMoneyTime = (TextView) findViewById(R.id.tv_getmoneytime);
        this.mTvStatus = (TextView) findViewById(R.id.tv_status);
        this.mTvText3 = (TextView) findViewById(R.id.text3);
        this.mTvDate = (TextView) findViewById(R.id.tv_date);
        this.mTvTime = (TextView) findViewById(R.id.tv_time);
        this.mTvDate2 = (TextView) findViewById(R.id.tv_date2);
        this.mTvTime2 = (TextView) findViewById(R.id.tv_time2);
        this.mTvDate3 = (TextView) findViewById(R.id.tv_date3);
        this.mTvTime3 = (TextView) findViewById(R.id.tv_time3);
        this.mImg2 = (ImageView) findViewById(R.id.img2);
        this.mImg3 = (ImageView) findViewById(R.id.img3);
        this.mRelFail = (RelativeLayout) findViewById(R.id.rel_fail);
        this.mTvRenson = (TextView) findViewById(R.id.tv_renson);
        this.mTvFailTime = (TextView) findViewById(R.id.tv_failtime);
        this.mVLine2 = findViewById(R.id.view2);
        this.mTvContent = (TextView) findViewById(R.id.tv_content);
        this.mTvContent2 = (TextView) findViewById(R.id.tv_content2);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView("退款详情");
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void initView() {
        this.mTvMoney.setText("¥" + this.mRefundBean.Refund);
        if (this.mRefundBean.PayType == 0) {
            this.mTvAccount.setText("支付宝" + this.mRefundBean.PayStr);
        } else if (this.mRefundBean.PayType == 1) {
            this.mTvAccount.setText("微信" + this.mRefundBean.RefundName);
        } else {
            this.mTvAccount.setText("其他" + this.mRefundBean.Refund + "元");
        }
        if (StringUtils.isNotEmpty(this.mRefundBean.ApplicationTimeStr)) {
            this.mTvRefundTime.setText(TimeUtils.formatDateTime(Long.parseLong(this.mRefundBean.ApplicationTimeStr)));
        }
        if (this.mRefundBean.Status == 0) {
            this.mTvStatus.setText("退款申请");
        } else if (this.mRefundBean.Status == 1) {
            if (this.mRefundBean.isRefundToAccount == 1) {
                this.mTvStatus.setText("审核中");
                if (StringUtils.isNotEmpty(this.mRefundBean.RefundTimeStr)) {
                    String dateTime = TimeUtils.formatDateTime(Long.parseLong(this.mRefundBean.RefundTimeStr));
                    if (StringUtils.isNotEmpty(dateTime) && dateTime.length() == 19) {
                        this.mTvDate2.setVisibility(0);
                        this.mTvTime2.setVisibility(0);
                        this.mTvDate2.setText(dateTime.substring(0, 10));
                        this.mTvTime2.setText(dateTime.substring(11));
                    }
                }
                this.mImg2.setImageResource(R.mipmap.l_refund_start);
                this.mTvContent.setVisibility(0);
                this.mTvContent2.setVisibility(0);
            } else {
                this.mTvStatus.setText("审核成功");
                if (StringUtils.isNotEmpty(this.mRefundBean.RefundTimeStr)) {
                    String dateTime2 = TimeUtils.formatDateTime(Long.parseLong(this.mRefundBean.RefundTimeStr));
                    if (StringUtils.isNotEmpty(dateTime2) && dateTime2.length() == 19) {
                        this.mTvDate2.setVisibility(0);
                        this.mTvTime2.setVisibility(0);
                        this.mTvDate2.setText(dateTime2.substring(0, 10));
                        this.mTvTime2.setText(dateTime2.substring(11));
                    }
                }
                this.mImg2.setImageResource(R.mipmap.l_refund_start);
                this.mImg3.setImageResource(R.mipmap.l_refund_start);
                this.mTvText3.setVisibility(0);
                this.mTvText3.setText("审核成功");
                if (StringUtils.isNotEmpty(this.mRefundBean.RefundTimeStr)) {
                    String dateTime3 = TimeUtils.formatDateTime(Long.parseLong(this.mRefundBean.RefundTimeStr));
                    if (StringUtils.isNotEmpty(dateTime3) && dateTime3.length() == 19) {
                        this.mTvDate3.setVisibility(0);
                        this.mTvTime3.setVisibility(0);
                        this.mTvDate3.setText(dateTime3.substring(0, 10));
                        this.mTvTime3.setText(dateTime3.substring(11));
                    }
                }
                this.mVLine2.setBackgroundColor(getResources().getColor(R.color.theme_title_color1));
            }
        } else if (this.mRefundBean.Status == 2) {
            this.mTvStatus.setText("退款失败");
            if (StringUtils.isNotEmpty(this.mRefundBean.RefundTimeStr)) {
                String dateTime4 = TimeUtils.formatDateTime(Long.parseLong(this.mRefundBean.RefundTimeStr));
                if (StringUtils.isNotEmpty(dateTime4) && dateTime4.length() == 19) {
                    this.mTvDate3.setVisibility(0);
                    this.mTvTime3.setVisibility(0);
                    this.mTvDate3.setText(dateTime4.substring(0, 10));
                    this.mTvTime3.setText(dateTime4.substring(11));
                }
            }
            this.mImg2.setImageResource(R.mipmap.l_refund_start);
            this.mImg3.setImageResource(R.mipmap.l_refundfail);
            this.mTvText3.setVisibility(0);
            this.mTvText3.setText("退款失败");
            if (StringUtils.isNotEmpty(this.mRefundBean.Comment)) {
                this.mRelFail.setVisibility(0);
                this.mTvFailTime.setText(TimeUtils.formatDateTime(Long.parseLong(this.mRefundBean.RefundTimeStr)));
                this.mTvRenson.setText(this.mRefundBean.Comment);
                this.mVLine2.setBackgroundColor(getResources().getColor(R.color.theme_title_color1));
            }
        } else if (this.mRefundBean.Status == 3) {
            if (StringUtils.isNotEmpty(this.mRefundBean.RefundCompletionTimeStr)) {
                this.mTvGetMoneyTime.setText(TimeUtils.formatDateTime(Long.parseLong(this.mRefundBean.RefundCompletionTimeStr)));
            }
            this.mTvStatus.setText("退款成功");
            this.mImg2.setImageResource(R.mipmap.l_refund_start);
            this.mImg3.setImageResource(R.mipmap.l_refund_start);
            this.mTvText3.setVisibility(0);
            this.mTvText3.setText("成功到账");
            if (StringUtils.isNotEmpty(this.mRefundBean.RefundTimeStr)) {
                String dateTime5 = TimeUtils.formatDateTime(Long.parseLong(this.mRefundBean.RefundTimeStr));
                if (StringUtils.isNotEmpty(dateTime5) && dateTime5.length() == 19) {
                    this.mTvDate2.setVisibility(0);
                    this.mTvTime2.setVisibility(0);
                    this.mTvDate2.setText(dateTime5.substring(0, 10));
                    this.mTvTime2.setText(dateTime5.substring(11));
                }
            }
            if (StringUtils.isNotEmpty(this.mRefundBean.RefundCompletionTimeStr)) {
                String dateTime6 = TimeUtils.formatDateTime(Long.parseLong(this.mRefundBean.RefundCompletionTimeStr));
                if (StringUtils.isNotEmpty(dateTime6) && dateTime6.length() == 19) {
                    this.mTvDate3.setVisibility(0);
                    this.mTvTime3.setVisibility(0);
                    this.mTvDate3.setText(dateTime6.substring(0, 10));
                    this.mTvTime3.setText(dateTime6.substring(11));
                }
            }
            this.mVLine2.setBackgroundColor(getResources().getColor(R.color.theme_title_color1));
        } else if (this.mRefundBean.Status == 4) {
            this.mTvStatus.setText("退款失败");
            this.mImg2.setImageResource(R.mipmap.l_refund_start);
            this.mImg3.setImageResource(R.mipmap.l_refundfail);
            this.mTvText3.setVisibility(0);
            this.mTvText3.setText("退款失败");
            if (StringUtils.isNotEmpty(this.mRefundBean.RefundTimeStr)) {
                String dateTime7 = TimeUtils.formatDateTime(Long.parseLong(this.mRefundBean.RefundTimeStr));
                if (StringUtils.isNotEmpty(dateTime7) && dateTime7.length() == 19) {
                    this.mTvDate2.setVisibility(0);
                    this.mTvTime2.setVisibility(0);
                    this.mTvDate2.setText(dateTime7.substring(0, 10));
                    this.mTvTime2.setText(dateTime7.substring(11));
                }
            }
            if (StringUtils.isNotEmpty(this.mRefundBean.RefundTimeStr)) {
                String dateTime8 = TimeUtils.formatDateTime(Long.parseLong(this.mRefundBean.RefundTimeStr));
                if (StringUtils.isNotEmpty(dateTime8) && dateTime8.length() == 19) {
                    this.mTvDate3.setVisibility(0);
                    this.mTvTime3.setVisibility(0);
                    this.mTvDate3.setText(dateTime8.substring(0, 10));
                    this.mTvTime3.setText(dateTime8.substring(11));
                }
            }
            this.mVLine2.setBackgroundColor(getResources().getColor(R.color.theme_title_color1));
        }
        String dateTime9 = TimeUtils.formatDateTime(Long.parseLong(this.mRefundBean.ApplicationTimeStr));
        if (StringUtils.isNotEmpty(dateTime9) && dateTime9.length() == 19) {
            this.mTvDate.setText(dateTime9.substring(0, 10));
            this.mTvTime.setText(dateTime9.substring(11));
        }
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }
}
