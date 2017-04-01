package sw.service.service_interface;

import java.util.List;
import java.util.Map;

public interface TableServiceFun extends ServiceFun {
	/*查询所有*/
	public abstract List executSelectAll_S(Map paraMap)  throws Exception;
	/*删除多条*/
	public abstract int executDeleteBunch_S(List paraList)  throws Exception;
	/*删除一条*/
	public abstract int executDeleteOne_S(Map paraMap)  throws Exception;
}
