package org.tom.chapter5;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PhoneClientTest {
    final static Phone MOBILE_PHONE = mock(Phone.class);
    final static Phone STATIONARY_PHONE = mock(Phone.class);
    PhoneClient client = new PhoneClient();

    @Test
    void shouldReturnTrueIfClientHasMobile() {
        when(MOBILE_PHONE.isMobile()).thenReturn(true);
        client.addPhone(MOBILE_PHONE);
        client.addPhone(STATIONARY_PHONE);
        assertThat(client.hasMobile()).isTrue();
    }

    @Test
    void shouldReturnFalseIfClientHasNoMobile() {
        client.addPhone(STATIONARY_PHONE);
        assertThat(client.hasMobile()).isFalse();
    }
}
