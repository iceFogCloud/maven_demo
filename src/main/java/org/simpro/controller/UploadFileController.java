package org.simpro.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.simpro.utils.DateUtil;
import org.simpro.utils.PropertiesUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * 用户登录 控制层
 * @author yan_zhx
 * 2019年6月11日
 * TODO
 */
@Controller
@RequestMapping("/uploadFileController")
public class UploadFileController extends BaseController {

	
	 @RequestMapping(value="/upload")
	 @ResponseBody
	 public Map<String,Object> importFile(@RequestParam(value = "fileUpload", required = false) MultipartFile fileUpload, HttpServletRequest request) {
		 Map<String, Object> ret = new HashMap<String, Object>();
	        
	        String FILE_UPLOAD_PATH = PropertiesUtils.getPara("FILE_UPLOAD_PATH");
	        String filePath = PropertiesUtils.getPara("filePath");
	        //判断保存文件的路径是否存在
	        File fileUploadPath = new File(FILE_UPLOAD_PATH+DateUtil.getDays()+"/");
	        if (!fileUploadPath.exists()) {
	            fileUploadPath.mkdir();
	        }
	        
	        if (ServletFileUpload.isMultipartContent(request)) {
	            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
	            List<MultipartFile> fileList = multipartRequest.getFiles("fileUpload");
	            for (MultipartFile item : fileList) {
	                String fileName = "";        //当前上传文件全名称
	                String fileType = "";        //当前上传文件类型
	                String saveFileName = "";    //保存到服务器目录的文件名称
	                String reportFileAddr = "";      //保存到服务器目录的文件全路径
	                try {
	                    fileName = item.getOriginalFilename();
	                    String _fileName = fileName.substring(fileName.lastIndexOf("."),fileName.length());
	                    fileType = item.getContentType();
	                    saveFileName = DateUtil.getCurrTime()+_fileName;
	                    
	                    reportFileAddr = filePath + DateUtil.getDays() + "/" + saveFileName;
	                    
	                    File savedFile = new File(fileUploadPath, saveFileName);
	                    item.transferTo(savedFile);
	                   
	                    //上传文件成功，保存文件信息到表reportDetail
	                    Map<String, Object> param = new HashMap<String, Object>();
	                    param.put("reportName", fileName);
	                    param.put("reportType", fileType);
	                    param.put("createTime", DateUtil.getTime());
	                    param.put("imgUrl", reportFileAddr);
	                    ret.putAll(param);
	                    ret.put("success", true);
	                } catch (Exception e) {
	                    ret.put("success", false);
	                    ret.put("message", e.getMessage());
	                }
	            }
	        }
	        return ret;
	 }
}
