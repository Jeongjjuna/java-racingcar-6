package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class RandomNumberTest {

    @DisplayName("RandomNumber 범위 0~9 테스트 : 0~9 사이의 숫자가 아니라면 IllegalArgumentException가 발생한다.")
    @Test
    void random_number_range_0_to_9() {
        assertThatThrownBy(() -> new RandomNumber(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("랜덤 생성 숫자는 0~9사이의 숫자여야 합니다.");
    }

    @DisplayName("create 생성 테스트 : RandomNumber 생성 시 특정 숫자를 부여할 수 있다.")
    @Test
    void create() {
        RandomNumber randomNumber = new RandomNumber(5);

        assertThat(randomNumber).usingRecursiveComparison()
                .comparingOnlyFields("number")
                .isEqualTo(new RandomNumber(5));
    }
}