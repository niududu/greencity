package com.greencity.website.util;

import com.jcraft.jsch.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.Properties;
import java.util.UUID;
import java.util.Vector;

/**
 * @Description:
 * @Author: LiuZW
 * @CreateDate: 2020/4/28 0:19
 * @Version: 1.0
 */
public class FtpJSch  {
    private static ChannelSftp sftp = null;

    //账号
    private static String user = "root";
    //主机ip
    private static String host =  "";
    //密码
    private static String password = "";
    //端口
    private static int port = 22;
    //上传地址
    private static String directory = "/redsun/website/html";
    //下载目录
    private static String saveFile = "E:\\code\\practise\\website\\download";

    public static FtpJSch getConnect(){
        FtpJSch ftp = new FtpJSch();
        try {
            JSch jsch = new JSch();

            //获取sshSession  账号-ip-端口
            Session sshSession =jsch.getSession(user, host,port);
            //添加密码
            sshSession.setPassword(password);
            Properties sshConfig = new Properties();
            //严格主机密钥检查
            sshConfig.put("StrictHostKeyChecking", "no");

            sshSession.setConfig(sshConfig);
            //开启sshSession链接
            sshSession.connect();
            //获取sftp通道
            Channel channel = sshSession.openChannel("sftp");
            //开启
            channel.connect();
            sftp = (ChannelSftp) channel;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ftp;
    }

    /**
     *
     * @param uploadFile 上传文件的路径
     * @return 服务器上文件名
     */
    public static String upload(String uploadFile) {
        File file = null;
        String fileName = null;
        try {
            sftp.cd(directory);
            file = new File(uploadFile);
            //获取随机文件名
            fileName  = UUID.randomUUID().toString() + file.getName().substring(file.getName().length()-5);
            //文件名是 随机数加文件名的后5位
            sftp.put(new FileInputStream(file), fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return file == null ? null : fileName;
    }

    public static String uploadFile(File file) {
        String fileName = null;
        try {
            sftp.cd(directory);
            fileName  = StringUtil.getDateTimeFormatToString(new Date(),"yyyyMMdd")
                    + ((int)((Math.random()*9+1)*1000))
                    +file.getName().substring(file.getName().length()-5);
            //获取随机文件名
            //文件名是 随机数加文件名的后5位
            sftp.put(new FileInputStream(file), fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return file == null ? null : fileName;
    }

    /**
     * 下载文件
     *
     * @param downloadFileName
     *            下载的文件名
     */
    public void download(String downloadFileName) {
        try {
            sftp.cd(directory);

            File file = new File(saveFile);

            sftp.get(downloadFileName, new FileOutputStream(file));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除文件
     *
     * @param deleteFile
     *            要删除的文件名字
     */
    public void delete(String deleteFile) {
        try {
            sftp.cd(directory);
            sftp.rm(deleteFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 列出目录下的文件
     *
     * @param directory
     *            要列出的目录
     * @param directory
     * @return
     * @throws SftpException
     */
    public Vector listFiles(String directory)
            throws SftpException {
        return sftp.ls(directory);
    }

    public static void main(String[] args) {
        //getConnect();
        //upload("E:\\code\\practise\\website\\upload\\1.png");
        // 点击+号上传 == 》upload接口 ==》URl
        String yyyyMMdd = StringUtil.getDateTimeFormatToString(new Date(), "yyyyMMdd")
                + ((int)((Math.random()*9+1)*1000));
        System.out.println(yyyyMMdd);
    }


}
