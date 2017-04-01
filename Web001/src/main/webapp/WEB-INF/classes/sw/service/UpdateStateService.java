package sw.service;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import sw.dao.DaoSupport;

@Service("updateStateService")
public class UpdateStateService {
	@Resource(name="daoSupport")
	private DaoSupport daoSupport;

	public void setDaoSupport(DaoSupport daoSupport) {
		this.daoSupport = daoSupport;
	}
	
	public int excuteUpdateState(Map paramMap) throws Exception{
		int resultInt=0;
		resultInt=(int) daoSupport.update("update_state",paramMap);
		return resultInt;
	}
}
