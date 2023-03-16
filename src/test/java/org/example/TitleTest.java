package org.example;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Slf4j
public class TitleTest extends BaseTest {
    
    @Test
    @MethodSource("org.example.UtilTest#dataProvider")
    @Tag("Regression")
    @DisplayName("Validate correct page title")
    void shouldValidateCorrectTitle1() {
        //GIVEN
        driver.get("https://www.booking.com");
        log.info("URL application = https://www.booking.com");
        driver.manage().window().maximize();
        //WHEN
        String actualTitle = driver.getTitle();
        log.info("Actual title is: " + actualTitle);
        log.error("Some error");
        //THEN
        assertThat(actualTitle).isEqualTo("Booking.com | Oficjalna strona | Najlepsze hotele, loty, samochody na wynajem i zakwaterowanie");
    }
}