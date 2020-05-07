package com.greencity.website.util;
import com.greencity.website.constant.FtpConstant;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
/**
 * @Description:
 * @Author: LiuZW
 * @CreateDate: 2020/4/27 23:56
 * @Version: 1.0
 */

public class FtpUtil {

    private static FTPClient ftp;

    /**
     * 获取ftp连接
     *
     * @param f
     * @return
     * @throws Exception
     */
    public static boolean connectFtp(FtpConstant f) throws Exception {
        ftp = new FTPClient();
        boolean flag = false;
        int reply;
        if (f.getPort() == null) {
            ftp.connect(f.getIpAddr(), 21);
        } else {
            ftp.connect(f.getIpAddr(), f.getPort());
        }
        ftp.login(f.getUserName(), f.getPwd());
        ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
        reply = ftp.getReplyCode();
        if (!FTPReply.isPositiveCompletion(reply)) {
            ftp.disconnect();
            return flag;
        }
        ftp.changeWorkingDirectory(f.getPath());
        flag = true;
        return flag;
    }

    /**
     * 关闭ftp连接
     */
    public static void closeFtp() {
        if (ftp != null && ftp.isConnected()) {
            try {
                ftp.logout();
                ftp.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * ftp上传文件
     *
     * @param f
     * @throws Exception
     */
    public static void upload(File f) throws Exception {
        if (f.isDirectory()) {
            ftp.makeDirectory(f.getName());
            ftp.changeWorkingDirectory(f.getName());
            String[] files = f.list();
            for (String fstr : files) {
                File file1 = new File(f.getPath() + "/" + fstr);
                if (file1.isDirectory()) {
                    upload(file1);
                    ftp.changeToParentDirectory();
                } else {
                    File file2 = new File(f.getPath() + "/" + fstr);
                    FileInputStream input = new FileInputStream(file2);
                    ftp.storeFile(file2.getName(), input);
                    input.close();
                }
            }
        } else {
            File file2 = new File(f.getPath());
            FileInputStream input = new FileInputStream(file2);
            ftp.storeFile(file2.getName(), input);
            input.close();
        }
        closeFtp();
    }

    public static void main(String[] args) throws Exception {
        FtpUtil.connectFtp(new FtpConstant());
        File file = new File("F:/robotium-solo-5.6.1.jar");
        FtpUtil.upload(file);//把文件上传在ftp上
        System.out.println("上传文件完成。。。。");
    }


}
