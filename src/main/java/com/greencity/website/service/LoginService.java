package com.greencity.website.service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.greencity.website.VO.ResultVO;
import com.greencity.website.constant.FtpConstant;
import com.greencity.website.entity.IfoUser;
import com.greencity.website.mapper.IfoUserMapper;
import com.greencity.website.util.FtpJSch;
import com.greencity.website.util.ResultVOUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItem;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.Resource;
import java.io.*;
import java.util.Date;

/**
 * @Description:
 * @Author: LiuZW
 * @CreateDate: 2020/4/21 23:28
 * @Version: 1.0
 */
@Service
public class LoginService {

    @Resource
    private IfoUserMapper userMapper;


    /**
     * @MethodName: changePassword
     * @Description: 修改密码
     * @Param: [oldPassword, newPassword]
     * @Return: com.greencity.website.VO.ResultVO
     * @Author: LiuZW
     * @Date: 2020/4/29 21:15
     **/
    @Transactional
    public ResultVO changePassword(String oldPassword, String newPassword) {
        Subject subject = SecurityUtils.getSubject();
        String principal = (String) subject.getPrincipal();
        QueryWrapper<IfoUser> queryWrapper = new QueryWrapper<>(new IfoUser());
        queryWrapper.getEntity().setAccount(principal);
        IfoUser ifoUser = userMapper.selectOne(queryWrapper);
        String target = new Md5Hash(oldPassword).toString();
        if (!ifoUser.getPassword().equals(target)) {
            return ResultVOUtil.error(500,"旧密码错误,请核对后填写！");
        }
        String secret = new Md5Hash(newPassword).toString();
        ifoUser.setPassword(secret);
        ifoUser.setUpdateTime(new Date());
        userMapper.updateById(ifoUser);
        return ResultVOUtil.success();
    }

    /**
     * @MethodName: upload
     * @Description: 图片上传
     * @Param: [file]
     * @Return: com.greencity.website.VO.ResultVO
     * @Author: LiuZW
     * @Date: 2020/5/1 16:45
     **/
    public ResultVO upload(MultipartFile file) throws Exception {
        FtpJSch.getConnect();
        File file1 = multipartFileToFile(file);
        String fileName = FtpJSch.uploadFile(file1);
        JSONObject jsonResult = new JSONObject();
        jsonResult.put("url", FtpConstant.baseUrl + fileName);
        return ResultVOUtil.success(jsonResult);
    }


    public static File multipartFileToFile(MultipartFile file ) throws Exception {
        File toFile = null;
        if(file.equals("")||file.getSize()<=0){
            file = null;
        }else {
            InputStream ins = null;
            ins = file.getInputStream();
            toFile = new File(file.getOriginalFilename());
            inputStreamToFile(ins, toFile);
            ins.close();
        }
        return toFile;
    }

    public static void inputStreamToFile(InputStream ins, File file) {
        try {
            OutputStream os = new FileOutputStream(file);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            ins.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
