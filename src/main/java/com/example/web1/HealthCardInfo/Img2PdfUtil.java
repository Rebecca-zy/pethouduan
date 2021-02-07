package com.example.web1.HealthCardInfo;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

/**
 * 图片转pdf工具类
 */
public class Img2PdfUtil {

    private static Logger logger = Logger.getLogger(Img2PdfUtil.class);
    public static File MultipartFileToFile(MultipartFile multiFile) {
        // 获取文件名
        String fileName = multiFile.getOriginalFilename();
        // 获取文件后缀
        String prefix = fileName.substring(fileName.lastIndexOf("."));
        // 若需要防止生成的临时文件重复,可以在文件名后添加随机码

        try {
            File file = File.createTempFile(fileName, prefix);
            multiFile.transferTo(file);
            return file;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     *
     * @param outPdfFilepath 生成pdf文件路径
     * @param imageFiles 需要转换的图片File类Array,按array的顺序合成图片
     */
    public static void imagesToPdf(String outPdfFilepath, File[] imageFiles) throws Exception {
        logger.info("进入图片合成PDF工具方法");
        File file = new File(outPdfFilepath);
        //创建一个document对象。
        Document document = new Document();
        document.setMargins(0, 0, 0, 0);
        //创建一个PdfWriter实例，
        PdfWriter.getInstance(document, new FileOutputStream(file));
        //打开文档。
        document.open();
        int len = imageFiles.length;
        //在文档中增加图片。
        for (int i = 0; i < len; i++) {
            if (imageFiles[i].getName().toLowerCase().endsWith(".bmp")
                    || imageFiles[i].getName().toLowerCase().endsWith(".jpg")
                    || imageFiles[i].getName().toLowerCase().endsWith(".jpeg")
                    || imageFiles[i].getName().toLowerCase().endsWith(".gif")
                    || imageFiles[i].getName().toLowerCase().endsWith(".png")) {
                String temp = imageFiles[i].getAbsolutePath();
                logger.info("图片路径："+temp);
                Image img = Image.getInstance(temp);
                img.setAlignment(Image.ALIGN_CENTER);
                //img.scaleAbsolute(597, 844);// 直接设定显示尺寸
                // 根据图片大小设置页面，一定要先设置页面，再newPage（），否则无效
                document.setPageSize(new Rectangle(img.getWidth(), img.getHeight()));
                //document.setPageSize(new Rectangle(597, 844));
                document.newPage();
                document.add(img);
            }
        }
        //关闭文档。
        document.close();
        logger.info("图片合成PDF完成");
    }


}

