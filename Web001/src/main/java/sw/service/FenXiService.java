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

@Service("FenXiService")
public class FenXiService implements ServiceFun{
	@Resource(name="daoSupport")
	private DaoSupport daoSupport;
	public void setDaoSupport(DaoSupport daoSupport) {
		this.daoSupport = daoSupport;
	}
	
	@Override
	public Map executSelectOne_S(Map paraMap) throws Exception {
		// TODO Auto-generated method stub
		Map reusltMap=new HashMap();
		reusltMap=(Map)daoSupport.findForObject("sw.select_fenXiResult", paraMap);
		return reusltMap;
	}
	
	@Override
	public int executUpdateOne_S(Map paraMap) throws Exception {
		// TODO Auto-generated method stub
		int resultInt=0;
		resultInt= (int) daoSupport.update("sw.update_fenXiResult", paraMap);
		return resultInt;
	}
	
	@Override
	public int executAddOne_S(Map paraMap) throws Exception {
		// TODO Auto-generated method stub
		int resultInt=0;
		int updateResultInt=0;
		resultInt=(int) daoSupport.save("sw.select_getFenXiResult", paraMap);
		updateResultInt=(int) daoSupport.update("sw.update_state", paraMap);//添加时修稿对应的案例的state
		if((resultInt+updateResultInt)!=2){
			//出现问题就要回滚
			throw new Exception();
		}
		return resultInt+updateResultInt;
	}
	
}
