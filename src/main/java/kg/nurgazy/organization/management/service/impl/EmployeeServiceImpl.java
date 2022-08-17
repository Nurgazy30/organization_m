package kg.nurgazy.organization.management.service.impl;

import kg.nurgazy.organization.management.entity.EmployeeEntity;
import kg.nurgazy.organization.management.repository.EmployeeDAO;
import kg.nurgazy.organization.management.service.EmployeeService;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDAO;

    @Override
    public EmployeeEntity getById(Long id) {
        return employeeDAO.getByID(id);
    }

    @Override
    public List<EmployeeEntity> getAll() {
        return employeeDAO.getAll();
    }

    @Override
    public void save(EmployeeEntity entity) {
        employeeDAO.saveEmployee(entity);
    }

    @Override
    public void update(EmployeeEntity entity) {
        employeeDAO.updateEmployee(entity);
    }

    @Override
    public void deleteById(Long id) {
        employeeDAO.deleteEmployee(id);
    }

    @Override
    public void deleteAll(Long id) {
        employeeDAO.deleteAll(id);
    }

    public void setEmployeeDAO(EmployeeDAO dao) {
        this.employeeDAO = dao;
    }
}
