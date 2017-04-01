package sw.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import sw.dao.DaoSupport;
import swutil.TurnPage;

@Service(value="getAllAnLiService")
public class GetAllAnLiService {
	@Resource(name="daoSupport")
	private DaoSupport daoSupport;
	public void setDaoSupport(DaoSupport daoSupport) {
		this.daoSupport = daoSupport;
	}
	public Map excuteGetAllAnLi(Map paraMap) throws Exception{
		//查找对应的记录
		Map resultMap=new HashMap();
		List resultList=(List) daoSupport.findForList("sw.select_allAnLi", paraMap);
		int count=(int) daoSupport.findForObject("sw.select_anLiNum", paraMap);
		int pageCount=0;
		//转为页数
		int rowInOnePage=(int) paraMap.get("rowInOnePage");
		
		if(count%rowInOnePage==0){
			pageCount=count/rowInOnePage;
		}else{
			pageCount=count/rowInOnePage+1;
		}
		resultMap.put("data", resultList);
		resultMap.put("total", count);
		resultMap.put("pageCount",pageCount);
		return resultMap;
	}
}
