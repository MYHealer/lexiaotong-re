package client.android.yixiaotong.ui.hairdryer;

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
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.controller.store.LocalBusinessStore;
import client.android.yixiaotong.ui.RecordListActivity;
import client.android.yixiaotong.ui.RefundProgressActivity;
import client.android.yixiaotong.ui.WalletDetailActivity;
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
public class HairDryerMainFragment extends BaseFragment {
    private static final String TYPE_CLICK_DATA = "type_click_data";
    private Dialog mDialog;
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
    private TextView mTvQiehuanDevice;
    private UserInfoBean mUserInfoBean;
    private WalletModel mWalletModel;

    private void initViewNew(View view) {
        this.mTitleBar = (TitleBar) view.findViewById(R.id.tb_name);
        this.mIvMeIcon = (SimpleDraweeView) view.findViewById(R.id.iv_me_icon);
        this.mImgSex = (ImageView) view.findViewById(R.id.img_sex);
        this.mQiDong = (ImageView) view.findViewById(R.id.qidong);
        this.mTvMeName = (TextView) view.findViewById(R.id.tv_me_name);
        this.mTvMeId = (TextView) view.findViewById(R.id.tv_me_id);
        this.mTvMeXueHao = (TextView) view.findViewById(R.id.tv_me_xuehao);
        this.mTvQiehuanDevice = (TextView) view.findViewById(R.id.tv_qiehuandevice);
        this.mTvChakanRecored = (TextView) view.findViewById(R.id.tv_chakanrecord);
        this.mTvMoney = (TextView) view.findViewById(R.id.tv_capture_money);
        this.mTvBalance = (TextView) view.findViewById(R.id.tv_balance);
        this.mRelMoney = (RelativeLayout) view.findViewById(R.id.rel_money);
    }

    public static HairDryerMainFragment newInstance() {
        return new HairDryerMainFragment();
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_hair_dryer_main, viewGroup, false);
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
        this.mTitleBar.setTitleView("吹风");
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
        this.mQiDong.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.hairdryer.HairDryerMainFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HairDryerMainFragment.this.mWalletModel.getBalance() == 0) {
                    if (HairDryerMainFragment.this.mWalletModel.refund == 1) {
                        RefundProgressActivity.launch(HairDryerMainFragment.this.getActivity(), HairDryerMainFragment.this.mWalletModel);
                        return;
                    } else {
                        ToastUtils.show(HairDryerMainFragment.this.getContext(), "余额为0，请充值后再使用");
                        return;
                    }
                }
                if (!BluetoothManager.getInstance().isBluetoothOn()) {
                    HairDryerMainFragment.this.startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), 2001);
                } else if (AppUtils.isUserHuaWeiScan()) {
                    ScanQrcodeOrBarcodeActivity.launch(HairDryerMainFragment.this.getActivity(), HairDryerMainFragment.this.mWalletModel, "", 8);
                } else {
                    ZxingScanActivity.launch(HairDryerMainFragment.this.getActivity(), HairDryerMainFragment.this.mWalletModel, "", 8);
                }
            }
        });
        this.mTvQiehuanDevice.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.hairdryer.HairDryerMainFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.mTvChakanRecored.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.hairdryer.HairDryerMainFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RecordListActivity.launch(HairDryerMainFragment.this.getActivity(), 8);
            }
        });
        this.mTvMoney.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.hairdryer.HairDryerMainFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HairDryerMainFragment.this.showAlertDialog();
            }
        });
        this.mQiDong.setOnTouchListener(new View.OnTouchListener() { // from class: client.android.yixiaotong.ui.hairdryer.HairDryerMainFragment.5
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return motionEvent.getX() < 100.0f || motionEvent.getY() < 100.0f || motionEvent.getX() > 480.0f || motionEvent.getY() > 480.0f;
            }
        });
        this.mRelMoney.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.hairdryer.HairDryerMainFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HairDryerMainFragment.this.mWalletModel != null) {
                    WalletDetailActivity.launch(HairDryerMainFragment.this.getActivity(), HairDryerMainFragment.this.mWalletModel);
                }
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
        textView.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.hairdryer.HairDryerMainFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HairDryerMainFragment.this.mDialog.dismiss();
                HairDryerMainFragment.this.mTvMoney.setText(textView.getText().toString());
                LocalBusinessStore.saveLastDrinkWaterMoney(HairDryerMainFragment.this.getContext(), HairDryerMainFragment.this.mWalletModel.typeId, HairDryerMainFragment.this.mTvMoney.getText().toString());
                PreferenceUtil.putFloatHairDryer(HairDryerMainFragment.this.getContext(), HairDryerMainFragment.TYPE_CLICK_DATA + HairDryerMainFragment.this.getLoginAccount().getUid(), 0.3f);
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.hairdryer.HairDryerMainFragment.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HairDryerMainFragment.this.mDialog.dismiss();
                HairDryerMainFragment.this.mTvMoney.setText(textView2.getText().toString());
                LocalBusinessStore.saveLastDrinkWaterMoney(HairDryerMainFragment.this.getContext(), HairDryerMainFragment.this.mWalletModel.typeId, HairDryerMainFragment.this.mTvMoney.getText().toString());
                PreferenceUtil.putFloatHairDryer(HairDryerMainFragment.this.getContext(), HairDryerMainFragment.TYPE_CLICK_DATA + HairDryerMainFragment.this.getLoginAccount().getUid(), 0.5f);
            }
        });
        textView3.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.hairdryer.HairDryerMainFragment.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HairDryerMainFragment.this.mDialog.dismiss();
                HairDryerMainFragment.this.mTvMoney.setText(textView3.getText().toString());
                LocalBusinessStore.saveLastDrinkWaterMoney(HairDryerMainFragment.this.getContext(), HairDryerMainFragment.this.mWalletModel.typeId, HairDryerMainFragment.this.mTvMoney.getText().toString());
                PreferenceUtil.putFloatHairDryer(HairDryerMainFragment.this.getContext(), HairDryerMainFragment.TYPE_CLICK_DATA + HairDryerMainFragment.this.getLoginAccount().getUid(), 1.0f);
            }
        });
        textView4.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.hairdryer.HairDryerMainFragment.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HairDryerMainFragment.this.mDialog.dismiss();
                HairDryerMainFragment.this.mTvMoney.setText(textView4.getText().toString());
                LocalBusinessStore.saveLastDrinkWaterMoney(HairDryerMainFragment.this.getContext(), HairDryerMainFragment.this.mWalletModel.typeId, HairDryerMainFragment.this.mTvMoney.getText().toString());
                PreferenceUtil.putFloatHairDryer(HairDryerMainFragment.this.getContext(), HairDryerMainFragment.TYPE_CLICK_DATA + HairDryerMainFragment.this.getLoginAccount().getUid(), 2.0f);
            }
        });
        editText.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.hairdryer.HairDryerMainFragment.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                editText.setFocusable(true);
                editText.setFocusableInTouchMode(true);
                editText.requestFocus();
                HairDryerMainFragment.this.openInputMethod(editText);
            }
        });
        textView5.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.hairdryer.HairDryerMainFragment.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HairDryerMainFragment.this.mDialog.dismiss();
                if (StringUtils.isNotEmpty(editText.getText().toString()) && HairDryerMainFragment.isNumerEX(editText.getText().toString())) {
                    Float fValueOf = Float.valueOf(Float.parseFloat(editText.getText().toString()));
                    if (fValueOf.floatValue() > 5.0d) {
                        ToastUtils.show(HairDryerMainFragment.this.getActivity(), "为了保障您的权益，单次最大消费额为5元!");
                        HairDryerMainFragment.this.mTvMoney.setText("5.00元");
                        LocalBusinessStore.saveLastDrinkWaterMoney(HairDryerMainFragment.this.getContext(), HairDryerMainFragment.this.mWalletModel.typeId, "5.00元");
                        PreferenceUtil.putFloatHairDryer(HairDryerMainFragment.this.getContext(), HairDryerMainFragment.TYPE_CLICK_DATA + HairDryerMainFragment.this.getLoginAccount().getUid(), 5.0f);
                        HairDryerMainFragment.this.closeInputMethod();
                        return;
                    }
                    if (fValueOf.floatValue() < 0.3d) {
                        ToastUtils.show(HairDryerMainFragment.this.getActivity(), "最小金额为0.3元");
                        HairDryerMainFragment.this.mTvMoney.setText("0.30元");
                        LocalBusinessStore.saveLastDrinkWaterMoney(HairDryerMainFragment.this.getContext(), HairDryerMainFragment.this.mWalletModel.typeId, "0.30元");
                        PreferenceUtil.putFloatHairDryer(HairDryerMainFragment.this.getContext(), HairDryerMainFragment.TYPE_CLICK_DATA + HairDryerMainFragment.this.getLoginAccount().getUid(), 0.3f);
                        HairDryerMainFragment.this.closeInputMethod();
                        return;
                    }
                    String strTwoDecimal = DecimalUtil.twoDecimal(editText.getText().toString());
                    Float fValueOf2 = Float.valueOf(Float.parseFloat(strTwoDecimal));
                    HairDryerMainFragment.this.mTvMoney.setText(strTwoDecimal + "元");
                    PreferenceUtil.putFloatHairDryer(HairDryerMainFragment.this.getContext(), HairDryerMainFragment.TYPE_CLICK_DATA + HairDryerMainFragment.this.getLoginAccount().getUid(), fValueOf2.floatValue());
                    LocalBusinessStore.saveLastDrinkWaterMoney(HairDryerMainFragment.this.getContext(), HairDryerMainFragment.this.mWalletModel.typeId, HairDryerMainFragment.this.mTvMoney.getText().toString());
                    HairDryerMainFragment.this.closeInputMethod();
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
        this.mWalletModel = ((HairDryerMainActivity) activity).getmWalletModel();
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
        BusinessControllers.getInstance().GetOneStudentApplication(getLoginAccount(), this.mWalletModel.typeId, new Listener<List<WalletModel>>() { // from class: client.android.yixiaotong.ui.hairdryer.HairDryerMainFragment.13
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, List<WalletModel> list, Object... objArr) {
                if (HairDryerMainFragment.this.mIsEnable) {
                    if (list != null) {
                        if (list.size() > 0) {
                            HairDryerMainFragment.this.mTvBalance.setText(DecimalUtil.twoDecimal(DecimalUtil.divide(list.get(0).getBalance() + "", "100")) + "元");
                            return;
                        }
                        return;
                    }
                    ToastUtils.show(HairDryerMainFragment.this.getContext(), "数据异常，请重新登录");
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
                ScanQrcodeOrBarcodeActivity.launch(getActivity(), this.mWalletModel, "", 8);
            } else {
                ZxingScanActivity.launch(getActivity(), this.mWalletModel, "", 8);
            }
        }
    }
}
