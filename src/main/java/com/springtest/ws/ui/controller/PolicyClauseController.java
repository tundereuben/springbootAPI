package com.springtest.ws.ui.controller;

import com.springtest.ws.entity.PolicyClauseEntity;
import com.springtest.ws.io.repositories.PolicyClauseRepository;
import com.springtest.ws.service.PolicyClauseService;
import com.springtest.ws.shared.dto.PolicyClauseDto;
import com.springtest.ws.ui.model.request.PolicyClauseDetailsRequestModel;
import com.springtest.ws.ui.model.response.OperationStatusModel;
import com.springtest.ws.ui.model.response.PolicyClauseRest;
import com.springtest.ws.ui.model.response.RequestOperationName;
import com.springtest.ws.ui.model.response.RequestOperationStatus;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("clauses") // http://localhost/:8080/clauses
public class PolicyClauseController {

    @Autowired
    PolicyClauseService policyClauseService;
    PolicyClauseRepository policyClauseRepository;

    
    @GetMapping (path="/{id}")
    public PolicyClauseRest getClause(@PathVariable int id) {
        PolicyClauseRest returnValue = new PolicyClauseRest();

        PolicyClauseDto policyClauseDto = policyClauseService.getClauseByClauseCode(id);
        BeanUtils.copyProperties(policyClauseDto, returnValue);

        return returnValue;
    }

    @PostMapping
    public PolicyClauseRest createClause(@RequestBody PolicyClauseDetailsRequestModel clauseDetails) {
        PolicyClauseRest returnValue = new PolicyClauseRest();

        PolicyClauseDto policyClauseDto = new PolicyClauseDto();
        BeanUtils.copyProperties(clauseDetails, policyClauseDto);

        PolicyClauseDto createdClass = policyClauseService.createClause(policyClauseDto);
        BeanUtils.copyProperties(createdClass, returnValue);

        return returnValue;
    }

    @PutMapping(path="/{id}")
    public PolicyClauseRest updateClause(@PathVariable int id, @RequestBody PolicyClauseDetailsRequestModel clauseDetails) {
        PolicyClauseRest returnValue = new PolicyClauseRest();

        PolicyClauseDto policyClauseDto = new PolicyClauseDto();
        BeanUtils.copyProperties(clauseDetails, policyClauseDto);

        PolicyClauseDto updatedClause = policyClauseService.updateClause(id, policyClauseDto);
        BeanUtils.copyProperties(updatedClause, returnValue);

        return returnValue;
    }

    @DeleteMapping(path="/{id}")
    public OperationStatusModel deleteClause(@PathVariable int id) {
        OperationStatusModel returnValue = new OperationStatusModel();

        returnValue.setOperationName(RequestOperationName.DELETE.name());
        returnValue.setOperationResult(RequestOperationStatus.SUCCESS.name());

        policyClauseService.deleteClause(id);

        return returnValue;
    }

    @GetMapping
    public List<PolicyClauseRest> getClauses(@RequestParam(value="page", defaultValue = "0") int page,
                                             @RequestParam(value="limit", defaultValue = "25") int limit) {

        List<PolicyClauseRest> returnValue = new ArrayList<>();

        List<PolicyClauseDto> clauses = policyClauseService.getClauses(page, limit);

        for(PolicyClauseDto policyClauseDto : clauses) {
            PolicyClauseRest clauseModel = new PolicyClauseRest();
            BeanUtils.copyProperties(policyClauseDto, clauseModel);
            returnValue.add(clauseModel);
        }

        return returnValue;
    }

    @GetMapping(path="polCode")

    public List<PolicyClauseEntity> getClausesByPolicyCode(@RequestParam(value = "polCode") final int clsPolCode){
        
      return policyClauseService.getPolicyClauses(clsPolCode);
    }

    @GetMapping(path="sclCode")

    public List<PolicyClauseEntity> getClausesBySclCode(@RequestParam(value = "sclCode") final int clsSclCode){

        return policyClauseService.getPolicyClausesBySclCode(clsSclCode);
    }

}
