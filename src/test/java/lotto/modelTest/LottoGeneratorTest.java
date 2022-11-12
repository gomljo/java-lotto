package lotto.modelTest;

import lotto.model.Buyer;
import lotto.model.LottoGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {
    @Test
    @DisplayName("임의의 로또 번호를 생성하여 6개인지 확인한다.")
    public void createLottoTest(){
        int numberOfLottoNumbers=6;
        List<Integer> lotto = new ArrayList<>();
        LottoGenerator lottoGenerator = new LottoGenerator();
        lotto=lottoGenerator.createLotto();
        assertThat(lotto.size()).isEqualTo(numberOfLottoNumbers);
    }
    @Test
    @DisplayName("구매한 로또의 수만큼 로또를 발행하는지 확인한다.")
    public void generateLottoOfBuyerTest(){
        int numberOfLotto=8;
        List<List<Integer>> generatedLotto = new ArrayList<>();
        LottoGenerator lottoGenerator = new LottoGenerator();
        generatedLotto=lottoGenerator.generateLottoOfBuyer(numberOfLotto);
        assertThat(generatedLotto.size()).isEqualTo(numberOfLotto);
    }
}