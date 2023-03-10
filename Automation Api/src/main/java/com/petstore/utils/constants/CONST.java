package com.petstore.utils.constants;

public enum CONST {
    JSON_FILES_DIR("src/main/resources/json_files/");

    private final String text;

    CONST(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
