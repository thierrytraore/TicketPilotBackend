package com.exnihilo.services.impl;

import com.exnihilo.domains.dtos.AssignmentDto;
import com.exnihilo.domains.entities.Assignment;
import com.exnihilo.domains.mappers.AssignmentMapper;
import com.exnihilo.repositories.AssignmentRepository;
import com.exnihilo.services.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssignmentServiceImpl extends BaseServiceImpl<Assignment, AssignmentDto, String> implements AssignmentService {

    @Autowired
    public AssignmentServiceImpl(final AssignmentRepository assignmentRepository, final AssignmentMapper assignmentMapper) {
        super(assignmentRepository, assignmentMapper);
    }

}
