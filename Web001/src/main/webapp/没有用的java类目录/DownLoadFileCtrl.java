package sw.ctrl;

import java.io.BufferedInputStream;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ServletContextAware;
/**
 * 
 * @author Administrator
 * 文件下载模块
 *
 */
@Controller
@RequestMapping("downLoadFileCtrl")
public class DownLoadFileCtrl {
	//使用ajax方式处理下载文件
	@RequestMapping("downLoadFile")
	public ResponseEntity<byte[]> download(HttpServletRequest request) throws IOException {    
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
