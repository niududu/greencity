package com.greencity.website.util;


import com.greencity.website.VO.ResultVO;
import com.greencity.website.enums.ResultEnum;

/**
 * @Description:
 * @Author: LiuZW
 * @CreateDate: 2020/1/9/009 13:56
 * @Version: 1.0
 */
public class ResultVOUtil {

    /**
     * @MethodName: success
     * @Description: 返回成功
     * @Param: [object]
     * @Return: com.thinkoon.module.VO
     * @Author: LiuZW
     * @Date: 2020/1/9/009 13:59
     **/
    public static ResultVO success(Object object) {

        ResultVO<Object> resultVO = new ResultVO<>();
        resultVO.setCode(ResultEnum.SUCCESS.getCode());
        resultVO.setMsg(ResultEnum.SUCCESS.getMessage());
        resultVO.setData(object);
        return resultVO;
    }

    public static ResultVO success() {
        return success(null);
    }

    public static ResultVO error(Integer code, String msg) {
        ResultVO<Object> resultVO = new ResultVO<>();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return resultVO;
    }

    public static ResultVO error(ResultEnum resultEnum){
        ResultVO<Object> resultVO = new ResultVO<>();
        resultVO.setCode(resultEnum.getCode());
        resultVO.setMsg(resultEnum.getMessage());
        return resultVO;
    }

}
