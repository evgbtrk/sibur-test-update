package com.sibur.transport.service;

import com.sibur.transport.entity.Provider;
import com.sibur.transport.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProviderService {
    private ProviderRepository providerRepository;

    @Autowired
    public void setProviderRepository(ProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }

    public List<Provider> getAllProviders() {
        return providerRepository.findAll();
    }

    public Provider getProviderById(Long id) throws ChangeSetPersister.NotFoundException {
        return providerRepository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
    }
}
