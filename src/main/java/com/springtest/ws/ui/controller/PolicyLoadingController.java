package com.springtest.ws.ui.controller;

import com.springtest.ws.entity.PolicyLoadingEntity;
import com.springtest.ws.service.PolicyLoadingService;
import com.springtest.ws.shared.dto.PolicyLoadingDto;
import com.springtest.ws.ui.model.request.PolicyLoadingDetailsRequestModel;
import com.springtest.ws.ui.model.response.OperationStatusModel;
import com.springtest.ws.ui.model.response.PolicyLoadingRest;
import com.springtest.ws.ui.model.response.RequestOperationName;
import com.springtest.ws.ui.model.response.RequestOperationStatus;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("loadings") // http://localhost/:8080/loadings
public class PolicyLoadingController {

    @Autowired
    PolicyLoadingService policyLoadingService;

    @GetMapping(path="/{id}")
    public PolicyLoadingRest getLoading(@PathVariable int id){
        PolicyLoadingRest returnValue = new PolicyLoadingRest();

        PolicyLoadingDto policyLoadingDto = policyLoadingService.getLoadingByLoadingCode(id);
        BeanUtils.copyProperties(policyLoadingDto, returnValue);

        return returnValue;
    }

    @PostMapping()
    public PolicyLoadingRest createLoading(@RequestBody PolicyLoadingDetailsRequestModel loadingDetails) {
        PolicyLoadingRest returnValue = new PolicyLoadingRest();

        PolicyLoadingDto policyLoadingDto = new PolicyLoadingDto();
        BeanUtils.copyProperties(loadingDetails, policyLoadingDto);

        PolicyLoadingDto createdLoading = policyLoadingService.createLoading(policyLoadingDto);
        BeanUtils.copyProperties(createdLoading, returnValue);

        return returnValue;
    }

    @PutMapping(path="/{id}")
    public PolicyLoadingRest updateLoading(@PathVariable int id, @RequestBody PolicyLoadingDetailsRequestModel loadingDetails) {
        PolicyLoadingRest returnValue = new PolicyLoadingRest();

        PolicyLoadingDto policyLoadingDto = new PolicyLoadingDto();
        BeanUtils.copyProperties(loadingDetails, policyLoadingDto);

        PolicyLoadingDto updatedLoading = policyLoadingService.updateLoading(id, policyLoadingDto);
        BeanUtils.copyProperties(updatedLoading, returnValue);

        return returnValue;
    }

    @DeleteMapping(path="/{id}")
    public OperationStatusModel deleteLoading(@PathVariable int id) {
        OperationStatusModel returnValue = new OperationStatusModel();

        returnValue.setOperationName(RequestOperationName.DELETE.name());
        returnValue.setOperationResult(RequestOperationStatus.SUCCESS.name());

        policyLoadingService.deleteLoading(id);

        return returnValue;
    }

    @GetMapping()
    public List<PolicyLoadingRest> getLoadings(@RequestParam(value="page", defaultValue = "0") int page,
                                                 @RequestParam(value="limit", defaultValue = "25") int limit) {

        List<PolicyLoadingRest> returnValue = new ArrayList<>();

        List<PolicyLoadingDto> loadings = policyLoadingService.getLoadings(page, limit);

        for(PolicyLoadingDto policyLoadingDto : loadings) {
            PolicyLoadingRest loadingModel = new PolicyLoadingRest();
            BeanUtils.copyProperties(policyLoadingDto, loadingModel);
            returnValue.add(loadingModel);
        }

        return returnValue;
    }

    @GetMapping(path="polCode")
    public List<PolicyLoadingEntity> getLoadingsByPolicyCode(@RequestParam(value = "polCode") final int loadPolCode){

        return policyLoadingService.getPolicyLoadings(loadPolCode);
    }

    @GetMapping(path="sclCode")
    public List<PolicyLoadingEntity> getLoadingsBySubclassCode(@RequestParam(value = "sclCode") final int loadSclCode){

        return policyLoadingService.getPolicyLoadingsBySubclassCode(loadSclCode);
    }
}
