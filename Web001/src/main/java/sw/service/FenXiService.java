package sw.service;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import sw.dao.DaoSupport;
import sw.service.service_interface.TableServiceFun;

@Service("FenXiService")
public class FenXiService implements TableServiceFun{
	@Resource(name="daoSupport")
	private DaoSupport daoSupport;
	public void setDaoSupport(DaoSupport daoSupport) {
		this.daoSupport = daoSupport;
	}
	@Override
	public Map executSelectOne_S(Map paraMap) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int executUpdateOne_S(Map paraMap) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int executAddOne_S(Map paraMap) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public List executSelectAll_S(Map paraMap) throws Exception {
		// TODO Auto-generated method stub
		List resulList=new ArrayList();
		resulList=(List) daoSupport.findForList("", paraMap);
		return resulList;
	}
	@Override
	public int executDeleteBunch_S(List paraList) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int executDeleteOne_S(Map paraMap) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
