package sw.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import sw.dao.DaoSupport;


//服务代码，获取对应的案例对应用户所有的资料
@Service("getAllZhiKLiaoService")
public class GetAllZhiKLiaoService {
	
	
	//获取资源
	@Resource(name="daoSupport")
	private DaoSupport daoSupport;
	public void setDaoSupport(DaoSupport daoSupport) {
		this.daoSupport = daoSupport;
	}
	
	public List excuteGetAllZhiKLiaoService(Map paramMap) throws Exception{
		List resultList=new ArrayList();
		resultList=(List) daoSupport.findForList("sw.select_allZhiLiao", paramMap);
		if(resultList.size()>0){
			return resultList;
		}
		return null;
	
		
		
	}
	
}
