package org.tom.chapter3;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MoneyOneParamAnnotationTest {

	@ParameterizedTest
	@ValueSource(ints = { 10, 15, 50 })
	public void constructorShouldSetAmountAndCurrency(int amount) {
		Money money = new Money(amount, "USD");
		assertThat(money.getAmount()).isEqualTo(amount);
	}

}
