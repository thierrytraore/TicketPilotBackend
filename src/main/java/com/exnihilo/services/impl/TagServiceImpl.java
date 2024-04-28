package com.exnihilo.services.impl;

import com.exnihilo.domains.dtos.TagDto;
import com.exnihilo.domains.entities.Tag;
import com.exnihilo.domains.mappers.TagMapper;
import com.exnihilo.repositories.TagRepository;
import com.exnihilo.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagServiceImpl extends BaseServiceImpl<Tag, TagDto, String> implements TagService {

    @Autowired
    public TagServiceImpl(final TagRepository tagRepository, final TagMapper tagMapper) {
        super(tagRepository, tagMapper);
    }

}
