package com.exnihilo.services.impl;

import com.exnihilo.domains.dtos.MessageDto;
import com.exnihilo.domains.entities.Message;
import com.exnihilo.domains.mappers.MessageMapper;
import com.exnihilo.repositories.MessageRepository;
import com.exnihilo.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl extends BaseServiceImpl<Message, MessageDto, String> implements MessageService {

    @Autowired
    public MessageServiceImpl(final MessageRepository messageRepository, final MessageMapper messageMapper) {
        super(messageRepository, messageMapper);
    }

}
