package client.android.yixiaotong.ui.hamam;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import client.android.yixiaotong.BaseApplication;
import client.android.yixiaotong.BaseFragment;
import client.android.yixiaotong.R;
import client.android.yixiaotong.account.AccountManager;
import client.android.yixiaotong.baseutil.ActivitiesHelper;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.bean.SuccessBean;
import client.android.yixiaotong.controller.bean.UserInfoBean;
import client.android.yixiaotong.controller.bean.bindcard.IsHasBindCardFunctionBean;
import client.android.yixiaotong.controller.bean.hamam.HamamIsBindBean;
import client.android.yixiaotong.controller.bean.hamam.HamamVerifyAuthPasswordSecurity;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.error.ErrorUtil;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.controller.store.LocalBusinessStore;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.RecordListActivity;
import client.android.yixiaotong.ui.WalletDetailActivity;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.BindhamamDialogTip;
import client.android.yixiaotong.ui.dialog.ChongZhiDialogTip;
import client.android.yixiaotong.ui.dialog.SetPswDialogTip;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.dialog.UnBindHamamDialogTip;
import client.android.yixiaotong.ui.drinkwater.CardDetailOldActivity;
import client.android.yixiaotong.ui.login.LoginActivity;
import client.android.yixiaotong.ui.login.XiugaiAuthorizedPasswordActivity;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.DecimalUtil;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import com.facebook.common.util.UriUtil;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class HamamMainFragment extends BaseFragment {
    private PswState mCurrentState;
    ImageView mImgBindCard;
    ImageView mImgDetail;
    ImageView mImgSex;
    SimpleDraweeView mIvMeIcon;
    ImageView mQiDong;
    private ChongZhiDialogTip mRechargeDialogTip;
    RelativeLayout mRelMoney;
    RelativeLayout mRelTip;
    private SetPswDialogTip mSetPswDialogTip;
    TitleBar mTitleBar;
    TextView mTvBalance;
    LinearLayout mTvDeviceDetail;
    TextView mTvMeId;
    TextView mTvMeName;
    TextView mTvMeXueHao;
    LinearLayout mTvRecord;
    LinearLayout mTvResetPsw;
    TextView mTvRoomAddress;
    LinearLayout mTvUnbind;
    private UserInfoBean mUserInfoBean;
    private WalletModel mWalletModel;
    private boolean mIsEnable = false;
    private String mTipConetnt = "";
    private BindhamamDialogTip.BindDialogListener bindDialogListener = new BindhamamDialogTip.BindDialogListener() { // from class: client.android.yixiaotong.ui.hamam.HamamMainFragment.1
        @Override // client.android.yixiaotong.ui.dialog.BindhamamDialogTip.BindDialogListener
        public void onCanle() {
        }

        @Override // client.android.yixiaotong.ui.dialog.BindhamamDialogTip.BindDialogListener
        public void onConfirm() {
            HamamBindActivity.launch(HamamMainFragment.this.getActivity(), HamamMainFragment.this.mWalletModel, false);
        }
    };
    private UnBindHamamDialogTip.UnBindDialogListener unBindDialogListener = new UnBindHamamDialogTip.UnBindDialogListener() { // from class: client.android.yixiaotong.ui.hamam.HamamMainFragment.2
        @Override // client.android.yixiaotong.ui.dialog.UnBindHamamDialogTip.UnBindDialogListener
        public void onCanle() {
        }

        @Override // client.android.yixiaotong.ui.dialog.UnBindHamamDialogTip.UnBindDialogListener
        public void onConfirm() {
            HamamMainFragment.this.unbind(false);
        }
    };

    private enum PswState {
        unknow,
        enable,
        unable
    }

    private void initViewNew(View view) {
        this.mTitleBar = (TitleBar) view.findViewById(R.id.tb_name);
        this.mIvMeIcon = (SimpleDraweeView) view.findViewById(R.id.iv_me_icon);
        this.mImgSex = (ImageView) view.findViewById(R.id.img_sex);
        this.mTvMeName = (TextView) view.findViewById(R.id.tv_me_name);
        this.mTvMeId = (TextView) view.findViewById(R.id.tv_me_id);
        this.mTvMeXueHao = (TextView) view.findViewById(R.id.tv_me_xuehao);
        this.mQiDong = (ImageView) view.findViewById(R.id.qidong);
        this.mImgBindCard = (ImageView) view.findViewById(R.id.img_bindcard);
        this.mTvUnbind = (LinearLayout) view.findViewById(R.id.unbind);
        this.mTvResetPsw = (LinearLayout) view.findViewById(R.id.reset_psw);
        this.mTvDeviceDetail = (LinearLayout) view.findViewById(R.id.devicedetail);
        this.mTvRecord = (LinearLayout) view.findViewById(R.id.record);
        this.mTvRoomAddress = (TextView) view.findViewById(R.id.tv_room_address);
        this.mImgDetail = (ImageView) view.findViewById(R.id.img_dateil);
        this.mTvBalance = (TextView) view.findViewById(R.id.tv_balance);
        this.mRelTip = (RelativeLayout) view.findViewById(R.id.rel_tip);
        this.mRelMoney = (RelativeLayout) view.findViewById(R.id.rel_money);
    }

    public static HamamMainFragment newInstance() {
        return new HamamMainFragment();
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_hamam_main, viewGroup, false);
        if (this.mWalletModel == null) {
            getActivity().finish();
            return viewInflate;
        }
        initViewNew(viewInflate);
        initTitleBar();
        initInfoView();
        initView();
        initDialog();
        return viewInflate;
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView("公共浴室");
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void initInfoView() {
        UserInfoBean userInfo = getLoginAccount().getAccountManagetStore().getUserInfo();
        this.mUserInfoBean = userInfo;
        if (userInfo == null) {
            return;
        }
        this.mIvMeIcon.setImageURI(UriUtil.parseUriOrNull(userInfo.Icon));
        if (this.mUserInfoBean.GenderId == 1) {
            this.mImgSex.setImageDrawable(getResources().getDrawable(R.mipmap.l_shouye_boy));
        } else {
            this.mImgSex.setImageDrawable(getResources().getDrawable(R.mipmap.l_shouye_girl));
        }
        if (StringUtils.isNotEmpty(this.mUserInfoBean.StudentName)) {
            this.mTvMeName.setText(this.mUserInfoBean.StudentName);
        }
        String str = this.mUserInfoBean.ID + "";
        if (StringUtils.isNotEmpty(str) && str.length() > 4) {
            this.mTvMeId.setText("ID：**************" + str.substring(str.length() - 4, str.length()));
        }
        if (StringUtils.isNotEmpty(this.mUserInfoBean.StudentNo)) {
            this.mTvMeXueHao.setText("学号：" + this.mUserInfoBean.StudentNo);
        }
    }

    private void initDialog() {
        this.mSetPswDialogTip = new SetPswDialogTip(getActivity());
        this.mRechargeDialogTip = new ChongZhiDialogTip(getActivity());
    }

    private void initView() {
        if (LocalBusinessStore.getHamamIsFirstUse(getContext(), getLoginAccount().getUid())) {
            this.mRelTip.getBackground().setAlpha(120);
            this.mRelTip.setVisibility(0);
        } else {
            this.mRelTip.setVisibility(8);
        }
        this.mRelTip.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.hamam.HamamMainFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LocalBusinessStore.saveHamamIsFirstUse(HamamMainFragment.this.getContext(), HamamMainFragment.this.getLoginAccount().getUid());
                HamamMainFragment.this.mRelTip.setVisibility(8);
            }
        });
        this.mTvBalance.setText(DecimalUtil.twoDecimal(DecimalUtil.divide(this.mWalletModel.getBalance() + "", "100")) + "元");
        this.mTvRoomAddress.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.hamam.HamamMainFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String hamamRoomId = LocalBusinessStore.getHamamRoomId(HamamMainFragment.this.getContext(), HamamMainFragment.this.getLoginAccount().getUid());
                if (HamamMainFragment.this.mCurrentState != PswState.enable) {
                    if (HamamMainFragment.this.mCurrentState == PswState.unable) {
                        if (StringUtils.isNotEmpty(HamamMainFragment.this.mTipConetnt)) {
                            SystemErrorTip.getInstance().showTipDialog(HamamMainFragment.this.getActivity(), HamamMainFragment.this.mTipConetnt);
                            return;
                        } else {
                            if (StringUtils.isNotEmpty(HamamMainFragment.this.mTipConetnt)) {
                                HamamMainFragment.this.mSetPswDialogTip.showSetPswDialog("");
                                HamamMainFragment.this.mSetPswDialogTip.waitOnclick1();
                                return;
                            }
                            return;
                        }
                    }
                    return;
                }
                if (StringUtils.isEmpty(hamamRoomId)) {
                    new BindhamamDialogTip().showBindDialog(HamamMainFragment.this.getActivity(), HamamMainFragment.this.bindDialogListener, "亲～您还未绑定浴室，绑定后", "需等待5分钟才会生效", "暂不", "绑定");
                }
            }
        });
        this.mQiDong.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.hamam.HamamMainFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!StringUtils.isNotEmpty(LocalBusinessStore.getHamamRoomId(HamamMainFragment.this.getContext(), HamamMainFragment.this.getLoginAccount().getUid()))) {
                    new BindhamamDialogTip().showBindDialog(HamamMainFragment.this.getActivity(), HamamMainFragment.this.bindDialogListener, "亲～您还未绑定浴室，绑定后", "需等待5分钟才会生效", "暂不", "绑定");
                } else {
                    if (HamamMainFragment.this.mWalletModel.getBalance() >= 1000) {
                        HamamActivity.launch(HamamMainFragment.this.getActivity(), HamamMainFragment.this.mWalletModel);
                        return;
                    }
                    HamamMainFragment.this.mRechargeDialogTip.showChongZhiDialog(DecimalUtil.divide(HamamMainFragment.this.mWalletModel.getBalance() + "", "100"));
                    HamamMainFragment.this.mRechargeDialogTip.waitOnclick();
                    HamamMainFragment.this.mRechargeDialogTip.confirmOnclick(HamamMainFragment.this.mWalletModel);
                }
            }
        });
        this.mTvUnbind.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.hamam.HamamMainFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HamamMainFragment.this.mCurrentState != PswState.enable) {
                    if (HamamMainFragment.this.mCurrentState == PswState.unable) {
                        if (StringUtils.isNotEmpty(HamamMainFragment.this.mTipConetnt)) {
                            SystemErrorTip.getInstance().showTipDialog(HamamMainFragment.this.getActivity(), HamamMainFragment.this.mTipConetnt);
                            return;
                        } else {
                            HamamMainFragment.this.mSetPswDialogTip.showSetPswDialog("");
                            HamamMainFragment.this.mSetPswDialogTip.waitOnclick1();
                            return;
                        }
                    }
                    return;
                }
                if (StringUtils.isNotEmpty(LocalBusinessStore.getHamamRoomId(HamamMainFragment.this.getContext(), HamamMainFragment.this.getLoginAccount().getUid()))) {
                    new UnBindHamamDialogTip().showUnBindDialog(HamamMainFragment.this.getActivity(), HamamMainFragment.this.unBindDialogListener, "亲～解除绑定后，24小时之内", "无法再次绑定该浴室", "解绑", "不了");
                } else {
                    new BindhamamDialogTip().showBindDialog(HamamMainFragment.this.getActivity(), HamamMainFragment.this.bindDialogListener, "亲～您还未绑定浴室，绑定后", "需等待5分钟才会生效", "暂不", "绑定");
                }
            }
        });
        this.mTvResetPsw.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.hamam.HamamMainFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                XiugaiAuthorizedPasswordActivity.launch(HamamMainFragment.this.getActivity(), "", "", 3);
            }
        });
        this.mTvDeviceDetail.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.hamam.HamamMainFragment.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String hamamRoomId = LocalBusinessStore.getHamamRoomId(HamamMainFragment.this.getContext(), HamamMainFragment.this.getLoginAccount().getUid());
                if (HamamMainFragment.this.mCurrentState != PswState.enable) {
                    if (HamamMainFragment.this.mCurrentState == PswState.unable) {
                        if (StringUtils.isNotEmpty(HamamMainFragment.this.mTipConetnt)) {
                            SystemErrorTip.getInstance().showTipDialog(HamamMainFragment.this.getActivity(), HamamMainFragment.this.mTipConetnt);
                            return;
                        } else {
                            HamamMainFragment.this.mSetPswDialogTip.showSetPswDialog("");
                            HamamMainFragment.this.mSetPswDialogTip.waitOnclick1();
                            return;
                        }
                    }
                    return;
                }
                if (StringUtils.isNotEmpty(hamamRoomId)) {
                    HamamDetailActivity.launch(HamamMainFragment.this.getActivity(), HamamMainFragment.this.mWalletModel, -1, "", false);
                } else {
                    new BindhamamDialogTip().showBindDialog(HamamMainFragment.this.getActivity(), HamamMainFragment.this.bindDialogListener, "亲～您还未绑定浴室，绑定后", "需等待5分钟才会生效", "暂不", "绑定");
                }
            }
        });
        this.mTvRecord.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.hamam.HamamMainFragment.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HamamMainFragment.this.mWalletModel != null) {
                    RecordListActivity.launch(HamamMainFragment.this.getActivity(), HamamMainFragment.this.mWalletModel.typeId);
                }
            }
        });
        this.mQiDong.setOnTouchListener(new View.OnTouchListener() { // from class: client.android.yixiaotong.ui.hamam.HamamMainFragment.10
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return motionEvent.getX() < 100.0f || motionEvent.getY() < 100.0f || motionEvent.getX() > 480.0f || motionEvent.getY() > 480.0f;
            }
        });
        this.mRelMoney.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.hamam.HamamMainFragment.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HamamMainFragment.this.mWalletModel != null) {
                    WalletDetailActivity.launch(HamamMainFragment.this.getActivity(), HamamMainFragment.this.mWalletModel);
                }
            }
        });
        if (getLoginAccount().getAccountManagetStore().getUserInfo().AreaId == 25086) {
            this.mImgBindCard.setVisibility(0);
        } else {
            this.mImgBindCard.setVisibility(8);
        }
        this.mImgBindCard.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.hamam.HamamMainFragment.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HamamMainFragment.this.isCheckCardFunction();
            }
        });
    }

    @Override // client.android.yixiaotong.BaseFragment, android.app.Fragment
    public void onResume() {
        super.onResume();
        this.mIsEnable = true;
        this.mTipConetnt = "";
        isBindHamam();
        checkpsw();
    }

    @Override // client.android.yixiaotong.BaseFragment, android.app.Fragment
    public void onPause() {
        super.onPause();
        this.mIsEnable = false;
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mWalletModel = ((HamamMainActivity) activity).getmWalletModel();
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    private void isBindHamam() {
        BusinessControllers.getInstance().hamamIsBind(getLoginAccount(), "", new Listener<HamamIsBindBean>() { // from class: client.android.yixiaotong.ui.hamam.HamamMainFragment.13
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, HamamIsBindBean hamamIsBindBean, Object... objArr) {
                if (hamamIsBindBean == null || !HamamMainFragment.this.mIsEnable) {
                    return;
                }
                if (hamamIsBindBean.isbind == 1) {
                    LocalBusinessStore.saveHamamRoomId(HamamMainFragment.this.getContext(), HamamMainFragment.this.getLoginAccount().getUid(), hamamIsBindBean.bathhouseareaid);
                    HamamMainFragment.this.mTvRoomAddress.setText("绑定浴室：" + hamamIsBindBean.remarks);
                    if (StringUtils.isEmpty(hamamIsBindBean.remarks)) {
                        if (LocalBusinessStore.getHamamIsFirstUse(HamamMainFragment.this.getContext(), HamamMainFragment.this.getLoginAccount().getUid())) {
                            LocalBusinessStore.saveHamamIsFirstUse(HamamMainFragment.this.getContext(), HamamMainFragment.this.getLoginAccount().getUid());
                            HamamMainFragment.this.mRelTip.setVisibility(8);
                        }
                        HamamMainFragment.this.unbind(true);
                        return;
                    }
                    return;
                }
                if (hamamIsBindBean.isbind == 2) {
                    LocalBusinessStore.saveHamamRoomId(HamamMainFragment.this.getContext(), HamamMainFragment.this.getLoginAccount().getUid(), "");
                } else {
                    LocalBusinessStore.saveHamamRoomId(HamamMainFragment.this.getContext(), HamamMainFragment.this.getLoginAccount().getUid(), "");
                    ToastUtils.show(HamamMainFragment.this.getContext(), "未知错误！");
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (HamamMainFragment.this.mIsEnable) {
                    LocalBusinessStore.saveHamamRoomId(HamamMainFragment.this.getContext(), HamamMainFragment.this.getLoginAccount().getUid(), "");
                }
            }
        });
    }

    private void checkpsw() {
        BusinessControllers.getInstance().VerifyAuthPasswordSecurity(getLoginAccount(), 0, new Listener<HamamVerifyAuthPasswordSecurity>() { // from class: client.android.yixiaotong.ui.hamam.HamamMainFragment.14
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                HamamMainFragment.this.mCurrentState = PswState.unknow;
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, HamamVerifyAuthPasswordSecurity hamamVerifyAuthPasswordSecurity, Object... objArr) {
                if (HamamMainFragment.this.mIsEnable) {
                    if (hamamVerifyAuthPasswordSecurity.result == 1) {
                        HamamMainFragment.this.mCurrentState = PswState.enable;
                    } else {
                        HamamMainFragment.this.mCurrentState = PswState.unable;
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (HamamMainFragment.this.mIsEnable) {
                    HamamMainFragment.this.mCurrentState = PswState.unable;
                    if (clientException.getCode() == 20011) {
                        return;
                    }
                    if (clientException.getCode() == 20010) {
                        HamamMainFragment.this.mSetPswDialogTip.showSetPswDialog();
                        HamamMainFragment.this.mSetPswDialogTip.waitOnclick();
                        HamamMainFragment.this.mSetPswDialogTip.confirmOnclick();
                    } else {
                        if (clientException.getCode() != 1001) {
                            HamamMainFragment.this.mTipConetnt = clientException.getDetail();
                            return;
                        }
                        ToastUtils.show(HamamMainFragment.this.getContext(), "当前用户已下线，请重新登录");
                        AccountManager.getInstance().clearLoginAccount();
                        LoginActivity.launch(BaseApplication.app);
                        ActivitiesHelper.getInstance().closeExcept(LoginActivity.class);
                        HamamMainFragment.this.getActivity().finish();
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unbind(final boolean z) {
        BusinessControllers.getInstance().hamamUnBind(getLoginAccount(), LocalBusinessStore.getHamamRoomId(getActivity(), getLoginAccount().getUid()), new Listener<SuccessBean>() { // from class: client.android.yixiaotong.ui.hamam.HamamMainFragment.15
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SuccessBean successBean, Object... objArr) {
                if (HamamMainFragment.this.mIsEnable) {
                    if (z) {
                        HamamMainFragment.this.mTvRoomAddress.setText("绑定浴室：未绑定");
                        LocalBusinessStore.saveHamamRoomId(HamamMainFragment.this.getContext(), HamamMainFragment.this.getLoginAccount().getUid(), "");
                        SystemErrorTip.getInstance().showTipDialog(HamamMainFragment.this.getActivity(), "澡堂信息变更，需重新绑定澡堂，如有疑惑请联系相关客服人员");
                    } else {
                        if (successBean != null) {
                            ToastUtils.show(HamamMainFragment.this.getActivity(), "解绑成功");
                            LocalBusinessStore.saveHamamRoomId(HamamMainFragment.this.getContext(), HamamMainFragment.this.getLoginAccount().getUid(), "");
                            HamamMainFragment.this.getActivity().finish();
                            return;
                        }
                        ToastUtils.show(HamamMainFragment.this.getActivity(), "解绑失败");
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (HamamMainFragment.this.mIsEnable) {
                    ErrorUtil.onFailResult(HamamMainFragment.this.getActivity(), HamamMainFragment.this.mTitleBar.getTitleViewContent(), clientException, false);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void isCheckCardFunction() {
        BusinessControllers.getInstance().isHasCardFunction(getLoginAccount(), 11, new Listener<IsHasBindCardFunctionBean>() { // from class: client.android.yixiaotong.ui.hamam.HamamMainFragment.16
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(HamamMainFragment.this.getActivity(), "加载中..", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, IsHasBindCardFunctionBean isHasBindCardFunctionBean, Object... objArr) {
                if (HamamMainFragment.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    if (isHasBindCardFunctionBean.type == 1) {
                        CardDetailOldActivity.launch(HamamMainFragment.this.getActivity(), 11);
                    } else {
                        ToastUtils.show(HamamMainFragment.this.getActivity(), "不支持用卡功能");
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (HamamMainFragment.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    ErrorUtil.onFailResult(HamamMainFragment.this.getActivity(), HamamMainFragment.this.mTitleBar.getTitleViewContent(), clientException, false);
                }
            }
        });
    }
}
