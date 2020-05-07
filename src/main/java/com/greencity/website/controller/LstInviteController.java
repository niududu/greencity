package com.greencity.website.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.greencity.website.VO.ResultVO;
import com.greencity.website.VO.request.InsertInviteRequest;
import com.greencity.website.VO.request.InsertInviteRequest;
import com.greencity.website.VO.request.PageRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.greencity.website.service.LstInviteService;
import com.greencity.website.entity.LstInvite;

import lombok.extern.log4j.Log4j2;

import java.util.List;


/**
 * <p>
 * 招聘信息表 前端控制器
 * </p>
 *
 * @author LiuZW
 * @since 2020-04-25
 */
@Api(tags = "招聘信息API")
@RestController
@RequestMapping("invite")
@Log4j2
public class LstInviteController {


	@Autowired
    private LstInviteService lstInviteService;


    @PostMapping("/list")
    @ApiOperation(value = "查询招聘信息列表", notes = "查询招聘信息列表")
    public ResultVO getInviteList(PageRequest request) {

        return lstInviteService.getInviteList(request);
    }


    //@PostMapping("/detail")
    @ApiOperation(value = "获取招聘详情信息", notes = "获取招聘详情信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "inviteId", value = "招聘ID", required = true, paramType = "query", dataType = "int"),
    })
    public ResultVO getInviteDetail(int inviteId) {

        return lstInviteService.getInviteDetail(inviteId);
    }

    /**
     * @MethodName: saveInvite
     * @Description: 新增招聘信息
     * @Param: [request]
     * @Return: com.greencity.website.VO.ResultVO
     * @Author: LiuZW
     * @Date: 2020/4/25 21:38
     **/
    @PostMapping("/save")
    @ApiOperation(value = "新增招聘信息", notes = "新增招聘信息")
    public ResultVO saveInvite(InsertInviteRequest request)  {

        return lstInviteService.saveInvite(request);
    }

    /**
     * @MethodName: updateInvite
     * @Description: 更新招聘信息
     * @Param: [inviteId]
     * @Return: com.greencity.website.VO.ResultVO
     * @Author: LiuZW
     * @Date: 2020/4/25 21:47
     **/
    @PostMapping("/update")
    @ApiOperation(value = "更新招聘信息", notes = "更新招聘信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "招聘ID", required = true, paramType = "query", dataType = "int"),
    })
    public ResultVO updateInvite(Integer id,InsertInviteRequest request){

        return lstInviteService.updateInvite(id,request);
    }

    /**
     * @MethodName: deleteInvite
     * @Description: 删除招聘信息
     * @Param: [inviteId]
     * @Return: com.greencity.website.VO.ResultVO
     * @Author: LiuZW
     * @Date: 2020/4/25 21:47
     **/
    @PostMapping("/delete")
    @ApiOperation(value = "删除招聘信息", notes = "删除招聘信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "招聘ID", required = true, paramType = "query", dataType = "int"),
    })
    public ResultVO deleteInvite(Integer id){

        return lstInviteService.deleteInvite(id);
    }

    /**
     * @MethodName: deleteBatchInvite
     * @Description: 批量删除招聘信息
     * @Param: [ids]
     * @Return: com.greencity.website.VO.ResultVO
     * @Author: LiuZW
     * @Date: 2020/4/29 23:55
     **/
    @PostMapping("/deleteBatch")
    @ApiOperation(value = "批量删除招聘信息", notes = "批量删除招聘信息")
    public ResultVO deleteBatchInvite(@RequestBody List<Integer> ids){

        return lstInviteService.deleteBatchInvite(ids);
    }
}
