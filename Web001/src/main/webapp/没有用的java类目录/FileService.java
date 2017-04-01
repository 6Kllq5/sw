package sw.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import sw.dao.DaoSupport;

@Service("fileService")
public class FileService {
	@Resource(name="daoSupport")
	private DaoSupport daoSupport;
	public void setDaoSupport(DaoSupport daoSupport) {
		this.daoSupport = daoSupport;
	}
	
	//查找所有
	public List executSelectAllFileService(Map paraMap) throws Exception{
		List resultList=new ArrayList();
		resultList = (List) daoSupport.findForList("", paraMap);
		return resultList;
	}
	
	//添加
	public int executAddFileService(Map paraMap) throws Exception{
		int resultInt=0;
		resultInt = (int) daoSupport.save("sw.insert_file", paraMap);
		return resultInt;
	}
	
	//删除
	public int executDeleteFileService(Map paraMap) throws Exception{
		int resultInt =0;
		resultInt = (int) daoSupport.delete("", paraMap);
		return resultInt;
	}
	
	//修改
	public int executUpdateFileService(Map paraMap) throws Exception{
		int resultInt =0;
		resultInt = (int) daoSupport.delete("", paraMap);
		return resultInt;
	}
	
	
}
