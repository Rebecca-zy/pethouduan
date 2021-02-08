package com.example.web1.HealthCardInfo;


import net.coobird.thumbnailator.Thumbnails;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class FileUtils {

    public static double getAccuracy(long size) {
        double accuracy;
        if (size < 900) {
            accuracy = 0.85;
        } else if (size < 2047) {
            accuracy = 0.6;
        } else if (size < 3275) {
            accuracy = 0.44;
        } else {
            accuracy = 0.4;
        }
        return accuracy;
    }


    /**
     * @Description:压缩文件至指定大小
     **/
    public static void commpressPicCycle(String desPath, long desFileSize, double accuracy) throws IOException {
        File srcFileJPG = new File(desPath);
        //如果小于指定大小不压缩；如果大于等于指定大小压缩
        if (srcFileJPG.length() <= desFileSize) {
            return;
        }
        // 计算宽高
        BufferedImage bim = ImageIO.read(srcFileJPG);
        int desWidth = new BigDecimal(bim.getWidth()).multiply(new BigDecimal(accuracy)).intValue();
        int desHeight = new BigDecimal(bim.getHeight()).multiply(new BigDecimal(accuracy)).intValue();
        Thumbnails.of(desPath).size(desWidth, desHeight).outputQuality(accuracy).toFile(desPath);
        commpressPicCycle(desPath, desFileSize, accuracy);
    }



    public static Boolean uploadFile(byte[] file, String filePath, String fileName) throws Exception{
        FileOutputStream out = null;
        try{
            File targetFile = new File(filePath);
            if(!targetFile.exists()){
                targetFile.mkdirs();
            }
            out = new FileOutputStream(filePath+fileName);
            out.write(file);
            out.flush();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } finally {
            out.close();
        }
    }
    public static String uploadImg(MultipartFile file, String urlName){
        String originalName = file.getOriginalFilename();
        String suffix = originalName.substring(originalName.lastIndexOf(".") + 1);
        SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
        String date = df1.format(new Date());
        String filePath = "";
        //保存到数据库的url的路径
        filePath = "/Library/PetPhoto/"+urlName+"/" + date + "/";
        //filePath = "C:/"+urlName+"/" + date + "/";
        String uuid = UUID.randomUUID().toString();
        String fileName = uuid + "." + suffix;
        String fullPath = "";
        try {
            //执行保存操作
            Boolean writeFlag = uploadFile(file.getBytes(), filePath, fileName);
            if (writeFlag) {
                //保存到数据库的url
                fullPath = "http://192.168.0.101:8080" + "/"+urlName+"/" + date + "/" + fileName;
                //保存到数据库
            }
        }catch (Exception e){
            return "error";
        }
        return fullPath;
    }
}



