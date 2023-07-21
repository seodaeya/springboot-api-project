package com.example.demo.common;

import org.springframework.http.HttpStatus;
import org.springframework.util.ObjectUtils;

import java.util.HashMap;

/**
 * Response 결과
 */
public class ResponseResult extends HashMap<String, Object> {

    /** 코드 */
    private static final String CODE_TAG = "code";

    /** 메시지 */
    private static final String MSG_TAG = "msg";

    /** 데이터 */
    private static final String DATA_TAG = "data";

    /**
     * 생성자
     */
    public ResponseResult() {
    }

    /**
     * ResponseResult 초기화
     *
     * @param code http 상태
     * @param msg 메시지
     */
    public ResponseResult(int code, String msg) {
        super.put(CODE_TAG, code);
        super.put(MSG_TAG, msg);
    }

    /**
     * ResponseResult 초기화
     *
     * @param code http 상태
     * @param msg 메시지
     * @param data 데이터
     */
    public ResponseResult(int code, String msg, Object data) {
        super.put(CODE_TAG, code);
        super.put(MSG_TAG, msg);
        if (!ObjectUtils.isEmpty(data)) {
            super.put(DATA_TAG, data);
        }
    }

    /**
     * 성공 메시지 반환
     *
     * @return Response 결과
     */
    public static ResponseResult success() {
        return ResponseResult.success("성공");
    }

    /**
     * 성공 메시지 반환
     *
     * @return Response 결과
     */
    public static ResponseResult success(Object data) {
        return ResponseResult.success("성공", data);
    }

    /**
     * 성공 메시지 반환
     *
     * @param msg 메시지
     * @param data 데이터
     * @return Response 결과
     */
    public static ResponseResult success(String msg, Object data) {
        return new ResponseResult(HttpStatus.OK.value(), msg, data);
    }

    /**
     * 에러 메시지 반환
     *
     * @return
     */
    public static ResponseResult error() {
        return ResponseResult.error("에러");
    }

    /**
     * 에러 메시지 반환
     *
     * @param msg 메시지
     * @return Response 결과
     */
    public static ResponseResult error(String msg) {
        return ResponseResult.error(msg, null);
    }

    /**
     * 에러 메시지 반환
     *
     * @param msg 메시지
     * @param data 데이터
     * @return Response 결과
     */
    public static ResponseResult error(String msg, Object data) {
        return new ResponseResult(HttpStatus.INTERNAL_SERVER_ERROR.value(), msg, data);
    }

    /**
     * 에러 메시지 반환
     *
     * @param code http 상태
     * @param msg 메시지
     * @return Response 결과
     */
    public static ResponseResult error(int code, String msg) {
        return new ResponseResult(code, msg, null);
    }

    /**
     * 값 변경
     *
     * @param key 키
     * @param value 값
     * @return Response 결과
     */
    @Override
    public ResponseResult put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}