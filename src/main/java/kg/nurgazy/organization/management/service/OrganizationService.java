package kg.nurgazy.organization.management.service;

import kg.nurgazy.organization.management.entity.OrganizationEntity;

import java.util.List;

public interface OrganizationService {

    public OrganizationEntity getById(Long id);

    public List<OrganizationEntity> getAll();

    public Long save(OrganizationEntity entity);

    public void update(OrganizationEntity entity);

    public void deleteById(Long id);
}
