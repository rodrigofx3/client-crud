package com.example.clientcrud.services;

import com.example.clientcrud.dto.ClientDTO;
import com.example.clientcrud.entities.Client;
import com.example.clientcrud.repositories.ClientRepository;
import com.example.clientcrud.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    public ClientDTO findById(Long id) {
        Client entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resource with ID " + id + " not found."));
        return new ClientDTO(entity);
    }

}