package sw.ctrl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sw.service.LoginService;
import swutil.PageData;

@Controller
@RequestMapping(value="test")
public class TestCtrl {
	
	
	@RequestMapping("test")
	@ResponseBody
	public void testCtrl(HttpServletRequest req){
		Map p= req.getParameterMap();
		Map returnMap = new HashMap();
		Iterator entries = p.entrySet().iterator();
		Map.Entry entry;
		String name = "";
		while (entries.hasNext()) {
			String value = "";
			entry = (Map.Entry) entries.next();
			name = (String) entry.getKey();
			Object valueObj = entry.getValue();
			if (null == valueObj) {
				value = "";
			} else if (valueObj instanceof String[]) {
				String[] values = (String[]) valueObj;
				for (int i = 0; i < values.length; i++) {
					value += values[i] + ",";
				}
				value = value.substring(0, value.length() - 1);
			} else {
				value = valueObj.toString();
			}
			returnMap.put(name, value.equals("") ? null : value);
		}
	}
	
	
}
