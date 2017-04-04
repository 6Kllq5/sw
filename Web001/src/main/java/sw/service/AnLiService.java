package sw.service;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import sw.dao.DaoSupport;
import sw.service.service_interface.ServiceFun;
import sw.service.service_interface.TableServiceFun;

@Service("AnLiService")
public class AnLiService implements TableServiceFun{
	
	@Resource(name="daoSupport")
	private DaoSupport daoSupport;

	public void setDaoSupport(DaoSupport daoSupport) {
		this.daoSupport = daoSupport;
	}

	@Override
	public Map executSelectOne_S(Map paraMap)  throws Exception {
		// TODO Auto-generated method stub
		Map resultMap=new HashMap<>();
		resultMap=(Map) daoSupport.findForObject("sw.select_anli",paraMap);
		return resultMap;
	}

	@Override
	public int executUpdateOne_S(Map paraMap) throws Exception {
		int resultInt=0;
		resultInt=(int) daoSupport.update("sw.update_anLi", paraMap);
		return resultInt;
	}

	@Override
	public int executAddOne_S(Map paraMap)  throws Exception{
		// TODO Auto-generated method stub
		int resultInt=0;
		resultInt=(int) daoSupport.save("sw.insert_anli", paraMap);
		return resultInt;
	}
	
	@Override
	public List executSelectAll_S(Map paraMap) throws Exception {
		// TODO Auto-generated method stub
		List resultList=new ArrayList();
		resultList=(List) daoSupport.findForList("sw.select_allAnLi", paraMap);
		return resultList;
	}

	@Override
	public int executDeleteBunch_S(List paraList)  throws Exception{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int executDeleteOne_S(Map paraMap) throws Exception {
		// TODO Auto-generated method stub
		int resultInt=0;
		resultInt=(int) daoSupport.delete("sw.delete_anli", paraMap);
		return resultInt;
	}
	
	public int executSelectCount_S(Map paraMap) throws Exception{
		int resultInt = 0;
		resultInt=(int) daoSupport.findForObject("sw.select_anLiNum", paraMap);
		return resultInt;
	}
	
}
