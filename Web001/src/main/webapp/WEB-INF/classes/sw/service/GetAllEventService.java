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
	public Map excuteGetAllEvent(Map paramMap) throws Exception{
		Map reMap=new HashMap();
		TurnPage turnPage=(TurnPage)paramMap.get("turnPage");
		//查找对应的记录
		List resultList=(List) daoSupport.findForList("sw.select_allEvent", paramMap);
		//查找所有的记录条数
		reMap.put("list", resultList);
		long count=(Long)daoSupport.findForObject("sw.select_eventNum", paramMap);
		turnPage.setTotal(count);
		return reMap;
	}

}
