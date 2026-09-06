package client.android.yixiaotong.ui;

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
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.content.FileProvider;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.BaseApplication;
import client.android.yixiaotong.R;
import client.android.yixiaotong.account.AccountManager;
import client.android.yixiaotong.baseutil.ActivitiesHelper;
import client.android.yixiaotong.baseutil.KeyBoardUtils;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.bean.AreasBean;
import client.android.yixiaotong.controller.bean.NullBean;
import client.android.yixiaotong.controller.bean.UserInfoBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.error.ErrorUtil;
import client.android.yixiaotong.controller.store.FileUploadBean;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.login.FindPasswordOneActivity;
import client.android.yixiaotong.ui.login.FindPasswordTwoActivity;
import client.android.yixiaotong.ui.login.LoginActivity;
import client.android.yixiaotong.ui.login.XiugaiAuthorizedPasswordActivity;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.Base64;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.android.DialogUtils;
import client.android.yixiaotong.util.permission.PermissionUtil;
import com.afollestad.materialdialogs.MaterialDialog;
import com.facebook.common.util.UriUtil;
import com.facebook.drawee.view.SimpleDraweeView;
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

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class UserInfoActivity extends BaseActivity {
    private static final String EXTRA_IFNO = "user_info";
    public static final int PHOTO_CROP_RESULT = 203;
    private static final int REQUEST_CODE_CAMERA = 101;
    private static final int REQUEST_CODE_GALLERY = 100;
    private static final int REQUEST_PERMISSION = 102;
    private String Identification;
    private long areaId;
    private Uri cameraImageUri;
    private MaterialDialog mMaterialDialog;
    RadioButton mSexBoyButton;
    RadioButton mSexGirlButton;
    TitleBar mTitleBar;
    TextView mTvPhone;
    TextView mTvSchBinding;
    private UserInfoBean mUserInfoBean;
    private String schoolName;
    ScrollView scrollview;
    EditText vEtAddress;
    EditText vEtIdentification;
    EditText vEtName;
    EditText vEtNum;
    SimpleDraweeView vIvMeIcon;
    Uri imageUri = null;
    private boolean mIsEnable = true;
    private boolean mIsEditing = false;
    private PermissionUtil.PermissionGrant permissionGrant = new PermissionUtil.PermissionGrant() { // from class: client.android.yixiaotong.ui.UserInfoActivity.14
        @Override // client.android.yixiaotong.util.permission.PermissionUtil.PermissionGrant
        public void onPermissionGranted(int i) {
            if (i == 0) {
                PermissionUtil.requestPerssion(UserInfoActivity.this.getActivity(), 2, UserInfoActivity.this.permissionGrant);
            } else if (i == 2) {
                PermissionUtil.requestPerssion(UserInfoActivity.this.getActivity(), 3, UserInfoActivity.this.permissionGrant);
            } else {
                if (i != 3) {
                    return;
                }
                DialogUtils.showList(UserInfoActivity.this, "添加图片", R.array.sign, new MaterialDialog.ListCallback() { // from class: client.android.yixiaotong.ui.UserInfoActivity.14.1
                    @Override // com.afollestad.materialdialogs.MaterialDialog.ListCallback
                    public void onSelection(MaterialDialog materialDialog, View view, int i2, CharSequence charSequence) {
                        if (i2 == 0) {
                            UserInfoActivity.this.openCamera();
                        } else if (i2 == 1) {
                            UserInfoActivity.this.openGallery();
                        }
                    }
                });
            }
        }
    };
    private ArrayList<Uri> imageUris = new ArrayList<>();

    static {
        StubApp.interface11(6084);
    }

    private boolean checkPermission() {
        return true;
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public native void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.vIvMeIcon = (SimpleDraweeView) findViewById(R.id.v_iv_me_icon);
        this.vEtName = (EditText) findViewById(R.id.v_et_name);
        this.vEtNum = (EditText) findViewById(R.id.v_et_num);
        this.mSexBoyButton = (RadioButton) findViewById(R.id.sex_boy);
        this.mSexGirlButton = (RadioButton) findViewById(R.id.sex_girl);
        this.vEtIdentification = (EditText) findViewById(R.id.v_et_identification_id);
        this.vEtAddress = (EditText) findViewById(R.id.v_et_address);
        this.mTvSchBinding = (TextView) findViewById(R.id.tv_binding_sch);
        this.mTvPhone = (TextView) findViewById(R.id.v_et_photo_id);
        this.scrollview = (ScrollView) findViewById(R.id.scrollview);
    }

    private void initClickListeners() {
        findViewById(R.id.v_ll_icon).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.UserInfoActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PermissionUtil.requestPerssion(UserInfoActivity.this.getActivity(), 0, UserInfoActivity.this.permissionGrant);
            }
        });
        findViewById(R.id.v_tv_edit_pay_password).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.UserInfoActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FindPasswordOneActivity.launch(UserInfoActivity.this.getActivity(), 2);
            }
        });
        findViewById(R.id.v_tv_edit_password).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.UserInfoActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FindPasswordTwoActivity.launch(UserInfoActivity.this.getActivity(), UserInfoActivity.this.getLoginAccount().getUserName(), "", 1);
            }
        });
        findViewById(R.id.tv_binding_sch).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.UserInfoActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SchoolCodeActivity.launch(UserInfoActivity.this.getActivity(), UserInfoActivity.this.areaId, UserInfoActivity.this.schoolName);
            }
        });
        findViewById(R.id.v_tv_edit_xiushouquanpassword).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.UserInfoActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                XiugaiAuthorizedPasswordActivity.launch(UserInfoActivity.this.getActivity(), "", "", 3);
            }
        });
        findViewById(R.id.v_tv_edit_shouquanpassword).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.UserInfoActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FindPasswordOneActivity.launch(UserInfoActivity.this.getActivity(), 3);
            }
        });
        findViewById(R.id.btn_exit_app).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.UserInfoActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AccountManager.getInstance().clearLoginAccount();
                LoginActivity.launch(UserInfoActivity.this.getActivity());
                UserInfoActivity.this.closeAllActivity();
            }
        });
    }

    public static void launch(Activity activity, UserInfoBean userInfoBean) {
        Intent intent = new Intent(activity, (Class<?>) UserInfoActivity.class);
        intent.putExtra(EXTRA_IFNO, userInfoBean);
        activity.startActivity(intent);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView("个人信息");
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setRightView("编辑");
        this.mTitleBar.setRightViewTextColor(-14385452);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
        this.mTitleBar.setRightViewOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.UserInfoActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserInfoActivity.this.mIsEditing) {
                    KeyBoardUtils.hideSoftInput(UserInfoActivity.this.getActivity());
                    UserInfoActivity.this.modifyData();
                    UserInfoActivity.this.mTitleBar.setRightView("编辑");
                    UserInfoActivity.this.setEditStatus(false);
                    return;
                }
                UserInfoActivity.this.mTitleBar.setRightView("保存");
                UserInfoActivity.this.setEditStatus(true);
                KeyBoardUtils.hideSoftInput(UserInfoActivity.this.getActivity());
            }
        });
    }

    private void setScroll() {
        final int[] iArr = {0};
        this.scrollview.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: client.android.yixiaotong.ui.UserInfoActivity.9
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                UserInfoActivity userInfoActivity = UserInfoActivity.this;
                userInfoActivity.doScrollEvent(userInfoActivity.scrollview, iArr, UserInfoActivity.this.vEtNum, UserInfoActivity.this.vEtIdentification);
            }
        });
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
        MaterialDialog materialDialog = this.mMaterialDialog;
        if (materialDialog != null) {
            materialDialog.dismiss();
        }
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
                    if (iArr2[1] + height2 > rect.bottom) {
                        scrollView.scrollBy(0, (iArr2[1] + height2) - rect.bottom);
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
    public void initSchollSpinner() {
        BusinessControllers.getInstance().getSchoolList(getLoginAccount(), new Listener<List<AreasBean>>() { // from class: client.android.yixiaotong.ui.UserInfoActivity.10
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, List<AreasBean> list, Object... objArr) {
                if (UserInfoActivity.this.mIsEnable) {
                    UserInfoActivity.this.mMaterialDialog.dismiss();
                    if (list != null) {
                        for (int i = 0; i < list.size(); i++) {
                            AreasBean areasBean = list.get(i);
                            if (areasBean.ID == UserInfoActivity.this.mUserInfoBean.AreaId) {
                                UserInfoActivity.this.schoolName = areasBean.Name;
                                UserInfoActivity.this.mTvSchBinding.setText(areasBean.Name + "\n(生成绑定二维码)");
                                break;
                            }
                        }
                    }
                    UserInfoActivity.this.setEditStatus(false);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (UserInfoActivity.this.mIsEnable) {
                    UserInfoActivity.this.mMaterialDialog.dismiss();
                    SystemErrorTip.getInstance().showTipDialog(UserInfoActivity.this.getActivity(), new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.ui.UserInfoActivity.10.1
                        @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                        public void onConfirm() {
                            UserInfoActivity.this.finish();
                        }
                    }, clientException.getDetail());
                }
            }
        });
    }

    private void initData() {
        BusinessControllers.getInstance().getStudentInfo(getLoginAccount(), new Listener<UserInfoBean>() { // from class: client.android.yixiaotong.ui.UserInfoActivity.11
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                UserInfoActivity.this.mMaterialDialog = new MaterialDialog.Builder(UserInfoActivity.this.getActivity()).content("请稍候...").progress(true, 0).cancelable(false).show();
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, UserInfoBean userInfoBean, Object... objArr) {
                if (UserInfoActivity.this.mIsEnable) {
                    if (userInfoBean != null) {
                        UserInfoActivity.this.mUserInfoBean = userInfoBean;
                        UserInfoActivity userInfoActivity = UserInfoActivity.this;
                        userInfoActivity.areaId = userInfoActivity.mUserInfoBean.AreaId;
                        UserInfoActivity.this.setDataToView();
                        UserInfoActivity.this.initSchollSpinner();
                        return;
                    }
                    ToastUtils.show(UserInfoActivity.this.getContext(), "获取学生信息异常，请重新登录");
                    AccountManager.getInstance().clearLoginAccount();
                    LoginActivity.launch(BaseApplication.app);
                    ActivitiesHelper.getInstance().closeExcept(LoginActivity.class);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (UserInfoActivity.this.mIsEnable) {
                    UserInfoActivity.this.mMaterialDialog.dismiss();
                    ErrorUtil.onFailResult(UserInfoActivity.this.getActivity(), UserInfoActivity.this.mTitleBar.getTitleViewContent(), clientException, true);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEditStatus(boolean z) {
        if (z) {
            new MaterialDialog.Builder(getActivity()).title("提示").content("修改校区将会导致您的钱包中的余额被清零,您可以先在钱包详情中申请退款,退款成功后再更换校区").positiveText("知道了").show();
        }
        this.mIsEditing = z;
        this.vEtName.setEnabled(z);
        this.vEtNum.setEnabled(z);
        this.vEtIdentification.setEnabled(z);
        this.vEtAddress.setEnabled(z);
        this.mSexBoyButton.setEnabled(z);
        this.mSexGirlButton.setEnabled(z);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.mIsEditing) {
            KeyBoardUtils.hideSoftInput(getActivity());
        } else {
            super.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDataToView() {
        this.vEtName.setText(this.mUserInfoBean.StudentName);
        this.vEtNum.setText(this.mUserInfoBean.StudentNo);
        this.vIvMeIcon.setImageURI(UriUtil.parseUriOrNull(this.mUserInfoBean.Icon));
        if (StringUtils.isNotEmpty(this.mUserInfoBean.IdentityId) && this.mUserInfoBean.IdentityId.length() > 2) {
            this.vEtIdentification.setText(this.mUserInfoBean.IdentityId.substring(0, 1) + "**************" + this.mUserInfoBean.IdentityId.substring(this.mUserInfoBean.IdentityId.length() - 1));
        } else {
            this.vEtIdentification.setText(this.mUserInfoBean.IdentityId);
        }
        this.Identification = this.mUserInfoBean.IdentityId;
        this.vEtAddress.setText(this.mUserInfoBean.Address);
        this.mTvPhone.setText(this.mUserInfoBean.Mobile);
        if (this.mUserInfoBean.GenderId == 1) {
            this.mSexBoyButton.setChecked(true);
        } else {
            this.mSexGirlButton.setChecked(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void modifyData() {
        BusinessControllers.getInstance().updateStudentInfo(getLoginAccount(), this.vEtName.getText().toString(), this.vEtNum.getText().toString(), this.mSexBoyButton.isChecked() ? 1 : 2, null, this.mUserInfoBean.AreaId, this.mUserInfoBean.Mobile, this.vEtIdentification.getText().toString(), this.vEtAddress.getText().toString(), new Listener<NullBean>() { // from class: client.android.yixiaotong.ui.UserInfoActivity.12
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                UserInfoActivity.this.mMaterialDialog = new MaterialDialog.Builder(UserInfoActivity.this.getActivity()).content("请稍候...").progress(true, 0).cancelable(false).show();
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, NullBean nullBean, Object... objArr) {
                if (UserInfoActivity.this.mIsEnable) {
                    UserInfoActivity.this.mMaterialDialog.dismiss();
                    UserInfoActivity.this.toast("修改资料成功");
                    UserInfoActivity.this.mTitleBar.setRightView("编辑");
                    UserInfoActivity.this.setEditStatus(false);
                    if (UserInfoActivity.this.areaId == UserInfoActivity.this.mUserInfoBean.AreaId) {
                        if (UserInfoActivity.this.Identification.equals(UserInfoActivity.this.vEtIdentification.getText().toString())) {
                            return;
                        }
                        UserInfoActivity.this.getLoginAccount().setIdentityId(UserInfoActivity.this.vEtIdentification.getText().toString());
                    } else {
                        AccountManager.getInstance().clearLoginAccount();
                        LoginActivity.launch(UserInfoActivity.this.getActivity());
                        ActivitiesHelper.getInstance().closeExcept(LoginActivity.class);
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (UserInfoActivity.this.mIsEnable) {
                    UserInfoActivity.this.mMaterialDialog.dismiss();
                    SystemErrorTip.getInstance().showTipDialog(UserInfoActivity.this.getActivity(), clientException.getDetail());
                }
            }
        });
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        Uri uri;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i != 100 || intent == null) {
                if (i != 101 || (uri = this.cameraImageUri) == null) {
                    return;
                }
                this.imageUri = uri;
                uploadImage(uri);
                return;
            }
            if (intent.getClipData() != null) {
                intent.getClipData().getItemCount();
                Uri uri2 = intent.getClipData().getItemAt(0).getUri();
                this.imageUri = uri2;
                uploadImage(uri2);
                return;
            }
            if (intent.getData() != null) {
                Uri data = intent.getData();
                this.imageUri = data;
                uploadImage(data);
            }
        }
    }

    private void uploadImage(Uri uri) {
        this.imageUri.getPath();
        String strCompressImageToBase64 = compressImageToBase64(getActivity(), uri);
        String fileNameFromUri = getFileNameFromUri(uri);
        if (StringUtils.isEmpty(strCompressImageToBase64)) {
            return;
        }
        BusinessControllers.getInstance().uploadImage(getLoginAccount(), fileNameFromUri, 1, strCompressImageToBase64, new Listener<FileUploadBean>() { // from class: client.android.yixiaotong.ui.UserInfoActivity.13
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, FileUploadBean fileUploadBean, Object... objArr) {
                if (UserInfoActivity.this.mIsEnable) {
                    UserInfoActivity.this.toast("上传头像成功");
                    UserInfoActivity.this.vIvMeIcon.setImageURI(UriUtil.parseUriOrNull(fileUploadBean.url));
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (UserInfoActivity.this.mIsEnable) {
                    SystemErrorTip.getInstance().showTipDialog(UserInfoActivity.this.getActivity(), clientException.getDetail());
                }
            }
        });
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openGallery() {
        if (checkPermission()) {
            Intent intent = new Intent("android.intent.action.PICK");
            intent.setType(UrlHttpUtil.FILE_TYPE_IMAGE);
            intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
            startActivityForResult(intent, 100);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openCamera() {
        File fileCreateImageFile;
        if (checkPermission()) {
            File file = new File("/storage/emulated/0/Android/data/client.android.yixiaotong/files/Pictures/JPEG_20250724_105548_8645585308726751615.jpg");
            Log.e("FileProvider", "文件绝对路径: " + file.getAbsolutePath());
            Log.e("FileProvider", "包名: " + StubApp.getOrigApplicationContext(getApplicationContext()).getPackageName());
            Log.e("FileProvider", "文件是否存在: " + file.exists());
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

    private File createImageFile(String str) throws IOException {
        String str2 = str + new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date()) + "_";
        File externalFilesDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        if (!externalFilesDir.exists()) {
            externalFilesDir.mkdirs();
        }
        return File.createTempFile(str2, ".jpg", externalFilesDir);
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
