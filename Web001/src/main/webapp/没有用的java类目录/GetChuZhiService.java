package sw.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import sw.dao.DaoSupport;

@Service("getChuZhiService")
public class GetChuZhiService {

	@Resource(name="daoSupport")
	private DaoSupport daoSupport;

	public void setDaoSupport(DaoSupport daoSupport) {
		this.daoSupport = daoSupport;
	}
	
	public List excuteGetChuZhi(Map paramMap) throws Exception{
		List resultList=new ArrayList();
		resultList=(List) daoSupport.findForList("sw.select_shishi", paramMap);
		if(resultList.size()>0){
			return resultList;
		}
		return null;
	}
	
	
}
