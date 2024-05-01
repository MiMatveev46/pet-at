package at.common.exception;

import lombok.Getter;

public class ContextValueNotFound extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Value by key %s not found in context or null";

    @Getter
    private final Object key;

    public ContextValueNotFound(Object key) {
        super(String.format(MESSAGE_TEMPLATE, key));
        this.key = key;
    }
}
