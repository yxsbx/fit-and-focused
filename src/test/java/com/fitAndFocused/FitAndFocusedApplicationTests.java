package com.fitAndFocused;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class FitAndFocusedApplicationTests {

	@Test
	void contextLoads() {
	}

}
