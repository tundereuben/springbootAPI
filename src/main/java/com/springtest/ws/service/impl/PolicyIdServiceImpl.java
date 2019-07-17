package com.springtest.ws.service.impl;

import com.springtest.ws.entity.PolicyIdEntity;
import com.springtest.ws.io.repositories.PolicyIdRepository;
import com.springtest.ws.service.PolicyIdService;
import com.springtest.ws.shared.dto.PolicyIdDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PolicyIdServiceImpl implements PolicyIdService {

    @Autowired
    PolicyIdRepository policyIdRepository;

    @Override
    public PolicyIdDto createId(PolicyIdDto id) {
        if(policyIdRepository.findByIdCode(id.getIdCode()) != null) throw new RuntimeException("Record already exist");

        PolicyIdEntity policyIdEntity = new PolicyIdEntity();
        BeanUtils.copyProperties(id, policyIdEntity);

        PolicyIdEntity storedIdDetails = policyIdRepository.save(policyIdEntity);

        PolicyIdDto returnValue = new PolicyIdDto();
        BeanUtils.copyProperties(storedIdDetails, returnValue);

        return returnValue;
    }

    @Override
    public PolicyIdDto getIdByIdCode(int idCode) {
        PolicyIdDto returnValue = new PolicyIdDto();
        PolicyIdEntity policyIdEntity = policyIdRepository.findByIdCode(idCode);

        BeanUtils.copyProperties(policyIdEntity, returnValue);

        return returnValue;
    }

    @Override
    public PolicyIdDto updateId(int idCode, PolicyIdDto id) {
        PolicyIdDto returnValue = new PolicyIdDto();
        PolicyIdEntity policyIdEntity = policyIdRepository.findByIdCode(idCode);

        policyIdEntity.setIdName(id.getIdName());
        policyIdEntity.setIdType(id.getIdType());
        policyIdEntity.setIdSclCode(id.getIdSclCode());
        policyIdEntity.setIdPolCode(id.getIdPolCode());

        PolicyIdEntity updateIdDetails = policyIdRepository.save(policyIdEntity);

        BeanUtils.copyProperties(updateIdDetails, returnValue);

        return returnValue;
    }

    @Override
    public void deleteId(int idCode) {
        PolicyIdEntity policyIdEntity = policyIdRepository.findByIdCode(idCode);

        policyIdRepository.delete(policyIdEntity);
    }

    @Override
    public List<PolicyIdDto> getIds(int page, int limit) {
        List<PolicyIdDto> returnValue = new ArrayList<>();

        Pageable pageableRequest = PageRequest.of(page, limit, Sort.by("idCode"));

        Page<PolicyIdEntity> idsPage = policyIdRepository.findAll(pageableRequest);
        List<PolicyIdEntity> ids = idsPage.getContent();

        for(PolicyIdEntity policyIdEntity : ids) {
            PolicyIdDto policyIdDto = new PolicyIdDto();
            BeanUtils.copyProperties(policyIdEntity, policyIdDto);
            returnValue.add(policyIdDto);
        }

        return returnValue;
    }

    @Override
    public List<PolicyIdEntity> getPolicyIds(int idPolCode) {
        List<PolicyIdEntity> returnValue = policyIdRepository.findAllByIdPolCode(idPolCode);
        return returnValue;
    }

    @Override
    public List<PolicyIdEntity> getPolicyIdsBySclCode(int idSclCode) {
        List<PolicyIdEntity> returnValue = policyIdRepository.findAllByIdSclCode(idSclCode);
        return returnValue;
    }
}
