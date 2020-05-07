package com.greencity.website.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
/**
 *
 * 项目案例列表-数据库实体对象
 * @作者 LiuZW
 * @时间 2020-04-25
 */
@Data
@TableName("greencity.lst_case")
public class LstCase implements Serializable  {

    private static final long serialVersionUID = 1L;



    /**
     * 主键ID
     */
	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 案例类型【市政、公园、学校、绿化、保洁、其它】 
     */
	private Integer type;
    /**
     * 案例标题
     */
	private String title;
    /**
     * 案例简介
     */
	private String brief;
    /**
     * 案例内容
     */
	private String content;
    /**
     * 案例图片
     */
	private String url;
    /**
     * 是否删除 
     */
	private Integer isDelete;
    /**
     * 更新时间
     */
	private Date updateTime;
    /**
     * 创建时间
     */
	private Date createTime;
    /**
     * 创建人
     */
	private Integer createId;


}
