package com.springtest.ws.ui.controller;

import com.springtest.ws.service.ClauseService;
import com.springtest.ws.shared.dto.ClauseDto;
import com.springtest.ws.ui.model.request.ClauseDetailsRequestModel;
import com.springtest.ws.ui.model.response.ClauseRest;
import com.springtest.ws.ui.model.response.OperationStatusModel;
import com.springtest.ws.ui.model.response.RequestOperationName;
import com.springtest.ws.ui.model.response.RequestOperationStatus;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("clauses") // http://localhost/:8080/clauses
public class ClauseController {

    @Autowired
    ClauseService clauseService;

    
    @GetMapping (path="/{id}")
    public ClauseRest getClause(@PathVariable int id) {
        ClauseRest returnValue = new ClauseRest();

        ClauseDto clauseDto = clauseService.getClauseByClauseCode(id);
        BeanUtils.copyProperties(clauseDto, returnValue);

        return returnValue;
    }

    @PostMapping
    public ClauseRest createClause(@RequestBody ClauseDetailsRequestModel clauseDetails) {
        ClauseRest returnValue = new ClauseRest();

        ClauseDto clauseDto = new ClauseDto();
        BeanUtils.copyProperties(clauseDetails, clauseDto);

        ClauseDto createdClass = clauseService.createClause(clauseDto);
        BeanUtils.copyProperties(createdClass, returnValue);

        return returnValue;
    }

    @PutMapping(path="/{id}")
    public ClauseRest updateClause(@PathVariable int id, @RequestBody ClauseDetailsRequestModel clauseDetails) {
        ClauseRest returnValue = new ClauseRest();

        ClauseDto clauseDto = new ClauseDto();
        BeanUtils.copyProperties(clauseDetails, clauseDto);

        ClauseDto updatedClause = clauseService.updtateClause(id, clauseDto);
        BeanUtils.copyProperties(updatedClause, returnValue);

        return returnValue;
    }

    @DeleteMapping(path="/{id}")
    public OperationStatusModel deleteClause(@PathVariable int id) {
        OperationStatusModel returnValue = new OperationStatusModel();

        returnValue.setOperationName(RequestOperationName.DELETE.name());
        returnValue.setOperationResult(RequestOperationStatus.SUCCESS.name());

        clauseService.deleteClause(id);

        return returnValue;
    }

    @GetMapping
    public List<ClauseRest> getClasses(@RequestParam(value="page", defaultValue = "0") int page,
                                      @RequestParam(value="limit", defaultValue = "2000") int limit) {

        List<ClauseRest> returnValue = new ArrayList<>();

        List<ClauseDto> clauses = clauseService.getClauses(page, limit);

        for(ClauseDto clauseDto : clauses) {
            ClauseRest clauseModel = new ClauseRest();
            BeanUtils.copyProperties(clauseDto, clauseModel);
            returnValue.add(clauseModel);
        }

        return returnValue;
    }
}
