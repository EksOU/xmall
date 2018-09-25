package life.eks.xmall.common.web;

import java.io.Serializable;

/**
 * @author Eks OU
 */
public class Response implements Serializable {
    private static final int SUCCESS_CODE = 200;
    private static final int FLAT_FAIL_CODE = 5001;
    private static final String SUCCESS_MSG = "操作成功";
    private static final String FLAT_FAIL_MSG = "操作失败";

    private int code;
    private String message;
    private Object data;

    public static Response success() {
        return response(SUCCESS_CODE, SUCCESS_MSG, null);
    }

    public static Response success(Object data) {
        return response(SUCCESS_CODE, SUCCESS_MSG, data);
    }

    public static Response fail() {
        return response(FLAT_FAIL_CODE, FLAT_FAIL_MSG, null);
    }

    public static Response fail(Object data) {
        return response(FLAT_FAIL_CODE, FLAT_FAIL_MSG, data);
    }

    public static Response response(int code, String message, Object data) {
        return new Response(code, message, data);
    }

    private Response(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }
}
