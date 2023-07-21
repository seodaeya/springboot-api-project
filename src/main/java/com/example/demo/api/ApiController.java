package com.example.demo.api;

import com.example.demo.common.ResponseResult;
import com.example.demo.common.ResponseUtils;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * API 샘플
 */
@Log4j2
@RestController
@RequestMapping("/api")
public class ApiController {

    /**
     * GET 샘플
     */
    @GetMapping("/get")
    public void test(HttpServletResponse response, @RequestParam Map<String, String> params) {
        log.info("/api/get - " + params.toString());
        ResponseUtils.write(response, ResponseResult.success("GET 성공"));
    }

    /**
     * POST 샘플
     */
    @PostMapping("/post")
    public void login(HttpServletResponse response, @RequestBody Map<String, String> map) {
        log.info("/api/post - " + map.toString());
        ResponseUtils.write(response, ResponseResult.success("POST 성공"));
    }
}