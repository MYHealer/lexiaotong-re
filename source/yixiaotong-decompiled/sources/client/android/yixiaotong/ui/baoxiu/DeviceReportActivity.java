package client.android.yixiaotong.ui.baoxiu;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.BaseApplication;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.bean.SuccessBean;
import client.android.yixiaotong.controller.bean.report.RepairUploadReportPicsBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.controller.store.LocalBusinessStore;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.widget.PickerView;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.Base64;
import client.android.yixiaotong.util.EventBusUtil;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.android.DialogUtils;
import com.afollestad.materialdialogs.MaterialDialog;
import com.bumptech.glide.Glide;
import com.facebook.common.util.UriUtil;
import com.stub.StubApp;
import com.yfanads.android.libs.net.UrlHttpUtil;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class DeviceReportActivity extends BaseActivity {
    public static final String EXTRA_TYPEID = "extra_typeid";
    private static final int MAX_IMAGES = 3;
    private static final int REQUEST_CODE_CAMERA = 101;
    private static final int REQUEST_CODE_GALLERY = 100;
    private static final int REQUEST_PERMISSION = 102;
    private Uri cameraImageUri;
    private PickerView lv_list;
    private EditText mAddressEt;
    private TextView mBtnClearImg;
    private EditText mEtDeviceNo;
    private GridAdater mGridAdater;
    private GridView mGridImg;
    private int mHeight;
    private MaterialDialog mMaterialDialog;
    private EditText mMobileEt;
    private PopupWindow mPopWindow;
    private ImageView mRelAddImg;
    private RelativeLayout mRelSelectType;
    private EditText mReportEt;
    private TitleBar mTitleBar;
    private TextView mTvAppName;
    private int mWidth;
    private ScrollView scrollView;
    private View view;
    private int mTypeId = 0;
    private String mUploadPic = "";
    private int mUploadIndex = 0;
    private boolean mIsEnable = true;
    private List<WalletModel> mWalletModels = new ArrayList();
    private List<String> mData = new ArrayList();
    private List<String> uploadimgs = new ArrayList();
    private int mSelectIndex = -1;
    private int mSelectTypeid = 0;
    private ArrayList<Uri> imageUris = new ArrayList<>();

    static {
        StubApp.interface11(6364);
    }

    private boolean checkPermission() {
        return true;
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    static /* synthetic */ int access$2208(DeviceReportActivity deviceReportActivity) {
        int i = deviceReportActivity.mUploadIndex;
        deviceReportActivity.mUploadIndex = i + 1;
        return i;
    }

    public static void launch(Activity activity, int i) {
        if (activity != null) {
            Intent intent = new Intent(activity, (Class<?>) DeviceReportActivity.class);
            intent.putExtra("extra_typeid", i);
            activity.startActivity(intent);
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titlebar);
        this.mMobileEt = (EditText) findViewById(R.id.et_mobile);
        this.mAddressEt = (EditText) findViewById(R.id.et_address);
        this.mReportEt = (EditText) findViewById(R.id.et_report);
        this.mRelAddImg = (ImageView) findViewById(R.id.rel_addimg);
        this.mBtnClearImg = (TextView) findViewById(R.id.btn_clearimg);
        this.mGridImg = (GridView) findViewById(R.id.gridimg);
        this.mRelSelectType = (RelativeLayout) findViewById(R.id.rel_selecttype);
        this.mTvAppName = (TextView) findViewById(R.id.tv_appname);
        this.mEtDeviceNo = (EditText) findViewById(R.id.et_deviceno);
        this.scrollView = (ScrollView) findViewById(R.id.scrollview);
    }

    public static void hideKeyboard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
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
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        EventBusUtil.getInstance().getCommonEventBus().unregister(this);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView("故障报修");
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void initClickListeners() {
        findViewById(R.id.btn_complete).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.baoxiu.DeviceReportActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m90xa099c2f7(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-ui-baoxiu-DeviceReportActivity, reason: not valid java name */
    /* synthetic */ void m90xa099c2f7(View view) {
        String string = this.mMobileEt.getText().toString();
        String string2 = this.mAddressEt.getText().toString();
        String string3 = this.mReportEt.getText().toString();
        if (StringUtils.isEmpty(string3.trim())) {
            ToastUtils.show(getContext(), "请填写反馈内容");
            return;
        }
        if (this.mTypeId == 0 && this.mSelectIndex == -1) {
            ToastUtils.show(getContext(), "请选择设备类型");
            return;
        }
        if (StringUtils.isEmpty(string.trim())) {
            ToastUtils.show(getContext(), "请填写联系电话");
            return;
        }
        if (StringUtils.isEmpty(string2.trim())) {
            ToastUtils.show(getContext(), "请填写设备地址");
            return;
        }
        this.mUploadIndex = 0;
        if (this.imageUris.size() > 0) {
            uploadPic(this.imageUris.get(this.mUploadIndex));
        } else {
            submit(string, string2, string3);
        }
    }

    private void initView() {
        GridAdater gridAdater = new GridAdater();
        this.mGridAdater = gridAdater;
        this.mGridImg.setAdapter((ListAdapter) gridAdater);
        int i = this.mTypeId;
        if (i == 0) {
            this.mRelSelectType.setVisibility(0);
        } else {
            this.mSelectTypeid = i;
            this.mRelSelectType.setVisibility(8);
        }
        this.mRelAddImg.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.baoxiu.DeviceReportActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (DeviceReportActivity.this.imageUris.size() < 3) {
                    DialogUtils.showList(DeviceReportActivity.this.getActivity(), "添加图片", R.array.sign, new MaterialDialog.ListCallback() { // from class: client.android.yixiaotong.ui.baoxiu.DeviceReportActivity.1.1
                        @Override // com.afollestad.materialdialogs.MaterialDialog.ListCallback
                        public void onSelection(MaterialDialog materialDialog, View view2, int i2, CharSequence charSequence) {
                            if (i2 == 0) {
                                DeviceReportActivity.this.openCamera();
                            } else if (i2 == 1) {
                                DeviceReportActivity.this.openGallery();
                            }
                        }
                    });
                } else {
                    ToastUtils.show(DeviceReportActivity.this.getContext(), "最多只能选择3张照片");
                }
            }
        });
        this.mBtnClearImg.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.baoxiu.DeviceReportActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (DeviceReportActivity.this.imageUris == null || DeviceReportActivity.this.imageUris.size() <= 0) {
                    return;
                }
                DeviceReportActivity.this.imageUris.clear();
                DeviceReportActivity.this.mGridAdater.notifyDataSetChanged();
                DeviceReportActivity.this.mGridImg.setVisibility(8);
            }
        });
        this.mRelSelectType.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.baoxiu.DeviceReportActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DeviceReportActivity.hideKeyboard(view);
                DeviceReportActivity.this.showPopupWindow();
            }
        });
        this.mReportEt.setOnTouchListener(new View.OnTouchListener() { // from class: client.android.yixiaotong.ui.baoxiu.DeviceReportActivity.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                view.getParent().requestDisallowInterceptTouchEvent(true);
                if ((motionEvent.getAction() & 255) == 1) {
                    view.getParent().requestDisallowInterceptTouchEvent(false);
                }
                return false;
            }
        });
        final int[] iArr = {0};
        this.scrollView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: client.android.yixiaotong.ui.baoxiu.DeviceReportActivity.5
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                DeviceReportActivity deviceReportActivity = DeviceReportActivity.this;
                deviceReportActivity.doScrollEvent(deviceReportActivity.scrollView, iArr, DeviceReportActivity.this.mEtDeviceNo, DeviceReportActivity.this.mMobileEt, DeviceReportActivity.this.mAddressEt);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doScrollEvent(ScrollView scrollView, int[] iArr, EditText... editTextArr) {
        Rect rect = new Rect();
        scrollView.getWindowVisibleDisplayFrame(rect);
        int height = scrollView.getHeight() - rect.bottom;
        int scrollY = scrollView.getScrollY();
        for (EditText editText : editTextArr) {
            if (editText.isFocused()) {
                if (height > 100) {
                    int[] iArr2 = new int[2];
                    iArr[0] = scrollY;
                    editText.getLocationInWindow(iArr2);
                    int height2 = editText.getHeight();
                    if (iArr2[1] + height2 > rect.bottom - (height2 * 6)) {
                        scrollView.scrollBy(0, height - 100);
                        return;
                    }
                    return;
                }
                int i = iArr[0];
                if (i != scrollY) {
                    scrollView.scrollTo(0, i);
                }
                iArr[0] = scrollView.getScrollY();
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submit(String str, String str2, String str3) {
        String string = this.mEtDeviceNo.getText().toString();
        StringBuilder sb = new StringBuilder();
        List<String> list = this.uploadimgs;
        if (list != null && list.size() > 0) {
            for (int i = 0; i < this.uploadimgs.size(); i++) {
                sb.append(this.uploadimgs.get(i));
                if (i != this.uploadimgs.size() - 1) {
                    sb.append(",");
                }
            }
        }
        BusinessControllers.getInstance().newAddReports(getLoginAccount(), getLoginAccount().getAccountManagetStore().getUserInfo().Token, getLoginAccount().getAccountManagetStore().getUserInfo().AreaId + "", getLoginAccount().getUid() + "", string, str, this.mSelectTypeid, str2, sb.toString(), str3, new Listener<SuccessBean>() { // from class: client.android.yixiaotong.ui.baoxiu.DeviceReportActivity.6
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                if (DeviceReportActivity.this.mMaterialDialog == null || !DeviceReportActivity.this.mMaterialDialog.isShowing()) {
                    DeviceReportActivity.this.mMaterialDialog = new MaterialDialog.Builder(DeviceReportActivity.this.getActivity()).content("正在提交报修...").progress(true, 0).show();
                } else {
                    DeviceReportActivity.this.mMaterialDialog.setContent("正在提交报修..");
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SuccessBean successBean, Object... objArr) {
                if (DeviceReportActivity.this.mIsEnable) {
                    if (DeviceReportActivity.this.mMaterialDialog != null) {
                        DeviceReportActivity.this.mMaterialDialog.dismiss();
                        DeviceReportActivity.this.mMaterialDialog = null;
                    }
                    File[] fileArrListFiles = BaseApplication.app.getFaqImageTmpDir().listFiles();
                    if (fileArrListFiles != null && fileArrListFiles.length > 0) {
                        for (int i2 = 0; i2 < fileArrListFiles.length; i2++) {
                            if (fileArrListFiles[i2].isFile()) {
                                new File(fileArrListFiles[i2].getPath()).delete();
                            }
                        }
                    }
                    LocalBusinessStore.saveIsUploadRepair(DeviceReportActivity.this.getContext(), true);
                    ToastUtils.show(DeviceReportActivity.this.getContext(), "报修成功");
                    DeviceReportActivity.this.finish();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (DeviceReportActivity.this.mIsEnable) {
                    if (DeviceReportActivity.this.mMaterialDialog != null) {
                        DeviceReportActivity.this.mMaterialDialog.dismiss();
                        DeviceReportActivity.this.mMaterialDialog = null;
                    }
                    SystemErrorTip.getInstance().showTipDialog(DeviceReportActivity.this.getActivity(), clientException.getDetail());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uploadPic(Uri uri) {
        String strCompressImageToBase64 = compressImageToBase64(getActivity(), uri);
        String fileNameFromUri = getFileNameFromUri(uri);
        if (StringUtils.isEmpty(strCompressImageToBase64)) {
            return;
        }
        BusinessControllers.getInstance().uploadReportPics(getLoginAccount(), fileNameFromUri, strCompressImageToBase64, this.mSelectTypeid, new Listener<RepairUploadReportPicsBean>() { // from class: client.android.yixiaotong.ui.baoxiu.DeviceReportActivity.7
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                if (DeviceReportActivity.this.mMaterialDialog == null || !DeviceReportActivity.this.mMaterialDialog.isShowing()) {
                    DeviceReportActivity.this.mMaterialDialog = new MaterialDialog.Builder(DeviceReportActivity.this.getActivity()).content("正在上传图片...").progress(true, 0).show();
                } else {
                    DeviceReportActivity.this.mMaterialDialog.setContent("正在上传图片...");
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, RepairUploadReportPicsBean repairUploadReportPicsBean, Object... objArr) {
                if (DeviceReportActivity.this.mIsEnable) {
                    if (repairUploadReportPicsBean.success != 1 || !StringUtils.isNotEmpty(repairUploadReportPicsBean.url)) {
                        if (DeviceReportActivity.this.mMaterialDialog != null) {
                            DeviceReportActivity.this.mMaterialDialog.dismiss();
                            DeviceReportActivity.this.mMaterialDialog = null;
                        }
                        DeviceReportActivity.this.mUploadPic = "上传图片失败！";
                        SystemErrorTip.getInstance().showTipDialog(DeviceReportActivity.this.getActivity(), DeviceReportActivity.this.mUploadPic);
                        return;
                    }
                    DeviceReportActivity.this.uploadimgs.add(repairUploadReportPicsBean.url);
                    DeviceReportActivity.access$2208(DeviceReportActivity.this);
                    if (DeviceReportActivity.this.mUploadIndex < DeviceReportActivity.this.imageUris.size()) {
                        DeviceReportActivity deviceReportActivity = DeviceReportActivity.this;
                        deviceReportActivity.uploadPic((Uri) deviceReportActivity.imageUris.get(DeviceReportActivity.this.mUploadIndex));
                    } else {
                        DeviceReportActivity.this.submit(DeviceReportActivity.this.mMobileEt.getText().toString(), DeviceReportActivity.this.mAddressEt.getText().toString(), DeviceReportActivity.this.mReportEt.getText().toString());
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (DeviceReportActivity.this.mIsEnable) {
                    if (DeviceReportActivity.this.mMaterialDialog != null) {
                        DeviceReportActivity.this.mMaterialDialog.dismiss();
                        DeviceReportActivity.this.mMaterialDialog = null;
                    }
                    DeviceReportActivity.this.mUploadPic = clientException.getDetail();
                    SystemErrorTip.getInstance().showTipDialog(DeviceReportActivity.this.getActivity(), DeviceReportActivity.this.mUploadPic);
                }
            }
        });
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (i == 100 && intent != null) {
                if (intent.getClipData() != null) {
                    int itemCount = intent.getClipData().getItemCount();
                    for (int i3 = 0; i3 < itemCount && this.imageUris.size() < 3; i3++) {
                        this.imageUris.add(intent.getClipData().getItemAt(i3).getUri());
                    }
                    this.mGridAdater.notifyDataSetChanged();
                } else if (intent.getData() != null && this.imageUris.size() < 3) {
                    this.imageUris.add(intent.getData());
                }
                this.mGridAdater.notifyDataSetChanged();
                return;
            }
            if (i != 101 || this.cameraImageUri == null || this.imageUris.size() >= 3) {
                return;
            }
            this.imageUris.add(this.cameraImageUri);
            this.mGridAdater.notifyDataSetChanged();
        }
    }

    private void initWalletModel() {
        BusinessControllers.getInstance().getWalletModels(getLoginAccount(), new Listener<List<WalletModel>>() { // from class: client.android.yixiaotong.ui.baoxiu.DeviceReportActivity.8
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, List<WalletModel> list, Object... objArr) {
                DeviceReportActivity.this.setWalletData(list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setWalletData(List<WalletModel> list) {
        if (list == null) {
            return;
        }
        this.mWalletModels.clear();
        for (int i = 0; i < list.size(); i++) {
            this.mWalletModels.add(list.get(i));
            this.mData.add(this.mWalletModels.get(i).name);
        }
        this.mWalletModels.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void backgroudAlpha(float f) {
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = f;
        getWindow().setAttributes(attributes);
    }

    private class GridAdater extends BaseAdapter {
        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        private GridAdater() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return DeviceReportActivity.this.imageUris.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return DeviceReportActivity.this.imageUris.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(final int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(DeviceReportActivity.this.getContext()).inflate(R.layout.grid_item_img, (ViewGroup) null);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            Log.e("test", "img:" + i + "  " + DeviceReportActivity.this.imageUris.get(i) + "  " + DeviceReportActivity.this.imageUris.size());
            Glide.with(DeviceReportActivity.this.getActivity()).load((Uri) DeviceReportActivity.this.imageUris.get(i)).override(80, 80).centerCrop().into(viewHolder.img);
            viewHolder.delect.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.baoxiu.DeviceReportActivity.GridAdater.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    DeviceReportActivity.this.imageUris.remove(i);
                    DeviceReportActivity.this.mGridAdater.notifyDataSetChanged();
                    DeviceReportActivity.this.mRelAddImg.setVisibility(0);
                }
            });
            return view;
        }

        class ViewHolder {
            ImageView delect;
            ImageView img;

            public ViewHolder(View view) {
                this.img = (ImageView) view.findViewById(R.id.img);
                this.delect = (ImageView) view.findViewById(R.id.delect);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showPopupWindow() {
        PopupWindow popupWindow = this.mPopWindow;
        if (popupWindow == null || !popupWindow.isShowing()) {
            this.view = getLayoutInflater().inflate(R.layout.listview_layout, (ViewGroup) null);
            PopupWindow popupWindow2 = new PopupWindow(this.view);
            this.mPopWindow = popupWindow2;
            popupWindow2.setWidth(-1);
            this.mPopWindow.setHeight((this.mHeight * 5) / 12);
            this.mPopWindow.showAtLocation(getActivity().findViewById(R.id.lin), 81, 0, 0);
            backgroudAlpha(0.5f);
            this.lv_list = (PickerView) this.view.findViewById(R.id.list);
            TextView textView = (TextView) this.view.findViewById(R.id.tv_canle);
            TextView textView2 = (TextView) this.view.findViewById(R.id.tv_postive);
            this.lv_list.setData(this.mData);
            textView.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.baoxiu.DeviceReportActivity.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (DeviceReportActivity.this.mPopWindow != null && DeviceReportActivity.this.mPopWindow.isShowing()) {
                        DeviceReportActivity.this.mPopWindow.dismiss();
                    }
                    DeviceReportActivity.this.backgroudAlpha(1.0f);
                }
            });
            textView2.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.baoxiu.DeviceReportActivity.10
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (DeviceReportActivity.this.mPopWindow != null && DeviceReportActivity.this.mPopWindow.isShowing()) {
                        DeviceReportActivity.this.mPopWindow.dismiss();
                    }
                    DeviceReportActivity.this.backgroudAlpha(1.0f);
                    DeviceReportActivity deviceReportActivity = DeviceReportActivity.this;
                    deviceReportActivity.mSelectIndex = deviceReportActivity.lv_list.getPosition();
                    DeviceReportActivity.this.mTvAppName.setText(((WalletModel) DeviceReportActivity.this.mWalletModels.get(DeviceReportActivity.this.mSelectIndex)).name);
                    DeviceReportActivity deviceReportActivity2 = DeviceReportActivity.this;
                    deviceReportActivity2.mSelectTypeid = ((WalletModel) deviceReportActivity2.mWalletModels.get(DeviceReportActivity.this.mSelectIndex)).typeId;
                }
            });
        }
    }

    private void getWeightAndHeight() {
        Window window = getActivity().getWindow();
        Display defaultDisplay = getActivity().getWindowManager().getDefaultDisplay();
        window.getAttributes();
        this.mHeight = (int) (((double) defaultDisplay.getHeight()) * 0.8d);
        this.mWidth = (int) (((double) defaultDisplay.getWidth()) * 0.8d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openGallery() {
        if (this.imageUris.size() >= 3) {
            Toast.makeText(this, "最多只能选择3张图片", 0).show();
        } else if (checkPermission()) {
            Intent intent = new Intent("android.intent.action.PICK");
            intent.setType(UrlHttpUtil.FILE_TYPE_IMAGE);
            intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
            startActivityForResult(intent, 100);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openCamera() {
        File fileCreateImageFile;
        if (this.imageUris.size() >= 3) {
            Toast.makeText(this, "最多只能选择3张图片", 0).show();
            return;
        }
        if (checkPermission()) {
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            if (intent.resolveActivity(getPackageManager()) == null || (fileCreateImageFile = createImageFile()) == null) {
                return;
            }
            Uri uriForFile = FileProvider.getUriForFile(this, getPackageName() + ".fileprovider", fileCreateImageFile);
            this.cameraImageUri = uriForFile;
            intent.putExtra("output", uriForFile);
            startActivityForResult(intent, 101);
        }
    }

    private File createImageFile() {
        try {
            return File.createTempFile("JPEG_" + new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date()) + "_", ".jpg", getExternalFilesDir(Environment.DIRECTORY_PICTURES));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String compressImageToBase64(Context context, Uri uri) {
        try {
            InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
            if (inputStreamOpenInputStream == null) {
                return null;
            }
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(inputStreamOpenInputStream, null, options);
            inputStreamOpenInputStream.close();
            options.inSampleSize = calculateInSampleSize(options, 1024, 1024);
            options.inJustDecodeBounds = false;
            InputStream inputStreamOpenInputStream2 = context.getContentResolver().openInputStream(uri);
            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpenInputStream2, null, options);
            inputStreamOpenInputStream2.close();
            if (bitmapDecodeStream == null) {
                return null;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmapDecodeStream.compress(Bitmap.CompressFormat.JPEG, 70, byteArrayOutputStream);
            return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private int calculateInSampleSize(BitmapFactory.Options options, int i, int i2) {
        int i3 = options.outWidth;
        int i4 = options.outHeight;
        int i5 = 1;
        if (i3 > i || i4 > i2) {
            int i6 = i3 / 2;
            int i7 = i4 / 2;
            while (i6 / i5 >= i && i7 / i5 >= i2) {
                i5 *= 2;
            }
        }
        return i5;
    }

    /* JADX WARN: Code duplicated, block: B:47:0x007f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    private String compressUriToBase64(Uri uri) throws Throwable {
        InputStream inputStreamOpenInputStream;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ZipOutputStream zipOutputStream = new ZipOutputStream(byteArrayOutputStream);
        InputStream inputStream = null;
        strEncodeToString = null;
        String strEncodeToString = null;
        try {
            try {
                inputStreamOpenInputStream = getContentResolver().openInputStream(uri);
                if (inputStreamOpenInputStream == null) {
                    if (inputStreamOpenInputStream != null) {
                        try {
                            inputStreamOpenInputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    zipOutputStream.close();
                    byteArrayOutputStream.close();
                    return null;
                }
                try {
                    try {
                        String fileNameFromUri = getFileNameFromUri(uri);
                        if (fileNameFromUri == null) {
                            fileNameFromUri = UriUtil.LOCAL_FILE_SCHEME;
                        }
                        zipOutputStream.putNextEntry(new ZipEntry(fileNameFromUri));
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int i = inputStreamOpenInputStream.read(bArr);
                            if (i <= 0) {
                                break;
                            }
                            zipOutputStream.write(bArr, 0, i);
                        }
                        zipOutputStream.closeEntry();
                        zipOutputStream.finish();
                        strEncodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
                        if (inputStreamOpenInputStream != null) {
                            inputStreamOpenInputStream.close();
                        }
                        zipOutputStream.close();
                        byteArrayOutputStream.close();
                    } catch (IOException e2) {
                        e = e2;
                        e.printStackTrace();
                        if (inputStreamOpenInputStream != null) {
                            inputStreamOpenInputStream.close();
                        }
                        zipOutputStream.close();
                        byteArrayOutputStream.close();
                    }
                    return strEncodeToString;
                } catch (Throwable th) {
                    th = th;
                    inputStream = inputStreamOpenInputStream;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            throw th;
                        }
                    }
                    zipOutputStream.close();
                    byteArrayOutputStream.close();
                    throw th;
                }
            } catch (IOException e4) {
                e4.printStackTrace();
            }
        } catch (IOException e5) {
            e = e5;
            inputStreamOpenInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            if (inputStream != null) {
                inputStream.close();
            }
            zipOutputStream.close();
            byteArrayOutputStream.close();
            throw th;
        }
    }

    private String getFileNameFromUri(Uri uri) {
        Cursor cursorQuery;
        String scheme = uri.getScheme();
        String string = null;
        if (scheme != null && scheme.equals("content") && (cursorQuery = getContentResolver().query(uri, null, null, null, null)) != null && cursorQuery.moveToFirst()) {
            int columnIndex = cursorQuery.getColumnIndex("_display_name");
            string = columnIndex != -1 ? cursorQuery.getString(columnIndex) : null;
            cursorQuery.close();
        }
        return string == null ? uri.getLastPathSegment() : string;
    }
}
