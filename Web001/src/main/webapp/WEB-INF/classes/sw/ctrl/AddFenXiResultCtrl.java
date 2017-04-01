package sw.ctrl;

import java.io.File;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import net.sf.json.JSON;
import sw.service.AddFenXiResultService;
import sw.service.UpdateAnLiStateService;
import swutil.UUIDUtil;

@Controller
@RequestMapping(value="addFenXiResultCtrl")
public class AddFenXiResultCtrl {
	@Resource(name="addFenXiResultService")
	private AddFenXiResultService addFenXiResultService;
	public void setAddFenXiResultService(AddFenXiResultService addFenXiResultService) {
		this.addFenXiResultService = addFenXiResultService;
	}
	//用于更新state
	@Resource(name="updateAnLiStateService")
	private UpdateAnLiStateService updateAnLiStateService;
	
	public void setUpdateAnLiStateService(UpdateAnLiStateService updateAnLiStateService) {
		this.updateAnLiStateService = updateAnLiStateService;
	}
	@RequestMapping(value="addFenXiResult")
	@ResponseBody
	public Map addFenXiResult(@RequestParam("files") MultipartFile[] files,HttpServletRequest req){
		//获取数据
		String zhenduan_id=UUIDUtil.getRandom();
		String linchuang_pinggu	=req.getParameter("linchuang_pinggu");
		String diaocha_wenjuan=req.getParameter("diaocha_wenjuan");
		String goutong_moshi=req.getParameter("goutong_moshi");
		String 	jiating_tupian_lianjie="";
		String	shengtai_tupian_lianjie="";
		String	shehui_tupian_lianjie="";
		String diaocha_miaoshu=req.getParameter("diaocha_miaoshu");
		String fk_userid=req.getParameter("fk_userid");
		String fk_anli_id=req.getParameter("fk_anli_id");
		
		Map updateParamMap=new HashMap();
		updateParamMap.put("state", "4");
		updateParamMap.put("anli_id", fk_anli_id);
		
		Map paramMap=new HashMap();
		paramMap.put("zhenduan_id", zhenduan_id);
		paramMap.put("linchuang_pinggu", linchuang_pinggu);
		paramMap.put("diaocha_wenjuan", diaocha_wenjuan);
		paramMap.put("goutong_moshi", goutong_moshi);
		
		paramMap.put("diaocha_miaoshu", diaocha_miaoshu);
		paramMap.put("fk_userid", fk_userid);
		paramMap.put("fk_anli_id", fk_anli_id);
		
		List paramList=new ArrayList();
		String webroot = req.getServletContext().getRealPath("/");
        // 判断文件是否为空  
	  	String userFolder=req.getParameter("fk_userid");
		
		String anliFolder=req.getParameter("fk_anli_id");
		
		File upload=new File(webroot, "upload");
		File uploadimg=new File(upload, "img");
		File upload_userFolder = new File(uploadimg, userFolder.trim());
		File upload_anliFolder = new File(upload_userFolder, anliFolder.trim());
		//文件存放根目录
		if (!upload.exists()) {
			upload.mkdirs();
		}
		//确定对应用户的img的文件夹是否存在
		if (!uploadimg.exists()) {
			uploadimg.mkdirs();
		}
		//确定用户对应的文件工作目录
		if (!upload_userFolder.exists()) {
			upload_userFolder.mkdirs();
		}
		//确定用户对应的工作的案例的工作目录---资料上传
		if (!upload_anliFolder.exists()) {
			upload_anliFolder.mkdirs();
		}
		//判断file数组不能为空并且长度大于0  
        if(files!=null&&files.length>0){  
            //循环获取file数组中得文件  
            for(int i = 0;i<files.length;i++){  
            	String paramString=null;
            	
                MultipartFile file = files[i];  
                //保存文件  
                String filename = file.getOriginalFilename();// 获取问价名称是传过来的文件名称
        		
        		File newFile = new File(upload_anliFolder, filename);
        	    if (!file.isEmpty()) {  
        	        try {  
        	        	file.transferTo(newFile);
        	        } catch (Exception e) {  
        	            e.printStackTrace(); 
        	            paramString= webroot+"upload\\img\\"+userFolder+"\\"+anliFolder+"\\";
        	        }  
        	    }else{
        	    	paramString= webroot+"upload\\img\\"+userFolder+"\\"+anliFolder+"\\";
        	    }
        	    paramString= webroot+"upload\\img\\"+userFolder+"\\"+anliFolder+"\\"+filename;  
                paramList.add(paramString);
                
                if(i==0){
                	paramMap.put("jiating_tupian_lianjie",paramList.get(0));
                }else if(i==1){
                	paramMap.put("shengtai_tupian_lianjie", paramList.get(1));
                }else{
                	paramMap.put("shehui_tupian_lianjie", paramList.get(2));
                }
            }  
        }  
        try {
			addFenXiResultService.excuteAddFenXiResult(paramMap);
			//用于处理修改state
			updateAnLiStateService.excuteUpdateAnLiState(updateParamMap);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Map resultMap=new HashMap();
        resultMap.put("result", "ajaxSuccess");
        return resultMap;
        // 重定向  
	}
}
