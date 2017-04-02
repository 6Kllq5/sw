package sw.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import sw.dao.DaoSupport;
import sw.service.service_interface.ServiceFun;

@Service("PingGuService")
public class PingGuService implements ServiceFun{
	@Resource(name="daoSupport")
	private DaoSupport daoSupport;
	public void setDaoSupport(DaoSupport daoSupport) {
		this.daoSupport = daoSupport;
	}

	@Override
	public Map executSelectOne_S(Map paraMap) throws Exception {
		// TODO Auto-generated method stub
		Map resultMap=new HashMap();
		resultMap=(Map) daoSupport.findForObject("sw.select_pinggu", paraMap);
		return resultMap;
	}

	@Override
	public int executUpdateOne_S(Map paraMap) throws Exception {
		// TODO Auto-generated method stub
		int resultInt=0;
		resultInt=(int) daoSupport.findForObject("sw.update_pinggu", paraMap);
		return resultInt;
	}

	@Override
	public int executAddOne_S(Map paraMap) throws Exception {
		// TODO Auto-generated method stub
		int resultInt=0;
		resultInt=(int) daoSupport.findForObject("sw.insert_pinggu", paraMap);
		return resultInt;
	}

}
