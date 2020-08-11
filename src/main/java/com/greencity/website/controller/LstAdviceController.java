package com.greencity.website.controller;

import com.greencity.website.VO.ResultVO;
import com.greencity.website.VO.request.InsertAdviceRequest;
import com.greencity.website.VO.request.PageRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.greencity.website.service.LstAdviceService;

import lombok.extern.log4j.Log4j2;


/**
 * <p>
 * 反馈意见表 前端控制器
 * </p>
 *
 * @author LiuZW
 * @since 2020-05-08
 */
@RestController
@RequestMapping("lstAdvice")
@Slf4j
@Api(tags = "反馈信息API")
public class LstAdviceController {


	@Autowired
    private LstAdviceService lstAdviceService;

    /**
     * @MethodName: getAdviceList
     * @Description: 查询反馈列表
     * @Param: [request]
     * @Return: com.greencity.website.VO.ResultVO
     * @Author: LiuZW
     * @Date: 2020/5/8 14:18
     **/
    @PostMapping("/list")
    @ApiOperation(value = "查询反馈列表", notes = "查询反馈列表")
    public ResultVO getAdviceList(PageRequest request) {

        return lstAdviceService.getAdviceList(request);
    }

    /**
     * @MethodName: saveAdvice
     * @Description: 新增反馈信息
     * @Param: [request]
     * @Return: com.greencity.website.VO.ResultVO
     * @Author: LiuZW
     * @Date: 2020/5/8 14:37
     **/
    @PostMapping("/save")
    @ApiOperation(value = "新增反馈信息", notes = "新增反馈信息")
    public ResultVO saveAdvice(InsertAdviceRequest request)  {

        return lstAdviceService.saveAdvice(request);
    }



}
