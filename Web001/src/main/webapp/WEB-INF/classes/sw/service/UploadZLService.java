package sw.service;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import sw.dao.DaoSupport;

@Service("uploadZLService")
public class UploadZLService {
	@Resource(name="daoSupport")
	private DaoSupport daoSupport;
	
	public void setDaoSupport(DaoSupport daoSupport) {
		this.daoSupport = daoSupport;
	}

	
	//调用操作数据库的方法增加数据
	public int excuteUpload(Map paramMap) throws Exception{
		int a= (int) daoSupport.save("sw.insert_ziliao", paramMap);
		return a;
	}
}
