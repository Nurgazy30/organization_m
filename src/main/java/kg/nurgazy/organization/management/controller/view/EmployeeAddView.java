package kg.nurgazy.organization.management.controller.view;

import kg.nurgazy.organization.management.entity.EmployeeEntity;
import kg.nurgazy.organization.management.service.EmployeeService;
import kg.nurgazy.organization.management.service.OrganizationService;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.HashMap;
import java.util.Map;


@Getter
@Setter
public class EmployeeAddView {

    private EmployeeService employeeService;
    private OrganizationService organizationService;
    private Map<String, Long> organizationMap;

    private String selectedOrganization;

    private EmployeeEntity employee;

    @PostConstruct
    public void init() {
        employee = new EmployeeEntity();
        organizationMap = new HashMap<String, Long>();
        organizationService.getAll().forEach(elem -> organizationMap.put(elem.getOrganizationName(), elem.getId()));
    }


    public void formHandle() {
        employee.setOrganization(
                organizationService.getById(organizationMap.get(selectedOrganization))
        );
        employeeService.save(employee);
        employee = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Данные успешно сохранены"));
    }



}
