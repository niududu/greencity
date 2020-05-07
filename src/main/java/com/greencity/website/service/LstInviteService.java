package com.greencity.website.service;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.greencity.website.VO.CaseVO;
import com.greencity.website.VO.InviteVO;
import com.greencity.website.VO.ResultVO;
import com.greencity.website.VO.request.InsertCaseRequest;
import com.greencity.website.VO.request.InsertInviteRequest;
import com.greencity.website.VO.request.PageRequest;
import com.greencity.website.entity.LstCase;
import com.greencity.website.entity.LstInvite;
import com.greencity.website.enums.ResultEnum;
import com.greencity.website.mapper.LstInviteMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.greencity.website.util.ResultVOUtil;
import com.greencity.website.util.StringUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 
 * 招聘信息表 服务实现类
 * @作者 LiuZW
 * @时间 2020-04-25
 */
@Service
public class LstInviteService extends ServiceImpl<LstInviteMapper, LstInvite> {
	
	@Resource
	private LstInviteMapper lstInviteMapper;


    /**
     * @MethodName: getInviteList
     * @Description: 获取招聘信息列表
     * @Param: [request]
     * @Return: com.greencity.website.VO.ResultVO
     * @Author: LiuZW
     * @Date: 2020/4/25 22:57
     **/
    public ResultVO getInviteList(PageRequest request) {
        PageHelper.startPage(request.getCurrentPage(), request.getPageSize());
        List<InviteVO> inviteVOList = lstInviteMapper.selectVOList();
        JSONObject json = new JSONObject();
        json.put("list", inviteVOList);
        json.put("totalPageCount", new PageInfo<>(inviteVOList).getTotal());
        return ResultVOUtil.success(json);
    }

    public ResultVO getInviteDetail(int inviteId) {
        return null;
    }

    /**
     * @MethodName: saveInvite
     * @Description: 保存
     * @Param: [request]
     * @Return: com.greencity.website.VO.ResultVO
     * @Author: LiuZW
     * @Date: 2020/4/25 23:11
     **/
    @Transactional
    public ResultVO saveInvite(InsertInviteRequest request) {
        LstInvite lstInvite = new LstInvite();
        BeanUtils.copyProperties(request,lstInvite);
        lstInviteMapper.insert(lstInvite);
        return ResultVOUtil.success();
    }

    /**
     * @MethodName: updateInvite
     * @Description: 更新招聘信息
     * @Param: [inviteId, request]
     * @Return: com.greencity.website.VO.ResultVO
     * @Author: LiuZW
     * @Date: 2020/4/25 23:17
     **/
    @Transactional
    public ResultVO updateInvite(Integer inviteId, InsertInviteRequest request) {
        LstInvite lstInvite = lstInviteMapper.selectById(inviteId);
        if (StringUtil.isNull(lstInvite)) {
            return ResultVOUtil.error(ResultEnum.INVITE_NOT_EXIST);
        }
        BeanUtils.copyProperties(request, lstInvite);
        lstInviteMapper.updateById(lstInvite);
        return ResultVOUtil.success();
    }

    /**
     * @MethodName: deleteInvite
     * @Description: 删除招聘信息
     * @Param: [inviteId]
     * @Return: com.greencity.website.VO.ResultVO
     * @Author: LiuZW
     * @Date: 2020/4/25 23:17
     **/
    @Transactional
    public ResultVO deleteInvite(Integer inviteId) {
        LstInvite lstInvite = lstInviteMapper.selectById(inviteId);
        if (StringUtil.isNull(lstInvite)) {
            return ResultVOUtil.error(ResultEnum.INVITE_NOT_EXIST);
        }
        if (lstInvite.getIsDelete() != 0) {
            return ResultVOUtil.error(ResultEnum.INVITE_DELETE_ERROR);
        }
        lstInvite.setIsDelete(1);
        lstInviteMapper.updateById(lstInvite);
        return ResultVOUtil.success();
    }

    /**
     * @MethodName: deleteBatchInvite
     * @Description: 批量删除
     * @Param: [ids]
     * @Return: com.greencity.website.VO.ResultVO
     * @Author: LiuZW
     * @Date: 2020/4/30 0:14
     **/
    @Transactional
    public ResultVO deleteBatchInvite(List<Integer> ids) {
        lstInviteMapper.deleteBatchInvite(ids);
        return ResultVOUtil.success();
    }

}
