package com.greencity.website.mapper;

import com.greencity.website.VO.InviteVO;
import com.greencity.website.entity.LstInvite;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 招聘信息表 Mapper 接口
 *
 * @作者 LiuZW
 * @时间 2020-04-25
 */
@Mapper
public interface LstInviteMapper extends BaseMapper<LstInvite> {

    @Select("select id,job_name AS name,job_number AS number,invite_detail AS requirement,publish_date AS time " +
            "from lst_invite where is_delete = 0 ORDER BY create_time DESC")
    List<InviteVO> selectVOList();

    void deleteBatchInvite(@Param("list") List<Integer> ids);
}