package kg.nurgazy.organization.management.controller.validator;

import kg.nurgazy.organization.management.service.OrganizationService;
import lombok.Setter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class LicenseValidator implements Validator {

    @Setter
    private OrganizationService organizationService;


    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {

        var isUnique = organizationService.getAll()
                .stream()
                .noneMatch(elem -> elem.getLicenseNumber().equals(value.toString()));

        if (!isUnique) {
            var msg = new FacesMessage("Данный лицензионный номер занят!");
            throw new ValidatorException(msg);
        }
    }
}
