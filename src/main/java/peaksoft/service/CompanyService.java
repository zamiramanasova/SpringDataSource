package peaksoft.service;

import peaksoft.entity.Company;

import java.util.List;

public interface CompanyService {

    List<Company> companyList();

    void saveCompany(Company company);

    Company findId(Long id);

    void update(Company company);

    void delete(Long id);
}
