package com.greencity.website.mapper;

import com.greencity.website.VO.AdviceVO;
import com.greencity.website.entity.LstAdvice;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 
 * 反馈意见表 Mapper 接口
 * @作者 LiuZW
 * @时间 2020-05-08
 */
@Mapper
public interface LstAdviceMapper extends BaseMapper<LstAdvice> {

    @Select("select id,name,mobile,email,detail,DATE_FORMAT(create_time,'%Y-%m-%d') AS date from lst_advice ORDER BY create_time DESC")
     List<AdviceVO> selectVOList();
 }