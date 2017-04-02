package sw.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import sw.dao.DaoSupport;
import sw.service.service_interface.ServiceFun;


@Service("ChuZhiService")
public class ChuZhiService implements ServiceFun{
	@Resource(name="daoSupport")
	private DaoSupport daoSupport;
	
	public void setDaoSupport(DaoSupport daoSupport) {
		this.daoSupport = daoSupport;
	}
	
	@Override
	public Map executSelectOne_S(Map paraMap) throws Exception {
		// TODO Auto-generated method stub
		Map resultMap=new HashMap();
		resultMap=(Map) daoSupport.findForObject("sw.select_chuzhi", paraMap);
		return resultMap;
	}

	@Override
	public int executUpdateOne_S(Map paraMap) throws Exception {
		// TODO Auto-generated method stub
		int resultInt=0;
		resultInt=(int) daoSupport.update("sw.update_chuzhi", paraMap);
		return resultInt;
	}

	@Override
	public int executAddOne_S(Map paraMap) throws Exception {
		// TODO Auto-generated method stub
		int resultInt=0;
		int updateResultInt=0;
		resultInt=(int) daoSupport.save("sw.insert_chuzhi", paraMap);
		updateResultInt=(int) daoSupport.update("sw.update_state", paraMap);//添加时修稿对应的案例的state
		return resultInt;
	}
}
