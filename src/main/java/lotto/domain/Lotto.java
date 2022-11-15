package lotto.domain;

import java.util.*;
import java.util.stream.Stream;

public class Lotto {
    private static final int PROPER_QUANTITY = 6;
    private static final String DUPLICATE_ERROR_MESSAGE = "[ERROR] 숫자가 중복되었습니다. 프로그램을 종료합니다.";
    private static final String WRONG_QUANTITY_ERROR_MESSAGE = "[ERROR] 로또 번호의 수가 6개가 아닙니다. 프로그램을 종료합니다.";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateProperQuantity(numbers);
        validateDuplicatedNumbers(numbers);
        this.numbers = numbers;
    }

    private void validateProperQuantity(List<Integer> numbers) {
        if (numbers.size() != PROPER_QUANTITY) {
            System.out.println(WRONG_QUANTITY_ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicatedNumbers(List<Integer> numbers) {
        int numberOfUniqueNumbers;
        Stream<Integer> lottoNumbers = numbers.stream();
        numberOfUniqueNumbers = (int) lottoNumbers.distinct().count();
        if (numberOfUniqueNumbers != PROPER_QUANTITY) {
            System.out.println(DUPLICATE_ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }
    }

    public boolean has(int number) {
        return numbers.contains(number);
    }

    public List<Integer> getLotto() {
        return Collections.unmodifiableList(numbers);
    }
}