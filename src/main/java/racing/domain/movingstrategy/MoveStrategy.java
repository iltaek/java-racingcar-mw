package racing.domain.movingstrategy;

@FunctionalInterface
public interface MoveStrategy {
    boolean canIMove();
}
