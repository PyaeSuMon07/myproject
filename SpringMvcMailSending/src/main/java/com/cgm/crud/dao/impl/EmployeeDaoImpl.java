package com.cgm.crud.dao.impl;

import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.cgm.crud.dao.EmployeeDao;
import com.cgm.crud.entity.Employee;

/**
 *<h2>EmployeeDaoImplClass</h2>
 *<p>
 *Process for DisplayingEmployeeDaoImpl
 *</p>
 *
 * @author PyaeSuMon
 *
 */
@Repository
@Transactional
public class EmployeeDaoImpl implements EmployeeDao {
    /**
     *<h2>hiberneteTemplate</h2>
     *<p>
     *hiberneteTemplate
     *</p> 
     */
    @Autowired
    private HibernateTemplate hiberneteTemplate;

    /**
     *<h2>sessionFactory</h2>
     *<p>
     *sessionFactory
     *</p> 
     */
    @Autowired
    private SessionFactory sessionFactory;

    // add employee
    @Override
    public void addEmployee(Employee emp) {
        sessionFactory.getCurrentSession().save(emp);
    }

    // get all employee
    @Override
    public List<Employee> getAllEmp() {
        return hiberneteTemplate.loadAll(Employee.class);
    }

    // get employee by id
    @Override
    public Employee getEmpById(int id) {
        Employee emp = hiberneteTemplate.get(Employee.class, id);
        return emp;
    }

    // update employee
    @Override
    public void updateEmp(Employee emp) {
        hiberneteTemplate.update(emp);
    }

    // delete employee
    @Override
    public void deleteEmp(int id) {
        hiberneteTemplate.delete(hiberneteTemplate.load(Employee.class, id));
    }

    @SuppressWarnings("rawtypes")
    public Employee findByEmail(String email) {

        String userQuery = "SELECT e FROM Employee e WHERE e.email = :email";
        Query query = this.sessionFactory.getCurrentSession().createQuery(userQuery);
        query.setParameter("email", email);
        Employee emp = (Employee) query.uniqueResult();

        return emp;
    }
}