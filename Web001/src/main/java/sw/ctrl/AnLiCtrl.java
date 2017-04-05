package sw.ctrl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sw.ctrl.ctrl_interface.CtrlFun;
import sw.ctrl.ctrl_interface.TableCtrlFun;
import sw.service.AnLiService;
import swutil.RequestTool;
import swutil.UUIDUtil;

@Controller
@RequestMapping("AnLiCtrl")
public class AnLiCtrl implements TableCtrlFun{
	@Resource(name="AnLiService")
	private AnLiService anLiService;
	public void setAnLiService(AnLiService anLiService) {
		this.anLiService = anLiService;
	}
	
	
	@RequestMapping("anLiCtrl")
	@ResponseBody
	public Map anLiCtrl(HttpServletRequest request){
		Map resultMap=new HashMap();
		Map paraMap=new HashMap();
		paraMap=RequestTool.getParameterMap(request);
		String method=paraMap.get("method").toString();
		if(method.equals("selectAll")){
			//处理整数数据
			int offset=Integer.parseInt(paraMap.get("offset").toString());
			int rowInOnePage=Integer.parseInt(paraMap.get("rowInOnePage").toString());
			paraMap.remove("offset");
			paraMap.remove("rowInOnePage");
			paraMap.put("offset", offset);
			paraMap.put("rowInOnePage", rowInOnePage);
			resultMap=selectAll_C(paraMap);
		}else if(method.equals("selectOne")){
			resultMap=selectOne_C(paraMap);
		}else if(method.equals("add")){
			String anli_id=UUIDUtil.getRandom().toString();
			paraMap.put("anli_id", anli_id);
			resultMap=addOne_C(paraMap);
		}else if(method.equals("update")){
			resultMap=updateOne_C(paraMap);
		}else if(method.equals("delete")){
			resultMap=deleteOne_C(paraMap);
		}
		return resultMap;
	}
	
	@Override
	public Map selectOne_C(Map paraMap) {
		// TODO Auto-generated method stub
		Map resultMap=new HashMap();
		Map tempMap=new HashMap();
		try {
			tempMap=anLiService.executSelectOne_S(paraMap);
			resultMap.put("data", tempMap);
			resultMap.put("statu", 1);
			resultMap.put("message", "查询成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultMap;
	}

	@Override
	public Map deleteOne_C(Map paraMap) {
		// TODO Auto-generated method stub
		Map resultMap=new HashMap();
		int resultInt=0;
		try {
			resultInt=anLiService.executDeleteOne_S(paraMap);
			if(resultInt==0){
				resultMap.put("statu",0);
				resultMap.put("message","删除失败");
			}else{
				resultMap.put("statu",1);
				resultMap.put("message","删除陈功");
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
			resultInt=anLiService.executUpdateOne_S(paraMap);
			if(resultInt==0){
				resultMap.put("statu", 0);
				resultMap.put("message", "更新失败");
			}else{
				resultMap.put("statu", 1);
				resultMap.put("message", "更新成功");
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
			resultInt=anLiService.executAddOne_S(paraMap);
			if(resultInt==0){
				resultMap.put("statu",0 );
				resultMap.put("message", "添加失败");
			}else {
				resultMap.put("statu",1 );
				resultMap.put("message", "添加成功");
				resultMap.put("anli_id", paraMap.get("anli_id"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultMap;
	}

	@Override
	public Map selectAll_C(Map paraMap) {
		// TODO Auto-generated method stub
		Map resultMap=new HashMap();
		List data=new ArrayList();
		int total=0;
		int rowInOnePage=Integer.parseInt(paraMap.get("rowInOnePage").toString());
		try {
			data=anLiService.executSelectAll_S(paraMap);
			total=anLiService.executSelectCount_S(paraMap);
			resultMap.put("data", data);
			resultMap.put("total", total);
			resultMap.put("pageCount", total%rowInOnePage==0?(total/10):(total/10+1));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultMap;
	}

	@Override
	public Map deleteBunch_C(List paraList) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
