package cn.jiyun.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.jiyun.pojo.City;
import cn.jiyun.pojo.Dept;
import cn.jiyun.pojo.Emp;
import cn.jiyun.pojo.EmpVo;
import cn.jiyun.service.EmpService;

@Controller
@RequestMapping("emp")
public class EmpController {
	@Autowired
	private EmpService es;

	
	
	@RequestMapping("queryallemp")
	public String queryAllEmp(@RequestParam(defaultValue="1",required=true)Integer pageNum,Model model,EmpVo ev) {
		PageHelper.startPage(pageNum,2);
		List<EmpVo> el=es.queryAllEmp(ev);
		PageInfo<EmpVo> pageInfo = new PageInfo<EmpVo>(el);
		model.addAttribute("page", pageInfo);
		return "queryemp";
	}
	@RequestMapping("deleteemp")
	public String deleteEmp(Integer[] eids) {
		es.deleteEmp(eids);
		return "redirect:/emp/queryallemp.action";
	}
	@RequestMapping("/toadd")
	public String toAdd(Model model) {
		List<Dept> dl=es.queryDept();
		//我很清楚，fid=0的就是省，所以直接传0进来
		List<City> shengl=es.queryCity(0);
		model.addAttribute("dl", dl);
		model.addAttribute("shengl", shengl);
		return "add";
	}
	@RequestMapping("add")
	public String add(Emp e){
		es.add(e);
		return "redirect:/emp/queryallemp.action";
	}
	
	@ResponseBody
	@RequestMapping("/getchildcity")
	public List<City> getCity(Integer fid) {
		List<City> citylList=es.queryCity(fid);
		return citylList;
	}
	
	
}
