package com.greencity.website.service;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.greencity.website.VO.InviteVO;
import com.greencity.website.VO.NewsVO;
import com.greencity.website.VO.ResultVO;
import com.greencity.website.VO.request.InsertNewsRequest;
import com.greencity.website.VO.request.PageRequest;
import com.greencity.website.entity.LstInvite;
import com.greencity.website.entity.LstNews;
import com.greencity.website.enums.ResultEnum;
import com.greencity.website.mapper.LstNewsMapper;
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
 * 新闻列表 服务实现类
 * @作者 LiuZW
 * @时间 2020-04-25
 */
@Service
public class LstNewsService extends ServiceImpl<LstNewsMapper, LstNews> {
	
	@Resource
	private LstNewsMapper lstNewsMapper;

    /**
     * @MethodName: getNewsList
     * @Description: 获取新闻列表
     * @Param: [request]
     * @Return: com.greencity.website.VO.ResultVO
     * @Author: LiuZW
     * @Date: 2020/4/25 23:46
     **/
    public ResultVO getNewsList(PageRequest request) {
        PageHelper.startPage(request.getCurrentPage(), request.getPageSize());
        List<NewsVO> newsVOList = lstNewsMapper.selectVOList();
        JSONObject json = new JSONObject();
        json.put("list", newsVOList);
        json.put("totalPageCount", new PageInfo<>(newsVOList).getTotal());
        return ResultVOUtil.success(json);
    }

    /**
     * @MethodName: saveNews
     * @Description: 保存新闻信息
     * @Param: [request]
     * @Return: com.greencity.website.VO.ResultVO
     * @Author: LiuZW
     * @Date: 2020/4/25 23:49
     **/
    @Transactional
    public ResultVO saveNews(InsertNewsRequest request) {

        LstNews lstNews = new LstNews();
        BeanUtils.copyProperties(request,lstNews);
        lstNewsMapper.insert(lstNews);
        return ResultVOUtil.success();
    }

    /**
     * @MethodName: updateNews
     * @Description: 更新新闻
     * @Param: [id, request]
     * @Return: com.greencity.website.VO.ResultVO
     * @Author: LiuZW
     * @Date: 2020/4/25 23:50
     **/
    @Transactional
    public ResultVO updateNews(Integer id, InsertNewsRequest request) {
        LstNews lstNews = lstNewsMapper.selectById(id);
        if (StringUtil.isNull(lstNews)) {
            return ResultVOUtil.error(ResultEnum.NEWS_NOT_EXIST);
        }
        BeanUtils.copyProperties(request, lstNews);
        lstNewsMapper.updateById(lstNews);
        return ResultVOUtil.success();
    }

    /**
     * @MethodName: deleteNews
     * @Description: 删除新闻
     * @Param: [id]
     * @Return: com.greencity.website.VO.ResultVO
     * @Author: LiuZW
     * @Date: 2020/4/25 23:50
     **/
    @Transactional
    public ResultVO deleteNews(Integer id) {
        LstNews lstNews = lstNewsMapper.selectById(id);
        if (StringUtil.isNull(lstNews)) {
            return ResultVOUtil.error(ResultEnum.NEWS_NOT_EXIST);
        }
        if (lstNews.getIsDelete() != 0) {
            return ResultVOUtil.error(ResultEnum.NEWS_DELETE_ERROR);
        }
        lstNews.setIsDelete(1);
        lstNewsMapper.updateById(lstNews);
        return ResultVOUtil.success();
    }

    /**
     * @MethodName: deleteBatchNews
     * @Description: 批量删除新闻
     * @Param: [ids]
     * @Return: com.greencity.website.VO.ResultVO
     * @Author: LiuZW
     * @Date: 2020/4/30 0:16
     **/
    @Transactional
    public ResultVO deleteBatchNews(List<Integer> ids) {
        lstNewsMapper.deleteBatchNews(ids);
        return ResultVOUtil.success();
    }
}
