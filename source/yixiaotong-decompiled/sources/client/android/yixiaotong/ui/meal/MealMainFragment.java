package client.android.yixiaotong.ui.meal;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import client.android.yixiaotong.BaseApplication;
import client.android.yixiaotong.BaseFragment;
import client.android.yixiaotong.R;
import client.android.yixiaotong.baseutil.CoderUtils;
import client.android.yixiaotong.baseutil.IntegerUtils;
import client.android.yixiaotong.baseutil.MacDesUtils;
import client.android.yixiaotong.baseutil.QrcodeUtils;
import client.android.yixiaotong.baseutil.RandomUtils;
import client.android.yixiaotong.baseutil.ShortUtils;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.bean.GetMealQrcodeBean;
import client.android.yixiaotong.controller.bean.UserInfoBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.controller.store.LocalBusinessStore;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.sdk.utils.HexString;
import client.android.yixiaotong.ui.RecordListActivity;
import client.android.yixiaotong.ui.WalletDetailActivity;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.DecimalUtil;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.android.NetworkUtils;
import client.android.yixiaotong.util.executor.AsyncQueueExecutor;
import client.android.yixiaotong.util.executor.MainThreadExecutor;
import com.afollestad.materialdialogs.MaterialDialog;
import com.facebook.common.util.UriUtil;
import com.facebook.drawee.view.SimpleDraweeView;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class MealMainFragment extends BaseFragment {
    private Bitmap mBitmap;
    Button mBtnRefresh;
    ImageView mImgSex;
    SimpleDraweeView mIvMeIcon;
    private MaterialDialog mMaterialDialog;
    RelativeLayout mRelMoney;
    private String mTime;
    TitleBar mTitleBar;
    TextView mTvBalance;
    TextView mTvMeId;
    TextView mTvMeName;
    TextView mTvMeXueHao;
    TextView mTvRecord;
    private UserInfoBean mUserInfoBean;
    private WalletModel mWalletModel;
    ImageView qrcodeImg;
    private boolean mIsEnable = true;
    private Handler mHandler = new Handler() { // from class: client.android.yixiaotong.ui.meal.MealMainFragment.7
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (MealMainFragment.this.mBitmap != null) {
                Matrix matrix = new Matrix();
                matrix.setScale(0.5f, 0.5f);
                MealMainFragment.this.qrcodeImg.setImageBitmap(Bitmap.createBitmap(MealMainFragment.this.mBitmap, 0, 0, MealMainFragment.this.mBitmap.getWidth(), MealMainFragment.this.mBitmap.getHeight(), matrix, true));
            }
        }
    };

    private void initViewNew(View view) {
        this.mTitleBar = (TitleBar) view.findViewById(R.id.tb_name);
        this.mIvMeIcon = (SimpleDraweeView) view.findViewById(R.id.iv_me_icon);
        this.mImgSex = (ImageView) view.findViewById(R.id.img_sex);
        this.mTvMeName = (TextView) view.findViewById(R.id.tv_me_name);
        this.mTvMeId = (TextView) view.findViewById(R.id.tv_me_id);
        this.mTvMeXueHao = (TextView) view.findViewById(R.id.tv_me_xuehao);
        this.qrcodeImg = (ImageView) view.findViewById(R.id.qrcode);
        this.mTvRecord = (TextView) view.findViewById(R.id.tv_chakanrecord);
        this.mBtnRefresh = (Button) view.findViewById(R.id.btn_refresh);
        this.mTvBalance = (TextView) view.findViewById(R.id.tv_balance);
        this.mRelMoney = (RelativeLayout) view.findViewById(R.id.rel_money);
    }

    public static MealMainFragment newInstance() {
        return new MealMainFragment();
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_meal_main, viewGroup, false);
        initViewNew(viewInflate);
        initTitleBar();
        initInfoView();
        getWalletMonel();
        return viewInflate;
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView("用餐");
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

    private void getWalletMonel() {
        BusinessControllers.getInstance().getWalletModels(getLoginAccount(), new Listener<List<WalletModel>>() { // from class: client.android.yixiaotong.ui.meal.MealMainFragment.1
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, List<WalletModel> list, Object... objArr) {
                if (list != null) {
                    for (WalletModel walletModel : list) {
                        if (walletModel.typeId == 5) {
                            MealMainFragment.this.mWalletModel = walletModel;
                            MealMainFragment.this.initView();
                            MealMainFragment.this.initData();
                        }
                    }
                    return;
                }
                MealMainFragment.this.getActivity().finish();
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                SystemErrorTip.getInstance().showTipDialog(MealMainFragment.this.getActivity(), new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.ui.meal.MealMainFragment.1.1
                    @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                    public void onConfirm() {
                        MealMainFragment.this.getActivity().finish();
                    }
                }, clientException.getDetail());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initView() {
        if (this.mWalletModel == null) {
            return;
        }
        this.mTvBalance.setText(DecimalUtil.twoDecimal(DecimalUtil.divide(this.mWalletModel.getBalance() + "", "100")) + "元");
        this.mTvRecord.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.meal.MealMainFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RecordListActivity.launch(MealMainFragment.this.getActivity(), 5);
            }
        });
        this.mBtnRefresh.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.meal.MealMainFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MealMainFragment.this.initData();
            }
        });
        this.mRelMoney.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.meal.MealMainFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MealMainFragment.this.mWalletModel != null) {
                    WalletDetailActivity.launch(MealMainFragment.this.getActivity(), MealMainFragment.this.mWalletModel);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        if (this.mWalletModel == null) {
            return;
        }
        if (!NetworkUtils.isNetworkAvailable(getContext())) {
            ToastUtils.show(getContext(), "请检查网络后重试");
        } else {
            BusinessControllers.getInstance().getMealQrCode(getLoginAccount(), this.mWalletModel.ID, new Listener<GetMealQrcodeBean>() { // from class: client.android.yixiaotong.ui.meal.MealMainFragment.5
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onStart(Controller controller) {
                    MealMainFragment.this.mMaterialDialog = new MaterialDialog.Builder(MealMainFragment.this.getActivity()).content("正在处理中,请稍候...").cancelable(false).progress(true, 0).show();
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, GetMealQrcodeBean getMealQrcodeBean, Object... objArr) {
                    if (MealMainFragment.this.mIsEnable) {
                        MealMainFragment.this.mMaterialDialog.dismiss();
                        MealMainFragment.this.mTime = getMealQrcodeBean.time;
                        MealMainFragment.this.generate((int) (getMealQrcodeBean.Balance * 100.0f), "00");
                    }
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onFail(Controller controller, ClientException clientException) {
                    if (MealMainFragment.this.mIsEnable) {
                        MealMainFragment.this.mMaterialDialog.dismiss();
                        MealMainFragment mealMainFragment = MealMainFragment.this;
                        mealMainFragment.generate((int) mealMainFragment.mWalletModel.getBalance(), "01");
                    }
                }
            });
        }
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        this.mIsEnable = true;
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        this.mIsEnable = false;
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    private void refreshQrcode(final String str) {
        AsyncQueueExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.ui.meal.MealMainFragment.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    final Bitmap bitmapCreateQrcode = QrcodeUtils.createQrcode(str);
                    MealMainFragment.this.mBitmap = bitmapCreateQrcode;
                    File file = new File(BaseApplication.app.getImageTmpDir(), "qrcode.jpg");
                    if (file.exists()) {
                        file.delete();
                    }
                    file.createNewFile();
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    bitmapCreateQrcode.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                    IOUtils.closeQuietly((OutputStream) fileOutputStream);
                    MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.ui.meal.MealMainFragment.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MealMainFragment.this.qrcodeImg.setImageBitmap(bitmapCreateQrcode);
                        }
                    });
                } catch (Exception unused) {
                    MealMainFragment.this.mHandler.sendEmptyMessage(1);
                }
            }
        });
    }

    private String getTime(String str) {
        return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(Long.parseLong(str) * 1000));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void generate(int i, String str) {
        String time;
        String str2 = getLoginAccount().getAccountManagetStore().getUserInfo().StudentName;
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        String strSubstring = (HexString.bufferToHex(CoderUtils.getBytesByGB2312String2(str2, str2.length())) + "0000000000000000").substring(0, 16);
        if (StringUtils.isNotEmpty(this.mTime)) {
            time = getTime(this.mTime);
        } else {
            time = new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime());
        }
        String strSubstring2 = HexString.bufferToHex(IntegerUtils.intToBytes(i)).substring(2, 8);
        short qrcodeCountToday = LocalBusinessStore.getQrcodeCountToday(getContext());
        LocalBusinessStore.setQrcodeCountToday(getContext(), (short) (qrcodeCountToday + 1));
        String strBufferToHex = HexString.bufferToHex(ShortUtils.shortToBytes(qrcodeCountToday));
        String randomString = RandomUtils.getRandomString();
        refreshQrcode(new MacDesUtils().PBOC_1DES(strSubstring + getLoginAccount().getUid() + time + strSubstring2 + str + strBufferToHex + "0000", "AA55A55A" + randomString, 0) + randomString);
    }
}
