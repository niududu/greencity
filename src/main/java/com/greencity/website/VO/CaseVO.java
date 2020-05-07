package com.greencity.website.VO;

import com.greencity.website.enums.CaseTypeNameEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Description:
 * @Author: LiuZW
 * @CreateDate: 2020/4/25 21:25
 * @Version: 1.0
 */
@Data
public class CaseVO {

    private Integer id;
    /**
     * 案例类型【市政、公园、学校、绿化、保洁、其它】
     */
    private Integer type = -1;

    private String typeName;
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
    private String imgSrc;

    public String getTypeName(){
        return CaseTypeNameEnum.getNameById(type);
    }

}
