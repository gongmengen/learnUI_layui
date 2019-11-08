package learnUI.controller;

import learnUI.common.LayResult;
import learnUI.utils.FastDFSClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;

@Controller
public class UpLoadController {

    @RequestMapping("/upload/")
    @ResponseBody
    public LayResult fileUpLoad(MultipartFile file){
        try {
            FastDFSClient fastDFSClient = new FastDFSClient("classpath:conf/fastdfs.conf");
            String originalFilename = file.getOriginalFilename();
            String fileextension = originalFilename.substring(originalFilename.lastIndexOf(".")+1);
            String url = fastDFSClient.uploadFile(file.getBytes(), fileextension);
            url="http://192.168.25.133/"+url;
            System.out.println(url);
            HashMap hashMap = new HashMap();
            hashMap.put("src",url);
            return new LayResult(0,"",hashMap);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return new LayResult(1,"上传失败",null);
        }
    }
}
