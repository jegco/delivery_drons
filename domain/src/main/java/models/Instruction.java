package models;

public enum Instruction {
    A("A"), D("D"), I("I");

    private final String instructionCode;

    Instruction(String instructionCode) {
        this.instructionCode = instructionCode;
    }

    public static Instruction getInstructionByCode(String code) {
        for (Instruction instruction : values()) {
            if (instruction.getInstructionCode().equalsIgnoreCase(code)) {
                return instruction;
            }
        }
        return null;
    }

    public String getInstructionCode() {
        return instructionCode;
    }
}
