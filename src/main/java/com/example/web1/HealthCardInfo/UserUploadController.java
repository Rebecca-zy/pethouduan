package com.example.web1.HealthCardInfo;


import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import java.io.File;

import static com.example.web1.HealthCardInfo.PdfUtil.MultipartFileToFile;


@CrossOrigin(origins = "*")
@RestController
public class UserUploadController {
    @Resource
    HttpServletRequest request;
    //处理文件上传
    @RequestMapping(value="/useruploadimg", method = RequestMethod.POST)
    public @ResponseBody String[] uploadImg(@RequestParam("file") MultipartFile[] file) throws Exception {
        String url[] = new String[file.length];
        int len=0;
        for (MultipartFile multipartFile:file){
            String fileName = multipartFile.getOriginalFilename();
            //设置文件上传路径
            String filePath = request.getSession().getServletContext().getRealPath("imgupload/");
            try {
                 Boolean res= FileUtils.uploadFile(multipartFile.getBytes(), filePath, fileName);
                 url[len]=FileUtils.uploadImg(multipartFile,fileName);
            } catch (Exception e) {
                System.out.println(e);
            }
            len++;
        }
        File imageFiles[]=new File[len];
        for (int i=0;i<len;i++){
            imageFiles[i]=MultipartFileToFile(file[i]);
        }

// //        生成pdf文件的路径
//         String outPdfPath = "/Users/zhangyun/Desktop/PdfTest.pdf";
//         PdfUtil.imagesToPdf(outPdfPath, imageFiles);

        return url;
    }



}
