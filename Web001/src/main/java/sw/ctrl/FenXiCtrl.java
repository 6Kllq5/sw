package sw.ctrl;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import sw.ctrl.ctrl_interface.CtrlFun;
import sw.service.FenXiService;
import swutil.FileUtil;
import swutil.RequestTool;
import swutil.UUIDUtil;
@Controller
@RequestMapping("FenXiCtrl")
public class FenXiCtrl implements CtrlFun{
	@Resource(name="FenXiService")
	private FenXiService fenXiService;
	public void setFenXiService(FenXiService fenXiService) {
		this.fenXiService = fenXiService;
	}
	@RequestMapping(value="fenXiCtrl")
	@ResponseBody
	public Map fenXiCtrl(HttpServletRequest request){
		Map paraMap = new HashMap();
		Map resultMap=new HashMap();
		paraMap=RequestTool.getParameterMap(request);
		String method=(String) paraMap.get("method");
		if(method.equals("select")){
			
			resultMap=selectOne_C(paraMap);
		}else if(method.equals("add")){
			String zhenduan_id=UUIDUtil.getRandom().toString();
			paraMap.put("zhenduan_id", zhenduan_id);
			resultMap=addOne_C(paraMap);
		}else if(method.equals("update")){
			resultMap=updateOne_C(paraMap);
		}
		return resultMap;
	}
	
	//点击上传图片--前台使用ajax提交上传请求
	@RequestMapping("uploadImg")
	@ResponseBody
	public Map uploadImg(@RequestParam(value = "file", required = false) MultipartFile file,
			HttpServletRequest request){
		Map resultMap=new HashMap();
		String filePath = FileUtil.uploadImg(file, request);//回传前台进行缓存数据
		return resultMap;
	}
	
	@Override
	public Map selectOne_C(Map paraMap) {
		// TODO Auto-generated method stub
		Map resultMap=new HashMap();
		Map tempMap=new  HashMap();
		try {
			tempMap=fenXiService.executSelectOne_S(paraMap);
			if(tempMap==null||tempMap.size()==0){
				resultMap.put("data", null);
				resultMap.put("statu", 0);
				resultMap.put("message", "查询失败");
			}else{
				resultMap.put("data", tempMap);
				resultMap.put("statu", 1);
				resultMap.put("message", "查询成功");
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
		try {
			resultInt=fenXiService.executUpdateOne_S(paraMap);
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

	@Override
	public Map addOne_C(Map paraMap) {
		// TODO Auto-generated method stub
		Map resultMap=new HashMap();
		int resultInt=0;
		try {
			resultInt=fenXiService.executAddOne_S(paraMap);
			if(resultInt==0){
				resultMap.put("statu", 0);
				resultMap.put("message", "添加失败");
			}else{
				resultMap.put("statu", 1);
				resultMap.put("message", "添加成功");
				resultMap.put("zhenduan_id", paraMap.get("paraMap"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultMap;
	}
}
