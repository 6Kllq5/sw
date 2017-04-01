package sw.service;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import sw.dao.DaoSupport;

@Service("addAnLiService")
public class AddAnLiService {
	@Resource(name="daoSupport")
	private DaoSupport daoSupport;
	public void setDaoSupport(DaoSupport daoSupport) {
		this.daoSupport = daoSupport;
	}
	public int  excuteAddAnLi(Map paramMap) throws Exception{
		int resultInt=0;
		daoSupport.save("sw.insert_anli", paramMap);
		return resultInt;
	}
}
