package sw.service;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import sw.dao.DaoSupport;

@Service("updateAnLiStateService")
public class UpdateAnLiStateService {
	@Resource(name="daoSupport")
	private DaoSupport daoSupport;
	public void setDaoSupport(DaoSupport daoSupport) {
		this.daoSupport = daoSupport;
	}
	public void excuteUpdateAnLiState(Map paramMap) throws Exception{
		daoSupport.update("sw.update_anLiState", paramMap);
	}
}
