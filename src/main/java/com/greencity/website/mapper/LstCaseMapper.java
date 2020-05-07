package com.greencity.website.mapper;

import com.greencity.website.VO.CaseVO;
import com.greencity.website.entity.LstCase;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 
 * 项目案例列表 Mapper 接口
 * @作者 LiuZW
 * @时间 2020-04-25
 */
@Mapper
public interface LstCaseMapper extends BaseMapper<LstCase> {

    @Select("select id,type,title,brief,content,url AS imgSrc " +
            "from lst_case where is_delete = 0 ORDER BY create_time DESC")
    List<CaseVO> selectVOList();

    void deleteBatchCase(@Param("list") List<Integer> ids);
}