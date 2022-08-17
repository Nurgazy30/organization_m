package kg.nurgazy.organization.management.controller.view;

import kg.nurgazy.organization.management.entity.EmployeeEntity;
import kg.nurgazy.organization.management.service.EmployeeService;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import java.util.List;

@Getter
@Setter
public class EmployeeView {

    private EmployeeService employeeService;

    private List<EmployeeEntity> employeeList;

    @PostConstruct
    public void init() {
        employeeList = employeeService.getAll();
    }




}
