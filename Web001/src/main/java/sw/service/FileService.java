package sw.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import sw.dao.DaoSupport;

import sw.service.service_interface.TableServiceFun;

@Service("FileService")
public class FileService implements TableServiceFun{
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
		int resultInt=0;
		try {
			resultInt=(int) daoSupport.update("sw.update_jianjie", paraMap);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultInt;
	}
	
	@Override
	public int executAddOne_S(Map paraMap) throws Exception {
		// TODO Auto-generated method stub
		int resultInt=0;
		resultInt=(int)daoSupport.save("sw.insert_file", paraMap);
		/*daoSupport.update("", paraMap);//添加时修稿对应的案例的state
*/		return resultInt;
	}

	@Override
	public List executSelectAll_S(Map paraMap) throws Exception {
		// TODO Auto-generated method stub
		List resultList=new ArrayList();
		resultList=(List) daoSupport.findForList("sw.select_allZhiLiao", paraMap);
		return resultList;
	}

	@Override
	public int executDeleteBunch_S(List paraList) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int executDeleteOne_S(Map paraMap) throws Exception {
		// TODO Auto-generated method stub
		int resultInt=0;
		resultInt=(int) daoSupport.delete("sw.delete_file", paraMap);
		
		return resultInt;
	}
	
}
