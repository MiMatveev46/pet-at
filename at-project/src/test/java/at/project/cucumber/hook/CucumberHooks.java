package at.project.cucumber.hook;

import at.common.context.impl.CommonAutoTestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class CucumberHooks {
    private final CommonAutoTestContext context;

    @Before
    public void logStartTest(Scenario scenario) {
        log.info("Запущен тест {}", scenario.getName());
    }

    @After
    public void clearContext() {
        context.clear();
        log.info("Контекст очищен");
    }
}
