package com.exnihilo.resources;

import com.exnihilo.domains.dtos.MessageDto;
import com.exnihilo.resources.impl.BaseResourceImpl;
import com.exnihilo.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messages")
public class MessageResource extends BaseResourceImpl<MessageDto, String> {

    @Autowired
    public MessageResource(final MessageService messageService) {
        super(messageService);
    }

}
