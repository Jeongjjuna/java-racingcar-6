package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @DisplayName("더 앞에 있는지 테스트 :Car 객체가 다른 Car 보다 더 앞에 있으면 true, 그렇지 않으면 false 반환")
    @Test
    void isFrontOf() {
        Car car = new Car("홍길동", 5);

        boolean expectedTrue = car.isFrontOf(new Car("성춘향", 3));
        boolean expectedFalse = car.isFrontOf(new Car("성춘향", 6));

        assertAll(
            () -> assertThat(expectedTrue).isTrue(),
            () -> assertThat(expectedFalse).isFalse()
        );
    }

    @DisplayName("move 테스트 : 자동차의 position 이 한칸 전진한다.")
    @Test
    void move() {
        Car car = new Car("홍길동", 5);

        car.move();

        assertThat(car).usingRecursiveComparison()
                .comparingOnlyFields("position")
                .isEqualTo(new Car("홍길동", 6));
    }

    @DisplayName("같은 position 인지 테스트 : 자동차의 position 이 같으면 true, 다르면 false 반환.")
    @Test
    void isSamePosition() {
        Car car = new Car("홍길동", 5);

        assertAll(
                () -> assertThat(car.isSamePosition(5)).isTrue(),
                () -> assertThat(car.isSamePosition(7)).isFalse()
        );

    }

    @DisplayName("같은 position 값을 가지는 Car 인지 테스트 : 자동차의 position 이 같으면 true, 다르면 false 반환.")
    @Test
    void isSamePositionCar() {
        Car car1 = new Car("홍길동", 5);
        Car car2 = new Car("성춘향", 5);
        Car car3 = new Car("이몽룡", 6);

        assertAll(
                () -> assertThat(car1.isSamePosition(car2)).isTrue(),
                () -> assertThat(car1.isSamePosition(car3)).isFalse()
        );

    }

    @DisplayName("create 생성 테스트 : Car 생성 시 이름을 부여할 수 있다.")
    @Test
    void create() {
        Car car = new Car("홍길동");

        assertThat(car).usingRecursiveComparison()
                .comparingOnlyFields("name")
                .isEqualTo(new Car("홍길동"));
    }

    @DisplayName("name 사이즈 5이하 테스트 : 5이하가 아니라면 IllegalArgumentException가 발생한다.")
    @Test
    void name_size_less_than_5() {
        assertThatThrownBy(() -> new Car("홍길동홍길동"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름 크기는 5이하여야 합니다.");
    }
}