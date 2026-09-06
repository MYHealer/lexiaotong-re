package client.android.yixiaotong.util.imgutil;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import client.android.yixiaotong.BaseApplication;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.util.AppUtils;
import client.android.yixiaotong.util.GsonUtils;
import client.android.yixiaotong.util.http.bean.BaseBean;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import com.facebook.common.util.UriUtil;
import com.google.gson.reflect.TypeToken;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.kuaishou.weapon.p0.t;
import com.yfanads.android.libs.net.UrlHttpUtil;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class UploadImgUtil {
    public static final String TAG = "UploadImgUtil";

    public interface Listener {
        void onFailure(String str);

        void onResponse(BaseBean baseBean);
    }

    public static void UpLoadImage(Activity activity, Uri uri, final Listener listener) {
        RequestBody requestBodyBitmapToResquestBoby;
        try {
            requestBodyBitmapToResquestBoby = bitmapToResquestBoby(getBitmapFromUri(activity, uri));
        } catch (IOException e) {
            e.printStackTrace();
            requestBodyBitmapToResquestBoby = null;
        }
        Log.e(TAG, "UpLoadImage:" + uri.getPath());
        MultipartBody multipartBodyBuild = new MultipartBody.Builder().setType(MultipartBody.FORM).addFormDataPart(UriUtil.LOCAL_FILE_SCHEME, System.currentTimeMillis() + "_filename.jpg", requestBodyBitmapToResquestBoby).build();
        Request requestBuild = new Request.Builder().url("https://web-xhf.lxt6.cn:8089/api/oss/ali/upload").addHeader("Cookie", LocalDataUtil.getLastTokenInfo(BaseApplication.app)).addHeader("X-Sid", "2021011300001").addHeader("X-Product-Ver", AppUtils.getVersion(BaseApplication.app)).addHeader("X-Mobile-Info", "Android#?" + AppUtils.getSystemModel() + "#?" + AppUtils.getSystemVersion()).addHeader("X-clientType", LocalDataUtil.getClientTypeInfo(BaseApplication.app)).addHeader("X-B3-TraceId", AppUtils.getTraceId()).addHeader("X-B3-SpanId", AppUtils.getSpanId()).addHeader("X-Ghost", AppUtils.getGhost()).addHeader("X-route", LocalDataUtil.getRoute(BaseApplication.app)).addHeader("X-Sign", "").post(multipartBodyBuild).build();
        LogUtil.e(TAG, requestBuild.toString() + PPSLabelView.Code + multipartBodyBuild.boundary() + PPSLabelView.Code + multipartBodyBuild.size() + PPSLabelView.Code + multipartBodyBuild.type() + PPSLabelView.Code + multipartBodyBuild.getContentType());
        new OkHttpClient.Builder().connectTimeout(30000L, TimeUnit.MILLISECONDS).readTimeout(30000L, TimeUnit.MILLISECONDS).proxy(Proxy.NO_PROXY).build().newCall(requestBuild).enqueue(new Callback() { // from class: client.android.yixiaotong.util.imgutil.UploadImgUtil.1
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                LogUtil.e(UploadImgUtil.TAG, "onFailure，图片上传失败：" + iOException.getMessage());
                Listener listener2 = listener;
                if (listener2 != null) {
                    listener2.onFailure(iOException.getMessage());
                }
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                if (listener != null) {
                    String strString = response.body().string();
                    LogUtil.e(UploadImgUtil.TAG, "onResponse，图片上传成功：" + strString);
                    try {
                        listener.onResponse((BaseBean) GsonUtils.getInstance().parse(new TypeToken<BaseBean>() { // from class: client.android.yixiaotong.util.imgutil.UploadImgUtil.1.1
                        }.getType(), strString));
                    } catch (ClientException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        });
    }

    private static RequestBody bitmapToResquestBoby(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 60, byteArrayOutputStream);
        return RequestBody.create(MediaType.parse(UrlHttpUtil.FILE_TYPE_IMAGE), byteArrayOutputStream.toByteArray());
    }

    private static Bitmap getBitmapFromUri(Activity activity, Uri uri) throws IOException {
        ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = activity.getContentResolver().openFileDescriptor(uri, t.k);
        if (parcelFileDescriptorOpenFileDescriptor != null) {
            return BitmapFactory.decodeFileDescriptor(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor());
        }
        return null;
    }
}
