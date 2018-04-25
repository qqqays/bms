package com.qays.bms.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Q-ays.
 * whosqays@gmail.com
 * 04-25-2018 10:28
 */

@RestController
@Api(tags = "swagger test")
public class SwaggerTest {

    @ApiOperation(value = "abc")
    @ApiImplicitParam(name = "param", value = "input param", required = true, paramType = "query")
    @GetMapping("/fuck")
    public String fuck(String param) {
        return param;
    }
}
