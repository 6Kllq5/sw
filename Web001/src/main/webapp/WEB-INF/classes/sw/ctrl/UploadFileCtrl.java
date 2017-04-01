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

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import sw.service.GetAllZhiKLiaoService;
import sw.service.UpdateAnLiStateService;
import sw.service.UploadZLService;
import swutil.UUIDUtil;

@Controller
@RequestMapping(value = "uploadFileCtrl")
public class UploadFileCtrl {
	@Resource(name = "uploadZLService")
	private UploadZLService uploadZLService;

	public void setUploadZLService(UploadZLService uploadZLService) {
		this.uploadZLService = uploadZLService;
	}
	
	@Resource(name="getAllZhiKLiaoService")
	private  GetAllZhiKLiaoService getAllZhiKLiaoService;
	
	public void setGetAllZhiKLiaoService(GetAllZhiKLiaoService getAllZhiKLiaoService) {
		this.getAllZhiKLiaoService = getAllZhiKLiaoService;
	}
	
	//修改当前的state为2
	
	@Resource(name="updateAnLiStateService")
	private UpdateAnLiStateService updateAnLiStateService;

	public void setUpdateAnLiStateService(UpdateAnLiStateService updateAnLiStateService) {
		this.updateAnLiStateService = updateAnLiStateService;
	}



	@RequestMapping(value = "upload")
	public ModelAndView upload(@RequestParam(value = "file", required = false) MultipartFile file,
			HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView();
		Map paramMap = new HashMap();
		//yongyushouji1jieguo
		List resultList=new ArrayList();
		//存入数据库文件
		String wenjian_id=UUIDUtil.getRandom();
		//生成的一部分
		Calendar now = Calendar.getInstance();
		String filename = file.getOriginalFilename();// 获取问价名称是传过来的文件名称
		
		System.out.println(filename);
		
		String webroot = request.getServletContext().getRealPath("/");

		/*
		 * 拼装路径，web根目录/upload
		 */
		
		String userFolder=request.getParameter("fk_userid");
		
		String anliFolder=request.getParameter("fk_anli_id");
		
		String isJump=request.getParameter("isJump");
		
		String state =request.getParameter("state");
		
		
		Map updateParamMap=new HashMap();
		if(isJump.equals("1")){
			updateParamMap.put("state", "3");
		}else{
			updateParamMap.put("state", state);
		}
		updateParamMap.put("anli_id", anliFolder);
				
		File upload=new File(webroot, "upload");
		File upload_userFolder = new File(upload, userFolder.trim());
		File upload_anliFolder = new File(upload_userFolder, anliFolder.trim());
		
		//文件存放根目录
		if (!upload.exists()) {
			upload.mkdirs();
		}
		//确定用户对应的文件工作目录
		if (!upload_userFolder.exists()) {
			upload_userFolder.mkdirs();
		}
		//确定用户对应的工作的案例的工作目录---资料上传
		if (!upload_anliFolder.exists()) {
			upload_anliFolder.mkdirs();
		}
		/*
		 * 拼装上传文件的路径，web根目录/upload/文件名
		 */
		File newFile = new File(upload_anliFolder, filename);
		if (newFile.exists()) {
			newFile.delete();
		}
		/*
		 * 移动文件
		 */
		// file.ge.getUpload().renameTo(newFile);
		try {
			file.transferTo(newFile);
			// 移动文件成功则存入数据库中
			paramMap.put("wenjian_name", filename.trim());//存放用戶上传的文件名
			paramMap.put("wenjian_id", wenjian_id.trim());
			paramMap.put("fk_userid", userFolder.trim());
			paramMap.put("fk_anli_id", anliFolder.trim());
			paramMap.put("wenjian_lujing", webroot+"upload\\"+userFolder.trim()+"\\"+anliFolder.trim()+"\\"+filename.trim());//拼接路径
			int year=now.get(Calendar.YEAR);
			int moueth=now.get(Calendar.MONTH) + 1;
			int day=now.get(Calendar.DAY_OF_MONTH);
			String wenjian_gengxinshijian=year+"-"+moueth+"-"+day;
			paramMap.put("wenjian_gengxinshijian", wenjian_gengxinshijian);
			uploadZLService.excuteUpload(paramMap);
			resultList=getAllZhiKLiaoService.excuteGetAllZhiKLiaoService(paramMap);
			//修改state
			updateAnLiStateService.excuteUpdateAnLiState(updateParamMap);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 
		mv.addObject("list", resultList);
		
		if(isJump.equals("0")){
			mv.setViewName("soujiziliao");
		}else{
			mv.setViewName("fenxizenduan");
		}
		return mv;
	}

}
