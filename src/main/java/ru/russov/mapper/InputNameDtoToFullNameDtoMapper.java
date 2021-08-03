package ru.russov.mapper;

import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import net.rakugakibox.spring.boot.orika.OrikaMapperFactoryConfigurer;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import ru.russov.dto.FullNameDto;
import ru.russov.dto.InputNameDto;

import java.util.Arrays;

@Component
public class InputNameDtoToFullNameDtoMapper implements OrikaMapperFactoryConfigurer {

    @Override
    public void configure(MapperFactory factory) {
        factory
                .classMap(InputNameDto.class, FullNameDto.class)
                .byDefault()
                .customize(new CustomMapper<InputNameDto, FullNameDto>() {
                    @Override
                    public void mapAtoB(InputNameDto inputNameDto, FullNameDto fullNameDto, MappingContext context) {
                        fullNameDto.setFullName(StringUtils.join(
                                Arrays.asList(inputNameDto.getFirstName(), inputNameDto.getLastName()),
                                " ")
                        );
                    }
                })
                .register();
    }
}
