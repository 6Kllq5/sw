package sw.service;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import sw.dao.DaoSupport;

@Service("updateAnLiService")
public class UpdateAnLiService {
	@Resource(name="daoSupport")
	private DaoSupport daoSupport;

	public void setDaoSupport(DaoSupport daoSupport) {
		this.daoSupport = daoSupport;
	}
	
	public void excuteUpdateAnLi(Map paramMap) throws Exception{
		daoSupport.update("sw.update_anLi", paramMap);
	}
}
