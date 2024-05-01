package at.project.cucumber.step;

import at.common.context.impl.CommonAutoTestContext;
import io.cucumber.java.en.Then;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
@RequiredArgsConstructor
public class CommonCucumberSteps {
    private final CommonAutoTestContext context;

    @Then("^Сохраняю в контекст:$")
    public void saveInContext(Map<String, String> params) {
        params.forEach((key, value) -> {
            context.put(key, value);
            log.info("Сохранено в контекст: ключ - {}, значение - {}", key, value);
        });
    }
}
