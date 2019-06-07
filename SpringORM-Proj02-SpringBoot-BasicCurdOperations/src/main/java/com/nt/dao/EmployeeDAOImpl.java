package com.nt.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.nt.entity.EmployeeHLO;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	private static final String HQL_QUERY_GET_SAL_BY_ID="SELECT sal FROM EmployeeHLO WHERE eno=:id";
	//private static final String UPDATE_EMP_SAL_BY_ID="UPDATE EmployeeHLO SET sal=sal+(sal*(?/100.0f)) where eno=?";
	private static final String UPDATE_EMP_SAL_BY_ID="UPDATE EmployeeHLO SET sal=? WHERE eno=?";
	private static final String DELETE_EMPS_BY_SAL_RANGE="DELETE FROM EmployeeHLO WHERE sal>=:min AND sal<=:max";
	@Autowired
	private HibernateTemplate ht;

	public EmployeeHLO getEmpByEno(int eno)  throws Exception{
		EmployeeHLO hlo=null;
		
		hlo=ht.get(EmployeeHLO.class,eno);
		return hlo;
	}

	@Override
	public int insertEmp(EmployeeHLO hlo) {
		int idVal=0;
		ht.setCheckWriteOperations(false);
		idVal=(Integer) ht.save("EmployeeHLO",hlo);
		return idVal;
	}

	//@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public float getEmpSalById(int eno) {
		List<Float> list=null;
		list=(List<Float>) ht.findByNamedParam(HQL_QUERY_GET_SAL_BY_ID,"id",eno);
	    System.out.println(list);
		return list.get(0);
	}


	/*@SuppressWarnings({ "deprecation" })
	@Override
	public int updateEmpSalById(int eno, float percentage) {
		int count=0;
		count=ht.bulkUpdate(UPDATE_EMP_SAL_BY_ID,percentage,eno);
		return count;
	}*/
	
	@SuppressWarnings("deprecation")
	@Override
	public int updateEmpSalById(int eno, float newSalary) {
		int count=0;
		count=ht.bulkUpdate(UPDATE_EMP_SAL_BY_ID,newSalary,eno);
		return count;
	}

	@Override
	public int deleteEmpsBySalRange(float minSal, float maxSal) {
		int count=0;
		count=ht.execute(new HibernateCallback<Integer>() {

			@Override
			public Integer doInHibernate(Session session) throws HibernateException {
				Transaction tx=null;
				Query query=null;
				int count=0;
				boolean flag=false;
				try {
				 query=session.createQuery(DELETE_EMPS_BY_SAL_RANGE);
				 query.setParameter("min",minSal);
				 query.setParameter("max",maxSal);
				 tx=session.beginTransaction();
				 count=query.executeUpdate();
				 flag=true;
				}catch (HibernateException he) {
					he.printStackTrace();
					flag=false;
					throw he;
				}
				finally {
					if(flag) 
						tx.commit();
					else
						tx.rollback();
				}
				return count;
			}
		});
		return count;
	}

}
