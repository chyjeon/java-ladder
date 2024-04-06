package ladder.model;

import java.util.stream.IntStream;

public class GameResult {
    private NameList nameList;
    private final GameResultList gameResultList;

    public GameResult(NameList nameList, GameResultList gameResultList) {
        this.nameList = nameList;
        this.gameResultList = gameResultList;
    }

    public void ladderGame(Ladder ladder) {
        for (Line line : ladder.getLines()) {
            ladderGameProcess(line);
        }
    }

    private void ladderGameProcess(Line line) {
        IntStream.range(0, line.getPoints().size())
                .forEach(index -> {
                    this.nameList = pointsSwap(line, index);
                });
    }

    private NameList pointsSwap(Line line, int index) {
        boolean point = line.getPoints().get(index);
        if (point) {
            return nameList.swapPoints(index);
        }
        return nameList;
    }


    public String makeResult(String name) {
        if (this.nameList.getNameList().contains(name)) {
            int index = this.nameList.getNameList().indexOf(name);
            return this.gameResultList.getResultList().get(index);
        }
        throw new IllegalArgumentException("입력한 사람은 게임 참여자가 아님");
    }

    public GameResultList getGameResultList() {
        return gameResultList;
    }

    public NameList getNameList() {
        return nameList;
    }
}
