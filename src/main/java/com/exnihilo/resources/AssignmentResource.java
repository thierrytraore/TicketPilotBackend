package com.exnihilo.resources;

import com.exnihilo.domains.dtos.AssignmentDto;
import com.exnihilo.resources.impl.BaseResourceImpl;
import com.exnihilo.services.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/assignments")
public class AssignmentResource extends BaseResourceImpl<AssignmentDto, String> {

    @Autowired
    public AssignmentResource(final AssignmentService assignmentService) {
        super(assignmentService);
    }

}
