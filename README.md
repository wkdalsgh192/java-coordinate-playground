# 구현 코드 분석
## Model
- (I) Figure: 도형이 가져야 할 공통 메소드 선언
- (AC) AbstractFigure: 도형이 가져야할 메소드 중 공통된 로직이 적용되는 메소드를 구현 후 나머지를 넘겨주기.
- (C) Line, Triangle, Rectangle: AbstractFigure를 상속받아 미구현 메소드를 오버라이딩
- (C) Point: 좌표 저장 클래스. AbstractFigure을 상속받는 객체라면 모두 해당 클래스를 가진다.
- (C) FigureFactory: Point의 갯수에 따라 Figure의 인스턴스를 생성.
---
## View
- (C) InputView: 입력값을 받는 과정에서 필요한 문자열을 출력 & 입력받은 문자열을 검증 후 FigureFactory에 필요한 파라미터 형태-List of Points-로 변환
  - 입력값 요청
  - 입력값 포맷 검증
  - 문자열로부터 Points 생성
  - 서비스로직으로 파라미터 전달 -- FigureFactory.create()
  - 어떠한 형태로든 View 로직 처리 과정에서 예외 발생 시 처음부터 다시 실행
- (C) OutputView: 모델을 출력 요구사항에 맞게 변환 후 출력
  - 결과값을 좌표평면에 표현
  - 넓이값 출력
---
## Controller
- (C) CoordinateCalculator: 어플리케이션이 입력부터 출력까지의 로직을 순차적으로 실행할 수 있는 메소드 구현
---
## Application
- (C) CoordinateMain: 어플리케이션의 실행 메소드를 가진 유일한 클래스.  

# 추가로 적용해 볼 부분
- Line을 Triangle, Rectangle과 구분하기: 연속된 abstract class 사용 괜찮음?

# 체크할 부분
<b>기억에 의존하기보다 논리에 입각해 설계하고 구현하기</b>

# 레퍼런스
![img.png](img.png)
