package com.greencity.website.service;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.greencity.website.VO.AdviceVO;
import com.greencity.website.VO.CaseVO;
import com.greencity.website.VO.ResultVO;
import com.greencity.website.VO.request.InsertAdviceRequest;
import com.greencity.website.VO.request.PageRequest;
import com.greencity.website.entity.LstAdvice;
import com.greencity.website.mapper.LstAdviceMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.greencity.website.util.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 反馈意见表 服务实现类
 *
 * @作者 LiuZW
 * @时间 2020-05-08
 */
@Service
public class LstAdviceService extends ServiceImpl<LstAdviceMapper, LstAdvice> {

    @Resource
    private LstAdviceMapper lstAdviceMapper;

    /**
     * @MethodName: getAdviceList
     * @Description: 获取反馈列表
     * @Param: [request]
     * @Return: com.greencity.website.VO.ResultVO
     * @Author: LiuZW
     * @Date: 2020/5/8 14:19
     **/
    public ResultVO getAdviceList(PageRequest request) {
        PageHelper.startPage(request.getCurrentPage(), request.getPageSize());
        List<AdviceVO> adviceVOList = lstAdviceMapper.selectVOList();
        JSONObject json = new JSONObject();
        json.put("list", adviceVOList);
        json.put("totalPageCount", new PageInfo<>(adviceVOList).getTotal());
        return ResultVOUtil.success(json);
    }

    /**
     * @MethodName: saveAdvice
     * @Description: 保存反馈信息
     * @Param: [request]
     * @Return: com.greencity.website.VO.ResultVO
     * @Author: LiuZW
     * @Date: 2020/5/8 14:27
     **/
    public ResultVO saveAdvice(InsertAdviceRequest request) {
        LstAdvice lstAdvice = new LstAdvice();
        BeanUtils.copyProperties(request, lstAdvice);
        int insert = lstAdviceMapper.insert(lstAdvice);
        if (insert > 0) {
            return ResultVOUtil.success();
        }
        return ResultVOUtil.error(500,"提交反馈信息失败！");
    }
}
