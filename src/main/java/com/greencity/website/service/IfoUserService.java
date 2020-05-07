package com.greencity.website.service;

import java.util.List;

import com.greencity.website.entity.IfoUser;
import com.greencity.website.mapper.IfoUserMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 
 * 账号信息表 服务实现类
 * @作者 LiuZW
 * @时间 2020-04-25
 */
@Service
public class IfoUserService extends ServiceImpl<IfoUserMapper, IfoUser> {
	
	@Resource
	private IfoUserMapper ifoUserMapper;
	

}
