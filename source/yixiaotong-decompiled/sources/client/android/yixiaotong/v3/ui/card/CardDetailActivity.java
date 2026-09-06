package client.android.yixiaotong.v3.ui.card;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.bean.SuccessBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.TimeUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.v3.bean.card.ClubCardBean;
import client.android.yixiaotong.v3.bean.login.PlanInfoBean;
import client.android.yixiaotong.v3.bean.login.TypeInfoBean;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.ui.error.V3ErrorTipActivity;
import client.android.yixiaotong.v3.ui.wallet.RefundV3Activity;
import client.android.yixiaotong.v3.userinfo.InvestorInfoUtil;
import client.android.yixiaotong.v3.userinfo.UserInfoUtil;
import client.android.yixiaotong.v3.util.ClickUtil;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class CardDetailActivity extends BaseActivity {
    private Button mBtnActivaCard;
    private Button mBtnMeKnow;
    private Button mBtnRefundCard;
    private ClubCardBean mClubCardBean;
    private int mIndex;
    private boolean mIsEnable = true;
    private RelativeLayout mRelCardBg;
    private TitleBar mTitleBar;
    private TextView mTvDay;
    private TextView mTvDiscount;
    private TextView mTvName;
    private TextView mTvNoActivate;
    private TextView mTvServerName;
    private TextView mTvTian;
    private TextView mTvTian2;
    private TextView mTvTime;
    private TextView mTvUseServer;
    private TextView mTvUseType;
    private TypeInfoBean mTypeInfoBean;

    static {
        StubApp.interface11(9654);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, ClubCardBean clubCardBean, TypeInfoBean typeInfoBean) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) CardDetailActivity.class).putExtra("bean", clubCardBean).putExtra("bean2", typeInfoBean));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mRelCardBg = (RelativeLayout) findViewById(R.id.rel_cardbg);
        this.mTvName = (TextView) findViewById(R.id.tv_name);
        this.mTvServerName = (TextView) findViewById(R.id.tv_servername);
        this.mTvTime = (TextView) findViewById(R.id.tv_usetime);
        this.mTvDay = (TextView) findViewById(R.id.tv_day);
        this.mTvNoActivate = (TextView) findViewById(R.id.tv_noactivate);
        this.mTvTian = (TextView) findViewById(R.id.tv_tian);
        this.mTvTian2 = (TextView) findViewById(R.id.tv_tian2);
        this.mTvDiscount = (TextView) findViewById(R.id.tv_discount);
        this.mTvUseType = (TextView) findViewById(R.id.tv_usetype);
        this.mTvUseServer = (TextView) findViewById(R.id.tv_useserver);
        this.mBtnMeKnow = (Button) findViewById(R.id.btn_meknow);
        this.mBtnRefundCard = (Button) findViewById(R.id.btn_refundcard);
        this.mBtnActivaCard = (Button) findViewById(R.id.btn_activacard);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView("会员卡详情");
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void initView() {
        String strConcat;
        if (this.mClubCardBean.statusFlag == 0) {
            this.mBtnActivaCard.setText("购买中");
        } else if (this.mClubCardBean.statusFlag == 1) {
            this.mBtnActivaCard.setText("已激活");
        } else if (this.mClubCardBean.statusFlag == 2) {
            this.mBtnActivaCard.setText("未激活");
        } else if (this.mClubCardBean.statusFlag == 3) {
            this.mBtnActivaCard.setText("退款办理中");
        } else if (this.mClubCardBean.statusFlag == 4) {
            this.mBtnActivaCard.setText("退卡成功");
        } else {
            this.mBtnActivaCard.setVisibility(4);
        }
        if (this.mClubCardBean.statusFlag == 2) {
            this.mRelCardBg.setBackgroundResource(R.mipmap.bg6);
            this.mTvNoActivate.setVisibility(0);
            this.mBtnMeKnow.setVisibility(8);
            this.mBtnRefundCard.setVisibility(0);
            this.mTvTian.setVisibility(4);
            this.mTvTian2.setVisibility(4);
        } else if (this.mClubCardBean.discountValue == 0) {
            this.mRelCardBg.setBackgroundResource(R.mipmap.bg1);
            this.mTvNoActivate.setVisibility(4);
            this.mBtnMeKnow.setVisibility(0);
            this.mBtnRefundCard.setVisibility(8);
        } else {
            if (this.mClubCardBean.cardGroup == 1) {
                this.mRelCardBg.setBackgroundResource(R.mipmap.bg2);
            } else if (this.mClubCardBean.cardGroup == 2) {
                this.mRelCardBg.setBackgroundResource(R.mipmap.bg3);
            } else if (this.mClubCardBean.cardGroup == 3) {
                this.mRelCardBg.setBackgroundResource(R.mipmap.bg4);
            } else if (this.mClubCardBean.cardGroup == 4) {
                this.mRelCardBg.setBackgroundResource(R.mipmap.bg5);
            }
            this.mTvNoActivate.setVisibility(4);
            this.mBtnMeKnow.setVisibility(0);
            this.mBtnRefundCard.setVisibility(8);
        }
        if (this.mClubCardBean.cardGroup == 1) {
            strConcat = "周卡";
        } else if (this.mClubCardBean.cardGroup == 2) {
            strConcat = "月卡";
        } else if (this.mClubCardBean.cardGroup == 3) {
            strConcat = "季卡";
        } else {
            strConcat = this.mClubCardBean.cardGroup == 4 ? "年卡" : "";
        }
        if (this.mClubCardBean.discountValue != 100) {
            if (this.mClubCardBean.discountValue == 0) {
                strConcat = "免费 ".concat(strConcat);
            } else {
                strConcat = (this.mClubCardBean.discountValue / 10.0f) + "折 " + strConcat;
            }
        }
        this.mTvName.setText(this.mTypeInfoBean.base.appName + strConcat);
        this.mTvServerName.setText(this.mClubCardBean.providerName);
        if (StringUtils.isNotEmpty(this.mClubCardBean.useStartTime) && StringUtils.isNotEmpty(this.mClubCardBean.useEntTime)) {
            this.mTvTime.setText(this.mClubCardBean.useStartTime + " 至 " + this.mClubCardBean.useEntTime);
        }
        if (StringUtils.isNotEmpty(this.mClubCardBean.useEntTime)) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            long jStrTimeToSec = TimeUtils.strTimeToSec(this.mClubCardBean.useEntTime);
            if (jStrTimeToSec != 0) {
                Log.e("test", jCurrentTimeMillis + "  " + jStrTimeToSec);
                long j = ((((jStrTimeToSec - jCurrentTimeMillis) / 60) / 60) / 24) / 1000;
                if (jCurrentTimeMillis > jStrTimeToSec) {
                    this.mTvDay.setText("0");
                } else {
                    this.mTvDay.setText((1 + j) + "");
                }
            }
        } else if (this.mClubCardBean.statusFlag != 2) {
            this.mTvDay.setText("0");
        }
        if (this.mClubCardBean.discountValue == 100) {
            this.mTvDiscount.setText("不免费");
        } else if (this.mClubCardBean.discountValue == 0) {
            this.mTvDiscount.setText("免费");
        } else {
            this.mTvDiscount.setText((this.mClubCardBean.discountValue / 10.0f) + "折");
        }
        if (this.mClubCardBean.typeidJsonb != null && this.mClubCardBean.typeidJsonb.size() > 0) {
            StringBuilder sb = new StringBuilder();
            ArrayList arrayList = new ArrayList();
            this.mIndex = InvestorInfoUtil.getInstance().getInvestorInfosIndex();
            List<PlanInfoBean> list = InvestorInfoUtil.getInstance().getInvestorInfosV3().get(this.mIndex).investorInfo.planInfo;
            if (list != null && list.size() > 0) {
                for (int i = 0; i < list.size(); i++) {
                    List<TypeInfoBean> list2 = list.get(i).typeInfo;
                    if (list2 != null && list2.size() > 0) {
                        for (int i2 = 0; i2 < list2.size(); i2++) {
                            arrayList.add(list.get(i).typeInfo.get(i2));
                        }
                    }
                }
            }
            for (int i3 = 0; i3 < this.mClubCardBean.typeidJsonb.size(); i3++) {
                for (int i4 = 0; i4 < arrayList.size(); i4++) {
                    Log.e("test", i3 + "  " + i4 + "  " + this.mClubCardBean.typeidJsonb.get(i3) + "  " + ((TypeInfoBean) arrayList.get(i4)).base.typeId + "  " + sb.toString().contains(((TypeInfoBean) arrayList.get(i4)).base.appName));
                    if (this.mClubCardBean.typeidJsonb.get(i3).intValue() == ((TypeInfoBean) arrayList.get(i4)).base.typeId && !sb.toString().contains(((TypeInfoBean) arrayList.get(i4)).base.appName)) {
                        sb.append(((TypeInfoBean) arrayList.get(i4)).base.appName + "/");
                    }
                }
            }
            if (sb.length() > 1) {
                this.mTvUseType.setText(sb.toString().substring(0, sb.length() - 1));
            }
        }
        this.mTvUseServer.setText(this.mClubCardBean.providerName);
    }

    private void initClickListeners() {
        findViewById(R.id.tv_rule).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.card.CardDetailActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m322xff897d66(view);
            }
        });
        findViewById(R.id.btn_refundcard).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.card.CardDetailActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m323x251d8667(view);
            }
        });
        findViewById(R.id.btn_activacard).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.card.CardDetailActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m324x4ab18f68(view);
            }
        });
        findViewById(R.id.btn_meknow).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.card.CardDetailActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m325x70459869(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-v3-ui-card-CardDetailActivity, reason: not valid java name */
    /* synthetic */ void m322xff897d66(View view) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        CardRuleActivity.launch(getActivity());
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$1$client-android-yixiaotong-v3-ui-card-CardDetailActivity, reason: not valid java name */
    /* synthetic */ void m323x251d8667(View view) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        refundCard();
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$2$client-android-yixiaotong-v3-ui-card-CardDetailActivity, reason: not valid java name */
    /* synthetic */ void m324x4ab18f68(View view) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        activate();
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$3$client-android-yixiaotong-v3-ui-card-CardDetailActivity, reason: not valid java name */
    /* synthetic */ void m325x70459869(View view) {
        finish();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mIsEnable = true;
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mIsEnable = false;
        BaseMaterialDialog.dissmisMaterialDialog();
    }

    private void activate() {
        V3BusinessControllers.getInstance().postActivate(getLoginAccount(), UserInfoUtil.getInstance().getLoginAccountV3().schoolInfoList.get(UserInfoUtil.getInstance().getSchoolInfosIndex()).id + "", InvestorInfoUtil.getInstance().getInvestorInfosV3().get(this.mIndex).investorInfo.investorId, this.mClubCardBean.ldcId, new Listener<SuccessBean>() { // from class: client.android.yixiaotong.v3.ui.card.CardDetailActivity.1
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(CardDetailActivity.this.getActivity(), "正在激活.", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SuccessBean successBean, Object... objArr) {
                if (CardDetailActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    ToastUtils.show(CardDetailActivity.this.getContext(), "激活卡片成功");
                    CardDetailActivity.this.finish();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (CardDetailActivity.this.mIsEnable) {
                    CardDetailActivity.this.onError(clientException);
                }
            }
        });
    }

    private void refundCard() {
        RefundV3Activity.launch(getActivity(), this.mClubCardBean.ldcId + "", this.mClubCardBean.discountHowmuchMoney, this.mClubCardBean.discountHowmuchMoney, 3);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(ClientException clientException) {
        if (clientException.isNeedTip(clientException.getCode())) {
            SystemErrorTip.getInstance().showTipDialog(getActivity(), new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v3.ui.card.CardDetailActivity.2
                @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                public void onConfirm() {
                }
            }, clientException.getDetail());
        } else {
            V3ErrorTipActivity.launch(getActivity(), this.mTitleBar.getTitleViewContent(), clientException.getDetail(), clientException.getCode(), 2, clientException.getSerial());
        }
    }
}
