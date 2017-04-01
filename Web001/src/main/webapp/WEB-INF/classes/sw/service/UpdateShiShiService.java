package sw.service;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import sw.dao.DaoSupport;

@Service("updateShiShiService")
public class UpdateShiShiService {
	@Resource(name="daoSupport")
	private DaoSupport daoSupport;

	public void setDaoSupport(DaoSupport daoSupport) {
		this.daoSupport = daoSupport;
	}
	
	public int excuteUpdateShiShi(Map paramMap) throws Exception{
		int resultInt=0;
		resultInt=(int) daoSupport.update("sw.update_shishi", paramMap);
		return resultInt;
	}
}
