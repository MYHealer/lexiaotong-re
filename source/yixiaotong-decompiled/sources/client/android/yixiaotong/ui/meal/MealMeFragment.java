package client.android.yixiaotong.ui.meal;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import client.android.yixiaotong.BaseFragment;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.bean.UserInfoBean;
import client.android.yixiaotong.controller.bean.recharge.RechargeInfoBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.RechargeRecordActivity;
import client.android.yixiaotong.ui.RecordListActivity;
import client.android.yixiaotong.ui.baoxiu.MalfunctionRepairActivity;
import client.android.yixiaotong.ui.dialog.AppTipDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.refund.Refund2Activity;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.DecimalUtil;
import client.android.yixiaotong.util.StringUtils;
import com.facebook.common.util.UriUtil;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class MealMeFragment extends BaseFragment {
    private boolean mIsEnable;
    SimpleDraweeView mIvMeIcon;
    private String mRechargeContent;
    private int mRechargeState;
    private String mRechargeTime;
    private int mRechargeType;
    RelativeLayout mRel;
    RelativeLayout mRelChongZhi;
    RelativeLayout mRelRefund;
    RelativeLayout mRelXiaoFei;
    TitleBar mTitleBar;
    EditText mTvMeId;
    EditText mTvMeName;
    EditText mTvMeXueHao;
    private UserInfoBean mUserInfoBean;
    private WalletModel mWalletModel;

    private void initViewNew(View view) {
        this.mTitleBar = (TitleBar) view.findViewById(R.id.tb_name);
        this.mRel = (RelativeLayout) view.findViewById(R.id.rel);
        this.mIvMeIcon = (SimpleDraweeView) view.findViewById(R.id.iv_me_icon);
        this.mTvMeName = (EditText) view.findViewById(R.id.tv_me_name);
        this.mTvMeId = (EditText) view.findViewById(R.id.tv_me_id);
        this.mTvMeXueHao = (EditText) view.findViewById(R.id.tv_me_xuehao);
        this.mRelChongZhi = (RelativeLayout) view.findViewById(R.id.rel_chongzhi);
        this.mRelXiaoFei = (RelativeLayout) view.findViewById(R.id.rel_xiaofei);
        this.mRelRefund = (RelativeLayout) view.findViewById(R.id.rel_refund);
    }

    public static MealMeFragment newInstance() {
        return new MealMeFragment();
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_meal_me, viewGroup, false);
        initViewNew(viewInflate);
        this.mIsEnable = true;
        initTitleBar();
        initInfoView();
        initView();
        getWalletMonel();
        return viewInflate;
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView("用餐");
    }

    private void initInfoView() {
        UserInfoBean userInfo = getLoginAccount().getAccountManagetStore().getUserInfo();
        this.mUserInfoBean = userInfo;
        if (userInfo == null) {
            return;
        }
        this.mIvMeIcon.setImageURI(UriUtil.parseUriOrNull(userInfo.Icon));
        if (StringUtils.isNotEmpty(this.mUserInfoBean.StudentName)) {
            this.mTvMeName.setText(this.mUserInfoBean.StudentName);
        }
        String str = this.mUserInfoBean.ID + "";
        if (StringUtils.isNotEmpty(str) && str.length() > 4) {
            this.mTvMeId.setText("ID：**************" + str.substring(str.length() - 4, str.length()));
        }
        if (StringUtils.isNotEmpty(this.mUserInfoBean.StudentNo)) {
            this.mTvMeXueHao.setText(this.mUserInfoBean.StudentNo);
        }
    }

    private void initView() {
        UserInfoBean userInfoBean = this.mUserInfoBean;
        if (userInfoBean != null && userInfoBean.UserType == 1) {
            this.mRel.setVisibility(8);
        }
        this.mRel.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.meal.MealMeFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MalfunctionRepairActivity.launch(MealMeFragment.this.getActivity(), 5);
            }
        });
        this.mRelChongZhi.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.meal.MealMeFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RechargeRecordActivity.launch(MealMeFragment.this.getActivity(), 5);
            }
        });
        this.mRelXiaoFei.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.meal.MealMeFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RecordListActivity.launch(MealMeFragment.this.getActivity(), 5);
            }
        });
        this.mRelRefund.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.meal.MealMeFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!DecimalUtil.twoDecimal(MealMeFragment.this.mWalletModel.getBaseWallet()).equals("0.00")) {
                    if (MealMeFragment.this.mRechargeState != -2) {
                        if (MealMeFragment.this.mRechargeState == -1) {
                            SystemErrorTip.getInstance().showTipDialog(MealMeFragment.this.getActivity(), MealMeFragment.this.mRechargeContent);
                            return;
                        }
                        if (MealMeFragment.this.mRechargeState == 0) {
                            if (MealMeFragment.this.mRechargeType == 2) {
                                SystemErrorTip.getInstance().showTipDialog(MealMeFragment.this.getActivity(), "申请退款时间为" + MealMeFragment.this.mRechargeTime);
                                return;
                            } else {
                                SystemErrorTip.getInstance().showTipDialog(MealMeFragment.this.getActivity(), "暂不能申请退款");
                                return;
                            }
                        }
                        if (MealMeFragment.this.mRechargeState == 1) {
                            new AppTipDialog().showTipDialog(MealMeFragment.this.getActivity(), new AppTipDialog.TipDialogListener() { // from class: client.android.yixiaotong.ui.meal.MealMeFragment.4.1
                                @Override // client.android.yixiaotong.ui.dialog.AppTipDialog.TipDialogListener
                                public void onCanle() {
                                }

                                @Override // client.android.yixiaotong.ui.dialog.AppTipDialog.TipDialogListener
                                public void onConfirt() {
                                    Refund2Activity.launch(MealMeFragment.this.getActivity(), MealMeFragment.this.mWalletModel);
                                }
                            }, "申请退款后，" + MealMeFragment.this.mWalletModel.name + "功能将被冻结，不能使用！是否要继续申请退款？", "取消", "继续");
                            return;
                        }
                        return;
                    }
                    SystemErrorTip.getInstance().showTipDialog(MealMeFragment.this.getActivity(), "正在请求中...");
                    return;
                }
                SystemErrorTip.getInstance().showTipDialog(MealMeFragment.this.getActivity(), "当前基本账户余额为0.00元，无法申请退款");
            }
        });
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.mIsEnable = false;
    }

    private void getWalletMonel() {
        BusinessControllers.getInstance().getWalletModels(getLoginAccount(), new Listener<List<WalletModel>>() { // from class: client.android.yixiaotong.ui.meal.MealMeFragment.5
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, List<WalletModel> list, Object... objArr) {
                if (list != null) {
                    for (WalletModel walletModel : list) {
                        if (walletModel.typeId == 5) {
                            MealMeFragment.this.mWalletModel = walletModel;
                            if (!DecimalUtil.twoDecimal(MealMeFragment.this.mWalletModel.getBaseWallet()).equals("0.00")) {
                                MealMeFragment.this.getRechargePromptInformation();
                            }
                        }
                    }
                    return;
                }
                MealMeFragment.this.getActivity().finish();
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                SystemErrorTip.getInstance().showTipDialog(MealMeFragment.this.getActivity(), new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.ui.meal.MealMeFragment.5.1
                    @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                    public void onConfirm() {
                        MealMeFragment.this.getActivity().finish();
                    }
                }, clientException.getDetail());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getRechargePromptInformation() {
        BusinessControllers.getInstance().GetRechargePromptInformation(getLoginAccount(), this.mWalletModel.typeId, new Listener<RechargeInfoBean>() { // from class: client.android.yixiaotong.ui.meal.MealMeFragment.6
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, RechargeInfoBean rechargeInfoBean, Object... objArr) {
                if (MealMeFragment.this.mIsEnable && StringUtils.isNotEmpty(rechargeInfoBean.firstCharge) && StringUtils.isNotEmpty(rechargeInfoBean.leastCharge)) {
                    MealMeFragment.this.mRechargeState = rechargeInfoBean.refundStatus;
                    MealMeFragment.this.mRechargeTime = rechargeInfoBean.refundTime;
                    if (rechargeInfoBean.refundStatus == 1) {
                        return;
                    }
                    MealMeFragment.this.mRechargeType = rechargeInfoBean.refundType;
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (MealMeFragment.this.mIsEnable) {
                    MealMeFragment.this.mRechargeContent = clientException.getDetail();
                    MealMeFragment.this.mRechargeState = -1;
                }
            }
        });
    }
}
