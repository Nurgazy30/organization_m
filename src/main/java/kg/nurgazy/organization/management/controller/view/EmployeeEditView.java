package kg.nurgazy.organization.management.controller.view;

import kg.nurgazy.organization.management.entity.EmployeeEntity;
import kg.nurgazy.organization.management.service.EmployeeService;
import kg.nurgazy.organization.management.service.OrganizationService;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.PrimeFaces;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class EmployeeEditView {

    private List<EmployeeEntity> employees;

    private EmployeeEntity selectedEmployee;

    private Map<String, Long> organizationMap;

    private String selectedOrganization;

    private EmployeeService employeeService;
    private OrganizationService organizationService;


    @PostConstruct
    public void init(){
        employees = employeeService.getAll();
        organizationMap = new HashMap<>();
        organizationService.getAll()
                .forEach((elem) -> organizationMap.put(elem.getOrganizationName(), elem.getId() ));
    }

    public void saveEmployee(){
        var organization = organizationService.getById(organizationMap.get(selectedOrganization));
        System.out.println(organization.getOrganizationName());
        selectedEmployee.setOrganization(organization);
        employeeService.update(selectedEmployee);
        employees = employeeService.getAll();

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Данные успешно сохранены"));
        PrimeFaces.current().executeScript("PF('manageEmployeeDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages", "form:dt-employees");
    }
    public void deleteEmployee(){
        employeeService.deleteById(selectedEmployee.getId());
        employees = employeeService.getAll();


        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Запись удалена"));
        PrimeFaces.current().ajax().update("form:messages", "form:dt-employees");

    }
}
