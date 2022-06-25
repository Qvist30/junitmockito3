package org.tom.chapter3;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

public class MoneyTest {
	@Test
	public void constructorShouldSetAmountAndCurrency() {
		Money money = new Money(10, "USD");
		assertThat(money.getAmount()).isEqualTo(10);
		assertThat(money.getCurrency()).isEqualTo("USD");
	}
}
