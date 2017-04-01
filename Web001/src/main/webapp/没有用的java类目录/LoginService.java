package sw.service;

import java.util.ArrayList;
import java.util.HashMap;


import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import sw.dao.DaoSupport;


@Service("loginService")
public class LoginService {
	//mvc结构部分·
	@Resource(name="daoSupport")
	private DaoSupport daoSupport;
	public void setDaoSupport(DaoSupport daoSupport) {
		this.daoSupport = daoSupport;
	}
	//注意命名规则
	public List executSelectOne(Map paramMap) throws Exception{
		List resultList=new ArrayList();
		resultList=(List) daoSupport.findForList("sw.select_user", paramMap);
		if(resultList.size()>0){
			return resultList;
		}
		return null;
	}
}
