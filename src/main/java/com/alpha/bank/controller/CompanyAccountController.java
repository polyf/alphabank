package com.alpha.bank.controller;

import com.alpha.bank.model.CompanyAccount;
import com.alpha.bank.service.CompanyAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/company-accounts")
public class CompanyAccountController {

    private final CompanyAccountService companyAccountService;

    @Autowired
    public CompanyAccountController(CompanyAccountService companyAccountService) {
        this.companyAccountService = companyAccountService;
    }

    @GetMapping
    public List<CompanyAccount> getAllEntities() {
        return companyAccountService.getAllCompanyAccounts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyAccount> getEntityById(@PathVariable Long id) {
        CompanyAccount entity = companyAccountService.getEntityById(id);
        if (entity != null) {
            return ResponseEntity.ok(entity);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public CompanyAccount createEntity(@RequestBody CompanyAccount companyAccount) {
        return companyAccountService.saveCompanyAccount(companyAccount);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CompanyAccount> updateEntity(@PathVariable Long id, @RequestBody CompanyAccount updatedEntity) {
        CompanyAccount entity = companyAccountService.updateCompanyAccount(id, updatedEntity);
        if (entity != null) {
            return ResponseEntity.ok(entity);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEntity(@PathVariable Long id) {
        if (companyAccountService.deleteCompanyAccount(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}