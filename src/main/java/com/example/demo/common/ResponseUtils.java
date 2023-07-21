package com.example.demo.common;

import com.google.gson.Gson;

import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.util.StringUtils;

import java.io.Writer;

/**
 * Response 유틸
 */
@Log4j2
public class ResponseUtils {

    /**
     * reponse에 string형태로 반환
     *
     * @param response
     * @param str
     * @param contentType
     */
    public static void write(HttpServletResponse response, String str, String contentType) {

        // contentType - default: html
        contentType = StringUtils.hasText(contentType) ? contentType : "html";
        // charset - default: utf-8
        String charset = Constants.UTF8;

        response.setContentType(String.format("text/%s; charset=%s", contentType, charset));
        response.setCharacterEncoding(charset);
        Writer writer = null;

        try {
            writer = response.getWriter();
            writer.write(str);
        } catch (Exception e) {
            log.error(e);
        } finally {
            try {
                writer.close();
            } catch (Exception e) {
                log.error(e);
            }
        }
    }

    /**
     * ResponseResult to json
     *
     * @param response
     * @param responseResult
     */
    public static void write(HttpServletResponse response, ResponseResult responseResult) {
        write(response, new Gson().toJson(responseResult));
    }

    /**
     * contentType: html
     *
     * @param response
     * @param str
     * @throws Exception
     */
    public static void write(HttpServletResponse response, String str) {
        write(response, str, "html");
    }
}