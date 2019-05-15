package com.springtest.ws.ui.controller;

import com.springtest.ws.service.ClassService;
import com.springtest.ws.shared.dto.ClassDto;
import com.springtest.ws.ui.model.request.ClassDetailsRequestModel;
import com.springtest.ws.ui.model.response.ClassRest;
import com.springtest.ws.ui.model.response.OperationStatusModel;
import com.springtest.ws.ui.model.response.RequestOperationName;
import com.springtest.ws.ui.model.response.RequestOperationStatus;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("classes") // http://localhost/:8080/classes
//@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
public class ClassController {

    @Autowired
    ClassService classService;

    @GetMapping(path="/{id}",
                produces = {MediaType.APPLICATION_JSON_VALUE })
    public ClassRest _getClass(@PathVariable int id) {
        ClassRest returnValue = new ClassRest();

        ClassDto classDto = classService.getClassByClassCode(id);
        BeanUtils.copyProperties(classDto, returnValue);

        return returnValue;
    }

    @PostMapping(
            consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }
    )
    public ClassRest _createClass(@RequestBody ClassDetailsRequestModel classDetails) {
        ClassRest returnValue = new ClassRest();

        ClassDto classDto = new ClassDto();
        BeanUtils.copyProperties(classDetails, classDto);

        ClassDto createdClass = classService.createClass(classDto);
        BeanUtils.copyProperties(createdClass, returnValue);

        return returnValue;
    }

    @PutMapping(path="/{id}")
    public ClassRest _updateClass(@PathVariable int id, @RequestBody ClassDetailsRequestModel classDetails) {
        ClassRest returnValue = new ClassRest();

        ClassDto classDto = new ClassDto();
        BeanUtils.copyProperties(classDetails, classDto);

        ClassDto updatedClass = classService.updateClass(id, classDto);
        BeanUtils.copyProperties(updatedClass, returnValue);

        return returnValue;
    }

    @DeleteMapping(path="/{id}")
    public OperationStatusModel _deleteClass(@PathVariable int id) {
        OperationStatusModel returnValue = new OperationStatusModel();

        returnValue.setOperationName(RequestOperationName.DELETE.name());
        returnValue.setOperationResult(RequestOperationStatus.SUCCESS.name());

        classService.deleteClass(id);

        return returnValue;
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE })
    public List<ClassRest> getClasses(@RequestParam(value="page", defaultValue = "0") int page,
                                      @RequestParam(value="limit", defaultValue = "25") int limit) {

        List<ClassRest> returnValue = new ArrayList<>();

        List<ClassDto> classes = classService.getClasses(page, limit);

        for(ClassDto classDto : classes) {
            ClassRest classModel = new ClassRest();
            BeanUtils.copyProperties(classDto, classModel);
            returnValue.add(classModel);
        }
        
        return returnValue;
    }
}
