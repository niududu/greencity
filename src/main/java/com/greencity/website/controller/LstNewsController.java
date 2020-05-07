package com.greencity.website.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.greencity.website.VO.ResultVO;
import com.greencity.website.VO.request.InsertCaseRequest;
import com.greencity.website.VO.request.InsertNewsRequest;
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
import com.greencity.website.service.LstNewsService;
import com.greencity.website.entity.LstNews;

import lombok.extern.log4j.Log4j2;

import java.util.List;


/**
 * <p>
 * 新闻列表 前端控制器
 * </p>
 *
 * @author LiuZW
 * @since 2020-04-25
 */
@Api(tags = "新闻信息API")
@RestController
@RequestMapping("lstNews")
@Log4j2
public class LstNewsController {


	@Autowired
    private LstNewsService lstNewsService;

    /**
     * @MethodName: getNewsList
     * @Description: 查询新闻列表
     * @Param: [request]
     * @Return: com.greencity.website.VO.ResultVO
     * @Author: LiuZW
     * @Date: 2020/4/25 23:38
     **/
    @PostMapping("/list")
    @ApiOperation(value = "查询新闻列表", notes = "查询新闻列表")
    public ResultVO getNewsList(PageRequest request) {
        
        return lstNewsService.getNewsList(request);
    }


    /**
     * @MethodName: getCaseDetail
     * @Description: 获取新闻详情信息
     * @Param: [caseId]
     * @Return: com.greencity.website.VO.ResultVO
     * @Author: LiuZW
     * @Date: 2020/4/25 21:08
     **/
    //@PostMapping("/detail")
    @ApiOperation(value = "获取新闻详情信息", notes = "获取新闻详情信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "新闻ID", required = true, paramType = "query", dataType = "int"),
    })
    public ResultVO getNewsDetail(int id) {

        return null;
    }

    /**
     * @MethodName: saveNews
     * @Description: 新增新闻信息
     * @Param: [request]
     * @Return: com.greencity.website.VO.ResultVO
     * @Author: LiuZW
     * @Date: 2020/4/25 23:39
     **/
    @PostMapping("/save")
    @ApiOperation(value = "新增新闻信息", notes = "新增新闻信息")
    public ResultVO saveNews(InsertNewsRequest request)  {

        return lstNewsService.saveNews(request);
    }

    /**
     * @MethodName: updateNews
     * @Description: 更新新闻信息
     * @Param: [id, request]
     * @Return: com.greencity.website.VO.ResultVO
     * @Author: LiuZW
     * @Date: 2020/4/25 23:39
     **/
    @PostMapping("/update")
    @ApiOperation(value = "更新新闻信息", notes = "更新新闻信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "新闻ID", required = true, paramType = "query", dataType = "int"),
    })
    public ResultVO updateNews(Integer id,InsertNewsRequest request){

        return lstNewsService.updateNews(id,request);
    }

    /**
     * @MethodName: deleteCase
     * @Description: 删除新闻信息
     * @Param: [caseId]
     * @Return: com.greencity.website.VO.ResultVO
     * @Author: LiuZW
     * @Date: 2020/4/25 21:47
     **/
    @PostMapping("/delete")
    @ApiOperation(value = "删除新闻信息", notes = "删除新闻信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "新闻ID", required = true, paramType = "query", dataType = "int"),
    })
    public ResultVO deleteNews(Integer id){

        return lstNewsService.deleteNews(id);
    }

    /**
     * @MethodName: deleteBatchNews
     * @Description: 批量删除新闻信息
     * @Param: [ids]
     * @Return: com.greencity.website.VO.ResultVO
     * @Author: LiuZW
     * @Date: 2020/4/30 0:16
     **/
    @PostMapping("/deleteBatch")
    @ApiOperation(value = "批量删除新闻信息", notes = "批量删除新闻信息")
    public ResultVO deleteBatchNews(@RequestBody List<Integer> ids){

        return lstNewsService.deleteBatchNews(ids);
    }

}
