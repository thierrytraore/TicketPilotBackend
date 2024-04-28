package com.exnihilo.resources;

import com.exnihilo.domains.dtos.TagDto;
import com.exnihilo.resources.impl.BaseResourceImpl;
import com.exnihilo.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tags")
public class TagResource extends BaseResourceImpl<TagDto, String> {

    @Autowired
    public TagResource(final TagService tagService) {
        super(tagService);
    }

}
