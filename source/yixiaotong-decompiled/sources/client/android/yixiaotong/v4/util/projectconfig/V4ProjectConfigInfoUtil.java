package client.android.yixiaotong.v4.util.projectconfig;

import android.app.Activity;
import android.content.SharedPreferences;
import client.android.yixiaotong.BaseApplication;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.v3.bean.login.UseSoftwareProductBean;
import client.android.yixiaotong.v3.util.LogUtil;
import client.android.yixiaotong.v4.http.bean.V4PayConfigBean;
import client.android.yixiaotong.v4.http.bean.V4RefundConfigBean;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.huawei.openalliance.ad.constant.x;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4ProjectConfigInfoUtil {
    private static final String TAG = "V4ProjectConfigInfoUtil";

    private static class SingletonHolder {
        public static final V4ProjectConfigInfoUtil INSTANCE = new V4ProjectConfigInfoUtil();

        private SingletonHolder() {
        }
    }

    public static V4ProjectConfigInfoUtil getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private V4ProjectConfigInfoUtil() {
    }

    public V4ProjectInfoBean getProjectInfoV4() {
        try {
            return (V4ProjectInfoBean) getGson().fromJson(BaseApplication.app.getSharedPreferences("ProjectInfoV4", 0).getString("project-data", ""), new TypeToken<V4ProjectInfoBean>() { // from class: client.android.yixiaotong.v4.util.projectconfig.V4ProjectConfigInfoUtil.1
            }.getType());
        } catch (Exception unused) {
            return null;
        }
    }

    public void saveProjectInfoV4(V4ProjectInfoBean v4ProjectInfoBean) {
        if (v4ProjectInfoBean == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = BaseApplication.app.getSharedPreferences("ProjectInfoV4", 0).edit();
        String json = getGson().toJson(v4ProjectInfoBean);
        LogUtil.e(TAG, "saveProjectInfoV4:" + json);
        editorEdit.putString("project-data", json);
        editorEdit.commit();
    }

    public void clearLoginAccount() {
        SharedPreferences.Editor editorEdit = BaseApplication.app.getSharedPreferences("ProjectInfoV4", 0).edit();
        editorEdit.clear();
        editorEdit.commit();
    }

    private Gson getGson() {
        return new GsonBuilder().excludeFieldsWithoutExposeAnnotation().serializeNulls().setPrettyPrinting().create();
    }

    public UseSoftwareProductBean isUseAndroid() {
        V4ProjectInfoBean projectInfoV4 = getProjectInfoV4();
        UseSoftwareProductBean useSoftwareProductBean = new UseSoftwareProductBean();
        useSoftwareProductBean.isUse = false;
        if (projectInfoV4 != null && projectInfoV4.frontTypeToArray != null && projectInfoV4.frontTypeToArray.size() > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("系统安全升级维护中，请使用");
            for (int i = 0; i < projectInfoV4.frontTypeToArray.size(); i++) {
                if (projectInfoV4.frontTypeToArray.get(i).intValue() == 3) {
                    useSoftwareProductBean.isUse = true;
                } else if (projectInfoV4.frontTypeToArray.get(i).intValue() == 4) {
                    sb.append("【乐校通】APP（苹果） 或");
                } else if (projectInfoV4.frontTypeToArray.get(i).intValue() == 2) {
                    sb.append("【乐校通】支付宝小程序 或");
                } else if (projectInfoV4.frontTypeToArray.get(i).intValue() == 1) {
                    sb.append("【乐校通】微信小程序 或");
                } else if (projectInfoV4.frontTypeToArray.get(i).intValue() == 5) {
                    sb.append("【乐校通】APP（鸿蒙） 或");
                }
            }
            if (sb.toString().endsWith("或")) {
                sb.delete(sb.length() - 2, sb.length());
            } else if (sb.toString().endsWith("请使用")) {
                sb.delete(sb.length() - 4, sb.length());
            }
            sb.append("，由此给大家造成的不便，敬请谅解！");
            if (useSoftwareProductBean.isUse) {
                useSoftwareProductBean.msg = null;
            } else {
                useSoftwareProductBean.msg = sb.toString();
            }
        } else {
            useSoftwareProductBean.msg = "系统安全升级维护中，由此给大家造成的不便，敬请谅解！";
        }
        return useSoftwareProductBean;
    }

    public boolean isEnableUse(Activity activity) {
        V4PayConfigBean v4PayConfigBean;
        V4ProjectInfoBean projectInfoV4 = getInstance().getProjectInfoV4();
        if (projectInfoV4 == null || (v4PayConfigBean = projectInfoV4.projectPayConfigDTO) == null || v4PayConfigBean.consumePayBank == null || v4PayConfigBean.consumePayBank.intValue() == 1) {
            return true;
        }
        if (v4PayConfigBean.consumePayBank.intValue() == 2) {
            SystemErrorTip.getInstance().showTipDialog(activity, "不支持使用APP，建议使用乐校通微信小程序");
            return false;
        }
        if (v4PayConfigBean.consumePayBank.intValue() != 3) {
            return true;
        }
        SystemErrorTip.getInstance().showTipDialog(activity, "不支持使用APP，建议使用乐校通支付宝小程序");
        return false;
    }

    public boolean isOpenRefund() {
        V4RefundConfigBean v4RefundConfigBean = getProjectInfoV4().refundConfigObj;
        return (v4RefundConfigBean == null || v4RefundConfigBean.refundApply == null || v4RefundConfigBean.refundApply.intValue() != 1) ? false : true;
    }

    public String checkRefundTimeRange() {
        V4RefundConfigBean v4RefundConfigBean;
        try {
            V4ProjectInfoBean projectInfoV4 = getProjectInfoV4();
            if (projectInfoV4 == null || (v4RefundConfigBean = projectInfoV4.refundConfigObj) == null) {
                return null;
            }
            if (v4RefundConfigBean.refundStartTime == null && v4RefundConfigBean.refundEndTime == null) {
                return null;
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            Date date = simpleDateFormat.parse(simpleDateFormat.format(new Date()));
            if (v4RefundConfigBean.refundStartTime != null && v4RefundConfigBean.refundEndTime == null) {
                Date date2 = simpleDateFormat.parse(v4RefundConfigBean.refundStartTime);
                if (date != null && date2 != null && !date.before(date2)) {
                    return null;
                }
            }
            if (v4RefundConfigBean.refundStartTime == null && v4RefundConfigBean.refundEndTime != null) {
                Date date3 = simpleDateFormat.parse(v4RefundConfigBean.refundEndTime);
                if (date != null && date3 != null && !date.after(date3)) {
                    return null;
                }
            }
            if (v4RefundConfigBean.refundStartTime != null && v4RefundConfigBean.refundEndTime != null) {
                Date date4 = simpleDateFormat.parse(v4RefundConfigBean.refundStartTime);
                Date date5 = simpleDateFormat.parse(v4RefundConfigBean.refundEndTime);
                if (date != null && date4 != null && date5 != null && !date.before(date4) && !date.after(date5)) {
                    return null;
                }
            }
            return "退款时段为：" + (v4RefundConfigBean.refundStartTime != null ? v4RefundConfigBean.refundStartTime : "") + x.A + (v4RefundConfigBean.refundEndTime != null ? v4RefundConfigBean.refundEndTime : "");
        } catch (Exception unused) {
            return null;
        }
    }

    public boolean dormWallet() {
        V4ProjectInfoBean projectInfoV4 = getProjectInfoV4();
        return (projectInfoV4 == null || projectInfoV4.dormWallet == null || projectInfoV4.dormWallet.intValue() != 1) ? false : true;
    }
}
