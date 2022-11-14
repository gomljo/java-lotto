package lotto.modelTest;

import lotto.model.RaffleNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

public class RaffleNumberTest {
    private static final String WRONG_QUANTITY_ERROR_MESSAGE="[ERROR] 추첨 번호가 6개가 아닙니다. 프로그램을 종료합니다.";
    private static final String DUPLICATE_ERROR_MESSAGE="[ERROR] 숫자가 중복되었습니다. 프로그램을 종료합니다.";
    private static final String ENTER_WRONG_LETTERS_MESSAGE = "[ERROR] 금액을 잘못 입력하셨습니다. 프로그램을 종료합니다.";
    private  String raffleNumbers;
    @Test
    @DisplayName("추첨 번호 6개가 아니라면 에러를 출력한다.")
    public void createRaffleNumberTest(){
        raffleNumbers = "1,2,3,4,5,6,7";
        assertThatThrownBy(()->new RaffleNumber(raffleNumbers)).isInstanceOf(IllegalArgumentException.class).hasMessageContaining(WRONG_QUANTITY_ERROR_MESSAGE);
    }
    @Test
    @DisplayName("추첨 번호 6개 중 중복이 발생한다면 에러를 출력한다.")
    public void createDuplicatedRaffleNumberTest(){
        raffleNumbers = "1,2,3,4,5,5";
        assertThatThrownBy(()->new RaffleNumber(raffleNumbers)).isInstanceOf(IllegalArgumentException.class).hasMessageContaining(DUPLICATE_ERROR_MESSAGE);
    }
    @Test
    @DisplayName("추첨 번호 6개 중 숫자와 콤마를 제외한 문자가 포함되어 있다면 에러를 출력한다.")
    public void createWrongRaffleNumberTest(){
        raffleNumbers = "1,2,3,[,5,ㄷ";
        assertThatThrownBy(()->new RaffleNumber(raffleNumbers)).isInstanceOf(IllegalArgumentException.class).hasMessageContaining(ENTER_WRONG_LETTERS_MESSAGE);
    }
    @Test
    @DisplayName("정상적인 추첨 번호를 입력한다면 정수형 리스트로 변환한 값을 반환한다.")
    public void createProperRaffleNumberTest(){
        raffleNumbers = "1,2,3,4,5,6";
        List<Integer> expectedRaffleNumbers = List.of(1,2,3,4,5,6);
        assertThat(new RaffleNumber(raffleNumbers).getRaffleNumbers()).isEqualTo(expectedRaffleNumbers);
    }
}
