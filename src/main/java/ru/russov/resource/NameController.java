package ru.russov.resource;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;
import org.springframework.web.bind.annotation.GetMapping;
import ru.russov.dto.FullNameDto;
import ru.russov.dto.InputNameDto;
import ru.russov.dto.OutputNameDto;

@Slf4j
@RequiredArgsConstructor
@org.springframework.web.bind.annotation.RestController
public class NameController {

    private final MapperFacade facade;

    private static final String name = "Maik";
    private static final String surname = "Vazovski";

    @GetMapping("/getInfo")
    public OutputNameDto getInfo() {
        return facade.map(new InputNameDto(name, surname), OutputNameDto.class);
    }

    @GetMapping("/getFullName")
    public FullNameDto getFullName() {
        return facade.map(new InputNameDto(name, surname), FullNameDto.class);
    }
}
