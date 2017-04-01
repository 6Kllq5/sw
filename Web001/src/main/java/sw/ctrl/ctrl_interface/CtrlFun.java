package sw.ctrl.ctrl_interface;

import java.util.List;
import java.util.Map;
public interface CtrlFun {
	/*查询一条*/
	public abstract Map selectOne_C(Map paraMap);
	/*修改一条*/
	public abstract Map updateOne_C(Map paraMap);
	/*添加一条*/
	public abstract Map addOne_C(Map paraMap);
}
