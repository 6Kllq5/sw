package sw.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import sw.dao.DaoSupport;

@Service("getFenXiResultService")
public class GetFenXiResultService {
	@Resource(name="daoSupport")
	private DaoSupport daoSupport;
	public void setDaoSupport(DaoSupport daoSupport) {
		this.daoSupport = daoSupport;
	}
	public List excuteGetFenXiResult(Map paramMap) throws Exception{
		List resultList=new ArrayList();
		resultList=(List) daoSupport.findForList("sw.select_getFenXiResult",paramMap);
		if(resultList.size()>0){
			return resultList;
		}
		return null;
	}
	
}
