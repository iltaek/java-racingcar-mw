public class RacingAnnouncer {
    void announceResult(){
        System.out.println("실행 결과");
        System.out.print(RacingReporter.accumulatedResult);
        System.out.println(RacingResultAnalyzer.winners + "가 최종 우승했습니다.");

    }
}
