package sw.service;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import sw.dao.DaoSupport;

@Service("fXZDService")
public class FXZDService {
	@Resource(name="daoSupport")
	private DaoSupport daoSupport;

	public void setDaoSupport(DaoSupport daoSupport) {
		this.daoSupport = daoSupport;
	}
	
	public int excuteFxzd(Map paramMap) throws Exception{
		int resultInt=0;
		daoSupport.save("", paramMap);
		return resultInt;
	}
	
}
