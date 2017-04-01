package sw.service;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import sw.dao.DaoSupport;

@Service("updatePingGuService")
public class UpdatePingGuService {
	@Resource(name="daoSupport")
	private  DaoSupport daoSupport;

	public void setDaoSupport(DaoSupport daoSupport) {
		this.daoSupport = daoSupport;
	}
	
	public int excuteUpdatePingGu(Map paramMap) throws Exception{
		int resultInt=0;
		resultInt=(int) daoSupport.update("sw.update_pingGu", paramMap);
		return resultInt;
	}
}
