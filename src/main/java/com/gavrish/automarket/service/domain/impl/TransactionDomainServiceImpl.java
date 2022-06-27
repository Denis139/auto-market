package com.gavrish.automarket.service.domain.impl;

import com.gavrish.automarket.mapper.TransactionMapper;
import com.gavrish.automarket.model.dto.request.TransactionAddRequest;
import com.gavrish.automarket.model.dto.view.TransactionView;
import com.gavrish.automarket.model.entity.Transaction;
import com.gavrish.automarket.repository.TransactionRepository;
import com.gavrish.automarket.service.domain.TransactionDomainService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;

@Service
public class TransactionDomainServiceImpl implements TransactionDomainService {

    private TransactionRepository transactionRepository;

    private TransactionMapper transactionMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UUID add(TransactionAddRequest request) {

        var transaction = transactionMapper.from(request);
        transaction = transactionRepository.saveAndFlush(transaction);

        return transaction.getId();
    }

    @Override
    public TransactionView get(UUID id) {
        return transactionMapper.from(findById(id));
    }

    @Override
    public List<TransactionView> getAll() {
        return transactionRepository.findAll()
                .stream()
                .map(o->transactionMapper.from(o))
                .toList();
    }

    @Override
    public Boolean delete(UUID id) {

        var transaction = findById(id);
        transactionRepository.delete(transaction);
        transactionRepository.flush();

        return !transactionRepository.existsById(id);
    }

    private Transaction findById(UUID id) {
        return transactionRepository
                .findById(id)
                .orElseThrow(()-> new EntityNotFoundException(String.format("Transaction with id [%s] not found", id)));
    }
}
