package sw.ctrl.ctrl_interface;

import java.util.List;
import java.util.Map;

public interface TableCtrlFun extends CtrlFun{
	/*查询所有*/
	public abstract Map selectAll_C(Map paraMap);
	/*删除多条*/
	public abstract Map deleteBunch_C(List paraList);
	/*删除一条*/
	public abstract Map deleteOne_C(Map paraMap);
}
