package ru.russov.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class OutputNameDto {
    private String firstName;
    private String lastName;
}
