package cn.jiyun.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import cn.jiyun.pojo.City;
import cn.jiyun.pojo.Dept;
import cn.jiyun.pojo.Emp;
import cn.jiyun.pojo.EmpVo;

public interface EmpMapper {

	@Select("select * from dept")
	public List<Dept> queryDept();
	
	@Select("select * from city where fid=#{fid}")
	public List<City> queryCity(Integer fid);
	
	@Select("select * from city")
	public List<City> queryAllCity();
	
	@Select("select * from emp where eid=#{eid}")
	public Emp queryByEid(Integer eid);

	public void deleteEmp(Integer[] eids);

	public List<EmpVo> queryAllEmp(EmpVo ev);
	
	public Object add(Emp e);
}
