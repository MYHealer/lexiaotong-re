package android.client.bluetoothsdk.util;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.provider.Contacts;
import android.provider.Telephony;
import android.text.TextUtils;
import com.byazt.bv.BaseConstants;
import com.byazt.tk.AdBaseConstants;
import com.yfanads.android.libs.net.UrlHttpUtil;
import java.io.File;
import java.net.URL;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class IntentUtils {
    private static boolean isSupportsContactsV2() {
        return true;
    }

    public static Intent openPlayStore(Context context) {
        return openPlayStore(context, true);
    }

    public static Intent openPlayStore(Context context, boolean z) {
        String packageName = context.getPackageName();
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(BaseConstants.MARKET_PREFIX + packageName));
        return (!isIntentAvailable(context, intent) && z) ? openLink("https://play.google.com/store/apps/details?id=" + packageName) : intent;
    }

    public static Intent sendEmail(String str, String str2, String str3) {
        return sendEmail(new String[]{str}, str2, str3);
    }

    public static Intent sendEmail(String[] strArr, String str, String str2) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("message/rfc822");
        intent.putExtra("android.intent.extra.EMAIL", strArr);
        intent.putExtra("android.intent.extra.SUBJECT", str);
        intent.putExtra("android.intent.extra.TEXT", str2);
        return intent;
    }

    public static Intent shareText(String str, String str2) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("android.intent.extra.SUBJECT", str);
        }
        intent.putExtra("android.intent.extra.TEXT", str2);
        intent.setType("text/plain");
        return intent;
    }

    public static Intent sendSms(Context context, String str, String str2) {
        String defaultSmsPackage = Telephony.Sms.getDefaultSmsPackage(context);
        Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + str));
        intent.putExtra("sms_body", str2);
        if (defaultSmsPackage != null) {
            intent.setPackage(defaultSmsPackage);
        }
        return intent;
    }

    public static Intent showStreetView(float f, float f2, Float f3, Integer num, Float f4, Integer num2) {
        StringBuilder sbAppend = new StringBuilder("google.streetview:cbll=").append(f).append(",").append(f2);
        if (f3 != null || num != null || f4 != null) {
            Object[] objArr = new Object[3];
            Object obj = f3;
            if (f3 == null) {
                obj = "";
            }
            objArr[0] = obj;
            Object obj2 = num;
            if (num == null) {
                obj2 = "";
            }
            objArr[1] = obj2;
            Object obj3 = f4;
            if (f4 == null) {
                obj3 = "";
            }
            objArr[2] = obj3;
            sbAppend.append("&cbp=1,").append(String.format("%s,,%s,%s", objArr));
        }
        if (num2 != null) {
            sbAppend.append("&mz=").append(num2);
        }
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse(sbAppend.toString()));
        return intent;
    }

    public static Intent showLocation(float f, float f2, Integer num) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        String str = String.format("geo:%s,%s", Float.valueOf(f), Float.valueOf(f2));
        if (num != null) {
            str = String.format("%s?z=%s", str, num);
        }
        intent.setData(Uri.parse(str));
        return intent;
    }

    public static Intent findLocation(String str) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse(String.format("geo:0,0?q=%s", str)));
        return intent;
    }

    public static Intent showLocationServices() {
        Intent intent = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
        intent.addFlags(1074266112);
        return intent;
    }

    public static Intent openLink(String str) {
        if (!TextUtils.isEmpty(str) && !str.contains("://")) {
            str = "http://" + str;
        }
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        return intent;
    }

    public static Intent openLink(URL url) {
        return openLink(url.toString());
    }

    public static Intent openVideo(File file) {
        return openVideo(Uri.fromFile(file));
    }

    public static Intent openVideo(String str) {
        return openVideo(new File(str));
    }

    public static Intent openVideo(Uri uri) {
        return openMedia(uri, UrlHttpUtil.FILE_TYPE_VIDEO);
    }

    public static Intent openAudio(File file) {
        return openAudio(Uri.fromFile(file));
    }

    public static Intent openAudio(String str) {
        return openAudio(new File(str));
    }

    public static Intent openAudio(Uri uri) {
        return openMedia(uri, UrlHttpUtil.FILE_TYPE_AUDIO);
    }

    public static Intent openImage(String str) {
        return openImage(new File(str));
    }

    public static Intent openImage(File file) {
        return openImage(Uri.fromFile(file));
    }

    public static Intent openImage(Uri uri) {
        return openMedia(uri, UrlHttpUtil.FILE_TYPE_IMAGE);
    }

    public static Intent openText(String str) {
        return openText(new File(str));
    }

    public static Intent openText(File file) {
        return openText(Uri.fromFile(file));
    }

    public static Intent openText(Uri uri) {
        return openMedia(uri, "text/plain");
    }

    public static Intent openApk(String str) {
        return openApk(new File(str));
    }

    public static Intent openApk(File file) {
        return openApk(Uri.fromFile(file));
    }

    public static Intent openApk(Uri uri) {
        return openMedia(uri, AdBaseConstants.MIME_APK);
    }

    public static Intent pickFile() {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType(UrlHttpUtil.FILE_TYPE_FILE);
        return intent;
    }

    public static Intent callPhone(String str) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.CALL");
        intent.setData(Uri.parse("tel:" + str));
        return intent;
    }

    public static Intent pickContact() {
        return pickContact(null);
    }

    public static Intent pickContact(String str) {
        Intent intent;
        if (isSupportsContactsV2()) {
            intent = new Intent("android.intent.action.PICK", Uri.parse("content://com.android.contacts/contacts"));
        } else {
            intent = new Intent("android.intent.action.PICK", Contacts.People.CONTENT_URI);
        }
        if (!TextUtils.isEmpty(str)) {
            intent.setType(str);
        }
        return intent;
    }

    public static Intent pickContactWithPhone() {
        if (isSupportsContactsV2()) {
            return pickContact("vnd.android.cursor.dir/phone_v2");
        }
        return pickContact("vnd.android.cursor.dir/phone");
    }

    public static Intent pickImage() {
        Intent intent = new Intent("android.intent.action.PICK");
        intent.setType(UrlHttpUtil.FILE_TYPE_IMAGE);
        return intent;
    }

    public static Intent dialPhone(String str) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.DIAL");
        intent.setFlags(268435456);
        intent.setData(Uri.parse("tel:" + str));
        return intent;
    }

    public static boolean isCropAvailable(Context context) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setType(UrlHttpUtil.FILE_TYPE_IMAGE);
        return isIntentAvailable(context, intent);
    }

    public static Intent cropImage(Context context, File file, int i, int i2, int i3, int i4, boolean z) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setType(UrlHttpUtil.FILE_TYPE_IMAGE);
        ResolveInfo resolveInfo = context.getPackageManager().queryIntentActivities(intent, 0).get(0);
        intent.putExtra("outputX", i);
        intent.putExtra("outputY", i2);
        intent.putExtra("aspectX", i3);
        intent.putExtra("aspectY", i4);
        intent.putExtra("scale", z);
        intent.putExtra("return-data", true);
        intent.setData(Uri.fromFile(file));
        intent.setComponent(new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name));
        return intent;
    }

    public static Intent photoCapture(String str) {
        Uri uriFromFile = Uri.fromFile(new File(str));
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        intent.putExtra("output", uriFromFile);
        return intent;
    }

    public static boolean isIntentAvailable(Context context, Intent intent) {
        return context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }

    private static Intent openMedia(Uri uri, String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(uri, str);
        return intent;
    }
}
