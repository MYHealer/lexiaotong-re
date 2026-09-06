package client.android.yixiaotong.exception;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class HttpException extends ClientException {
    public static final int APPUPDATECODE = -53;
    public static final int NETWORK_ERROR = -1000;
    public static final int NETWORK_ERROR404 = 404;
    public static final int NETWORK_ERROR502 = 502;
    public static final int NETWORK_ERROR503 = 503;
    public static final int NETWORK_ERROR504 = 504;
    public static final String NETWORK_MSG = "网络连接超时！";
    public static final int NETWORK_NORMAL = 200;
    public static Map<Integer, HttpException> sMap = new HashMap<Integer, HttpException>() { // from class: client.android.yixiaotong.exception.HttpException.1
        {
            put(1000, new HttpException(1000, "不合法访问"));
            put(1001, new HttpException(1001, "提供参数"));
            put(1002, new HttpException(1002, "参数验证不通过"));
            put(1003, new HttpException(1003, "未知错误"));
            put(1004, new HttpException(1004, "未找到数据或数据不存在"));
            put(1005, new HttpException(1005, "文件大小超过限制"));
            put(1006, new HttpException(1006, "未选择文件"));
            put(1007, new HttpException(1007, "系统限制"));
            put(1008, new HttpException(1008, "系统超出限制"));
            put(2000, new HttpException(2000, "登录失败，用户名或密码错误"));
            put(2001, new HttpException(2001, "旧密码错误"));
            put(4000, new HttpException(4000, "订单创建失败"));
            put(4001, new HttpException(4001, "未找到订单"));
            put(4002, new HttpException(4002, "订单当前状态下不能取消订单"));
            put(4003, new HttpException(4003, "订单当前状态下不能确认收货"));
            put(4004, new HttpException(4004, "支付确认失败"));
            put(4005, new HttpException(4005, "支付密码错误"));
            put(4006, new HttpException(4006, "订单已付款，不能再进行支付"));
            put(4007, new HttpException(4007, "货到付款订单不能在线支付"));
            put(5000, new HttpException(5000, "设备没有初始化"));
            put(5001, new HttpException(5001, "设备已经初始化"));
        }
    };

    public HttpException() {
    }

    public HttpException(int i) {
        super(i);
    }

    public HttpException(Exception exc) {
        super(exc);
    }

    public HttpException(String str) {
        super(str);
    }

    public HttpException(int i, String str) {
        super(i, str);
    }

    public static HttpException filter(int i, String str) {
        return new HttpException(i, str);
    }

    public static HttpException filter(int i, String str, Object obj) {
        HttpException httpException = new HttpException(i, str);
        httpException.setObject(obj);
        return httpException;
    }

    public static HttpException filter(int i, String str, Object obj, String str2) {
        HttpException httpException = new HttpException(i, str);
        httpException.setObject(obj);
        httpException.setSerial(str2);
        return httpException;
    }

    public static HttpException getDefautException() {
        return new HttpException(-1000, NETWORK_MSG);
    }
}
