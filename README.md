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
> 차량 별로 주입해야할 연료량이 맞는 지 확인한다.

### 참고 자료
![img.png](img.png)