package sw.service;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import sw.dao.DaoSupport;

@Service("deleteAnLiService")
public class DeleteAnLiService {
	@Resource(name="daoSupport")
	private DaoSupport daoSupport;

	public void setDaoSupport(DaoSupport daoSupport) {
		this.daoSupport = daoSupport;
	}
	public int excuteDeleteAnLi(Map paramMap) throws Exception{
		int resultInt=0;
		resultInt=(int)daoSupport.delete("sw.delete_anli", paramMap);
		return resultInt;
	}
}
