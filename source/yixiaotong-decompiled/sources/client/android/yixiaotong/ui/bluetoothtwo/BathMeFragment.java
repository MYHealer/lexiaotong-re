package client.android.yixiaotong.ui.bluetoothtwo;

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
public class BathMeFragment extends BaseFragment {
    private boolean mIsEnable;
    private SimpleDraweeView mIvMeIcon;
    private String mRechargeContent;
    private int mRechargeState;
    private String mRechargeTime;
    private int mRechargeType;
    private RelativeLayout mRel;
    private RelativeLayout mRelChongZhi;
    private RelativeLayout mRelRefund;
    private RelativeLayout mRelXiaoFei;
    private TitleBar mTitleBar;
    private EditText mTvMeId;
    private EditText mTvMeName;
    private EditText mTvMeXueHao;
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

    public static BathMeFragment newInstance() {
        return new BathMeFragment();
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
        this.mTitleBar.setTitleView("洗澡");
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
            this.mTvMeId.setText("**************" + str.substring(str.length() - 4, str.length()));
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
        this.mRel.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BathMeFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MalfunctionRepairActivity.launch(BathMeFragment.this.getActivity(), 1);
            }
        });
        this.mRelChongZhi.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BathMeFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RechargeRecordActivity.launch(BathMeFragment.this.getActivity(), 1);
            }
        });
        this.mRelXiaoFei.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BathMeFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RecordListActivity.launch(BathMeFragment.this.getActivity(), 1);
            }
        });
        this.mRelRefund.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BathMeFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!DecimalUtil.twoDecimal(BathMeFragment.this.mWalletModel.getBaseWallet()).equals("0.00")) {
                    if (BathMeFragment.this.mRechargeState != -2) {
                        if (BathMeFragment.this.mRechargeState == -1) {
                            SystemErrorTip.getInstance().showTipDialog(BathMeFragment.this.getActivity(), BathMeFragment.this.mRechargeContent);
                            return;
                        }
                        if (BathMeFragment.this.mRechargeState == 0) {
                            if (BathMeFragment.this.mRechargeType == 2) {
                                SystemErrorTip.getInstance().showTipDialog(BathMeFragment.this.getActivity(), "申请退款时间为" + BathMeFragment.this.mRechargeTime);
                                return;
                            } else {
                                SystemErrorTip.getInstance().showTipDialog(BathMeFragment.this.getActivity(), "暂不能申请退款");
                                return;
                            }
                        }
                        if (BathMeFragment.this.mRechargeState == 1) {
                            new AppTipDialog().showTipDialog(BathMeFragment.this.getActivity(), new AppTipDialog.TipDialogListener() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BathMeFragment.4.1
                                @Override // client.android.yixiaotong.ui.dialog.AppTipDialog.TipDialogListener
                                public void onCanle() {
                                }

                                @Override // client.android.yixiaotong.ui.dialog.AppTipDialog.TipDialogListener
                                public void onConfirt() {
                                    Refund2Activity.launch(BathMeFragment.this.getActivity(), BathMeFragment.this.mWalletModel);
                                }
                            }, "申请退款后，" + BathMeFragment.this.mWalletModel.name + "功能将被冻结，不能使用！是否要继续申请退款？", "取消", "继续");
                            return;
                        }
                        return;
                    }
                    SystemErrorTip.getInstance().showTipDialog(BathMeFragment.this.getActivity(), "正在请求中...");
                    return;
                }
                SystemErrorTip.getInstance().showTipDialog(BathMeFragment.this.getActivity(), "当前基本账户余额为0.00元，无法申请退款");
            }
        });
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.mIsEnable = false;
    }

    private void getWalletMonel() {
        BusinessControllers.getInstance().getWalletModels(getLoginAccount(), new Listener<List<WalletModel>>() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BathMeFragment.5
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, List<WalletModel> list, Object... objArr) {
                if (list != null) {
                    for (WalletModel walletModel : list) {
                        if (walletModel.typeId == 1) {
                            BathMeFragment.this.mWalletModel = walletModel;
                            if (!DecimalUtil.twoDecimal(BathMeFragment.this.mWalletModel.getBaseWallet()).equals("0.00")) {
                                BathMeFragment.this.getRechargePromptInformation();
                            }
                        }
                    }
                    return;
                }
                BathMeFragment.this.getActivity().finish();
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                SystemErrorTip.getInstance().showTipDialog(BathMeFragment.this.getActivity(), new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BathMeFragment.5.1
                    @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                    public void onConfirm() {
                        BathMeFragment.this.getActivity().finish();
                    }
                }, clientException.getDetail());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getRechargePromptInformation() {
        BusinessControllers.getInstance().GetRechargePromptInformation(getLoginAccount(), this.mWalletModel.typeId, new Listener<RechargeInfoBean>() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BathMeFragment.6
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, RechargeInfoBean rechargeInfoBean, Object... objArr) {
                if (BathMeFragment.this.mIsEnable && StringUtils.isNotEmpty(rechargeInfoBean.firstCharge) && StringUtils.isNotEmpty(rechargeInfoBean.leastCharge)) {
                    BathMeFragment.this.mRechargeState = rechargeInfoBean.refundStatus;
                    BathMeFragment.this.mRechargeTime = rechargeInfoBean.refundTime;
                    if (rechargeInfoBean.refundStatus == 1) {
                        return;
                    }
                    BathMeFragment.this.mRechargeType = rechargeInfoBean.refundType;
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (BathMeFragment.this.mIsEnable) {
                    BathMeFragment.this.mRechargeContent = clientException.getDetail();
                    BathMeFragment.this.mRechargeState = -1;
                }
            }
        });
    }
}
