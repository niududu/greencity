package com.greencity.website.mapper;

import com.greencity.website.VO.NewsVO;
import com.greencity.website.entity.LstNews;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 新闻列表 Mapper 接口
 *
 * @作者 LiuZW
 * @时间 2020-04-25
 */
@Mapper
public interface LstNewsMapper extends BaseMapper<LstNews> {

    @Select("select id,title AS name,brief,content,author,url AS imgSrc,create_time AS date " +
            "from lst_news where is_delete = 0 ORDER BY create_time DESC")
    List<NewsVO> selectVOList();

    void deleteBatchNews(@Param("list") List<Integer> ids);
}