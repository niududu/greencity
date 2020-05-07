package com.greencity.website.controller;

import com.greencity.website.VO.request.InsertCaseRequest;
import com.greencity.website.VO.request.PageRequest;
import com.greencity.website.VO.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.greencity.website.service.LstCaseService;

import lombok.extern.log4j.Log4j2;

import java.util.List;


/**
 * <p>
 * 项目案例列表 前端控制器
 * </p>
 *
 * @author LiuZW
 * @since 2020-04-25
 */
@Api(tags = "案例API")
@RestController
@RequestMapping("case")
@Log4j2
public class LstCaseController {


	@Autowired
    private LstCaseService lstCaseService;


    /**
     * @MethodName: getCaseList
     * @Description: 查询案例列表
     * @Param: [request]
     * @Return: com.greencity.website.VO.ResultVO
     * @Author: LiuZW
     * @Date: 2020/4/25 21:06
     **/
    @PostMapping("/list")
    @ApiOperation(value = "查询案例列表", notes = "查询案例列表")
    public ResultVO getCaseList(PageRequest request) {

        return lstCaseService.getCaseList(request);
    }


    /**
     * @MethodName: getCaseDetail
     * @Description: 获取案例详情信息
     * @Param: [caseId]
     * @Return: com.greencity.website.VO.ResultVO
     * @Author: LiuZW
     * @Date: 2020/4/25 21:08
     **/
    //@PostMapping("/detail")
    @ApiOperation(value = "获取案例详情信息", notes = "获取案例详情信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "caseId", value = "案例ID", required = true, paramType = "query", dataType = "int"),
    })
    public ResultVO getCaseDetail(int caseId) {

        return lstCaseService.getCaseDetail(caseId);
    }

    /**
     * @MethodName: saveCase
     * @Description: 新增案例信息
     * @Param: [request]
     * @Return: com.greencity.website.VO.ResultVO
     * @Author: LiuZW
     * @Date: 2020/4/25 21:38
     **/
    @PostMapping("/save")
    @ApiOperation(value = "新增案例信息", notes = "新增案例信息")
    public ResultVO saveCase(InsertCaseRequest request)  {

        return lstCaseService.saveCase(request);
    }

    /**
     * @MethodName: updateCase
     * @Description: 更新案例信息
     * @Param: [caseId]
     * @Return: com.greencity.website.VO.ResultVO
     * @Author: LiuZW
     * @Date: 2020/4/25 21:47
     **/
    @PostMapping("/update")
    @ApiOperation(value = "更新案例信息", notes = "更新案例信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "案例ID", required = true, paramType = "query", dataType = "int"),
    })
    public ResultVO updateCase(Integer id,InsertCaseRequest request){

        return lstCaseService.updateCase(id,request);
    }

    /**
     * @MethodName: deleteCase
     * @Description: 删除案例信息
     * @Param: [caseId]
     * @Return: com.greencity.website.VO.ResultVO
     * @Author: LiuZW
     * @Date: 2020/4/25 21:47
     **/
    @PostMapping("/delete")
    @ApiOperation(value = "删除案例信息", notes = "删除案例信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "案例ID", required = true, paramType = "query", dataType = "int"),
    })
    public ResultVO deleteCase(Integer id){

        return lstCaseService.deleteCase(id);
    }

    /**
     * @MethodName: deleteBatchCase
     * @Description: 批量删除案例信息
     * @Param: [ids]
     * @Return: com.greencity.website.VO.ResultVO
     * @Author: LiuZW
     * @Date: 2020/4/29 23:55
     **/
    @PostMapping("/deleteBatch")
    @ApiOperation(value = "批量删除案例信息", notes = "批量删除案例信息")
    public ResultVO deleteBatchCase(@RequestBody List<Integer> ids){

        return lstCaseService.deleteBatchCase(ids);
    }

}
