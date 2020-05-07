package com.greencity.website.service;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.greencity.website.VO.CaseVO;
import com.greencity.website.VO.request.InsertCaseRequest;
import com.greencity.website.VO.request.PageRequest;
import com.greencity.website.VO.ResultVO;
import com.greencity.website.entity.LstCase;
import com.greencity.website.enums.ResultEnum;
import com.greencity.website.mapper.LstCaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.greencity.website.util.ResultVOUtil;
import com.greencity.website.util.StringUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 项目案例列表 服务实现类
 *
 * @作者 LiuZW
 * @时间 2020-04-25
 */
@Service
public class LstCaseService extends ServiceImpl<LstCaseMapper, LstCase> {

    @Resource
    private LstCaseMapper lstCaseMapper;

    /**
     * @MethodName: getCaseList
     * @Description: 获取案例列表
     * @Param: [request]
     * @Return: com.greencity.website.VO.ResultVO
     * @Author: LiuZW
     * @Date: 2020/4/25 21:12
     **/
    public ResultVO getCaseList(PageRequest request) {
        PageHelper.startPage(request.getCurrentPage(), request.getPageSize());
        List<CaseVO> caseVOList = lstCaseMapper.selectVOList();
        JSONObject json = new JSONObject();
        json.put("list", caseVOList);
        json.put("totalPageCount", new PageInfo<>(caseVOList).getTotal());
        return ResultVOUtil.success(json);
    }

    /**
     * @MethodName: getCaseDetail
     * @Description: 获取案例详情信息
     * @Param: [caseId]
     * @Return: com.greencity.website.VO.ResultVO
     * @Author: LiuZW
     * @Date: 2020/4/25 21:12
     **/
    public ResultVO getCaseDetail(int caseId) {
        return null;
    }

    /**
     * @MethodName: saveCase
     * @Description: 新增案例
     * @Param: [request]
     * @Return: com.greencity.website.VO.ResultVO
     * @Author: LiuZW
     * @Date: 2020/4/25 21:43
     **/
    @Transactional
    public ResultVO saveCase(InsertCaseRequest request) {

        LstCase lstCase = new LstCase();
        BeanUtils.copyProperties(request, lstCase);
        lstCaseMapper.insert(lstCase);
        return ResultVOUtil.success();
    }

    /**
     * @MethodName: updateCase
     * @Description: 更新案例
     * @Param: [caseId]
     * @Return: com.greencity.website.VO.ResultVO
     * @Author: LiuZW
     * @Date: 2020/4/25 21:49
     **/
    @Transactional
    public ResultVO updateCase(Integer caseId, InsertCaseRequest request) {
        LstCase lstCase = lstCaseMapper.selectById(caseId);
        if (StringUtil.isNull(lstCase)) {
            return ResultVOUtil.error(ResultEnum.CASE_NOT_EXIST);
        }
        BeanUtils.copyProperties(request, lstCase);
        lstCaseMapper.updateById(lstCase);
        return ResultVOUtil.success();
    }

    /**
     * @MethodName: deleteCase
     * @Description: 删除案例
     * @Param: [caseId]
     * @Return: com.greencity.website.VO.ResultVO
     * @Author: LiuZW
     * @Date: 2020/4/25 21:49
     **/
    @Transactional
    public ResultVO deleteCase(Integer caseId) {
        LstCase lstCase = lstCaseMapper.selectById(caseId);
        if (StringUtil.isNull(lstCase)) {
            return ResultVOUtil.error(ResultEnum.CASE_NOT_EXIST);
        }
        if (lstCase.getIsDelete() != 0) {
            return ResultVOUtil.error(ResultEnum.CASE_DELETE_ERROR);
        }
        lstCase.setIsDelete(1);
        lstCaseMapper.updateById(lstCase);
        return ResultVOUtil.success();
    }

    /**
     * @MethodName: deleteBatchCase
     * @Description: 批量删除案例信息
     * @Param: [ids]
     * @Return: com.greencity.website.VO.ResultVO
     * @Author: LiuZW
     * @Date: 2020/4/29 23:43
     **/
    @Transactional
    public ResultVO deleteBatchCase(List<Integer> ids) {
        lstCaseMapper.deleteBatchCase(ids);
        return ResultVOUtil.success();
    }
}
