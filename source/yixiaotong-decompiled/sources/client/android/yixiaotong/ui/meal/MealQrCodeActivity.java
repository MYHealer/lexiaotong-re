package client.android.yixiaotong.ui.meal;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.BaseApplication;
import client.android.yixiaotong.R;
import client.android.yixiaotong.baseutil.BrightnessUtils;
import client.android.yixiaotong.baseutil.CoderUtils;
import client.android.yixiaotong.baseutil.IntegerUtils;
import client.android.yixiaotong.baseutil.MacDesUtils;
import client.android.yixiaotong.baseutil.QrcodeUtils;
import client.android.yixiaotong.baseutil.RandomUtils;
import client.android.yixiaotong.baseutil.ShortUtils;
import client.android.yixiaotong.controller.bean.GetMealQrcodeBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.controller.store.LocalBusinessStore;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.sdk.utils.HexString;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.executor.AsyncQueueExecutor;
import client.android.yixiaotong.util.executor.MainThreadExecutor;
import com.afollestad.materialdialogs.MaterialDialog;
import com.stub.StubApp;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class MealQrCodeActivity extends BaseActivity {
    private boolean isAutoBrightness = false;
    private int mBrightness;
    private MaterialDialog mMaterialDialog;
    private String mTime;
    TitleBar mTitlebar;
    TextView mTvRecord;
    private WalletModel mWalletModel;
    ImageView qrcodeImg;

    static {
        StubApp.interface11(7500);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, WalletModel walletModel) {
        Intent intent = new Intent(activity, (Class<?>) MealQrCodeActivity.class);
        intent.putExtra("walletModel", walletModel);
        activity.startActivity(intent);
    }

    private void initViewNew() {
        this.mTitlebar = (TitleBar) findViewById(R.id.titlebar);
        this.qrcodeImg = (ImageView) findViewById(R.id.qrcode);
        this.mTvRecord = (TextView) findViewById(R.id.tv_chakanrecord);
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.ui.meal.MealQrCodeActivity$1, reason: invalid class name */
    class AnonymousClass1 extends Listener<GetMealQrcodeBean> {
        AnonymousClass1() {
        }

        @Override // client.android.yixiaotong.controller.core.Listener
        public void onStart(Controller controller) {
            try {
                MealQrCodeActivity.this.mMaterialDialog = new MaterialDialog.Builder(MealQrCodeActivity.this.getActivity()).content("正在处理中,请稍候...").cancelable(false).progress(true, 0).show();
            } catch (Exception unused) {
            }
        }

        @Override // client.android.yixiaotong.controller.core.Listener
        public void onComplete(Controller controller, GetMealQrcodeBean getMealQrcodeBean, Object... objArr) {
            try {
                MealQrCodeActivity.this.mMaterialDialog.dismiss();
            } catch (Exception unused) {
            }
            MealQrCodeActivity.this.mTime = getMealQrcodeBean.time;
            MealQrCodeActivity.this.generate((int) (getMealQrcodeBean.Balance * 100.0f), "00");
        }

        @Override // client.android.yixiaotong.controller.core.Listener
        public void onFail(Controller controller, ClientException clientException) {
            try {
                MealQrCodeActivity.this.mMaterialDialog.dismiss();
            } catch (Exception unused) {
            }
            MealQrCodeActivity mealQrCodeActivity = MealQrCodeActivity.this;
            mealQrCodeActivity.generate((int) mealQrCodeActivity.mWalletModel.getBalance(), "01");
        }
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.ui.meal.MealQrCodeActivity$2, reason: invalid class name */
    class AnonymousClass2 implements View.OnClickListener {
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }

        AnonymousClass2() {
        }
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        BrightnessUtils.stopAutoBrightness(getActivity());
        BrightnessUtils.setBrightness(getActivity(), 1.0f);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        BrightnessUtils.setBrightness(getActivity(), this.mBrightness);
        if (this.isAutoBrightness) {
            BrightnessUtils.startAutoBrightness(getActivity());
        } else {
            BrightnessUtils.stopAutoBrightness(getActivity());
        }
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

    @Override // android.app.Activity
    public void finish() {
        super.finish();
    }

    private void initTitleBar() {
        this.mTitlebar.setTitleView("用餐");
        this.mTitlebar.setLeftViewIsBack();
        this.mTitlebar.setLeftViewOnClickBack(getActivity());
    }

    private void refreshQrcode(final String str) {
        AsyncQueueExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.ui.meal.MealQrCodeActivity.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    final Bitmap bitmapCreateQrcode = QrcodeUtils.createQrcode(str);
                    File file = new File(BaseApplication.app.getImageTmpDir(), "qrcode.jpg");
                    if (file.exists()) {
                        file.delete();
                    }
                    file.createNewFile();
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    bitmapCreateQrcode.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                    IOUtils.closeQuietly((OutputStream) fileOutputStream);
                    MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.ui.meal.MealQrCodeActivity.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MealQrCodeActivity.this.qrcodeImg.setImageBitmap(bitmapCreateQrcode);
                        }
                    });
                } catch (Exception unused) {
                }
            }
        });
    }
}
