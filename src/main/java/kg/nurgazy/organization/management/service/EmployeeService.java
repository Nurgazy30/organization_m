package kg.nurgazy.organization.management.service;

import kg.nurgazy.organization.management.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeService {

    EmployeeEntity getById(Long id);

    List<EmployeeEntity> getAll();

    void save(EmployeeEntity entity);

    void update(EmployeeEntity entity);

    void deleteById(Long id);

    void deleteAll(Long id);
}
