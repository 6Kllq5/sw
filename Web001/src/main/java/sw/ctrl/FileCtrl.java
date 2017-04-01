package sw.ctrl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import sw.ctrl.ctrl_interface.TableCtrlFun;
import sw.service.FileService;
import swutil.FileUtil;
import swutil.RequestTool;
import swutil.UUIDUtil;

@Controller
@RequestMapping(value="FileCtrl")
public class FileCtrl implements TableCtrlFun{
	@Resource(name="FileService")
	private FileService fileService;
	
	public void setFileService(FileService fileService) {
		this.fileService = fileService;
	}
	@RequestMapping(value="fileCtrl")
	@ResponseBody
	public Map fileCtrl(HttpServletRequest request){
		Map resultMap = new HashMap();
		Map paraMap = new HashMap();
		paraMap = RequestTool.getParameterMap(request);
		String method = (String) paraMap.get("method");
		if(method.equals("select_all")){
			resultMap=selectAll_C(paraMap);
		}else if(method.equals("update")){
			resultMap=updateOne_C(paraMap);
		}else if(method.equals("download")){
			
		}else if(method.equals("delete")){
			resultMap = deleteOne_C(paraMap);
		}
		return resultMap;
	}
	
	@RequestMapping(value="uploadfileCtrl")
	@ResponseBody
	public Map add(@RequestParam(value = "file", required = false) MultipartFile file,
			HttpServletRequest request){
		Map resultMap =new HashMap();
		Map paraMap=new HashMap();
		int resultInt=0;
		String wenjian_lujing = FileUtil.uploadFile(file, request).replace("\\", ";");
		
		/*
		 * 拼装路径，web根目录/upload
		 */
		String wenjian_id=UUIDUtil.getRandom().toString().trim();
		
		String fk_userid=request.getParameter("fk_userid");
		
		String fk_anli_id=request.getParameter("fk_anli_id");
		
		String wenjian_jianjie=request.getParameter("wenjian_jianjie");
		
		Calendar now = Calendar.getInstance();
		int year=now.get(Calendar.YEAR);
		int moueth=now.get(Calendar.MONTH) + 1;
		int day=now.get(Calendar.DAY_OF_MONTH);
		String wenjian_gengxinshijian=year+"-"+moueth+"-"+day;
		
		String filename = file.getOriginalFilename();
		
		paraMap.put("wenjian_id", wenjian_id);
		paraMap.put("fk_userid", fk_userid);
		paraMap.put("fk_anli_id", fk_anli_id);
		paraMap.put("wenjian_gengxinshijian", wenjian_gengxinshijian);
		paraMap.put("wenjian_name", filename);
		paraMap.put("wenjian_lujing", wenjian_lujing);
		paraMap.put("wenjian_jianjie", wenjian_jianjie);
		try {
			resultInt=fileService.executAddOne_S(paraMap);
			if(resultInt==0){
				resultMap.put("statu", 0);
				resultMap.put("message", "添加失败");
			}else{
				resultMap.put("statu", 1);
				resultMap.put("message", "添加成功");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultMap;
	}
	
	//使用ajax方式处理下载文件
	@RequestMapping("downloadfile")
	public ResponseEntity<byte[]> download(HttpServletRequest request) throws IOException {    
		 	String filepath=new String(request.getParameter("filepath").getBytes("iso-8859-1"),"utf-8");
		 	filepath=filepath.replaceAll(";", "//");//换成这个\字符会报错
	        File file=new File(filepath);  
	        HttpHeaders headers = new HttpHeaders();    
	        //为了解决中文名称乱码问题  
	        String fileName=new String(file.getName().getBytes("UTF-8"),"iso-8859-1");
	        headers.setContentDispositionFormData("attachment", fileName);   
	        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);   
	        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers, HttpStatus.CREATED);    
	}  
	
	@Override
	public Map selectOne_C(Map paraMap) {
		Map resultMap=new HashMap();
		return resultMap;
	}
	@Override
	public Map deleteOne_C(Map paraMap) {
		// TODO Auto-generated method stub
		Map resultMap=new HashMap();
		int resultInt =0;
		try {
			resultInt=fileService.executDeleteOne_S(paraMap);
			if(resultInt==0){
				resultMap.put("statu", 0);
				resultMap.put("message", "删除失败");
			}else{
				resultMap.put("statu", 1);
				resultMap.put("message", "删除成功");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultMap;
	}
	
	
	@Override
	public Map updateOne_C(Map paraMap) {
		// TODO Auto-generated method stub
		Map resultMap=new HashMap();
		int resultInt=0;
		resultInt=fileService.executUpdateOne_S(paraMap);
		if(resultInt==0){
			resultMap.put("statu",0);
			resultMap.put("message","更新失败");
		}else{
			resultMap.put("statu",1);
			resultMap.put("message","更新成功");
		}
		return resultMap;
	}
	
	
	@Override
	public Map addOne_C(Map paraMap) {
		// TODO Auto-generated method stub
		Map resultMap=new HashMap();
		return resultMap;
	}

	
	@Override
	public Map selectAll_C(Map paraMap) {
		// TODO Auto-generated method stub
		Map resultMap=new HashMap();
		List resultList=new ArrayList();
		try {
			resultList=fileService.executSelectAll_S(paraMap);
			resultMap.put("data", resultList);
			resultMap.put("statu",1);
			resultMap.put("message","查询成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultMap;
	}
	
	
	@Override
	public Map deleteBunch_C(List paraList) {
		// TODO Auto-generated method stub
		Map resultMap=new HashMap();
		return resultMap;
	}
}
