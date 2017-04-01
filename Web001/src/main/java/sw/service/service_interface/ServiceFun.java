package sw.service.service_interface;

import java.util.Map;

public interface ServiceFun {
	/*查询一条*/
	public abstract Map executSelectOne_S(Map paraMap)  throws Exception;
	/*修改一条*/
	public abstract int executUpdateOne_S(Map paraMap)  throws Exception;
	/*添加一条*/
	public abstract int executAddOne_S(Map paraMap)  throws Exception;
}
