package swutil;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public class FileUtil {
	//返回文件存放路径---文件上传
	public static String uploadFile(MultipartFile file,HttpServletRequest request){
		String  resultString =null;
		String reallyName= file.getOriginalFilename();// 获取问价名称是传过来的文件名称
		String array[]=reallyName.split("\\.");
		String suff=array[array.length-1];
		try{
			String filename=String.valueOf(new Date().getTime())+"."+suff;//使用时间作为文件名称保证唯一
//			
			String webroot = request.getServletContext().getRealPath("/");
			String userFolder=request.getParameter("fk_userid");//对应上传者的目录
			String anliFolder=request.getParameter("fk_anli_id");//对应某一个案例的文件存放目录
			//upload目录
			File upload=new File(webroot.trim(),"file");
			//用户目录
			File user_upload_path=new File(upload,userFolder.trim());
			//案例目录
			File anli_upload_path=new File(user_upload_path,anliFolder.trim());
			//判断目录是否存在不存在则创建
			if(!upload.exists()){
				upload.mkdirs();
			}
			if(!user_upload_path.exists()){
				user_upload_path.mkdirs();
			}
			if(!anli_upload_path.exists()){
				anli_upload_path.mkdirs();
			}
			
			File newFile = new File(anli_upload_path, filename);
			if (newFile.exists()) {
				newFile.delete();
			}
			//移动目录
			file.transferTo(newFile);
			
			//拼接路径
			resultString=anli_upload_path.getPath()+"\\"+filename;
		}catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultString;
	}
	
	
	//三张图片
	public static String uploadImg(MultipartFile file,HttpServletRequest request){
		String  resultString =null;
		try{
			String filename = file.getOriginalFilename();// 获取问价名称是传过来的文件名称
			String webroot = request.getServletContext().getRealPath("/");
			String userFolder=request.getParameter("fk_userid");//对应上传者的目录
			String anliFolder=request.getParameter("fk_anli_id");//对应某一个案例的文件存放目录
			//upload目录
			File upload=new File(webroot.trim(),"file");
			//用户目录
			File user_upload_path=new File(upload,userFolder.trim());
			//案例目录
			File anli_upload_path=new File(user_upload_path,anliFolder.trim());
			//判断目录是否存在不存在则创建
			if(!upload.exists()){
				upload.mkdirs();
			}
			if(!user_upload_path.exists()){
				user_upload_path.mkdirs();
			}
			if(!anli_upload_path.exists()){
				anli_upload_path.mkdirs();
			}
			
			File newFile = new File(anli_upload_path, filename);
			if (newFile.exists()) {
				newFile.delete();
			}
			//移动目录
			file.transferTo(newFile);
			
			//拼接路径
			resultString=anli_upload_path.getPath()+"\\"+filename;
		}catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultString;
	}
	
	//文件下载
	public static ResponseEntity<byte[]> download(HttpServletRequest request) throws IOException {    
		 	String filepath=new String(request.getParameter("filepath").getBytes("iso-8859-1"),"utf-8");
	        File file=new File(filepath);  
	        HttpHeaders headers = new HttpHeaders();    
	        //为了解决中文名称乱码问题  
	        String fileName=new String(file.getName().getBytes("UTF-8"),"iso-8859-1");
	        headers.setContentDispositionFormData("attachment", fileName);   
	        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);   
	        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers, HttpStatus.CREATED);    
	}    
}
