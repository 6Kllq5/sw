package sw.service;

import java.util.HashMap;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import sw.dao.DaoSupport;

@Service("UserService")
public class UserService {
	@Resource(name="daoSupport")
	private DaoSupport daoSupport;
	public void setDaoSupport(DaoSupport daoSupport) {
		this.daoSupport = daoSupport;
	}
	
	//登录
	public Map login(Map paraMap) throws Exception{
		Map resultMap=new HashMap();
		resultMap=(Map) daoSupport.findForObject("sw.select_user",paraMap);
		return resultMap;
	}
	
	//注册
	public Map registe(Map paraMap) throws Exception{
		Map resultMap=new HashMap();
		resultMap=(Map) daoSupport.findForObject("",paraMap);
		return resultMap;
	}
	
	//批量导入
	public int bunch_registe(List list) throws Exception{
		int resultInt=0;
		resultInt= (int) daoSupport.save("sw.insert_bunchUser",list);
		return resultInt;
	}
}
