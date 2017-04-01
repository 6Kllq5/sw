package sw.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import sw.dao.DaoSupport;
import sw.service.service_interface.ServiceFun;

@Service("JiHuaService")
public class JiHuaService implements ServiceFun{

	@Resource(name="daoSupport")
	private DaoSupport daoSupport;
	public void setDaoSupport(DaoSupport daoSupport) {
		this.daoSupport = daoSupport;
	}

	@Override
	public Map executSelectOne_S(Map paraMap) throws Exception {
		// TODO Auto-generated method stub
		Map resultMap=new HashMap();
		resultMap=(Map) daoSupport.findForObject("sw.select_jiHua", paraMap);
		return resultMap;
	}

	@Override
	public int executUpdateOne_S(Map paraMap) throws Exception {
		// TODO Auto-generated method stub
		int resultInt=0;
		resultInt=(int) daoSupport.update("sw.update_jiHua", paraMap);
		return resultInt;
	}

	@Override
	public int executAddOne_S(Map paraMap) throws Exception {
		int resultInt=0;
		// TODO Auto-generated method stub
		resultInt=(int) daoSupport.save("sw.insert_jihua", paraMap);
		return resultInt;
	}
}
