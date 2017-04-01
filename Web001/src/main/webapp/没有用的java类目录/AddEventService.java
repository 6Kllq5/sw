package sw.service;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import sw.dao.DaoSupport;

@Service("addEventService")
public class AddEventService {
	@Resource(name="daoSupport")
	private DaoSupport daoSupport;

	public void setDaoSupport(DaoSupport daoSupport) {
		this.daoSupport = daoSupport;
	}
	public int excuteAddEvent(Map paramMap) throws Exception{
		int resultInt=0;
		resultInt=(int) daoSupport.save("sw.insert_event", paramMap);
		return resultInt;
	}
}
