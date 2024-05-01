package at.common.context.impl;

import at.common.context.AutoTestContext;
import at.common.exception.ContextValueNotFound;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Component
public class CommonAutoTestContext implements AutoTestContext<Object, Object> {
    private final ThreadLocal<Map<Object, Object>> data = ThreadLocal.withInitial(HashMap::new);

    @Override
    public void put(Object key, Object value) {
        data.get().put(key, value);
        log.debug("Saved to context: key - {}, value - {}", key, value);
    }


    @Override
    public void clear() {
        data.get().clear();
        log.info("Context cleared");
    }


    @Override
    public void removeByKey(Object key) {
        Object removedValue = data.get().remove(key);
        log.debug("Removed from context: {}", removedValue);
    }


    @Override
    public boolean containsKey(Object key) {
        return data.get().containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return data.get().containsValue(value);
    }


    @Override
    public Object get(Object key) {
        return data.get().get(key);
    }

    @Override
    public <R> R get(Object key, Class<R> type) {
        return type.cast(get(key));
    }


    @Override
    public Object getNotNull(Object key) {
        return getOptional(get(key)).orElseThrow(() -> new ContextValueNotFound(key));
    }

    @Override
    public <R> R getNotNull(Object key, Class<R> type) {
        return type.cast(getNotNull(key));
    }


    @Override
    public Object getOrDefault(Object key, Object defaultValue) {
        return getOptional(key).orElse(defaultValue);
    }

    @Override
    public <R> R getOrDefault(Object key, R defaultValue, Class<R> type) {
        return getOptional(key, type).orElse(defaultValue);
    }


    @Override
    public Optional<Object> getOptional(Object key) {
        return Optional.ofNullable(get(key));
    }

    @Override
    public <R> Optional<R> getOptional(Object key, Class<R> type) {
        return Optional.ofNullable(get(key)).map(type::cast);
    }
}
