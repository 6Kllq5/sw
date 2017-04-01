package sw.service;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import sw.dao.DaoSupport;

@Service("updateFenXiResultService")
public class UpdateFenXiResultService {
	@Resource(name="daoSupport")
	private DaoSupport daoSupport;

	public void setDaoSupport(DaoSupport daoSupport) {
		this.daoSupport = daoSupport;
	}
	
	public int excuteUpdateFenXiResult(Map paramMap) throws Exception{
		int resultInt=0;
		resultInt=(int) daoSupport.update("sw.update_fenXi", paramMap);
		return resultInt;
	}
	
}
