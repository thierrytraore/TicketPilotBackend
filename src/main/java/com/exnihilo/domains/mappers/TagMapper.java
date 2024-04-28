package com.exnihilo.domains.mappers;

import com.exnihilo.domains.dtos.TagDto;
import com.exnihilo.domains.entities.Tag;
import org.mapstruct.BeanMapping;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface TagMapper extends BaseMapper<Tag, TagDto> {

    Tag toEntity(TagDto tagDto);

    @InheritInverseConfiguration(name = "toEntity")
    TagDto toDto(Tag tag);

    @InheritConfiguration(name = "toEntity")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    Tag partialUpdate(TagDto tagDto, @MappingTarget Tag tag);

}