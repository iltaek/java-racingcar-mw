구현할 기능 목록
- Main(Scanner) : 사용자 입력 받기(자동차 이름, 경기 횟수)
- UserInputValidator : 사용자 입력 유효성 체크(size, null?, invalid character)
 - validateCarNames : 자동차 이름 유효성 체크
 - validateRacingCounts : 게임 횟수 유효성 체크
- CarNameSeparator : 유효성 체크가 끝난 자동차 이름을 리스트로 반환한다.
- RacingCar : 자동차 객체 생성(이름, 이동거리)
  - move : 랜덤하게 이동 혹은 정지
- RacingManager : 자동차들에 경기 주행 명령
- RacingRepoter : 현재 자동차 이동 거리 출력
- RacingWinnerDetector : 레이싱 우승자 선정
- ResultAnnouncer : 레이싱 우승자 출력