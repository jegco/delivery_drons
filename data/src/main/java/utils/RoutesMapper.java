package utils;

import models.Instruction;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RoutesMapper implements Function<String, List<Instruction>> {

    @Override
    public List<Instruction> apply(String instructions) {
        return Arrays.stream(instructions.split(""))
                .map(Instruction::getInstructionByCode).collect(Collectors.toList());
    }
}