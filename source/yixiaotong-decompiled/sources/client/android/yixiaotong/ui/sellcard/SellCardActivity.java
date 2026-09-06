package client.android.yixiaotong.ui.sellcard;

import android.app.Activity;
import android.client.bluetoothsdk.BluetoothSDK;
import android.client.bluetoothsdk.bluetooth.BluetoothDevice;
import android.client.bluetoothsdk.listener.BluetoothConnectListener;
import android.client.bluetoothsdk.util.TimeOut;
import android.client.bluetoothsdk.util.executor.MainThreadExecutor;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.alipay.AliPayUtils;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.bean.SuccessBean;
import client.android.yixiaotong.controller.bean.sellcard.SellCardAliBean;
import client.android.yixiaotong.controller.bean.sellcard.SellCardAuthorizeBean;
import client.android.yixiaotong.controller.bean.sellcard.SellCardPriceBean;
import client.android.yixiaotong.controller.bean.sellcard.SellCardUnionBean;
import client.android.yixiaotong.controller.bean.sellcard.SellCardWeiXinPayBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.error.ErrorUtil;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.unionpay.AlipayActivity;
import client.android.yixiaotong.ui.unionpay.UnionWebActivity;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.DecimalUtil;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.android.LocalPreferencesHelper;
import client.android.yixiaotong.util.random.RandomUtils;
import client.android.yixiaotong.wxapi.WxPayUtils;
import client.android.yixiaotong.zksoundwave.SWCommandUtil;
import client.android.yixiaotong.zksoundwave.soundwavedatamanage.SoundWaveDataListener;
import com.android.volley.VolleyError;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.masget.base.ApiConfig;
import com.masget.base.volley.JSONResponseHandler;
import com.masget.base.volley.VolleyRequestNew;
import com.stub.StubApp;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class SellCardActivity extends BaseActivity {
    public static final String EXTRA_MAC = "extra_mac";
    public static final String EXTRA_MACHINEDATA = "extra_machinedata";
    public static final String EXTRA_MACHINEID = "extra_machineid";
    public static final String EXTRA_WALLET = "extra_wallet";
    private Handler mHandler;
    ImageView mImgAliay;
    ImageView mImgUnion;
    ImageView mImgWeiXin;
    private String mLanYaSendData;
    private String mMac;
    private String mMachineData;
    private String mMachineId;
    private String mOrderId;
    private int mPrice;
    TitleBar mTitleBar;
    TextView mTvPrice;
    private WalletModel mWalletModel;
    private boolean mIsAliPay = false;
    private int mConnectCount = 0;
    private boolean mIsEnable = true;
    private SystemErrorTip.SystemErrorDialogListener systemErrorDialogListener = new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.ui.sellcard.SellCardActivity.1
        @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
        public void onConfirm() {
            SellCardActivity.this.finish();
        }
    };

    static {
        StubApp.interface11(7594);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    static /* synthetic */ int access$4208(SellCardActivity sellCardActivity) {
        int i = sellCardActivity.mConnectCount;
        sellCardActivity.mConnectCount = i + 1;
        return i;
    }

    public static void launch(Activity activity, WalletModel walletModel, String str, String str2, String str3) {
        if (activity != null) {
            Intent intent = new Intent(activity, (Class<?>) SellCardActivity.class);
            intent.putExtra("extra_wallet", walletModel);
            intent.putExtra("extra_mac", str);
            intent.putExtra("extra_machineid", str2);
            intent.putExtra("extra_machinedata", str3);
            activity.startActivity(intent);
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mTvPrice = (TextView) findViewById(R.id.tv_price);
        this.mImgWeiXin = (ImageView) findViewById(R.id.img_weixin);
        this.mImgAliay = (ImageView) findViewById(R.id.img_aliay);
        this.mImgUnion = (ImageView) findViewById(R.id.img_union);
    }

    private void initTitleBar() {
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
        this.mTitleBar.setTitleView("售卡");
    }

    private void initView() {
        if (this.mWalletModel.weiXinCharge == 0) {
            this.mImgWeiXin.setVisibility(8);
        }
        if (this.mWalletModel.aliCharge == 0 && this.mWalletModel.unionCharge == 0) {
            this.mImgAliay.setVisibility(8);
        }
        if (this.mWalletModel.unionCharge == 0) {
            this.mImgUnion.setVisibility(8);
        }
        this.mImgWeiXin.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.sellcard.SellCardActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SellCardActivity.this.mIsAliPay = false;
                SellCardActivity.this.weixin();
            }
        });
        this.mImgAliay.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.sellcard.SellCardActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SellCardActivity.this.mIsAliPay = false;
                if (SellCardActivity.this.mWalletModel.aliCharge == 0 || SellCardActivity.this.mWalletModel.unionCharge != 0) {
                    if (SellCardActivity.this.mWalletModel.aliCharge != 0 || SellCardActivity.this.mWalletModel.unionCharge == 0) {
                        ToastUtils.show(SellCardActivity.this.getContext(), "支付宝和银联支付存在冲突");
                        return;
                    } else {
                        SellCardActivity.this.unionAli();
                        return;
                    }
                }
                SellCardActivity.this.mIsAliPay = true;
                SellCardActivity.this.aliPay();
            }
        });
        this.mImgUnion.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.sellcard.SellCardActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SellCardActivity.this.mIsAliPay = false;
                SellCardActivity.this.union();
            }
        });
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        Log.e("test", "onResume" + this.mIsEnable);
        this.mIsEnable = true;
        getOrderInfo();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mIsEnable = false;
        Log.e("test", "onPause" + this.mIsEnable);
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        this.mHandler.removeMessages(0);
        this.mHandler = null;
        dismissDialog();
        BluetoothSDK.getInstance().closeBLE();
    }

    private void getCardSalesPrice() {
        BusinessControllers.getInstance().getCardSalesPrice(getLoginAccount(), this.mWalletModel.typeId, RandomUtils.getRandNumMaxStringNonO(6), new Listener<SellCardPriceBean>() { // from class: client.android.yixiaotong.ui.sellcard.SellCardActivity.5
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                SellCardActivity.this.showDialog();
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SellCardPriceBean sellCardPriceBean, Object... objArr) {
                if (SellCardActivity.this.mIsEnable) {
                    SellCardActivity.this.dismissDialog();
                    if (sellCardPriceBean != null) {
                        SellCardActivity.this.mTvPrice.setText(DecimalUtil.twoDecimal(DecimalUtil.divide(sellCardPriceBean.price + "", "100")));
                        SellCardActivity.this.mPrice = sellCardPriceBean.price;
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (SellCardActivity.this.mIsEnable) {
                    SellCardActivity.this.dismissDialog();
                    ErrorUtil.onFailResult(SellCardActivity.this.getActivity(), SellCardActivity.this.mTitleBar.getTitleViewContent(), clientException, true);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void weixin() {
        BusinessControllers.getInstance().WxCardMachinePay(getLoginAccount(), this.mPrice, this.mMachineId, this.mWalletModel.typeId, new Listener<SellCardWeiXinPayBean>() { // from class: client.android.yixiaotong.ui.sellcard.SellCardActivity.6
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                SellCardActivity.this.showDialog();
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SellCardWeiXinPayBean sellCardWeiXinPayBean, Object... objArr) {
                if (SellCardActivity.this.mIsEnable) {
                    SellCardActivity.this.dismissDialog();
                    if (sellCardWeiXinPayBean != null) {
                        SellCardActivity.this.mOrderId = sellCardWeiXinPayBean.orderid;
                        WxPayUtils.pay(SellCardActivity.this.getActivity(), sellCardWeiXinPayBean.appid, sellCardWeiXinPayBean.partnerid, sellCardWeiXinPayBean.prepayid, sellCardWeiXinPayBean.noncestr, sellCardWeiXinPayBean.timestamp, sellCardWeiXinPayBean.sign);
                        return;
                    }
                    SystemErrorTip.getInstance().showTipDialog(SellCardActivity.this.getActivity(), "数据出错，下单失败");
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (SellCardActivity.this.mIsEnable) {
                    SellCardActivity.this.dismissDialog();
                    ErrorUtil.onFailResult(SellCardActivity.this.getActivity(), SellCardActivity.this.mTitleBar.getTitleViewContent(), clientException, true);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aliPay() {
        BusinessControllers.getInstance().AliCardMachinePay(getLoginAccount(), this.mPrice, this.mMachineId, this.mWalletModel.typeId, new Listener<SellCardAliBean>() { // from class: client.android.yixiaotong.ui.sellcard.SellCardActivity.7
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                SellCardActivity.this.showDialog();
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SellCardAliBean sellCardAliBean, Object... objArr) {
                if (SellCardActivity.this.mIsEnable && sellCardAliBean != null && StringUtils.isNotEmpty(sellCardAliBean.payInfo)) {
                    SellCardActivity.this.mOrderId = sellCardAliBean.orderid;
                    AliPayUtils.pay(SellCardActivity.this.getActivity(), sellCardAliBean.payInfo, new AliPayUtils.OnPayListener() { // from class: client.android.yixiaotong.ui.sellcard.SellCardActivity.7.1
                        @Override // client.android.yixiaotong.alipay.AliPayUtils.OnPayListener
                        public void paySuccess() {
                            ToastUtils.show(SellCardActivity.this.getContext(), "支付成功");
                            SellCardActivity.this.getCardSalesAuth();
                        }

                        @Override // client.android.yixiaotong.alipay.AliPayUtils.OnPayListener
                        public void payWaitting() {
                            SellCardActivity.this.dismissDialog();
                            SystemErrorTip.getInstance().showTipDialog(SellCardActivity.this.getActivity(), "正在等待支付结果,稍后会收到服务器确认的支付结果");
                        }

                        @Override // client.android.yixiaotong.alipay.AliPayUtils.OnPayListener
                        public void payFail() {
                            SellCardActivity.this.dismissDialog();
                            SystemErrorTip.getInstance().showTipDialog(SellCardActivity.this.getActivity(), "支付失败");
                        }
                    });
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (SellCardActivity.this.mIsEnable) {
                    SellCardActivity.this.dismissDialog();
                    ErrorUtil.onFailResult(SellCardActivity.this.getActivity(), SellCardActivity.this.mTitleBar.getTitleViewContent(), clientException, true);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unionAli() {
        BusinessControllers.getInstance().UnionCardMachinePay(getLoginAccount(), this.mPrice, this.mMachineId, this.mWalletModel.typeId, new Listener<SellCardUnionBean>() { // from class: client.android.yixiaotong.ui.sellcard.SellCardActivity.8
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                SellCardActivity.this.showDialog();
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, final SellCardUnionBean sellCardUnionBean, Object... objArr) {
                String strOptString;
                String strOptString2;
                String strOptString3;
                if (SellCardActivity.this.mIsEnable) {
                    SellCardActivity.this.dismissDialog();
                    if (sellCardUnionBean != null) {
                        SellCardActivity.this.mOrderId = sellCardUnionBean.orderID;
                        try {
                            JSONObject jSONObject = new JSONObject(sellCardUnionBean.settmentInfo);
                            strOptString = jSONObject.optString("settlementtype");
                            try {
                                strOptString2 = jSONObject.optString("settlementparams");
                                try {
                                    strOptString3 = jSONObject.optString("extraparams");
                                } catch (JSONException e) {
                                    e = e;
                                    e.printStackTrace();
                                    strOptString3 = "";
                                }
                            } catch (JSONException e2) {
                                e = e2;
                                strOptString2 = "";
                            }
                        } catch (JSONException e3) {
                            e = e3;
                            strOptString = "";
                            strOptString2 = strOptString;
                        }
                        HashMap map = new HashMap();
                        map.put("ordernumber", sellCardUnionBean.orderID);
                        map.put(TtmlNode.TAG_BODY, "APP支付宝充值支付");
                        map.put("amount", Integer.valueOf(SellCardActivity.this.mPrice));
                        map.put("businesstype", "2001");
                        map.put("paymenttypeid", "12");
                        if (StringUtils.isNotEmpty(strOptString3)) {
                            map.put("extraparams", strOptString3);
                        }
                        if (StringUtils.isNotEmpty(strOptString2) && sellCardUnionBean.mainUnionCompanyId != sellCardUnionBean.unionCompanyId) {
                            map.put("subcompanyid", sellCardUnionBean.unionCompanyId + "");
                            map.put("settlementtype", strOptString);
                            map.put("settlementparams", strOptString2);
                        }
                        map.put("unionSession", sellCardUnionBean.unionSession);
                        map.put("unionAppKey", sellCardUnionBean.unionAppKey);
                        map.put("companyid", sellCardUnionBean.mainUnionCompanyId + "");
                        VolleyRequestNew.postJson(true, ApiConfig.URL_PAY, map, new JSONResponseHandler() { // from class: client.android.yixiaotong.ui.sellcard.SellCardActivity.8.1
                            @Override // com.masget.base.volley.JSONResponseHandler
                            public void onSuccess(JSONObject jSONObject2) {
                                if (jSONObject2.optInt("ret") != 0) {
                                    SellCardActivity.this.dismissDialog();
                                    ToastUtils.show(SellCardActivity.this.getContext(), jSONObject2.optString(CrashHianalyticsData.MESSAGE));
                                    return;
                                }
                                try {
                                    String strOptString4 = new JSONObject(jSONObject2.optString("data")).optString("qrcode");
                                    if (StringUtils.isNotEmpty(strOptString4)) {
                                        LocalPreferencesHelper localPreferencesHelper = new LocalPreferencesHelper(SellCardActivity.this.getContext(), "default_alipay_preferences");
                                        localPreferencesHelper.saveOrUpdate("paystate", "0");
                                        localPreferencesHelper.saveOrUpdate("payRespcode", "0");
                                        Intent intent = new Intent(SellCardActivity.this.getActivity(), (Class<?>) AlipayActivity.class);
                                        intent.putExtra("qrcode", strOptString4);
                                        intent.putExtra("ordernumber", sellCardUnionBean.orderID);
                                        intent.putExtra("mainUnionCompanyId", sellCardUnionBean.mainUnionCompanyId + "");
                                        intent.putExtra("unionSession", sellCardUnionBean.unionSession);
                                        intent.putExtra("unionAppKey", sellCardUnionBean.unionAppKey);
                                        SellCardActivity.this.startActivity(intent);
                                        SellCardActivity.this.dismissDialog();
                                    }
                                } catch (JSONException e4) {
                                    e4.printStackTrace();
                                }
                            }

                            @Override // com.masget.base.volley.JSONResponseHandler
                            public void onFail(VolleyError volleyError) {
                                SellCardActivity.this.dismissDialog();
                                SystemErrorTip.getInstance().showTipDialog(SellCardActivity.this.getActivity(), "下单失败");
                            }
                        });
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (SellCardActivity.this.mIsEnable) {
                    SellCardActivity.this.dismissDialog();
                    ErrorUtil.onFailResult(SellCardActivity.this.getActivity(), SellCardActivity.this.mTitleBar.getTitleViewContent(), clientException, true);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void union() {
        BusinessControllers.getInstance().UnionCardMachinePay(getLoginAccount(), this.mPrice, this.mMachineId, this.mWalletModel.typeId, new Listener<SellCardUnionBean>() { // from class: client.android.yixiaotong.ui.sellcard.SellCardActivity.9
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                SellCardActivity.this.showDialog();
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SellCardUnionBean sellCardUnionBean, Object... objArr) {
                String strOptString;
                String strOptString2;
                String strOptString3;
                if (SellCardActivity.this.mIsEnable) {
                    SellCardActivity.this.dismissDialog();
                    if (sellCardUnionBean != null) {
                        SellCardActivity.this.mOrderId = sellCardUnionBean.orderID;
                        try {
                            JSONObject jSONObject = new JSONObject(sellCardUnionBean.settmentInfo);
                            strOptString = jSONObject.optString("settlementtype");
                            try {
                                strOptString2 = jSONObject.optString("settlementparams");
                                try {
                                    strOptString3 = jSONObject.optString("extraparams");
                                } catch (JSONException e) {
                                    e = e;
                                    e.printStackTrace();
                                    strOptString3 = "";
                                }
                            } catch (JSONException e2) {
                                e = e2;
                                strOptString2 = "";
                            }
                        } catch (JSONException e3) {
                            e = e3;
                            strOptString = "";
                            strOptString2 = strOptString;
                        }
                        HashMap map = new HashMap();
                        map.put("ordernumber", sellCardUnionBean.orderID);
                        map.put(TtmlNode.TAG_BODY, "APP银联在线充值支付");
                        map.put("amount", Integer.valueOf(SellCardActivity.this.mPrice));
                        map.put("businesstype", "1001");
                        map.put("paymenttypeid", "4");
                        if (StringUtils.isNotEmpty(strOptString3)) {
                            map.put("extraparams", strOptString3);
                        }
                        if (StringUtils.isNotEmpty(strOptString2) && sellCardUnionBean.mainUnionCompanyId != sellCardUnionBean.unionCompanyId) {
                            map.put("subcompanyid", sellCardUnionBean.unionCompanyId + "");
                            map.put("settlementtype", strOptString);
                            map.put("settlementparams", strOptString2);
                        }
                        map.put("unionSession", sellCardUnionBean.unionSession);
                        map.put("unionAppKey", sellCardUnionBean.unionAppKey);
                        map.put("companyid", sellCardUnionBean.mainUnionCompanyId + "");
                        String strPostUrlEncrypt = VolleyRequestNew.postUrlEncrypt(ApiConfig.URL_PAY, map, true);
                        if (strPostUrlEncrypt == null) {
                            SellCardActivity.this.dismissDialog();
                            SystemErrorTip.getInstance().showTipDialog(SellCardActivity.this.getActivity(), "获取订单失败");
                            return;
                        }
                        Intent intent = new Intent(SellCardActivity.this.getActivity(), (Class<?>) UnionWebActivity.class);
                        intent.putExtra("url", strPostUrlEncrypt);
                        intent.putExtra("ordernumber", sellCardUnionBean.orderID);
                        intent.putExtra("mainUnionCompanyId", sellCardUnionBean.mainUnionCompanyId + "");
                        intent.putExtra("unionSession", sellCardUnionBean.unionSession);
                        intent.putExtra("unionAppKey", sellCardUnionBean.unionAppKey);
                        SellCardActivity.this.startActivity(intent);
                        SellCardActivity.this.dismissDialog();
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (SellCardActivity.this.mIsEnable) {
                    SellCardActivity.this.dismissDialog();
                    ErrorUtil.onFailResult(SellCardActivity.this.getActivity(), SellCardActivity.this.mTitleBar.getTitleViewContent(), clientException, true);
                }
            }
        });
    }

    private void getOrderInfo() {
        if (!StringUtils.isNotEmpty(this.mOrderId) || this.mIsAliPay) {
            return;
        }
        BusinessControllers.getInstance().GerOrdersInfo(getLoginAccount(), this.mOrderId, new Listener<SuccessBean>() { // from class: client.android.yixiaotong.ui.sellcard.SellCardActivity.10
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(SellCardActivity.this.getActivity(), "正在查询订单状态", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SuccessBean successBean, Object... objArr) {
                if (successBean == null || !SellCardActivity.this.mIsEnable) {
                    return;
                }
                if (successBean.success == 1) {
                    SellCardActivity.this.getCardSalesAuth();
                } else {
                    SellCardActivity.this.dismissDialog();
                    ToastUtils.show(SellCardActivity.this.getContext(), "订单未支付！");
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (SellCardActivity.this.mIsEnable) {
                    SellCardActivity.this.dismissDialog();
                    ErrorUtil.onFailResult(SellCardActivity.this.getActivity(), SellCardActivity.this.mTitleBar.getTitleViewContent(), clientException, true);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getCardSalesAuth() {
        BusinessControllers.getInstance().getCardSalesAuth(getLoginAccount(), 0, this.mMachineId, this.mWalletModel.typeId, 0, RandomUtils.getRandNumMaxStringNonO(6), 1, this.mOrderId, this.mMachineData, this.mPrice, new Listener<SellCardAuthorizeBean>() { // from class: client.android.yixiaotong.ui.sellcard.SellCardActivity.11
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(SellCardActivity.this.getActivity(), "正在授权", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SellCardAuthorizeBean sellCardAuthorizeBean, Object... objArr) {
                Log.e("test", "onComplete" + SellCardActivity.this.mIsEnable);
                if (SellCardActivity.this.mIsEnable) {
                    if (sellCardAuthorizeBean == null) {
                        SellCardActivity.this.dismissDialog();
                        return;
                    }
                    Log.e("test", "onComplete 开始连接设备");
                    SWCommandUtil.getInstance().sendGetQrcodeData(sellCardAuthorizeBean.systemData, sellCardAuthorizeBean.systemTime);
                    BluetoothSDK.getInstance().ConnectManagerDevice(new BluetoothDevice("", SellCardActivity.this.mMac));
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (SellCardActivity.this.mIsEnable) {
                    SellCardActivity.this.dismissDialog();
                    ErrorUtil.onFailResult(SellCardActivity.this.getActivity(), SellCardActivity.this.mTitleBar.getTitleViewContent(), clientException, true);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog() {
        BaseMaterialDialog.showMaterialDialog(getActivity(), "加载中...", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissDialog() {
        BaseMaterialDialog.dissmisMaterialDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDialogShowing() {
        return BaseMaterialDialog.isShowMaterialDialog();
    }

    private void initSW() {
        SWCommandUtil.getInstance().initDataManage();
        SWCommandUtil.getInstance().setDataListener(new SoundWaveDataListener() { // from class: client.android.yixiaotong.ui.sellcard.SellCardActivity.12
            @Override // client.android.yixiaotong.zksoundwave.soundwavedatamanage.SoundWaveDataListener
            public void onQrcodeData(String str, String str2, int i) {
            }

            @Override // client.android.yixiaotong.zksoundwave.soundwavedatamanage.SoundWaveDataListener
            public void onGetQrcodeData(String str) {
                SellCardActivity.this.mLanYaSendData = str;
            }
        });
    }

    private void initHandler() {
        this.mHandler = new Handler() { // from class: client.android.yixiaotong.ui.sellcard.SellCardActivity.13
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (SellCardActivity.this.isDialogShowing()) {
                    SellCardActivity.this.dismissDialog();
                    SystemErrorTip.getInstance().showTipDialog(SellCardActivity.this.getActivity(), "连接售卡机超时了，请稍后再重试");
                }
            }
        };
    }

    private void initLanYa() {
        BluetoothSDK.getInstance().init(getContext());
        Log.e("test", "initLanYa");
        BluetoothSDK.getInstance().setListener(new BluetoothConnectListener() { // from class: client.android.yixiaotong.ui.sellcard.SellCardActivity.14
            @Override // android.client.bluetoothsdk.listener.BluetoothConnectListener
            public void onStart(BluetoothDevice bluetoothDevice) {
                Log.e("test", "onStart:");
                BaseMaterialDialog.showMaterialDialog(SellCardActivity.this.getActivity(), "正在连接设备...", false);
                SellCardActivity.this.mHandler.sendEmptyMessageDelayed(0, 30000L);
            }

            @Override // android.client.bluetoothsdk.listener.BluetoothConnectListener
            public void onBluetoothException(android.client.bluetoothsdk.util.ClientException clientException) {
                if (SellCardActivity.this.mIsEnable) {
                    SellCardActivity.this.dismissDialog();
                    SystemErrorTip.getInstance().showTipDialog(SellCardActivity.this.getActivity(), clientException.getDetail());
                }
            }

            @Override // android.client.bluetoothsdk.listener.BluetoothConnectListener
            public void onFail(BluetoothDevice bluetoothDevice, TimeOut timeOut, String str) {
                Log.e("test", "onFail:" + SellCardActivity.this.mIsEnable + "  " + SellCardActivity.this.mConnectCount);
                if (SellCardActivity.this.mIsEnable) {
                    SellCardActivity.access$4208(SellCardActivity.this);
                    if (SellCardActivity.this.mConnectCount > 1) {
                        SellCardActivity.this.dismissDialog();
                        if (StringUtils.isNotEmpty(str)) {
                            SystemErrorTip.getInstance().showTipDialog(SellCardActivity.this.getActivity(), SellCardActivity.this.systemErrorDialogListener, str + "，连接设备失败");
                            return;
                        } else {
                            SystemErrorTip.getInstance().showTipDialog(SellCardActivity.this.getActivity(), SellCardActivity.this.systemErrorDialogListener, "连接设备失败" + timeOut);
                            return;
                        }
                    }
                    BluetoothSDK.getInstance().ConnectManagerDevice(new BluetoothDevice("", SellCardActivity.this.mMac));
                }
            }

            @Override // android.client.bluetoothsdk.listener.BluetoothConnectListener
            public void onSuccessConnect(BluetoothDevice bluetoothDevice) {
                Log.e("test", "onSuccessConnect:" + SellCardActivity.this.mLanYaSendData);
                MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.ui.sellcard.SellCardActivity.14.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SellCardActivity.this.dismissDialog();
                        if (StringUtils.isNotEmpty(SellCardActivity.this.mLanYaSendData)) {
                            BluetoothSDK.getInstance().SendDataManagerDevice(SellCardActivity.this.mLanYaSendData);
                        }
                    }
                }, 200L);
            }

            @Override // android.client.bluetoothsdk.listener.BluetoothConnectListener
            public void onSuccessSendData(BluetoothDevice bluetoothDevice, String str) {
                Log.e("test", "onSuccessSendData:" + str);
                SellCardActivity.this.dismissDialog();
                ToastUtils.show(SellCardActivity.this.getContext(), "机器正在出卡中...");
                SellCardActivity.this.finish();
            }
        });
    }
}
