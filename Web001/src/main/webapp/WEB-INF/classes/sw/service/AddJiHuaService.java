package sw.service;
import java.util.ArrayList;

import java.util.HashMap;


import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import sw.dao.DaoSupport;

@Service("addJiHuaService")
public class AddJiHuaService {
	@Resource(name="daoSupport")
	private DaoSupport daoSupport;
	public void setDaoSupport(DaoSupport daoSupport) {
		this.daoSupport = daoSupport;
	}
	public int executSave(Map paramMap) throws Exception{
		int resultInt=0;
		resultInt=(int)daoSupport.save("sw.insert_jihua_save", paramMap);
		return resultInt;
	}
}
