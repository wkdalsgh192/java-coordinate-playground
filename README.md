## [NEXTSTEP 플레이그라운드의 미션 진행 과정](https://github.com/next-step/nextstep-docs/blob/master/playground/README.md)

---
## 학습 효과를 높이기 위해 추천하는 미션 진행 방법

---
1. 피드백 강의 전까지 미션 진행 
> 피드백 강의 전까지 혼자 힘으로 미션 진행. 미션을 진행하면서 하나의 작업이 끝날 때 마다 add, commit
> 예를 들어 다음 숫자 야구 게임의 경우 0, 1, 2단계까지 구현을 완료한 후 push

![mission baseball](https://raw.githubusercontent.com/next-step/nextstep-docs/master/playground/images/mission_baseball.png)

---
2. 피드백 앞 단계까지 미션 구현을 완료한 후 피드백 강의를 학습한다.

---
3. Git 브랜치를 master 또는 main으로 변경한 후 피드백을 반영하기 위한 새로운 브랜치를 생성한 후 처음부터 다시 미션 구현을 도전한다.

```
git branch -a // 모든 로컬 브랜치 확인
git checkout master // 기본 브랜치가 master인 경우
git checkout main // 기본 브랜치가 main인 경우

git checkout -b 브랜치이름
ex) git checkout -b apply-feedback
```
## 연료 주입

---
### 기능 요구 사항
1. 여러 대의 차량이 있다.
2. 차량은 세 종류로 이루어져있다.
3. 고객은 인터넷으로부터 예약할 때 목적지에 대한 이동거리를 입력한다.
4. 입력된 거리에 따라 차량별로 필요한 연료를 주입한다.
5. 차량별로 연비가 다르므로 필요 연료도 다르다.

### 프로그래밍 요구 사항
1. 상속과 추상 메소드를 활용한다.
2. if/else 절을 쓰지 않고 구현한다.

### 테스트 사항
> - 차량 별로 주입해야할 연료량이 맞는 지 확인한다.
> - 차량 별로 이동거리가 주어질 때 필요한 연료량을 파악할 수 있는 보고서 내용을 확인한다.

### 참고 자료
![img.png](img.png)

---

## 좌표계산기(선 길이)

### 서비스 로직
1. 사용자가 점에 대한 좌표 정보를 입력한다.
2. 정상 좌표인 경우, 해당 좌표를 표시한다.
3. 직선 좌표인 경우 두 점 사이 거리를 계산해서 출력한다.

### 기능 요구 사항
- 좌표 정보는 괄호로 둘러 쌓여 있으며 쉼표로 x,y 값을 구분한다.
- 좌표값을 두 개 입력한 경우, 두 점을 잇는 직선으로 가정한다. 두 좌표 사이는 '-' 문자로 구분한다.
- 두 좌표 모두 최대 24까지만 입력할 수 있다.
- 입력 범위를 초과할 경우 에러 문구를 출력하고 다시 입력을 받는다.
- 정상적인 좌표값을 입력한 경우, 해당 좌표에 특수 문자를 표시한다.
- 직선인 경우는 두 점 사이 거리를 계산해서 출력한다.

### 테스트 사항
> - 좌표를 두 개 입력했을 때 두 좌표 사이에 '-' 문자가 들어가야 한다. [(1,2)(3,4) -> (1,2)-(3,4)]
> - 좌표를 입력했을 때 24를 초과하면 에러 문구를 출력한다. [(25,25) -> throws IllegalArgumentException]
> - 직선 좌표의 경우, 두 점 사이 거리를 계산한다. [(10,10)(14,15) -> return 6.403124]

---

## 좌표 계산기(사각형 면적)

### 서비스 로직
1. 사용자가 좌표값을 입력한다.
2. 좌표값이 두 개인 경우, 직선으로 가정한다.
3. 좌표값이 네 개인 경우, 네 점을 연결하는 사각형으로 가정한다.

### 기능 요구 사항
- 두 좌표 모두 0이상 24이하의 정수여야 한다.
- 좌표값과 좌표값 사이는 '-' 문자로 구분한다.
- 직선인 경우는 두 점 사이의 거리를 계산해서 출력한다.
- 사각형인 경우, 반드시 직사각형이여야 한다.
- 직사각형인 경우, 사각형 넓이를 계산해서 출력한다.
- 사각형 면적은 width * height 방식으로 계산할 수 있다.
- Point 객체를 이용해 x,y 좌표를 관리한다.

### 테스트 사항
> - 좌표 하나가 주어졌을 때 Point 객체로 변환한다.
> - 각 좌표의 값 범위는 0 미만이거나 24를 초과할 수 없다. [new Point(25,25) -> throws IllegalArgumentException]
> - 좌표를 입력했을 때, 주어진 좌표의 갯수를 확인하고, 분류한다. [(10,10)-(10,12) -> return LINE]
> - 직선 좌표인 경우, 두 점 사이의 거리를 계산한다. [(10,10)(14,15) -> return 6.403124]
> - 사각형 좌표인 경우, 네 점이 이루는 사각형이 직사각형이여야 한다. [(10,11)-(22,10)-(22,18)-(10,18) -> throw IllegalArgumentException]
> - 직사각형 좌표에인 경우, 사각형의 면적을 계산한다. [(10,10)-(22,10)-(22,18)-(10,18) -> return 96]