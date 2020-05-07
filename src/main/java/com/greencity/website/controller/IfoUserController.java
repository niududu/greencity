package com.greencity.website.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.springframework.beans.BeanUtils;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.greencity.website.service.IfoUserService;
import com.greencity.website.entity.IfoUser;

import lombok.extern.log4j.Log4j2;


/**
 * <p>
 * 账号信息表 前端控制器
 * </p>
 *
 * @author LiuZW
 * @since 2020-04-25
 */
@RestController
@RequestMapping("ifoUser")
@Log4j2
public class IfoUserController {


	@Autowired
    private IfoUserService ifoUserService;



}
