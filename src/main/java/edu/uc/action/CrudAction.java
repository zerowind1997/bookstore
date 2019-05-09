package edu.uc.action;

/**
 * 处理标准Crud操作的抽象Action类
 * 
 * @author Liuvei
 * @Copyright: Liuvei.com
 *
 */
public abstract class CrudAction extends BaseAction {

	private static final long serialVersionUID = -1794971315031245000L;

	/**
	 * 处理标准Crud操作: 根据不同的oper值，跳转到对应的方法中
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public String crud() {
		String result = "list";
		if (oper == null) {
			oper = "";
		} else {
			oper = oper.trim().toLowerCase();
		}
		result = oper;
		// 根据不同的操作类型,调用不同的处理方法
		switch (oper) {
		case "list":
			result = list(); // 列表页面
			break;
		case "listdeal":
			result = listDeal(); // 列表处理
			break;
		case "insert":
			result = insert(); // 添加页面
			break;
		case "insertdeal":
			result = insertDeal(); // 添加处理
			break;
		case "update":
			result = update(); // 修改页面
			break;
		case "updatedeal":
			result = updateDeal(); // 修改处理
			break;
		case "detail":
			result = detail(); // 详情页面
			break;
		case "detaildeal":
			result = detailDeal(); // 详情处理
			break;
		case "deletedeal":
			result = deleteDeal(); // 删除处理
			break;
		default:
			result = list(); // 列表页面 : 默认
			break;
		}
		result = result.replace("deal", "");
		return result;
	}

	/**
	 * list
	 * @param request
	 * @param response
	 * @return
	 */
	public abstract String list();

	/**
	 * listDeal
	 * @param request
	 * @param response
	 * @return
	 */
	public abstract String listDeal();

	/**
	 * insert
	 * @param request
	 * @param response
	 * @return
	 */
	public abstract String insert();

	/**
	 * insertDeal
	 * @param request
	 * @param response
	 * @return
	 */
	public abstract String insertDeal();

	/**
	 * delete
	 * @param request
	 * @param response
	 * @return
	 */
	public abstract String delete();

	/**
	 * deleteDeal
	 * @param request
	 * @param response
	 * @return
	 */
	public abstract String deleteDeal();

	/**
	 * update
	 * @param request
	 * @param response
	 * @return
	 */
	public abstract String update();

	/**
	 * updateDeal
	 * @param request
	 * @param response
	 * @return
	 */
	public abstract String updateDeal();

	/**
	 * detail
	 * @param request
	 * @param response
	 * @return
	 */
	public abstract String detail();

	/**
	 * detailDeal
	 * @param request
	 * @param response
	 * @return
	 */
	public abstract String detailDeal();

}
