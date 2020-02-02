package com.zuniorteam.racingcar.view.console;

import com.zuniorteam.racingcar.dto.GameInput;
import com.zuniorteam.racingcar.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GameInputView {

    private static final String CAR_NAMES_SPLIT_TOKEN = ",";
    private static final Scanner SCANNER = new Scanner(System.in);

    public GameInput listen() {

        final List<String> carNames = Arrays.stream(scanCarNames().split(CAR_NAMES_SPLIT_TOKEN))
                .map(String::trim)
                .collect(Collectors.toList());

        final int numberOfStep = scanNumberOfStep();

        return new GameInput(carNames, numberOfStep);
    }

    private String scanCarNames() {
        System.out.println("자동차 이름들을 입력해주세요. [,] 구분");

        final String carNames = SCANNER.nextLine();

        validateCarNames(carNames);

        return carNames;
    }

    private void validateCarNames(String carNames) {
        if (StringUtils.isEmpty(carNames)) {
            throw new RuntimeException("자동차 이름들이 없습니다");
        }
    }


    private int scanNumberOfStep() {
        System.out.println("시도할 횟수는 몇회인가요?");
        return SCANNER.nextInt();
    }

}
