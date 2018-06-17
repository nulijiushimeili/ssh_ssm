package service;

import dao.EmpDao;
import moduels.Emp;

public class EmpService {

    EmpDao empDao = new EmpDao();

    public Emp load(int id){
        return empDao.getEmpById(id);
    }
}
