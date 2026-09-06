package client.android.yixiaotong.ui.drinkwater;

import android.app.Activity;
import android.app.Dialog;
import android.client.bluetoothsdk.BluetoothSDK;
import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import client.android.yixiaotong.BaseApplication;
import client.android.yixiaotong.BaseFragment;
import client.android.yixiaotong.R;
import client.android.yixiaotong.account.AccountManager;
import client.android.yixiaotong.baseutil.ActivitiesHelper;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.bean.UserInfoBean;
import client.android.yixiaotong.controller.bean.bindcard.IsHasBindCardFunctionBean;
import client.android.yixiaotong.controller.bean.bindcard.PasswordStateBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.error.ErrorUtil;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.controller.store.LocalBusinessStore;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.RecordListActivity;
import client.android.yixiaotong.ui.RefundProgressActivity;
import client.android.yixiaotong.ui.WalletDetailActivity;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.login.LoginActivity;
import client.android.yixiaotong.ui.scancode.ScanQrcodeOrBarcodeActivity;
import client.android.yixiaotong.ui.scancode.ZxingScanActivity;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.AppUtils;
import client.android.yixiaotong.util.DecimalUtil;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.bluetooth.BluetoothManager;
import client.android.yixiaotong.util.drinkwater.PreferenceUtil;
import com.facebook.common.util.UriUtil;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class DrinkWaterMainFragment extends BaseFragment {
    private static final String TYPE_CLICK_DATA = "type_click_data";
    private Dialog mDialog;
    private ImageView mImgBindCard;
    private ImageView mImgSex;
    private boolean mIsEnable = true;
    private SimpleDraweeView mIvMeIcon;
    private String mOrderMoney;
    private ImageView mQiDong;
    private RelativeLayout mRelMoney;
    private TitleBar mTitleBar;
    private TextView mTvBalance;
    private TextView mTvChakanRecored;
    private TextView mTvMeId;
    private TextView mTvMeName;
    private TextView mTvMeXueHao;
    private TextView mTvMoney;
    private TextView mTvPsw;
    private UserInfoBean mUserInfoBean;
    private View mVLine;
    private WalletModel mWalletModel;

    private void initViewNew(View view) {
        this.mTitleBar = (TitleBar) view.findViewById(R.id.tb_name);
        this.mIvMeIcon = (SimpleDraweeView) view.findViewById(R.id.iv_me_icon);
        this.mImgSex = (ImageView) view.findViewById(R.id.img_sex);
        this.mTvMeName = (TextView) view.findViewById(R.id.tv_me_name);
        this.mTvMeId = (TextView) view.findViewById(R.id.tv_me_id);
        this.mTvMeXueHao = (TextView) view.findViewById(R.id.tv_me_xuehao);
        this.mQiDong = (ImageView) view.findViewById(R.id.qidong);
        this.mImgBindCard = (ImageView) view.findViewById(R.id.img_bindcard);
        this.mTvPsw = (TextView) view.findViewById(R.id.tv_qiehuandevice);
        this.mVLine = view.findViewById(R.id.v_line);
        this.mTvChakanRecored = (TextView) view.findViewById(R.id.tv_chakanrecord);
        this.mTvMoney = (TextView) view.findViewById(R.id.tv_capture_money);
        this.mTvBalance = (TextView) view.findViewById(R.id.tv_balance);
        this.mRelMoney = (RelativeLayout) view.findViewById(R.id.rel_money);
    }

    public static DrinkWaterMainFragment newInstance() {
        return new DrinkWaterMainFragment();
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_drink_water_main, viewGroup, false);
        if (this.mWalletModel == null) {
            getActivity().finish();
            return viewInflate;
        }
        initViewNew(viewInflate);
        initTitleBar();
        initInfoView();
        initView();
        return viewInflate;
    }

    private void initTitleBar() {
        if (StringUtils.isNotEmpty(this.mWalletModel.name)) {
            this.mTitleBar.setTitleView(this.mWalletModel.name);
        } else {
            this.mTitleBar.setTitleView("饮水");
        }
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

    private void initView() {
        if (this.mWalletModel == null) {
            return;
        }
        this.mTvBalance.setText(DecimalUtil.twoDecimal(DecimalUtil.divide(this.mWalletModel.getBalance() + "", "100")) + "元");
        if (StringUtils.isNotEmpty(LocalBusinessStore.getLastDrinkWaterMoney(getContext(), this.mWalletModel.typeId))) {
            this.mTvMoney.setText(LocalBusinessStore.getLastDrinkWaterMoney(getContext(), this.mWalletModel.typeId));
        } else {
            this.mTvMoney.setText("0.30元");
        }
        this.mQiDong.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.drinkwater.DrinkWaterMainFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (DrinkWaterMainFragment.this.mWalletModel.getBalance() == 0) {
                    if (DrinkWaterMainFragment.this.mWalletModel.refund == 1) {
                        RefundProgressActivity.launch(DrinkWaterMainFragment.this.getActivity(), DrinkWaterMainFragment.this.mWalletModel);
                        return;
                    } else {
                        ToastUtils.show(DrinkWaterMainFragment.this.getContext(), "余额为0，请充值后再使用");
                        return;
                    }
                }
                if (!BluetoothManager.getInstance().isBluetoothOn()) {
                    DrinkWaterMainFragment.this.startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), 2001);
                } else if (AppUtils.isUserHuaWeiScan()) {
                    ScanQrcodeOrBarcodeActivity.launch(DrinkWaterMainFragment.this.getActivity(), DrinkWaterMainFragment.this.mWalletModel, "", 6);
                } else {
                    ZxingScanActivity.launch(DrinkWaterMainFragment.this.getActivity(), DrinkWaterMainFragment.this.mWalletModel, "", 6);
                }
            }
        });
        this.mTvChakanRecored.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.drinkwater.DrinkWaterMainFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RecordListActivity.launch(DrinkWaterMainFragment.this.getActivity(), DrinkWaterMainFragment.this.mWalletModel.typeId);
            }
        });
        this.mTvMoney.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.drinkwater.DrinkWaterMainFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DrinkWaterMainFragment.this.showAlertDialog();
            }
        });
        this.mQiDong.setOnTouchListener(new View.OnTouchListener() { // from class: client.android.yixiaotong.ui.drinkwater.DrinkWaterMainFragment.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return motionEvent.getX() < 100.0f || motionEvent.getY() < 100.0f || motionEvent.getX() > 480.0f || motionEvent.getY() > 480.0f;
            }
        });
        this.mRelMoney.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.drinkwater.DrinkWaterMainFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (DrinkWaterMainFragment.this.mWalletModel != null) {
                    WalletDetailActivity.launch(DrinkWaterMainFragment.this.getActivity(), DrinkWaterMainFragment.this.mWalletModel);
                }
            }
        });
        if (getLoginAccount().getAccountManagetStore().getUserInfo().AreaId == 35016) {
            this.mImgBindCard.setVisibility(0);
            this.mVLine.setVisibility(0);
            this.mTvPsw.setVisibility(0);
        } else {
            this.mImgBindCard.setVisibility(8);
            this.mVLine.setVisibility(8);
            this.mTvPsw.setVisibility(8);
        }
        this.mImgBindCard.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.drinkwater.DrinkWaterMainFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DrinkWaterMainFragment.this.isCheckCardFunction();
            }
        });
        this.mTvPsw.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.drinkwater.DrinkWaterMainFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DrinkWaterMainFragment.this.isCheckPsw();
            }
        });
    }

    public void showAlertDialog() {
        Dialog dialog = new Dialog(getActivity(), R.style.mydialog);
        this.mDialog = dialog;
        Window window = dialog.getWindow();
        View viewInflate = getActivity().getLayoutInflater().inflate(R.layout.drinkwater_inputmoney_dialog, (ViewGroup) null);
        final TextView textView = (TextView) viewInflate.findViewById(R.id.tv_moneythree);
        final TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_moneyfive);
        final TextView textView3 = (TextView) viewInflate.findViewById(R.id.tv_moneyone);
        final TextView textView4 = (TextView) viewInflate.findViewById(R.id.tv_moneytwo);
        final EditText editText = (EditText) viewInflate.findViewById(R.id.tv_inputmoney);
        TextView textView5 = (TextView) viewInflate.findViewById(R.id.tv_positive);
        this.mDialog.setContentView(viewInflate);
        this.mDialog.setCancelable(false);
        textView.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.drinkwater.DrinkWaterMainFragment.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DrinkWaterMainFragment.this.mDialog.dismiss();
                DrinkWaterMainFragment.this.mTvMoney.setText(textView.getText().toString());
                LocalBusinessStore.saveLastDrinkWaterMoney(DrinkWaterMainFragment.this.getContext(), DrinkWaterMainFragment.this.mWalletModel.typeId, DrinkWaterMainFragment.this.mTvMoney.getText().toString());
                PreferenceUtil.putFloat(DrinkWaterMainFragment.this.getContext(), DrinkWaterMainFragment.TYPE_CLICK_DATA + DrinkWaterMainFragment.this.getLoginAccount().getUid(), 0.3f);
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.drinkwater.DrinkWaterMainFragment.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DrinkWaterMainFragment.this.mDialog.dismiss();
                DrinkWaterMainFragment.this.mTvMoney.setText(textView2.getText().toString());
                LocalBusinessStore.saveLastDrinkWaterMoney(DrinkWaterMainFragment.this.getContext(), DrinkWaterMainFragment.this.mWalletModel.typeId, DrinkWaterMainFragment.this.mTvMoney.getText().toString());
                PreferenceUtil.putFloat(DrinkWaterMainFragment.this.getContext(), DrinkWaterMainFragment.TYPE_CLICK_DATA + DrinkWaterMainFragment.this.getLoginAccount().getUid(), 0.5f);
            }
        });
        textView3.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.drinkwater.DrinkWaterMainFragment.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DrinkWaterMainFragment.this.mDialog.dismiss();
                DrinkWaterMainFragment.this.mTvMoney.setText(textView3.getText().toString());
                LocalBusinessStore.saveLastDrinkWaterMoney(DrinkWaterMainFragment.this.getContext(), DrinkWaterMainFragment.this.mWalletModel.typeId, DrinkWaterMainFragment.this.mTvMoney.getText().toString());
                PreferenceUtil.putFloat(DrinkWaterMainFragment.this.getContext(), DrinkWaterMainFragment.TYPE_CLICK_DATA + DrinkWaterMainFragment.this.getLoginAccount().getUid(), 1.0f);
            }
        });
        textView4.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.drinkwater.DrinkWaterMainFragment.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DrinkWaterMainFragment.this.mDialog.dismiss();
                DrinkWaterMainFragment.this.mTvMoney.setText(textView4.getText().toString());
                LocalBusinessStore.saveLastDrinkWaterMoney(DrinkWaterMainFragment.this.getContext(), DrinkWaterMainFragment.this.mWalletModel.typeId, DrinkWaterMainFragment.this.mTvMoney.getText().toString());
                PreferenceUtil.putFloat(DrinkWaterMainFragment.this.getContext(), DrinkWaterMainFragment.TYPE_CLICK_DATA + DrinkWaterMainFragment.this.getLoginAccount().getUid(), 2.0f);
            }
        });
        editText.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.drinkwater.DrinkWaterMainFragment.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                editText.setFocusable(true);
                editText.setFocusableInTouchMode(true);
                editText.requestFocus();
                DrinkWaterMainFragment.this.openInputMethod(editText);
            }
        });
        textView5.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.drinkwater.DrinkWaterMainFragment.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DrinkWaterMainFragment.this.mDialog.dismiss();
                if (StringUtils.isNotEmpty(editText.getText().toString()) && DrinkWaterMainFragment.isNumerEX(editText.getText().toString())) {
                    Float fValueOf = Float.valueOf(Float.parseFloat(editText.getText().toString()));
                    if (fValueOf.floatValue() > 10.0d) {
                        ToastUtils.show(DrinkWaterMainFragment.this.getActivity(), "为了保障您的权益，单次最大消费额为10元!");
                        DrinkWaterMainFragment.this.mTvMoney.setText("10.00元");
                        LocalBusinessStore.saveLastDrinkWaterMoney(DrinkWaterMainFragment.this.getContext(), DrinkWaterMainFragment.this.mWalletModel.typeId, "10.00元");
                        PreferenceUtil.putFloat(DrinkWaterMainFragment.this.getContext(), DrinkWaterMainFragment.TYPE_CLICK_DATA + DrinkWaterMainFragment.this.getLoginAccount().getUid(), 10.0f);
                        DrinkWaterMainFragment.this.closeInputMethod();
                        return;
                    }
                    if (fValueOf.floatValue() < 0.3d) {
                        ToastUtils.show(DrinkWaterMainFragment.this.getActivity(), "最小金额为0.3元");
                        DrinkWaterMainFragment.this.mTvMoney.setText("0.30元");
                        LocalBusinessStore.saveLastDrinkWaterMoney(DrinkWaterMainFragment.this.getContext(), DrinkWaterMainFragment.this.mWalletModel.typeId, "0.30元");
                        PreferenceUtil.putFloat(DrinkWaterMainFragment.this.getContext(), DrinkWaterMainFragment.TYPE_CLICK_DATA + DrinkWaterMainFragment.this.getLoginAccount().getUid(), 0.3f);
                        DrinkWaterMainFragment.this.closeInputMethod();
                        return;
                    }
                    String strTwoDecimal = DecimalUtil.twoDecimal(editText.getText().toString());
                    Float fValueOf2 = Float.valueOf(Float.parseFloat(strTwoDecimal));
                    DrinkWaterMainFragment.this.mTvMoney.setText(strTwoDecimal + "元");
                    PreferenceUtil.putFloat(DrinkWaterMainFragment.this.getContext(), DrinkWaterMainFragment.TYPE_CLICK_DATA + DrinkWaterMainFragment.this.getLoginAccount().getUid(), fValueOf2.floatValue());
                    LocalBusinessStore.saveLastDrinkWaterMoney(DrinkWaterMainFragment.this.getContext(), DrinkWaterMainFragment.this.mWalletModel.typeId, DrinkWaterMainFragment.this.mTvMoney.getText().toString());
                    DrinkWaterMainFragment.this.closeInputMethod();
                }
            }
        });
        Display defaultDisplay = getActivity().getWindowManager().getDefaultDisplay();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = (int) (((double) defaultDisplay.getWidth()) * 0.7d);
        window.setAttributes(attributes);
        this.mDialog.show();
    }

    public void openInputMethod(EditText editText) {
        ((InputMethodManager) editText.getContext().getSystemService("input_method")).showSoftInput(editText, 0);
    }

    public void closeInputMethod() {
        InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService("input_method");
        if (!inputMethodManager.isActive() || getActivity().getCurrentFocus() == null || getActivity().getCurrentFocus().getWindowToken() == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 2);
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mWalletModel = ((DrinkWaterMainActivity) activity).getmWalletModel();
    }

    @Override // client.android.yixiaotong.BaseFragment, android.app.Fragment
    public void onResume() {
        super.onResume();
        this.mIsEnable = true;
        BluetoothSDK.getInstance().closeBLE();
        if (this.mWalletModel == null) {
            return;
        }
        String orderMoney = LocalBusinessStore.getOrderMoney(getContext(), this.mWalletModel.typeId);
        this.mOrderMoney = orderMoney;
        if (!StringUtils.isNotEmpty(orderMoney) || this.mOrderMoney.equals("0")) {
            return;
        }
        getOneApp();
    }

    @Override // client.android.yixiaotong.BaseFragment, android.app.Fragment
    public void onPause() {
        super.onPause();
        this.mIsEnable = false;
        if (this.mWalletModel == null) {
            return;
        }
        LocalBusinessStore.saveOrderMoney(getContext(), this.mWalletModel.typeId, "0");
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    public static boolean isNumerEX(String str) {
        return Pattern.compile("-?[0-9]+.?[0-9]+").matcher(str).matches() || Pattern.compile("[0-9]*").matcher(str).matches();
    }

    public void getOneApp() {
        BusinessControllers.getInstance().GetOneStudentApplication(getLoginAccount(), this.mWalletModel.typeId, new Listener<List<WalletModel>>() { // from class: client.android.yixiaotong.ui.drinkwater.DrinkWaterMainFragment.14
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, List<WalletModel> list, Object... objArr) {
                if (DrinkWaterMainFragment.this.mIsEnable) {
                    if (list != null) {
                        if (list.size() > 0) {
                            DrinkWaterMainFragment.this.mTvBalance.setText(DecimalUtil.twoDecimal(DecimalUtil.divide(list.get(0).getBalance() + "", "100")) + "元");
                            return;
                        }
                        return;
                    }
                    ToastUtils.show(DrinkWaterMainFragment.this.getContext(), "数据异常，请重新登录");
                    AccountManager.getInstance().clearLoginAccount();
                    LoginActivity.launch(BaseApplication.app);
                    ActivitiesHelper.getInstance().closeExcept(LoginActivity.class);
                }
            }
        });
    }

    @Override // android.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 2001 && i2 == -1) {
            if (AppUtils.isUserHuaWeiScan()) {
                ScanQrcodeOrBarcodeActivity.launch(getActivity(), this.mWalletModel, "", 6);
            } else {
                ZxingScanActivity.launch(getActivity(), this.mWalletModel, "", 6);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void isCheckPsw() {
        BusinessControllers.getInstance().whetherPassword(getLoginAccount(), new Listener<PasswordStateBean>() { // from class: client.android.yixiaotong.ui.drinkwater.DrinkWaterMainFragment.15
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(DrinkWaterMainFragment.this.getActivity(), "加载中..", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, PasswordStateBean passwordStateBean, Object... objArr) {
                if (DrinkWaterMainFragment.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    if (passwordStateBean.flag == 0) {
                        ResetDevicePswOldActivity.launch(DrinkWaterMainFragment.this.getActivity(), 0, "");
                    } else if (passwordStateBean.flag == 1) {
                        MachinePSWOldActivity.launch(DrinkWaterMainFragment.this.getActivity(), passwordStateBean.password);
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (DrinkWaterMainFragment.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    ErrorUtil.onFailResult(DrinkWaterMainFragment.this.getActivity(), DrinkWaterMainFragment.this.mTitleBar.getTitleViewContent(), clientException, false);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void isCheckCardFunction() {
        BusinessControllers.getInstance().isHasCardFunction(getLoginAccount(), 6, new Listener<IsHasBindCardFunctionBean>() { // from class: client.android.yixiaotong.ui.drinkwater.DrinkWaterMainFragment.16
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(DrinkWaterMainFragment.this.getActivity(), "加载中..", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, IsHasBindCardFunctionBean isHasBindCardFunctionBean, Object... objArr) {
                if (DrinkWaterMainFragment.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    if (isHasBindCardFunctionBean.type == 1) {
                        CardDetailOldActivity.launch(DrinkWaterMainFragment.this.getActivity(), 6);
                    } else {
                        ToastUtils.show(DrinkWaterMainFragment.this.getActivity(), "不支持用卡功能");
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (DrinkWaterMainFragment.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    ErrorUtil.onFailResult(DrinkWaterMainFragment.this.getActivity(), DrinkWaterMainFragment.this.mTitleBar.getTitleViewContent(), clientException, false);
                }
            }
        });
    }
}
