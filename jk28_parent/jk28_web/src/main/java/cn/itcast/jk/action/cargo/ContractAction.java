package cn.itcast.jk.action.cargo;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.jk.action.BaseAction;
import cn.itcast.jk.domain.Contract;
import cn.itcast.jk.domain.User;
import cn.itcast.jk.service.ContractService;
import cn.itcast.jk.utils.Page;
/**
 * 
 * @author Administrator
 *
 */
public class ContractAction extends BaseAction implements ModelDriven<Contract> {
	private Contract model = new Contract();
	public Contract getModel() {
		return model;
	}
	
	//分页查询
	private Page page  = new Page();
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	
	
	//注入ContractService
	private ContractService contractService;
	public void setContractService(ContractService contractService) {
		this.contractService = contractService;
	}
	
	/**
	 * 分页查询
	 */
	public String list() throws Exception {
		String hql = "from Contract where 1=1 ";
		
		//如何确定出用户的等级
		User user =  super.getCurUser();
		int degree = user.getUserinfo().getDegree();
		if(degree==4){
			//说明是员工
			hql+=" and createBy='"+user.getId()+"'";
		}else if(degree==3){
			//说明是部门经理，管理本部门
			hql+=" and createDept='"+user.getDept().getId()+"'";
		}else if(degree==2){
			//说明是管理本部门及下属部门？？？？？
			
			
		}else if(degree==1){
			//说明是副总？？？？？
			
			
		}else if(degree==0){
			//说明是总经理
			
		}
		
		contractService.findPage(hql, page, Contract.class, null);
		
		//设置分页的url地址
		page.setUrl("contractAction_list");
		
		//将page对象压入栈顶
		super.push(page);
		
		
		return "list";
	}
	
	/**
	 * 查看
	 *     id=rterytrytrytr
	 * model对象
	 *      id属性：rterytrytrytr
	 */
	public String toview() throws Exception {
		//1.调用业务方法，根据id,得到对象
		Contract dept = contractService.get(Contract.class, model.getId());
		
		//放入栈顶
		super.push(dept);
		
		//3.跳页面
		return "toview";
	}
	
	/**
	 * 进入新增页面
	 */
	public String tocreate() throws Exception {
		//调用业务方法
	
		//跳页面
		return "tocreate";
	}
	
	/**
	 * 保存
	 *     <s:select name="parent.id"
	 *     <input type="text" name="deptName" value=""/>
	 * model对象能接收
	 *      parent 
	 *           id
	 *      deptName
	 */
	public String insert() throws Exception {
		//1.加入细粒度权限控制的数据
		User user = super.getCurUser();
		model.setCreateBy(user.getId());//设置创建者的id
		model.setCreateDept(user.getDept().getId());//设置创建者所在部门的id
		
		//1.调用业务方法，实现保存
		contractService.saveOrUpdate(model);
		//跳页面
		return "alist";
	}
	
	
	/**
	 * 进入修改页面
	 */
	public String toupdate() throws Exception {
		//1.根据id,得到一个对象
		Contract obj = contractService.get(Contract.class, model.getId());
		
		//2.将对象放入值栈中
		super.push(obj);
		
		
		//5.跳页面
		return "toupdate";
	}
	
	/**
	 * 修改
	 */
	public String update() throws Exception {
		//调用业务
		Contract obj = contractService.get(Contract.class, model.getId());//根据id,得到一个数据库中保存的对象
		
		//2.设置修改的属性
		obj.setCustomName(model.getCustomName());
		obj.setPrintStyle(model.getPrintStyle());
		obj.setContractNo(model.getContractNo());
		obj.setOfferor(model.getOfferor());
		obj.setInputBy(model.getInputBy());
		obj.setCheckBy(model.getCheckBy());
		obj.setInspector(model.getInspector());
		obj.setSigningDate(model.getSigningDate());
		obj.setImportNum(model.getImportNum());
		obj.setShipTime(model.getShipTime());
		obj.setTradeTerms(model.getTradeTerms());
		obj.setDeliveryPeriod(model.getDeliveryPeriod());
        obj.setCrequest(model.getCrequest());
        obj.setRemark(model.getRemark());
        
		contractService.saveOrUpdate(obj);
		return "alist";
	}
	
	/**
	 * 删除
	 */
	public String delete() throws Exception {
		String ids[] = model.getId().split(", ");
		
		//调用业务方法，实现批量删除
		contractService.delete(Contract.class, ids);
		
		
		return "alist";
	}
	
	/**
	 * 提交
	 */
	public String submit() throws Exception {
		String ids []  = model.getId().split(", ");
		
		//2.遍历ids,并加载出每个购销合同对象，再修改购销合同的状态
		contractService.changeState(ids, 1);
		return "alist";
	}
	
	/**
	 * 取消
	 */
	public String cancel() throws Exception {
		String ids []  = model.getId().split(", ");
		
		//2.遍历ids,并加载出每个购销合同对象，再修改购销合同的状态
		contractService.changeState(ids, 0);
		return "alist";
	}
	
	/**
	 * 打印
	 */
	public String print() throws Exception {
		//1.根据购销合同的id,得到购销合同对象
		Contract contract = contractService.get(Contract.class, model.getId());
		
		//2.指定path
		String path = ServletActionContext.getServletContext().getRealPath("/");//应用程序的根路径
		
		//3.指定response
		HttpServletResponse response = ServletActionContext.getResponse();
		
		ContractPrint cp = new ContractPrint();
		cp.print(contract, path, response);
		
		return NONE;
	}
}
