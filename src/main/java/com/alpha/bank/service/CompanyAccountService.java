package com.alpha.bank.service;

import com.alpha.bank.model.CompanyAccount;
import com.alpha.bank.repository.CompanyAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyAccountService {

    private final CompanyAccountRepository companyAccountRepository;

    @Autowired
    public CompanyAccountService(CompanyAccountRepository companyAccountRepository) {
        this.companyAccountRepository = companyAccountRepository;
    }

    public List<CompanyAccount> getAllCompanyAccounts() {
        return companyAccountRepository.findAll();
    }

    public CompanyAccount getEntityById(Long id) {
        return companyAccountRepository.findById(id).orElse(null);
    }

    public CompanyAccount saveCompanyAccount(CompanyAccount companyAccount) {
        return companyAccountRepository.save(companyAccount);
    }

    public CompanyAccount updateCompanyAccount(Long id, CompanyAccount updatedEntity) {
        if (companyAccountRepository.existsById(id)) {
            updatedEntity.setId(id);
            return companyAccountRepository.save(updatedEntity);
        } else {
            return null;
        }
    }

    public boolean deleteCompanyAccount(Long id) {
        if (companyAccountRepository.existsById(id)) {
            companyAccountRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}