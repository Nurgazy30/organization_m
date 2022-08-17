package kg.nurgazy.organization.management.controller.view;

import kg.nurgazy.organization.management.entity.LegalFormType;
import kg.nurgazy.organization.management.entity.OrganizationEntity;
import kg.nurgazy.organization.management.entity.PropertyFormType;
import kg.nurgazy.organization.management.service.EmployeeService;
import kg.nurgazy.organization.management.service.FileService;
import kg.nurgazy.organization.management.service.OrganizationService;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.PrimeFaces;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.List;

@Getter
@Setter
public class OrganizationEditView {

    private List<OrganizationEntity> organizations;

    private OrganizationEntity selectedOrganization;

    private OrganizationService organizationService;
    private FileService fileService;

    private EmployeeService employeeService;

    @PostConstruct
    public void init(){
        organizations = organizationService.getAll();
    }



    public void deleteOrganization() {

        fileService.deleteFile(selectedOrganization.getId());
        employeeService.deleteAll(selectedOrganization.getId());
        organizationService.deleteById(selectedOrganization.getId());

        organizations = organizationService.getAll();

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Запись удалена"));
        PrimeFaces.current().ajax().update("form:messages", "form:dt-organizations");
    }

    public void saveOrganization() {

        if (selectedOrganization != null) {


            organizationService.update(selectedOrganization);
            organizations = organizationService.getAll();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Данные успешно сохранены"));
            PrimeFaces.current().executeScript("PF('manageOrganizationDialog').hide()");
            PrimeFaces.current().ajax().update("form:messages", "form:dt-organizations");
        }

    }

    public LegalFormType[] getLegalForms() { return LegalFormType.values(); }

    public PropertyFormType[] getPropertyTypes() { return PropertyFormType.values();}



}
