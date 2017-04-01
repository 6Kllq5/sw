package sw.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import sw.dao.DaoSupport;
import swutil.TurnPage;

@Service(value="getAllEventService")
public class GetAllEventService {
	@Resource(name="daoSupport")
	private DaoSupport daoSupport;
	
	public void setDaoSupport(DaoSupport daoSupport) {
		this.daoSupport = daoSupport;
	}
	public List excuteGetAllEvent(Map paramMap) throws Exception{
		List resultList=new ArrayList();
		//查找对应的记录
		resultList=(List) daoSupport.findForList("sw.select_allEvent", paramMap);
		if(resultList.size()>0){
			return resultList;
		}
		else{
			return null;
		}
	}
}
